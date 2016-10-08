package com.xiaoenai.app.classes.chat.messagelist;

import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;

final class g
  implements Runnable
{
  public void run()
  {
    Intent localIntent = new Intent("messageList_change");
    Xiaoenai.j().sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */