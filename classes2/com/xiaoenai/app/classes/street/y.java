package com.xiaoenai.app.classes.street;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.street.a.a;
import com.xiaoenai.app.classes.street.model.Contact;
import java.util.ArrayList;
import org.json.JSONObject;

class y
  implements Runnable
{
  y(w paramw, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.b.a.a.k();
    if (this.a.optBoolean("success"))
    {
      ArrayList localArrayList = Contact.getContactList(this.a.optJSONArray("data"));
      this.b.a.b.a(localArrayList);
      StreetAddressManagerActivity.a(this.b.a, this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */