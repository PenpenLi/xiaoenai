package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.concurrent.atomic.AtomicInteger;

public class CodeAllocator
{
  private static final AtomicInteger REQUEST_CODE = new AtomicInteger(59994);
  
  public static int allocateRequestCode(String paramString)
  {
    int i = REQUEST_CODE.getAndIncrement();
    AliSDKLogger.i("kernel", i + " is allocated for onActivityResult request code for " + paramString);
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CodeAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */