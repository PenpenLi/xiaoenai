package com.xiaoenai.app.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.gameCenter.GameItemActivity;

class e
  implements View.OnClickListener
{
  e(AutoViewPager.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(AutoViewPager.b(this.b.a), GameItemActivity.class);
    paramView.putExtra("game_id", AutoViewPager.a(this.b.a, this.a));
    AutoViewPager.b(this.b.a).startActivity(paramView);
    ((Activity)AutoViewPager.b(this.b.a)).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */