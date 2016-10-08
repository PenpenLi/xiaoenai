package com.mob.tools.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class b
  extends c
{
  private File a;
  
  protected InputStream a()
  {
    return new FileInputStream(this.a);
  }
  
  public void a(String paramString)
  {
    this.a = new File(paramString);
  }
  
  protected long b()
  {
    return this.a.length();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */