package com.xiaoenai.app;

import android.text.TextUtils;
import com.xiaoenai.app.h.c.a.d;
import com.xiaoenai.app.model.UserConfig;

class g
  implements d
{
  g(Xiaoenai paramXiaoenai) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString)
  {
    paramString = UserConfig.getString("meiqia_client_id", null);
    if (TextUtils.isEmpty(paramString)) {
      UserConfig.setString("meiqia_client_id", paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */