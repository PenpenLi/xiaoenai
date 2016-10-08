package com.xiaoenai.app.classes.store;

import com.xiaoenai.app.classes.common.c.a.d;
import com.xiaoenai.app.classes.common.c.a.e;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.b;
import com.xiaoenai.app.widget.remindButton.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class k
{
  private static k a = null;
  private HashMap<Integer, BaseSticker> b = new HashMap();
  
  public static k a()
  {
    try
    {
      if (a == null) {
        a = new k();
      }
      return a;
    }
    finally {}
  }
  
  private void e()
  {
    List localList = a.a().b("xiaoenai.mine.face");
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        RedHintsInfo localRedHintsInfo = (RedHintsInfo)localList.get(i);
        int j = Integer.valueOf(new e(localRedHintsInfo.getModule()).a().c).intValue();
        FaceSticker localFaceSticker = null;
        if (this.b.containsKey(Integer.valueOf(j))) {
          localFaceSticker = (FaceSticker)this.b.get(Integer.valueOf(j));
        }
        if (localFaceSticker != null) {
          localFaceSticker.setRedHintsInfo(localRedHintsInfo);
        }
        i += 1;
      }
    }
  }
  
  public BaseSticker a(int paramInt)
  {
    return (BaseSticker)this.b.get(Integer.valueOf(paramInt));
  }
  
  public void a(BaseSticker paramBaseSticker)
  {
    if (this.b.containsKey(Integer.valueOf(paramBaseSticker.getId())))
    {
      BaseSticker localBaseSticker = (BaseSticker)this.b.get(Integer.valueOf(paramBaseSticker.getId()));
      localBaseSticker.setDownload(paramBaseSticker.isDownload());
      localBaseSticker.setDownloading(paramBaseSticker.isDownloading());
      localBaseSticker.setFree(paramBaseSticker.getFree());
      localBaseSticker.setMine(paramBaseSticker.isMine());
      localBaseSticker.setNew(paramBaseSticker.isNew());
      localBaseSticker.setPurchased(paramBaseSticker.isPurchased());
      localBaseSticker.setZipUrl(paramBaseSticker.getZipUrl());
    }
  }
  
  public void a(List<BaseSticker> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      BaseSticker localBaseSticker = (BaseSticker)paramList.get(i);
      if (b.b(localBaseSticker.getName())) {
        localBaseSticker.setDownload(true);
      }
      if (!this.b.containsKey(Integer.valueOf(localBaseSticker.getId()))) {
        this.b.put(Integer.valueOf(localBaseSticker.getId()), localBaseSticker);
      }
      i += 1;
    }
    e();
  }
  
  public List<BaseSticker> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((BaseSticker)this.b.get(localIterator.next()));
    }
    b(localArrayList);
    return localArrayList;
  }
  
  public void b(BaseSticker paramBaseSticker)
  {
    if (this.b.containsKey(Integer.valueOf(paramBaseSticker.getId()))) {
      ((BaseSticker)this.b.get(Integer.valueOf(paramBaseSticker.getId()))).setNew(false);
    }
  }
  
  public void b(List<BaseSticker> paramList)
  {
    Collections.sort(paramList, new l(this));
  }
  
  public List<BaseSticker> c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      BaseSticker localBaseSticker = (BaseSticker)this.b.get(localIterator.next());
      if (localBaseSticker.isMine()) {
        localArrayList.add(localBaseSticker);
      }
    }
    b(localArrayList);
    return localArrayList;
  }
  
  public void c(BaseSticker paramBaseSticker)
  {
    if (this.b.containsKey(Integer.valueOf(paramBaseSticker.getId()))) {
      ((BaseSticker)this.b.get(Integer.valueOf(paramBaseSticker.getId()))).setDownload(paramBaseSticker.isDownload());
    }
  }
  
  public void c(List<BaseSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseSticker localBaseSticker = (BaseSticker)paramList.next();
      ab.a().a(localBaseSticker);
    }
  }
  
  public void d()
  {
    this.b.clear();
  }
  
  public void d(BaseSticker paramBaseSticker)
  {
    if (this.b.containsKey(Integer.valueOf(paramBaseSticker.getId()))) {
      ((BaseSticker)this.b.get(Integer.valueOf(paramBaseSticker.getId()))).setDownloading(paramBaseSticker.isDownloading());
    }
  }
  
  public void d(List<BaseSticker> paramList)
  {
    Iterator localIterator1 = c().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      BaseSticker localBaseSticker1 = (BaseSticker)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      if (localIterator2.hasNext())
      {
        BaseSticker localBaseSticker2 = (BaseSticker)localIterator2.next();
        if (localBaseSticker1.getId() != localBaseSticker2.getId()) {
          break;
        }
        localBaseSticker2.setMine(true);
        if (b.b(localBaseSticker2.getName())) {
          localBaseSticker2.setDownload(true);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */