package com.xiaoenai.app.common.application.a;

import android.content.res.Configuration;
import com.xiaoenai.app.common.application.a.a.b;
import com.xiaoenai.app.utils.f.a;
import dagger.internal.d;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class c
  implements b
{
  private b a;
  
  @Inject
  public c(b paramb)
  {
    a.c("ApplicationProxy Inject {}", new Object[] { this });
    d.a(paramb);
    this.a = paramb;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.a.a(paramConfiguration);
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void b()
  {
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\application\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */