package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.m.a;
import android.support.v7.view.menu.q;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private static final String TAG = "Toolbar";
  private m.a mActionMenuPresenterCallback;
  private int mButtonGravity;
  private ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private final bb mContentInsets = new bb();
  private final AppCompatDrawableManager mDrawableManager;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  View mExpandedActionView;
  private a mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private final ArrayList<View> mHiddenViews = new ArrayList();
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  private f.a mMenuBuilderCallback;
  private ActionMenuView mMenuView;
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new ca(this);
  private ImageButton mNavButtonView;
  private OnMenuItemClickListener mOnMenuItemClickListener;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new cb(this);
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private int mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<View> mTempViews = new ArrayList();
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private int mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, a.k.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = paramContext.getResourceId(a.k.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = paramContext.getResourceId(a.k.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = paramContext.getInteger(a.k.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = 48;
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_titleMargins, 0);
    this.mTitleMarginBottom = paramInt;
    this.mTitleMarginTop = paramInt;
    this.mTitleMarginEnd = paramInt;
    this.mTitleMarginStart = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.mTitleMarginStart = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.mTitleMarginEnd = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.mTitleMarginTop = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.mTitleMarginBottom = paramInt;
    }
    this.mMaxButtonHeight = paramContext.getDimensionPixelSize(a.k.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.getDimensionPixelOffset(a.k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    int i = paramContext.getDimensionPixelOffset(a.k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    int j = paramContext.getDimensionPixelSize(a.k.Toolbar_contentInsetLeft, 0);
    int k = paramContext.getDimensionPixelSize(a.k.Toolbar_contentInsetRight, 0);
    this.mContentInsets.b(j, k);
    if ((paramInt != Integer.MIN_VALUE) || (i != Integer.MIN_VALUE)) {
      this.mContentInsets.a(paramInt, i);
    }
    this.mCollapseIcon = paramContext.getDrawable(a.k.Toolbar_collapseIcon);
    this.mCollapseDescription = paramContext.getText(a.k.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(a.k.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.mPopupContext = getContext();
    setPopupTheme(paramContext.getResourceId(a.k.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.getDrawable(a.k.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(a.k.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(a.k.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(a.k.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.getColor(a.k.Toolbar_titleTextColor, -1));
    }
    if (paramContext.hasValue(a.k.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.getColor(a.k.Toolbar_subtitleTextColor, -1));
    }
    paramContext.recycle();
    this.mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private void addCustomViewsWithGravity(List<View> paramList, int paramInt)
  {
    int i = 1;
    int j = 0;
    if (ViewCompat.getLayoutDirection(this) == 1) {}
    int m;
    int k;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      m = getChildCount();
      k = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
      paramList.clear();
      paramInt = j;
      if (i == 0) {
        break;
      }
      paramInt = m - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(localLayoutParams.gravity) == k)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i = 0;
    }
    while (paramInt < m)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.mViewType == 0) && (shouldLayout(localView)) && (getChildHorizontalGravity(localLayoutParams.gravity) == k)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private void addSystemView(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateDefaultLayoutParams();
    }
    for (;;)
    {
      ((LayoutParams)localObject).mViewType = 1;
      if ((!paramBoolean) || (this.mExpandedActionView == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mHiddenViews.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = generateLayoutParams((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void ensureCollapseButtonView()
  {
    if (this.mCollapseButtonView == null)
    {
      this.mCollapseButtonView = new ImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | this.mButtonGravity & 0x70);
      localLayoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams(localLayoutParams);
      this.mCollapseButtonView.setOnClickListener(new cc(this));
    }
  }
  
  private void ensureLogoView()
  {
    if (this.mLogoView == null) {
      this.mLogoView = new ImageView(getContext());
    }
  }
  
  private void ensureMenu()
  {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null)
    {
      f localf = (f)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null) {
        this.mExpandedMenuPresenter = new a(null);
      }
      this.mMenuView.setExpandedActionViewsExclusive(true);
      localf.a(this.mExpandedMenuPresenter, this.mPopupContext);
    }
  }
  
  private void ensureMenuView()
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = new ActionMenuView(getContext());
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800005 | this.mButtonGravity & 0x70);
      this.mMenuView.setLayoutParams(localLayoutParams);
      addSystemView(this.mMenuView, false);
    }
  }
  
  private void ensureNavButtonView()
  {
    if (this.mNavButtonView == null)
    {
      this.mNavButtonView = new ImageButton(getContext(), null, a.a.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | this.mButtonGravity & 0x70);
      this.mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int getChildHorizontalGravity(int paramInt)
  {
    int j = ViewCompat.getLayoutDirection(this);
    int i = GravityCompat.getAbsoluteGravity(paramInt, j) & 0x7;
    paramInt = i;
    switch (i)
    {
    case 2: 
    case 4: 
    default: 
      if (j == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private int getChildTop(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    int i;
    int k;
    int m;
    if (paramInt > 0)
    {
      paramInt = (j - paramInt) / 2;
      switch (getChildVerticalGravity(localLayoutParams.gravity))
      {
      default: 
        i = getPaddingTop();
        k = getPaddingBottom();
        m = getHeight();
        paramInt = (m - i - k - j) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - j - localLayoutParams.bottomMargin - paramInt;
      j = m - k - j - paramInt - i;
      if (j < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - j));
      }
    }
  }
  
  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    paramInt = i;
    switch (i)
    {
    default: 
      paramInt = this.mGravity & 0x70;
    }
    return paramInt;
  }
  
  private int getHorizontalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = MarginLayoutParamsCompat.getMarginStart(paramView);
    return MarginLayoutParamsCompat.getMarginEnd(paramView) + i;
  }
  
  private MenuInflater getMenuInflater()
  {
    return new g(getContext());
  }
  
  private int getVerticalMargins(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = paramView.topMargin;
    return paramView.bottomMargin + i;
  }
  
  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfInt)
  {
    int m = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    int n = paramList.size();
    int j = 0;
    int i = 0;
    while (j < n)
    {
      paramArrayOfInt = (View)paramList.get(j);
      LayoutParams localLayoutParams = (LayoutParams)paramArrayOfInt.getLayoutParams();
      m = localLayoutParams.leftMargin - m;
      k = localLayoutParams.rightMargin - k;
      int i1 = Math.max(0, m);
      int i2 = Math.max(0, k);
      m = Math.max(0, -m);
      k = Math.max(0, -k);
      int i3 = paramArrayOfInt.getMeasuredWidth();
      j += 1;
      i += i3 + i1 + i2;
    }
    return i;
  }
  
  private boolean isChildOrHidden(View paramView)
  {
    return (paramView.getParent() == this) || (this.mHiddenViews.contains(paramView));
  }
  
  private static boolean isCustomView(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).mViewType == 0;
  }
  
  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i + paramInt1;
  }
  
  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i);
  }
  
  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  private void postShowOverflowMenu()
  {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }
  
  private boolean shouldCollapse()
  {
    if (!this.mCollapsible) {
      return false;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label56;
      }
      View localView = getChildAt(i);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        break;
      }
      i += 1;
    }
    label56:
    return true;
  }
  
  private boolean shouldLayout(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  void addChildrenForExpandedActionView()
  {
    int i = this.mHiddenViews.size() - 1;
    while (i >= 0)
    {
      addView((View)this.mHiddenViews.get(i));
      i -= 1;
    }
    this.mHiddenViews.clear();
  }
  
  public boolean canShowOverflowMenu()
  {
    return (getVisibility() == 0) && (this.mMenuView != null) && (this.mMenuView.isOverflowReserved());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void collapseActionView()
  {
    if (this.mExpandedMenuPresenter == null) {}
    for (h localh = null;; localh = this.mExpandedMenuPresenter.b)
    {
      if (localh != null) {
        localh.collapseActionView();
      }
      return;
    }
  }
  
  public void dismissPopupMenus()
  {
    if (this.mMenuView != null) {
      this.mMenuView.dismissPopupMenus();
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getContentInsetEnd()
  {
    return this.mContentInsets.d();
  }
  
  public int getContentInsetLeft()
  {
    return this.mContentInsets.a();
  }
  
  public int getContentInsetRight()
  {
    return this.mContentInsets.b();
  }
  
  public int getContentInsetStart()
  {
    return this.mContentInsets.c();
  }
  
  public Drawable getLogo()
  {
    if (this.mLogoView != null) {
      return this.mLogoView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.mLogoView != null) {
      return this.mLogoView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    ensureMenu();
    return this.mMenuView.getMenu();
  }
  
  @Nullable
  public CharSequence getNavigationContentDescription()
  {
    if (this.mNavButtonView != null) {
      return this.mNavButtonView.getContentDescription();
    }
    return null;
  }
  
  @Nullable
  public Drawable getNavigationIcon()
  {
    if (this.mNavButtonView != null) {
      return this.mNavButtonView.getDrawable();
    }
    return null;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    ensureMenu();
    return this.mMenuView.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitleText;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitleText;
  }
  
  public DecorToolbar getWrapper()
  {
    if (this.mWrapper == null) {
      this.mWrapper = new ToolbarWidgetWrapper(this, true);
    }
    return this.mWrapper;
  }
  
  public boolean hasExpandedActionView()
  {
    return (this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.b != null);
  }
  
  public boolean hideOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.hideOverflowMenu());
  }
  
  public void inflateMenu(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowing());
  }
  
  public boolean isTitleTruncated()
  {
    if (this.mTitleTextView == null) {}
    for (;;)
    {
      return false;
      Layout localLayout = this.mTitleTextView.getLayout();
      if (localLayout != null)
      {
        int j = localLayout.getLineCount();
        int i = 0;
        while (i < j)
        {
          if (localLayout.getEllipsisCount(i) > 0) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 9) {
      this.mEatingHover = false;
    }
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.mEatingHover = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    int i1;
    int i4;
    int i;
    int i2;
    int i3;
    int i5;
    int[] arrayOfInt;
    int n;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      k = 1;
      i1 = getWidth();
      i4 = getHeight();
      i = getPaddingLeft();
      i2 = getPaddingRight();
      i3 = getPaddingTop();
      i5 = getPaddingBottom();
      paramInt4 = i1 - i2;
      arrayOfInt = this.mTempMargins;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      n = ViewCompat.getMinimumHeight(this);
      if (!shouldLayout(this.mNavButtonView)) {
        break label1565;
      }
      if (k == 0) {
        break label876;
      }
      paramInt4 = layoutChildRight(this.mNavButtonView, paramInt4, arrayOfInt, n);
      paramInt1 = i;
    }
    for (;;)
    {
      label111:
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      if (shouldLayout(this.mCollapseButtonView))
      {
        if (k != 0)
        {
          paramInt2 = layoutChildRight(this.mCollapseButtonView, paramInt4, arrayOfInt, n);
          paramInt3 = paramInt1;
        }
      }
      else
      {
        label151:
        paramInt1 = paramInt2;
        paramInt4 = paramInt3;
        if (shouldLayout(this.mMenuView))
        {
          if (k == 0) {
            break label915;
          }
          paramInt4 = layoutChildLeft(this.mMenuView, paramInt3, arrayOfInt, n);
          paramInt1 = paramInt2;
        }
        label191:
        arrayOfInt[0] = Math.max(0, getContentInsetLeft() - paramInt4);
        arrayOfInt[1] = Math.max(0, getContentInsetRight() - (i1 - i2 - paramInt1));
        paramInt3 = Math.max(paramInt4, getContentInsetLeft());
        paramInt4 = Math.min(paramInt1, i1 - i2 - getContentInsetRight());
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (shouldLayout(this.mExpandedActionView))
        {
          if (k == 0) {
            break label936;
          }
          paramInt2 = layoutChildRight(this.mExpandedActionView, paramInt4, arrayOfInt, n);
          paramInt1 = paramInt3;
        }
        label293:
        if (!shouldLayout(this.mLogoView)) {
          break label1559;
        }
        if (k == 0) {
          break label957;
        }
        paramInt2 = layoutChildRight(this.mLogoView, paramInt2, arrayOfInt, n);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label326:
        paramBoolean = shouldLayout(this.mTitleTextView);
        boolean bool = shouldLayout(this.mSubtitleTextView);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.mTitleTextView.getMeasuredHeight();
          paramInt1 = 0 + (((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4));
        }
        int j;
        if (bool)
        {
          localObject1 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          j = this.mSubtitleTextView.getMeasuredHeight();
        }
        for (int m = ((LayoutParams)localObject1).bottomMargin + (paramInt4 + j) + paramInt1;; m = paramInt1)
        {
          label464:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label975;
            }
            localObject1 = this.mTitleTextView;
            if (!bool) {
              break label984;
            }
            localObject2 = this.mSubtitleTextView;
            label475:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.mTitleTextView.getMeasuredWidth() <= 0)) && ((!bool) || (this.mSubtitleTextView.getMeasuredWidth() <= 0))) {
              break label993;
            }
            j = 1;
            label527:
            switch (this.mGravity & 0x70)
            {
            default: 
              paramInt1 = (i4 - i3 - i5 - m) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.mTitleMarginTop) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.mTitleMarginTop;
              }
              break;
            }
          }
          label599:
          label604:
          label620:
          label876:
          label915:
          label936:
          label957:
          label975:
          label984:
          label993:
          label1113:
          label1527:
          label1544:
          label1550:
          for (;;)
          {
            paramInt1 = i3 + paramInt1;
            if (k != 0) {
              if (j != 0)
              {
                paramInt4 = this.mTitleMarginStart;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1544;
                }
                localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                paramInt4 = paramInt2 - this.mTitleTextView.getMeasuredWidth();
                k = this.mTitleTextView.getMeasuredHeight() + paramInt1;
                this.mTitleTextView.layout(paramInt4, paramInt1, paramInt2, k);
                m = this.mTitleMarginEnd;
                paramInt1 = k + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= m;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                k = this.mSubtitleTextView.getMeasuredWidth();
                m = this.mSubtitleTextView.getMeasuredHeight() + paramInt1;
                this.mSubtitleTextView.layout(paramInt2 - k, paramInt1, paramInt2, m);
                paramInt1 = this.mTitleMarginEnd;
                k = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (j != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  addCustomViewsWithGravity(this.mTempViews, 3);
                  paramInt3 = this.mTempViews.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = layoutChildLeft((View)this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, n);
                      paramInt2 += 1;
                      continue;
                      k = 0;
                      break;
                      paramInt1 = layoutChildLeft(this.mNavButtonView, i, arrayOfInt, n);
                      break label111;
                      paramInt3 = layoutChildLeft(this.mCollapseButtonView, paramInt1, arrayOfInt, n);
                      paramInt2 = paramInt4;
                      break label151;
                      paramInt1 = layoutChildRight(this.mMenuView, paramInt2, arrayOfInt, n);
                      paramInt4 = paramInt3;
                      break label191;
                      paramInt1 = layoutChildLeft(this.mExpandedActionView, paramInt3, arrayOfInt, n);
                      paramInt2 = paramInt4;
                      break label293;
                      paramInt3 = layoutChildLeft(this.mLogoView, paramInt1, arrayOfInt, n);
                      break label326;
                      localObject1 = this.mSubtitleTextView;
                      break label464;
                      localObject2 = this.mTitleTextView;
                      break label475;
                      j = 0;
                      break label527;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.mTitleMarginTop;
                      break label604;
                      paramInt4 = i4 - i5 - m - paramInt1 - i3;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.mTitleMarginBottom) {
                        break label1550;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.mTitleMarginBottom - paramInt4));
                      break label599;
                      paramInt1 = i4 - i5 - ((LayoutParams)localObject2).bottomMargin - this.mTitleMarginBottom - m;
                      break label604;
                      paramInt4 = 0;
                      break label620;
                      if (j != 0)
                      {
                        paramInt4 = this.mTitleMarginStart;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1527;
                        }
                        localObject1 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                        k = this.mTitleTextView.getMeasuredWidth() + paramInt3;
                        paramInt4 = this.mTitleTextView.getMeasuredHeight() + paramInt1;
                        this.mTitleTextView.layout(paramInt3, paramInt1, k, paramInt4);
                        m = this.mTitleMarginEnd;
                        paramInt1 = ((LayoutParams)localObject1).bottomMargin;
                        k += m;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                      paramInt4 = paramInt1 + ((LayoutParams)localObject1).topMargin;
                      paramInt1 = this.mSubtitleTextView.getMeasuredWidth() + paramInt3;
                      m = this.mSubtitleTextView.getMeasuredHeight() + paramInt4;
                      this.mSubtitleTextView.layout(paramInt3, paramInt4, paramInt1, m);
                      paramInt4 = this.mTitleMarginEnd;
                      m = ((LayoutParams)localObject1).bottomMargin;
                    }
                    for (m = paramInt4 + paramInt1;; m = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (j == 0) {
                        break;
                      }
                      paramInt1 = Math.max(k, m);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1113;
                      addCustomViewsWithGravity(this.mTempViews, 5);
                      paramInt3 = this.mTempViews.size();
                      paramInt2 = 0;
                      while (paramInt2 < paramInt3)
                      {
                        paramInt4 = layoutChildRight((View)this.mTempViews.get(paramInt2), paramInt4, arrayOfInt, n);
                        paramInt2 += 1;
                      }
                      addCustomViewsWithGravity(this.mTempViews, 1);
                      paramInt3 = getViewListMeasuredWidth(this.mTempViews, arrayOfInt);
                      paramInt2 = (i1 - i - i2) / 2 + i - paramInt3 / 2;
                      paramInt3 += paramInt2;
                      if (paramInt2 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.mTempViews.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = layoutChildLeft((View)this.mTempViews.get(paramInt1), paramInt2, arrayOfInt, n);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt2;
                        if (paramInt3 > paramInt4) {
                          paramInt1 = paramInt2 - (paramInt3 - paramInt4);
                        }
                      }
                      this.mTempViews.clear();
                      return;
                    }
                    k = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1559:
        paramInt3 = paramInt1;
      }
      label1565:
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = 0;
    int[] arrayOfInt = this.mTempMargins;
    int n;
    int i1;
    int i;
    int i2;
    int j;
    int i3;
    label539:
    View localView;
    if (ViewUtils.isLayoutRtl(this))
    {
      n = 0;
      i1 = 1;
      i = 0;
      if (shouldLayout(this.mNavButtonView))
      {
        measureChildConstrained(this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        i = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        m = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        k = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
      }
      i2 = i;
      i = k;
      j = m;
      if (shouldLayout(this.mCollapseButtonView))
      {
        measureChildConstrained(this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        i2 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        j = Math.max(m, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        i = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState(this.mCollapseButtonView));
      }
      k = getContentInsetStart();
      i3 = 0 + Math.max(k, i2);
      arrayOfInt[i1] = Math.max(0, k - i2);
      i1 = 0;
      k = i;
      m = j;
      if (shouldLayout(this.mMenuView))
      {
        measureChildConstrained(this.mMenuView, paramInt1, i3, paramInt2, 0, this.mMaxButtonHeight);
        i1 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        m = Math.max(j, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        k = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState(this.mMenuView));
      }
      i = getContentInsetEnd();
      i2 = i3 + Math.max(i, i1);
      arrayOfInt[n] = Math.max(0, i - i1);
      i1 = i2;
      i = k;
      j = m;
      if (shouldLayout(this.mExpandedActionView))
      {
        i1 = i2 + measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i2, paramInt2, 0, arrayOfInt);
        j = Math.max(m, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        i = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState(this.mExpandedActionView));
      }
      k = i1;
      m = i;
      n = j;
      if (shouldLayout(this.mLogoView))
      {
        k = i1 + measureChildCollapseMargins(this.mLogoView, paramInt1, i1, paramInt2, 0, arrayOfInt);
        n = Math.max(j, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        m = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState(this.mLogoView));
      }
      i2 = getChildCount();
      i1 = 0;
      j = n;
      i = m;
      m = i1;
      i1 = k;
      if (m >= i2) {
        break label646;
      }
      localView = getChildAt(m);
      if (((LayoutParams)localView.getLayoutParams()).mViewType != 0) {
        break label953;
      }
      if (shouldLayout(localView)) {
        break label595;
      }
    }
    label595:
    label646:
    label953:
    for (;;)
    {
      m += 1;
      break label539;
      n = 1;
      i1 = 0;
      break;
      i1 += measureChildCollapseMargins(localView, paramInt1, i1, paramInt2, 0, arrayOfInt);
      j = Math.max(j, localView.getMeasuredHeight() + getVerticalMargins(localView));
      i = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState(localView));
      continue;
      n = 0;
      m = 0;
      int i4 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int i5 = this.mTitleMarginStart + this.mTitleMarginEnd;
      k = i;
      if (shouldLayout(this.mTitleTextView))
      {
        measureChildCollapseMargins(this.mTitleTextView, paramInt1, i1 + i5, paramInt2, i4, arrayOfInt);
        k = this.mTitleTextView.getMeasuredWidth();
        n = getHorizontalMargins(this.mTitleTextView) + k;
        m = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        k = ViewUtils.combineMeasuredStates(i, ViewCompat.getMeasuredState(this.mTitleTextView));
      }
      i3 = m;
      i2 = n;
      i = k;
      if (shouldLayout(this.mSubtitleTextView))
      {
        i2 = Math.max(n, measureChildCollapseMargins(this.mSubtitleTextView, paramInt1, i1 + i5, paramInt2, i4 + m, arrayOfInt));
        i3 = m + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        i = ViewUtils.combineMeasuredStates(k, ViewCompat.getMeasuredState(this.mSubtitleTextView));
      }
      j = Math.max(j, i3);
      n = getPaddingLeft();
      i3 = getPaddingRight();
      k = getPaddingTop();
      m = getPaddingBottom();
      n = ViewCompat.resolveSizeAndState(Math.max(i2 + i1 + (n + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
      paramInt1 = ViewCompat.resolveSizeAndState(Math.max(j + (k + m), getSuggestedMinimumHeight()), paramInt2, i << 16);
      if (shouldCollapse()) {
        paramInt1 = 0;
      }
      setMeasuredDimension(n, paramInt1);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.mMenuView != null) {}
    for (paramParcelable = this.mMenuView.peekMenu();; paramParcelable = null)
    {
      if ((localSavedState.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.expandedMenuItemId);
        if (paramParcelable != null) {
          MenuItemCompat.expandActionView(paramParcelable);
        }
      }
      if (!localSavedState.isOverflowOpen) {
        break;
      }
      postShowOverflowMenu();
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    bb localbb = this.mContentInsets;
    if (paramInt == 1) {}
    for (;;)
    {
      localbb.a(bool);
      return;
      bool = false;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.b != null)) {
      localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.b.getItemId();
    }
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0) {
      this.mEatingTouch = false;
    }
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.mEatingTouch = false;
    }
    return true;
  }
  
  void removeChildrenForExpandedActionView()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).mViewType != 2) && (localView != this.mMenuView))
      {
        removeViewAt(i);
        this.mHiddenViews.add(localView);
      }
      i -= 1;
    }
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    this.mContentInsets.b(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    this.mContentInsets.a(paramInt1, paramInt2);
  }
  
  public void setLogo(@DrawableRes int paramInt)
  {
    setLogo(this.mDrawableManager.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (!isChildOrHidden(this.mLogoView)) {
        addSystemView(this.mLogoView, true);
      }
    }
    for (;;)
    {
      if (this.mLogoView != null) {
        this.mLogoView.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.mLogoView != null) && (isChildOrHidden(this.mLogoView)))
      {
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
      }
    }
  }
  
  public void setLogoDescription(@StringRes int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureLogoView();
    }
    if (this.mLogoView != null) {
      this.mLogoView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setMenu(f paramf, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramf == null) && (this.mMenuView == null)) {}
    f localf;
    do
    {
      return;
      ensureMenuView();
      localf = this.mMenuView.peekMenu();
    } while (localf == paramf);
    if (localf != null)
    {
      localf.b(this.mOuterActionMenuPresenter);
      localf.b(this.mExpandedMenuPresenter);
    }
    if (this.mExpandedMenuPresenter == null) {
      this.mExpandedMenuPresenter = new a(null);
    }
    paramActionMenuPresenter.c(true);
    if (paramf != null)
    {
      paramf.a(paramActionMenuPresenter, this.mPopupContext);
      paramf.a(this.mExpandedMenuPresenter, this.mPopupContext);
    }
    for (;;)
    {
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setPresenter(paramActionMenuPresenter);
      this.mOuterActionMenuPresenter = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.a(this.mPopupContext, null);
      this.mExpandedMenuPresenter.a(this.mPopupContext, null);
      paramActionMenuPresenter.a(true);
      this.mExpandedMenuPresenter.a(true);
    }
  }
  
  public void setMenuCallbacks(m.a parama, f.a parama1)
  {
    this.mActionMenuPresenterCallback = parama;
    this.mMenuBuilderCallback = parama1;
    if (this.mMenuView != null) {
      this.mMenuView.setMenuCallbacks(parama, parama1);
    }
  }
  
  public void setNavigationContentDescription(@StringRes int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ensureNavButtonView();
    }
    if (this.mNavButtonView != null) {
      this.mNavButtonView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(@DrawableRes int paramInt)
  {
    setNavigationIcon(this.mDrawableManager.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (!isChildOrHidden(this.mNavButtonView)) {
        addSystemView(this.mNavButtonView, true);
      }
    }
    for (;;)
    {
      if (this.mNavButtonView != null) {
        this.mNavButtonView.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.mNavButtonView != null) && (isChildOrHidden(this.mNavButtonView)))
      {
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    ensureMenu();
    this.mMenuView.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(@StyleRes int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0) {
        this.mPopupContext = getContext();
      }
    }
    else
    {
      return;
    }
    this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(@StringRes int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mSubtitleTextView == null)
      {
        Context localContext = getContext();
        this.mSubtitleTextView = new TextView(localContext);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mSubtitleTextAppearance != 0) {
          this.mSubtitleTextView.setTextAppearance(localContext, this.mSubtitleTextAppearance);
        }
        if (this.mSubtitleTextColor != 0) {
          this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
        }
      }
      if (!isChildOrHidden(this.mSubtitleTextView)) {
        addSystemView(this.mSubtitleTextView, true);
      }
    }
    for (;;)
    {
      if (this.mSubtitleTextView != null) {
        this.mSubtitleTextView.setText(paramCharSequence);
      }
      this.mSubtitleText = paramCharSequence;
      return;
      if ((this.mSubtitleTextView != null) && (isChildOrHidden(this.mSubtitleTextView)))
      {
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
      }
    }
  }
  
  public void setSubtitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mSubtitleTextAppearance = paramInt;
    if (this.mSubtitleTextView != null) {
      this.mSubtitleTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setSubtitleTextColor(@ColorInt int paramInt)
  {
    this.mSubtitleTextColor = paramInt;
    if (this.mSubtitleTextView != null) {
      this.mSubtitleTextView.setTextColor(paramInt);
    }
  }
  
  public void setTitle(@StringRes int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mTitleTextView == null)
      {
        Context localContext = getContext();
        this.mTitleTextView = new TextView(localContext);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mTitleTextAppearance != 0) {
          this.mTitleTextView.setTextAppearance(localContext, this.mTitleTextAppearance);
        }
        if (this.mTitleTextColor != 0) {
          this.mTitleTextView.setTextColor(this.mTitleTextColor);
        }
      }
      if (!isChildOrHidden(this.mTitleTextView)) {
        addSystemView(this.mTitleTextView, true);
      }
    }
    for (;;)
    {
      if (this.mTitleTextView != null) {
        this.mTitleTextView.setText(paramCharSequence);
      }
      this.mTitleText = paramCharSequence;
      return;
      if ((this.mTitleTextView != null) && (isChildOrHidden(this.mTitleTextView)))
      {
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
      }
    }
  }
  
  public void setTitleTextAppearance(Context paramContext, @StyleRes int paramInt)
  {
    this.mTitleTextAppearance = paramInt;
    if (this.mTitleTextView != null) {
      this.mTitleTextView.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTitleTextColor(@ColorInt int paramInt)
  {
    this.mTitleTextColor = paramInt;
    if (this.mTitleTextView != null) {
      this.mTitleTextView.setTextColor(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.showOverflowMenu());
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    static final int CUSTOM = 0;
    static final int EXPANDED = 2;
    static final int SYSTEM = 1;
    int mViewType = 0;
    
    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }
    
    public LayoutParams(@NonNull Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.mViewType = paramLayoutParams.mViewType;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      copyMarginsFromCompat(paramMarginLayoutParams);
    }
    
    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new cd();
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.expandedMenuItemId = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isOverflowOpen = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.expandedMenuItemId);
      if (this.isOverflowOpen) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  private class a
    implements m
  {
    f a;
    h b;
    
    private a() {}
    
    public void a(Context paramContext, f paramf)
    {
      if ((this.a != null) && (this.b != null)) {
        this.a.d(this.b);
      }
      this.a = paramf;
    }
    
    public void a(f paramf, boolean paramBoolean) {}
    
    public void a(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.b != null)
      {
        j = k;
        if (this.a != null)
        {
          m = this.a.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.a.getItem(i) == this.b) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            b(this.a, this.b);
          }
          return;
        }
        i += 1;
      }
    }
    
    public boolean a(f paramf, h paramh)
    {
      Toolbar.this.ensureCollapseButtonView();
      if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
        Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
      }
      Toolbar.this.mExpandedActionView = paramh.getActionView();
      this.b = paramh;
      if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this)
      {
        paramf = Toolbar.this.generateDefaultLayoutParams();
        paramf.gravity = (0x800003 | Toolbar.this.mButtonGravity & 0x70);
        paramf.mViewType = 2;
        Toolbar.this.mExpandedActionView.setLayoutParams(paramf);
        Toolbar.this.addView(Toolbar.this.mExpandedActionView);
      }
      Toolbar.this.removeChildrenForExpandedActionView();
      Toolbar.this.requestLayout();
      paramh.e(true);
      if ((Toolbar.this.mExpandedActionView instanceof c)) {
        ((c)Toolbar.this.mExpandedActionView).onActionViewExpanded();
      }
      return true;
    }
    
    public boolean a(q paramq)
    {
      return false;
    }
    
    public boolean b()
    {
      return false;
    }
    
    public boolean b(f paramf, h paramh)
    {
      if ((Toolbar.this.mExpandedActionView instanceof c)) {
        ((c)Toolbar.this.mExpandedActionView).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
      Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
      Toolbar.this.mExpandedActionView = null;
      Toolbar.this.addChildrenForExpandedActionView();
      this.b = null;
      Toolbar.this.requestLayout();
      paramh.e(false);
      return true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */