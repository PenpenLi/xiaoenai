package org.cocos2dx.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

class Cocos2dxGLSurfaceView$1
  extends Handler
{
  Cocos2dxGLSurfaceView$1(Cocos2dxGLSurfaceView paramCocos2dxGLSurfaceView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((Cocos2dxGLSurfaceView.access$000(this.this$0) == null) || (!Cocos2dxGLSurfaceView.access$000(this.this$0).requestFocus()));
      Cocos2dxGLSurfaceView.access$000(this.this$0).removeTextChangedListener(Cocos2dxGLSurfaceView.access$100());
      Cocos2dxGLSurfaceView.access$000(this.this$0).setText("");
      paramMessage = (String)paramMessage.obj;
      Cocos2dxGLSurfaceView.access$000(this.this$0).append(paramMessage);
      Cocos2dxGLSurfaceView.access$100().setOriginText(paramMessage);
      Cocos2dxGLSurfaceView.access$000(this.this$0).addTextChangedListener(Cocos2dxGLSurfaceView.access$100());
      ((InputMethodManager)Cocos2dxGLSurfaceView.access$200().getContext().getSystemService("input_method")).showSoftInput(Cocos2dxGLSurfaceView.access$000(this.this$0), 0);
      Log.d("GLSurfaceView", "showSoftInput");
      return;
    } while (Cocos2dxGLSurfaceView.access$000(this.this$0) == null);
    Cocos2dxGLSurfaceView.access$000(this.this$0).removeTextChangedListener(Cocos2dxGLSurfaceView.access$100());
    ((InputMethodManager)Cocos2dxGLSurfaceView.access$200().getContext().getSystemService("input_method")).hideSoftInputFromWindow(Cocos2dxGLSurfaceView.access$000(this.this$0).getWindowToken(), 0);
    this.this$0.requestFocus();
    Log.d("GLSurfaceView", "HideSoftInput");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxGLSurfaceView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */