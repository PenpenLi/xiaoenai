package com.xiaoenai.app.utils.d;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class h
{
  public static final String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    paramString = new BigInteger(paramString.getBytes());
    return new BigInteger("0933910847463829232312312").xor(paramString).toString(16);
  }
  
  public static String a(Map<String, String> paramMap, String paramString)
  {
    String[] arrayOfString = new String[paramMap.size()];
    Object localObject = paramMap.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfString[i] = ((String)((Map.Entry)((Iterator)localObject).next()).getKey());
      i += 1;
    }
    Arrays.sort(arrayOfString);
    localObject = "";
    i = 0;
    while (i < arrayOfString.length)
    {
      localObject = (String)localObject + ac.a(arrayOfString[i]) + "=" + ac.a((String)paramMap.get(arrayOfString[i])) + "&";
      i += 1;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramMap = (String)localObject + paramString;; paramMap = ((String)localObject).substring(0, ((String)localObject).length() - 1)) {
      return c(paramMap);
    }
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    String[] arrayOfString = new String[paramJSONObject.length()];
    Object localObject = paramJSONObject.keys();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfString[i] = ((String)((Iterator)localObject).next());
      i += 1;
    }
    Arrays.sort(arrayOfString);
    localObject = "";
    i = 0;
    while (i < arrayOfString.length)
    {
      localObject = (String)localObject + ac.a(arrayOfString[i]) + "=" + ac.a(paramJSONObject.getString(arrayOfString[i])) + "&";
      i += 1;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramJSONObject = (String)localObject + paramString;; paramJSONObject = ((String)localObject).substring(0, ((String)localObject).length() - 1)) {
      return c(paramJSONObject);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length % 3 == 0) {
      paramArrayOfByte = c(paramArrayOfByte);
    }
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      arrayOfByte = c(paramArrayOfByte);
      paramArrayOfByte = arrayOfByte;
    } while (arrayOfByte.length % 4 == 0);
    int i = 4 - arrayOfByte.length % 4;
    paramArrayOfByte = new byte[arrayOfByte.length + i];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    paramArrayOfByte[arrayOfByte.length] = 61;
    if (i > 1) {
      paramArrayOfByte[(arrayOfByte.length + 1)] = 61;
    }
    return paramArrayOfByte;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    BigInteger localBigInteger = new BigInteger("0933910847463829232312312");
    try
    {
      paramString = new String(new BigInteger(paramString, 16).xor(localBigInteger).toByteArray());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return new String(a(paramArrayOfByte));
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(c.a(paramArrayOfByte)).getBytes();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == 47) {
        paramArrayOfByte[i] = 95;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramArrayOfByte[i] == 43) {
          paramArrayOfByte[i] = 45;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public static String d(String paramString)
  {
    return new String(a(paramString.getBytes()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */