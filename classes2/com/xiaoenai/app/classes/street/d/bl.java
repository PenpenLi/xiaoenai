package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

final class bl
  extends m
{
  h a = h.a(this.b);
  
  bl(Context paramContext1, Context paramContext2, BaseActivity paramBaseActivity)
  {
    super(paramContext1);
  }
  
  public void a()
  {
    super.a();
    this.a.show();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.c != null) && (!this.c.isFinishing())) {
      this.a.hide();
    }
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    if ((this.c != null) && (!this.c.isFinishing())) {
      this.a.hide();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((this.c != null) && (!this.c.isFinishing())) {
      this.a.hide();
    }
    h.a(this.b, 2131100822, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */