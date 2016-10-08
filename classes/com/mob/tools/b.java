package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;

class b
  implements Handler.Callback
{
  b(a parama) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = (Object[])paramMessage.obj;
    paramMessage = (Context)localObject[0];
    localObject = (Intent)localObject[1];
    if (!(paramMessage instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramMessage.startActivity((Intent)localObject);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */