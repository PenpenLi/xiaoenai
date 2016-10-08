package com.xiaoenai.app.classes.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;

class b
  implements View.OnClickListener
{
  b(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    BaseTask.doTaskAction(5, 1, this.a);
    paramView = this.a.getPackageName();
    try
    {
      this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramView)));
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + paramView)));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */