package com.sina.weibo.sdk.register.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import org.json.JSONObject;

class MobileRegisterActivity$4
  implements RequestListener
{
  MobileRegisterActivity$4(MobileRegisterActivity paramMobileRegisterActivity, String paramString) {}
  
  public void onComplete(String paramString)
  {
    this.this$0.dismiss();
    LogUtil.d(MobileRegisterActivity.access$9(), "get onComplete : " + paramString);
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("uid", paramString.optString("uid"));
      localBundle.putString("phone_num", this.val$phoneNum);
      localBundle.putString("access_token", paramString.optString("oauth_token"));
      localBundle.putString("expires_in", paramString.optString("expires"));
      localIntent.putExtras(localBundle);
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
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
    MobileRegisterActivity.access$11(this.this$0).setVisibility(0);
    MobileRegisterActivity.access$11(this.this$0).setText(paramWeiboException);
    this.this$0.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\MobileRegisterActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */