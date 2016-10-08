package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Cocos2dxGLSurfaceView
  extends GLSurfaceView
{
  private static final int HANDLER_CLOSE_IME_KEYBOARD = 3;
  private static final int HANDLER_OPEN_IME_KEYBOARD = 2;
  private static final String TAG = Cocos2dxGLSurfaceView.class.getSimpleName();
  private static Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
  private static Cocos2dxTextInputWraper sCocos2dxTextInputWraper;
  private static Handler sHandler;
  private Cocos2dxEditBox mCocos2dxEditText;
  private Cocos2dxRenderer mCocos2dxRenderer;
  private boolean mSoftKeyboardShown = false;
  
  public Cocos2dxGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public Cocos2dxGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public static void closeIMEKeyboard()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    sHandler.sendMessage(localMessage);
  }
  
  private static void dumpMotionEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramMotionEvent.getAction();
    int k = j & 0xFF;
    localStringBuilder.append("event ACTION_").append(new String[] { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" }[k]);
    if ((k == 5) || (k == 6))
    {
      localStringBuilder.append("(pid ").append(j >> 8);
      localStringBuilder.append(")");
    }
    localStringBuilder.append("[");
    while (i < paramMotionEvent.getPointerCount())
    {
      localStringBuilder.append("#").append(i);
      localStringBuilder.append("(pid ").append(paramMotionEvent.getPointerId(i));
      localStringBuilder.append(")=").append((int)paramMotionEvent.getX(i));
      localStringBuilder.append(",").append((int)paramMotionEvent.getY(i));
      if (i + 1 < paramMotionEvent.getPointerCount()) {
        localStringBuilder.append(";");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    Log.d(TAG, localStringBuilder.toString());
  }
  
  private String getContentText()
  {
    return this.mCocos2dxRenderer.getContentText();
  }
  
  public static Cocos2dxGLSurfaceView getInstance()
  {
    return mCocos2dxGLSurfaceView;
  }
  
  public static void openIMEKeyboard()
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = mCocos2dxGLSurfaceView.getContentText();
    sHandler.sendMessage(localMessage);
  }
  
  public static void queueAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    mCocos2dxGLSurfaceView.queueEvent(new Cocos2dxGLSurfaceView.2(paramFloat1, paramFloat2, paramFloat3, paramLong));
  }
  
  public void deleteBackward()
  {
    queueEvent(new Cocos2dxGLSurfaceView.14(this));
  }
  
  public Cocos2dxEditBox getCocos2dxEditText()
  {
    return this.mCocos2dxEditText;
  }
  
  protected void initView()
  {
    setEGLContextClientVersion(2);
    setFocusableInTouchMode(true);
    mCocos2dxGLSurfaceView = this;
    sCocos2dxTextInputWraper = new Cocos2dxTextInputWraper(this);
    sHandler = new Cocos2dxGLSurfaceView.1(this);
  }
  
  public void insertText(String paramString)
  {
    queueEvent(new Cocos2dxGLSurfaceView.13(this, paramString));
  }
  
  public boolean isSoftKeyboardShown()
  {
    return this.mSoftKeyboardShown;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 4: 
      Cocos2dxVideoHelper.mVideoHandler.sendEmptyMessage(1000);
    }
    queueEvent(new Cocos2dxGLSurfaceView.11(this, paramInt));
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    queueEvent(new Cocos2dxGLSurfaceView.12(this, paramInt));
    return true;
  }
  
  public void onPause()
  {
    queueEvent(new Cocos2dxGLSurfaceView.4(this));
    setRenderMode(0);
  }
  
  public void onResume()
  {
    super.onResume();
    setRenderMode(1);
    queueEvent(new Cocos2dxGLSurfaceView.3(this));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!isInEditMode()) {
      this.mCocos2dxRenderer.setScreenWidthAndHeight(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat1 = new float[j];
    float[] arrayOfFloat2 = new float[j];
    if (this.mSoftKeyboardShown)
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(((Activity)getContext()).getCurrentFocus().getWindowToken(), 0);
      requestFocus();
      this.mSoftKeyboardShown = false;
    }
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramMotionEvent.getPointerId(i);
      arrayOfFloat1[i] = paramMotionEvent.getX(i);
      arrayOfFloat2[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      i = paramMotionEvent.getAction() >> 8;
      queueEvent(new Cocos2dxGLSurfaceView.5(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i)));
      continue;
      queueEvent(new Cocos2dxGLSurfaceView.6(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0]));
      continue;
      queueEvent(new Cocos2dxGLSurfaceView.7(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2));
      continue;
      i = paramMotionEvent.getAction() >> 8;
      queueEvent(new Cocos2dxGLSurfaceView.8(this, paramMotionEvent.getPointerId(i), paramMotionEvent.getX(i), paramMotionEvent.getY(i)));
      continue;
      queueEvent(new Cocos2dxGLSurfaceView.9(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0]));
      continue;
      queueEvent(new Cocos2dxGLSurfaceView.10(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2));
    }
  }
  
  public void setCocos2dxEditText(Cocos2dxEditBox paramCocos2dxEditBox)
  {
    this.mCocos2dxEditText = paramCocos2dxEditBox;
    if ((this.mCocos2dxEditText != null) && (sCocos2dxTextInputWraper != null))
    {
      this.mCocos2dxEditText.setOnEditorActionListener(sCocos2dxTextInputWraper);
      requestFocus();
    }
  }
  
  public void setCocos2dxRenderer(Cocos2dxRenderer paramCocos2dxRenderer)
  {
    this.mCocos2dxRenderer = paramCocos2dxRenderer;
    setRenderer(this.mCocos2dxRenderer);
  }
  
  public void setSoftKeyboardShown(boolean paramBoolean)
  {
    this.mSoftKeyboardShown = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */