package com.xiaoenai.app.classes.chat;

import android.content.res.Resources;
import android.os.Message;
import android.widget.ImageView;
import com.xiaoenai.app.utils.f.a;

class bh
  implements f.a
{
  bh(be parambe) {}
  
  public void a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (paramMessage.what == 0) {
      i = 1;
    }
    i = this.a.getResources().getIdentifier("chat_voice_amp" + i, "drawable", "com.xiaoenai.app");
    be.c(this.a).setImageResource(i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */