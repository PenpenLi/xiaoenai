package com.xiaoenai.app.classes.auth;

import android.content.Context;
import android.view.View;
import com.f.a.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

class q
  extends m
{
  q(SimpleLoginView paramSimpleLoginView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    SimpleLoginView.g(this.a).a(null);
  }
  
  public void a(int paramInt)
  {
    SimpleLoginView.g(this.a).l_();
    super.a(paramInt);
    SimpleLoginView.n(this.a).setEnabled(true);
    b.b(SimpleLoginView.g(this.a), "LoginFailure");
  }
  
  public void a(k paramk)
  {
    AppModel.getInstance().setUserId(paramk.c);
    SimpleLoginView.g(this.a).l_();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    SimpleLoginView.g(this.a).l_();
    paramJSONObject = a.b(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramJSONObject = new h(SimpleLoginView.g(this.a));
      paramJSONObject.a(2131100887);
      paramJSONObject.a(3000L);
      return;
    }
    SimpleLoginView.a(this.a, paramJSONObject, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */