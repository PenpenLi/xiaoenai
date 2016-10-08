package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.RelativeLayout;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONObject;

class dt
  extends m
{
  dt(StreetProductOrderActivity paramStreetProductOrderActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.a.isFinishing())
    {
      super.a();
      StreetProductOrderActivity.m(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    StreetProductOrderActivity.a locala;
    if (!this.a.isFinishing())
    {
      StreetProductOrderActivity.m(this.a).b();
      StreetProductOrderActivity.n(this.a).setVisibility(0);
      super.a(paramInt);
      locala = new StreetProductOrderActivity.a(this.a, null);
      if (Build.VERSION.SDK_INT >= 11) {
        locala.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { new JSONObject() });
      }
    }
    else
    {
      return;
    }
    locala.execute(new JSONObject[] { new JSONObject() });
  }
  
  public void a(k paramk)
  {
    if (!this.a.isFinishing())
    {
      StreetProductOrderActivity.m(this.a).b();
      StreetProductOrderActivity.n(this.a).setVisibility(0);
      super.a(paramk);
      paramk = new StreetProductOrderActivity.a(this.a, null);
      if (Build.VERSION.SDK_INT >= 11) {
        paramk.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { new JSONObject() });
      }
    }
    else
    {
      return;
    }
    paramk.execute(new JSONObject[] { new JSONObject() });
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StreetProductOrderActivity.a locala;
    if (!this.a.isFinishing())
    {
      locala = new StreetProductOrderActivity.a(this.a, null);
      if (Build.VERSION.SDK_INT >= 11) {
        locala.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      }
    }
    else
    {
      return;
    }
    locala.execute(new JSONObject[] { paramJSONObject });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */