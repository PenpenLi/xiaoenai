package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.Handler;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class w
  extends m
{
  w(StreetAddressManagerActivity paramStreetAddressManagerActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new x(this));
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a.k();
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    this.a.a.k();
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new y(this, paramJSONObject));
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */