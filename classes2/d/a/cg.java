package d.a;

public abstract class cg
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void a(int paramInt) {}
  
  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public byte[] b()
  {
    return null;
  }
  
  public int c()
  {
    return 0;
  }
  
  public int d()
  {
    return -1;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0) {
        throw new ch("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
      }
      i += j;
    }
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */