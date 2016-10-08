package com.qiniu.android.dns.b;

import com.qiniu.android.dns.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class c
{
  private static String a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    int i = paramDataInputStream.readUnsignedByte();
    if ((i & 0xC0) == 192)
    {
      i = ((i & 0x3F) << 8) + paramDataInputStream.readUnsignedByte();
      paramDataInputStream = new HashSet();
      paramDataInputStream.add(Integer.valueOf(i));
      paramDataInputStream = a(paramArrayOfByte, i, paramDataInputStream);
    }
    Object localObject;
    do
    {
      return paramDataInputStream;
      if (i == 0) {
        return "";
      }
      localObject = new byte[i];
      paramDataInputStream.readFully((byte[])localObject);
      localObject = IDN.toUnicode(new String((byte[])localObject));
      paramArrayOfByte = a(paramDataInputStream, paramArrayOfByte);
      paramDataInputStream = (DataInputStream)localObject;
    } while (paramArrayOfByte.length() <= 0);
    return (String)localObject + "." + paramArrayOfByte;
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt, HashSet<Integer> paramHashSet)
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    if ((i & 0xC0) == 192)
    {
      paramInt = ((i & 0x3F) << 8) + (paramArrayOfByte[(paramInt + 1)] & 0xFF);
      if (paramHashSet.contains(Integer.valueOf(paramInt))) {
        throw new com.qiniu.android.dns.a("", "Cyclic offsets detected.");
      }
      paramHashSet.add(Integer.valueOf(paramInt));
      paramArrayOfByte = a(paramArrayOfByte, paramInt, paramHashSet);
    }
    String str;
    do
    {
      return paramArrayOfByte;
      if (i == 0) {
        return "";
      }
      str = new String(paramArrayOfByte, paramInt + 1, i);
      paramHashSet = a(paramArrayOfByte, i + (paramInt + 1), paramHashSet);
      paramArrayOfByte = str;
    } while (paramHashSet.length() <= 0);
    return str + "." + paramHashSet;
  }
  
  private static void a(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt > 0)
    {
      a(paramDataInputStream, paramArrayOfByte);
      paramDataInputStream.readUnsignedShort();
      paramDataInputStream.readUnsignedShort();
      paramInt -= 1;
    }
  }
  
  private static void a(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.split("[.。．｡]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      byte[] arrayOfByte = IDN.toASCII(paramString[i]).getBytes();
      paramOutputStream.write(arrayOfByte.length);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      i += 1;
    }
    paramOutputStream.write(0);
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    com.qiniu.android.dns.c.a locala = new com.qiniu.android.dns.c.a();
    locala.a(8);
    paramInt = (short)paramInt;
    try
    {
      localDataOutputStream.writeShort(paramInt);
      localDataOutputStream.writeShort((short)locala.a());
      localDataOutputStream.writeShort(1);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.flush();
      b(localByteArrayOutputStream, paramString);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static h[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    int i = 1;
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    int j = localDataInputStream.readUnsignedShort();
    if (j != paramInt) {
      throw new com.qiniu.android.dns.a(paramString, "the answer id " + j + " is not match " + paramInt);
    }
    j = localDataInputStream.readUnsignedShort();
    if ((j >> 8 & 0x1) == 1)
    {
      paramInt = 1;
      if ((j >> 7 & 0x1) != 1) {
        break label124;
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramInt != 0)) {
        break label130;
      }
      throw new com.qiniu.android.dns.a(paramString, "the dns server cant support recursion ");
      paramInt = 0;
      break;
      label124:
      i = 0;
    }
    label130:
    paramInt = localDataInputStream.readUnsignedShort();
    i = localDataInputStream.readUnsignedShort();
    localDataInputStream.readUnsignedShort();
    localDataInputStream.readUnsignedShort();
    a(localDataInputStream, paramArrayOfByte, paramInt);
    return b(localDataInputStream, paramArrayOfByte, i);
  }
  
  private static h b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte)
  {
    a(paramDataInputStream, paramArrayOfByte);
    int j = paramDataInputStream.readUnsignedShort();
    paramDataInputStream.readUnsignedShort();
    long l1 = paramDataInputStream.readUnsignedShort();
    long l2 = paramDataInputStream.readUnsignedShort();
    int k = paramDataInputStream.readUnsignedShort();
    switch (j)
    {
    default: 
      Object localObject = null;
      int i = 0;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (i >= k) {
          break;
        }
        paramDataInputStream.readByte();
        i += 1;
      }
    case 1: 
      paramArrayOfByte = new byte[4];
      paramDataInputStream.readFully(paramArrayOfByte);
    }
    for (paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte).getHostAddress(); paramArrayOfByte == null; paramArrayOfByte = a(paramDataInputStream, paramArrayOfByte)) {
      throw new UnknownHostException("no record");
    }
    return new h(paramArrayOfByte, j, (int)(l2 + (l1 << 16)), System.currentTimeMillis() / 1000L);
  }
  
  private static void b(OutputStream paramOutputStream, String paramString)
  {
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    a(paramOutputStream, paramString);
    localDataOutputStream.writeShort(1);
    localDataOutputStream.writeShort(1);
  }
  
  private static h[] b(DataInputStream paramDataInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    h[] arrayOfh = new h[paramInt];
    while (paramInt > 0)
    {
      arrayOfh[i] = b(paramDataInputStream, paramArrayOfByte);
      i += 1;
      paramInt -= 1;
    }
    return arrayOfh;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */