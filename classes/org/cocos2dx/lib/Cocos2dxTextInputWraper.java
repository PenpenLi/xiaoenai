package org.cocos2dx.lib;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class Cocos2dxTextInputWraper
  implements TextWatcher, TextView.OnEditorActionListener
{
  private static final String TAG = Cocos2dxTextInputWraper.class.getSimpleName();
  private final Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
  private String mOriginText;
  private String mText;
  
  public Cocos2dxTextInputWraper(Cocos2dxGLSurfaceView paramCocos2dxGLSurfaceView)
  {
    this.mCocos2dxGLSurfaceView = paramCocos2dxGLSurfaceView;
  }
  
  private boolean isFullScreenEdit()
  {
    return ((InputMethodManager)this.mCocos2dxGLSurfaceView.getCocos2dxEditText().getContext().getSystemService("input_method")).isFullscreenMode();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 0;
    if (isFullScreenEdit()) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int k = i;
      if (i < this.mText.length())
      {
        k = i;
        if (j < paramEditable.length())
        {
          if (this.mText.charAt(i) == paramEditable.charAt(j)) {
            break label91;
          }
          k = i;
        }
      }
      while (k < this.mText.length())
      {
        this.mCocos2dxGLSurfaceView.deleteBackward();
        k += 1;
      }
      label91:
      i += 1;
      j += 1;
    }
    if (paramEditable.length() - j > 0)
    {
      String str = paramEditable.subSequence(j, paramEditable.length()).toString();
      this.mCocos2dxGLSurfaceView.insertText(str);
    }
    this.mText = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mText = paramCharSequence.toString();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.mCocos2dxGLSurfaceView.getCocos2dxEditText() == paramTextView) && (isFullScreenEdit()))
    {
      if (this.mOriginText != null)
      {
        int i = this.mOriginText.length();
        while (i > 0)
        {
          this.mCocos2dxGLSurfaceView.deleteBackward();
          i -= 1;
        }
      }
      String str = paramTextView.getText().toString();
      paramKeyEvent = str;
      if (str != null)
      {
        paramTextView = str;
        if (str.compareTo("") == 0) {
          paramTextView = "\n";
        }
        paramKeyEvent = paramTextView;
        if ('\n' != paramTextView.charAt(paramTextView.length() - 1)) {
          paramKeyEvent = paramTextView + '\n';
        }
      }
      this.mCocos2dxGLSurfaceView.insertText(paramKeyEvent);
    }
    if (paramInt == 6) {
      this.mCocos2dxGLSurfaceView.requestFocus();
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOriginText(String paramString)
  {
    this.mOriginText = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxTextInputWraper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */