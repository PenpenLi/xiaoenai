package com.meiqia.core;

import android.text.TextUtils;
import b.aq;
import com.meiqia.core.b.g;
import com.meiqia.core.c.a;
import java.util.Map;
import org.json.JSONObject;

class au
  implements as.b
{
  au(as paramas, as.a parama, Map paramMap) {}
  
  public void a(JSONObject paramJSONObject, aq paramaq)
  {
    boolean bool = TextUtils.equals(paramJSONObject.optString("result"), "queueing");
    if (bool) {
      this.a.a(bool, null, null, null);
    }
    for (;;)
    {
      g.b("scheduler " + this.b.get("track_id"));
      return;
      paramaq = com.meiqia.core.b.c.b(paramJSONObject.optJSONObject("agent"));
      com.meiqia.core.c.c localc = com.meiqia.core.b.c.c(paramJSONObject.optJSONObject("conv"));
      localc.a(paramaq.c());
      paramJSONObject = com.meiqia.core.b.c.a(paramJSONObject.optJSONArray("messages"));
      this.a.a(false, paramaq, localc, paramJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */