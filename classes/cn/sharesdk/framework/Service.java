package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.b.c;
import com.mob.tools.b.e;
import java.util.HashMap;

public abstract class Service
{
  private Context a;
  private String b;
  
  void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String getAppKey()
  {
    return this.b;
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public String getDeviceKey()
  {
    return c.a(this.a).w();
  }
  
  protected abstract int getServiceVersionInt();
  
  public abstract String getServiceVersionName();
  
  public void onBind() {}
  
  public void onUnbind() {}
  
  public static abstract class ServiceEvent
  {
    private final int PLATFORM = 1;
    protected Service service;
    
    public ServiceEvent(Service paramService)
    {
      this.service = paramService;
    }
    
    protected HashMap<String, Object> filterShareContent(int paramInt, Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
    {
      paramShareParams = ShareSDK.getPlatform(ShareSDK.platformIdToName(paramInt)).filterShareContent(paramShareParams, paramHashMap);
      paramHashMap = new HashMap();
      paramHashMap.put("shareID", paramShareParams.a);
      paramHashMap.put("shareContent", new e().a(paramShareParams.toString()));
      cn.sharesdk.framework.utils.d.a().i("filterShareContent ==>>%s", new Object[] { paramHashMap });
      return paramHashMap;
    }
    
    protected HashMap<String, Object> toMap()
    {
      HashMap localHashMap = new HashMap();
      c localc = c.a(Service.a(this.service));
      localHashMap.put("deviceid", localc.w());
      localHashMap.put("appkey", this.service.getAppKey());
      localHashMap.put("apppkg", localc.x());
      localHashMap.put("appver", Integer.valueOf(localc.z()));
      localHashMap.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
      localHashMap.put("plat", Integer.valueOf(1));
      localHashMap.put("networktype", localc.u());
      localHashMap.put("deviceData", localc.j());
      return localHashMap;
    }
    
    public final String toString()
    {
      return new e().a(toMap());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */