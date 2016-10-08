package org.cocos2dx.lib;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.inputmethod.InputMethodManager;

public class Cocos2dxEditBoxHelper
{
  private static final String TAG = Cocos2dxEditBoxHelper.class.getSimpleName();
  private static Cocos2dxActivity mCocos2dxActivity;
  private static SparseArray<Cocos2dxEditBox> mEditBoxArray;
  private static ResizeLayout mFrameLayout;
  private static int mViewTag = 0;
  
  public Cocos2dxEditBoxHelper(ResizeLayout paramResizeLayout)
  {
    mFrameLayout = paramResizeLayout;
    mCocos2dxActivity = (Cocos2dxActivity)Cocos2dxActivity.getContext();
    mEditBoxArray = new SparseArray();
  }
  
  public static void __editBoxEditingChanged(int paramInt, String paramString)
  {
    editBoxEditingChanged(paramInt, paramString);
  }
  
  public static void __editBoxEditingDidBegin(int paramInt)
  {
    editBoxEditingDidBegin(paramInt);
  }
  
  public static void __editBoxEditingDidEnd(int paramInt, String paramString)
  {
    editBoxEditingDidEnd(paramInt, paramString);
  }
  
  public static void closeKeyboard(int paramInt)
  {
    Object localObject = mCocos2dxActivity;
    localObject = (InputMethodManager)Cocos2dxActivity.getContext().getSystemService("input_method");
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)mEditBoxArray.get(paramInt);
    if (localCocos2dxEditBox != null)
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(localCocos2dxEditBox.getWindowToken(), 0);
      mCocos2dxActivity.getGLSurfaceView().setSoftKeyboardShown(false);
    }
  }
  
  public static int convertToSP(float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, mCocos2dxActivity.getResources().getDisplayMetrics());
  }
  
  public static int createEditBox(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    int i = mViewTag;
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.1(paramFloat, paramInt4, paramInt1, paramInt2, paramInt3, i));
    paramInt1 = mViewTag;
    mViewTag = paramInt1 + 1;
    return paramInt1;
  }
  
  private static native void editBoxEditingChanged(int paramInt, String paramString);
  
  private static native void editBoxEditingDidBegin(int paramInt);
  
  private static native void editBoxEditingDidEnd(int paramInt, String paramString);
  
  public static void openKeyboard(int paramInt)
  {
    Object localObject = mCocos2dxActivity;
    localObject = (InputMethodManager)Cocos2dxActivity.getContext().getSystemService("input_method");
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)mEditBoxArray.get(paramInt);
    if (localCocos2dxEditBox != null)
    {
      ((InputMethodManager)localObject).showSoftInput(localCocos2dxEditBox, 0);
      mCocos2dxActivity.getGLSurfaceView().setSoftKeyboardShown(true);
    }
  }
  
  public static void removeEditBox(int paramInt)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.2(paramInt));
  }
  
  public static void setEditBoxViewRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.13(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
  }
  
  public static void setFont(int paramInt, String paramString, float paramFloat)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.3(paramInt, paramString, paramFloat));
  }
  
  public static void setFontColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.4(paramInt1, paramInt5, paramInt2, paramInt3, paramInt4));
  }
  
  public static void setInputFlag(int paramInt1, int paramInt2)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.12(paramInt1, paramInt2));
  }
  
  public static void setInputMode(int paramInt1, int paramInt2)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.11(paramInt1, paramInt2));
  }
  
  public static void setMaxLength(int paramInt1, int paramInt2)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.7(paramInt1, paramInt2));
  }
  
  public static void setPlaceHolderText(int paramInt, String paramString)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.5(paramInt, paramString));
  }
  
  public static void setPlaceHolderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.6(paramInt1, paramInt5, paramInt2, paramInt3, paramInt4));
  }
  
  public static void setReturnType(int paramInt1, int paramInt2)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.10(paramInt1, paramInt2));
  }
  
  public static void setText(int paramInt, String paramString)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.9(paramInt, paramString));
  }
  
  public static void setVisible(int paramInt, boolean paramBoolean)
  {
    mCocos2dxActivity.runOnUiThread(new Cocos2dxEditBoxHelper.8(paramInt, paramBoolean));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */