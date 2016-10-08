package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class as
  extends m
{
  as(StreetCommentsAvtivity paramStreetCommentsAvtivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new at(this));
    super.a();
    StreetCommentsAvtivity.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new av(this, paramInt));
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().k().post(new aw(this, paramk));
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new au(this, paramJSONObject));
    super.a(paramJSONObject);
    a.c("getEvent result:{}", new Object[] { paramJSONObject.toString() });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */