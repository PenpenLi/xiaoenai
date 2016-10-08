package com.xiaoenai.app.classes.settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.ui.component.view.ProgressView;
import java.util.Date;

public class SettingHelpActivity
  extends TitleBarActivity
{
  private WebView a = null;
  private ProgressView b = null;
  private WebViewClient c = new ae(this);
  
  public int a()
  {
    return 2130903319;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void c()
  {
    this.b = ((ProgressView)findViewById(2131558669));
    this.a = ((WebView)findViewById(2131559739));
    this.a.getSettings().setJavaScriptEnabled(true);
    this.a.setWebViewClient(this.c);
    this.a.loadUrl("http://statics.xiaoenai.com/about/help_android_zh_3.0.html?r=" + new Date().getTime() / 1000L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingHelpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */