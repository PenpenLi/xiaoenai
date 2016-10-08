package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class e
  extends m
{
  e(StreetAddOrEditAddressActivity paramStreetAddOrEditAddressActivity, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new f(this));
    super.a();
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new h(this));
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().k().post(new i(this));
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new g(this, paramJSONObject));
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */