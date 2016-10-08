package com.xiaoenai.app.h.b.b;

import com.alimama.config.MMUAdInfo;
import com.alimama.listener.MMUFeedListener;
import com.xiaoenai.app.h.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  implements MMUFeedListener
{
  private final a a;
  
  public c(a parama)
  {
    this.a = parama;
  }
  
  public void onClicked(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("onClicked slotid = {}", new Object[] { paramString });
    if (this.a != null) {
      this.a.b(paramString);
    }
  }
  
  public void onRequestFeedAdFail(String paramString, int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("onRequestFeedAdFail slotid = {} errorCode = {}", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public void onRequestFeedAdSuccess(String paramString, List<MMUAdInfo> paramList)
  {
    com.xiaoenai.app.utils.f.a.c("onRequestFeedAdSuccess slotid = {} mmuFeedAdInfos = {}", new Object[] { paramString, paramList });
    if (this.a != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MMUAdInfo localMMUAdInfo = (MMUAdInfo)paramList.next();
        com.xiaoenai.app.utils.f.a.c("{}", new Object[] { localMMUAdInfo.getContent() });
        localArrayList.add(new d(localMMUAdInfo));
      }
      com.xiaoenai.app.utils.f.a.c("onRequestFeedAdSuccess slotid = {} AdInfo = {}", new Object[] { paramString, Integer.valueOf(localArrayList.size()) });
      this.a.a(paramString, localArrayList);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */