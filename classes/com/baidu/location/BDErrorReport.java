package com.baidu.location;

import android.os.Bundle;
import java.util.Locale;

public abstract class BDErrorReport
{
  private String a = null;
  
  public BDErrorReport() {}
  
  public BDErrorReport(BDErrorReport paramBDErrorReport)
  {
    this.a = paramBDErrorReport.a;
  }
  
  public Bundle getErrorInfo()
  {
    if (this.a == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("errInfo", this.a);
    return localBundle;
  }
  
  public abstract void onReportResult(boolean paramBoolean);
  
  public int setErrorInfo(boolean paramBoolean1, double paramDouble1, double paramDouble2, boolean paramBoolean2, String paramString1, double paramDouble3, double paramDouble4, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    localStringBuffer.append("&report=1");
    if (paramBoolean1) {
      localStringBuffer.append(String.format(Locale.CHINA, "&ell=%.5f|%.5f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    }
    if (paramBoolean2)
    {
      if ((paramString1 != null) && ((paramString1.equals("gcj02")) || (paramString1.equals("bd09")) || (paramString1.equals("bd09ll")) || (paramString1.equals("gps"))))
      {
        localStringBuffer.append(String.format(Locale.CHINA, "&ugc=%.5f|%.5f", new Object[] { Double.valueOf(paramDouble3), Double.valueOf(paramDouble4) }));
        localStringBuffer.append("&ucoord=");
        localStringBuffer.append(paramString1);
      }
    }
    else
    {
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() > 60) {
          paramString1 = paramString2.substring(0, 60);
        }
        localStringBuffer.append("&ver=");
        localStringBuffer.append(paramString1);
      }
      if (paramString3 != null)
      {
        paramString1 = paramString3;
        if (paramString3.length() > 512) {
          paramString1 = paramString3.substring(0, 512);
        }
        localStringBuffer.append("&erInfo=");
        localStringBuffer.append(paramString1);
      }
      this.a = localStringBuffer.toString();
      return 0;
    }
    return 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\BDErrorReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */