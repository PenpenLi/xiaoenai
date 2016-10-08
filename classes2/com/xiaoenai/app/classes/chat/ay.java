package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.common.dialog.e;

class ay
  implements View.OnClickListener
{
  ay(av paramav, e parame, a parama) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((av.a(this.c) instanceof ChatActivity)) {
      ((ChatActivity)av.a(this.c)).a(((PhotoMessage)this.b).x(), ((PhotoMessage)this.b).u(), ((PhotoMessage)this.b).v());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */