
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/content_decryption_module.mojom
//

package org.chromium.media.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class CdmPromiseResult extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final class Exception {
    
    
    
        private static final boolean IS_EXTENSIBLE = false;
    
        public static boolean isKnownValue(int value) {
            return false;
        }
    
        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;
    
            throw new DeserializationException("Invalid enum value.");
        }
    
        private Exception() {}
    
    }
    public boolean success;
    public int exception;
    public int systemCode;
    public String errorMessage;

    private CdmPromiseResult(int version) {
        super(STRUCT_SIZE, version);
    }

    public CdmPromiseResult() {
        this(0);
    }

    public static CdmPromiseResult deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static CdmPromiseResult deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static CdmPromiseResult decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        CdmPromiseResult result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new CdmPromiseResult(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.success = decoder0.readBoolean(8, 0);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.exception = decoder0.readInt(12);
                    CdmPromiseResult.Exception.validate(result.exception);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.systemCode = decoder0.readInt(16);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.errorMessage = decoder0.readString(24, false);
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
        
        encoder0.encode(this.success, 8, 0);
        
        encoder0.encode(this.exception, 12);
        
        encoder0.encode(this.systemCode, 16);
        
        encoder0.encode(this.errorMessage, 24, false);
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
        CdmPromiseResult other = (CdmPromiseResult) object;
        if (this.success!= other.success)
            return false;
        if (this.exception!= other.exception)
            return false;
        if (this.systemCode!= other.systemCode)
            return false;
        if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.errorMessage, other.errorMessage))
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
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.success);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.exception);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.systemCode);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.errorMessage);
        return result;
    }
}