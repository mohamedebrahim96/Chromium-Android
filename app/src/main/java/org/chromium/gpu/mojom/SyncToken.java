
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/sync_token.mojom
//

package org.chromium.gpu.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class SyncToken extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean verifiedFlush;
    public int namespaceId;
    public int extraDataField;
    public long commandBufferId;
    public long releaseCount;

    private SyncToken(int version) {
        super(STRUCT_SIZE, version);
    }

    public SyncToken() {
        this(0);
    }

    public static SyncToken deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SyncToken deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SyncToken decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SyncToken result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new SyncToken(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.verifiedFlush = decoder0.readBoolean(8, 0);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.namespaceId = decoder0.readInt(12);
                    CommandBufferNamespace.validate(result.namespaceId);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.extraDataField = decoder0.readInt(16);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.commandBufferId = decoder0.readLong(24);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.releaseCount = decoder0.readLong(32);
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
        
        encoder0.encode(this.verifiedFlush, 8, 0);
        
        encoder0.encode(this.namespaceId, 12);
        
        encoder0.encode(this.extraDataField, 16);
        
        encoder0.encode(this.commandBufferId, 24);
        
        encoder0.encode(this.releaseCount, 32);
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
        SyncToken other = (SyncToken) object;
        if (this.verifiedFlush!= other.verifiedFlush)
            return false;
        if (this.namespaceId!= other.namespaceId)
            return false;
        if (this.extraDataField!= other.extraDataField)
            return false;
        if (this.commandBufferId!= other.commandBufferId)
            return false;
        if (this.releaseCount!= other.releaseCount)
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
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.verifiedFlush);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.namespaceId);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.extraDataField);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.commandBufferId);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.releaseCount);
        return result;
    }
}