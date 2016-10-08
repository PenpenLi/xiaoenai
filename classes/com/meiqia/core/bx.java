package com.meiqia.core;

import b.aq;
import org.json.JSONObject;

class bx
  implements as.b
{
  bx(ah paramah, as.h paramh) {}
  
  public void a(JSONObject paramJSONObject, aq paramaq)
  {
    paramaq = paramJSONObject.optString("audio_url");
    paramJSONObject = paramJSONObject.optString("audio_key");
    ah.a(this.b, new by(this, paramJSONObject, paramaq));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */