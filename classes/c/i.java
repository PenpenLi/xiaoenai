package c;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class i
  implements Serializable, Comparable<i>
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final i b = a(new byte[0]);
  private static final long serialVersionUID = 1L;
  final byte[] c;
  transient int d;
  transient String e;
  
  i(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static i a(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
    return new i(arrayOfByte);
  }
  
  public static i a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    i locali = new i(paramString.getBytes(ac.a));
    locali.e = paramString;
    return locali;
  }
  
  public static i a(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new i((byte[])paramVarArgs.clone());
  }
  
  private i b(String paramString)
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
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream = a(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = i.class.getDeclaredField("c");
      localField.setAccessible(true);
      localField.set(this, paramObjectInputStream.c);
      return;
    }
    catch (NoSuchFieldException paramObjectInputStream)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException paramObjectInputStream)
    {
      throw new AssertionError();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.c.length);
    paramObjectOutputStream.write(this.c);
  }
  
  public byte a(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public int a(i parami)
  {
    int j = f();
    int k = parami.f();
    int m = Math.min(j, k);
    int i = 0;
    for (;;)
    {
      if (i < m)
      {
        int n = a(i) & 0xFF;
        int i1 = parami.a(i) & 0xFF;
        if (n == i1) {
          i += 1;
        } else {
          if (n >= i1) {
            break;
          }
        }
      }
    }
    do
    {
      return -1;
      return 1;
      if (j == k) {
        return 0;
      }
    } while (j < k);
    return 1;
  }
  
  public String a()
  {
    String str = this.e;
    if (str != null) {
      return str;
    }
    str = new String(this.c, ac.a);
    this.e = str;
    return str;
  }
  
  void a(e parame)
  {
    parame.b(this.c, 0, this.c.length);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 <= this.c.length - paramInt3) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (ac.a(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public String b()
  {
    return d.a(this.c);
  }
  
  public i c()
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
  
  public i e()
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
    localObject = new i((byte[])localObject);
    return (i)localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof i)) && (((i)paramObject).f() == this.c.length) && (((i)paramObject).a(0, this.c, 0, this.c.length))) {}
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */