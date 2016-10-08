package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.xiaoenai.app.classes.street.a.l;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONObject;

class dh
  extends m
{
  dh(StreetProductDetailActivity paramStreetProductDetailActivity, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    if (this.a) {
      this.b.a("");
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.b.isFinishing())
    {
      StreetProductDetailActivity.a(this.b).b();
      if (StreetProductDetailActivity.b(this.b) != null) {
        StreetProductDetailActivity.b(this.b).a();
      }
      super.a(paramInt);
      StreetProductDetailActivity.a(this.b, false);
      this.b.l_();
    }
  }
  
  public void a(k paramk)
  {
    if (!this.b.isFinishing())
    {
      StreetProductDetailActivity.a(this.b).b();
      if (StreetProductDetailActivity.b(this.b) != null) {
        StreetProductDetailActivity.b(this.b).a();
      }
      super.a(paramk);
      StreetProductDetailActivity.a(this.b, false);
      this.b.l_();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StreetProductDetailActivity.a locala;
    if (!this.b.isFinishing())
    {
      locala = new StreetProductDetailActivity.a(this.b, null);
      if (Build.VERSION.SDK_INT < 11) {
        break label60;
      }
      locala.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
    }
    for (;;)
    {
      this.b.l_();
      return;
      label60:
      locala.execute(new JSONObject[] { paramJSONObject });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */