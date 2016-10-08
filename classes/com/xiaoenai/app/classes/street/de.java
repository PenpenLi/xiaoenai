package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class de
  extends m
{
  de(StreetOrderReviewsActivity paramStreetOrderReviewsActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    StreetOrderReviewsActivity.d(this.a);
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */