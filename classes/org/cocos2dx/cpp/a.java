package org.cocos2dx.cpp;

import org.mzd.game.GameCallback;

class a
  extends GameCallback
{
  a(AppActivity paramAppActivity) {}
  
  public void onAppUpdate()
  {
    super.onAppUpdate();
    this.a.runOnUiThread(new b(this));
  }
  
  public void onGameExit()
  {
    super.onGameExit();
    com.xiaoenai.app.utils.f.a.c("onGameExit", new Object[0]);
    this.a.finish();
  }
  
  public void onPay(String paramString)
  {
    super.onPay(paramString);
    AppActivity.a(this.a, paramString);
    com.xiaoenai.app.utils.f.a.c("onPay {}", new Object[] { paramString });
    this.a.a(this.a, paramString);
  }
  
  public void onReportError(String paramString)
  {
    super.onReportError(paramString);
    com.xiaoenai.app.utils.f.a.c(paramString, new Object[0]);
    this.a.runOnUiThread(new c(this, paramString));
  }
  
  public void onShare(String paramString)
  {
    super.onShare(paramString);
    this.a.runOnUiThread(new d(this, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */