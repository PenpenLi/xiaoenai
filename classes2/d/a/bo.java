package d.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class bo
  extends bs
{
  private static final bx d = new bx("");
  private static final bp f = new bp("", (byte)0, (short)0);
  private static final byte[] g = new byte[16];
  byte[] a = new byte[5];
  byte[] b = new byte[10];
  byte[] c = new byte[1];
  private az h = new az(15);
  private short i = 0;
  private bp j = null;
  private Boolean k = null;
  private final long l;
  private byte[] m = new byte[1];
  
  static
  {
    g[0] = 0;
    g[2] = 1;
    g[3] = 3;
    g[6] = 4;
    g[8] = 5;
    g[10] = 6;
    g[4] = 7;
    g[11] = 8;
    g[15] = 9;
    g[14] = 10;
    g[13] = 11;
    g[12] = 12;
  }
  
  public bo(cg paramcg, long paramLong)
  {
    super(paramcg);
    this.l = paramLong;
  }
  
  private long A()
  {
    int n = 0;
    int i2 = 0;
    long l1 = 0L;
    long l2 = l1;
    int i1;
    if (this.e.d() >= 10)
    {
      byte[] arrayOfByte = this.e.b();
      int i3 = this.e.c();
      i1 = 0;
      n = i2;
      for (;;)
      {
        i2 = arrayOfByte[(i3 + n)];
        l1 |= (i2 & 0x7F) << i1;
        if ((i2 & 0x80) != 128)
        {
          this.e.a(n + 1);
          return l1;
        }
        i1 += 7;
        n += 1;
      }
    }
    do
    {
      n += 7;
      i1 = q();
      l2 |= (i1 & 0x7F) << n;
    } while ((i1 & 0x80) == 128);
    return l2;
  }
  
  private long a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[7] & 0xFF) << 56 | (paramArrayOfByte[6] & 0xFF) << 48 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[4] & 0xFF) << 32 | (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  private void a(bp parambp, byte paramByte)
  {
    int n = paramByte;
    if (paramByte == -1) {
      n = e(parambp.b);
    }
    if ((parambp.c > this.i) && (parambp.c - this.i <= 15)) {
      d(parambp.c - this.i << 4 | n);
    }
    for (;;)
    {
      this.i = parambp.c;
      return;
      b(n);
      a(parambp.c);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    this.e.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(byte paramByte)
  {
    this.m[0] = paramByte;
    this.e.b(this.m);
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    int n = paramInt;
    paramInt = i1;
    for (;;)
    {
      if ((n & 0xFFFFFF80) == 0)
      {
        this.a[paramInt] = ((byte)n);
        this.e.b(this.a, 0, paramInt + 1);
        return;
      }
      this.a[paramInt] = ((byte)(n & 0x7F | 0x80));
      n >>>= 7;
      paramInt += 1;
    }
  }
  
  private void b(long paramLong)
  {
    int n = 0;
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        this.b[n] = ((byte)(int)paramLong);
        this.e.b(this.b, 0, n + 1);
        return;
      }
      this.b[n] = ((byte)(int)(0x7F & paramLong | 0x80));
      paramLong >>>= 7;
      n += 1;
    }
  }
  
  private int c(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  private long c(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  private boolean c(byte paramByte)
  {
    paramByte &= 0xF;
    return (paramByte == 1) || (paramByte == 2);
  }
  
  private byte d(byte paramByte)
  {
    switch ((byte)(paramByte & 0xF))
    {
    default: 
      throw new bt("don't know what type: " + (byte)(paramByte & 0xF));
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 6;
    case 5: 
      return 8;
    case 6: 
      return 10;
    case 7: 
      return 4;
    case 8: 
      return 11;
    case 9: 
      return 15;
    case 10: 
      return 14;
    case 11: 
      return 13;
    }
    return 12;
  }
  
  private long d(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void d(int paramInt)
  {
    b((byte)paramInt);
  }
  
  private byte e(byte paramByte)
  {
    return g[paramByte];
  }
  
  private byte[] e(int paramInt)
  {
    if (paramInt == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramInt];
    this.e.d(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  private void f(int paramInt)
  {
    if (paramInt < 0) {
      throw new bt("Negative length: " + paramInt);
    }
    if ((this.l != -1L) && (paramInt > this.l)) {
      throw new bt("Length exceeded max allowed: " + paramInt);
    }
  }
  
  private int g(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  private int z()
  {
    int i2 = 0;
    int n = 0;
    int i1;
    if (this.e.d() >= 5)
    {
      byte[] arrayOfByte = this.e.b();
      int i3 = this.e.c();
      i1 = 0;
      i2 = 0;
      for (;;)
      {
        int i4 = arrayOfByte[(i3 + n)];
        i2 |= (i4 & 0x7F) << i1;
        if ((i4 & 0x80) != 128)
        {
          this.e.a(n + 1);
          return i2;
        }
        i1 += 7;
        n += 1;
      }
      n += 7;
    }
    for (;;)
    {
      i2 = q();
      i1 |= (i2 & 0x7F) << n;
      if ((i2 & 0x80) == 128) {
        break;
      }
      return i1;
      i1 = 0;
      n = i2;
    }
  }
  
  public void a()
  {
    this.i = this.h.a();
  }
  
  public void a(byte paramByte)
  {
    b(paramByte);
  }
  
  protected void a(byte paramByte, int paramInt)
  {
    if (paramInt <= 14)
    {
      d(paramInt << 4 | e(paramByte));
      return;
    }
    d(e(paramByte) | 0xF0);
    b(paramInt);
  }
  
  public void a(int paramInt)
  {
    b(c(paramInt));
  }
  
  public void a(long paramLong)
  {
    b(c(paramLong));
  }
  
  public void a(bp parambp)
  {
    if (parambp.b == 2)
    {
      this.j = parambp;
      return;
    }
    a(parambp, (byte)-1);
  }
  
  public void a(bq parambq)
  {
    a(parambq.a, parambq.b);
  }
  
  public void a(br parambr)
  {
    if (parambr.c == 0)
    {
      d(0);
      return;
    }
    b(parambr.c);
    d(e(parambr.a) << 4 | e(parambr.b));
  }
  
  public void a(bx parambx)
  {
    this.h.a(this.i);
    this.i = 0;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      a(paramString, 0, paramString.length);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new be("UTF-8 not supported!");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int n = paramByteBuffer.limit();
    int i1 = paramByteBuffer.position();
    a(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), n - i1);
  }
  
  public void a(short paramShort)
  {
    b(c(paramShort));
  }
  
  public void b() {}
  
  public void c()
  {
    b((byte)0);
  }
  
  public void d() {}
  
  public void e() {}
  
  public bx f()
  {
    this.h.a(this.i);
    this.i = 0;
    return d;
  }
  
  public void g()
  {
    this.i = this.h.a();
  }
  
  public bp h()
  {
    int n = q();
    if (n == 0) {
      return f;
    }
    int i1 = (short)((n & 0xF0) >> 4);
    short s;
    bp localbp;
    if (i1 == 0)
    {
      s = r();
      localbp = new bp("", d((byte)(n & 0xF)), s);
      if (c(n)) {
        if ((byte)(n & 0xF) != 1) {
          break label104;
        }
      }
    }
    label104:
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      this.k = localBoolean;
      this.i = localbp.c;
      return localbp;
      s = (short)(i1 + this.i);
      break;
    }
  }
  
  public void i() {}
  
  public br j()
  {
    int i1 = z();
    if (i1 == 0) {}
    for (int n = 0;; n = q()) {
      return new br(d((byte)(n >> 4)), d((byte)(n & 0xF)), i1);
    }
  }
  
  public void k() {}
  
  public bq l()
  {
    byte b1 = q();
    int i1 = b1 >> 4 & 0xF;
    int n = i1;
    if (i1 == 15) {
      n = z();
    }
    return new bq(d(b1), n);
  }
  
  public void m() {}
  
  public bw n()
  {
    return new bw(l());
  }
  
  public void o() {}
  
  public boolean p()
  {
    boolean bool = true;
    if (this.k != null)
    {
      bool = this.k.booleanValue();
      this.k = null;
    }
    while (q() == 1) {
      return bool;
    }
    return false;
  }
  
  public byte q()
  {
    if (this.e.d() > 0)
    {
      byte b1 = this.e.b()[this.e.c()];
      this.e.a(1);
      return b1;
    }
    this.e.d(this.c, 0, 1);
    return this.c[0];
  }
  
  public short r()
  {
    return (short)g(z());
  }
  
  public int s()
  {
    return g(z());
  }
  
  public long t()
  {
    return d(A());
  }
  
  public double u()
  {
    byte[] arrayOfByte = new byte[8];
    this.e.d(arrayOfByte, 0, 8);
    return Double.longBitsToDouble(a(arrayOfByte));
  }
  
  public String v()
  {
    int n = z();
    f(n);
    if (n == 0) {
      return "";
    }
    try
    {
      if (this.e.d() >= n)
      {
        String str1 = new String(this.e.b(), this.e.c(), n, "UTF-8");
        this.e.a(n);
        return str1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new be("UTF-8 not supported!");
    }
    String str2 = new String(e(n), "UTF-8");
    return str2;
  }
  
  public ByteBuffer w()
  {
    int n = z();
    f(n);
    if (n == 0) {
      return ByteBuffer.wrap(new byte[0]);
    }
    byte[] arrayOfByte = new byte[n];
    this.e.d(arrayOfByte, 0, n);
    return ByteBuffer.wrap(arrayOfByte);
  }
  
  public void x()
  {
    this.h.b();
    this.i = 0;
  }
  
  public static class a
    implements bu
  {
    private final long a = -1L;
    
    public bs a(cg paramcg)
    {
      return new bo(paramcg, this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */