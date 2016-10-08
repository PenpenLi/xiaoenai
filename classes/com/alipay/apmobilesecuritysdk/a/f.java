package com.alipay.apmobilesecuritysdk.a;

import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;

public final class f
{
  private boolean a = false;
  private String b;
  private String c;
  
  public f(AppListResult paramAppListResult)
  {
    if (paramAppListResult == null) {
      return;
    }
    this.a = paramAppListResult.success;
    this.b = paramAppListResult.appListData;
    this.c = paramAppListResult.appListVer;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */