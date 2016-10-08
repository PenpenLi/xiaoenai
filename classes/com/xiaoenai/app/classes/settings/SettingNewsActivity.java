package com.xiaoenai.app.classes.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Date;

public class SettingNewsActivity
  extends TitleBarActivity
{
  private WebView a = null;
  private ProgressView b = null;
  private WebViewClient c = new af(this);
  
  public int a()
  {
    return 2130903319;
  }
  
  protected void b()
  {
    super.b();
    this.g.setTitle(2131101119);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void c()
  {
    this.b = ((ProgressView)findViewById(2131558669));
    this.a = ((WebView)findViewById(2131559739));
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.setWebViewClient(this.c);
    this.a.loadUrl("http://statics.xiaoenai.com/about/notification_iphone.html?r=" + new Date().getTime() / 1000L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    UserConfig.setBoolean("has_news", Boolean.valueOf(false));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.canGoBack())
      {
        this.a.goBack();
        return true;
      }
      finish();
      overridePendingTransition(2130968606, 2130968607);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingNewsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */