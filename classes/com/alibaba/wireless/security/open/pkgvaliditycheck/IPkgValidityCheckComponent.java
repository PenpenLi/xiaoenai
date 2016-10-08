package com.alibaba.wireless.security.open.pkgvaliditycheck;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IPkgValidityCheckComponent
  extends IComponent
{
  public abstract int checkEnvAndFiles(String... paramVarArgs);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\pkgvaliditycheck\IPkgValidityCheckComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */