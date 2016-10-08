package org.cocos2dx.cpp;

import org.mzd.game.GameJni;

class f
  implements Runnable
{
  f(AppActivity paramAppActivity, String paramString) {}
  
  public void run()
  {
    GameJni.onNotification(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */