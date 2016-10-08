package com.alibaba.sdk.android.time.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.time.TimeService;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.HttpHelper;
import com.alibaba.sdk.android.util.IOUtils;
import java.io.Closeable;
import java.io.InputStream;
import org.json.JSONObject;

public class TimeServiceImpl
  implements TimeService
{
  public static final TimeServiceImpl INSTANCE = new TimeServiceImpl();
  private volatile long deltaTimestamp;
  
  public long getCurrentTimestamp()
  {
    if (this.deltaTimestamp == 0L) {
      return System.currentTimeMillis();
    }
    return this.deltaTimestamp + System.currentTimeMillis();
  }
  
  public long refreshTimestamp()
  {
    localObject3 = null;
    localObject1 = null;
    try
    {
      InputStream localInputStream = HttpHelper.get("http://" + ConfigManager.INIT_SERVER_HOST + "/getServerTime.htm");
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      String str = IOUtils.toString(localInputStream, "UTF-8");
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        long l = new JSONObject(str).optLong("serverTime");
        if (l != 0L)
        {
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          this.deltaTimestamp = (l - System.currentTimeMillis());
        }
      }
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        AliSDKLogger.e("TimeService", "Fail to request the server side time", localException);
        IOUtils.closeQuietly((Closeable)localObject1);
      }
    }
    finally
    {
      IOUtils.closeQuietly((Closeable)localObject3);
    }
    return getCurrentTimestamp();
  }
  
  public void update(long paramLong)
  {
    this.deltaTimestamp = (paramLong - System.currentTimeMillis());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\time\impl\TimeServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */