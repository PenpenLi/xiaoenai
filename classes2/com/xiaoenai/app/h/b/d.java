package com.xiaoenai.app.h.b;

import android.view.ViewGroup;
import com.alimama.config.MMUAdInfo;
import com.xiaoenai.app.utils.f.a;

public class d
{
  private MMUAdInfo a;
  private String b = "";
  private String c = "";
  private c d;
  private c e;
  private String f = "";
  private String g = "";
  private String h = "";
  
  public d(MMUAdInfo paramMMUAdInfo)
  {
    this.a = paramMMUAdInfo;
    a.c("{}", new Object[] { paramMMUAdInfo.getContent() });
    this.d = new c();
    this.e = new c();
    String str;
    if (paramMMUAdInfo.getContent() != null)
    {
      this.b = paramMMUAdInfo.getContentValue("title");
      this.c = paramMMUAdInfo.getContentValue("sub_title");
      str = paramMMUAdInfo.getContentValue("icon_url");
      if (!str.startsWith("http")) {
        break label173;
      }
      this.d.b(str);
      str = paramMMUAdInfo.getContentValue("img_url");
      if (!str.startsWith("http")) {
        break label184;
      }
      this.e.b(str);
    }
    for (;;)
    {
      this.g = paramMMUAdInfo.getContentValue("click_type");
      this.f = paramMMUAdInfo.getContentValue("click_url");
      return;
      label173:
      this.d.a(str);
      break;
      label184:
      this.e.a(str);
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.a.attachAdView(paramViewGroup);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public c c()
  {
    return this.d;
  }
  
  public c d()
  {
    return this.e;
  }
  
  public void e()
  {
    a.c("onClickAd", new Object[0]);
    this.a.onClickAd();
  }
  
  public void f()
  {
    a.c("onDestroy", new Object[0]);
    this.a.onDestroy();
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */