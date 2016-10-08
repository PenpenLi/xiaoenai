package com.xiaoenai.app.classes.home.a;

import android.support.v4.app.FragmentActivity;
import com.xiaoenai.app.classes.common.p;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class g
  implements p
{
  g(f paramf) {}
  
  public void a()
  {
    if ((this.a.a.getActivity() != null) && (!this.a.a.getActivity().isFinishing()) && (this.a.a.isAdded())) {
      a.a(this.a.a, k.a().b());
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    k.a().b(paramJSONObject);
    AppSettings.setLong("key_last_discover_update_time", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */