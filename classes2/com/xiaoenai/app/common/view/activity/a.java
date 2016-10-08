package com.xiaoenai.app.common.view.activity;

public final class a
  implements dagger.a<BaseActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
    if ((!a) && (parama2 == null)) {
      throw new AssertionError();
    }
    this.d = parama2;
  }
  
  public static dagger.a<BaseActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2)
  {
    return new a(parama, parama1, parama2);
  }
  
  public static void a(BaseActivity paramBaseActivity, javax.inject.a<com.xiaoenai.app.common.a> parama)
  {
    paramBaseActivity.p = ((com.xiaoenai.app.common.a)parama.get());
  }
  
  public static void b(BaseActivity paramBaseActivity, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama)
  {
    paramBaseActivity.q = ((com.xiaoenai.app.common.view.b.a)parama.get());
  }
  
  public static void c(BaseActivity paramBaseActivity, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama)
  {
    paramBaseActivity.r = ((com.xiaoenai.app.common.application.a.a)parama.get());
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramBaseActivity.p = ((com.xiaoenai.app.common.a)this.b.get());
    paramBaseActivity.q = ((com.xiaoenai.app.common.view.b.a)this.c.get());
    paramBaseActivity.r = ((com.xiaoenai.app.common.application.a.a)this.d.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\view\activity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */