package com.xiaoenai.app.classes.common;

import android.view.View;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import org.json.JSONObject;

class t
  implements k.a
{
  t(q paramq) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    q.a(this.a);
    paramk = UserConfig.getString("home_inviter", null);
    try
    {
      paramk = new JSONObject(paramk).getString("lover_uid");
      q.a(this.a, paramk);
      return;
    }
    catch (Exception paramk)
    {
      paramk.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */