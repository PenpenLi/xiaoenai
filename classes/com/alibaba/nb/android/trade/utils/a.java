package com.alibaba.nb.android.trade.utils;

import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  private static final AtomicInteger a = new AtomicInteger(59994);
  
  public static int a(String paramString)
  {
    int i = a.getAndIncrement();
    com.alibaba.nb.android.trade.utils.d.a.a("kernel", i + " is allocated for onActivityResult request code for " + paramString);
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */