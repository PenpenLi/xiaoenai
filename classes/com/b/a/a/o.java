package com.b.a.a;

import java.io.File;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class o
  extends h
{
  private long a;
  private boolean b;
  
  public void a(HttpUriRequest paramHttpUriRequest)
  {
    if ((this.file.exists()) && (this.file.canWrite())) {
      this.a = this.file.length();
    }
    if (this.a > 0L)
    {
      this.b = true;
      paramHttpUriRequest.setHeader("Range", "bytes=" + this.a + "-");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */