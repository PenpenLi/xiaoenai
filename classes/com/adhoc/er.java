package com.adhoc;

import android.os.Build.VERSION;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class er
  implements Serializable
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final er b = a(new byte[0]);
  final byte[] c;
  transient int d;
  transient String e;
  
  er(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static er a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    if (Build.VERSION.SDK_INT > 8) {}
    for (er localer = new er(paramString.getBytes(fj.a));; localer = new er(paramString.getBytes()))
    {
      localer.e = paramString;
      return localer;
    }
  }
  
  public static er a(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new er((byte[])paramVarArgs.clone());
  }
  
  private er b(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance(paramString).digest(this.c));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public byte a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public String a()
  {
    String str = this.e;
    if (Build.VERSION.SDK_INT > 8) {
      if (str == null) {}
    }
    while (str != null)
    {
      return str;
      str = new String(this.c, fj.a);
      this.e = str;
      return str;
    }
    try
    {
      str = new String(this.c, "utf-8");
      this.e = str;
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      fl.a(localUnsupportedEncodingException);
    }
    return null;
  }
  
  void a(eo parameo)
  {
    parameo.b(this.c, 0, this.c.length);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 <= this.c.length - paramInt3) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (fj.a(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public String b()
  {
    return en.a(this.c);
  }
  
  public er c()
  {
    return b("MD5");
  }
  
  public String d()
  {
    int i = 0;
    char[] arrayOfChar = new char[this.c.length * 2];
    byte[] arrayOfByte = this.c;
    int k = arrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = a[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public er e()
  {
    int i = 0;
    int j;
    for (;;)
    {
      localObject = this;
      if (i >= this.c.length) {
        return localObject;
      }
      j = this.c[i];
      if ((j >= 65) && (j <= 90)) {
        break;
      }
      i += 1;
    }
    Object localObject = (byte[])this.c.clone();
    localObject[i] = ((byte)(j + 32));
    i += 1;
    if (i < localObject.length)
    {
      j = localObject[i];
      if ((j < 65) || (j > 90)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = ((byte)(j + 32));
      }
    }
    localObject = new er((byte[])localObject);
    return (er)localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof er)) && (((er)paramObject).f() == this.c.length) && (((er)paramObject).a(0, this.c, 0, this.c.length))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int f()
  {
    return this.c.length;
  }
  
  public byte[] g()
  {
    return (byte[])this.c.clone();
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.c);
    this.d = i;
    return i;
  }
  
  public String toString()
  {
    if (this.c.length == 0) {
      return "ByteString[size=0]";
    }
    if (this.c.length <= 16) {
      return String.format("ByteString[size=%s data=%s]", new Object[] { Integer.valueOf(this.c.length), d() });
    }
    return String.format("ByteString[size=%s md5=%s]", new Object[] { Integer.valueOf(this.c.length), c().d() });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */