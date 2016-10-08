package com.xiaoenai.app.classes.chat.messagelist;

import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import java.util.Vector;

class b
  implements Runnable
{
  b(a parama, Vector paramVector) {}
  
  public void run()
  {
    Intent localIntent = new Intent("messageList_change");
    localIntent.putExtra("selection", this.a.size());
    Xiaoenai.j().sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */