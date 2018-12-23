
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/tcp_socket.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class TcpBoundSocket_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.TCPBoundSocket";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(org.chromium.mojo.system.Core core, TcpBoundSocket impl) {
            return new Stub(core, impl);
        }

        @Override
        public TcpBoundSocket[] buildArray(int size) {
          return new TcpBoundSocket[size];
        }
    };


    private static final int LISTEN_ORDINAL = 0;

    private static final int CONNECT_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements TcpBoundSocket.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void listen(
int backlog, org.chromium.mojo.bindings.InterfaceRequest<TcpServerSocket> socket, 
ListenResponse callback) {

            TcpBoundSocketListenParams _message = new TcpBoundSocketListenParams();

            _message.backlog = backlog;

            _message.socket = socket;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    LISTEN_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TcpBoundSocketListenResponseParamsForwardToCallback(callback));

        }


        @Override
        public void connect(
org.chromium.net.interfaces.AddressList remoteAddrList, TcpConnectedSocketOptions tcpConnectedSocketOptions, org.chromium.mojo.bindings.InterfaceRequest<TcpConnectedSocket> socket, SocketObserver observer, 
ConnectResponse callback) {

            TcpBoundSocketConnectParams _message = new TcpBoundSocketConnectParams();

            _message.remoteAddrList = remoteAddrList;

            _message.tcpConnectedSocketOptions = tcpConnectedSocketOptions;

            _message.socket = socket;

            _message.observer = observer;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CONNECT_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TcpBoundSocketConnectResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<TcpBoundSocket> {

        Stub(org.chromium.mojo.system.Core core, TcpBoundSocket impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.NO_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                                TcpBoundSocket_Internal.MANAGER, messageWithHeader);






                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                                getCore(), TcpBoundSocket_Internal.MANAGER, messageWithHeader, receiver);







                    case LISTEN_ORDINAL: {

                        TcpBoundSocketListenParams data =
                                TcpBoundSocketListenParams.deserialize(messageWithHeader.getPayload());

                        getImpl().listen(data.backlog, data.socket, new TcpBoundSocketListenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case CONNECT_ORDINAL: {

                        TcpBoundSocketConnectParams data =
                                TcpBoundSocketConnectParams.deserialize(messageWithHeader.getPayload());

                        getImpl().connect(data.remoteAddrList, data.tcpConnectedSocketOptions, data.socket, data.observer, new TcpBoundSocketConnectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class TcpBoundSocketListenParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int backlog;
        public org.chromium.mojo.bindings.InterfaceRequest<TcpServerSocket> socket;

        private TcpBoundSocketListenParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpBoundSocketListenParams() {
            this(0);
        }

        public static TcpBoundSocketListenParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpBoundSocketListenParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpBoundSocketListenParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpBoundSocketListenParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpBoundSocketListenParams(elementsOrVersion);
                    {
                        
                    result.backlog = decoder0.readInt(8);
                    }
                    {
                        
                    result.socket = decoder0.readInterfaceRequest(12, false);
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
            
            encoder0.encode(this.backlog, 8);
            
            encoder0.encode(this.socket, 12, false);
        }
    }



    
    static final class TcpBoundSocketListenResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private TcpBoundSocketListenResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpBoundSocketListenResponseParams() {
            this(0);
        }

        public static TcpBoundSocketListenResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpBoundSocketListenResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpBoundSocketListenResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpBoundSocketListenResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpBoundSocketListenResponseParams(elementsOrVersion);
                    {
                        
                    result.netError = decoder0.readInt(8);
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
            
            encoder0.encode(this.netError, 8);
        }
    }

    static class TcpBoundSocketListenResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TcpBoundSocket.ListenResponse mCallback;

        TcpBoundSocketListenResponseParamsForwardToCallback(TcpBoundSocket.ListenResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(LISTEN_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TcpBoundSocketListenResponseParams response = TcpBoundSocketListenResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.netError);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TcpBoundSocketListenResponseParamsProxyToResponder implements TcpBoundSocket.ListenResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpBoundSocketListenResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer netError) {
            TcpBoundSocketListenResponseParams _response = new TcpBoundSocketListenResponseParams();

            _response.netError = netError;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    LISTEN_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class TcpBoundSocketConnectParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.net.interfaces.AddressList remoteAddrList;
        public TcpConnectedSocketOptions tcpConnectedSocketOptions;
        public org.chromium.mojo.bindings.InterfaceRequest<TcpConnectedSocket> socket;
        public SocketObserver observer;

        private TcpBoundSocketConnectParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpBoundSocketConnectParams() {
            this(0);
        }

        public static TcpBoundSocketConnectParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpBoundSocketConnectParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpBoundSocketConnectParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpBoundSocketConnectParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpBoundSocketConnectParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.remoteAddrList = org.chromium.net.interfaces.AddressList.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.tcpConnectedSocketOptions = TcpConnectedSocketOptions.decode(decoder1);
                    }
                    {
                        
                    result.socket = decoder0.readInterfaceRequest(24, false);
                    }
                    {
                        
                    result.observer = decoder0.readServiceInterface(28, true, SocketObserver.MANAGER);
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
            
            encoder0.encode(this.remoteAddrList, 8, false);
            
            encoder0.encode(this.tcpConnectedSocketOptions, 16, true);
            
            encoder0.encode(this.socket, 24, false);
            
            encoder0.encode(this.observer, 28, true, SocketObserver.MANAGER);
        }
    }



    
    static final class TcpBoundSocketConnectResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public org.chromium.net.interfaces.IpEndPoint localAddr;
        public org.chromium.net.interfaces.IpEndPoint peerAddr;
        public org.chromium.mojo.system.DataPipe.ConsumerHandle receiveStream;
        public org.chromium.mojo.system.DataPipe.ProducerHandle sendStream;

        private TcpBoundSocketConnectResponseParams(int version) {
            super(STRUCT_SIZE, version);
            this.receiveStream = org.chromium.mojo.system.InvalidHandle.INSTANCE;
            this.sendStream = org.chromium.mojo.system.InvalidHandle.INSTANCE;
        }

        public TcpBoundSocketConnectResponseParams() {
            this(0);
        }

        public static TcpBoundSocketConnectResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpBoundSocketConnectResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpBoundSocketConnectResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpBoundSocketConnectResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpBoundSocketConnectResponseParams(elementsOrVersion);
                    {
                        
                    result.netError = decoder0.readInt(8);
                    }
                    {
                        
                    result.receiveStream = decoder0.readConsumerHandle(12, true);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.localAddr = org.chromium.net.interfaces.IpEndPoint.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                    result.peerAddr = org.chromium.net.interfaces.IpEndPoint.decode(decoder1);
                    }
                    {
                        
                    result.sendStream = decoder0.readProducerHandle(32, true);
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
            
            encoder0.encode(this.netError, 8);
            
            encoder0.encode(this.receiveStream, 12, true);
            
            encoder0.encode(this.localAddr, 16, true);
            
            encoder0.encode(this.peerAddr, 24, true);
            
            encoder0.encode(this.sendStream, 32, true);
        }
    }

    static class TcpBoundSocketConnectResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TcpBoundSocket.ConnectResponse mCallback;

        TcpBoundSocketConnectResponseParamsForwardToCallback(TcpBoundSocket.ConnectResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(CONNECT_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TcpBoundSocketConnectResponseParams response = TcpBoundSocketConnectResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.netError, response.localAddr, response.peerAddr, response.receiveStream, response.sendStream);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TcpBoundSocketConnectResponseParamsProxyToResponder implements TcpBoundSocket.ConnectResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpBoundSocketConnectResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer netError, org.chromium.net.interfaces.IpEndPoint localAddr, org.chromium.net.interfaces.IpEndPoint peerAddr, org.chromium.mojo.system.DataPipe.ConsumerHandle receiveStream, org.chromium.mojo.system.DataPipe.ProducerHandle sendStream) {
            TcpBoundSocketConnectResponseParams _response = new TcpBoundSocketConnectResponseParams();

            _response.netError = netError;

            _response.localAddr = localAddr;

            _response.peerAddr = peerAddr;

            _response.receiveStream = receiveStream;

            _response.sendStream = sendStream;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CONNECT_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}