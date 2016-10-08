package com.xiaoenai.app.feature.feedback.view.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.ui.a.b;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;

class n
  implements View.OnClickListener
{
  n(FeedbackActivity paramFeedbackActivity, c paramc, b paramb) {}
  
  public void onClick(View paramView)
  {
    paramView = new g(this.c);
    paramView.a(a.f.fb_delete_make_sure);
    paramView.d(k.j);
    paramView.a(a.f.delete, o.a(this, this.a));
    paramView.b(a.f.cancel, p.a());
    paramView.show();
    this.b.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */