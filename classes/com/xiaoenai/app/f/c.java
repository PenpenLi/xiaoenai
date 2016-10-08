package com.xiaoenai.app.f;

import com.d.a.a.k;
import com.xiaoenai.app.utils.b;
import java.io.File;

public class c
  extends a
{
  private boolean g = true;
  private int h;
  private String i;
  private String j;
  
  public c()
  {
    super(new k(5).a().b().a("download"));
  }
  
  public c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    super(new k(5).a().b(false).a(0L).a("download"));
    this.h = paramInt;
    this.i = paramString1;
    this.j = paramString2;
    this.d = paramString3;
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    a(this.j, "download_id", this.h, "total_size", this.e, "download_size", paramLong);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return b.a(paramString1, paramString2);
  }
  
  protected boolean a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    return j();
  }
  
  public void b() {}
  
  public void c()
  {
    if ((a(a(this.i), this.e)) && (a(this.f.getAbsolutePath(), this.d))) {
      a(this.j, "download_id", this.h, "download_key", 1);
    }
    while (!j()) {
      return;
    }
    a(this.j, "download_id", this.h, "download_key", -1);
  }
  
  protected void d()
  {
    a(this.j, "download_id", this.h, "download_key", -1);
    l();
  }
  
  protected boolean j()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally {}
  }
  
  public void k()
  {
    a(false);
    l();
  }
  
  public void l()
  {
    if (this.f.exists()) {
      this.f.delete();
    }
    File localFile = b.a(this.d);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */