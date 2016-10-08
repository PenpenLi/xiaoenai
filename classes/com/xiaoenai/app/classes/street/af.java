package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class af
  extends m
{
  af(StreetAfterSaleLogisticsActivity paramStreetAfterSaleLogisticsActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.l_();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.l_();
    if (paramJSONObject.optBoolean("success")) {
      this.a.b(paramJSONObject.optString("data"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */