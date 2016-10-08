package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class q
  extends m
{
  q(StreetAddOrEditAddressActivity paramStreetAddOrEditAddressActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new r(this));
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    if (paramInt == 90031)
    {
      h.c(this.a, 2131100678, 1500L);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    this.a.l_();
    if (paramk.b == 90031)
    {
      h.c(this.a, 2131100678, 1500L);
      return;
    }
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new s(this));
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */