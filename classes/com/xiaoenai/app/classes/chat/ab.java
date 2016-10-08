package com.xiaoenai.app.classes.chat;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ab
  implements View.OnClickListener
{
  ab(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ChatConnectionFailedActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */