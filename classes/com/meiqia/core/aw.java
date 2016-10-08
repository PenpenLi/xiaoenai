package com.meiqia.core;

import b.aq;
import com.meiqia.core.b.c;
import com.meiqia.core.b.i;
import com.meiqia.core.d.k;
import java.util.Collections;
import org.json.JSONObject;

class aw
  implements as.b
{
  aw(as paramas, k paramk) {}
  
  public void a(JSONObject paramJSONObject, aq paramaq)
  {
    paramJSONObject = c.a(paramJSONObject.optJSONArray("replies"));
    Collections.sort(paramJSONObject, new i());
    this.a.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */