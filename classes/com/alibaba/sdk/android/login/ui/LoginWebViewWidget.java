package com.alibaba.sdk.android.login.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.sdk.android.login.bridge.LoginBridge;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.impl.WebResCacheManager;
import com.alibaba.sdk.android.login.utils.LoginUtils;
import com.alibaba.sdk.android.login.utils.StringUtil;
import com.alibaba.sdk.android.util.ResourceUtils;
import com.alibaba.sdk.android.webview.BridgeWebChromeClient;
import com.alibaba.sdk.android.webview.TaeWebView;
import java.util.Map;

public class LoginWebViewWidget
  extends LinearLayout
{
  private TaeWebView webView;
  
  public LoginWebViewWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(ResourceUtils.getRLayout(paramContext, "ali_sdk_login_web_view_widget"), this, true);
    this.webView = ((TaeWebView)findViewById(ResourceUtils.getRId(getContext(), "web_view")));
    this.webView.addBridgeObject("loginBridge", new LoginBridge());
    this.webView.setWebChromeClient(new BridgeWebChromeClient());
    if (LoginContext.useCache) {
      WebResCacheManager.INSTANCE.init(paramContext);
    }
    this.webView.setWebViewClient(new LoginWebViewWidget.1(this));
  }
  
  public void destroyWebView()
  {
    if (this.webView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.webView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.webView);
      }
      this.webView.removeAllViews();
      this.webView.destroy();
    }
  }
  
  public TaeWebView getWebView()
  {
    return this.webView;
  }
  
  public void loadPasswordLoginUrl()
  {
    this.webView.loadUrl(LoginContext.passwordLoginUrl);
  }
  
  public void loadQrLoginUrl(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(LoginContext.qrCodeLoginUrl);
    if ((paramMap != null) && (!StringUtil.isBlank((String)paramMap.get("domain")))) {
      localStringBuilder.append("_").append((String)paramMap.get("domain"));
    }
    if ((paramMap != null) && (!StringUtil.isBlank((String)paramMap.get("config"))))
    {
      String str = LoginUtils.urlParamsFormat((String)paramMap.get("config"));
      paramMap = str;
      if (StringUtil.isBlank(str)) {
        paramMap = "";
      }
      localStringBuilder.append(paramMap);
    }
    this.webView.loadUrl(localStringBuilder.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\LoginWebViewWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */