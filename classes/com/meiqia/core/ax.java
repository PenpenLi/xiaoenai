package com.meiqia.core;

import b.aq;
import com.meiqia.core.d.i;
import org.json.JSONObject;

class ax
  implements as.b
{
  ax(as paramas, i parami) {}
  
  public void a(JSONObject paramJSONObject, aq paramaq)
  {
    paramaq = paramJSONObject.optString("track_id");
    String str1 = paramJSONObject.optString("enterprise_id");
    String str2 = paramJSONObject.optString("browser_id");
    String str3 = paramJSONObject.optString("visit_page_id");
    String str4 = paramJSONObject.optString("visit_id");
    paramJSONObject = paramJSONObject.optString("aes_key");
    this.a.a(true, paramJSONObject, paramaq, str1, str2, str3, str4);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */