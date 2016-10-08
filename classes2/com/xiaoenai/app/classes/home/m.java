package com.xiaoenai.app.classes.home;

import com.xiaoenai.app.classes.common.p;
import com.xiaoenai.app.classes.home.a.k;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class m
  implements p
{
  m(l paraml) {}
  
  public void a() {}
  
  public void a(JSONObject paramJSONObject)
  {
    k.a().b(paramJSONObject);
    AppSettings.setLong("key_last_discover_update_time", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */