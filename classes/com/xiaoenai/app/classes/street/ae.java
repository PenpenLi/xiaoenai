package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.classes.street.model.DeliveryCompany;
import com.xiaoenai.app.net.m;
import org.json.JSONArray;
import org.json.JSONObject;

class ae
  extends m
{
  ae(StreetAfterSaleLogisticsActivity paramStreetAfterSaleLogisticsActivity, Context paramContext)
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
    paramJSONObject = paramJSONObject.optJSONArray("data");
    StreetAfterSaleLogisticsActivity.a(this.a, new DeliveryCompany[paramJSONObject.length()]);
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        StreetAfterSaleLogisticsActivity.e(this.a)[i] = new DeliveryCompany();
        try
        {
          StreetAfterSaleLogisticsActivity.e(this.a)[i].fromJson(DeliveryCompany.class, paramJSONObject.optJSONObject(i), StreetAfterSaleLogisticsActivity.e(this.a)[i]);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */