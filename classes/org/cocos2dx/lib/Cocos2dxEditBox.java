package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;

public class Cocos2dxEditBox
  extends EditText
{
  private final int kEditBoxInputFlagInitialCapsAllCharacters = 4;
  private final int kEditBoxInputFlagInitialCapsSentence = 3;
  private final int kEditBoxInputFlagInitialCapsWord = 2;
  private final int kEditBoxInputFlagPassword = 0;
  private final int kEditBoxInputFlagSensitive = 1;
  private final int kEditBoxInputModeAny = 0;
  private final int kEditBoxInputModeDecimal = 5;
  private final int kEditBoxInputModeEmailAddr = 1;
  private final int kEditBoxInputModeNumeric = 2;
  private final int kEditBoxInputModePhoneNumber = 3;
  private final int kEditBoxInputModeSingleLine = 6;
  private final int kEditBoxInputModeUrl = 4;
  private final int kKeyboardReturnTypeDefault = 0;
  private final int kKeyboardReturnTypeDone = 1;
  private final int kKeyboardReturnTypeGo = 4;
  private final int kKeyboardReturnTypeSearch = 3;
  private final int kKeyboardReturnTypeSend = 2;
  private int mInputFlagConstraints;
  private int mInputModeConstraints;
  private int mMaxLength;
  private float mScaleX;
  
  public Cocos2dxEditBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public float getOpenGLViewScaleX()
  {
    return this.mScaleX;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    ((Cocos2dxActivity)getContext()).getGLSurfaceView().requestFocus();
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setEditBoxViewRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.width = paramInt3;
    localLayoutParams.height = paramInt4;
    localLayoutParams.gravity = 51;
    setLayoutParams(localLayoutParams);
  }
  
  public void setInputFlag(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      setInputType(this.mInputFlagConstraints | this.mInputModeConstraints);
      return;
      this.mInputFlagConstraints = 129;
      setTypeface(Typeface.DEFAULT);
      setTransformationMethod(new PasswordTransformationMethod());
      continue;
      this.mInputFlagConstraints = 524288;
      continue;
      this.mInputFlagConstraints = 8192;
      continue;
      this.mInputFlagConstraints = 16384;
      continue;
      this.mInputFlagConstraints = 4096;
    }
  }
  
  public void setInputMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      setInputType(this.mInputModeConstraints | this.mInputFlagConstraints);
      return;
      this.mInputModeConstraints = 131073;
      continue;
      this.mInputModeConstraints = 33;
      continue;
      this.mInputModeConstraints = 4098;
      continue;
      this.mInputModeConstraints = 3;
      continue;
      this.mInputModeConstraints = 17;
      continue;
      this.mInputModeConstraints = 12290;
      continue;
      this.mInputModeConstraints = 1;
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
    setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.mMaxLength) });
  }
  
  public void setMultilineEnabled(boolean paramBoolean)
  {
    this.mInputModeConstraints |= 0x20000;
  }
  
  public void setOpenGLViewScaleX(float paramFloat)
  {
    this.mScaleX = paramFloat;
  }
  
  public void setReturnType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      setImeOptions(268435457);
      return;
    case 0: 
      setImeOptions(268435457);
      return;
    case 1: 
      setImeOptions(268435462);
      return;
    case 2: 
      setImeOptions(268435460);
      return;
    case 3: 
      setImeOptions(268435459);
      return;
    }
    setImeOptions(268435458);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */