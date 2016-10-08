package com.xiaoenai.app.common.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.common.c.b;
import com.xiaoenai.app.common.c.c;
import com.xiaoenai.app.common.c.d;
import com.xiaoenai.app.common.c.e;
import com.xiaoenai.app.utils.d.t;

public class TitleBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  private RelativeLayout a;
  private ViewGroup b;
  private ImageView c;
  private TextView d;
  private ViewGroup e;
  private TextView f;
  private ViewGroup g;
  private TextView h;
  private TextView i;
  private int j = 0;
  
  public TitleBarView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TitleBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, c.e.TitleBar);
    try
    {
      this.j = paramContext.getInt(c.e.TitleBar_titleBarTheme, 2);
      paramAttributeSet = paramContext.getString(c.e.TitleBar_titleBarTitle);
      String str1 = paramContext.getString(c.e.TitleBar_leftText);
      Drawable localDrawable1 = paramContext.getDrawable(c.e.TitleBar_leftDrawable);
      String str2 = paramContext.getString(c.e.TitleBar_rightText);
      Drawable localDrawable2 = paramContext.getDrawable(c.e.TitleBar_rightDrawable);
      paramContext.recycle();
      a(this.j, paramAttributeSet, str1, str2, localDrawable1, localDrawable2);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    setTitleBarTheme(paramInt);
    setTitleText(paramString1);
    a(this.c, paramDrawable1, null);
    a(this.d, null, paramString2);
    a(this.h, null, paramString3);
    a(this.i, paramDrawable2, null);
  }
  
  private void a(Context paramContext)
  {
    paramContext = RelativeLayout.inflate(paramContext, c.d.view_title_bar, this);
    this.a = ((RelativeLayout)paramContext.findViewById(c.c.title_bar_root_layout));
    this.b = ((ViewGroup)paramContext.findViewById(c.c.title_bar_left_layout));
    this.c = ((ImageView)paramContext.findViewById(c.c.title_bar_left_1));
    this.d = ((TextView)paramContext.findViewById(c.c.title_bar_left_2));
    this.e = ((ViewGroup)paramContext.findViewById(c.c.title_bar_middle_layout));
    this.f = ((TextView)paramContext.findViewById(c.c.title_bar_title_text));
    this.g = ((ViewGroup)paramContext.findViewById(c.c.title_bar_right_layout));
    this.h = ((TextView)paramContext.findViewById(c.c.title_bar_right_1));
    this.i = ((TextView)paramContext.findViewById(c.c.title_bar_right_2));
    this.a.setOnClickListener(this);
  }
  
  private void a(View paramView, Drawable paramDrawable, String paramString)
  {
    if (paramView != null)
    {
      if ((paramDrawable != null) || (!TextUtils.isEmpty(paramString))) {
        break label22;
      }
      paramView.setVisibility(8);
    }
    for (;;)
    {
      return;
      label22:
      paramView.setVisibility(0);
      if (paramDrawable != null)
      {
        if (!(paramView instanceof ImageView)) {
          break label69;
        }
        ((ImageView)paramView).setImageDrawable(paramDrawable);
      }
      while (((paramView instanceof TextView)) && (!TextUtils.isEmpty(paramString)))
      {
        ((TextView)paramView).setText(paramString);
        return;
        label69:
        if (Build.VERSION.SDK_INT >= 16) {
          paramView.setBackground(paramDrawable);
        } else {
          paramView.setBackgroundDrawable(paramDrawable);
        }
      }
    }
  }
  
  private void setTitleText(String paramString)
  {
    if (this.f != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.setText(paramString);
        this.f.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.f.setVisibility(8);
  }
  
  private void setTitleView(View paramView)
  {
    if ((this.e != null) && (paramView != null))
    {
      this.e.removeAllViews();
      this.e.addView(paramView);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      a(getResources().getDrawable(paramInt1), getResources().getString(paramInt2));
    }
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 == 0))
      {
        a(getResources().getDrawable(paramInt1), null);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 <= 0));
    a(null, getResources().getString(paramInt2));
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    a(this.c, paramDrawable, null);
    a(this.d, null, paramString);
  }
  
  public void a(String paramString, View paramView)
  {
    setTitleText(paramString);
    setTitleView(paramView);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      b(getResources().getDrawable(paramInt1), getResources().getString(paramInt2));
    }
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 == 0))
      {
        b(getResources().getDrawable(paramInt1), null);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 <= 0));
    b(null, getResources().getString(paramInt2));
  }
  
  public void b(Drawable paramDrawable, String paramString)
  {
    a(this.h, null, paramString);
    a(this.i, paramDrawable, null);
  }
  
  public int getTitleBarTheme()
  {
    return this.j;
  }
  
  public TextView getTitleTextView()
  {
    if ((this.f != null) && (this.f.getVisibility() == 0)) {
      return this.f;
    }
    return null;
  }
  
  public void onClick(View paramView) {}
  
  public void setDefultTitleTextView(@StringRes int paramInt)
  {
    if ((this.e != null) && (this.f != null))
    {
      this.e.removeAllViews();
      this.e.addView(this.f);
      this.f.setText(paramInt);
      this.f.setVisibility(0);
    }
  }
  
  public void setLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.b != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setLeftButtonClickenable(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setClickable(paramBoolean);
    }
    Resources localResources;
    if (this.d != null)
    {
      localResources = getResources();
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int k = c.b.common_white;; k = c.b.common_title_bar_title_botton_unable)
    {
      k = localResources.getColor(k);
      this.d.setTextColor(k);
      return;
    }
  }
  
  public void setLeftButtonEnable(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftButtonVisible(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
  
  public void setRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.g != null) {
      this.g.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRightButtonClickenable(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.setClickable(paramBoolean);
    }
    Object localObject;
    if (this.i != null)
    {
      localObject = getResources();
      if (!paramBoolean) {
        break label67;
      }
      k = c.b.common_white;
      ((Resources)localObject).getColor(k);
      localObject = this.i;
      if (!paramBoolean) {
        break label74;
      }
    }
    label67:
    label74:
    for (int k = -65536;; k = -16776961)
    {
      ((TextView)localObject).setTextColor(k);
      this.i.invalidate();
      return;
      k = 17170444;
      break;
    }
  }
  
  public void setRightButtonEnable(boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.setEnabled(paramBoolean);
    }
  }
  
  public void setRightButtonView(View paramView)
  {
    if ((paramView != null) && (this.g != null))
    {
      this.g.removeAllViews();
      this.g.addView(paramView);
    }
  }
  
  public void setRightButtonVisible(int paramInt)
  {
    if (this.g != null) {
      this.g.setVisibility(paramInt);
    }
  }
  
  public void setTitle(@StringRes int paramInt)
  {
    a(getResources().getString(paramInt), null);
  }
  
  public void setTitle(String paramString)
  {
    a(paramString, null);
  }
  
  public void setTitleBarBackground(int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setTitleBarTheme(int paramInt)
  {
    this.j = paramInt;
    if (this.a != null) {}
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.a.setBackgroundResource(c.b.common_white);
      return;
    case 1: 
      this.a.setBackgroundResource(c.b.common_transparent);
      return;
    }
    this.a.setBackgroundResource(c.b.black);
  }
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.e != null) {
      this.e.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleTextMaxWidth(int paramInt)
  {
    if (this.f != null) {
      this.f.setMaxWidth(t.a(this.f.getContext(), paramInt));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\view\widget\TitleBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */