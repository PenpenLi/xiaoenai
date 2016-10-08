package com.xiaoenai.app.classes.forum.fragment;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class p
  extends m
{
  p(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new q(this));
    super.a();
    b.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new r(this, paramInt));
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().k().post(new s(this, paramk));
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a.c("data = {}", new Object[] { paramJSONObject });
    b.a(this.a, paramJSONObject, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */