package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.a.a.a;
import android.support.v7.app.ActionBar.b;
import android.support.v7.view.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final int FADE_DURATION = 200;
  private static final String TAG = "ScrollingTabContainerView";
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private b mTabClickListener;
  private LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
  protected ViewPropertyAnimatorCompat mVisibilityAnim;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = a.a(paramContext);
    setContentHeight(paramContext.e());
    this.mStackedTabMaxWidth = paramContext.g();
    this.mTabLayout = createTabLayout();
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private Spinner createSpinner()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, a.a.actionDropDownStyle);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  private LinearLayoutCompat createTabLayout()
  {
    LinearLayoutCompat localLinearLayoutCompat = new LinearLayoutCompat(getContext(), null, a.a.actionBarTabBarStyle);
    localLinearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    localLinearLayoutCompat.setGravity(17);
    localLinearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    return localLinearLayoutCompat;
  }
  
  private c createTabView(ActionBar.b paramb, boolean paramBoolean)
  {
    paramb = new c(getContext(), paramb, paramBoolean);
    if (paramBoolean)
    {
      paramb.setBackgroundDrawable(null);
      paramb.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
      return paramb;
    }
    paramb.setFocusable(true);
    if (this.mTabClickListener == null) {
      this.mTabClickListener = new b(null);
    }
    paramb.setOnClickListener(this.mTabClickListener);
    return paramb;
  }
  
  private boolean isCollapsed()
  {
    return (this.mTabSpinner != null) && (this.mTabSpinner.getParent() == this);
  }
  
  private void performCollapse()
  {
    if (isCollapsed()) {
      return;
    }
    if (this.mTabSpinner == null) {
      this.mTabSpinner = createSpinner();
    }
    removeView(this.mTabLayout);
    addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
    if (this.mTabSpinner.getAdapter() == null) {
      this.mTabSpinner.setAdapter(new a(null));
    }
    if (this.mTabSelector != null)
    {
      removeCallbacks(this.mTabSelector);
      this.mTabSelector = null;
    }
    this.mTabSpinner.setSelection(this.mSelectedTabIndex);
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {
      return false;
    }
    removeView(this.mTabSpinner);
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.mTabSpinner.getSelectedItemPosition());
    return false;
  }
  
  public void addTab(ActionBar.b paramb, int paramInt, boolean paramBoolean)
  {
    paramb = createTabView(paramb, false);
    this.mTabLayout.addView(paramb, paramInt, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((a)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramb.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.b paramb, boolean paramBoolean)
  {
    paramb = createTabView(paramb, false);
    this.mTabLayout.addView(paramb, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((a)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramb.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    View localView = this.mTabLayout.getChildAt(paramInt);
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
    this.mTabSelector = new bd(this, localView);
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        ViewCompat.setAlpha(this, 0.0F);
      }
      localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat.setDuration(200L);
      localViewPropertyAnimatorCompat.setInterpolator(sAlphaInterpolator);
      localViewPropertyAnimatorCompat.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
      localViewPropertyAnimatorCompat.start();
      return;
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(0.0F);
    localViewPropertyAnimatorCompat.setDuration(200L);
    localViewPropertyAnimatorCompat.setInterpolator(sAlphaInterpolator);
    localViewPropertyAnimatorCompat.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
    localViewPropertyAnimatorCompat.start();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = a.a(getContext());
    setContentHeight(paramConfiguration.e());
    this.mStackedTabMaxWidth = paramConfiguration.g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((c)paramView).b().d();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.mTabLayout.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != Integer.MIN_VALUE))) {
        break label195;
      }
      if (j <= 2) {
        break label182;
      }
      this.mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label72:
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      label87:
      i = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      if ((bool) || (!this.mAllowCollapse)) {
        break label203;
      }
      label110:
      if (paramInt2 == 0) {
        break label216;
      }
      this.mTabLayout.measure(0, i);
      if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label208;
      }
      performCollapse();
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.mSelectedTabIndex);
      }
      return;
      bool = false;
      break;
      label182:
      this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label72;
      label195:
      this.mMaxTabWidth = -1;
      break label87;
      label203:
      paramInt2 = 0;
      break label110;
      label208:
      performExpand();
      continue;
      label216:
      performExpand();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    if (this.mTabSpinner != null) {
      ((a)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    if (this.mTabSpinner != null) {
      ((a)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.mSelectedTabIndex = paramInt;
    int j = this.mTabLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = this.mTabLayout.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        i += 1;
        break;
      }
    }
    if ((this.mTabSpinner != null) && (paramInt >= 0)) {
      this.mTabSpinner.setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((c)this.mTabLayout.getChildAt(paramInt)).a();
    if (this.mTabSpinner != null) {
      ((a)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  protected class VisibilityAnimListener
    implements ViewPropertyAnimatorListener
  {
    private boolean mCanceled = false;
    private int mFinalVisibility;
    
    protected VisibilityAnimListener() {}
    
    public void onAnimationCancel(View paramView)
    {
      this.mCanceled = true;
    }
    
    public void onAnimationEnd(View paramView)
    {
      if (this.mCanceled) {
        return;
      }
      ScrollingTabContainerView.this.mVisibilityAnim = null;
      ScrollingTabContainerView.this.setVisibility(this.mFinalVisibility);
    }
    
    public void onAnimationStart(View paramView)
    {
      ScrollingTabContainerView.this.setVisibility(0);
      this.mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
    {
      this.mFinalVisibility = paramInt;
      ScrollingTabContainerView.this.mVisibilityAnim = paramViewPropertyAnimatorCompat;
      return this;
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      return ScrollingTabContainerView.this.mTabLayout.getChildCount();
    }
    
    public Object getItem(int paramInt)
    {
      return ((ScrollingTabContainerView.c)ScrollingTabContainerView.this.mTabLayout.getChildAt(paramInt)).b();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return ScrollingTabContainerView.this.createTabView((ActionBar.b)getItem(paramInt), true);
      }
      ((ScrollingTabContainerView.c)paramView).a((ActionBar.b)getItem(paramInt));
      return paramView;
    }
  }
  
  private class b
    implements View.OnClickListener
  {
    private b() {}
    
    public void onClick(View paramView)
    {
      ((ScrollingTabContainerView.c)paramView).b().d();
      int j = ScrollingTabContainerView.this.mTabLayout.getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
        if (localView == paramView) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private class c
    extends LinearLayoutCompat
    implements View.OnLongClickListener
  {
    private final int[] b = { 16842964 };
    private ActionBar.b c;
    private TextView d;
    private ImageView e;
    private View f;
    
    public c(Context paramContext, ActionBar.b paramb, boolean paramBoolean)
    {
      super(null, a.a.actionBarTabStyle);
      this.c = paramb;
      this$1 = TintTypedArray.obtainStyledAttributes(paramContext, null, this.b, a.a.actionBarTabStyle, 0);
      if (ScrollingTabContainerView.this.hasValue(0)) {
        setBackgroundDrawable(ScrollingTabContainerView.this.getDrawable(0));
      }
      ScrollingTabContainerView.this.recycle();
      if (paramBoolean) {
        setGravity(8388627);
      }
      a();
    }
    
    public void a()
    {
      Object localObject1 = this.c;
      Object localObject2 = ((ActionBar.b)localObject1).c();
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.f = ((View)localObject2);
        if (this.d != null) {
          this.d.setVisibility(8);
        }
        if (this.e != null)
        {
          this.e.setVisibility(8);
          this.e.setImageDrawable(null);
        }
        return;
      }
      if (this.f != null)
      {
        removeView(this.f);
        this.f = null;
      }
      Object localObject3 = ((ActionBar.b)localObject1).a();
      localObject2 = ((ActionBar.b)localObject1).b();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.e == null)
        {
          localObject4 = new ImageView(getContext());
          LinearLayoutCompat.LayoutParams localLayoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.e = ((ImageView)localObject4);
        }
        this.e.setImageDrawable((Drawable)localObject3);
        this.e.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label360;
        }
        i = 1;
        label207:
        if (i == 0) {
          break label366;
        }
        if (this.d == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, a.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayoutCompat.LayoutParams(-2, -2);
          ((LinearLayoutCompat.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.d = ((TextView)localObject3);
        }
        this.d.setText((CharSequence)localObject2);
        this.d.setVisibility(0);
      }
      for (;;)
      {
        if (this.e != null) {
          this.e.setContentDescription(((ActionBar.b)localObject1).e());
        }
        if ((i != 0) || (TextUtils.isEmpty(((ActionBar.b)localObject1).e()))) {
          break label393;
        }
        setOnLongClickListener(this);
        return;
        if (this.e == null) {
          break;
        }
        this.e.setVisibility(8);
        this.e.setImageDrawable(null);
        break;
        label360:
        i = 0;
        break label207;
        label366:
        if (this.d != null)
        {
          this.d.setVisibility(8);
          this.d.setText(null);
        }
      }
      label393:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
    
    public void a(ActionBar.b paramb)
    {
      this.c = paramb;
      a();
    }
    
    public ActionBar.b b()
    {
      return this.c;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.b.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      if (Build.VERSION.SDK_INT >= 14) {
        paramAccessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      paramView = new int[2];
      getLocationOnScreen(paramView);
      Object localObject = getContext();
      int i = getWidth();
      int j = getHeight();
      int k = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      localObject = Toast.makeText((Context)localObject, this.c.e(), 0);
      ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
      ((Toast)localObject).show();
      return true;
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((ScrollingTabContainerView.this.mMaxTabWidth > 0) && (getMeasuredWidth() > ScrollingTabContainerView.this.mMaxTabWidth)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMaxTabWidth, 1073741824), paramInt2);
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ScrollingTabContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */