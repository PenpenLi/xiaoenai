package com.xiaoenai.app.classes.common.webview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

class c
  extends Handler
{
  c(WebViewActivity paramWebViewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = paramMessage.getData();
    paramMessage = ((Bundle)localObject).getString("ip");
    String str = ((Bundle)localObject).getString("ip_url");
    localObject = ((Bundle)localObject).getString("host");
    HashMap localHashMap = new HashMap();
    localHashMap.put("Host", localObject);
    this.a.runOnUiThread(new d(this, paramMessage, str, localHashMap));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */