package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.net.c.a.l;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.WebViewInsideViewPager;
import java.io.File;

public class StreetWebPageActivity
  extends StreetBaseActivity
{
  WebChromeClient a = new dz(this);
  private RelativeLayout b = null;
  private WebView c = null;
  private String i = "";
  private String j = "";
  private String k = "";
  private ProgressView l = null;
  private boolean m = true;
  private String n = null;
  private WebViewClient o = new dy(this, "StreetWebPageActivity");
  
  private void c()
  {
    this.c = new WebViewInsideViewPager(this);
    this.c.setWebChromeClient(this.a);
    this.c.setWebViewClient(this.o);
    this.c.setScrollBarStyle(0);
    this.c.getSettings().setDefaultTextEncodingName("utf-8");
    this.c.getSettings().setBuiltInZoomControls(true);
    WebSettings localWebSettings = this.c.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheMaxSize(8388608L);
    localWebSettings.setAppCachePath(getApplicationContext().getDir("cache", 0).getPath());
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
    localWebSettings.setBuiltInZoomControls(true);
    if (Build.VERSION.SDK_INT >= 11) {
      localWebSettings.setDisplayZoomControls(false);
    }
    this.b = ((RelativeLayout)findViewById(2131559364));
    this.b.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    this.l = ((ProgressView)findViewById(2131559336));
    if ((this.i != null) && (this.i.length() > 0))
    {
      this.i = l.c(this.i);
      this.c.loadUrl(this.i);
    }
    while ((this.j == null) || (this.j.length() <= 0)) {
      return;
    }
    this.c.loadData(this.j, "text/html; charset=UTF-8", null);
  }
  
  private void d()
  {
    if ((this.n != null) && (this.n.length() > 0) && (HomeActivity.class.getName().equals(this.n)))
    {
      this.g.a(2130839001, 0);
      this.g.setRightButtonVisible(0);
    }
    for (;;)
    {
      this.g.setLeftButtonClickListener(new dw(this));
      this.g.setRightButtonClickListener(new dx(this));
      return;
      this.g.setRightButtonVisible(8);
    }
  }
  
  public int a()
  {
    return 2130903285;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.n = paramBundle.getStringExtra("from");
      this.i = paramBundle.getStringExtra("url");
      this.j = paramBundle.getStringExtra("html");
      this.k = paramBundle.getStringExtra("title");
      this.g.setTitle(this.k);
      a.c("url = {}", new Object[] { this.i });
      a.c("title = {}", new Object[] { this.k });
    }
    c();
    d();
  }
  
  protected void onDestroy()
  {
    if (this.b != null)
    {
      this.b.removeView(this.c);
      this.b.removeAllViews();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.destroyDrawingCache();
      this.c.stopLoading();
      this.c.removeAllViews();
      this.c.clearHistory();
      this.c.freeMemory();
      this.c.destroy();
      this.c = null;
    }
    super.onDestroy();
  }
  
  public void r()
  {
    if ((this.n != null) && (this.n.length() > 0) && (HomeActivity.class.getName().equals(this.n))) {
      this.f = 1;
    }
    super.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetWebPageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */