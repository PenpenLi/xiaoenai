package com.taobao.applink.param;

import android.content.Context;
import android.util.Log;
import com.taobao.applink.exception.TBAppLinkException;
import com.taobao.applink.exception.TBAppLinkExceptionCode;
import com.taobao.applink.util.TBAppLinkStringUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TBURIParam
  extends TBNavParam
{
  private static final String MODEL_NAME = "h5";
  private String mUrl;
  
  private TBURIParam() {}
  
  public TBURIParam(String paramString)
  {
    this.mParams.put("module", "h5");
    this.mUrl = paramString;
  }
  
  public boolean checkParams(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("h5Url");
      if (!TBAppLinkStringUtil.isURL(paramJSONObject)) {
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.d("AppLink", paramJSONObject.toString());
      return false;
    }
    this.mParams.put("module", "h5");
    this.mUrl = paramJSONObject;
    return true;
  }
  
  public String getH5URL()
  {
    if (!TBAppLinkStringUtil.isURL(this.mUrl)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.H5URL_ILLEGAL);
    }
    return super.getH5URL(this.mUrl);
  }
  
  public String getJumpUrl(Context paramContext)
  {
    if (!TBAppLinkStringUtil.isURL(this.mUrl)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.H5URL_ILLEGAL);
    }
    this.mParams.put("h5Url", this.mUrl);
    return super.getJumpUrl(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBURIParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */