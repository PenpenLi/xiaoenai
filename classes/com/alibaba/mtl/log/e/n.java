package com.alibaba.mtl.log.e;

public class n
{
  private static a a(String paramString)
  {
    a locala = null;
    int j = 0;
    int i;
    int k;
    if (paramString != null)
    {
      locala = new a(null);
      i = 0;
      while (i < 256)
      {
        locala.d[i] = i;
        i += 1;
      }
      locala.x = 0;
      locala.y = 0;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      if (j < 256) {}
      try
      {
        k = (k + (paramString.charAt(i) + locala.d[j])) % 256;
        int m = locala.d[j];
        locala.d[j] = locala.d[k];
        locala.d[k] = m;
        i = (i + 1) % paramString.length();
        j += 1;
      }
      catch (Exception paramString) {}
    }
    return locala;
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, a parama)
  {
    if ((paramArrayOfByte != null) && (parama != null))
    {
      int k = parama.x;
      int j = parama.y;
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        k = (k + 1) % 256;
        j = (j + parama.d[k]) % 256;
        int m = parama.d[k];
        parama.d[k] = parama.d[j];
        parama.d[j] = m;
        m = parama.d[k];
        int n = parama.d[j];
        int i1 = paramArrayOfByte[i];
        paramArrayOfByte[i] = ((byte)(parama.d[((m + n) % 256)] ^ i1));
        i += 1;
      }
      parama.x = k;
      parama.y = j;
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramString != null))
    {
      paramString = a(paramString);
      if (paramString != null) {
        return a(paramArrayOfByte, paramString);
      }
    }
    return null;
  }
  
  private static class a
  {
    public int[] d = new int['Ā'];
    public int x;
    public int y;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */