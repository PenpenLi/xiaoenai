package com.xiaoenai.app.f;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class k
  extends m
{
  k(j paramj, Context paramContext, ImageInfo[] paramArrayOfImageInfo)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    j.g(this.b).post(new n(this));
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    j.g(this.b).post(new l(this, paramJSONObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */