package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;

public class UTMIVariables
{
  private static UTMIVariables jdField_a_of_type_ComUtMiniBaseUTMIVariables = new UTMIVariables();
  private boolean O = false;
  private UTMI1010_2001Event jdField_a_of_type_ComUtMiniSdkeventsUTMI1010_2001Event = null;
  private String ak = null;
  private String an = null;
  private String ao = null;
  
  public static UTMIVariables getInstance()
  {
    return jdField_a_of_type_ComUtMiniBaseUTMIVariables;
  }
  
  public String getH5RefPage()
  {
    return this.an;
  }
  
  public String getH5Url()
  {
    return this.ao;
  }
  
  public String getRefPage()
  {
    return this.ak;
  }
  
  public UTMI1010_2001Event getUTMI1010_2001EventInstance()
  {
    try
    {
      UTMI1010_2001Event localUTMI1010_2001Event = this.jdField_a_of_type_ComUtMiniSdkeventsUTMI1010_2001Event;
      return localUTMI1010_2001Event;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isAliyunOSPlatform()
  {
    try
    {
      boolean bool = this.O;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setH5RefPage(String paramString)
  {
    this.an = paramString;
  }
  
  public void setH5Url(String paramString)
  {
    this.ao = paramString;
  }
  
  public void setRefPage(String paramString)
  {
    this.ak = paramString;
  }
  
  public void setToAliyunOSPlatform()
  {
    try
    {
      this.O = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setUTMI1010_2001EventInstance(UTMI1010_2001Event paramUTMI1010_2001Event)
  {
    try
    {
      this.jdField_a_of_type_ComUtMiniSdkeventsUTMI1010_2001Event = paramUTMI1010_2001Event;
      return;
    }
    finally
    {
      paramUTMI1010_2001Event = finally;
      throw paramUTMI1010_2001Event;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\base\UTMIVariables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */