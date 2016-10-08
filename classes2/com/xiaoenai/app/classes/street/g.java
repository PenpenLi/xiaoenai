package com.xiaoenai.app.classes.street;

import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class g
  implements Runnable
{
  g(e parame, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.b.e.l_();
    if (this.a.optBoolean("success"))
    {
      int i = StreetAddOrEditAddressActivity.i(this.b.e).getId();
      if (this.a.optJSONObject("data") != null) {
        i = this.a.optJSONObject("data").optInt("contact_id");
      }
      Contact localContact = new Contact(i, this.b.a, this.b.b, this.b.c, this.b.d, StreetAddOrEditAddressActivity.i(this.b.e).getDefault());
      StreetAddOrEditAddressActivity.a(this.b.e, localContact);
      return;
    }
    h.c(this.b.b(), this.a.optString("error"), 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */