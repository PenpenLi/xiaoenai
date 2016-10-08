package com.alibaba.sdk.android.rpc.utils;

import com.alibaba.sdk.android.rpc.ServiceInvokeException;
import com.alibaba.sdk.android.rpc.ServiceInvokeException.ServiceInvokeExceptionType;
import com.alibaba.sdk.android.rpc.ServiceResponse;
import com.alibaba.sdk.android.rpc.codec.DynamicByteBuffer;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class ProtocolUtils
{
  private static final String UTF_8_CHAR_SET = "UTF-8";
  private static final Map<Integer, ServiceInvokeException.ServiceInvokeExceptionType> codeServiceInvokeExceptionTypes = new HashMap();
  
  static
  {
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(1), ServiceInvokeException.ServiceInvokeExceptionType.INVALID_SID);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(2), ServiceInvokeException.ServiceInvokeExceptionType.INVALID_SID);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(3), ServiceInvokeException.ServiceInvokeExceptionType.HSF_EXCEPTION);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(5), ServiceInvokeException.ServiceInvokeExceptionType.LOGIN_REQUIRED);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(6), ServiceInvokeException.ServiceInvokeExceptionType.API_NOT_FOUND);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(7), ServiceInvokeException.ServiceInvokeExceptionType.APP_NOT_FOUND);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(8), ServiceInvokeException.ServiceInvokeExceptionType.PERMISSION_DENIED);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(9), ServiceInvokeException.ServiceInvokeExceptionType.API_FLOW_REGULATION);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(304), ServiceInvokeException.ServiceInvokeExceptionType.INVAILD_ETAG);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(404), ServiceInvokeException.ServiceInvokeExceptionType.SERVICE_NOT_FOUND);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(416), ServiceInvokeException.ServiceInvokeExceptionType.TIMESTAMP_MISMATCH);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(502), ServiceInvokeException.ServiceInvokeExceptionType.DECRYPT_FAILED);
    codeServiceInvokeExceptionTypes.put(Integer.valueOf(504), ServiceInvokeException.ServiceInvokeExceptionType.SERVICE_TIMEOUT);
  }
  
  public static ServiceInvokeException createServiceInvokeException(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof TimeoutException)) {
      return new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.SERVICE_TIMEOUT, paramThrowable);
    }
    if ((paramThrowable instanceof ServiceInvokeException)) {
      return (ServiceInvokeException)paramThrowable;
    }
    return new ServiceInvokeException(paramThrowable);
  }
  
  public static Map<String, Object> decodeHeader(DynamicByteBuffer paramDynamicByteBuffer)
  {
    boolean bool = false;
    int j = 0;
    if ((paramDynamicByteBuffer == null) || (!paramDynamicByteBuffer.hasRemaining())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int k = paramDynamicByteBuffer.get();
    if (k == 0) {
      return null;
    }
    Object localObject = new byte[k];
    int i = 0;
    while (i < k)
    {
      localObject[i] = paramDynamicByteBuffer.get();
      i += 1;
    }
    byte[] arrayOfByte;
    try
    {
      localObject = new String((byte[])localObject, "UTF-8");
      k = paramDynamicByteBuffer.get();
      switch (k)
      {
      default: 
        arrayOfByte = new byte[k];
        i = j;
      case -5: 
        while (i < k)
        {
          arrayOfByte[i] = paramDynamicByteBuffer.get();
          i += 1;
          continue;
          paramDynamicByteBuffer = Integer.valueOf(paramDynamicByteBuffer.getInt());
        }
      }
    }
    catch (UnsupportedEncodingException paramDynamicByteBuffer)
    {
      return null;
    }
    for (;;)
    {
      localHashMap.put(localObject, paramDynamicByteBuffer);
      return localHashMap;
      if (paramDynamicByteBuffer.get() == 0) {}
      for (;;)
      {
        paramDynamicByteBuffer = Boolean.valueOf(bool);
        break;
        bool = true;
      }
      try
      {
        paramDynamicByteBuffer = new String(arrayOfByte, "UTF-8");
      }
      catch (UnsupportedEncodingException paramDynamicByteBuffer) {}
    }
    return null;
  }
  
  public static Map<String, Object> decodeHeaders(DynamicByteBuffer paramDynamicByteBuffer)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      Map localMap = decodeHeader(paramDynamicByteBuffer);
      if (localMap == null) {
        break;
      }
      localHashMap.putAll(localMap);
    }
    return localHashMap;
  }
  
  public static String decodeString(DynamicByteBuffer paramDynamicByteBuffer)
  {
    if (paramDynamicByteBuffer.remaining() < 2) {
      return null;
    }
    paramDynamicByteBuffer.mark();
    int i = readWord(paramDynamicByteBuffer);
    if (paramDynamicByteBuffer.remaining() < i)
    {
      paramDynamicByteBuffer.reset();
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramDynamicByteBuffer.get(arrayOfByte);
    try
    {
      paramDynamicByteBuffer = new String(arrayOfByte, "UTF-8");
      return paramDynamicByteBuffer;
    }
    catch (UnsupportedEncodingException paramDynamicByteBuffer) {}
    return null;
  }
  
  public static long decodeVariableNumber(DynamicByteBuffer paramDynamicByteBuffer)
  {
    long l2 = 1L;
    long l1 = 0L;
    int i;
    long l3;
    do
    {
      if (paramDynamicByteBuffer.remaining() < 1) {
        return -1L;
      }
      i = paramDynamicByteBuffer.get();
      l3 = l1 + (i & 0x7F) * l2;
      l2 *= 128L;
      l1 = l3;
    } while ((i & 0x80) != 0);
    return l3;
  }
  
  public static void encodeHeader(DynamicByteBuffer paramDynamicByteBuffer, Map.Entry<String, Object> paramEntry)
  {
    if ((paramEntry.getKey() == null) || (paramEntry.getValue() == null)) {
      return;
    }
    try
    {
      byte[] arrayOfByte = ((String)paramEntry.getKey()).getBytes("UTF-8");
      paramDynamicByteBuffer.put((byte)arrayOfByte.length);
      paramDynamicByteBuffer.put(arrayOfByte);
      paramEntry = paramEntry.getValue();
      int i;
      if ((paramEntry instanceof Integer))
      {
        paramDynamicByteBuffer.put((byte)-5);
        i = ((Integer)paramEntry).intValue();
        paramDynamicByteBuffer.put((byte)((0xFF000000 & i) >> 24));
        paramDynamicByteBuffer.put((byte)((0xFF0000 & i) >> 16));
        paramDynamicByteBuffer.put((byte)((0xFF00 & i) >> 8));
        paramDynamicByteBuffer.put((byte)(i & 0xFF));
        return;
      }
      if ((paramEntry instanceof Boolean))
      {
        paramDynamicByteBuffer.put((byte)-4);
        if (((Boolean)paramEntry).booleanValue()) {}
        for (i = 1;; i = 0)
        {
          paramDynamicByteBuffer.put((byte)i);
          return;
        }
      }
      try
      {
        paramEntry = paramEntry.toString().getBytes("UTF-8");
        paramDynamicByteBuffer.put((byte)paramEntry.length);
        paramDynamicByteBuffer.put(paramEntry);
        return;
      }
      catch (Exception paramEntry)
      {
        for (;;)
        {
          paramEntry = new byte[0];
        }
      }
      return;
    }
    catch (Exception paramDynamicByteBuffer) {}
  }
  
  public static void encodeHeaders(DynamicByteBuffer paramDynamicByteBuffer, Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      paramDynamicByteBuffer.put((byte)0);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      encodeHeader(paramDynamicByteBuffer, (Map.Entry)paramMap.next());
    }
    paramDynamicByteBuffer.put((byte)0);
  }
  
  public static void encodeString(DynamicByteBuffer paramDynamicByteBuffer, String paramString)
  {
    if (paramString == null)
    {
      paramDynamicByteBuffer.put((byte)0);
      paramDynamicByteBuffer.put((byte)0);
      return;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramDynamicByteBuffer.put((byte)((paramString.length & 0xFF00) >> 8));
      paramDynamicByteBuffer.put((byte)(paramString.length & 0xFF));
      paramDynamicByteBuffer.put(paramString);
      return;
    }
    catch (Exception paramDynamicByteBuffer) {}
  }
  
  public static void encodeVariableNumber(DynamicByteBuffer paramDynamicByteBuffer, long paramLong)
  {
    long l;
    do
    {
      int j = (byte)(int)(paramLong % 128L);
      l = paramLong / 128L;
      int i = j;
      if (l > 0L) {
        i = (byte)(j | 0x80);
      }
      paramDynamicByteBuffer.put(i);
      paramLong = l;
    } while (l > 0L);
  }
  
  public static byte[] encodeVariableNumber(long paramLong)
  {
    DynamicByteBuffer localDynamicByteBuffer = DynamicByteBuffer.allocate(8);
    encodeVariableNumber(localDynamicByteBuffer, paramLong);
    return localDynamicByteBuffer.array();
  }
  
  public static ServiceResponse processServiceResponse(ServiceResponse paramServiceResponse, boolean paramBoolean, String paramString)
  {
    if (paramServiceResponse == null) {
      throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.SYSTEM_ERROR, "Null response");
    }
    if (paramServiceResponse.channelStatusCode == 0)
    {
      paramServiceResponse.restore(paramBoolean, paramString);
      int i = paramServiceResponse.serviceStatusCode;
      if (i == 200) {
        return paramServiceResponse;
      }
      ServiceInvokeException.ServiceInvokeExceptionType localServiceInvokeExceptionType = (ServiceInvokeException.ServiceInvokeExceptionType)codeServiceInvokeExceptionTypes.get(Integer.valueOf(i));
      paramString = localServiceInvokeExceptionType;
      if (localServiceInvokeExceptionType == null) {
        paramString = ServiceInvokeException.ServiceInvokeExceptionType.SYSTEM_ERROR;
      }
      paramServiceResponse = paramServiceResponse.serviceResult;
      if (paramServiceResponse == null) {
        throw new ServiceInvokeException(paramString, "Error occurred, the service status code " + i);
      }
      throw new ServiceInvokeException(paramString, paramServiceResponse);
    }
    if (paramServiceResponse.channelStatusCode == 10) {
      throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.INVALID_SID, "Error occurred channelStatusCode " + paramServiceResponse.channelStatusCode);
    }
    throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.SYSTEM_ERROR, "Error occurred channelStatusCode " + paramServiceResponse.channelStatusCode);
  }
  
  private static int readWord(DynamicByteBuffer paramDynamicByteBuffer)
  {
    return (paramDynamicByteBuffer.get() & 0xFF) << 8 | paramDynamicByteBuffer.get() & 0xFF;
  }
  
  public static String toString(ServiceResponse paramServiceResponse)
  {
    if (paramServiceResponse.contentType == 0) {
      return paramServiceResponse.asJSONString();
    }
    return paramServiceResponse.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\utils\ProtocolUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */