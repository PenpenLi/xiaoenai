package com.xiaoenai.app.classes.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.history.ChatHistoryActivity;

class aw
  implements View.OnClickListener
{
  aw(av paramav) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(av.a(this.a), ChatHistoryActivity.class);
    av.a(this.a).startActivity(paramView);
    ((ChatActivity)av.a(this.a)).overridePendingTransition(2130968608, 2130968609);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */