package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.view.View;
import com.xiaoenai.app.classes.street.a.e;
import com.xiaoenai.app.classes.street.model.Delivery;
import org.json.JSONObject;

class bh
  extends com.xiaoenai.app.net.m
{
  bh(StreetDeliveryActivity paramStreetDeliveryActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    Delivery localDelivery = new Delivery();
    try
    {
      localDelivery.fromJson(Delivery.class, paramJSONObject.optJSONObject("data"), localDelivery);
      StreetDeliveryActivity.a(this.a, localDelivery);
      StreetDeliveryActivity.b(this.a).a(localDelivery.getTracks());
      if ((localDelivery.getTracks() != null) && (localDelivery.getTracks().length > 0)) {
        StreetDeliveryActivity.c(this.a).setVisibility(0);
      }
      com.xiaoenai.app.utils.m.a(StreetDeliveryActivity.d(this.a));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */