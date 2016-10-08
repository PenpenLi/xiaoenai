package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import com.xiaoenai.app.classes.street.widget.StreetSceneView;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class bq
  extends m
{
  bq(bo parambo, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((bo.a(this.a) != null) && (bo.a(this.a).getContext() != null) && (!((Activity)bo.a(this.a).getContext()).isFinishing()) && (paramJSONObject != null) && (paramJSONObject.optBoolean("success"))) {
      bo.a(this.a).b(paramJSONObject.optInt("data"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */