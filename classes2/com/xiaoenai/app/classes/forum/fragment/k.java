package com.xiaoenai.app.classes.forum.fragment;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import org.json.JSONObject;

class k
  extends com.xiaoenai.app.net.m
{
  k(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    b.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new m(this, paramInt));
    super.a(paramInt);
  }
  
  public void a(com.xiaoenai.app.net.k paramk)
  {
    Xiaoenai.j().k().post(new n(this, paramk));
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new l(this, paramJSONObject));
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */