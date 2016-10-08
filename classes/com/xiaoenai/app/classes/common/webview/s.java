package com.xiaoenai.app.classes.common.webview;

import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import com.xiaoenai.app.classes.common.share.at;
import com.xiaoenai.app.utils.as;
import java.util.HashMap;

class s
  extends at
{
  s(WebViewActivity paramWebViewActivity, WebView paramWebView, String paramString)
  {
    super(paramWebView, paramString);
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    super.onCancel(paramPlatform, paramInt);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    super.onComplete(paramPlatform, paramInt, paramHashMap);
    as.b(2131101258);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    super.onError(paramPlatform, paramInt, paramThrowable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */