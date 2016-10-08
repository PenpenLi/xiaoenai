package com.xiaoenai.app.classes.common.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.at;
import com.xiaoenai.app.classes.common.share.p;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends WebViewClient
{
  public String b;
  
  public w()
  {
    this.b = "";
  }
  
  public w(String paramString)
  {
    this.b = paramString;
  }
  
  private void a(WebView paramWebView, ShareInfo paramShareInfo, String paramString)
  {
    new p().a(paramShareInfo, Xiaoenai.j().getString(2131099955), paramWebView.getContext(), new at(paramWebView, paramString), paramWebView, paramString);
  }
  
  private void a(WebView paramWebView, String paramString)
  {
    ShareInfo localShareInfo = null;
    Object localObject1 = al.b(paramString);
    paramString = ((Bundle)localObject1).getString("params");
    if (!ae.a(paramString)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        str7 = ((JSONObject)localObject1).optString("title");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          str6 = ((JSONObject)localObject1).optString("content");
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            String str7;
            Object localObject2;
            paramString = null;
            str1 = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            String str6 = null;
          }
        }
        try
        {
          str5 = ((JSONObject)localObject1).optString("image_url");
        }
        catch (JSONException localJSONException3)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          str4 = null;
          str5 = null;
          break label247;
        }
        try
        {
          str4 = ((JSONObject)localObject1).optString("short_content");
        }
        catch (JSONException localJSONException4)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          str4 = null;
          break label247;
        }
        try
        {
          str3 = ((JSONObject)localObject1).optString("thumb_image_url");
        }
        catch (JSONException localJSONException5)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          break label247;
        }
        try
        {
          str2 = ((JSONObject)localObject1).optString("share_url");
        }
        catch (JSONException localJSONException6)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          break label247;
        }
        try
        {
          str1 = ((JSONObject)localObject1).optString("redirect_url");
        }
        catch (JSONException localJSONException7)
        {
          paramString = null;
          str1 = null;
          break label247;
        }
        try
        {
          paramString = ((JSONObject)localObject1).optString("show");
        }
        catch (JSONException localJSONException8)
        {
          paramString = null;
          break label247;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).optString("share_id");
          if ((str7 != null) && (str6 != null) && (str5 != null) && (str4 != null) && (str3 != null))
          {
            localShareInfo = new ShareInfo();
            localShareInfo.a(str7);
            localShareInfo.b(str6);
            localShareInfo.c(str5);
            localShareInfo.d(str4);
            localShareInfo.e(str3);
            localShareInfo.f(str2);
            localShareInfo.g(str1);
            localShareInfo.b(4);
            if ((paramString != null) && (!paramString.equals(""))) {
              localShareInfo.a(paramString.split(","));
            }
            a(paramWebView, localShareInfo, (String)localObject1);
          }
          return;
        }
        catch (JSONException localJSONException9)
        {
          break label247;
        }
        localJSONException1 = localJSONException1;
        paramString = null;
        str1 = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
        str7 = null;
      }
      label247:
      localObject2 = localShareInfo;
      continue;
      str7 = ((Bundle)localObject2).getString("title");
      str6 = ((Bundle)localObject2).getString("content");
      str5 = ((Bundle)localObject2).getString("image_url");
      str4 = ((Bundle)localObject2).getString("short_content");
      str3 = ((Bundle)localObject2).getString("thumb_image_url");
      str2 = ((Bundle)localObject2).getString("share_url");
      str1 = ((Bundle)localObject2).getString("redirect_url");
      paramString = ((Bundle)localObject2).getString("show");
      localObject2 = ((Bundle)localObject2).getString("share_id");
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    a.c("url = {}", new Object[] { paramString });
    if ((paramString.contains("xiaoenaisdk")) && (paramString.contains("share")))
    {
      a(paramWebView, paramString);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */