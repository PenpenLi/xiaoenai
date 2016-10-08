package com.xiaoenai.app.ui.component.view.a;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class b
{
  public static void a(TextView paramTextView, SpannableStringBuilder paramSpannableStringBuilder, int paramInt)
  {
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramSpannableStringBuilder, TextView.BufferType.SPANNABLE);
    paramTextView.setLinkTextColor(paramInt);
  }
  
  public static void a(a parama)
  {
    parama.d().setSpan(new c(parama, false), parama.b(), parama.c(), 33);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */