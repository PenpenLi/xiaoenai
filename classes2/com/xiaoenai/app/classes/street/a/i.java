package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.os.Bundle;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.common.a.a;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import java.util.ArrayList;
import org.json.JSONObject;

class i
  extends m
{
  i(g paramg, Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (g.a(this.d) != null) {
      g.a(this.d).k();
    }
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    if (g.a(this.d) != null) {
      g.a(this.d).k();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (g.a(this.d) != null) {
      g.a(this.d).k();
    }
    paramJSONObject = Order.getOrderList(paramJSONObject.optJSONArray("data"));
    if (paramJSONObject.size() < 20) {
      g.a(this.d, false);
    }
    if (this.a > 0) {
      this.d.b(paramJSONObject, this.b);
    }
    for (;;)
    {
      Object localObject = new b();
      Bundle localBundle = new Bundle();
      localBundle.putInt("order_size_keys", paramJSONObject.size());
      ((b)localObject).a(localBundle);
      a.a().a(835L, (b)localObject);
      if (this.c == 1)
      {
        paramJSONObject = new b();
        localObject = new Bundle();
        ((Bundle)localObject).putString("street_order_op_key", "street_order_unselect_all_action");
        paramJSONObject.a((Bundle)localObject);
        a.a().a(833L, paramJSONObject);
      }
      return;
      this.d.a(paramJSONObject, this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */