package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ah
  extends m
{
  ah(ad paramad, Context paramContext, BaseActivity paramBaseActivity)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.a != null) && (this.a.isFinishing())) {
      this.a.l_();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((this.a != null) && (this.a.isFinishing())) {
      this.a.l_();
    }
    if (ad.a(this.b) != null) {
      ad.a(this.b).onCancelOrderSuccess(ad.b(this.b));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */