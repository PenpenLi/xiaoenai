package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

public class SecurityInit
{
  public static int Initialize(Context paramContext)
  {
    try
    {
      int i = SecurityGuardManager.getInitializer().initialize(paramContext);
      return i;
    }
    catch (SecException paramContext)
    {
      paramContext.printStackTrace();
      throw new JAQException(paramContext.getErrorCode());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\jaq\SecurityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */