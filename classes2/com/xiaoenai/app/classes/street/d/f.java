package com.xiaoenai.app.classes.street.d;

import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.street.StreetCustomerServiceActivity;
import com.xiaoenai.app.f.j.a;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class f
  implements j.a
{
  f(e parame) {}
  
  public void a() {}
  
  public void a(JSONObject paramJSONObject)
  {
    if (!e.a(this.a).isFinishing()) {
      e.a(this.a).l_();
    }
    if (paramJSONObject.optBoolean("success")) {
      ((StreetCustomerServiceActivity)e.a(this.a)).b(paramJSONObject.optString("data"));
    }
  }
  
  public void b()
  {
    if ((e.a(this.a) != null) && (!e.a(this.a).isFinishing())) {
      e.a(this.a).l_();
    }
    h.c(e.a(this.a), 2131099748, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */