package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class bf
  extends m
{
  bf(be parambe, Context paramContext, BaseActivity paramBaseActivity)
  {
    super(paramContext);
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
    paramJSONObject = paramJSONObject.optString("data");
    if ((this.a != null) && (this.a.isFinishing())) {
      this.a.l_();
    }
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      ba.a(this.b.b, this.b.a, paramJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */