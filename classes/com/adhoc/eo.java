package com.adhoc;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class eo
  implements ep, eq, Cloneable
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  fd a;
  long b;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    fj.a(paramArrayOfByte.length, paramInt1, paramInt2);
    fd localfd = this.a;
    if (localfd == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localfd.c - localfd.b);
      System.arraycopy(localfd.a, localfd.b, paramArrayOfByte, paramInt1, paramInt2);
      localfd.b += paramInt2;
      this.b -= paramInt2;
      paramInt1 = paramInt2;
    } while (localfd.b != localfd.c);
    this.a = localfd.a();
    fe.a(localfd);
    return paramInt2;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L);
  }
  
  public long a(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return -1L;
    }
    long l1 = 0L;
    int i = ((fd)localObject1).c - ((fd)localObject1).b;
    if (paramLong >= i) {}
    for (paramLong -= i;; paramLong = 0L)
    {
      l1 += i;
      Object localObject2 = ((fd)localObject1).f;
      localObject1 = localObject2;
      if (localObject2 != this.a) {
        break;
      }
      return -1L;
      localObject2 = ((fd)localObject1).a;
      paramLong = ((fd)localObject1).b + paramLong;
      long l2 = ((fd)localObject1).c;
      while (paramLong < l2)
      {
        if (localObject2[((int)paramLong)] == paramByte) {
          return l1 + paramLong - ((fd)localObject1).b;
        }
        paramLong += 1L;
      }
    }
  }
  
  public long a(eo parameo, long paramLong)
  {
    if (parameo == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.b) {
      l = this.b;
    }
    parameo.a_(this, l);
    return l;
  }
  
  public long a(fg paramfg)
  {
    if (paramfg == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramfg.a(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public eo a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
  
  public eo a(eo parameo, long paramLong1, long paramLong2)
  {
    if (parameo == null) {
      throw new IllegalArgumentException("out == null");
    }
    fj.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    parameo.b += paramLong2;
    fd localfd2;
    long l1;
    long l2;
    for (fd localfd1 = this.a;; localfd1 = localfd1.f)
    {
      localfd2 = localfd1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localfd1.c - localfd1.b) {
        break;
      }
      paramLong1 -= localfd1.c - localfd1.b;
    }
    label103:
    if (l2 > 0L)
    {
      localfd1 = new fd(localfd2);
      localfd1.b = ((int)(localfd1.b + l1));
      localfd1.c = Math.min(localfd1.b + (int)l2, localfd1.c);
      if (parameo.a != null) {
        break label215;
      }
      localfd1.g = localfd1;
      localfd1.f = localfd1;
      parameo.a = localfd1;
    }
    for (;;)
    {
      l2 -= localfd1.c - localfd1.b;
      localfd2 = localfd2.f;
      l1 = 0L;
      break label103;
      break;
      label215:
      parameo.a.g.a(localfd1);
    }
  }
  
  public eo a(er paramer)
  {
    if (paramer == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramer.a(this);
    return this;
  }
  
  public eo a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public eo a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    int i;
    label136:
    int j;
    label168:
    byte[] arrayOfByte;
    int k;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      i = 0;
      if ((j > 56319) || (i < 56320) || (i > 57343))
      {
        b(63);
        paramInt1 += 1;
      }
    }
    else
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        fd localfd = e(1);
        arrayOfByte = localfd.a;
        k = localfd.c - paramInt1;
        int m = Math.min(paramInt2, 2048 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        label241:
        if (paramInt1 < m)
        {
          i = paramString.charAt(paramInt1);
          if (i < 128) {}
        }
        else
        {
          i = paramInt1 + k - localfd.c;
          localfd.c += i;
          this.b += i;
        }
      }
    }
    for (;;)
    {
      break label168;
      arrayOfByte[(paramInt1 + k)] = ((byte)i);
      paramInt1 += 1;
      break label241;
      if (j < 2048)
      {
        b(j >> 6 | 0xC0);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        b(j >> 12 | 0xE0);
        b(j >> 6 & 0x3F | 0x80);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 >= paramInt2) {
          break;
        }
        i = paramString.charAt(paramInt1 + 1);
        break label136;
        i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
        b(i >> 18 | 0xF0);
        b(i >> 12 & 0x3F | 0x80);
        b(i >> 6 & 0x3F | 0x80);
        b(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public fh a()
  {
    return fh.b;
  }
  
  public String a(long paramLong, Charset paramCharset)
  {
    fj.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    fd localfd;
    String str;
    do
    {
      return paramCharset;
      localfd = this.a;
      if (localfd.b + paramLong > localfd.c) {
        return new String(f(paramLong), paramCharset);
      }
      str = new String(localfd.a, localfd.b, (int)paramLong, paramCharset);
      localfd.b = ((int)(localfd.b + paramLong));
      this.b -= paramLong;
      paramCharset = str;
    } while (localfd.b != localfd.c);
    this.a = localfd.a();
    fe.a(localfd);
    return str;
  }
  
  public void a(long paramLong)
  {
    if (this.b < paramLong) {
      throw new EOFException();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public void a_(eo parameo, long paramLong)
  {
    if (parameo == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (parameo == this) {
      throw new IllegalArgumentException("source == this");
    }
    fj.a(parameo.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= parameo.a.c - parameo.a.b) {
        break label189;
      }
      if (this.a == null) {
        break label160;
      }
      localfd1 = this.a.g;
      if ((localfd1 == null) || (!localfd1.e)) {
        break label176;
      }
      l = localfd1.c;
      if (!localfd1.d) {
        break label166;
      }
    }
    label160:
    label166:
    for (int i = 0;; i = localfd1.b)
    {
      if (l + paramLong - i > 2048L) {
        break label176;
      }
      parameo.a.a(localfd1, (int)paramLong);
      parameo.b -= paramLong;
      this.b += paramLong;
      return;
      localfd1 = null;
      break;
    }
    label176:
    parameo.a = parameo.a.a((int)paramLong);
    label189:
    fd localfd1 = parameo.a;
    long l = localfd1.c - localfd1.b;
    parameo.a = localfd1.a();
    if (this.a == null)
    {
      this.a = localfd1;
      localfd1 = this.a;
      fd localfd2 = this.a;
      fd localfd3 = this.a;
      localfd2.g = localfd3;
      localfd1.f = localfd3;
    }
    for (;;)
    {
      parameo.b -= l;
      this.b += l;
      paramLong -= l;
      break;
      this.a.g.a(localfd1).b();
    }
  }
  
  public byte b(long paramLong)
  {
    fj.a(this.b, paramLong, 1L);
    for (fd localfd = this.a;; localfd = localfd.f)
    {
      int i = localfd.c - localfd.b;
      if (paramLong < i) {
        return localfd.a[(localfd.b + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  public eo b(int paramInt)
  {
    fd localfd = e(1);
    byte[] arrayOfByte = localfd.a;
    int i = localfd.c;
    localfd.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public eo b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public eo b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    fj.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      fd localfd = e(1);
      int j = Math.min(i - paramInt1, 2048 - localfd.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localfd.a, localfd.c, j);
      paramInt1 += j;
      localfd.c = (j + localfd.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public eo c()
  {
    return this;
  }
  
  public eo c(int paramInt)
  {
    fd localfd = e(2);
    byte[] arrayOfByte = localfd.a;
    int i = localfd.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localfd.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public er c(long paramLong)
  {
    return new er(f(paramLong));
  }
  
  public void close() {}
  
  public eo d()
  {
    return this;
  }
  
  public eo d(int paramInt)
  {
    fd localfd = e(4);
    byte[] arrayOfByte = localfd.a;
    int j = localfd.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localfd.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public String d(long paramLong)
  {
    return a(paramLong, fj.a);
  }
  
  public ep e()
  {
    return this;
  }
  
  fd e(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    fd localfd2;
    fd localfd1;
    if (this.a == null)
    {
      this.a = fe.a();
      localfd2 = this.a;
      fd localfd3 = this.a;
      localfd1 = this.a;
      localfd3.g = localfd1;
      localfd2.f = localfd1;
    }
    do
    {
      return localfd1;
      localfd2 = this.a.g;
      if (localfd2.c + paramInt > 2048) {
        break;
      }
      localfd1 = localfd2;
    } while (localfd2.e);
    return localfd2.a(fe.a());
  }
  
  String e(long paramLong)
  {
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      str = d(paramLong - 1L);
      g(2L);
      return str;
    }
    String str = d(paramLong);
    g(1L);
    return str;
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof eo)) {
      return false;
    }
    paramObject = (eo)paramObject;
    if (this.b != ((eo)paramObject).b) {
      return false;
    }
    if (this.b == 0L) {
      return true;
    }
    Object localObject2 = this.a;
    paramObject = ((eo)paramObject).a;
    int j = ((fd)localObject2).b;
    int i = ((fd)paramObject).b;
    while (l1 < this.b)
    {
      long l2 = Math.min(((fd)localObject2).c - j, ((fd)paramObject).c - i);
      int k = 0;
      while (k < l2)
      {
        if (localObject2.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      k = j;
      Object localObject1 = localObject2;
      if (j == ((fd)localObject2).c)
      {
        localObject1 = ((fd)localObject2).f;
        k = ((fd)localObject1).b;
      }
      j = i;
      localObject2 = paramObject;
      if (i == ((fd)paramObject).c)
      {
        localObject2 = ((fd)paramObject).f;
        j = ((fd)localObject2).b;
      }
      l1 += l2;
      i = j;
      j = k;
      paramObject = localObject2;
      localObject2 = localObject1;
    }
    return true;
  }
  
  public boolean f()
  {
    return this.b == 0L;
  }
  
  public byte[] f(long paramLong)
  {
    fj.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }
  
  public void flush() {}
  
  public long g()
  {
    long l2 = this.b;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    fd localfd;
    do
    {
      do
      {
        return l1;
        localfd = this.a.g;
        l1 = l2;
      } while (localfd.c >= 2048);
      l1 = l2;
    } while (!localfd.e);
    return l2 - (localfd.c - localfd.b);
  }
  
  public void g(long paramLong)
  {
    while (paramLong > 0L)
    {
      if (this.a == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      long l = paramLong - i;
      fd localfd = this.a;
      localfd.b = (i + localfd.b);
      paramLong = l;
      if (this.a.b == this.a.c)
      {
        localfd = this.a;
        this.a = localfd.a();
        fe.a(localfd);
        paramLong = l;
      }
    }
  }
  
  public byte h()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    fd localfd = this.a;
    int i = localfd.b;
    int j = localfd.c;
    byte[] arrayOfByte = localfd.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localfd.a();
      fe.a(localfd);
      return b1;
    }
    localfd.b = k;
    return b1;
  }
  
  public eo h(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    fd localfd = e(j);
    byte[] arrayOfByte = localfd.a;
    int i = localfd.c + j - 1;
    int k = localfd.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localfd.c += j;
    paramLong = this.b;
    this.b = (j + paramLong);
    return this;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    fd localfd;
    do
    {
      int k = ((fd)localObject).b;
      int m = ((fd)localObject).c;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.a[k];
        k += 1;
      }
      localfd = ((fd)localObject).f;
      j = i;
      localObject = localfd;
    } while (localfd != this.a);
    return i;
  }
  
  public short i()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    fd localfd = this.a;
    int k = localfd.b;
    int i = localfd.c;
    if (i - k < 2) {
      return (short)((h() & 0xFF) << 8 | h() & 0xFF);
    }
    byte[] arrayOfByte = localfd.a;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.b -= 2L;
    if (m == i)
    {
      this.a = localfd.a();
      fe.a(localfd);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localfd.b = m;
    }
  }
  
  public int j()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    fd localfd = this.a;
    int j = localfd.b;
    int i = localfd.c;
    if (i - j < 4) {
      return (h() & 0xFF) << 24 | (h() & 0xFF) << 16 | (h() & 0xFF) << 8 | h() & 0xFF;
    }
    byte[] arrayOfByte = localfd.a;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.b -= 4L;
    if (n == i)
    {
      this.a = localfd.a();
      fe.a(localfd);
      return j;
    }
    localfd.b = n;
    return j;
  }
  
  public short k()
  {
    return fj.a(i());
  }
  
  public int l()
  {
    return fj.a(j());
  }
  
  public long m()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = ((fd)localObject).a;
    int m = ((fd)localObject).b;
    int n = ((fd)localObject).c;
    long l1 = l2;
    int k = i;
    label57:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0xF000000000000000 & l1) == 0L) {
          break label299;
        }
        localObject = new eo().h(l1).b(i1);
        throw new NumberFormatException("Number too large: " + ((eo)localObject).o());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      this.a = ((fd)localObject).a();
      fe.a((fd)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l2 = l1;
        if (this.a != null) {
          break;
        }
      }
      this.b -= k;
      return l1;
      label299:
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label57;
      ((fd)localObject).b = m;
    }
  }
  
  public er n()
  {
    return new er(q());
  }
  
  public String o()
  {
    try
    {
      String str = a(this.b, fj.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String p()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      eo localeo = new eo();
      a(localeo, 0L, Math.min(32L, this.b));
      throw new EOFException("\\n not found: size=" + b() + " content=" + localeo.n().d() + "...");
    }
    return e(l);
  }
  
  public byte[] q()
  {
    try
    {
      byte[] arrayOfByte = f(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public void r()
  {
    try
    {
      g(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public eo s()
  {
    eo localeo = new eo();
    if (this.b == 0L) {
      return localeo;
    }
    localeo.a = new fd(this.a);
    fd localfd1 = localeo.a;
    fd localfd2 = localeo.a;
    fd localfd3 = localeo.a;
    localfd2.g = localfd3;
    localfd1.f = localfd3;
    for (localfd1 = this.a.f; localfd1 != this.a; localfd1 = localfd1.f) {
      localeo.a.g.a(new fd(localfd1));
    }
    localeo.b = this.b;
    return localeo;
  }
  
  public String toString()
  {
    if (this.b == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (this.b <= 16L)
    {
      localObject = s().n();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(this.b), ((er)localObject).d() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
      for (localObject = this.a.f; localObject != this.a; localObject = ((fd)localObject).f) {
        localMessageDigest.update(((fd)localObject).a, ((fd)localObject).b, ((fd)localObject).c - ((fd)localObject).b);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(this.b), er.a(localMessageDigest.digest()).d() });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */