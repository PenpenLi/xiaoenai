package d.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class bn
  extends bs
{
  private static final bx f = new bx();
  protected boolean a = false;
  protected boolean b = true;
  protected int c;
  protected boolean d = false;
  private byte[] g = new byte[1];
  private byte[] h = new byte[2];
  private byte[] i = new byte[4];
  private byte[] j = new byte[8];
  private byte[] k = new byte[1];
  private byte[] l = new byte[2];
  private byte[] m = new byte[4];
  private byte[] n = new byte[8];
  
  public bn(cg paramcg, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramcg);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d(paramInt2);
    return this.e.d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void a() {}
  
  public void a(byte paramByte)
  {
    this.g[0] = paramByte;
    this.e.b(this.g, 0, 1);
  }
  
  public void a(int paramInt)
  {
    this.i[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.i[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.i[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.i[3] = ((byte)(paramInt & 0xFF));
    this.e.b(this.i, 0, 4);
  }
  
  public void a(long paramLong)
  {
    this.j[0] = ((byte)(int)(paramLong >> 56 & 0xFF));
    this.j[1] = ((byte)(int)(paramLong >> 48 & 0xFF));
    this.j[2] = ((byte)(int)(paramLong >> 40 & 0xFF));
    this.j[3] = ((byte)(int)(paramLong >> 32 & 0xFF));
    this.j[4] = ((byte)(int)(paramLong >> 24 & 0xFF));
    this.j[5] = ((byte)(int)(paramLong >> 16 & 0xFF));
    this.j[6] = ((byte)(int)(paramLong >> 8 & 0xFF));
    this.j[7] = ((byte)(int)(0xFF & paramLong));
    this.e.b(this.j, 0, 8);
  }
  
  public void a(bp parambp)
  {
    a(parambp.b);
    a(parambp.c);
  }
  
  public void a(bq parambq)
  {
    a(parambq.a);
    a(parambq.b);
  }
  
  public void a(br parambr)
  {
    a(parambr.a);
    a(parambr.b);
    a(parambr.c);
  }
  
  public void a(bx parambx) {}
  
  public void a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      a(paramString.length);
      this.e.b(paramString, 0, paramString.length);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new be("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit() - paramByteBuffer.position();
    a(i1);
    this.e.b(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1);
  }
  
  public void a(short paramShort)
  {
    this.h[0] = ((byte)(paramShort >> 8 & 0xFF));
    this.h[1] = ((byte)(paramShort & 0xFF));
    this.e.b(this.h, 0, 2);
  }
  
  public String b(int paramInt)
  {
    try
    {
      d(paramInt);
      Object localObject = new byte[paramInt];
      this.e.d((byte[])localObject, 0, paramInt);
      localObject = new String((byte[])localObject, "UTF-8");
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new be("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void b() {}
  
  public void c()
  {
    a((byte)0);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
    this.d = true;
  }
  
  public void d() {}
  
  protected void d(int paramInt)
  {
    if (paramInt < 0) {
      throw new bt("Negative length: " + paramInt);
    }
    if (this.d)
    {
      this.c -= paramInt;
      if (this.c < 0) {
        throw new bt("Message length exceeded: " + paramInt);
      }
    }
  }
  
  public void e() {}
  
  public bx f()
  {
    return f;
  }
  
  public void g() {}
  
  public bp h()
  {
    byte b1 = q();
    if (b1 == 0) {}
    for (short s = 0;; s = r()) {
      return new bp("", b1, s);
    }
  }
  
  public void i() {}
  
  public br j()
  {
    return new br(q(), q(), s());
  }
  
  public void k() {}
  
  public bq l()
  {
    return new bq(q(), s());
  }
  
  public void m() {}
  
  public bw n()
  {
    return new bw(q(), s());
  }
  
  public void o() {}
  
  public boolean p()
  {
    return q() == 1;
  }
  
  public byte q()
  {
    if (this.e.d() >= 1)
    {
      byte b1 = this.e.b()[this.e.c()];
      this.e.a(1);
      return b1;
    }
    a(this.k, 0, 1);
    return this.k[0];
  }
  
  public short r()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.l;
    if (this.e.d() >= 2)
    {
      arrayOfByte = this.e.b();
      i1 = this.e.c();
      this.e.a(2);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      return (short)(arrayOfByte[(i1 + 1)] & 0xFF | (i2 & 0xFF) << 8);
      a(this.l, 0, 2);
    }
  }
  
  public int s()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.m;
    if (this.e.d() >= 4)
    {
      arrayOfByte = this.e.b();
      i1 = this.e.c();
      this.e.a(4);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      int i3 = arrayOfByte[(i1 + 1)];
      int i4 = arrayOfByte[(i1 + 2)];
      return arrayOfByte[(i1 + 3)] & 0xFF | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 8;
      a(this.m, 0, 4);
    }
  }
  
  public long t()
  {
    int i1 = 0;
    byte[] arrayOfByte = this.n;
    if (this.e.d() >= 8)
    {
      arrayOfByte = this.e.b();
      i1 = this.e.c();
      this.e.a(8);
    }
    for (;;)
    {
      long l1 = arrayOfByte[i1] & 0xFF;
      long l2 = arrayOfByte[(i1 + 1)] & 0xFF;
      long l3 = arrayOfByte[(i1 + 2)] & 0xFF;
      long l4 = arrayOfByte[(i1 + 3)] & 0xFF;
      long l5 = arrayOfByte[(i1 + 4)] & 0xFF;
      long l6 = arrayOfByte[(i1 + 5)] & 0xFF;
      long l7 = arrayOfByte[(i1 + 6)] & 0xFF;
      return arrayOfByte[(i1 + 7)] & 0xFF | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8;
      a(this.n, 0, 8);
    }
  }
  
  public double u()
  {
    return Double.longBitsToDouble(t());
  }
  
  public String v()
  {
    int i1 = s();
    if (this.e.d() >= i1) {
      try
      {
        String str = new String(this.e.b(), this.e.c(), i1, "UTF-8");
        this.e.a(i1);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new be("JVM DOES NOT SUPPORT UTF-8");
      }
    }
    return b(i1);
  }
  
  public ByteBuffer w()
  {
    int i1 = s();
    d(i1);
    if (this.e.d() >= i1)
    {
      localObject = ByteBuffer.wrap(this.e.b(), this.e.c(), i1);
      this.e.a(i1);
      return (ByteBuffer)localObject;
    }
    Object localObject = new byte[i1];
    this.e.d((byte[])localObject, 0, i1);
    return ByteBuffer.wrap((byte[])localObject);
  }
  
  public static class a
    implements bu
  {
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    
    public a()
    {
      this(false, true);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this(paramBoolean1, paramBoolean2, 0);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramInt;
    }
    
    public bs a(cg paramcg)
    {
      paramcg = new bn(paramcg, this.a, this.b);
      if (this.c != 0) {
        paramcg.c(this.c);
      }
      return paramcg;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */