package org.cocos2dx.lib;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class Cocos2dxHandler
  extends Handler
{
  public static final int HANDLER_SHOW_DIALOG = 1;
  private WeakReference<Cocos2dxActivity> mActivity;
  
  public Cocos2dxHandler(Cocos2dxActivity paramCocos2dxActivity)
  {
    this.mActivity = new WeakReference(paramCocos2dxActivity);
  }
  
  private void showDialog(Message paramMessage)
  {
    Cocos2dxActivity localCocos2dxActivity = (Cocos2dxActivity)this.mActivity.get();
    paramMessage = (DialogMessage)paramMessage.obj;
    new AlertDialog.Builder(localCocos2dxActivity).setTitle(paramMessage.titile).setMessage(paramMessage.message).setPositiveButton("Ok", new Cocos2dxHandler.1(this)).create().show();
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    showDialog(paramMessage);
  }
  
  public static class DialogMessage
  {
    public String message;
    public String titile;
    
    public DialogMessage(String paramString1, String paramString2)
    {
      this.titile = paramString1;
      this.message = paramString2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */