package com.taobao.applink.param;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.applink.TBAppLinkParam;
import com.taobao.applink.TBAppLinkSDK;
import com.taobao.applink.api.TBAPIType;
import com.taobao.applink.auth.TBAppLinkAuthListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TBAuthParam
  extends TBBaseParam
{
  public static final String ACTION_NAME = "ali.open.auth";
  private static final String MODEL_NAME = "auth";
  private String mRedirectUri;
  
  private TBAuthParam()
  {
    super(TBAPIType.AUTH);
  }
  
  public TBAuthParam(TBAppLinkAuthListener paramTBAppLinkAuthListener)
  {
    super(TBAPIType.AUTH);
    this.mListener = paramTBAppLinkAuthListener;
    this.mParams.put("action", "ali.open.auth");
    this.mParams.put("module", "auth");
  }
  
  public boolean checkParams(JSONObject paramJSONObject)
  {
    this.mParams.put("action", "ali.open.auth");
    this.mParams.put("module", "auth");
    return true;
  }
  
  public String getH5URL()
  {
    if (TBAppLinkSDK.getInstance().sOpenParam == null) {
      return null;
    }
    String str1;
    if (TextUtils.isEmpty(TBAppLinkSDK.getInstance().sOpenParam.mAppkey))
    {
      str1 = "";
      if (!TextUtils.isEmpty(this.mRedirectUri)) {
        break label73;
      }
    }
    label73:
    for (String str2 = "";; str2 = this.mRedirectUri)
    {
      return String.format("http://oauth.m.taobao.com/authorize?response_type=code&client_id=%s&redirect_uri=%s&view=wap", new Object[] { str1, str2 });
      str1 = TBAppLinkSDK.getInstance().sOpenParam.mAppkey;
      break;
    }
  }
  
  public String getJumpUrl(Context paramContext)
  {
    return super.getJumpUrl(paramContext);
  }
  
  public void setParams(JSONObject paramJSONObject)
  {
    try
    {
      this.mRedirectUri = paramJSONObject.getString("redirect_uri");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public TBBaseParam setRedirectUri(String paramString)
  {
    this.mRedirectUri = paramString;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBAuthParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */