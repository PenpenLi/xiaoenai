package com.xiaoenai.app.classes.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;

public class RedView
  extends FrameLayout
{
  public TextView a;
  private TextView b;
  private boolean c;
  
  public RedView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RedView);
    Object localObject1 = paramAttributeSet.getDrawable(2);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new ImageView(paramContext);
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      setView((View)localObject2);
    }
    localObject1 = paramAttributeSet.getString(0);
    TextView localTextView;
    if (localObject1 != null)
    {
      localObject2 = paramAttributeSet.getColorStateList(3);
      localTextView = new TextView(paramContext);
      if (localObject2 != null) {
        break label213;
      }
      localTextView.setTextColor(paramAttributeSet.getColor(3, -16777216));
    }
    for (;;)
    {
      localTextView.setTextSize(paramAttributeSet.getDimensionPixelOffset(1, ab.c(paramContext, 16.0F)), ab.b(paramContext, 16.0F));
      localTextView.setText((CharSequence)localObject1);
      setView(localTextView);
      this.a = localTextView;
      paramAttributeSet.recycle();
      this.b = new TextView(paramContext);
      this.b.setBackgroundResource(2130838818);
      paramContext = new FrameLayout.LayoutParams(-2, -2);
      paramContext.gravity = 5;
      paramContext.height = ab.a(6.0F);
      paramContext.width = ab.a(6.0F);
      addView(this.b, paramContext);
      a();
      return;
      label213:
      localTextView.setTextColor((ColorStateList)localObject2);
    }
  }
  
  public void a()
  {
    this.b.setVisibility(8);
    this.c = false;
  }
  
  public void b()
  {
    this.b.setVisibility(0);
    this.c = true;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (this.a != null) {
      this.a.setPressed(paramBoolean);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if (this.a != null) {
      this.a.setSelected(paramBoolean);
    }
  }
  
  public void setText(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.a != null) {
      this.a.setTextColor(paramColorStateList);
    }
  }
  
  public void setTextSize(int paramInt)
  {
    if (this.a != null) {
      this.a.setTextSize(paramInt);
    }
  }
  
  public void setView(View paramView)
  {
    paramView.setPadding(ab.a(4.0F), ab.a(1.0F), ab.a(4.0F), ab.a(1.0F));
    addView(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\widget\RedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */