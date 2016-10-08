package org.cocos2dx.cpp;

import org.mzd.game.GameJni;

class e
  implements Runnable
{
  e(AppActivity paramAppActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!this.c.isFinishing()) {
      GameJni.payFinish(this.a, this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */