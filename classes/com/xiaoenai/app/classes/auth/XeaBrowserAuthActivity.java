package com.xiaoenai.app.classes.auth;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.widget.TitleBarView;

public class XeaBrowserAuthActivity
  extends TitleBarActivity
  implements SimpleLoginView.a
{
  private WebView a;
  private b b;
  private String c;
  
  private void f()
  {
    this.g.setLeftButtonClickListener(new aq(this));
    this.g.setRightButtonClickListener(new ar(this));
    this.a = ((WebView)findViewById(2131558741));
  }
  
  public int a()
  {
    return 2130903087;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void f_() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringExtra("game_redirect_url");
      this.c = getIntent().getStringExtra("app_key");
      this.b = new b(this.a, this, new ao(this), new ap(this, this), this.c);
      this.b.a(paramBundle);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\XeaBrowserAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */