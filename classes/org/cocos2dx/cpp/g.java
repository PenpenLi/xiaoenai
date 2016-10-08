package org.cocos2dx.cpp;

import org.mzd.game.GameJni;

class g
  implements Runnable
{
  g(AppActivity.a parama, int paramInt) {}
  
  public void run()
  {
    GameJni.adjustTs(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */