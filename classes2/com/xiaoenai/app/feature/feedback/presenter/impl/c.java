package com.xiaoenai.app.feature.feedback.presenter.impl;

import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.domain.e.e;

public final class c
  implements dagger.internal.b<FeedbackPresenterImpl>
{
  private final javax.inject.a<com.xiaoenai.app.feature.feedback.b.a.a> b;
  private final javax.inject.a<com.xiaoenai.app.domain.e.b> c;
  private final javax.inject.a<e> d;
  private final javax.inject.a<o> e;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(javax.inject.a<com.xiaoenai.app.feature.feedback.b.a.a> parama, javax.inject.a<com.xiaoenai.app.domain.e.b> parama1, javax.inject.a<e> parama2, javax.inject.a<o> parama3)
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
  }
  
  public static dagger.internal.b<FeedbackPresenterImpl> a(javax.inject.a<com.xiaoenai.app.feature.feedback.b.a.a> parama, javax.inject.a<com.xiaoenai.app.domain.e.b> parama1, javax.inject.a<e> parama2, javax.inject.a<o> parama3)
  {
    return new c(parama, parama1, parama2, parama3);
  }
  
  public FeedbackPresenterImpl a()
  {
    return new FeedbackPresenterImpl((com.xiaoenai.app.feature.feedback.b.a.a)this.b.get(), (com.xiaoenai.app.domain.e.b)this.c.get(), (e)this.d.get(), (o)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\presenter\impl\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */