package com.xiaoenai.app.classes.gameCenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import java.io.File;

public class WebGameActivity
  extends TitleBarActivity
  implements com.xiaoenai.app.classes.common.o
{
  public static final Integer a = Integer.valueOf(0);
  public static final Integer b = Integer.valueOf(1);
  WebChromeClient c = new m(this);
  private ProgressView i = null;
  private WebView j = null;
  private RelativeLayout k = null;
  private String l = null;
  private String m = null;
  private Boolean n = Boolean.valueOf(false);
  private Boolean o = Boolean.valueOf(true);
  private WebViewClient s = new k(this, "WebGameActivity");
  
  private void c()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)getResources().getDrawable(2130838790);
    this.g.b(localAnimationDrawable, null);
    this.g.setRightButtonEnable(false);
    this.g.post(new l(this, localAnimationDrawable));
    this.i.setVisibility(0);
  }
  
  private void c(WebView paramWebView, String paramString)
  {
    Object localObject = al.a(paramString.substring(paramString.lastIndexOf("?") + 1, paramString.length()));
    a.c("params={}", new Object[] { ((Bundle)localObject).toString() });
    paramString = ((Bundle)localObject).getString("appkey");
    localObject = ((Bundle)localObject).getString("appsig");
    int i1 = User.getInstance().getUserId();
    paramWebView.loadUrl(Xiaoenai.h + "v1/gameapi/access_token?" + "user_id=" + i1 + "&appkey=" + paramString + "&appsig=" + (String)localObject);
  }
  
  private void d()
  {
    this.g.b(null, getString(2131101025));
    this.g.setRightButtonEnable(true);
    this.i.setVisibility(8);
  }
  
  private void d(WebView paramWebView, String paramString)
  {
    paramWebView = al.a(paramString.substring(paramString.lastIndexOf("?") + 1, paramString.length()));
    a.c("params={}", new Object[] { paramWebView.toString() });
    paramWebView.getInt("code");
    paramWebView = paramWebView.getString("message");
    if ((paramWebView != null) && (!paramWebView.equals(""))) {
      h.c(this, paramWebView, 1500L);
    }
  }
  
  private void f()
  {
    g localg = new g(this);
    localg.a(String.format(getString(2131100341), new Object[] { this.m }));
    localg.a(2131100898, new n(this));
    localg.b(2131099973, new o(this));
  }
  
  public int a()
  {
    return 2130903229;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    a.c("onReceivedError = {}", new Object[] { Integer.valueOf(paramInt) });
    a.c("description = {}", new Object[] { paramString1 });
    a.c("failingUrl = {}", new Object[] { paramString2 });
    paramWebView.setVisibility(4);
    d();
    h.c(this, paramString1, 1500L);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    c();
  }
  
  public void a(StatEntry paramStatEntry)
  {
    paramStatEntry.setExpand(this.l);
  }
  
  protected void b()
  {
    super.b();
    this.g.setTitle(this.m);
    this.g.setLeftButtonClickListener(new i(this));
    if (this.f == 1) {
      this.g.a(2130839001, 0);
    }
    for (;;)
    {
      this.g.setRightButtonClickListener(new j(this));
      if (!this.o.booleanValue()) {
        break;
      }
      this.g.setRightButtonVisible(0);
      return;
      this.g.a(2130839000, 2131100339);
    }
    this.g.setRightButtonVisible(8);
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    d();
    if (paramString.contains("xiaoenaiapi")) {
      d(paramWebView, paramString);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.l = localIntent.getStringExtra("url");
    this.l = com.xiaoenai.app.net.c.a.l.c(this.l);
    this.m = localIntent.getStringExtra("title");
    this.n = Boolean.valueOf(localIntent.getBooleanExtra("need_confirm", false));
    this.o = Boolean.valueOf(localIntent.getBooleanExtra("has_refresh_button", true));
    this.f = localIntent.getIntExtra("back_anim", 2);
    super.onCreate(paramBundle);
    this.j = new WebView(this);
    this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.j.setWebChromeClient(this.c);
    this.j.setWebViewClient(this.s);
    this.j.setScrollBarStyle(0);
    this.j.getSettings().setDefaultTextEncodingName("utf-8");
    this.j.loadUrl(this.l);
    this.k = ((RelativeLayout)findViewById(2131559364));
    this.k.addView(this.j);
    this.i = ((ProgressView)findViewById(2131559336));
    c();
    paramBundle = this.j.getSettings();
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setDomStorageEnabled(true);
    paramBundle.setAppCacheMaxSize(8388608L);
    paramBundle.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
    paramBundle.setAllowFileAccess(true);
    paramBundle.setAppCacheEnabled(true);
    paramBundle.setCacheMode(-1);
    c.a().a(118);
    c.a().b(504);
  }
  
  protected void onDestroy()
  {
    if (this.k != null)
    {
      this.k.removeView(this.j);
      this.k.removeAllViews();
      this.k = null;
    }
    if (this.j != null)
    {
      this.j.destroyDrawingCache();
      this.j.stopLoading();
      this.j.removeAllViews();
      this.j.clearHistory();
      this.j.freeMemory();
      this.j.destroy();
      this.j = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.j.loadUrl("javascript:applicationClientDidEnterBackground()");
  }
  
  protected void onResume()
  {
    if (getRequestedOrientation() != 1) {
      setRequestedOrientation(1);
    }
    super.onResume();
    this.j.loadUrl("javascript:applicationClientWillEnterForeground()");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\WebGameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */