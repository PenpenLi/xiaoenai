package com.xiaoenai.app.classes.store;

import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import java.util.Comparator;

class l
  implements Comparator<BaseSticker>
{
  l(k paramk) {}
  
  public int a(BaseSticker paramBaseSticker1, BaseSticker paramBaseSticker2)
  {
    if (paramBaseSticker1.getSort() > paramBaseSticker2.getSort()) {
      return 1;
    }
    if (paramBaseSticker1.getSort() < paramBaseSticker2.getSort()) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */