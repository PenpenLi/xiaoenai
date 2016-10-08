package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;

public class SecurityStorage
{
  private Context a;
  
  public SecurityStorage(Context paramContext)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
  }
  
  public String getString(String paramString)
  {
    try
    {
      paramString = SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().getString(paramString);
      return paramString;
    }
    catch (SecException paramString)
    {
      paramString.printStackTrace();
      throw new JAQException(paramString.getErrorCode());
    }
  }
  
  public int putString(String paramString1, String paramString2)
  {
    try
    {
      int i = SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().putString(paramString1, paramString2);
      return i;
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
  
  public void removeString(String paramString)
  {
    try
    {
      SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().removeString(paramString);
      return;
    }
    catch (SecException paramString)
    {
      paramString.printStackTrace();
      throw new JAQException(paramString.getErrorCode());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\jaq\SecurityStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */