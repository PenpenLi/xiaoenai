package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class aj
  extends m
{
  aj(ad paramad, Context paramContext1, BaseActivity paramBaseActivity, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.a != null) && (this.a.isFinishing())) {
      this.a.l_();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((this.a != null) && (this.a.isFinishing())) {
      this.a.l_();
    }
    if (paramJSONObject.optBoolean("success"))
    {
      if (ad.a(this.c) != null) {
        ad.a(this.c).onConfirmSuccess(ad.b(this.c));
      }
      return;
    }
    h.c(this.b, 2131100732, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */