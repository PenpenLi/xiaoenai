package com.xiaoenai.app.feature.feedback.view.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.d.m;

class a
  implements View.OnClickListener
{
  a(ChatImageViewPager paramChatImageViewPager, com.xiaoenai.app.ui.a.b paramb, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (!com.xiaoenai.app.utils.d.a.a())
    {
      h.c(this.c, a.f.pv_sdcard_unmounted_tip, 1500L);
      return;
    }
    if (this.b.startsWith("http"))
    {
      com.xiaoenai.app.utils.e.b.a(this.b, new b(this));
      return;
    }
    paramView = this.b;
    if (this.b.startsWith("file://")) {
      paramView = this.b.substring(7);
    }
    if (paramView.startsWith(com.xiaoenai.app.feature.photopreview.a.a.a))
    {
      com.xiaoenai.app.utils.d.a.a(this.c, a.f.pv_photo_already_in_sdcard);
      return;
    }
    String str = m.a(this.b) + ".jpg";
    ChatImageViewPager.a(this.c, paramView, str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */