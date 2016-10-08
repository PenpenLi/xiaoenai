package c;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e
  implements g, h, Cloneable
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  w a;
  long b;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ac.a(paramArrayOfByte.length, paramInt1, paramInt2);
    w localw = this.a;
    if (localw == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localw.c - localw.b);
      System.arraycopy(localw.a, localw.b, paramArrayOfByte, paramInt1, paramInt2);
      localw.b += paramInt2;
      this.b -= paramInt2;
      paramInt1 = paramInt2;
    } while (localw.b != localw.c);
    this.a = localw.a();
    x.a(localw);
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
    long l = 0L;
    int j = ((w)localObject1).c - ((w)localObject1).b;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l += j;
      Object localObject2 = ((w)localObject1).f;
      localObject1 = localObject2;
      if (localObject2 != this.a) {
        break;
      }
      return -1L;
      localObject2 = ((w)localObject1).a;
      int i = (int)(((w)localObject1).b + paramLong);
      int k = ((w)localObject1).c;
      while (i < k)
      {
        if (localObject2[i] == paramByte) {
          return l + i - ((w)localObject1).b;
        }
        i += 1;
      }
    }
  }
  
  public long a(e parame, long paramLong)
  {
    if (parame == null) {
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
    parame.a_(this, l);
    return l;
  }
  
  public long a(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramz.a(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public aa a()
  {
    return aa.b;
  }
  
  public e a(int paramInt)
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
  
  public e a(e parame, long paramLong1, long paramLong2)
  {
    if (parame == null) {
      throw new IllegalArgumentException("out == null");
    }
    ac.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    parame.b += paramLong2;
    w localw2;
    long l1;
    long l2;
    for (w localw1 = this.a;; localw1 = localw1.f)
    {
      localw2 = localw1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localw1.c - localw1.b) {
        break;
      }
      paramLong1 -= localw1.c - localw1.b;
    }
    label103:
    if (l2 > 0L)
    {
      localw1 = new w(localw2);
      localw1.b = ((int)(localw1.b + l1));
      localw1.c = Math.min(localw1.b + (int)l2, localw1.c);
      if (parame.a != null) {
        break label215;
      }
      localw1.g = localw1;
      localw1.f = localw1;
      parame.a = localw1;
    }
    for (;;)
    {
      l2 -= localw1.c - localw1.b;
      localw2 = localw2.f;
      l1 = 0L;
      break label103;
      break;
      label215:
      parame.a.g.a(localw1);
    }
  }
  
  public e a(i parami)
  {
    if (parami == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    parami.a(this);
    return this;
  }
  
  public e a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public e a(String paramString, int paramInt1, int paramInt2)
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
        w localw = e(1);
        arrayOfByte = localw.a;
        k = localw.c - paramInt1;
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
          i = paramInt1 + k - localw.c;
          localw.c += i;
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
  
  public String a(long paramLong, Charset paramCharset)
  {
    ac.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    w localw;
    String str;
    do
    {
      return paramCharset;
      localw = this.a;
      if (localw.b + paramLong > localw.c) {
        return new String(f(paramLong), paramCharset);
      }
      str = new String(localw.a, localw.b, (int)paramLong, paramCharset);
      localw.b = ((int)(localw.b + paramLong));
      this.b -= paramLong;
      paramCharset = str;
    } while (localw.b != localw.c);
    this.a = localw.a();
    x.a(localw);
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
  
  public void a_(e parame, long paramLong)
  {
    if (parame == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (parame == this) {
      throw new IllegalArgumentException("source == this");
    }
    ac.a(parame.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= parame.a.c - parame.a.b) {
        break label189;
      }
      if (this.a == null) {
        break label160;
      }
      localw1 = this.a.g;
      if ((localw1 == null) || (!localw1.e)) {
        break label176;
      }
      l = localw1.c;
      if (!localw1.d) {
        break label166;
      }
    }
    label160:
    label166:
    for (int i = 0;; i = localw1.b)
    {
      if (l + paramLong - i > 2048L) {
        break label176;
      }
      parame.a.a(localw1, (int)paramLong);
      parame.b -= paramLong;
      this.b += paramLong;
      return;
      localw1 = null;
      break;
    }
    label176:
    parame.a = parame.a.a((int)paramLong);
    label189:
    w localw1 = parame.a;
    long l = localw1.c - localw1.b;
    parame.a = localw1.a();
    if (this.a == null)
    {
      this.a = localw1;
      localw1 = this.a;
      w localw2 = this.a;
      w localw3 = this.a;
      localw2.g = localw3;
      localw1.f = localw3;
    }
    for (;;)
    {
      parame.b -= l;
      this.b += l;
      paramLong -= l;
      break;
      this.a.g.a(localw1).b();
    }
  }
  
  public byte b(long paramLong)
  {
    ac.a(this.b, paramLong, 1L);
    for (w localw = this.a;; localw = localw.f)
    {
      int i = localw.c - localw.b;
      if (paramLong < i) {
        return localw.a[(localw.b + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  public e b(int paramInt)
  {
    w localw = e(1);
    byte[] arrayOfByte = localw.a;
    int i = localw.c;
    localw.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public e b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public e b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    ac.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      w localw = e(1);
      int j = Math.min(i - paramInt1, 2048 - localw.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localw.a, localw.c, j);
      paramInt1 += j;
      localw.c = (j + localw.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public e c()
  {
    return this;
  }
  
  public e c(int paramInt)
  {
    w localw = e(2);
    byte[] arrayOfByte = localw.a;
    int i = localw.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localw.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public i c(long paramLong)
  {
    return new i(f(paramLong));
  }
  
  public void close() {}
  
  public e d()
  {
    return this;
  }
  
  public e d(int paramInt)
  {
    w localw = e(4);
    byte[] arrayOfByte = localw.a;
    int j = localw.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localw.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public String d(long paramLong)
  {
    return a(paramLong, ac.a);
  }
  
  public g e()
  {
    return this;
  }
  
  w e(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    w localw2;
    w localw1;
    if (this.a == null)
    {
      this.a = x.a();
      localw2 = this.a;
      w localw3 = this.a;
      localw1 = this.a;
      localw3.g = localw1;
      localw2.f = localw1;
    }
    do
    {
      return localw1;
      localw2 = this.a.g;
      if (localw2.c + paramInt > 2048) {
        break;
      }
      localw1 = localw2;
    } while (localw2.e);
    return localw2.a(x.a());
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
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    if (this.b != ((e)paramObject).b) {
      return false;
    }
    if (this.b == 0L) {
      return true;
    }
    Object localObject2 = this.a;
    paramObject = ((e)paramObject).a;
    int j = ((w)localObject2).b;
    int i = ((w)paramObject).b;
    while (l1 < this.b)
    {
      long l2 = Math.min(((w)localObject2).c - j, ((w)paramObject).c - i);
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
      if (j == ((w)localObject2).c)
      {
        localObject1 = ((w)localObject2).f;
        k = ((w)localObject1).b;
      }
      j = i;
      localObject2 = paramObject;
      if (i == ((w)paramObject).c)
      {
        localObject2 = ((w)paramObject).f;
        j = ((w)localObject2).b;
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
    ac.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }
  
  public void flush() {}
  
  public InputStream g()
  {
    return new f(this);
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
      w localw = this.a;
      localw.b = (i + localw.b);
      paramLong = l;
      if (this.a.b == this.a.c)
      {
        localw = this.a;
        this.a = localw.a();
        x.a(localw);
        paramLong = l;
      }
    }
  }
  
  public long h()
  {
    long l2 = this.b;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    w localw;
    do
    {
      do
      {
        return l1;
        localw = this.a.g;
        l1 = l2;
      } while (localw.c >= 2048);
      l1 = l2;
    } while (!localw.e);
    return l2 - (localw.c - localw.b);
  }
  
  public e h(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L) {
        return a("-9223372036854775808");
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L) {
              i = 1;
            }
          }
        }
      }
      int k;
      w localw;
      byte[] arrayOfByte;
      for (;;)
      {
        k = i;
        if (j != 0) {
          k = i + 1;
        }
        localw = e(k);
        arrayOfByte = localw.a;
        i = localw.c + k;
        while (paramLong != 0L)
        {
          int m = (int)(paramLong % 10L);
          i -= 1;
          arrayOfByte[i] = c[m];
          paramLong /= 10L;
        }
        i = 2;
        continue;
        if (paramLong < 1000L)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L) {
              i = 5;
            } else {
              i = 6;
            }
          }
          else if (paramLong < 10000000L)
          {
            i = 7;
          }
          else
          {
            i = 8;
            continue;
            if (paramLong < 1000000000000L)
            {
              if (paramLong < 10000000000L)
              {
                if (paramLong < 1000000000L) {
                  i = 9;
                } else {
                  i = 10;
                }
              }
              else if (paramLong < 100000000000L) {
                i = 11;
              } else {
                i = 12;
              }
            }
            else if (paramLong < 1000000000000000L)
            {
              if (paramLong < 10000000000000L) {
                i = 13;
              } else if (paramLong < 100000000000000L) {
                i = 14;
              } else {
                i = 15;
              }
            }
            else if (paramLong < 100000000000000000L)
            {
              if (paramLong < 10000000000000000L) {
                i = 16;
              } else {
                i = 17;
              }
            }
            else if (paramLong < 1000000000000000000L) {
              i = 18;
            } else {
              i = 19;
            }
          }
        }
      }
      if (j != 0) {
        arrayOfByte[(i - 1)] = 45;
      }
      localw.c += k;
      paramLong = this.b;
      this.b = (k + paramLong);
      return this;
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    w localw;
    do
    {
      int k = ((w)localObject).b;
      int m = ((w)localObject).c;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.a[k];
        k += 1;
      }
      localw = ((w)localObject).f;
      j = i;
      localObject = localw;
    } while (localw != this.a);
    return i;
  }
  
  public byte i()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    w localw = this.a;
    int i = localw.b;
    int j = localw.c;
    byte[] arrayOfByte = localw.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localw.a();
      x.a(localw);
      return b1;
    }
    localw.b = k;
    return b1;
  }
  
  public e i(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    w localw = e(j);
    byte[] arrayOfByte = localw.a;
    int i = localw.c + j - 1;
    int k = localw.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localw.c += j;
    paramLong = this.b;
    this.b = (j + paramLong);
    return this;
  }
  
  public short j()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    w localw = this.a;
    int k = localw.b;
    int i = localw.c;
    if (i - k < 2) {
      return (short)((i() & 0xFF) << 8 | i() & 0xFF);
    }
    byte[] arrayOfByte = localw.a;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.b -= 2L;
    if (m == i)
    {
      this.a = localw.a();
      x.a(localw);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localw.b = m;
    }
  }
  
  public int k()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    w localw = this.a;
    int j = localw.b;
    int i = localw.c;
    if (i - j < 4) {
      return (i() & 0xFF) << 24 | (i() & 0xFF) << 16 | (i() & 0xFF) << 8 | i() & 0xFF;
    }
    byte[] arrayOfByte = localw.a;
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
      this.a = localw.a();
      x.a(localw);
      return j;
    }
    localw.b = n;
    return j;
  }
  
  public short l()
  {
    return ac.a(j());
  }
  
  public int m()
  {
    return ac.a(k());
  }
  
  public long n()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = ((w)localObject).a;
    int m = ((w)localObject).b;
    int n = ((w)localObject).c;
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
        localObject = new e().i(l1).b(i1);
        throw new NumberFormatException("Number too large: " + ((e)localObject).p());
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
      this.a = ((w)localObject).a();
      x.a((w)localObject);
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
      ((w)localObject).b = m;
    }
  }
  
  public i o()
  {
    return new i(r());
  }
  
  public String p()
  {
    try
    {
      String str = a(this.b, ac.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String q()
  {
    long l = a((byte)10);
    if (l == -1L)
    {
      e locale = new e();
      a(locale, 0L, Math.min(32L, this.b));
      throw new EOFException("\\n not found: size=" + b() + " content=" + locale.o().d() + "...");
    }
    return e(l);
  }
  
  public byte[] r()
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
  
  public void s()
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
  
  public e t()
  {
    e locale = new e();
    if (this.b == 0L) {
      return locale;
    }
    locale.a = new w(this.a);
    w localw1 = locale.a;
    w localw2 = locale.a;
    w localw3 = locale.a;
    localw2.g = localw3;
    localw1.f = localw3;
    for (localw1 = this.a.f; localw1 != this.a; localw1 = localw1.f) {
      locale.a.g.a(new w(localw1));
    }
    locale.b = this.b;
    return locale;
  }
  
  public String toString()
  {
    if (this.b == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (this.b <= 16L)
    {
      localObject = t().o();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(this.b), ((i)localObject).d() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
      for (localObject = this.a.f; localObject != this.a; localObject = ((w)localObject).f) {
        localMessageDigest.update(((w)localObject).a, ((w)localObject).b, ((w)localObject).c - ((w)localObject).b);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(this.b), i.a(localMessageDigest.digest()).d() });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */