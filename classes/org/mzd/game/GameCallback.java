package org.mzd.game;

import com.xiaoenai.app.utils.f.a;

public class GameCallback
{
  public void onAppUpdate() {}
  
  public void onGameExit()
  {
    a.c("cocos_android_app_uninit", new Object[0]);
  }
  
  public void onPay(String paramString)
  {
    a.c("onPay {}", new Object[] { paramString });
  }
  
  public void onReportError(String paramString) {}
  
  public void onShare(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\mzd\game\GameCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */