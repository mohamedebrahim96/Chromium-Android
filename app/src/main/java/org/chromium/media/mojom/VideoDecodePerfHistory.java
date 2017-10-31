
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/video_decode_perf_history.mojom
//

package org.chromium.media.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface VideoDecodePerfHistory extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends VideoDecodePerfHistory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy> MANAGER = VideoDecodePerfHistory_Internal.MANAGER;


    void getPerfInfo(
int profile, org.chromium.gfx.mojom.Size videoSize, int framesPerSec, 
GetPerfInfoResponse callback);

    interface GetPerfInfoResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Boolean, Boolean> { }


}
