package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.widget.LinearLayout;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONObject;

class da
  extends m
{
  da(StreetOrderRemindActivity paramStreetOrderRemindActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    StreetOrderRemindActivity.m(this.a).setVisibility(4);
    StreetOrderRemindActivity.n(this.a).a();
  }
  
  public void a(int paramInt)
  {
    StreetOrderRemindActivity.n(this.a).b();
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    StreetOrderRemindActivity.n(this.a).b();
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StreetOrderRemindActivity.n(this.a).b();
    StreetOrderRemindActivity.f(this.a).parseOrder(paramJSONObject.optJSONObject("data"));
    int i = StreetOrderRemindActivity.f(this.a).getSku().getPrice();
    if ((StreetOrderRemindActivity.f(this.a).getProduct().getIsRush().booleanValue()) || (StreetOrderRemindActivity.f(this.a).getSku().getRushId() > 0)) {
      i = StreetOrderRemindActivity.f(this.a).getSku().getRushPrice();
    }
    StreetOrderRemindActivity.a(this.a, i * StreetOrderRemindActivity.f(this.a).getCount());
    StreetOrderRemindActivity.a(this.a, StreetOrderRemindActivity.b(this.a));
    StreetOrderRemindActivity.m(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */