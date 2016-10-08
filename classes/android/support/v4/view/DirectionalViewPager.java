package android.support.v4.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.Scroller;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;

public class DirectionalViewPager
  extends ViewPager
{
  private static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  private static final int INVALID_POINTER = -1;
  private static final String TAG = "DirectionalViewPager";
  private static final boolean USE_CACHE = false;
  public static final int VERTICAL = 1;
  private static final String XML_NS = "http://schemas.android.com/apk/res/android";
  private int mActivePointerId = -1;
  private PagerAdapter mAdapter;
  private int mChildHeightMeasureSpec;
  private int mChildWidthMeasureSpec;
  private int mCurItem;
  private boolean mInLayout;
  private float mInitialMotion;
  private OnInterceptTouchListener mInterceptTouchListener = null;
  private boolean mIsBeingDragged;
  private boolean mIsUnableToDrag;
  private final ArrayList<ViewPager.ItemInfo> mItems = new ArrayList();
  private float mLastMotionX;
  private float mLastMotionY;
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  DataSetObserver mObserver;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  private int mOrientation = 0;
  private boolean mPopulatePending;
  private Parcelable mRestoredAdapterState = null;
  private ClassLoader mRestoredClassLoader = null;
  private int mRestoredCurItem = -1;
  private int mScrollState = 0;
  private boolean mScrollable = true;
  private Scroller mScroller;
  private boolean mScrolling;
  private boolean mScrollingCacheEnabled;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public DirectionalViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public DirectionalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
    int i = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "orientation", -1);
    if (i != -1) {
      setOrientation(i);
    }
  }
  
  private void completeScroll()
  {
    boolean bool = this.mScrolling;
    if (bool)
    {
      setScrollingCacheEnabled(false);
      this.mScroller.abortAnimation();
      i = getScrollX();
      int j = getScrollY();
      int k = this.mScroller.getCurrX();
      int m = this.mScroller.getCurrY();
      if ((i != k) || (j != m)) {
        scrollTo(k, m);
      }
      setScrollState(0);
    }
    this.mPopulatePending = false;
    this.mScrolling = false;
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (localItemInfo.scrolling)
      {
        bool = true;
        localItemInfo.scrolling = false;
      }
      i += 1;
    }
    if (bool) {
      populate();
    }
  }
  
  private void endDrag()
  {
    this.mIsBeingDragged = false;
    this.mIsUnableToDrag = false;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == this.mActivePointerId)
    {
      if (i != 0) {
        break label63;
      }
      i = 1;
      if (this.mOrientation != 0) {
        break label68;
      }
      this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
    }
    for (;;)
    {
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.clear();
      }
      return;
      label63:
      i = 0;
      break;
      label68:
      this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.mScrollState == paramInt) {}
    do
    {
      return;
      this.mScrollState = paramInt;
    } while (this.mOnPageChangeListener == null);
    this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.mScrollingCacheEnabled != paramBoolean) {
      this.mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  ViewPager.ItemInfo addNewItem(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.position = paramInt1;
    localItemInfo.object = this.mAdapter.instantiateItem(this, paramInt1);
    if (paramInt2 < 0)
    {
      this.mItems.add(localItemInfo);
      return localItemInfo;
    }
    this.mItems.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mInLayout)
    {
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      paramView.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void computeScroll()
  {
    if ((!this.mScroller.isFinished()) && (this.mScroller.computeScrollOffset()))
    {
      int k = getScrollX();
      int m = getScrollY();
      int j = this.mScroller.getCurrX();
      int i = this.mScroller.getCurrY();
      if ((k != j) || (m != i)) {
        scrollTo(j, i);
      }
      if (this.mOnPageChangeListener != null) {
        if (this.mOrientation != 0) {
          break label118;
        }
      }
      for (i = getWidth();; i = k)
      {
        k = j / i;
        j %= i;
        float f = j / i;
        this.mOnPageChangeListener.onPageScrolled(k, f, j);
        invalidate();
        return;
        label118:
        k = getHeight();
        j = i;
      }
    }
    completeScroll();
  }
  
  void dataSetChanged()
  {
    int m = 1;
    int i;
    int k;
    int n;
    int j;
    label36:
    ViewPager.ItemInfo localItemInfo;
    if ((this.mItems.isEmpty()) && (this.mAdapter.getCount() > 0))
    {
      i = 1;
      k = 0;
      n = -1;
      j = i;
      i = n;
      if (k >= this.mItems.size()) {
        break label204;
      }
      localItemInfo = (ViewPager.ItemInfo)this.mItems.get(k);
      n = this.mAdapter.getItemPosition(localItemInfo.object);
      if (n != -1) {
        break label94;
      }
    }
    for (;;)
    {
      k += 1;
      break label36;
      i = 0;
      break;
      label94:
      if (n == -2)
      {
        this.mItems.remove(k);
        k -= 1;
        this.mAdapter.destroyItem(this, localItemInfo.position, localItemInfo.object);
        if (this.mCurItem == localItemInfo.position)
        {
          i = Math.max(0, Math.min(this.mCurItem, this.mAdapter.getCount() - 1));
          j = 1;
        }
      }
      else
      {
        if (localItemInfo.position != n)
        {
          if (localItemInfo.position == this.mCurItem) {
            i = n;
          }
          localItemInfo.position = n;
          j = 1;
          continue;
          label204:
          if (i >= 0) {
            setCurrentItemInternal(i, false, true);
          }
          for (i = m;; i = j)
          {
            if (i != 0)
            {
              populate();
              requestLayout();
            }
            return;
          }
        }
        continue;
      }
      j = 1;
    }
  }
  
  public PagerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getScrollable()
  {
    return this.mScrollable;
  }
  
  ViewPager.ItemInfo infoForChild(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.mItems.get(i);
      if (this.mAdapter.isViewFromObject(paramView, localItemInfo.object)) {
        return localItemInfo;
      }
      i += 1;
    }
    return null;
  }
  
  void initViewPager()
  {
    super.initViewPager();
    setWillNotDraw(false);
    this.mScroller = new Scroller(getContext());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = 10;
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mAdapter != null) {
      populate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mInterceptTouchListener != null) && (!this.mInterceptTouchListener.onOnInterceptTouch(paramMotionEvent))) {
      return false;
    }
    a.c("============== onInterceptTouchEvent: {}", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      this.mActivePointerId = -1;
      return false;
    }
    a.c("======= mIsBeingDragged: {}", new Object[] { Boolean.valueOf(this.mIsBeingDragged) });
    if (i != 0)
    {
      if (this.mIsBeingDragged) {
        return true;
      }
      if (this.mIsUnableToDrag) {
        return false;
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.mIsBeingDragged;
      i = this.mActivePointerId;
      if ((i != -1) || (Build.VERSION.SDK_INT <= 4))
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        float f4 = MotionEventCompat.getX(paramMotionEvent, i);
        float f5 = MotionEventCompat.getY(paramMotionEvent, i);
        float f2 = Math.abs(f4 - this.mLastMotionX);
        float f1 = Math.abs(f5 - this.mLastMotionY);
        float f3;
        if (this.mOrientation == 0)
        {
          f3 = f2;
          f2 = f1;
          label242:
          a.c("{},{},{}", new Object[] { Float.valueOf(f3), Integer.valueOf(this.mTouchSlop), Float.valueOf(f2) });
          if ((f3 <= this.mTouchSlop) || (f3 <= f2)) {
            break label341;
          }
          this.mIsBeingDragged = true;
          setScrollState(1);
          if (this.mOrientation != 0) {
            break label332;
          }
          this.mLastMotionX = f4;
        }
        for (;;)
        {
          setScrollingCacheEnabled(true);
          break;
          f3 = f1;
          break label242;
          label332:
          this.mLastMotionY = f5;
        }
        label341:
        if (f2 > this.mTouchSlop)
        {
          this.mIsUnableToDrag = true;
          continue;
          if (this.mOrientation == 0)
          {
            f1 = paramMotionEvent.getX();
            this.mInitialMotion = f1;
            this.mLastMotionX = f1;
          }
          for (this.mLastMotionY = paramMotionEvent.getY();; this.mLastMotionY = f1)
          {
            this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
            if (this.mScrollState != 2) {
              break label450;
            }
            this.mIsBeingDragged = true;
            this.mIsUnableToDrag = false;
            setScrollState(1);
            break;
            this.mLastMotionX = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            this.mInitialMotion = f1;
          }
          label450:
          completeScroll();
          this.mIsBeingDragged = false;
          this.mIsUnableToDrag = false;
          continue;
          onSecondaryPointerUp(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    int i = getChildCount();
    label34:
    View localView;
    int j;
    if (this.mOrientation == 0)
    {
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = 0;
      if (paramInt2 >= i) {
        return;
      }
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        ViewPager.ItemInfo localItemInfo = infoForChild(localView);
        if (localItemInfo != null)
        {
          j = paramInt1 * localItemInfo.position;
          paramInt4 = getPaddingLeft();
          paramInt3 = getPaddingTop();
          if (this.mOrientation != 0) {
            break label145;
          }
          paramInt4 += j;
        }
      }
    }
    for (;;)
    {
      localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
      paramInt2 += 1;
      break label34;
      paramInt1 = paramInt4 - paramInt2;
      break;
      label145:
      paramInt3 += j;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824);
    this.mInLayout = true;
    populate();
    this.mInLayout = false;
    paramInt2 = getChildCount();
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8) {
        localView.measure(this.mChildWidthMeasureSpec, this.mChildHeightMeasureSpec);
      }
      paramInt1 += 1;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mAdapter != null)
    {
      this.mAdapter.restoreState(paramParcelable.adapterState, paramParcelable.loader);
      setCurrentItemInternal(paramParcelable.position, false, true);
      return;
    }
    this.mRestoredCurItem = paramParcelable.position;
    this.mRestoredAdapterState = paramParcelable.adapterState;
    this.mRestoredClassLoader = paramParcelable.loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mCurItem;
    localSavedState.adapterState = this.mAdapter.saveState();
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOrientation == 0)
    {
      paramInt1 = this.mCurItem * paramInt1;
      if (paramInt1 != getScrollX())
      {
        completeScroll();
        scrollTo(paramInt1, getScrollY());
      }
    }
    do
    {
      return;
      paramInt1 = this.mCurItem * paramInt2;
    } while (paramInt1 == getScrollY());
    completeScroll();
    scrollTo(getScrollX(), paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.mAdapter == null) || (this.mAdapter.getCount() == 0)) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      completeScroll();
      float f1;
      if (this.mOrientation == 0)
      {
        f1 = paramMotionEvent.getX();
        this.mInitialMotion = f1;
        this.mLastMotionX = f1;
      }
      for (;;)
      {
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        break;
        f1 = paramMotionEvent.getY();
        this.mInitialMotion = f1;
        this.mLastMotionY = f1;
      }
      a.c("======= mIsBeingDragged: {}", new Object[] { Boolean.valueOf(this.mIsBeingDragged) });
      int i;
      float f5;
      float f2;
      float f3;
      if (!this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        float f4 = MotionEventCompat.getX(paramMotionEvent, i);
        f5 = MotionEventCompat.getY(paramMotionEvent, i);
        f2 = Math.abs(f4 - this.mLastMotionX);
        f1 = Math.abs(f5 - this.mLastMotionY);
        if (this.mOrientation != 0) {
          break label484;
        }
        f3 = f2;
        f2 = f1;
        label253:
        if ((f3 > this.mTouchSlop) && (f3 > f2))
        {
          this.mIsBeingDragged = true;
          if (this.mOrientation != 0) {
            break label490;
          }
          this.mLastMotionX = f4;
          label289:
          setScrollState(1);
          setScrollingCacheEnabled(true);
        }
      }
      if (this.mIsBeingDragged)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
        f2 = MotionEventCompat.getX(paramMotionEvent, i);
        f3 = MotionEventCompat.getY(paramMotionEvent, i);
        if (this.mOrientation == 0)
        {
          i = getWidth();
          f1 = getScrollX() + (this.mLastMotionX - f2);
          this.mLastMotionX = f2;
          label362:
          f2 = Math.max(0, (this.mCurItem - 1) * i);
          f3 = Math.min(this.mCurItem + 1, this.mAdapter.getCount() - 1) * i;
          if (f1 >= f2) {
            break label528;
          }
          label407:
          if (this.mOrientation != 0) {
            break label543;
          }
          this.mLastMotionX += f2 - (int)f2;
          scrollTo((int)f2, getScrollY());
        }
        int j;
        while (this.mOnPageChangeListener != null)
        {
          j = (int)f2 / i;
          int k = (int)f2 % i;
          f1 = k / i;
          this.mOnPageChangeListener.onPageScrolled(j, f1, k);
          break;
          label484:
          f3 = f1;
          break label253;
          label490:
          this.mLastMotionY = f5;
          break label289;
          i = getHeight();
          f1 = getScrollY() + (this.mLastMotionY - f3);
          this.mLastMotionY = f3;
          break label362;
          label528:
          f2 = f1;
          if (f1 <= f3) {
            break label407;
          }
          f2 = f3;
          break label407;
          label543:
          this.mLastMotionY += f2 - (int)f2;
          scrollTo(getScrollX(), (int)f2);
        }
        if (this.mIsBeingDragged)
        {
          paramMotionEvent = this.mVelocityTracker;
          paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (this.mOrientation == 0)
          {
            j = (int)VelocityTrackerCompat.getXVelocity(paramMotionEvent, this.mActivePointerId);
            f1 = this.mLastMotionX;
            i = getWidth() / 3;
            label625:
            this.mPopulatePending = true;
            if ((Math.abs(j) <= this.mMinimumVelocity) && (Math.abs(this.mInitialMotion - f1) < i)) {
              break label733;
            }
            if (f1 <= this.mInitialMotion) {
              break label718;
            }
            setCurrentItemInternal(this.mCurItem - 1, true, true);
          }
          for (;;)
          {
            this.mActivePointerId = -1;
            endDrag();
            break;
            j = (int)VelocityTrackerCompat.getYVelocity(paramMotionEvent, this.mActivePointerId);
            f1 = this.mLastMotionY;
            i = getHeight() / 3;
            break label625;
            label718:
            setCurrentItemInternal(this.mCurItem + 1, true, true);
            continue;
            label733:
            setCurrentItemInternal(this.mCurItem, true, true);
          }
          if (this.mIsBeingDragged)
          {
            setCurrentItemInternal(this.mCurItem, true, true);
            this.mActivePointerId = -1;
            endDrag();
            continue;
            i = MotionEventCompat.getActionIndex(paramMotionEvent);
            if (this.mOrientation == 0) {
              this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
            }
            for (;;)
            {
              this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
              break;
              this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
            }
            onSecondaryPointerUp(paramMotionEvent);
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
            if (this.mOrientation == 0) {
              this.mLastMotionX = MotionEventCompat.getX(paramMotionEvent, i);
            } else {
              this.mLastMotionY = MotionEventCompat.getY(paramMotionEvent, i);
            }
          }
        }
      }
    }
  }
  
  void populate()
  {
    if (this.mAdapter == null) {}
    while ((this.mPopulatePending) || (getWindowToken() == null)) {
      return;
    }
    this.mAdapter.startUpdate(this);
    int i;
    int j;
    int i1;
    label70:
    int k;
    label75:
    ViewPager.ItemInfo localItemInfo;
    if (this.mCurItem > 0)
    {
      i = this.mCurItem - 1;
      j = this.mAdapter.getCount();
      if (this.mCurItem >= j - 1) {
        break label172;
      }
      i1 = this.mCurItem + 1;
      j = 0;
      k = -1;
      if (j >= this.mItems.size()) {
        break label274;
      }
      localItemInfo = (ViewPager.ItemInfo)this.mItems.get(j);
      if (((localItemInfo.position >= i) && (localItemInfo.position <= i1)) || (localItemInfo.scrolling)) {
        break label180;
      }
      this.mItems.remove(j);
      this.mAdapter.destroyItem(this, localItemInfo.position, localItemInfo.object);
      j -= 1;
    }
    for (;;)
    {
      k = localItemInfo.position;
      j += 1;
      break label75;
      i = this.mCurItem;
      break;
      label172:
      i1 = j - 1;
      break label70;
      label180:
      int n = j;
      if (k < i1)
      {
        n = j;
        if (localItemInfo.position > i)
        {
          n = k + 1;
          k = j;
          int m = n;
          if (n < i)
          {
            m = i;
            k = j;
          }
          for (;;)
          {
            n = k;
            if (m > i1) {
              break;
            }
            n = k;
            if (m >= localItemInfo.position) {
              break;
            }
            addNewItem(m, k);
            m += 1;
            k += 1;
          }
          label274:
          if (this.mItems.size() > 0) {}
          for (j = ((ViewPager.ItemInfo)this.mItems.get(this.mItems.size() - 1)).position; j < i1; j = -1)
          {
            k = j + 1;
            j = i;
            if (k > i) {
              j = k;
            }
            while (j <= i1)
            {
              addNewItem(j, -1);
              j += 1;
            }
          }
          this.mAdapter.finishUpdate(this);
          return;
        }
      }
      j = n;
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.mAdapter != null) {
      VerticalViewPagerCompat.setDataSetObserver(this.mAdapter, null);
    }
    this.mAdapter = paramPagerAdapter;
    if (this.mAdapter != null)
    {
      if (this.mObserver == null) {
        this.mObserver = new DataSetObserver(null);
      }
      VerticalViewPagerCompat.setDataSetObserver(this.mAdapter, this.mObserver);
      this.mPopulatePending = false;
      if (this.mRestoredCurItem >= 0)
      {
        this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
        setCurrentItemInternal(this.mRestoredCurItem, false, true);
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
      }
    }
    else
    {
      return;
    }
    populate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.mPopulatePending = false;
    setCurrentItemInternal(paramInt, true, false);
  }
  
  void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 0)) {
      setScrollingCacheEnabled(false);
    }
    int i;
    label215:
    label228:
    for (;;)
    {
      return;
      if ((!paramBoolean2) && (this.mCurItem == paramInt) && (this.mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      if (paramInt < 0) {
        i = 0;
      }
      while ((i > this.mCurItem + 1) || (i < this.mCurItem - 1))
      {
        paramInt = 0;
        while (paramInt < this.mItems.size())
        {
          ((ViewPager.ItemInfo)this.mItems.get(paramInt)).scrolling = true;
          paramInt += 1;
        }
        i = paramInt;
        if (paramInt >= this.mAdapter.getCount()) {
          i = this.mAdapter.getCount() - 1;
        }
      }
      if (this.mCurItem != i)
      {
        paramInt = 1;
        this.mCurItem = i;
        populate();
        if (!paramBoolean1) {
          break;
        }
        if (this.mOrientation != 0) {
          break label215;
        }
        smoothScrollTo(getWidth() * i, 0);
      }
      for (;;)
      {
        if ((paramInt == 0) || (this.mOnPageChangeListener == null)) {
          break label228;
        }
        this.mOnPageChangeListener.onPageSelected(i);
        return;
        paramInt = 0;
        break;
        smoothScrollTo(0, getHeight() * i);
      }
    }
    if ((paramInt != 0) && (this.mOnPageChangeListener != null)) {
      this.mOnPageChangeListener.onPageSelected(i);
    }
    completeScroll();
    if (this.mOrientation == 0)
    {
      scrollTo(getWidth() * i, 0);
      return;
    }
    scrollTo(0, getHeight() * i);
  }
  
  public void setOnInterceptTouchListener(OnInterceptTouchListener paramOnInterceptTouchListener)
  {
    this.mInterceptTouchListener = paramOnInterceptTouchListener;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Only HORIZONTAL and VERTICAL are valid orientations.");
    }
    if (paramInt == this.mOrientation) {
      return;
    }
    completeScroll();
    this.mInitialMotion = 0.0F;
    this.mLastMotionX = 0.0F;
    this.mLastMotionY = 0.0F;
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    this.mOrientation = paramInt;
    if (this.mOrientation == 0) {
      scrollTo(this.mCurItem * getWidth(), 0);
    }
    for (;;)
    {
      requestLayout();
      return;
      scrollTo(0, this.mCurItem * getHeight());
    }
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mScrollable = paramBoolean;
  }
  
  void smoothScrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      completeScroll();
      return;
    }
    setScrollingCacheEnabled(true);
    this.mScrolling = true;
    setScrollState(2);
    this.mScroller.startScroll(i, j, paramInt1, paramInt2);
    invalidate();
  }
  
  private class DataSetObserver
    extends DataSetObserver
  {
    private DataSetObserver() {}
    
    public void onChanged()
    {
      DirectionalViewPager.this.dataSetChanged();
    }
  }
  
  public static abstract interface OnInterceptTouchListener
  {
    public abstract boolean onOnInterceptTouch(MotionEvent paramMotionEvent);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new DirectionalViewPager.SavedState.1());
    Parcelable adapterState;
    ClassLoader loader;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.adapterState = paramParcel.readParcelable(localClassLoader);
      this.loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.adapterState, paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\DirectionalViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */