package com.xiaoenai.app.f;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.model.Forum.Post.a;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class e
  extends m
{
  e(d paramd, Context paramContext, Post.a[] paramArrayOfa)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    d.f(this.b).post(new h(this));
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    d.f(this.b).post(new f(this, paramJSONObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */