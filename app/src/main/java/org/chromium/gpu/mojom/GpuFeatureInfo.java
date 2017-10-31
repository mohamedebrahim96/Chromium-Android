
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/gpu_feature_info.mojom
//

package org.chromium.gpu.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class GpuFeatureInfo extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int[] statusValues;
    public int[] enabledGpuDriverBugWorkarounds;
    public String disabledExtensions;
    public int[] appliedGpuDriverBugListEntries;

    private GpuFeatureInfo(int version) {
        super(STRUCT_SIZE, version);
    }

    public GpuFeatureInfo() {
        this(0);
    }

    public static GpuFeatureInfo deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static GpuFeatureInfo deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static GpuFeatureInfo decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        GpuFeatureInfo result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new GpuFeatureInfo(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.statusValues = decoder0.readInts(8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i0 = 0; i0 < result.statusValues.length; ++i0) {
                        GpuFeatureStatus.validate(result.statusValues[i0]);
                    }
                }
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.enabledGpuDriverBugWorkarounds = decoder0.readInts(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.disabledExtensions = decoder0.readString(24, false);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.appliedGpuDriverBugListEntries = decoder0.readInts(32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            }
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.statusValues, 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.enabledGpuDriverBugWorkarounds, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.disabledExtensions, 24, false);
        
        encoder0.encode(this.appliedGpuDriverBugListEntries, 32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        GpuFeatureInfo other = (GpuFeatureInfo) object;
        if (!java.util.Arrays.equals(this.statusValues, other.statusValues))
            return false;
        if (!java.util.Arrays.equals(this.enabledGpuDriverBugWorkarounds, other.enabledGpuDriverBugWorkarounds))
            return false;
        if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.disabledExtensions, other.disabledExtensions))
            return false;
        if (!java.util.Arrays.equals(this.appliedGpuDriverBugListEntries, other.appliedGpuDriverBugListEntries))
            return false;
        return true;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + java.util.Arrays.hashCode(this.statusValues);
        result = prime * result + java.util.Arrays.hashCode(this.enabledGpuDriverBugWorkarounds);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.disabledExtensions);
        result = prime * result + java.util.Arrays.hashCode(this.appliedGpuDriverBugListEntries);
        return result;
    }
}