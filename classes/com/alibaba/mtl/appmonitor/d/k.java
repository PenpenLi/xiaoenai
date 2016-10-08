package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.taobao.orange.OrangeConfig;
import java.util.Map;

public class k
{
  static String A = "appmonitor";
  static String B = "c_config";
  static String C = "f_u_interval";
  static String D = "b_u_interval";
  static String E = "c_content";
  static String[] a = { A };
  
  private static void a(Map<String, String> paramMap)
  {
    i.a("OrangeConfigAdapter", new Object[] { "orange Config:" + paramMap });
    if (paramMap == null) {
      return;
    }
    com.alibaba.mtl.log.a.a.g((String)paramMap.get(B));
    com.alibaba.mtl.log.a.a.h((String)paramMap.get(C));
    com.alibaba.mtl.log.a.a.i((String)paramMap.get(D));
    if (paramMap.containsKey(E)) {
      com.alibaba.mtl.log.a.a.l((String)paramMap.get(E));
    }
    l.a(com.alibaba.mtl.log.a.getContext());
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      i.a("OrangeConfigAdapter", new Object[] { "[init orange]" });
      i.a("OrangeConfigAdapter", new Object[] { "[registerListener]" });
      OrangeConfig.getInstance().registerListener(a, new k.1());
      r.a().a(8, new a(), 5000L);
      return;
    }
    catch (Throwable paramContext)
    {
      i.a("OrangeConfigAdapter", "init orange error", paramContext);
    }
  }
  
  static class a
    implements Runnable
  {
    int index = 0;
    
    public void run()
    {
      Map localMap = OrangeConfig.getInstance().getConfigs(k.A);
      i.a("OrangeConfigAdapter", new Object[] { "configs:", localMap });
      this.index += 1;
      if (localMap != null) {
        k.b(localMap);
      }
      while (this.index >= 20) {
        return;
      }
      r.a().a(8, this, 5000L);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */