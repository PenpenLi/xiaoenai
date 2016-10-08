package com.alipay.sdk.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpPost;

public final class d
{
  private static ThreadPoolExecutor a = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(20));
  private static Object b = new Object();
  private static HttpPost c = new HttpPost("https://mclient.alipay.com/sdkErrorlog.do");
  
  public static void a(String paramString)
  {
    a.execute(new e(paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */