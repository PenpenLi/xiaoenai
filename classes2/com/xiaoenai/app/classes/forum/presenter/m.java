package com.xiaoenai.app.classes.forum.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.k;
import com.xiaoenai.app.classes.settings.SettingFeedbackActivity;

class m
  implements View.OnClickListener
{
  m(h paramh) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(h.a(this.a), SettingFeedbackActivity.class);
    paramView.putExtra("from", "forum");
    h.a(this.a).startActivity(paramView);
    h.a(this.a).overridePendingTransition(2130968604, 2130968605);
    h.c(this.a).dismiss();
    h.a(this.a).finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */