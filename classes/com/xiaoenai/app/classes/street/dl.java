package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class dl
  extends m
{
  dl(StreetProductOrderActivity paramStreetProductOrderActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    UserConfig.setInt("street_cart_count", paramJSONObject.optInt("date", 0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */