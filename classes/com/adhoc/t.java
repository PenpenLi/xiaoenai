package com.adhoc;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.adhoc.adhocsdk.ExperimentFlags.a;
import com.adhoc.adhocsdk.OnAdHocReceivedData;
import java.io.IOException;
import org.json.JSONObject;

class t
  implements an
{
  t(s params, int paramInt, OnAdHocReceivedData paramOnAdHocReceivedData) {}
  
  public void a(bj parambj, IOException paramIOException)
  {
    try
    {
      fl.b("请求" + this.a + "内超时,取本地flag");
      s.a(this.c, s.b(this.c));
      s.a(this.c, this.b, s.c(this.c), s.d(this.c));
      return;
    }
    catch (Throwable parambj)
    {
      fl.a(parambj);
    }
  }
  
  public void a(bn parambn)
  {
    this.c.a = false;
    if (parambn != null) {}
    for (;;)
    {
      try
      {
        if (!parambn.d())
        {
          fl.b(parambn.e().toString());
          fl.b("请求回调获取flag失败,返回本地数据");
          s.a(this.c, s.b(this.c));
          s.a(this.c, this.b, s.c(this.c), s.d(this.c));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        String str;
        JSONObject localJSONObject1;
        fl.a(localThrowable);
        return;
        JSONObject localJSONObject2 = new JSONObject();
        fl.a("result is null :" + str);
        continue;
      }
      finally
      {
        if (parambn == null) {
          continue;
        }
        parambn.h().close();
      }
      str = parambn.h().e();
      if (str.equals("")) {
        continue;
      }
      localJSONObject1 = new JSONObject(str);
      fl.a("网络获取 listener :" + str);
      s.a(this.c, new ExperimentFlags(localJSONObject1));
      s.d(this.c).setFlagState(ExperimentFlags.a.a.toString());
      localJSONObject1 = s.a(this.c, localJSONObject1);
      q.a().a(localJSONObject1);
      AdhocTracker.incrementStat(s.a(this.c), "Event-GET_EXPERIMENT_FLAGS", 1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */