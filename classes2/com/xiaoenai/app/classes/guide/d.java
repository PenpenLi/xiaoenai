package com.xiaoenai.app.classes.guide;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.model.UserConfig;

final class d
  implements View.OnClickListener
{
  d(int paramInt, RelativeLayout paramRelativeLayout, GuideBaseView paramGuideBaseView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    b.c()[this.a] = null;
    this.b.removeView(this.c);
    if (this.a == 3)
    {
      this.b.removeView(b.d());
      if (b.d() != null) {
        b.b(null);
      }
      UserConfig.setBoolean("first_in_home_connect", Boolean.valueOf(false));
    }
    for (;;)
    {
      this.c.setClickable(false);
      this.c.setOnClickListener(null);
      return;
      int i = this.a;
      b.a(this.d, this.b, i + 1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\guide\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */