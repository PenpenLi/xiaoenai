package com.xiaoenai.app.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class CleanableEditText
  extends EditText
{
  private boolean a = false;
  private char b = ' ';
  private Drawable c;
  private boolean d;
  
  public CleanableEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CleanableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CleanableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if (b(paramString) != -1) {
      return 1;
    }
    if ((paramString.length() > 3) && (paramString.charAt(3) != this.b)) {
      return 2;
    }
    if ((paramString.length() > 8) && (paramString.charAt(8) != this.b)) {
      return 3;
    }
    if (paramString.length() > 13) {
      return 4;
    }
    return 0;
  }
  
  private void a()
  {
    this.c = getCompoundDrawables()[2];
    setOnFocusChangeListener(new a(null));
    addTextChangedListener(new b(null));
    setClearDrawableVisible(false);
    setLongClickable(false);
  }
  
  private int b(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    int i = 0;
    if (i < paramString.length())
    {
      if ((i == 3) || (i == 8)) {}
      while (paramString.charAt(i) != this.b)
      {
        i += 1;
        break;
      }
      return i;
    }
    return -1;
  }
  
  public String getFormatText()
  {
    String str2 = getText().toString();
    String str1 = str2;
    if (this.a) {
      str1 = str2.replaceAll(String.valueOf(this.b), "");
    }
    return str1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getX() > getWidth() - getTotalPaddingRight()) && (paramMotionEvent.getX() < getWidth() - getPaddingRight())) {}
      for (int i = 1; i != 0; i = 0)
      {
        setText("");
        return true;
      }
    }
  }
  
  public void setClearDrawableVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Drawable localDrawable = this.c;; localDrawable = null)
    {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], localDrawable, getCompoundDrawables()[3]);
      return;
    }
  }
  
  public void setFormatText(char paramChar)
  {
    this.b = paramChar;
  }
  
  public void setmIsPhoneFormat(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private class a
    implements View.OnFocusChangeListener
  {
    private a() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      boolean bool = true;
      CleanableEditText.a(CleanableEditText.this, paramBoolean);
      if (CleanableEditText.a(CleanableEditText.this))
      {
        if (CleanableEditText.this.getText().toString().length() >= 1) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          CleanableEditText.this.setClearDrawableVisible(paramBoolean);
          return;
        }
      }
      CleanableEditText.this.setClearDrawableVisible(false);
    }
  }
  
  private class b
    implements TextWatcher
  {
    private b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      if (paramEditable.toString().length() >= 1) {}
      for (;;)
      {
        CleanableEditText.this.setClearDrawableVisible(bool);
        return;
        bool = false;
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      Editable localEditable;
      if (CleanableEditText.b(CleanableEditText.this))
      {
        localEditable = CleanableEditText.this.getEditableText();
        if ((paramInt2 != 1) || ((paramInt1 != 3) && (paramInt1 != 8))) {}
      }
      else
      {
        return;
      }
      switch (CleanableEditText.a(CleanableEditText.this, paramCharSequence.toString()))
      {
      default: 
        return;
      case 1: 
        paramInt1 = CleanableEditText.b(CleanableEditText.this, localEditable.toString());
        localEditable.delete(paramInt1, paramInt1 + 1);
        return;
      case 2: 
        localEditable.insert(3, String.valueOf(CleanableEditText.c(CleanableEditText.this)));
        return;
      case 3: 
        localEditable.insert(8, String.valueOf(CleanableEditText.c(CleanableEditText.this)));
        return;
      }
      localEditable.delete(paramCharSequence.length() - 1, paramCharSequence.length());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\CleanableEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */