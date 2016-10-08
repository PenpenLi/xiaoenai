package com.xiaoenai.app.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;

public class ListItemViewEx
  extends RelativeLayout
{
  private TextView a;
  private ImageView b;
  private ImageView c;
  private View d;
  private int e = 0;
  private boolean f = false;
  private int g;
  private boolean h = false;
  private int i;
  private boolean j = true;
  private float k = 17.0F;
  private RelativeLayout.LayoutParams l;
  private RelativeLayout.LayoutParams m;
  
  public ListItemViewEx(Context paramContext)
  {
    super(paramContext);
    setBackgroundWithPosition(this.e);
  }
  
  public ListItemViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.list_item_view_ex);
    try
    {
      this.e = paramContext.getInt(0, 0);
      setTitleView(paramContext.getString(7));
      this.f = paramContext.getBoolean(3, false);
      this.g = paramContext.getInt(1, 1);
      this.h = paramContext.getBoolean(4, false);
      this.i = paramContext.getInt(2, 1);
      this.k = paramContext.getDimension(6, 16.0F);
      this.j = paramContext.getBoolean(5, true);
      paramContext.recycle();
      setBackgroundWithPosition(this.e);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a()
  {
    if ((this.b != null) && (this.b.getParent() != null)) {
      removeView(this.b);
    }
  }
  
  private void e()
  {
    if ((this.c != null) && (this.c.getParent() != null)) {
      removeView(this.c);
    }
  }
  
  public void b()
  {
    if (this.j)
    {
      ImageView localImageView = new ImageView(getContext());
      this.d = localImageView;
      localImageView.setId(2131558437);
      localImageView.setImageResource(2130837615);
      this.m = new RelativeLayout.LayoutParams(-2, -2);
      this.m.addRule(11, -1);
      this.m.addRule(15, -1);
      this.d.setPadding(0, 0, ab.a(20.0F), 0);
      addView(localImageView, this.m);
    }
  }
  
  public void c()
  {
    if ((this.b != null) && (this.b.getParent() != null)) {
      removeView(this.b);
    }
    this.b = new ImageView(getContext());
    this.b.setBackgroundColor(getResources().getColor(2131492931));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(10);
    if (this.f)
    {
      if (this.g != 0) {
        break label118;
      }
      localLayoutParams.leftMargin = ab.a(this.k);
      localLayoutParams.rightMargin = ab.a(this.k);
    }
    for (;;)
    {
      addView(this.b, localLayoutParams);
      return;
      label118:
      if (this.g == 1) {
        localLayoutParams.leftMargin = ab.a(this.k);
      } else if (this.g == 2) {
        localLayoutParams.rightMargin = ab.a(this.k);
      }
    }
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.getParent() != null)) {
      removeView(this.c);
    }
    this.c = new ImageView(getContext());
    this.c.setBackgroundColor(getResources().getColor(2131492931));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(12);
    if (this.h)
    {
      if (this.i != 0) {
        break label118;
      }
      localLayoutParams.leftMargin = ab.a(this.k);
      localLayoutParams.rightMargin = ab.a(this.k);
    }
    for (;;)
    {
      addView(this.c, localLayoutParams);
      return;
      label118:
      if (this.i == 1) {
        localLayoutParams.leftMargin = ab.a(this.k);
      } else if (this.i == 2) {
        localLayoutParams.rightMargin = ab.a(this.k);
      }
    }
  }
  
  public void setBackgroundWithPosition(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      c();
      d();
      return;
    case 1: 
      e();
      c();
      return;
    case 2: 
      a();
      d();
      return;
    }
    a();
    e();
  }
  
  public void setBottomLineShortDirection(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setIsShowArrow(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setShortMargin(float paramFloat)
  {
    this.k = paramFloat;
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
        this.a.setId(2131558438);
        this.a.setTextSize(2, 18.0F);
        localColorStateList = getResources().getColorStateList(2131493220);
        this.a.setTextColor(localColorStateList);
        this.a.setText(paramString);
        this.l = new RelativeLayout.LayoutParams(-2, -2);
        this.l.addRule(9, -1);
        this.l.addRule(15, -1);
        this.a.setPadding(0, ab.a(15.0F), 0, ab.a(15.0F));
        if (!isInEditMode()) {
          break label170;
        }
        this.l.leftMargin = 24;
        addView(this.a, this.l);
      }
    }
    label170:
    while (paramString != null) {
      for (;;)
      {
        ColorStateList localColorStateList;
        this.a.setText(paramString);
        return;
        this.l.leftMargin = ab.a(16.0F);
      }
    }
    removeView(this.a);
    this.a = null;
  }
  
  public void setTopLineShortDirection(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setisBottomShortLine(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setisTopShortLine(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\ListItemViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */