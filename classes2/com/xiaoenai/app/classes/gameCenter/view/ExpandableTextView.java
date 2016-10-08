package com.xiaoenai.app.classes.gameCenter.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.xiaoenai.app.R.styleable;

public class ExpandableTextView
  extends TextView
{
  private CharSequence a;
  private CharSequence b;
  private TextView.BufferType c;
  private boolean d = true;
  private int e;
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextView);
    this.e = paramContext.getInt(0, 32);
    paramContext.recycle();
    setOnClickListener(new a(this));
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    if ((this.a != null) && (this.a.length() > this.e)) {
      return Html.fromHtml(new SpannableStringBuilder(this.a, 0, this.e + 1).append("...  ") + "<font color=\"#F45595\">" + getContext().getString(2131100520) + "</font>");
    }
    return this.a;
  }
  
  private void a()
  {
    super.setText(getDisplayableText(), this.c);
  }
  
  private CharSequence getDisplayableText()
  {
    if (this.d) {
      return this.b;
    }
    return this.a;
  }
  
  public CharSequence getOriginalText()
  {
    return this.a;
  }
  
  public int getTrimLength()
  {
    return this.e;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.a = paramCharSequence;
    this.b = a(paramCharSequence);
    this.c = paramBufferType;
    a();
  }
  
  public void setTrimLength(int paramInt)
  {
    this.e = paramInt;
    this.b = a(this.a);
    a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\view\ExpandableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */