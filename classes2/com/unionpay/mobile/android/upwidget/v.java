package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.e;

public final class v
  extends LinearLayout
{
  private Context a = null;
  private TextView b = null;
  
  private v(Context paramContext, Drawable paramDrawable)
  {
    super(paramContext);
    this.a = paramContext;
    setOrientation(0);
    paramContext = this.a;
    if (paramDrawable != null)
    {
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setBackgroundDrawable(paramDrawable);
      int i = b.o;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 16;
      addView(localImageView, localLayoutParams);
    }
    this.b = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    if (paramDrawable != null) {
      paramContext.leftMargin = a.d;
    }
    addView(this.b, paramContext);
  }
  
  public static v a(Context paramContext, Drawable paramDrawable)
  {
    paramContext = new v(paramContext, paramDrawable);
    if (paramContext.b != null) {
      paramContext.b.setTextSize(16.0F);
    }
    paramContext.a(e.a(-16758391, -65536));
    return paramContext;
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (this.b != null) {
      this.b.setTextColor(paramColorStateList);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (this.b != null) {
      this.b.setText(paramCharSequence);
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.b != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */