package com.alibaba.sdk.android.webview;

import com.alibaba.sdk.android.ui.util.SignUtil;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SignBridge
{
  private String toSignRequest(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = JSONUtils.optString(paramString, "url");
      JSONObject localJSONObject = paramString.optJSONObject("params");
      paramString = null;
      if (localJSONObject != null)
      {
        paramString = new HashMap();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          paramString.put(str2, JSONUtils.optString(localJSONObject, str2));
        }
      }
      paramString = SignUtil.sign(str1, paramString, paramBoolean);
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
    return paramString;
  }
  
  @BridgeMethod
  public void signGet(BridgeCallbackContext paramBridgeCallbackContext, String paramString)
  {
    paramBridgeCallbackContext.success(toSignRequest(paramString, false));
  }
  
  @BridgeMethod
  public void signPost(BridgeCallbackContext paramBridgeCallbackContext, String paramString)
  {
    paramBridgeCallbackContext.success(toSignRequest(paramString, true));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\SignBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */