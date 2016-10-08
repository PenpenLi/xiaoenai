package com.alimama.mobile.sdk.shell;

import com.alimama.mobile.sdk.config.system.AppUtil;
import com.alimama.mobile.sdk.config.system.MMLog;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class DownloadingService$1
  implements Runnable
{
  DownloadingService$1(DownloadingService paramDownloadingService, String paramString) {}
  
  public void run()
  {
    HttpResponse localHttpResponse = AppUtil.httpGet(this.this$0.toActionUrl(this.val$slot_id));
    if (localHttpResponse == null) {}
    for (;;)
    {
      return;
      Object localObject = null;
      try
      {
        if (localHttpResponse.getEntity() != null) {
          localObject = EntityUtils.toString(localHttpResponse.getEntity(), AppUtil.parseCharset(AppUtil.convertHeaders(localHttpResponse.getAllHeaders())));
        }
        localObject = new JSONObject((String)localObject).optJSONArray("plugins");
        if (localObject != null)
        {
          this.this$0.updateSDK(((JSONArray)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        MMLog.e(localException, "", new Object[0]);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\DownloadingService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */