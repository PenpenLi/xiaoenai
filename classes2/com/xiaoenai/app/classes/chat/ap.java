package com.xiaoenai.app.classes.chat;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.history.ChatHistoryActivity;

class ap
  implements View.OnClickListener
{
  ap(an paraman) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    FragmentActivity localFragmentActivity = this.a.getActivity();
    paramView.setClass(localFragmentActivity, ChatHistoryActivity.class);
    paramView.putExtra("from", "chat");
    localFragmentActivity.startActivity(paramView);
    localFragmentActivity.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */