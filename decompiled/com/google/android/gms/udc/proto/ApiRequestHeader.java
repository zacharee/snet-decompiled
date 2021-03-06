package com.google.android.gms.udc.proto;

import com.google.android.gms.lint.BuildConfig;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.wireless.android.play.playlog.proto.UserLocation.LaunchSettingsEvent.Action;
import com.google.wireless.android.play.playlog.proto.UserLocation.LocationSharingEvent.Type;
import java.io.IOException;

public final class ApiRequestHeader extends ExtendableMessageNano<ApiRequestHeader> {
    private static volatile ApiRequestHeader[] _emptyArray;
    public String consistencyTokenJar;

    public static ApiRequestHeader[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ApiRequestHeader[0];
                }
            }
        }
        return _emptyArray;
    }

    public ApiRequestHeader() {
        clear();
    }

    public ApiRequestHeader clear() {
        this.consistencyTokenJar = BuildConfig.VERSION_NAME;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiRequestHeader)) {
            return false;
        }
        ApiRequestHeader other = (ApiRequestHeader) o;
        if (this.consistencyTokenJar == null) {
            if (other.consistencyTokenJar != null) {
                return false;
            }
        } else if (!this.consistencyTokenJar.equals(other.consistencyTokenJar)) {
            return false;
        }
        if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
            return this.unknownFieldData.equals(other.unknownFieldData);
        }
        if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.consistencyTokenJar == null ? 0 : this.consistencyTokenJar.hashCode())) * 31;
        if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
            i = this.unknownFieldData.hashCode();
        }
        return hashCode + i;
    }

    public void writeTo(CodedOutputByteBufferNano output) throws IOException {
        if (!this.consistencyTokenJar.equals(BuildConfig.VERSION_NAME)) {
            output.writeString(1, this.consistencyTokenJar);
        }
        super.writeTo(output);
    }

    protected int computeSerializedSize() {
        int size = super.computeSerializedSize();
        if (this.consistencyTokenJar.equals(BuildConfig.VERSION_NAME)) {
            return size;
        }
        return size + CodedOutputByteBufferNano.computeStringSize(1, this.consistencyTokenJar);
    }

    public ApiRequestHeader mergeFrom(CodedInputByteBufferNano input) throws IOException {
        while (true) {
            int tag = input.readTag();
            switch (tag) {
                case Action.UNKNOWN /*0*/:
                    break;
                case Type.TAP_ABOUT /*10*/:
                    this.consistencyTokenJar = input.readString();
                    continue;
                default:
                    if (!storeUnknownField(input, tag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public static ApiRequestHeader parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
        return (ApiRequestHeader) MessageNano.mergeFrom(new ApiRequestHeader(), data);
    }

    public static ApiRequestHeader parseFrom(CodedInputByteBufferNano input) throws IOException {
        return new ApiRequestHeader().mergeFrom(input);
    }
}
