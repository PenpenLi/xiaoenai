package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;

public class StreetBaseItemView
  extends RelativeLayout
{
  private TextView a;
  private ImageView b;
  private ImageView c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private RelativeLayout.LayoutParams g;
  
  public StreetBaseItemView(Context paramContext)
  {
    super(paramContext);
    setBackgroundWithPosition(this.d);
  }
  
  public StreetBaseItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.mall_base_item_view);
    try
    {
      this.d = paramContext.getInt(0, 0);
      this.e = paramContext.getBoolean(1, false);
      this.f = paramContext.getBoolean(2, false);
      paramContext.recycle();
      setBackgroundWithPosition(this.d);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public void a()
  {
    if ((this.b != null) && (this.b.getParent() != null)) {
      removeView(this.b);
    }
    this.b = new ImageView(getContext());
    this.b.setBackgroundColor(getResources().getColor(2131493097));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(10);
    if (this.e)
    {
      if (!isInEditMode()) {
        break label108;
      }
      localLayoutParams.leftMargin = 24;
    }
    for (localLayoutParams.rightMargin = 24;; localLayoutParams.rightMargin = ab.a(16.0F))
    {
      addView(this.b, localLayoutParams);
      return;
      label108:
      localLayoutParams.leftMargin = ab.a(16.0F);
    }
  }
  
  public void b()
  {
    if ((this.c != null) && (this.c.getParent() != null)) {
      removeView(this.c);
    }
    this.c = new ImageView(getContext());
    this.c.setBackgroundColor(getResources().getColor(2131493097));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(12);
    if (this.f)
    {
      if (!isInEditMode()) {
        break label108;
      }
      localLayoutParams.leftMargin = 24;
    }
    for (localLayoutParams.rightMargin = 24;; localLayoutParams.rightMargin = ab.a(16.0F))
    {
      addView(this.c, localLayoutParams);
      return;
      label108:
      localLayoutParams.leftMargin = ab.a(16.0F);
    }
  }
  
  public void setBackgroundWithPosition(int paramInt)
  {
    setBackgroundResource(2130839054);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a();
      b();
      return;
    case 1: 
      a();
      return;
    }
    a();
  }
  
  public void setTitleView(int paramInt)
  {
    setTitleView(getResources().getString(paramInt));
  }
  
  public void setTitleView(String paramString)
  {
    if (this.a == null) {
      if (paramString != null)
      {
        this.a = new TextView(getContext());
        this.a.setDuplicateParentStateEnabled(true);
        this.a.setId(2131558440);
        this.a.setTextSize(2, 18.0F);
        localColorStateList = getResources().getColorStateList(2131493220);
        this.a.setTextColor(localColorStateList);
        this.a.setText(paramString);
        this.g = new RelativeLayout.LayoutParams(-2, -2);
        this.g.addRule(9, -1);
        this.g.addRule(15, -1);
        if (!isInEditMode()) {
          break label151;
        }
        this.g.leftMargin = 24;
        addView(this.a, this.g);
      }
    }
    label151:
    while (paramString != null) {
      for (;;)
      {
        ColorStateList localColorStateList;
        this.a.setText(paramString);
        return;
        this.g.leftMargin = ab.a(16.0F);
      }
    }
    removeView(this.a);
    this.a = null;
  }
  
  public void setisBottomShortLine(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setisTopShortLine(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetBaseItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */