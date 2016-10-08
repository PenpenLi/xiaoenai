package com.xiaoenai.app.classes.gameCenter;

import android.content.Context;
import android.widget.LinearLayout;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONObject;

class c
  extends m
{
  c(GameItemActivity paramGameItemActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    GameItemActivity.a(this.a).a();
    GameItemActivity.b(this.a).setVisibility(4);
    super.a();
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing()) {
      GameItemActivity.a(this.a).b();
    }
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    if (!this.a.isFinishing()) {
      GameItemActivity.a(this.a).b();
    }
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.a.isFinishing())
    {
      super.a(paramJSONObject);
      GameItemActivity.a(this.a, paramJSONObject);
      GameItemActivity.a(this.a).b();
      GameItemActivity.b(this.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */