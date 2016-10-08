package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.log.e.i;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListener;

final class k$1
  implements OrangeConfigListener
{
  public void onConfigUpdate(String paramString)
  {
    i.a("OrangeConfigAdapter", new Object[] { "orange onConfigUpdate:" + paramString });
    k.b(OrangeConfig.getInstance().getConfigs(paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\k$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */