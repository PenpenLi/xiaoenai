package com.sina.weibo.sdk.component.view;

import org.json.JSONObject;

class AttentionComponentView$2$1
  implements Runnable
{
  AttentionComponentView$2$1(AttentionComponentView.2 param2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.val$target != null) {
      AttentionComponentView.access$3(AttentionComponentView.2.access$0(this.this$1), this.val$target.optBoolean("followed_by", false));
    }
    AttentionComponentView.access$2(AttentionComponentView.2.access$0(this.this$1), false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\view\AttentionComponentView$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */