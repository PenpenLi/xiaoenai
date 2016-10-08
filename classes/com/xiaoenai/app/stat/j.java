package com.xiaoenai.app.stat;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.o;

public class j
{
  public static j a;
  public static Object b = new Object();
  
  public static j a()
  {
    synchronized (b)
    {
      if (a == null) {
        a = new j();
      }
      j localj = a;
      return localj;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    StatEntry localStatEntry = new StatEntry();
    a(localStatEntry, paramContext, paramString1, paramString2);
    h.a().a(localStatEntry);
  }
  
  public void a(StatEntry paramStatEntry, Context paramContext, String paramString1, String paramString2)
  {
    paramStatEntry.setLogId(10001);
    paramStatEntry.setDeviceId(Xiaoenai.j().m());
    paramStatEntry.setUid(User.getInstance().getUserId());
    if (paramContext != null) {
      paramStatEntry.setNet(o.f(paramContext));
    }
    paramStatEntry.setInitate(UserConfig.getLong("initate_ts", 0L));
    paramStatEntry.setTimestamp(ak.b());
    if (AppModel.getInstance().isLogined()) {
      paramStatEntry.setStatus(0);
    }
    for (;;)
    {
      paramStatEntry.setRefer(paramString1);
      paramStatEntry.setPage(paramString2);
      paramStatEntry.setFollow("");
      paramStatEntry.setExpId(0);
      paramStatEntry.setEvent("");
      paramStatEntry.setExpand("");
      return;
      paramStatEntry.setStatus(2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\stat\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */