package com.xiaoenai.app.classes.chat.messagelist.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.GifPlayerActivity;

class e
  implements View.OnClickListener
{
  e(d paramd, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b.getContext();
    if ((localObject instanceof ChatActivity)) {
      ((ChatActivity)localObject).f();
    }
    localObject = new Intent("gifPlayerAction");
    ((Intent)localObject).putExtra("gifPath", this.a);
    ((Intent)localObject).setClass(this.b.getContext(), GifPlayerActivity.class);
    paramView.getContext().startActivity((Intent)localObject);
    ((Activity)paramView.getContext()).overridePendingTransition(2130968595, 2130968596);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */