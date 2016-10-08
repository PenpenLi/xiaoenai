package com.mob.tools.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class t
  extends c
{
  private StringBuilder a = new StringBuilder();
  
  public t a(String paramString)
  {
    this.a.append(paramString);
    return this;
  }
  
  protected InputStream a()
  {
    return new ByteArrayInputStream(this.a.toString().getBytes("utf-8"));
  }
  
  protected long b()
  {
    return this.a.toString().getBytes("utf-8").length;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */