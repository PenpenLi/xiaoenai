package com.xiaoenai.app.feature.feedback.a.a.b;

import com.xiaoenai.app.feature.feedback.presenter.impl.FeedbackPresenterImpl;
import dagger.internal.d;

public final class b
  implements dagger.internal.b<com.xiaoenai.app.feature.feedback.presenter.a>
{
  private final a b;
  private final javax.inject.a<FeedbackPresenterImpl> c;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(a parama, javax.inject.a<FeedbackPresenterImpl> parama1)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
  }
  
  public static dagger.internal.b<com.xiaoenai.app.feature.feedback.presenter.a> a(a parama, javax.inject.a<FeedbackPresenterImpl> parama1)
  {
    return new b(parama, parama1);
  }
  
  public com.xiaoenai.app.feature.feedback.presenter.a a()
  {
    return (com.xiaoenai.app.feature.feedback.presenter.a)d.a(this.b.a((FeedbackPresenterImpl)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\a\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */