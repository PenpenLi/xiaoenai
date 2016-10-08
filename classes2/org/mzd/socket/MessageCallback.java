package org.mzd.socket;

import com.xiaoenai.app.net.socket.c;
import com.xiaoenai.app.utils.f.a;

public class MessageCallback
{
  private c mSocketPackage = null;
  
  public MessageCallback(c paramc)
  {
    this.mSocketPackage = paramc;
  }
  
  public void onMessageCallback(boolean paramBoolean, String paramString)
  {
    a.c("onMessageCallback {} {}", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (this.mSocketPackage != null) {}
    try
    {
      this.mSocketPackage.a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\mzd\socket\MessageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */