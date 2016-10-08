package com.xiaoenai.app.feature.feedback.view.activity;

import com.xiaoenai.app.data.e.o;

public final class q
  implements dagger.a<FeedbackActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<o> e;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> f;
  private final javax.inject.a<com.xiaoenai.app.domain.e.c> g;
  private final javax.inject.a<com.xiaoenai.app.data.e.c> h;
  private final javax.inject.a<com.xiaoenai.app.common.a.a> i;
  private final javax.inject.a<com.xiaoenai.app.feature.feedback.presenter.a> j;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public q(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.domain.e.c> parama5, javax.inject.a<com.xiaoenai.app.data.e.c> parama6, javax.inject.a<com.xiaoenai.app.common.a.a> parama7, javax.inject.a<com.xiaoenai.app.feature.feedback.presenter.a> parama8)
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
    if ((!a) && (parama3 == null)) {
      throw new AssertionError();
    }
    this.e = parama3;
    if ((!a) && (parama4 == null)) {
      throw new AssertionError();
    }
    this.f = parama4;
    if ((!a) && (parama5 == null)) {
      throw new AssertionError();
    }
    this.g = parama5;
    if ((!a) && (parama6 == null)) {
      throw new AssertionError();
    }
    this.h = parama6;
    if ((!a) && (parama7 == null)) {
      throw new AssertionError();
    }
    this.i = parama7;
    if ((!a) && (parama8 == null)) {
      throw new AssertionError();
    }
    this.j = parama8;
  }
  
  public static dagger.a<FeedbackActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.domain.e.c> parama5, javax.inject.a<com.xiaoenai.app.data.e.c> parama6, javax.inject.a<com.xiaoenai.app.common.a.a> parama7, javax.inject.a<com.xiaoenai.app.feature.feedback.presenter.a> parama8)
  {
    return new q(parama, parama1, parama2, parama3, parama4, parama5, parama6, parama7, parama8);
  }
  
  public void a(FeedbackActivity paramFeedbackActivity)
  {
    if (paramFeedbackActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.view.activity.a.a(paramFeedbackActivity, this.b);
    com.xiaoenai.app.common.view.activity.a.b(paramFeedbackActivity, this.c);
    com.xiaoenai.app.common.view.activity.a.c(paramFeedbackActivity, this.d);
    com.xiaoenai.app.common.view.activity.c.a(paramFeedbackActivity, this.e);
    com.xiaoenai.app.common.view.activity.c.b(paramFeedbackActivity, this.f);
    paramFeedbackActivity.e = ((com.xiaoenai.app.domain.e.c)this.g.get());
    paramFeedbackActivity.f = ((com.xiaoenai.app.data.e.c)this.h.get());
    paramFeedbackActivity.g = ((com.xiaoenai.app.common.a.a)this.i.get());
    paramFeedbackActivity.h = ((com.xiaoenai.app.feature.feedback.presenter.a)this.j.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */