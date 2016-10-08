package com.xiaoenai.app.h.b.a;

import android.view.ViewGroup;
import com.alimama.config.custom.MMUFeedCustomAdapter;
import com.alimama.listener.MMUAdInfoStateReporter;
import com.inmobi.ads.InMobiCustomNative;
import com.inmobi.ads.InMobiNative;
import com.xiaoenai.app.h.b.c.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a
  extends MMUFeedCustomAdapter
{
  public a()
  {
    com.xiaoenai.app.utils.f.a.c("InMobiFeedAdapter", new Object[0]);
  }
  
  public void startRequestAd()
  {
    com.xiaoenai.app.utils.f.a.c("startRequestAd {}", new Object[] { getAPPID() });
    try
    {
      Object localObject = new JSONObject(getAPPID());
      String str2 = ((JSONObject)localObject).getString("PLACEMENT_ID");
      String str1 = ((JSONObject)localObject).getString("ACCOUNT_ID");
      ((JSONObject)localObject).getInt("rtid");
      com.xiaoenai.app.utils.f.a.c("AdPlaceID = {}", new Object[] { str2 });
      com.xiaoenai.app.utils.f.a.c("AccountID = {}", new Object[] { str1 });
      localObject = new InMobiCustomNative(Long.valueOf(str2).longValue(), new b(this));
      c.a(getMMUActivity(), str1);
      ((InMobiNative)localObject).load();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyMMUAdRequestAdFail();
    }
  }
  
  public static class a
    implements MMUAdInfoStateReporter
  {
    private InMobiNative a;
    private ViewGroup b;
    private Map<String, String> c = new HashMap();
    private boolean d = false;
    private boolean e = false;
    
    public a(InMobiNative paramInMobiNative, HashMap<String, Object> paramHashMap)
    {
      com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter", new Object[0]);
      this.a = paramInMobiNative;
      paramInMobiNative = paramHashMap.entrySet().iterator();
      while (paramInMobiNative.hasNext())
      {
        Object localObject = (Map.Entry)paramInMobiNative.next();
        paramHashMap = (String)((Map.Entry)localObject).getKey();
        localObject = String.valueOf(((Map.Entry)localObject).getValue());
        com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter key = {} value = {}", new Object[] { paramHashMap, localObject });
        com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter key = {} value = {}", new Object[] { paramHashMap, localObject });
        this.c.put(paramHashMap, localObject);
      }
    }
    
    public void onAttachAdView(ViewGroup paramViewGroup)
    {
      com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter viewGroup = {}", new Object[] { paramViewGroup });
      this.b = paramViewGroup;
      if ((this.a != null) && (!this.d))
      {
        InMobiNative.unbind(paramViewGroup);
        InMobiNative.bind(paramViewGroup, this.a);
        this.d = true;
      }
    }
    
    public void onClickAd()
    {
      com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter onClickAd", new Object[0]);
      if ((this.a != null) && (!this.e))
      {
        this.a.reportAdClick(this.c);
        this.e = true;
      }
    }
    
    public void onDestroy()
    {
      com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter onDestroy", new Object[0]);
      InMobiNative.unbind(this.b);
      com.xiaoenai.app.utils.f.a.c("InMobiFeedReporter onDestroy", new Object[0]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */