package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.support.v7.view.menu.f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends AbsActionBarView
{
  private static final String TAG = "ActionBarContextView";
  private View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, a.k.ActionMode, paramInt, 0);
    setBackgroundDrawable(paramContext.getDrawable(a.k.ActionMode_background));
    this.mTitleStyleRes = paramContext.getResourceId(a.k.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = paramContext.getResourceId(a.k.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = paramContext.getLayoutDimension(a.k.ActionMode_height, 0);
    this.mCloseItemLayout = paramContext.getResourceId(a.k.ActionMode_closeItemLayout, a.h.abc_action_mode_close_item_material);
    paramContext.recycle();
  }
  
  private void initTitle()
  {
    int m = 8;
    int j = 1;
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(a.h.abc_action_bar_title_item, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(a.f.action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(a.f.action_bar_subtitle));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    int i;
    label167:
    Object localObject;
    if (!TextUtils.isEmpty(this.mTitle))
    {
      i = 1;
      if (TextUtils.isEmpty(this.mSubtitle)) {
        break label232;
      }
      localObject = this.mSubtitleView;
      if (j == 0) {
        break label237;
      }
    }
    label232:
    label237:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.mTitleLayout;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (this.mTitleLayout.getParent() == null) {
        addView(this.mTitleLayout);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label167;
    }
  }
  
  public void closeMode()
  {
    if (this.mClose == null) {
      killMode();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.e();
    }
    return false;
  }
  
  public void initForMode(b paramb)
  {
    if (this.mClose == null)
    {
      this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      addView(this.mClose);
    }
    for (;;)
    {
      this.mClose.findViewById(a.f.action_mode_close_button).setOnClickListener(new d(this, paramb));
      paramb = (f)paramb.b();
      if (this.mActionMenuPresenter != null) {
        this.mActionMenuPresenter.f();
      }
      this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
      this.mActionMenuPresenter.b(true);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.mActionMenuPresenter, this.mPopupContext);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.a(this));
      this.mMenuView.setBackgroundDrawable(null);
      addView(this.mMenuView, localLayoutParams);
      return;
      if (this.mClose.getParent() == null) {
        addView(this.mClose);
      }
    }
  }
  
  public boolean isOverflowMenuShowing()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.h();
    }
    return false;
  }
  
  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }
  
  public void killMode()
  {
    removeAllViews();
    this.mCustomView = null;
    this.mMenuView = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.e();
      this.mActionMenuPresenter.g();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent.setSource(this);
        paramAccessibilityEvent.setClassName(getClass().getName());
        paramAccessibilityEvent.setPackageName(getContext().getPackageName());
        paramAccessibilityEvent.setContentDescription(this.mTitle);
      }
    }
    else {
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = ViewUtils.isLayoutRtl(this);
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      if ((this.mClose == null) || (this.mClose.getVisibility() == 8)) {
        break label289;
      }
      localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      if (!paramBoolean) {
        break label252;
      }
      paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      label83:
      if (!paramBoolean) {
        break label261;
      }
      paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      label94:
      paramInt2 = next(i, paramInt2, paramBoolean);
    }
    label210:
    label252:
    label261:
    label284:
    label289:
    for (paramInt2 = next(positionChild(this.mClose, paramInt2, j, k, paramBoolean) + paramInt2, paramInt4, paramBoolean);; paramInt2 = i)
    {
      paramInt4 = paramInt2;
      if (this.mTitleLayout != null)
      {
        paramInt4 = paramInt2;
        if (this.mCustomView == null)
        {
          paramInt4 = paramInt2;
          if (this.mTitleLayout.getVisibility() != 8) {
            paramInt4 = paramInt2 + positionChild(this.mTitleLayout, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.mCustomView != null) {
        positionChild(this.mCustomView, paramInt4, j, k, paramBoolean);
      }
      if (paramBoolean)
      {
        paramInt1 = getPaddingLeft();
        if (this.mMenuView != null)
        {
          localObject = this.mMenuView;
          if (paramBoolean) {
            break label284;
          }
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        positionChild((View)localObject, paramInt1, j, k, paramBoolean);
        return;
        i = getPaddingLeft();
        break;
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        break label83;
        paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        break label94;
        paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
        break label210;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1073741824;
    int m = 0;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i;
    int n;
    int j;
    if (this.mContentHeight > 0)
    {
      i = this.mContentHeight;
      int i2 = getPaddingTop() + getPaddingBottom();
      paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
      n = i - i2;
      j = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.mClose != null)
      {
        paramInt1 = measureChildView(this.mClose, paramInt1, j, 0);
        localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.mMenuView != null)
      {
        paramInt1 = paramInt2;
        if (this.mMenuView.getParent() == this) {
          paramInt1 = measureChildView(this.mMenuView, paramInt2, j, 0);
        }
      }
      paramInt2 = paramInt1;
      if (this.mTitleLayout != null)
      {
        paramInt2 = paramInt1;
        if (this.mCustomView == null)
        {
          if (!this.mTitleOptional) {
            break label506;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.mTitleLayout.measure(paramInt2, j);
          int i3 = this.mTitleLayout.getMeasuredWidth();
          if (i3 > paramInt1) {
            break label494;
          }
          j = 1;
          label306:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i3;
          }
          localObject = this.mTitleLayout;
          if (j == 0) {
            break label500;
          }
          paramInt1 = 0;
          label330:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label335:
      if (this.mCustomView != null)
      {
        localObject = this.mCustomView.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject).width == -2) {
          break label522;
        }
        paramInt1 = 1073741824;
        label363:
        j = paramInt2;
        if (((ViewGroup.LayoutParams)localObject).width >= 0) {
          j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -2) {
          break label529;
        }
        paramInt2 = k;
        label395:
        if (((ViewGroup.LayoutParams)localObject).height < 0) {
          break label536;
        }
        k = Math.min(((ViewGroup.LayoutParams)localObject).height, n);
        label413:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      if (this.mContentHeight > 0) {
        break label551;
      }
      j = getChildCount();
      paramInt1 = 0;
      paramInt2 = m;
      label450:
      if (paramInt2 >= j) {
        break label543;
      }
      i = getChildAt(paramInt2).getMeasuredHeight() + i2;
      if (i <= paramInt1) {
        break label560;
      }
      paramInt1 = i;
    }
    label494:
    label500:
    label506:
    label522:
    label529:
    label536:
    label543:
    label551:
    label560:
    for (;;)
    {
      paramInt2 += 1;
      break label450;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      j = 0;
      break label306;
      paramInt1 = 8;
      break label330;
      paramInt2 = measureChildView(this.mTitleLayout, paramInt1, j, 0);
      break label335;
      paramInt1 = Integer.MIN_VALUE;
      break label363;
      paramInt2 = Integer.MIN_VALUE;
      break label395;
      k = n;
      break label413;
      setMeasuredDimension(i1, paramInt1);
      return;
      setMeasuredDimension(i1, i);
      return;
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null) {
      removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if ((paramView != null) && (this.mTitleLayout != null))
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional) {
      requestLayout();
    }
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.d();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */