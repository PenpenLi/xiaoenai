package com.sina.weibo.sdk.component.view;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.WidgetRequestParam.WidgetRequestCallback;
import com.sina.weibo.sdk.utils.Utility;

class AttentionComponentView$3
  implements WidgetRequestParam.WidgetRequestCallback
{
  AttentionComponentView$3(AttentionComponentView paramAttentionComponentView) {}
  
  public void onWebViewResult(String paramString)
  {
    paramString = Utility.parseUri(paramString).getString("result");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Integer.parseInt(paramString);
        if (l == 1L)
        {
          AttentionComponentView.access$3(this.this$0, true);
          return;
        }
        if (l == 0L)
        {
          AttentionComponentView.access$3(this.this$0, false);
          return;
        }
      }
      catch (NumberFormatException paramString) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\view\AttentionComponentView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */