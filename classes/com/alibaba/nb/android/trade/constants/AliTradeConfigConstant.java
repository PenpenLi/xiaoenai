package com.alibaba.nb.android.trade.constants;

import com.alibaba.nb.android.trade.AliTradeContext;

public class AliTradeConfigConstant
{
  public static final String CHECK_GROUP_NAME = "group0";
  public static final String ISV_CODE = "isvCode";
  public static final String ISV_VERSION = "isvVersion";
  public static final String MD5_SALT = "ALITRADE20160628";
  public static final String SIGN_KEY = "sign";
  public static final String SP_CONFIG_NAME = "aliTradeConfigSP";
  
  public static String getConfigUrl()
  {
    String str;
    switch (1.a[AliTradeContext.environment.ordinal()])
    {
    default: 
      str = "https://nbsdk-baichuan.alicdn.com/%s/%s/%s/meta.htm?plat=android";
    }
    for (;;)
    {
      return String.format(str, new Object[] { AliTradeContext.sdkVersion, AliTradeContext.appKey, "1.0.0" });
      str = "http://nbsdk-baichuan.taobao.com/%s/%s/%s/meta.htm?plat=android";
      continue;
      str = "http://100.69.205.47/%s/%s/%s/meta.htm?plat=android";
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\constants\AliTradeConfigConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */