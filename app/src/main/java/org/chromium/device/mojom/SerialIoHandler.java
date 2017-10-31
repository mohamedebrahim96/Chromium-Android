
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/interfaces/serial.mojom
//

package org.chromium.device.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface SerialIoHandler extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SerialIoHandler, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SerialIoHandler, SerialIoHandler.Proxy> MANAGER = SerialIoHandler_Internal.MANAGER;


    void open(
String port, SerialConnectionOptions options, 
OpenResponse callback);

    interface OpenResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void read(
int bytes, 
ReadResponse callback);

    interface ReadResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<byte[], Integer> { }



    void write(
byte[] data, 
WriteResponse callback);

    interface WriteResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, Integer> { }



    void cancelRead(
int reason);



    void cancelWrite(
int reason);



    void flush(

FlushResponse callback);

    interface FlushResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void getControlSignals(

GetControlSignalsResponse callback);

    interface GetControlSignalsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<SerialDeviceControlSignals> { }



    void setControlSignals(
SerialHostControlSignals signals, 
SetControlSignalsResponse callback);

    interface SetControlSignalsResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void configurePort(
SerialConnectionOptions options, 
ConfigurePortResponse callback);

    interface ConfigurePortResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void getPortInfo(

GetPortInfoResponse callback);

    interface GetPortInfoResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<SerialConnectionInfo> { }



    void setBreak(

SetBreakResponse callback);

    interface SetBreakResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void clearBreak(

ClearBreakResponse callback);

    interface ClearBreakResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


}
