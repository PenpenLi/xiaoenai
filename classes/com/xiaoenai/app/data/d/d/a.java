package com.xiaoenai.app.data.d.d;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.data.d.f;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import com.xiaoenai.app.data.entity.ImageResultEntity;
import javax.inject.Inject;
import rx.f.d;

public class a
  extends com.xiaoenai.app.data.d.c
{
  @Inject
  public a(Context paramContext, j paramj, m paramm, f paramf, Handler paramHandler)
  {
    super(paramContext, paramj, paramm, paramf, paramHandler);
  }
  
  private String c(String paramString)
  {
    String str = "";
    if (paramString.equals("api_type_image")) {
      str = "v2/upload/img_token";
    }
    while (!paramString.equals("api_type_voice")) {
      return str;
    }
    return "v2/upload/voice_token";
  }
  
  public rx.a<ImageResultEntity> a(String paramString1, String paramString2)
  {
    return b(paramString1).a(d.a()).a(b.a(this, paramString2));
  }
  
  protected void a(String paramString) {}
  
  public rx.a<String> b(String paramString)
  {
    this.a = this.c.a(c(paramString));
    return rx.a.a(new c(this));
  }
  
  public rx.a<ImageResultEntity> b(String paramString1, String paramString2)
  {
    return rx.a.a(new e(this, paramString1, paramString2));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */