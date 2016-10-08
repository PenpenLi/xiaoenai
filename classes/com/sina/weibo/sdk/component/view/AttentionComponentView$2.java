package com.sina.weibo.sdk.component.view;

import android.os.Handler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

class AttentionComponentView$2
  implements RequestListener
{
  AttentionComponentView$2(AttentionComponentView paramAttentionComponentView) {}
  
  public void onComplete(String paramString)
  {
    LogUtil.d(AttentionComponentView.access$1(), "json : " + paramString);
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("target");
      this.this$0.getHandler().post(new AttentionComponentView.2.1(this, paramString));
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void onWeiboException(WeiboException paramWeiboException)
  {
    LogUtil.d(AttentionComponentView.access$1(), "error : " + paramWeiboException.getMessage());
    AttentionComponentView.access$2(this.this$0, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\view\AttentionComponentView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */