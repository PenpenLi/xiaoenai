package org.cocos2dx.cpp;

import com.xiaoenai.app.model.game.GamePushInfo;
import java.util.Comparator;

class j
  implements Comparator<GamePushInfo>
{
  j(i parami) {}
  
  public int a(GamePushInfo paramGamePushInfo1, GamePushInfo paramGamePushInfo2)
  {
    if (paramGamePushInfo1.isPast().booleanValue()) {
      if (paramGamePushInfo2.isPast().booleanValue()) {
        if (paramGamePushInfo1.getPushTime() >= paramGamePushInfo2.getPushTime()) {}
      }
    }
    while ((paramGamePushInfo2.isPast().booleanValue()) || (paramGamePushInfo1.getPushTime() < paramGamePushInfo2.getPushTime()))
    {
      return -1;
      if (paramGamePushInfo1.getPushTime() > paramGamePushInfo2.getPushTime()) {
        return 1;
      }
      return 0;
      return 1;
    }
    if (paramGamePushInfo1.getPushTime() > paramGamePushInfo2.getPushTime()) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\cpp\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */