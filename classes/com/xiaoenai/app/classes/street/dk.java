package com.xiaoenai.app.classes.street;

import android.content.res.Resources;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class dk
  implements a.a
{
  dk(StreetProductOrderActivity paramStreetProductOrderActivity) {}
  
  public void a()
  {
    this.a.a(this.a.getResources().getString(2131101447));
  }
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    a.c(" data = {}", new Object[] { paramJSONObject });
    if (!this.a.isFinishing()) {
      StreetProductOrderActivity.a(this.a, paramBoolean, paramJSONObject);
    }
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
    a.c("date = {}", new Object[] { paramJSONObject });
    this.a.l_();
    StreetProductOrderActivity.a(this.a, true, paramBoolean, StreetProductOrderActivity.o(this.a));
  }
  
  public void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.a.l_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */