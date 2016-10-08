package com.xiaoenai.app.classes.guide;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.model.UserConfig;

final class c
  implements View.OnClickListener
{
  c(RelativeLayout paramRelativeLayout, GuideBaseView paramGuideBaseView) {}
  
  public void onClick(View paramView)
  {
    b.a = null;
    this.a.removeView(this.b);
    UserConfig.setBoolean("first_in_home_single", Boolean.valueOf(false));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\guide\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */