package com.xiaoenai.app.h.b.a;

import android.app.Activity;
import android.content.res.Resources;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.xiaoenai.app.h.b.e.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class b
  implements InMobiNative.NativeAdListener
{
  b(a parama) {}
  
  public void onAdDismissed(InMobiNative paramInMobiNative)
  {
    com.xiaoenai.app.utils.f.a.c("onAdDismissed", new Object[0]);
  }
  
  public void onAdDisplayed(InMobiNative paramInMobiNative)
  {
    com.xiaoenai.app.utils.f.a.c("onAdDisplayed", new Object[0]);
  }
  
  public void onAdLoadFailed(InMobiNative paramInMobiNative, InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    com.xiaoenai.app.utils.f.a.c("onAdLoadFailed {} {}", new Object[] { paramInMobiAdRequestStatus.getStatusCode(), paramInMobiAdRequestStatus.getMessage() });
    this.a.notifyMMUAdRequestAdFail();
  }
  
  public void onAdLoadSucceeded(InMobiNative paramInMobiNative)
  {
    com.xiaoenai.app.utils.f.a.c("onAdLoadSucceeded {}", new Object[] { paramInMobiNative.getAdContent() });
    try
    {
      Object localObject = new JSONObject((String)paramInMobiNative.getAdContent());
      com.xiaoenai.app.utils.f.a.c("content = {}", new Object[] { localObject });
      HashMap localHashMap = new HashMap();
      localHashMap.put("ration_name", "InMobi");
      localHashMap.put("title", ((JSONObject)localObject).optString("title"));
      localHashMap.put("icon_url", String.valueOf(((JSONObject)localObject).getJSONObject("icon")));
      localHashMap.put("sub_title", ((JSONObject)localObject).optString("description"));
      localHashMap.put("img_url", String.valueOf(((JSONObject)localObject).getJSONObject("screenshots")));
      localHashMap.put("rating", ((JSONObject)localObject).optString("rating"));
      localHashMap.put("click_url", ((JSONObject)localObject).optString("landingURL"));
      String str = ((JSONObject)localObject).optString("cta");
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.equals(this.a.getMMUActivity().getResources().getString(e.a.ad_click_open))) {
          localObject = "open";
        }
      }
      localHashMap.put("click_type", localObject);
      this.a.addMMUAdInfo(localHashMap, new a.a(paramInMobiNative, localHashMap));
    }
    catch (JSONException paramInMobiNative)
    {
      for (;;)
      {
        paramInMobiNative.printStackTrace();
      }
    }
    this.a.notifyMMUAdRequestAdSuccess();
  }
  
  public void onUserLeftApplication(InMobiNative paramInMobiNative)
  {
    com.xiaoenai.app.utils.f.a.c("onUserLeftApplication", new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */