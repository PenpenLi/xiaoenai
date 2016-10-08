package com.xiaoenai.app.feature.feedback.view.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.feature.feedback.b.e;
import com.xiaoenai.app.ui.a.b;
import com.xiaoenai.app.utils.d.a;

class m
  implements View.OnClickListener
{
  m(FeedbackActivity paramFeedbackActivity, c paramc, b paramb) {}
  
  public void onClick(View paramView)
  {
    a.a(this.c, ((e)this.a).i());
    a.a(this.c, a.f.fb_copy_success);
    this.b.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */