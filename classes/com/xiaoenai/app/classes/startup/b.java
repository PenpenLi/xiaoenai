package com.xiaoenai.app.classes.startup;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.xiaoenai.app.classes.common.c.c;
import com.xiaoenai.app.classes.common.c.f;
import com.xiaoenai.app.model.AppModel;

class b
  implements View.OnClickListener
{
  b(LauncherActivity paramLauncherActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    com.xiaoenai.app.utils.f.a.c("============= jumpAction", new Object[0]);
    if (this.a != null)
    {
      LauncherActivity.b(this.c);
      paramView = AppModel.getInstance();
      if ((paramView.isLogined()) && (paramView.getToken() != null) && (!paramView.getToken().equals("")))
      {
        new c().a(this.c, this.a, new f(), "ads");
        com.xiaoenai.app.classes.home.a.a().a(this.b, this.c, "click");
        LauncherActivity.c(this.c).setClickable(false);
      }
    }
    else
    {
      return;
    }
    LauncherActivity.d(this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\startup\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */