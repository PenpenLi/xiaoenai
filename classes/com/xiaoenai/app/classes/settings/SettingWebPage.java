package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.widget.TitleBarView;

public class SettingWebPage
  extends TitleBarActivity
{
  private String a = "com.xiaoenai.setting";
  private RelativeLayout b = null;
  private WebView c = null;
  private String i = null;
  private String j = null;
  private ProgressView k = null;
  
  public int a()
  {
    return 2130903309;
  }
  
  protected void b()
  {
    super.b();
    this.g.a(2130839000, 2131099689);
    if (this.i != null) {
      this.g.a(this.i, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str = localIntent.getAction();
    if (this.a.equals(str))
    {
      this.i = localIntent.getStringExtra("title");
      this.j = localIntent.getStringExtra("url");
    }
    if (getIntent().getIntExtra("from", 0) == 1) {
      this.d = false;
    }
    super.onCreate(paramBundle);
    this.b = ((RelativeLayout)findViewById(2131559697));
    this.k = ((ProgressView)findViewById(2131558669));
    this.c = new WebView(this);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.c.setScrollBarStyle(0);
    this.c.getSettings().setDefaultTextEncodingName("utf-8");
    this.c.getSettings().setJavaScriptEnabled(true);
    this.c.getSettings().setDomStorageEnabled(true);
    this.c.getSettings().setUseWideViewPort(true);
    this.c.getSettings().setLoadWithOverviewMode(true);
    if (this.j != null) {
      this.c.loadUrl(this.j);
    }
    this.c.setWebViewClient(new ao(this));
    this.b.addView(this.c);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.stopLoading();
      this.c.removeAllViews();
      this.c.clearHistory();
      this.c.clearCache(true);
      this.c.destroy();
      this.c = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      r();
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingWebPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */