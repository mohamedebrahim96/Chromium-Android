
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/interface_factory.mojom
//

package org.chromium.media.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface InterfaceFactory extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends InterfaceFactory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<InterfaceFactory, InterfaceFactory.Proxy> MANAGER = InterfaceFactory_Internal.MANAGER;


    void createAudioDecoder(
org.chromium.mojo.bindings.InterfaceRequest<AudioDecoder> audioDecoder);



    void createVideoDecoder(
org.chromium.mojo.bindings.InterfaceRequest<VideoDecoder> videoDecoder);



    void createRenderer(
String audioDeviceId, org.chromium.mojo.bindings.InterfaceRequest<Renderer> renderer);



    void createCdm(
String keySystem, org.chromium.mojo.bindings.InterfaceRequest<ContentDecryptionModule> cdm);


}
