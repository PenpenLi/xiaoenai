package com.taobao.applink.param;

import android.content.Context;
import android.util.Log;
import com.taobao.applink.exception.TBAppLinkException;
import com.taobao.applink.exception.TBAppLinkExceptionCode;
import com.taobao.applink.util.TBAppLinkStringUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TBDetailParam
  extends TBNavParam
{
  private static final String MODEL_NAME = "detail";
  private String mItemID;
  
  private TBDetailParam() {}
  
  public TBDetailParam(String paramString)
  {
    this.mParams.put("module", "detail");
    this.mItemID = paramString;
  }
  
  public boolean checkParams(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("itemId");
      if (!TBAppLinkStringUtil.isNumeric(paramJSONObject)) {
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.d("AppLink", paramJSONObject.toString());
      return false;
    }
    this.mParams.put("module", "detail");
    this.mItemID = paramJSONObject;
    return true;
  }
  
  public String getH5URL()
  {
    if (!TBAppLinkStringUtil.isNumeric(this.mItemID)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.ITEMID_ILLEGAL);
    }
    return super.getH5URL(String.format("http://h5.m.taobao.com/awp/core/detail.htm?id=%s&", new Object[] { this.mItemID }));
  }
  
  public String getJumpUrl(Context paramContext)
  {
    if (!TBAppLinkStringUtil.isNumeric(this.mItemID)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.ITEMID_ILLEGAL);
    }
    this.mExtraParams.put("itemId", this.mItemID);
    return super.getJumpUrl(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBDetailParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */