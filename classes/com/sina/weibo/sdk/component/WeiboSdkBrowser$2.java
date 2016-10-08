package com.sina.weibo.sdk.component;

import android.view.View;
import android.view.View.OnClickListener;

class WeiboSdkBrowser$2
  implements View.OnClickListener
{
  WeiboSdkBrowser$2(WeiboSdkBrowser paramWeiboSdkBrowser) {}
  
  public void onClick(View paramView)
  {
    if (WeiboSdkBrowser.access$10(this.this$0) != null) {
      WeiboSdkBrowser.access$10(this.this$0).execRequest(this.this$0, 3);
    }
    this.this$0.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboSdkBrowser$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */