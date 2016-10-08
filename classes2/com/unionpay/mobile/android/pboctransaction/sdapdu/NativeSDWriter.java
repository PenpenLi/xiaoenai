package com.unionpay.mobile.android.pboctransaction.sdapdu;

import com.unionpay.mobile.android.utils.h;
import java.util.ArrayList;

public class NativeSDWriter
{
  public NativeSDWriter()
  {
    b.a();
  }
  
  private native boolean closeSD();
  
  private native boolean openSD(ArrayList<String> paramArrayList);
  
  private native String writeApdu(String paramString);
  
  public final String a(String paramString)
  {
    h.c("uppay", "[====>]" + paramString);
    paramString = writeApdu(paramString);
    h.c("uppay", "[<====]" + paramString);
    return paramString;
  }
  
  public final boolean a()
  {
    h.c("uppay", "close()");
    return closeSD();
  }
  
  public final boolean a(ArrayList<String> paramArrayList)
  {
    boolean bool = openSD(paramArrayList);
    h.c("uppay", "open(), ret=" + bool);
    return bool;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\sdapdu\NativeSDWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */