package c;

import java.io.IOException;
import java.io.InputStream;

class v
  extends InputStream
{
  v(u paramu) {}
  
  public int available()
  {
    if (u.a(this.a)) {
      throw new IOException("closed");
    }
    return (int)Math.min(this.a.a.b, 2147483647L);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public int read()
  {
    if (u.a(this.a)) {
      throw new IOException("closed");
    }
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 2048L) == -1L)) {
      return -1;
    }
    return this.a.a.i() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (u.a(this.a)) {
      throw new IOException("closed");
    }
    ac.a(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.a.a.b == 0L) && (this.a.b.a(this.a.a, 2048L) == -1L)) {
      return -1;
    }
    return this.a.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a + ".inputStream()";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */