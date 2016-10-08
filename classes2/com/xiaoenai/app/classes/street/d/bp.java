package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import com.xiaoenai.app.classes.street.widget.StreetSceneView;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class bp
  extends m
{
  bp(bo parambo, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    bo.a(this.d, false);
    if ((bo.a(this.d) != null) && (bo.a(this.d).getContext() != null) && (!((Activity)bo.a(this.d).getContext()).isFinishing())) {
      bo.a(this.d).b();
    }
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    if ((bo.a(this.d) != null) && (bo.a(this.d).getContext() != null) && (!((Activity)bo.a(this.d).getContext()).isFinishing())) {
      bo.a(this.d).b();
    }
    bo.a(this.d, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    bo localbo;
    JSONObject localJSONObject;
    if ((bo.a(this.d) != null) && (bo.a(this.d).getContext() != null) && (!((Activity)bo.a(this.d).getContext()).isFinishing()))
    {
      bo.a(this.d).b();
      bo.a(this.d, false);
      if ((paramJSONObject != null) && (paramJSONObject.optBoolean("success")) && (paramJSONObject.optJSONObject("data") != null))
      {
        localbo = this.d;
        localJSONObject = paramJSONObject.optJSONObject("data");
        if (this.a <= 0) {
          break label157;
        }
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      localbo.a(localJSONObject, bool, this.b, this.c);
      if (this.a == 0) {
        bo.a(this.d).a(paramJSONObject.optJSONObject("data"), this.b, this.c);
      }
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */