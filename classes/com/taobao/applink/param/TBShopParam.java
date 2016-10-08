package com.taobao.applink.param;

import android.content.Context;
import android.util.Log;
import com.taobao.applink.exception.TBAppLinkException;
import com.taobao.applink.exception.TBAppLinkExceptionCode;
import com.taobao.applink.util.TBAppLinkStringUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TBShopParam
  extends TBNavParam
{
  private static final String MODEL_NAME = "shop";
  private String mShopID;
  
  private TBShopParam() {}
  
  public TBShopParam(String paramString)
  {
    this.mParams.put("module", "shop");
    this.mShopID = paramString;
  }
  
  public boolean checkParams(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("shopId");
      if (!TBAppLinkStringUtil.isNumeric(paramJSONObject)) {
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.d("AppLink", paramJSONObject.toString());
      return false;
    }
    this.mParams.put("module", "shop");
    this.mShopID = paramJSONObject;
    return true;
  }
  
  public String getH5URL()
  {
    if (!TBAppLinkStringUtil.isNumeric(this.mShopID)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.SHOPID_ILLEGAL);
    }
    return super.getH5URL(String.format("http://shop.m.taobao.com/shop/shopIndex.htm?shop_id=%s&", new Object[] { this.mShopID }));
  }
  
  public String getJumpUrl(Context paramContext)
  {
    if (!TBAppLinkStringUtil.isNumeric(this.mShopID)) {
      throw new TBAppLinkException(TBAppLinkExceptionCode.SHOPID_ILLEGAL);
    }
    this.mExtraParams.put("shopId", this.mShopID);
    return super.getJumpUrl(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBShopParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */