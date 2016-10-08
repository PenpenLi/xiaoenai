package com.xiaoenai.app.classes.common.webview;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.xiaoenai.app.ui.component.view.webview.XeaWebView;
import com.xiaoenai.app.ui.component.view.webview.a;

class m
  extends a
{
  m(WebViewActivity paramWebViewActivity, View paramView1, ViewGroup paramViewGroup, View paramView2, XeaWebView paramXeaWebView)
  {
    super(paramView1, paramViewGroup, paramView2, paramXeaWebView);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WebViewActivity.e(this.a).a(paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.c(paramString);
    super.onReceivedTitle(paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */