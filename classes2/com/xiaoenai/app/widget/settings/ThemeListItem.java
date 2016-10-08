package com.xiaoenai.app.widget.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;

public class ThemeListItem
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  private ImageView c;
  private ImageView d;
  private boolean e = false;
  private RelativeLayout.LayoutParams f;
  private RelativeLayout.LayoutParams g;
  private RelativeLayout.LayoutParams h;
  private RelativeLayout.LayoutParams i;
  
  public ThemeListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeListItem);
    try
    {
      setBackgroundWithPosition(paramContext.getInt(0, -1));
      setThemeImage(paramContext.getDrawable(1));
      setThemeTitle(paramContext.getString(2));
      setSelectedMarkImage(paramContext.getBoolean(3, false));
      setVIP(paramContext.getBoolean(4, false));
      paramContext.recycle();
      setClickable(true);
      if (getLayoutParams() != null)
      {
        if (isInEditMode()) {
          getLayoutParams().height = 72;
        }
      }
      else {
        return;
      }
    }
    finally
    {
      paramContext.recycle();
    }
    getLayoutParams().height = ab.a(48.0F);
  }
  
  private void setBackgroundWithPosition(int paramInt)
  {
    setBackgroundResource(2130839054);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.c = new ImageView(getContext());
      this.c.setBackgroundColor(getResources().getColor(2131493097));
      this.i = new RelativeLayout.LayoutParams(-1, 1);
      this.i.addRule(3, 2131558431);
      if (!isInEditMode()) {
        break label98;
      }
    }
    label98:
    for (this.i.leftMargin = 24;; this.i.leftMargin = ab.a(16.0F))
    {
      addView(this.c, this.i);
      return;
    }
  }
  
  public void setSelectedMarkImage(boolean paramBoolean)
  {
    if (this.d == null) {
      if (paramBoolean)
      {
        this.d = new ImageView(getContext());
        this.d.setId(2131558432);
        this.d.setImageResource(2130838990);
        this.h = new RelativeLayout.LayoutParams(-2, -2);
        this.h.addRule(11, -1);
        addView(this.d, this.h);
      }
    }
    while (paramBoolean) {
      return;
    }
    removeView(this.d);
    this.d = null;
  }
  
  public void setThemeImage(int paramInt)
  {
    setThemeImage(getResources().getDrawable(paramInt));
  }
  
  public void setThemeImage(Drawable paramDrawable)
  {
    if ((this.a == null) && (paramDrawable != null))
    {
      this.a = new ImageView(getContext());
      this.a.setId(2131558431);
      this.a.setImageDrawable(paramDrawable);
      this.f = new RelativeLayout.LayoutParams(-2, -2);
      this.f.addRule(9, -1);
      addView(this.a, this.f);
    }
  }
  
  public void setThemeTitle(int paramInt)
  {
    setThemeTitle(getResources().getString(paramInt));
  }
  
  public void setThemeTitle(String paramString)
  {
    if (this.b == null)
    {
      this.b = new TextView(getContext());
      this.b = new TextView(getContext());
      this.b.setDuplicateParentStateEnabled(true);
      this.b.setId(2131558433);
      this.b.setTextSize(2, 16.0F);
      ColorStateList localColorStateList = getResources().getColorStateList(2131493220);
      this.b.setTextColor(localColorStateList);
      this.g = new RelativeLayout.LayoutParams(-2, -2);
      this.g.addRule(1, 2131558431);
      this.g.addRule(15, -1);
      addView(this.b, this.g);
    }
    if (paramString != null) {
      this.b.setText(paramString);
    }
  }
  
  public void setVIP(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\settings\ThemeListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */