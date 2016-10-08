package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import org.json.JSONObject;

class MobileRegisterActivity$3
  implements RequestListener
{
  MobileRegisterActivity$3(MobileRegisterActivity paramMobileRegisterActivity) {}
  
  public void onComplete(String paramString)
  {
    LogUtil.d(MobileRegisterActivity.access$9(), "get onComplete : " + paramString);
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      MobileRegisterActivity.access$10(this.this$0, (String)paramString.get("cfrom"));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onWeiboException(WeiboException paramWeiboException)
  {
    LogUtil.d(MobileRegisterActivity.access$9(), "get onWeiboException " + paramWeiboException.getMessage());
    str = ResourceManager.getString(this.this$0.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramWeiboException.getMessage());
      paramWeiboException = str;
      if (!TextUtils.isEmpty(localJSONObject.optString("error_description"))) {
        paramWeiboException = localJSONObject.optString("error_description");
      }
    }
    catch (Exception paramWeiboException)
    {
      for (;;)
      {
        paramWeiboException.printStackTrace();
        paramWeiboException = str;
      }
    }
    UIUtils.showToast(this.this$0.getApplicationContext(), paramWeiboException, 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\MobileRegisterActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */