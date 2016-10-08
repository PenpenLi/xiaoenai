package com.xiaoenai.app.classes.forum.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.classes.common.widget.RedView;
import com.xiaoenai.app.utils.ab;

public class RedPointThreeTabLayout
  extends LinearLayout
{
  private a a;
  private ColorStateList b;
  private int c = 0;
  @BindView(2131560114)
  FrameLayout mFirstLayout;
  @BindView(2131560115)
  RedView mFirstRedView;
  @BindView(2131560117)
  FrameLayout mLastLayout;
  @BindView(2131560118)
  RedView mLastRedView;
  @BindView(2131560038)
  FrameLayout mMidLayout;
  @BindView(2131560116)
  RedView mMidRedView;
  
  public RedPointThreeTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedPointThreeTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public RedPointThreeTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public RedPointThreeTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.mFirstRedView.setSelected(false);
    this.mFirstLayout.setSelected(false);
    this.mMidRedView.setSelected(false);
    this.mMidLayout.setSelected(false);
    this.mLastRedView.setSelected(false);
    this.mLastLayout.setSelected(false);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2130903390, this);
    ButterKnife.bind(this);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RedPointThreeTabLayout);
    String str1 = paramAttributeSet.getString(0);
    String str2 = paramAttributeSet.getString(1);
    String str3 = paramAttributeSet.getString(2);
    this.mFirstRedView.setText(str1);
    this.mMidRedView.setText(str2);
    this.mLastRedView.setText(str3);
    int i = paramAttributeSet.getResourceId(3, 2130838991);
    this.mFirstLayout.setBackgroundResource(i);
    this.mMidLayout.setBackgroundResource(i);
    this.mLastLayout.setBackgroundResource(i);
    i = paramAttributeSet.getDimensionPixelOffset(4, ab.c(paramContext, 16.0F));
    this.mFirstRedView.setTextSize(ab.b(paramContext, i));
    this.mMidRedView.setTextSize(ab.b(paramContext, i));
    this.mLastRedView.setTextSize(ab.b(paramContext, i));
    this.b = paramAttributeSet.getColorStateList(5);
    setRedTextViewColorList(this.b);
    this.mLastRedView.a.setPadding(ab.a(4.0F), ab.a(1.0F), ab.a(4.0F), ab.a(1.0F));
    paramAttributeSet.recycle();
    setCurrentPosition(0);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.mFirstRedView.b();
      this.mMidRedView.b();
      this.mLastRedView.b();
      return;
    case 0: 
      this.mFirstRedView.b();
      return;
    case 1: 
      this.mMidRedView.b();
      return;
    }
    this.mLastRedView.b();
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.mFirstRedView.a();
      this.mMidRedView.a();
      this.mLastRedView.a();
      return;
    case 0: 
      this.mFirstRedView.a();
      return;
    case 1: 
      this.mMidRedView.a();
      return;
    }
    this.mLastRedView.a();
  }
  
  public int getCurrentPosition()
  {
    return this.c;
  }
  
  public a getOnTabSelectedListener()
  {
    return this.a;
  }
  
  @OnClick({2131560114})
  void onFirstClick()
  {
    setCurrentPosition(0);
    if (this.a != null) {
      this.a.a(this.mFirstRedView, 0);
    }
  }
  
  @OnClick({2131560117})
  void onLastClick()
  {
    setCurrentPosition(2);
    if (this.a != null) {
      this.a.a(this.mFirstRedView, 2);
    }
  }
  
  @OnClick({2131560038})
  void onMidClick()
  {
    setCurrentPosition(1);
    if (this.a != null) {
      this.a.a(this.mFirstRedView, 1);
    }
  }
  
  public void setCurrentPosition(int paramInt)
  {
    a();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.c = paramInt;
      return;
      this.mFirstRedView.setSelected(true);
      this.mFirstLayout.setSelected(true);
      continue;
      this.mMidRedView.setSelected(true);
      this.mMidLayout.setSelected(true);
      continue;
      this.mLastRedView.setSelected(true);
      this.mLastLayout.setSelected(true);
    }
  }
  
  public void setOnTabSelectedListener(a parama)
  {
    this.a = parama;
  }
  
  public void setRedTextViewColorList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.b = paramColorStateList;
      this.mFirstRedView.setTextColor(paramColorStateList);
      this.mMidRedView.setTextColor(paramColorStateList);
      this.mLastRedView.setTextColor(paramColorStateList);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\RedPointThreeTabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */