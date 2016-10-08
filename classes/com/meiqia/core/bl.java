package com.meiqia.core;

import android.os.Handler;
import android.text.TextUtils;
import b.aq;
import b.g;
import com.meiqia.core.b.a;
import com.meiqia.core.b.c;
import com.meiqia.core.c.b;
import java.io.IOException;
import org.json.JSONObject;

class bl
  implements b.h
{
  bl(as paramas, com.meiqia.core.d.h paramh, as.b paramb) {}
  
  public void a(g paramg, aq paramaq)
  {
    if (this.b == null) {
      return;
    }
    if ((this.b instanceof as.c))
    {
      this.b.a(null, paramaq);
      return;
    }
    paramg = c.a(paramaq);
    String str = paramg.optString("ret");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      paramg = new JSONObject(a.b(ah.a.c(), str));
      if (!paramaq.c()) {
        break label250;
      }
      if ((paramg.has("msg")) && ("conversation not found".equals(paramg.optString("msg"))))
      {
        as.a(this.c).post(new bo(this));
        return;
      }
    }
    catch (Exception paramg)
    {
      as.a(this.c).post(new bn(this));
      return;
    }
    if (paramg.has("success"))
    {
      if ((paramg.optBoolean("success")) || (TextUtils.equals(paramg.optString("result"), "queueing")))
      {
        this.b.a(paramg, paramaq);
        return;
      }
      paramaq.b();
      int i;
      if (paramg.optBoolean("black")) {
        i = 20004;
      }
      for (paramg = "blacklist state";; paramg = "no agent online")
      {
        as.a(this.c).post(new bp(this, i, paramg));
        return;
        i = 19998;
      }
    }
    this.b.a(paramg, paramaq);
    return;
    label250:
    as.a(this.c).post(new bq(this, paramg, paramaq));
  }
  
  public void a(g paramg, IOException paramIOException)
  {
    as.a(this.c).post(new bm(this, paramIOException));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */