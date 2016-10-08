package c;

import java.io.InputStream;

class f
  extends InputStream
{
  f(e parame) {}
  
  public int available()
  {
    return (int)Math.min(this.a.b, 2147483647L);
  }
  
  public void close() {}
  
  public int read()
  {
    if (this.a.b > 0L) {
      return this.a.i() & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */