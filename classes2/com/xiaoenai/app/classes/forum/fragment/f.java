package com.xiaoenai.app.classes.forum.fragment;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class f
  extends m
{
  f(b paramb, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a) {
      Xiaoenai.j().k().post(new g(this));
    }
    super.a();
    b.a(this.b, true);
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new i(this, paramInt));
    a.c("====================getEvent errCode:{}", new Object[] { Integer.valueOf(paramInt) });
    com.xiaoenai.app.ui.a.h.a(this.b.getActivity(), 2131100382, 1500L);
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().k().post(new j(this, paramk));
    a.c("==============getEvent ErrCode:{}", new Object[] { Integer.valueOf(paramk.b) });
    a.c("==============getEvent ErrString:{}", new Object[] { paramk.d });
    com.xiaoenai.app.ui.a.h.a(this.b.getActivity(), 2131100382, 1500L);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new h(this, paramJSONObject));
    super.a(paramJSONObject);
    a.c("getEvent result:{}", new Object[] { paramJSONObject.toString() });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */