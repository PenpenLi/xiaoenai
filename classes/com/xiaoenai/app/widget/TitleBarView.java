package com.xiaoenai.app.widget;

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
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.f.a;

public class TitleBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  int a = 0;
  @BindView(2131560121)
  ImageView mLeft1;
  @BindView(2131560122)
  TextView mLeft2;
  @BindView(2131560120)
  ViewGroup mLeftLayout;
  @BindView(2131560123)
  ViewGroup mMiddleLayout;
  @BindView(2131560126)
  TextView mRight1;
  @BindView(2131560127)
  TextView mRight2;
  @BindView(2131560125)
  ViewGroup mRightLayout;
  @BindView(2131560119)
  RelativeLayout mTitleRootLayout;
  @BindView(2131560124)
  TextView mTitleTextView;
  
  public TitleBarView(Context paramContext)
  {
    super(paramContext);
    RelativeLayout.inflate(paramContext, 2130903391, this);
    ButterKnife.bind(this);
  }
  
  public TitleBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    RelativeLayout.inflate(paramContext, 2130903391, this);
    ButterKnife.bind(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TitleBar);
    try
    {
      this.a = paramContext.getInt(0, 2);
      paramAttributeSet = paramContext.getString(1);
      String str1 = paramContext.getString(3);
      Drawable localDrawable1 = paramContext.getDrawable(2);
      String str2 = paramContext.getString(5);
      Drawable localDrawable2 = paramContext.getDrawable(4);
      paramContext.recycle();
      a(this.a, paramAttributeSet, str1, str2, localDrawable1, localDrawable2);
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
    a(this.mLeft1, paramDrawable1, null);
    a(this.mLeft2, null, paramString2);
    a(this.mRight1, null, paramString3);
    a(this.mRight2, paramDrawable2, null);
    this.mTitleRootLayout.setOnClickListener(this);
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
    if (this.mTitleTextView != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mTitleTextView.setText(paramString);
        this.mTitleTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mTitleTextView.setVisibility(8);
  }
  
  private void setTitleView(View paramView)
  {
    if ((this.mMiddleLayout != null) && (paramView != null))
    {
      this.mMiddleLayout.removeAllViews();
      this.mMiddleLayout.addView(paramView);
    }
  }
  
  public void a()
  {
    a(2131296397);
  }
  
  public void a(int paramInt)
  {
    a.c("refreshTopBar theme {}", new Object[] { Integer.valueOf(paramInt) });
    a.c("isNightTheme = {}", new Object[] { UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)) });
    if (paramInt == 2131296398)
    {
      if (this.mRight1 != null) {
        this.mRight1.setTextColor(getResources().getColor(2131492971));
      }
      if (this.mRight2 != null) {
        this.mRight2.setTextColor(getResources().getColor(2131492971));
      }
      if (this.mLeft2 != null) {
        this.mLeft2.setTextColor(getResources().getColor(2131492971));
      }
      if (this.mTitleTextView != null) {
        this.mTitleTextView.setTextColor(getResources().getColor(2131492971));
      }
      setTitleBarTheme(3);
      return;
    }
    if (this.mRight1 != null) {
      this.mRight1.setTextColor(getResources().getColor(2131493206));
    }
    if (this.mRight2 != null) {
      this.mRight2.setTextColor(getResources().getColor(2131493206));
    }
    if (this.mLeft2 != null) {
      this.mLeft2.setTextColor(getResources().getColor(2131493206));
    }
    if (this.mTitleTextView != null) {
      this.mTitleTextView.setTextColor(getResources().getColor(2131493206));
    }
    setTitleBarTheme(this.a);
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
    a(this.mLeft1, paramDrawable, null);
    a(this.mLeft2, null, paramString);
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
    a(this.mRight1, null, paramString);
    a(this.mRight2, paramDrawable, null);
  }
  
  public TextView getTitleTextView()
  {
    if ((this.mTitleTextView != null) && (this.mTitleTextView.getVisibility() == 0)) {
      return this.mTitleTextView;
    }
    return null;
  }
  
  public void onClick(View paramView) {}
  
  public void setLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mLeftLayout != null) {
      this.mLeftLayout.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setLeftButtonEnable(boolean paramBoolean)
  {
    if (this.mLeftLayout != null) {
      this.mLeftLayout.setEnabled(paramBoolean);
    }
  }
  
  public void setLeftButtonVisible(int paramInt)
  {
    if (this.mLeftLayout != null) {
      this.mLeftLayout.setVisibility(paramInt);
    }
  }
  
  public void setRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mRightLayout != null) {
      this.mRightLayout.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRightButtonEnable(boolean paramBoolean)
  {
    if (this.mRightLayout != null) {
      this.mRightLayout.setEnabled(paramBoolean);
    }
  }
  
  public void setRightButtonView(View paramView)
  {
    if ((paramView != null) && (this.mRightLayout != null))
    {
      this.mRightLayout.removeAllViews();
      this.mRightLayout.addView(paramView);
    }
  }
  
  public void setRightButtonVisible(int paramInt)
  {
    if (this.mRightLayout != null) {
      this.mRightLayout.setVisibility(paramInt);
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
  
  public void setTitleBarTheme(int paramInt)
  {
    this.a = paramInt;
    if (this.mTitleRootLayout != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mTitleRootLayout.setBackgroundResource(2131493168);
      return;
    case 1: 
      this.mTitleRootLayout.setBackgroundResource(2131493177);
      return;
    case 2: 
      paramInt = UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue();
      this.mTitleRootLayout.setBackgroundColor(paramInt);
      return;
    }
    this.mTitleRootLayout.setBackgroundResource(2131492973);
  }
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mMiddleLayout != null) {
      this.mMiddleLayout.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\TitleBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */