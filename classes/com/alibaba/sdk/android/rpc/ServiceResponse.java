package com.alibaba.sdk.android.rpc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.sdk.android.rpc.codec.DynamicByteBuffer;
import com.alibaba.sdk.android.rpc.impl.RpcContext;
import com.alibaba.sdk.android.rpc.utils.ProtocolUtils;
import com.alibaba.sdk.android.security.SecurityGuardService;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ServiceResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ServiceResponse> CREATOR = new ServiceResponse.1();
  private static final String DEFAULT_CHARSET = "utf-8";
  public byte channelStatusCode = 0;
  public byte contentType = 0;
  public byte[] payload;
  public Map<String, Object> responseHeaders = new HashMap();
  public byte[] serviceResult;
  public int serviceStatusCode = -1;
  
  public ServiceResponse() {}
  
  public ServiceResponse(Parcel paramParcel)
  {
    this.channelStatusCode = paramParcel.readByte();
    if (paramParcel.dataAvail() > 0)
    {
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.payload = new byte[i];
        paramParcel.readByteArray(this.payload);
      }
    }
  }
  
  public ServiceResponse(byte[] paramArrayOfByte)
  {
    this.payload = paramArrayOfByte;
  }
  
  public String asJSONString()
  {
    if (this.contentType == 2) {
      throw new IllegalStateException("content type is custom binary!");
    }
    if (this.serviceResult == null) {
      return null;
    }
    if (this.contentType == 0) {
      try
      {
        String str = new String(this.serviceResult, "utf-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException(localUnsupportedEncodingException);
      }
    }
    throw new IllegalStateException("unsupported content type:" + this.contentType);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void restore(boolean paramBoolean, String paramString)
  {
    if (this.channelStatusCode != 0) {}
    int i;
    do
    {
      do
      {
        return;
        byte[] arrayOfByte2 = this.payload;
        arrayOfByte1 = arrayOfByte2;
        if (paramBoolean) {
          arrayOfByte1 = RpcContext.securityGuardService.symDecrypt(arrayOfByte2, paramString);
        }
        paramString = new DynamicByteBuffer(arrayOfByte1);
        this.serviceStatusCode = ((short)(int)ProtocolUtils.decodeVariableNumber(paramString));
        this.contentType = paramString.get();
        if (paramString.remaining() > 0) {
          this.responseHeaders = ProtocolUtils.decodeHeaders(paramString);
        }
      } while (paramString.remaining() <= 0);
      i = (int)ProtocolUtils.decodeVariableNumber(paramString);
      if (i > 0) {
        paramString.get(new byte[i]);
      }
      i = paramString.remaining();
    } while (i <= 0);
    byte[] arrayOfByte1 = new byte[i];
    paramString.get(arrayOfByte1);
    this.serviceResult = arrayOfByte1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[channelStatusCode:").append(this.channelStatusCode).append(",serviceResult.length:");
    if (this.serviceResult == null) {}
    for (int i = 0;; i = this.serviceResult.length) {
      return i + "" + ",responseHeaders:" + this.responseHeaders + ",contentType:" + this.contentType + ",serviceStatusCode:" + this.serviceStatusCode + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte(this.channelStatusCode);
    if ((this.payload != null) && (this.payload.length > 0))
    {
      paramParcel.writeInt(this.payload.length);
      paramParcel.writeByteArray(this.payload);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\ServiceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */