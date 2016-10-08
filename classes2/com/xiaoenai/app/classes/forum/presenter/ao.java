package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import com.xiaoenai.app.classes.common.mvp.view.b;
import com.xiaoenai.app.classes.forum.b.d;
import com.xiaoenai.app.classes.forum.c.a;
import com.xiaoenai.app.model.g;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ao
  extends m
{
  ao(an paraman, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((an.e(this.a) != null) && (!an.f(this.a).k_()) && (((a)an.g(this.a)).k())) {
      this.a.a(null);
    }
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    if ((an.h(this.a) != null) && (!an.i(this.a).k_()) && (((a)an.j(this.a)).k())) {
      this.a.a(null);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (an.a(this.a) != null)
    {
      paramJSONObject = g.a(paramJSONObject);
      d.a().a(paramJSONObject);
      if (!((a)an.b(this.a)).k()) {
        break label54;
      }
      this.a.a(paramJSONObject);
    }
    label54:
    while (an.c(this.a).k_()) {
      return;
    }
    ((a)an.d(this.a)).a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */