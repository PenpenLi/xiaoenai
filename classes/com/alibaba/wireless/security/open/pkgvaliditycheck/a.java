package com.alibaba.wireless.security.open.pkgvaliditycheck;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.IComponent;

public final class a
  implements IComponent, IPkgValidityCheckComponent
{
  private com.taobao.wireless.security.adapter.a.a a;
  
  public a(ContextWrapper paramContextWrapper)
  {
    this.a = new com.taobao.wireless.security.adapter.a.a(paramContextWrapper);
  }
  
  public final int checkEnvAndFiles(String... paramVarArgs)
  {
    return this.a.a(paramVarArgs);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\pkgvaliditycheck\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */