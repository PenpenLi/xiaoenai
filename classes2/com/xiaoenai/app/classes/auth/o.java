package com.xiaoenai.app.classes.auth;

import android.content.Context;
import com.f.a.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

class o
  extends m
{
  o(SimpleLoginView paramSimpleLoginView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    SimpleLoginView.g(this.a).a(null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    SimpleLoginView.g(this.a).l_();
    b.b(SimpleLoginView.g(this.a), "LoginFailure");
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    AppModel.getInstance().setUserId(paramk.c);
    SimpleLoginView.g(this.a).l_();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = a.b(paramJSONObject);
    if (paramJSONObject == null) {
      return;
    }
    SimpleLoginView.a(this.a, paramJSONObject, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */