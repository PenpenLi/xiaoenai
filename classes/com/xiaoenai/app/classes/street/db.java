package com.xiaoenai.app.classes.street;

import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class db
  implements a.a
{
  db(StreetOrderRemindActivity paramStreetOrderRemindActivity) {}
  
  public void a()
  {
    this.a.a(null);
  }
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean)
    {
      this.a.l_();
      return;
    }
    a.c("data = {}", new Object[] { paramJSONObject });
  }
  
  public void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.a.l_();
    if (paramBoolean)
    {
      StreetOrderRemindActivity.f(this.a).setState(1);
      StreetOrderRemindActivity.a(this.a, 1);
      return;
    }
    StreetOrderRemindActivity.a(this.a, 0);
  }
  
  public void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.a.l_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */