package com.xiaoenai.app.feature.feedback.presenter.impl;

import com.xiaoenai.app.feature.feedback.view.a;
import rx.k;

class b
  extends k<Integer>
{
  b(FeedbackPresenterImpl paramFeedbackPresenterImpl) {}
  
  public void a()
  {
    FeedbackPresenterImpl.a(this.a);
    c();
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() > 0)
    {
      FeedbackPresenterImpl.c(this.a).e();
      FeedbackPresenterImpl.b(this.a);
      return;
    }
    this.a.q();
  }
  
  public void a(Throwable paramThrowable)
  {
    FeedbackPresenterImpl.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\presenter\impl\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */