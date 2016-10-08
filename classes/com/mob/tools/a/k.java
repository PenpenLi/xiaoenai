package com.mob.tools.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class k
  extends InputStream
{
  private ArrayList<InputStream> a = new ArrayList();
  private int b;
  
  private boolean a()
  {
    return (this.a == null) || (this.a.size() <= 0);
  }
  
  public void a(InputStream paramInputStream)
  {
    this.a.add(paramInputStream);
  }
  
  public int available()
  {
    if (a()) {
      return 0;
    }
    return ((InputStream)this.a.get(this.b)).available();
  }
  
  public void close()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((InputStream)localIterator.next()).close();
    }
  }
  
  public int read()
  {
    int j;
    if (a())
    {
      j = -1;
      return j;
    }
    for (int i = ((InputStream)this.a.get(this.b)).read();; i = ((InputStream)this.a.get(this.b)).read())
    {
      j = i;
      if (i >= 0) {
        break;
      }
      this.b += 1;
      j = i;
      if (this.b >= this.a.size()) {
        break;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j;
    if (a())
    {
      j = -1;
      return j;
    }
    for (int i = ((InputStream)this.a.get(this.b)).read(paramArrayOfByte, paramInt1, paramInt2);; i = ((InputStream)this.a.get(this.b)).read(paramArrayOfByte, paramInt1, paramInt2))
    {
      j = i;
      if (i >= 0) {
        break;
      }
      this.b += 1;
      j = i;
      if (this.b >= this.a.size()) {
        break;
      }
    }
  }
  
  public long skip(long paramLong)
  {
    throw new IOException();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */