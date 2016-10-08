package com.xiaoenai.app.classes.home.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Handler;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.as;

class p
  implements DialogInterface.OnDismissListener
{
  p(o paramo) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    User.getInstance();
    if (User.isSingle())
    {
      as.a();
      return;
    }
    paramDialogInterface = new Intent(this.a.b.getContext(), ChatActivity.class);
    this.a.b.getContext().startActivity(paramDialogInterface);
    ((Activity)this.a.b.getContext()).overridePendingTransition(2130968608, 2130968609);
    ContentView.e(this.a.b).post(new q(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */