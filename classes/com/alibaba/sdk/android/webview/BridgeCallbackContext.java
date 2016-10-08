package com.alibaba.sdk.android.webview;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.ui.UIContext;
import org.json.JSONException;
import org.json.JSONObject;

public class BridgeCallbackContext
{
  public int requestId;
  public WebView webView;
  
  private void callback(String paramString)
  {
    if (this.webView == null) {
      return;
    }
    this.webView.loadUrl(paramString);
  }
  
  private static String formatJsonString(String paramString)
  {
    return paramString.replace("\\", "\\\\");
  }
  
  public Activity getActivity()
  {
    return (Activity)this.webView.getContext();
  }
  
  public void onFailure(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      onFailure(localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public void onFailure(String paramString)
  {
    UIContext.executorService.postUITask(new BridgeCallbackContext.2(this, paramString));
  }
  
  public void success(String paramString)
  {
    UIContext.executorService.postUITask(new BridgeCallbackContext.1(this, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BridgeCallbackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */