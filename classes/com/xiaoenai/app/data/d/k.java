package com.xiaoenai.app.data.d;

import com.xiaoenai.app.data.d.a.b;
import com.xiaoenai.app.utils.f.a;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class k
  implements j
{
  private final b a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  
  @Inject
  public k(b paramb)
  {
    this.a = paramb;
    a();
  }
  
  private void a()
  {
    this.b = this.a.a("baseURL");
    this.c = this.a.a("appsURL");
    this.d = this.a.a("notificationURL");
    this.e = this.a.a("socketURL");
    this.f = this.a.a("socketURL2");
    this.g = this.a.a("forumUrl");
    this.h = this.a.a("forumImageURL");
    this.i = this.a.a("forumShareURL");
    this.j = this.a.a("imageBaseURL");
    this.k = this.a.a("authSdkUrl");
    this.l = this.a.a("messageUrl");
    this.m = this.a.a("verifyUrl");
    this.n = this.a.a("adsURL");
    this.o = this.a.a("configURL");
    this.p = this.a.a("streetURL");
    this.q = this.a.a("streetImageUploadURL");
    this.r = this.a.a("statURL");
    this.s = this.a.a("gameURL");
    this.t = this.a.a("streetGuideURL");
  }
  
  private void b()
  {
    if (this.a.a())
    {
      this.a.b();
      a.c("reload and update environment", new Object[0]);
      a();
    }
  }
  
  public String a(String paramString)
  {
    b();
    return this.b + paramString;
  }
  
  public String b(String paramString)
  {
    b();
    return this.c + paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */