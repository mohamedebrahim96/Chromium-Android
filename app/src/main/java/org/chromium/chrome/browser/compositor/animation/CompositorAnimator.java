// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.compositor.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.chromium.base.VisibleForTesting;
import org.chromium.chrome.browser.compositor.layouts.ChromeAnimation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * An animator that can be used for animations in the Browser Compositor.
 */
public class CompositorAnimator extends Animator {
    /** The different states that this animator can be in. */
    @IntDef({AnimationState.STARTED, AnimationState.RUNNING, AnimationState.CANCELED,
            AnimationState.ENDED})
    @Retention(RetentionPolicy.SOURCE)
    private @interface AnimationState {
        int STARTED = 0;
        int RUNNING = 1;
        int CANCELED = 2;
        int ENDED = 3;
    }

    /** The {@link CompositorAnimationHandler} running the animation. */
    private final WeakReference<CompositorAnimationHandler> mHandler;

    /** The list of listeners for events through the life of an animation. */
    private final ArrayList<AnimatorListener> mListeners = new ArrayList<>();

    /** The list of frame update listeners for this animation. */
    private final ArrayList<AnimatorUpdateListener> mAnimatorUpdateListeners = new ArrayList<>();

    /**
     * A cached copy of the list of {@link AnimatorUpdateListener}s to prevent allocating a new list
     * every update.
     */
    private final ArrayList<AnimatorUpdateListener> mCachedList = new ArrayList<>();

    /** The time interpolator for the animator. */
    private TimeInterpolator mTimeInterpolator;

    /**
     * The amount of time in ms that has passed since the animation has started. This includes any
     * delay that was set.
     */
    private long mTimeSinceStartMs;

    /**
     * The fraction that the animation is complete. This number is in the range [0, 1] and accounts
     * for the set time interpolator.
     */
    private float mAnimatedFraction;

    /** The value that the animation should start with (ending at {@link #mEndValue}). */
    private float mStartValue;

    /** The value that the animation will transition to (starting at {@link #mStartValue}). */
    private float mEndValue;

    /** The duration of the animation in ms. */
    private long mDurationMs;

    /**
     * The animator's start delay in ms. Once {@link #start()} is called, updates are not sent until
     * this time has passed.
     */
    private long mStartDelayMs;

    /** The current state of the animation. */
    @AnimationState
    private int mAnimationState = AnimationState.ENDED;

    /**
     * Whether the animation ended because of frame updates. This is used to determine if any
     * listeners need to be updated one more time.
     */
    private boolean mDidUpdateToCompletion;

    /**
     * A utility for creating a basic animator.
     * @param handler The {@link CompositorAnimationHandler} responsible for running the animation.
     * @param startValue The starting animation value.
     * @param endValue The end animation value.
     * @param durationMs The duration of the animation in ms.
     * @param listener An update listener if specific actions need to be performed.
     * @return A {@link CompositorAnimator} for the property.
     */
    public static CompositorAnimator ofFloat(CompositorAnimationHandler handler, float startValue,
            float endValue, long durationMs, @Nullable AnimatorUpdateListener listener) {
        CompositorAnimator animator = new CompositorAnimator(handler);
        animator.setValues(startValue, endValue);
        if (listener != null) animator.addUpdateListener(listener);
        animator.setDuration(durationMs);
        return animator;
    }

    /** An interface for listening for frames of an animation. */
    public interface AnimatorUpdateListener {
        /**
         * A notification of the occurrence of another frame of the animation.
         * @param animator The animator that was updated.
         */
        void onAnimationUpdate(CompositorAnimator animator);
    }

    /**
     * Create a new animator for the current context.
     * @param handler The {@link CompositorAnimationHandler} responsible for running the animation.
     */
    public CompositorAnimator(@NonNull CompositorAnimationHandler handler) {
        mHandler = new WeakReference<>(handler);

        // The default interpolator is decelerate; this mimics the existing ChromeAnimation
        // behavior.
        mTimeInterpolator = ChromeAnimation.getDecelerateInterpolator();

        // By default, animate for 0 to 1.
        mStartValue = 0;
        mEndValue = 1;
    }

    /**
     * Push an update to the animation. This should be called while the start delay is active and
     * assumes that the animated object is at the starting position when {@link #start} is called.
     * @param deltaTimeMs The time since the previous frame.
     */
    public void doAnimationFrame(long deltaTimeMs) {
        mTimeSinceStartMs += deltaTimeMs;

        // Clamp to the animator's duration, taking into account the start delay.
        long finalTimeMs = Math.min(mTimeSinceStartMs - mStartDelayMs, mDurationMs);

        // Wait until the start delay has passed.
        if (finalTimeMs < 0) return;

        // In the case where duration is 0, the animation is complete.
        mAnimatedFraction = 1;
        if (mDurationMs > 0) {
            mAnimatedFraction =
                    mTimeInterpolator.getInterpolation(finalTimeMs / (float) mDurationMs);
        }

        // Push update to listeners.
        mCachedList.addAll(mAnimatorUpdateListeners);
        for (int i = 0; i < mCachedList.size(); i++) mCachedList.get(i).onAnimationUpdate(this);
        mCachedList.clear();

        if (finalTimeMs == mDurationMs) {
            mDidUpdateToCompletion = true;
            end();
        }
    }

    /**
     * @return The animated fraction after being passed through the time interpolator, if set.
     */
    @VisibleForTesting
    public float getAnimatedFraction() {
        return mAnimatedFraction;
    }

    /**
     * Add a listener for frame occurrences.
     * @param listener The listener to add.
     */
    public void addUpdateListener(AnimatorUpdateListener listener) {
        mAnimatorUpdateListeners.add(listener);
    }

    /**
     * @param listener The listener to remove.
     */
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        mAnimatorUpdateListeners.remove(listener);
    }

    /**
     * @return Whether or not the animation has ended after being started. If the animation is
     *         started after ending, this value will be reset to true.
     */
    public boolean hasEnded() {
        return mAnimationState == AnimationState.ENDED;
    }

    /**
     * Set the values to animate between.
     * @param start The value to begin the animation with.
     * @param end The value to end the animation at.
     */
    @VisibleForTesting
    public void setValues(float start, float end) {
        mStartValue = start;
        mEndValue = end;
    }

    /**
     * @return The current value between the floats set by {@link #setValues(float, float)}.
     */
    @VisibleForTesting
    public float getAnimatedValue() {
        return mStartValue + (getAnimatedFraction() * (mEndValue - mStartValue));
    }

    @Override
    public void addListener(AnimatorListener listener) {
        mListeners.add(listener);
    }

    @Override
    public void removeListener(AnimatorListener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void removeAllListeners() {
        mListeners.clear();
        mAnimatorUpdateListeners.clear();
    }

    @Override
    public void start() {
        if (mAnimationState != AnimationState.ENDED) return;

        super.start();
        mAnimationState = AnimationState.RUNNING;
        mDidUpdateToCompletion = false;
        CompositorAnimationHandler handler = mHandler.get();
        if (handler != null) handler.registerAndStartAnimator(this);
        mTimeSinceStartMs = 0;

        ArrayList<AnimatorListener> clonedList = (ArrayList<AnimatorListener>) mListeners.clone();
        for (int i = 0; i < clonedList.size(); i++) clonedList.get(i).onAnimationStart(this);
    }

    @Override
    public void cancel() {
        if (mAnimationState == AnimationState.ENDED) return;

        mAnimationState = AnimationState.CANCELED;

        super.cancel();

        ArrayList<AnimatorListener> clonedList = (ArrayList<AnimatorListener>) mListeners.clone();
        for (int i = 0; i < clonedList.size(); i++) clonedList.get(i).onAnimationCancel(this);

        end();
    }

    @Override
    public void end() {
        if (mAnimationState == AnimationState.ENDED) return;

        super.end();
        boolean wasCanceled = mAnimationState == AnimationState.CANCELED;
        mAnimationState = AnimationState.ENDED;

        // If the animation was ended early but not canceled, push one last update to the listeners.
        if (!mDidUpdateToCompletion && !wasCanceled) {
            mAnimatedFraction = 1f;
            ArrayList<AnimatorUpdateListener> clonedList =
                    (ArrayList<AnimatorUpdateListener>) mAnimatorUpdateListeners.clone();
            for (int i = 0; i < clonedList.size(); i++) clonedList.get(i).onAnimationUpdate(this);
        }

        ArrayList<AnimatorListener> clonedList = (ArrayList<AnimatorListener>) mListeners.clone();
        for (int i = 0; i < clonedList.size(); i++) clonedList.get(i).onAnimationEnd(this);
    }

    @Override
    public long getStartDelay() {
        return mStartDelayMs;
    }

    @Override
    public void setStartDelay(long startDelayMs) {
        if (startDelayMs < 0) startDelayMs = 0;
        mStartDelayMs = startDelayMs;
    }

    @Override
    public CompositorAnimator setDuration(long durationMs) {
        if (durationMs < 0) durationMs = 0;
        mDurationMs = durationMs;
        return this;
    }

    @Override
    public long getDuration() {
        return mDurationMs;
    }

    @Override
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        assert timeInterpolator != null;
        mTimeInterpolator = timeInterpolator;
    }

    @Override
    public boolean isRunning() {
        return mAnimationState == AnimationState.RUNNING;
    }
}
