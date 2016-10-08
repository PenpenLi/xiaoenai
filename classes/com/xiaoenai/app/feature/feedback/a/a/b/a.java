package com.xiaoenai.app.feature.feedback.a.a.b;

import com.xiaoenai.app.domain.e.b;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import com.xiaoenai.app.feature.feedback.presenter.impl.FeedbackPresenterImpl;
import com.xiaoenai.app.feature.feedback.view.activity.FeedbackActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class a
{
  private final FeedbackActivity a;
  
  public a(FeedbackActivity paramFeedbackActivity)
  {
    this.a = paramFeedbackActivity;
  }
  
  @PerActivity
  @Provides
  b a(com.xiaoenai.app.data.e.b.a parama)
  {
    return parama;
  }
  
  @PerActivity
  @Provides
  com.xiaoenai.app.feature.feedback.presenter.a a(FeedbackPresenterImpl paramFeedbackPresenterImpl)
  {
    return paramFeedbackPresenterImpl;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */