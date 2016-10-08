package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.xiaoenai.app.classes.street.d.i;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ct
  extends m
{
  ct(StreetOrderDetailActivity paramStreetOrderDetailActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    StreetOrderDetailActivity.g(this.a).a.k();
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    StreetOrderDetailActivity.g(this.a).a.k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StreetOrderDetailActivity.e(this.a);
    StreetOrderDetailActivity.a(this.a).parseOrder(paramJSONObject.optJSONObject("data"));
    StreetOrderDetailActivity.f(this.a).a();
    StreetOrderDetailActivity.g(this.a).a.k();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */