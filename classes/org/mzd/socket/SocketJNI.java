package org.mzd.socket;

import android.content.Context;
import com.xiaoenai.app.net.socket.b;
import com.xiaoenai.app.utils.f.a;

public class SocketJNI
{
  private static b iSocketCallBack = null;
  
  public static final native void appToBackground();
  
  public static final native void appToForeground();
  
  public static final native boolean checkHashKey(String paramString);
  
  public static final native void connect();
  
  public static final native void destroy();
  
  public static final native void getNewMessage(long paramLong1, long paramLong2);
  
  public static final native void init(Context paramContext);
  
  public static final native void networkChange(int paramInt);
  
  public static void onLogCallback(String paramString)
  {
    a.c("onLogCallback {}", new Object[] { paramString });
  }
  
  public static void onNetworkStatus(int paramInt)
  {
    a.c("onNetworkStatus {}", new Object[] { Integer.valueOf(paramInt) });
    if (iSocketCallBack != null) {
      iSocketCallBack.a(paramInt);
    }
  }
  
  public static void onNotification(String paramString)
  {
    a.c("onNotification {}", new Object[] { paramString });
    try
    {
      if (iSocketCallBack != null) {
        iSocketCallBack.a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      a.a(paramString.getMessage(), new Object[0]);
    }
  }
  
  public static final native void readMessage(MessageCallback paramMessageCallback, String paramString);
  
  public static final native void send(String paramString);
  
  public static final native void sendCallMessage(MessageCallback paramMessageCallback, String paramString);
  
  public static final native void sendMessage(MessageCallback paramMessageCallback, String paramString);
  
  public static final native void setAdjustTime(long paramLong);
  
  public static final native void setExStoragePath(String paramString);
  
  public static final native void setLogLevel(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public static final native void setLogPath(String paramString);
  
  public static final native void setLoverId(long paramLong);
  
  public static final native void setSavePidPath(String paramString);
  
  public static final native void setSerUrl(String paramString);
  
  public static final native void setServer(String paramString);
  
  public static void setSocketCallBack(b paramb)
  {
    try
    {
      iSocketCallBack = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static final native void setUserData(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public static final native void setUserDataPath(String paramString);
  
  public static final native void updateMessage(MessageCallback paramMessageCallback, String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\mzd\socket\SocketJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */