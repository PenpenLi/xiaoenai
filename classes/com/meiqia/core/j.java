package com.meiqia.core;

import org.json.JSONObject;

class j
  implements as.e
{
  j(ah paramah, as.g paramg) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("status");
    if (("closed".equals(paramJSONObject)) || ("processed".equals(paramJSONObject)))
    {
      this.a.b();
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */