package com.xiaoenai.app.utils;

import com.xiaoenai.app.classes.store.ab;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

final class d
  extends Thread
{
  public void run()
  {
    super.run();
    Vector localVector = ab.a().a(100);
    Object localObject = b.a().iterator();
    int i;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      i = 0;
      while (i < localVector.size())
      {
        BaseSticker localBaseSticker = (BaseSticker)localVector.get(i);
        if (String.valueOf(localBaseSticker.getId()).equals(str))
        {
          localBaseSticker.setDownload(true);
          ab.a().a(localBaseSticker);
          localVector.remove(localBaseSticker);
        }
        i += 1;
      }
    }
    if (localVector.size() > 0)
    {
      i = 0;
      while (i < localVector.size())
      {
        localObject = (BaseSticker)localVector.get(i);
        ((BaseSticker)localObject).setDownload(false);
        ab.a().a((BaseSticker)localObject);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */