package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
{
  private static final boolean DEBUG = false;
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  public static final int GAP_HANDLING_NONE = 0;
  public static final int HORIZONTAL = 0;
  private static final int INVALID_OFFSET = Integer.MIN_VALUE;
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  public static final String TAG = "StaggeredGridLayoutManager";
  public static final int VERTICAL = 1;
  private final a mAnchorInfo = new a(null);
  private final Runnable mCheckForGapsRunnable = new br(this);
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  @NonNull
  private final ai mLayoutState;
  LazySpanLookup mLazySpanLookup = new LazySpanLookup();
  private int mOrientation;
  private SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  @NonNull
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  private boolean mReverseLayout = false;
  @NonNull
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  private int mSpanCount = -1;
  private b[] mSpans;
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.mOrientation = paramInt2;
    setSpanCount(paramInt1);
    if (this.mGapStrategy != 0) {}
    for (;;)
    {
      setAutoMeasureEnabled(bool);
      this.mLayoutState = new ai();
      createOrientationHelpers();
      return;
      bool = false;
    }
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setSpanCount(paramContext.spanCount);
    setReverseLayout(paramContext.reverseLayout);
    if (this.mGapStrategy != 0) {}
    for (;;)
    {
      setAutoMeasureEnabled(bool);
      this.mLayoutState = new ai();
      createOrientationHelpers();
      return;
      bool = false;
    }
  }
  
  private void appendViewToAllSpans(View paramView)
  {
    int i = this.mSpanCount - 1;
    while (i >= 0)
    {
      this.mSpans[i].b(paramView);
      i -= 1;
    }
  }
  
  private void applyPendingSavedState(a parama)
  {
    if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
      if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount)
      {
        int j = 0;
        if (j < this.mSpanCount)
        {
          this.mSpans[j].e();
          int k = this.mPendingSavedState.mSpanOffsets[j];
          int i = k;
          if (k != Integer.MIN_VALUE) {
            if (!this.mPendingSavedState.mAnchorLayoutFromEnd) {
              break label102;
            }
          }
          label102:
          for (i = k + this.mPrimaryOrientation.getEndAfterPadding();; i = k + this.mPrimaryOrientation.getStartAfterPadding())
          {
            this.mSpans[j].c(i);
            j += 1;
            break;
          }
        }
      }
      else
      {
        this.mPendingSavedState.invalidateSpanInfo();
        this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
      }
    }
    this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
    setReverseLayout(this.mPendingSavedState.mReverseLayout);
    resolveShouldLayoutReverse();
    if (this.mPendingSavedState.mAnchorPosition != -1) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    for (parama.c = this.mPendingSavedState.mAnchorLayoutFromEnd;; parama.c = this.mShouldReverseLayout)
    {
      if (this.mPendingSavedState.mSpanLookupSize > 1)
      {
        this.mLazySpanLookup.a = this.mPendingSavedState.mSpanLookup;
        this.mLazySpanLookup.b = this.mPendingSavedState.mFullSpanItems;
      }
      return;
    }
  }
  
  private void attachViewToSpans(View paramView, LayoutParams paramLayoutParams, ai paramai)
  {
    if (paramai.e == 1)
    {
      if (paramLayoutParams.mFullSpan)
      {
        appendViewToAllSpans(paramView);
        return;
      }
      paramLayoutParams.mSpan.b(paramView);
      return;
    }
    if (paramLayoutParams.mFullSpan)
    {
      prependViewToAllSpans(paramView);
      return;
    }
    paramLayoutParams.mSpan.a(paramView);
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    int i = -1;
    if (getChildCount() == 0)
    {
      if (this.mShouldReverseLayout) {
        return 1;
      }
      return -1;
    }
    int j;
    if (paramInt < getFirstChildPosition())
    {
      j = 1;
      if (j == this.mShouldReverseLayout) {
        break label47;
      }
    }
    label47:
    for (paramInt = i;; paramInt = 1)
    {
      return paramInt;
      j = 0;
      break;
    }
  }
  
  private boolean checkForGaps()
  {
    if ((getChildCount() == 0) || (this.mGapStrategy == 0) || (!isAttachedToWindow())) {
      return false;
    }
    int j;
    if (this.mShouldReverseLayout) {
      j = getLastChildPosition();
    }
    for (int i = getFirstChildPosition(); (j == 0) && (hasGapsToFix() != null); i = getLastChildPosition())
    {
      this.mLazySpanLookup.a();
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      j = getFirstChildPosition();
    }
    if (!this.mLaidOutInvalidFullSpan) {
      return false;
    }
    if (this.mShouldReverseLayout) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = this.mLazySpanLookup.a(j, i + 1, k, true);
      if (localFullSpanItem1 != null) {
        break;
      }
      this.mLaidOutInvalidFullSpan = false;
      this.mLazySpanLookup.a(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.mLazySpanLookup.a(j, localFullSpanItem1.a, k * -1, true);
    if (localFullSpanItem2 == null) {
      this.mLazySpanLookup.a(localFullSpanItem1.a);
    }
    for (;;)
    {
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
      this.mLazySpanLookup.a(localFullSpanItem2.a + 1);
    }
  }
  
  private boolean checkSpanForGap(b paramb)
  {
    boolean bool = true;
    if (this.mShouldReverseLayout)
    {
      if (paramb.d() < this.mPrimaryOrientation.getEndAfterPadding()) {
        return !paramb.c((View)b.a(paramb).get(b.a(paramb).size() - 1)).mFullSpan;
      }
    }
    else if (paramb.b() > this.mPrimaryOrientation.getStartAfterPadding())
    {
      if (!paramb.c((View)b.a(paramb).get(0)).mFullSpan) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleItemClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.a(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleItemClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.a(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleItemClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.b(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int j = -1;
    int k = 1;
    int m = Integer.MIN_VALUE;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = Integer.MIN_VALUE;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        } while (this.mOrientation == 1);
        return Integer.MIN_VALUE;
        paramInt = m;
        if (this.mOrientation == 1) {
          paramInt = 1;
        }
        return paramInt;
        i = j;
      } while (this.mOrientation == 0);
      return Integer.MIN_VALUE;
    }
    if (this.mOrientation == 0) {}
    for (paramInt = k;; paramInt = Integer.MIN_VALUE) {
      return paramInt;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.mSpanCount];
    int i = 0;
    while (i < this.mSpanCount)
    {
      localFullSpanItem.c[i] = (paramInt - this.mSpans[i].b(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.c = new int[this.mSpanCount];
    int i = 0;
    while (i < this.mSpanCount)
    {
      localFullSpanItem.c[i] = (this.mSpans[i].a(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private void createOrientationHelpers()
  {
    this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, ai paramai, RecyclerView.State paramState)
  {
    this.mRemainingSpans.set(0, this.mSpanCount, true);
    int i;
    int m;
    label62:
    int j;
    label65:
    View localView;
    LayoutParams localLayoutParams;
    int i2;
    int i1;
    label137:
    b localb;
    label158:
    label169:
    label190:
    label223:
    int n;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int k;
    if (this.mLayoutState.i) {
      if (paramai.e == 1)
      {
        i = Integer.MAX_VALUE;
        updateAllRemainingSpans(paramai.e, i);
        if (!this.mShouldReverseLayout) {
          break label507;
        }
        m = this.mPrimaryOrientation.getEndAfterPadding();
        j = 0;
        if ((!paramai.a(paramState)) || ((!this.mLayoutState.i) && (this.mRemainingSpans.isEmpty()))) {
          break label877;
        }
        localView = paramai.a(paramRecycler);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i2 = localLayoutParams.getViewLayoutPosition();
        j = this.mLazySpanLookup.c(i2);
        if (j != -1) {
          break label519;
        }
        i1 = 1;
        if (i1 == 0) {
          break label535;
        }
        if (!localLayoutParams.mFullSpan) {
          break label525;
        }
        localb = this.mSpans[0];
        this.mLazySpanLookup.a(i2, localb);
        localLayoutParams.mSpan = localb;
        if (paramai.e != 1) {
          break label547;
        }
        addView(localView);
        measureChildWithDecorationsAndMargin(localView, localLayoutParams, false);
        if (paramai.e != 1) {
          break label569;
        }
        if (!localLayoutParams.mFullSpan) {
          break label557;
        }
        j = getMaxEnd(m);
        n = j + this.mPrimaryOrientation.getDecoratedMeasurement(localView);
        if ((i1 == 0) || (!localLayoutParams.mFullSpan)) {
          break label968;
        }
        localFullSpanItem = createFullSpanItemFromEnd(j);
        localFullSpanItem.b = -1;
        localFullSpanItem.a = i2;
        this.mLazySpanLookup.a(localFullSpanItem);
        k = j;
      }
    }
    for (;;)
    {
      if ((localLayoutParams.mFullSpan) && (paramai.d == -1))
      {
        if (i1 != 0) {
          this.mLaidOutInvalidFullSpan = true;
        }
      }
      else
      {
        label310:
        attachViewToSpans(localView, localLayoutParams, paramai);
        if ((!isLayoutRTL()) || (this.mOrientation != 1)) {
          break label769;
        }
        if (!localLayoutParams.mFullSpan) {
          break label739;
        }
        j = this.mSecondaryOrientation.getEndAfterPadding();
        label351:
        i2 = j - this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        i1 = j;
        j = i2;
        if (this.mOrientation != 1) {
          break label826;
        }
        layoutDecoratedWithMargins(localView, j, k, i1, n);
        label395:
        if (!localLayoutParams.mFullSpan) {
          break label843;
        }
        updateAllRemainingSpans(this.mLayoutState.e, i);
        label416:
        recycle(paramRecycler, this.mLayoutState);
        if ((this.mLayoutState.h) && (localView.isFocusable()))
        {
          if (!localLayoutParams.mFullSpan) {
            break label861;
          }
          this.mRemainingSpans.clear();
        }
      }
      for (;;)
      {
        j = 1;
        break label65;
        i = Integer.MIN_VALUE;
        break;
        if (paramai.e == 1)
        {
          i = paramai.g + paramai.b;
          break;
        }
        i = paramai.f - paramai.b;
        break;
        label507:
        m = this.mPrimaryOrientation.getStartAfterPadding();
        break label62;
        label519:
        i1 = 0;
        break label137;
        label525:
        localb = getNextSpan(paramai);
        break label158;
        label535:
        localb = this.mSpans[j];
        break label169;
        label547:
        addView(localView, 0);
        break label190;
        label557:
        j = localb.b(m);
        break label223;
        label569:
        if (localLayoutParams.mFullSpan) {}
        for (j = getMinStart(m);; j = localb.a(m))
        {
          k = j - this.mPrimaryOrientation.getDecoratedMeasurement(localView);
          if ((i1 != 0) && (localLayoutParams.mFullSpan))
          {
            localFullSpanItem = createFullSpanItemFromStart(j);
            localFullSpanItem.b = 1;
            localFullSpanItem.a = i2;
            this.mLazySpanLookup.a(localFullSpanItem);
          }
          n = j;
          break;
        }
        if (paramai.e == 1) {
          if (!areAllEndsEqual()) {
            j = 1;
          }
        }
        for (;;)
        {
          if (j == 0) {
            break label737;
          }
          localFullSpanItem = this.mLazySpanLookup.f(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.d = true;
          }
          this.mLaidOutInvalidFullSpan = true;
          break;
          j = 0;
          continue;
          if (!areAllStartsEqual()) {
            j = 1;
          } else {
            j = 0;
          }
        }
        label737:
        break label310;
        label739:
        j = this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - localb.d) * this.mSizePerSpan;
        break label351;
        label769:
        if (localLayoutParams.mFullSpan) {}
        for (j = this.mSecondaryOrientation.getStartAfterPadding();; j = localb.d * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding())
        {
          i1 = j + this.mSecondaryOrientation.getDecoratedMeasurement(localView);
          break;
        }
        label826:
        layoutDecoratedWithMargins(localView, k, j, n, i1);
        break label395;
        label843:
        updateRemainingSpans(localb, this.mLayoutState.e, i);
        break label416;
        label861:
        this.mRemainingSpans.set(localb.d, false);
      }
      label877:
      if (j == 0) {
        recycle(paramRecycler, this.mLayoutState);
      }
      if (this.mLayoutState.e == -1) {
        i = getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
      }
      for (i = this.mPrimaryOrientation.getStartAfterPadding() - i; i > 0; i = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding()) {
        return Math.min(paramai.b, i);
      }
      return 0;
      label968:
      k = j;
    }
  }
  
  private int findFirstReferenceChildPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      int k = getPosition(getChildAt(i));
      if ((k >= 0) && (k < paramInt)) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  private int findLastReferenceChildPosition(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      int j = getPosition(getChildAt(i));
      if ((j >= 0) && (j < paramInt)) {
        return j;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMaxEnd(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i = this.mPrimaryOrientation.getEndAfterPadding() - i;
      } while (i <= 0);
      i -= -scrollBy(-i, paramRecycler, paramState);
    } while ((!paramBoolean) || (i <= 0));
    this.mPrimaryOrientation.offsetChildren(i);
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMinStart(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i -= this.mPrimaryOrientation.getStartAfterPadding();
      } while (i <= 0);
      i -= scrollBy(i, paramRecycler, paramState);
    } while ((!paramBoolean) || (i <= 0));
    this.mPrimaryOrientation.offsetChildren(-i);
  }
  
  private int getFirstChildPosition()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  private int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return getPosition(getChildAt(i - 1));
  }
  
  private int getMaxEnd(int paramInt)
  {
    int j = this.mSpans[0].b(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].b(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMaxStart(int paramInt)
  {
    int j = this.mSpans[0].a(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].a(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinEnd(int paramInt)
  {
    int j = this.mSpans[0].b(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].b(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinStart(int paramInt)
  {
    int j = this.mSpans[0].a(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].a(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private b getNextSpan(ai paramai)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = -1;
    int i;
    int k;
    int i1;
    int n;
    int m;
    if (preferLastSpan(paramai.e))
    {
      i = this.mSpanCount - 1;
      k = -1;
      if (paramai.e != 1) {
        break label124;
      }
      i1 = this.mPrimaryOrientation.getStartAfterPadding();
      n = Integer.MAX_VALUE;
      m = i;
      paramai = (ai)localObject1;
      i = n;
      label61:
      localObject1 = paramai;
      if (m == k) {
        break label195;
      }
      localObject1 = this.mSpans[m];
      n = ((b)localObject1).b(i1);
      if (n >= i) {
        break label200;
      }
      paramai = (ai)localObject1;
      i = n;
    }
    label124:
    label195:
    label197:
    label200:
    for (;;)
    {
      m += j;
      break label61;
      k = this.mSpanCount;
      i = 0;
      j = 1;
      break;
      i1 = this.mPrimaryOrientation.getEndAfterPadding();
      n = Integer.MIN_VALUE;
      m = i;
      paramai = (ai)localObject2;
      i = n;
      localObject1 = paramai;
      if (m != k)
      {
        localObject1 = this.mSpans[m];
        n = ((b)localObject1).a(i1);
        if (n <= i) {
          break label197;
        }
        paramai = (ai)localObject1;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        return (b)localObject1;
      }
    }
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.mShouldReverseLayout)
    {
      k = getLastChildPosition();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      this.mLazySpanLookup.b(i);
      switch (paramInt3)
      {
      default: 
        label76:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = getFirstChildPosition();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      this.mLazySpanLookup.b(paramInt1, paramInt2);
      break label76;
      this.mLazySpanLookup.a(paramInt1, paramInt2);
      break label76;
      this.mLazySpanLookup.a(paramInt1, 1);
      this.mLazySpanLookup.b(paramInt2, 1);
      break label76;
      if (this.mShouldReverseLayout) {}
      for (paramInt1 = getFirstChildPosition(); i <= paramInt1; paramInt1 = getLastChildPosition())
      {
        requestLayout();
        return;
      }
    }
  }
  
  private void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + localLayoutParams.leftMargin, paramInt2 + localLayoutParams.topMargin, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    calculateItemDecorationsForChild(paramView, this.mTmpRect);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = updateSpecWithExtra(paramInt1, localLayoutParams.leftMargin + this.mTmpRect.left, localLayoutParams.rightMargin + this.mTmpRect.right);
    paramInt2 = updateSpecWithExtra(paramInt2, localLayoutParams.topMargin + this.mTmpRect.top, localLayoutParams.bottomMargin + this.mTmpRect.bottom);
    if (paramBoolean) {}
    for (paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);; paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams))
    {
      if (paramBoolean) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams.mFullSpan)
    {
      if (this.mOrientation == 1)
      {
        measureChildWithDecorationsAndMargin(paramView, this.mFullSizeSpec, getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
        return;
      }
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), this.mFullSizeSpec, paramBoolean);
      return;
    }
    if (this.mOrientation == 1)
    {
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, paramLayoutParams.height, true), paramBoolean);
      return;
    }
    measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), 0, paramLayoutParams.width, true), getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
  }
  
  private void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    a locala = this.mAnchorInfo;
    locala.a();
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if (this.mPendingSavedState != null) {
      applyPendingSavedState(locala);
    }
    for (;;)
    {
      updateAnchorInfoForLayout(paramState, locala);
      if ((this.mPendingSavedState == null) && ((locala.c != this.mLastLayoutFromEnd) || (isLayoutRTL() != this.mLastLayoutRTL)))
      {
        this.mLazySpanLookup.a();
        locala.d = true;
      }
      if ((getChildCount() <= 0) || ((this.mPendingSavedState != null) && (this.mPendingSavedState.mSpanOffsetsSize >= 1))) {
        break label247;
      }
      if (!locala.d) {
        break;
      }
      i = 0;
      while (i < this.mSpanCount)
      {
        this.mSpans[i].e();
        if (locala.b != Integer.MIN_VALUE) {
          this.mSpans[i].c(locala.b);
        }
        i += 1;
      }
      resolveShouldLayoutReverse();
      locala.c = this.mShouldReverseLayout;
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].a(this.mShouldReverseLayout, locala.b);
      i += 1;
    }
    label247:
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.a = false;
    this.mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
    updateLayoutState(locala.a, paramState);
    if (locala.c)
    {
      setLayoutStateDirection(-1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(1);
      this.mLayoutState.c = (locala.a + this.mLayoutState.d);
      fill(paramRecycler, this.mLayoutState, paramState);
      label346:
      repositionToWrapContentIfNecessary();
      if (getChildCount() > 0)
      {
        if (!this.mShouldReverseLayout) {
          break label545;
        }
        fixEndGap(paramRecycler, paramState, true);
        fixStartGap(paramRecycler, paramState, false);
      }
      label378:
      if ((!paramBoolean) || (paramState.isPreLayout())) {
        break label574;
      }
      if ((this.mGapStrategy == 0) || (getChildCount() <= 0) || ((!this.mLaidOutInvalidFullSpan) && (hasGapsToFix() == null))) {
        break label562;
      }
      i = 1;
      label420:
      if (i == 0) {
        break label568;
      }
      removeCallbacks(this.mCheckForGapsRunnable);
      if (!checkForGaps()) {
        break label568;
      }
      i = 1;
      label444:
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    }
    for (;;)
    {
      this.mLastLayoutFromEnd = locala.c;
      this.mLastLayoutRTL = isLayoutRTL();
      this.mPendingSavedState = null;
      if (i == 0) {
        break;
      }
      onLayoutChildren(paramRecycler, paramState, false);
      return;
      setLayoutStateDirection(1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(-1);
      this.mLayoutState.c = (locala.a + this.mLayoutState.d);
      fill(paramRecycler, this.mLayoutState, paramState);
      break label346;
      label545:
      fixStartGap(paramRecycler, paramState, true);
      fixEndGap(paramRecycler, paramState, false);
      break label378;
      label562:
      i = 0;
      break label420;
      label568:
      i = 0;
      break label444;
      label574:
      i = 0;
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    int i;
    if (this.mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.mShouldReverseLayout) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != this.mShouldReverseLayout) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == isLayoutRTL()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private void prependViewToAllSpans(View paramView)
  {
    int i = this.mSpanCount - 1;
    while (i >= 0)
    {
      this.mSpans[i].a(paramView);
      i -= 1;
    }
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, ai paramai)
  {
    if ((!paramai.a) || (paramai.i)) {
      return;
    }
    if (paramai.b == 0)
    {
      if (paramai.e == -1)
      {
        recycleFromEnd(paramRecycler, paramai.g);
        return;
      }
      recycleFromStart(paramRecycler, paramai.f);
      return;
    }
    if (paramai.e == -1)
    {
      i = paramai.f - getMaxStart(paramai.f);
      if (i < 0) {}
      for (i = paramai.g;; i = paramai.g - Math.min(i, paramai.b))
      {
        recycleFromEnd(paramRecycler, i);
        return;
      }
    }
    int i = getMinEnd(paramai.g) - paramai.g;
    if (i < 0) {}
    int j;
    for (i = paramai.f;; i = Math.min(i, paramai.b) + j)
    {
      recycleFromStart(paramRecycler, i);
      return;
      j = paramai.f;
    }
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if (this.mPrimaryOrientation.getDecoratedStart(localView) >= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.mFullSpan) {
            break label119;
          }
          j = 0;
          if (j >= this.mSpanCount) {
            break label88;
          }
          if (b.a(this.mSpans[j]).size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (b.a(localLayoutParams.mSpan).size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.mSpanCount)
        {
          this.mSpans[j].g();
          j += 1;
        }
      }
      localLayoutParams.mSpan.g();
      removeAndRecycleView(localView, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if (this.mPrimaryOrientation.getDecoratedEnd(localView) <= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.mFullSpan) {
            break label112;
          }
          i = 0;
          if (i >= this.mSpanCount) {
            break label81;
          }
          if (b.a(this.mSpans[i]).size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label81:
      label112:
      while (b.a(localLayoutParams.mSpan).size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.mSpanCount)
        {
          this.mSpans[i].h();
          i += 1;
        }
      }
      localLayoutParams.mSpan.h();
      removeAndRecycleView(localView, paramRecycler);
    }
  }
  
  private void repositionToWrapContentIfNecessary()
  {
    if (this.mSecondaryOrientation.getMode() == 1073741824) {
      return;
    }
    float f1 = 0.0F;
    int k = getChildCount();
    int i = 0;
    View localView;
    float f2;
    while (i < k)
    {
      localView = getChildAt(i);
      f2 = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
      if (f2 < f1)
      {
        label55:
        i += 1;
      }
      else
      {
        if (!((LayoutParams)localView.getLayoutParams()).isFullSpan()) {
          break label325;
        }
        f2 = 1.0F * f2 / this.mSpanCount;
      }
    }
    label162:
    label202:
    label325:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      break label55;
      int m = this.mSizePerSpan;
      int j = Math.round(this.mSpanCount * f1);
      i = j;
      if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
        i = Math.min(j, this.mSecondaryOrientation.getTotalSpace());
      }
      updateMeasureSpecs(i);
      if (this.mSizePerSpan == m) {
        break;
      }
      i = 0;
      LayoutParams localLayoutParams;
      if (i < k)
      {
        localView = getChildAt(i);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.mFullSpan) {
          break label202;
        }
      }
      for (;;)
      {
        i += 1;
        break label162;
        break;
        if ((isLayoutRTL()) && (this.mOrientation == 1))
        {
          localView.offsetLeftAndRight(-(this.mSpanCount - 1 - localLayoutParams.mSpan.d) * this.mSizePerSpan - -(this.mSpanCount - 1 - localLayoutParams.mSpan.d) * m);
        }
        else
        {
          j = localLayoutParams.mSpan.d * this.mSizePerSpan;
          int n = localLayoutParams.mSpan.d * m;
          if (this.mOrientation == 1) {
            localView.offsetLeftAndRight(j - n);
          } else {
            localView.offsetTopAndBottom(j - n);
          }
        }
      }
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!isLayoutRTL()))
    {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    }
    if (!this.mReverseLayout) {}
    for (;;)
    {
      this.mShouldReverseLayout = bool;
      return;
      bool = false;
    }
  }
  
  private void setLayoutStateDirection(int paramInt)
  {
    int i = 1;
    this.mLayoutState.e = paramInt;
    ai localai = this.mLayoutState;
    boolean bool2 = this.mShouldReverseLayout;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label50;
      }
    }
    label50:
    for (paramInt = i;; paramInt = -1)
    {
      localai.d = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.mSpanCount)
    {
      if (b.a(this.mSpans[i]).isEmpty()) {}
      for (;;)
      {
        i += 1;
        break;
        updateRemainingSpans(this.mSpans[i], paramInt1, paramInt2);
      }
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, a parama)
  {
    if (this.mLastLayoutFromEnd) {}
    for (int i = findLastReferenceChildPosition(paramState.getItemCount());; i = findFirstReferenceChildPosition(paramState.getItemCount()))
    {
      parama.a = i;
      parama.b = Integer.MIN_VALUE;
      return true;
    }
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.State paramState)
  {
    boolean bool2 = false;
    this.mLayoutState.b = 0;
    this.mLayoutState.c = paramInt;
    int i;
    boolean bool1;
    if (isSmoothScrolling())
    {
      i = paramState.getTargetScrollPosition();
      if (i != -1)
      {
        boolean bool3 = this.mShouldReverseLayout;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label171;
          }
          paramInt = this.mPrimaryOrientation.getTotalSpace();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      if (getClipToPadding())
      {
        this.mLayoutState.f = (this.mPrimaryOrientation.getStartAfterPadding() - i);
        this.mLayoutState.g = (paramInt + this.mPrimaryOrientation.getEndAfterPadding());
      }
      for (;;)
      {
        this.mLayoutState.h = false;
        this.mLayoutState.a = true;
        paramState = this.mLayoutState;
        bool1 = bool2;
        if (this.mPrimaryOrientation.getMode() == 0)
        {
          bool1 = bool2;
          if (this.mPrimaryOrientation.getEnd() == 0) {
            bool1 = true;
          }
        }
        paramState.i = bool1;
        return;
        bool1 = false;
        break;
        label171:
        i = this.mPrimaryOrientation.getTotalSpace();
        paramInt = 0;
        break label67;
        this.mLayoutState.g = (paramInt + this.mPrimaryOrientation.getEnd());
        this.mLayoutState.f = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private void updateRemainingSpans(b paramb, int paramInt1, int paramInt2)
  {
    int i = paramb.i();
    if (paramInt1 == -1) {
      if (i + paramb.b() <= paramInt2) {
        this.mRemainingSpans.set(paramb.d, false);
      }
    }
    while (paramb.d() - i < paramInt2) {
      return;
    }
    this.mRemainingSpans.set(paramb.d, false);
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != Integer.MIN_VALUE) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  boolean areAllEndsEqual()
  {
    boolean bool2 = true;
    int j = this.mSpans[0].b(Integer.MIN_VALUE);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mSpanCount)
      {
        if (this.mSpans[i].b(Integer.MIN_VALUE) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean areAllStartsEqual()
  {
    boolean bool2 = true;
    int j = this.mSpans[0].a(Integer.MIN_VALUE);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mSpanCount)
      {
        if (this.mSpans[i].a(Integer.MIN_VALUE) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.mSpanCount];
    }
    do
    {
      int i = 0;
      while (i < this.mSpanCount)
      {
        arrayOfInt[i] = this.mSpans[i].k();
        i += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.mSpanCount);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mPrimaryOrientation.getStartAfterPadding();
    int k = this.mPrimaryOrientation.getEndAfterPadding();
    int i = getChildCount() - 1;
    Object localObject1 = null;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.mPrimaryOrientation.getDecoratedStart(localView);
      int n = this.mPrimaryOrientation.getDecoratedEnd(localView);
      Object localObject2 = localObject1;
      if (n > j)
      {
        if (m < k) {
          break label95;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i -= 1;
        localObject1 = localObject2;
        break;
        label95:
        if ((n <= k) || (!paramBoolean1)) {
          return localView;
        }
        localObject2 = localObject1;
        if (paramBoolean2)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
    }
    return (View)localObject1;
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mPrimaryOrientation.getStartAfterPadding();
    int k = this.mPrimaryOrientation.getEndAfterPadding();
    int m = getChildCount();
    int i = 0;
    Object localObject1 = null;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.mPrimaryOrientation.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (this.mPrimaryOrientation.getDecoratedEnd(localView) > j)
      {
        if (n < k) {
          break label94;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label94:
        if ((n >= j) || (!paramBoolean1)) {
          return localView;
        }
        localObject2 = localObject1;
        if (paramBoolean2)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
    }
    return (View)localObject1;
  }
  
  int findFirstVisibleItemPositionInt()
  {
    if (this.mShouldReverseLayout) {}
    for (View localView = findFirstVisibleItemClosestToEnd(true, true); localView == null; localView = findFirstVisibleItemClosestToStart(true, true)) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.mSpanCount];
    }
    do
    {
      int i = 0;
      while (i < this.mSpanCount)
      {
        arrayOfInt[i] = this.mSpans[i].j();
        i += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.mSpanCount);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.mSpanCount];
    }
    do
    {
      int i = 0;
      while (i < this.mSpanCount)
      {
        arrayOfInt[i] = this.mSpans[i].m();
        i += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.mSpanCount);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[this.mSpanCount];
    }
    do
    {
      int i = 0;
      while (i < this.mSpanCount)
      {
        arrayOfInt[i] = this.mSpans[i].l();
        i += 1;
      }
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= this.mSpanCount);
    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return this.mSpanCount;
    }
    return super.getColumnCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getGapStrategy()
  {
    return this.mGapStrategy;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return this.mSpanCount;
    }
    return super.getRowCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  View hasGapsToFix()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.mSpanCount);
    localBitSet.set(0, this.mSpanCount, true);
    int j;
    int k;
    if ((this.mOrientation == 1) && (isLayoutRTL()))
    {
      j = 1;
      if (!this.mShouldReverseLayout) {
        break label127;
      }
      k = -1;
      label58:
      if (i >= k) {
        break label139;
      }
    }
    int n;
    View localView;
    LayoutParams localLayoutParams;
    label127:
    label139:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label350;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.mSpan.d)) {
        break label156;
      }
      if (!checkSpanForGap(localLayoutParams.mSpan)) {
        break label145;
      }
      return localView;
      j = -1;
      break;
      k = i + 1;
      i = 0;
      break label58;
    }
    label145:
    localBitSet.clear(localLayoutParams.mSpan.d);
    label156:
    if (localLayoutParams.mFullSpan) {}
    label278:
    label344:
    label348:
    label350:
    label352:
    label356:
    for (;;)
    {
      n += m;
      break;
      if (n + m != k)
      {
        Object localObject = getChildAt(n + m);
        int i1;
        if (this.mShouldReverseLayout)
        {
          i = this.mPrimaryOrientation.getDecoratedEnd(localView);
          i1 = this.mPrimaryOrientation.getDecoratedEnd((View)localObject);
          if (i < i1) {
            return localView;
          }
          if (i != i1) {
            break label352;
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label356;
          }
          localObject = (LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams.mSpan.d - ((LayoutParams)localObject).mSpan.d < 0)
          {
            i = 1;
            if (j >= 0) {
              break label344;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            if (i == i1) {
              break label348;
            }
            return localView;
            i = this.mPrimaryOrientation.getDecoratedStart(localView);
            i1 = this.mPrimaryOrientation.getDecoratedStart((View)localObject);
            if (i > i1) {
              return localView;
            }
            if (i != i1) {
              break label352;
            }
            i = 1;
            break;
            i = 0;
            break label278;
          }
          break;
          return null;
          i = 0;
        }
      }
    }
  }
  
  public void invalidateSpanAssignments()
  {
    this.mLazySpanLookup.a();
    requestLayout();
  }
  
  boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].d(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].d(paramInt);
      i += 1;
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    removeCallbacks(this.mCheckForGapsRunnable);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].e();
      i += 1;
    }
  }
  
  @Nullable
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 0;
    if (getChildCount() == 0) {
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    resolveShouldLayoutReverse();
    int j = convertFocusDirectionToLayoutDirection(paramInt);
    if (j == Integer.MIN_VALUE) {
      return null;
    }
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    boolean bool = ((LayoutParams)localObject).mFullSpan;
    localObject = ((LayoutParams)localObject).mSpan;
    if (j == 1) {}
    for (paramInt = getLastChildPosition();; paramInt = getFirstChildPosition())
    {
      updateLayoutState(paramInt, paramState);
      setLayoutStateDirection(j);
      this.mLayoutState.c = (this.mLayoutState.d + paramInt);
      this.mLayoutState.b = ((int)(0.33333334F * this.mPrimaryOrientation.getTotalSpace()));
      this.mLayoutState.h = true;
      this.mLayoutState.a = false;
      fill(paramRecycler, this.mLayoutState, paramState);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      if (bool) {
        break;
      }
      paramRecycler = ((b)localObject).a(paramInt, j);
      if ((paramRecycler == null) || (paramRecycler == paramView)) {
        break;
      }
      return paramRecycler;
    }
    if (preferLastSpan(j))
    {
      i = this.mSpanCount - 1;
      while (i >= 0)
      {
        paramRecycler = this.mSpans[i].a(paramInt, j);
        if ((paramRecycler != null) && (paramRecycler != paramView)) {
          return paramRecycler;
        }
        i -= 1;
      }
    }
    do
    {
      i += 1;
      if (i >= this.mSpanCount) {
        break;
      }
      paramRecycler = this.mSpans[i].a(paramInt, j);
    } while ((paramRecycler == null) || (paramRecycler == paramView));
    return paramRecycler;
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      localView1 = findFirstVisibleItemClosestToStart(false, true);
      localView2 = findFirstVisibleItemClosestToEnd(false, true);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = getPosition(localView1);
    int j = getPosition(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramRecycler = paramView.getLayoutParams();
    if (!(paramRecycler instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramRecycler = (LayoutParams)paramRecycler;
    if (this.mOrientation == 0)
    {
      j = paramRecycler.getSpanIndex();
      if (paramRecycler.mFullSpan) {}
      for (i = this.mSpanCount;; i = 1)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, i, -1, -1, paramRecycler.mFullSpan, false));
        return;
      }
    }
    int j = paramRecycler.getSpanIndex();
    if (paramRecycler.mFullSpan) {}
    for (int i = this.mSpanCount;; i = 1)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, j, i, paramRecycler.mFullSpan, false));
      return;
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mLazySpanLookup.a();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    onLayoutChildren(paramRecycler, paramState, true);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.mPendingSavedState = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null) {
      return new SavedState(this.mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    localSavedState.mReverseLayout = this.mReverseLayout;
    localSavedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
    localSavedState.mLastLayoutRTL = this.mLastLayoutRTL;
    int i;
    label118:
    int j;
    label151:
    int k;
    if ((this.mLazySpanLookup != null) && (this.mLazySpanLookup.a != null))
    {
      localSavedState.mSpanLookup = this.mLazySpanLookup.a;
      localSavedState.mSpanLookupSize = localSavedState.mSpanLookup.length;
      localSavedState.mFullSpanItems = this.mLazySpanLookup.b;
      if (getChildCount() <= 0) {
        break label267;
      }
      if (!this.mLastLayoutFromEnd) {
        break label222;
      }
      i = getLastChildPosition();
      localSavedState.mAnchorPosition = i;
      localSavedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
      localSavedState.mSpanOffsetsSize = this.mSpanCount;
      localSavedState.mSpanOffsets = new int[this.mSpanCount];
      j = 0;
      if (j >= this.mSpanCount) {
        return localSavedState;
      }
      if (!this.mLastLayoutFromEnd) {
        break label230;
      }
      k = this.mSpans[j].b(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - this.mPrimaryOrientation.getEndAfterPadding();
      }
    }
    for (;;)
    {
      localSavedState.mSpanOffsets[j] = i;
      j += 1;
      break label151;
      localSavedState.mSpanLookupSize = 0;
      break;
      label222:
      i = getFirstChildPosition();
      break label118;
      label230:
      k = this.mSpans[j].a(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - this.mPrimaryOrientation.getStartAfterPadding();
      }
    }
    label267:
    localSavedState.mAnchorPosition = -1;
    localSavedState.mVisibleAnchorPosition = -1;
    localSavedState.mSpanOffsetsSize = 0;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int j;
    int i;
    if (paramInt > 0)
    {
      j = getLastChildPosition();
      i = 1;
      this.mLayoutState.a = true;
      updateLayoutState(j, paramState);
      setLayoutStateDirection(i);
      this.mLayoutState.c = (this.mLayoutState.d + j);
      j = Math.abs(paramInt);
      this.mLayoutState.b = j;
      i = fill(paramRecycler, this.mLayoutState, paramState);
      if (j >= i) {
        break label116;
      }
    }
    for (;;)
    {
      this.mPrimaryOrientation.offsetChildren(-paramInt);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      return paramInt;
      i = -1;
      j = getFirstChildPosition();
      break;
      label116:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mAnchorPosition != paramInt)) {
      this.mPendingSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mGapStrategy) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 2)) {
      throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }
    this.mGapStrategy = paramInt;
    if (this.mGapStrategy != 0) {}
    for (boolean bool = true;; bool = false)
    {
      setAutoMeasureEnabled(bool);
      requestLayout();
      return;
    }
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.mSizePerSpan * this.mSpanCount, getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.mSizePerSpan * this.mSpanCount, getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    this.mPrimaryOrientation = this.mSecondaryOrientation;
    this.mSecondaryOrientation = localOrientationHelper;
    requestLayout();
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.mReverseLayout != paramBoolean)) {
      this.mPendingSavedState.mReverseLayout = paramBoolean;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.mSpanCount)
    {
      invalidateSpanAssignments();
      this.mSpanCount = paramInt;
      this.mRemainingSpans = new BitSet(this.mSpanCount);
      this.mSpans = new b[this.mSpanCount];
      paramInt = 0;
      while (paramInt < this.mSpanCount)
      {
        this.mSpans[paramInt] = new b(paramInt, null);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new bs(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.mPendingSavedState == null;
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.State paramState, a parama)
  {
    boolean bool = false;
    if ((paramState.isPreLayout()) || (this.mPendingScrollPosition == -1)) {
      return false;
    }
    if ((this.mPendingScrollPosition < 0) || (this.mPendingScrollPosition >= paramState.getItemCount()))
    {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      return false;
    }
    if ((this.mPendingSavedState == null) || (this.mPendingSavedState.mAnchorPosition == -1) || (this.mPendingSavedState.mSpanOffsetsSize < 1))
    {
      paramState = findViewByPosition(this.mPendingScrollPosition);
      if (paramState != null)
      {
        if (this.mShouldReverseLayout) {}
        for (int i = getLastChildPosition();; i = getFirstChildPosition())
        {
          parama.a = i;
          if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
            break label188;
          }
          if (!parama.c) {
            break;
          }
          parama.b = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(paramState));
          return true;
        }
        parama.b = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(paramState));
        return true;
        label188:
        if (this.mPrimaryOrientation.getDecoratedMeasurement(paramState) > this.mPrimaryOrientation.getTotalSpace())
        {
          if (parama.c) {}
          for (i = this.mPrimaryOrientation.getEndAfterPadding();; i = this.mPrimaryOrientation.getStartAfterPadding())
          {
            parama.b = i;
            return true;
          }
        }
        i = this.mPrimaryOrientation.getDecoratedStart(paramState) - this.mPrimaryOrientation.getStartAfterPadding();
        if (i < 0)
        {
          parama.b = (-i);
          return true;
        }
        i = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(paramState);
        if (i < 0)
        {
          parama.b = i;
          return true;
        }
        parama.b = Integer.MIN_VALUE;
        return true;
      }
      parama.a = this.mPendingScrollPosition;
      if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE)
      {
        if (calculateScrollDirectionForPosition(parama.a) == 1) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
      }
      for (;;)
      {
        parama.d = true;
        return true;
        parama.a(this.mPendingScrollPositionOffset);
      }
    }
    parama.b = Integer.MIN_VALUE;
    parama.a = this.mPendingScrollPosition;
    return true;
  }
  
  void updateAnchorInfoForLayout(RecyclerView.State paramState, a parama)
  {
    if (updateAnchorFromPendingData(paramState, parama)) {}
    while (updateAnchorFromChildren(paramState, parama)) {
      return;
    }
    parama.b();
    parama.a = 0;
  }
  
  void updateMeasureSpecs(int paramInt)
  {
    this.mSizePerSpan = (paramInt / this.mSpanCount);
    this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, this.mSecondaryOrientation.getMode());
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    boolean mFullSpan;
    StaggeredGridLayoutManager.b mSpan;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final int getSpanIndex()
    {
      if (this.mSpan == null) {
        return -1;
      }
      return this.mSpan.d;
    }
    
    public boolean isFullSpan()
    {
      return this.mFullSpan;
    }
    
    public void setFullSpan(boolean paramBoolean)
    {
      this.mFullSpan = paramBoolean;
    }
  }
  
  static class LazySpanLookup
  {
    int[] a;
    List<FullSpanItem> b;
    
    private void c(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label21:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt1) {
          break label58;
        }
      }
      for (;;)
      {
        i -= 1;
        break label21;
        break;
        label58:
        if (localFullSpanItem.a < paramInt1 + paramInt2) {
          this.b.remove(i);
        } else {
          localFullSpanItem.a -= paramInt2;
        }
      }
    }
    
    private void d(int paramInt1, int paramInt2)
    {
      if (this.b == null) {
        return;
      }
      int i = this.b.size() - 1;
      label21:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt1) {
          break label58;
        }
      }
      for (;;)
      {
        i -= 1;
        break label21;
        break;
        label58:
        localFullSpanItem.a += paramInt2;
      }
    }
    
    private int g(int paramInt)
    {
      if (this.b == null) {
        return -1;
      }
      FullSpanItem localFullSpanItem = f(paramInt);
      if (localFullSpanItem != null) {
        this.b.remove(localFullSpanItem);
      }
      int j = this.b.size();
      int i = 0;
      if (i < j) {
        if (((FullSpanItem)this.b.get(i)).a < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)this.b.get(i);
          this.b.remove(i);
          return localFullSpanItem.a;
          i += 1;
          break;
        }
        return -1;
        i = -1;
      }
    }
    
    int a(int paramInt)
    {
      if (this.b != null)
      {
        int i = this.b.size() - 1;
        while (i >= 0)
        {
          if (((FullSpanItem)this.b.get(i)).a >= paramInt) {
            this.b.remove(i);
          }
          i -= 1;
        }
      }
      return b(paramInt);
    }
    
    public FullSpanItem a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int j = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label117;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a >= paramInt2) {
          return null;
        }
        if (localFullSpanItem.a >= paramInt1)
        {
          localObject = localFullSpanItem;
          if (paramInt3 == 0) {
            break;
          }
          localObject = localFullSpanItem;
          if (localFullSpanItem.b == paramInt3) {
            break;
          }
          if (paramBoolean)
          {
            localObject = localFullSpanItem;
            if (localFullSpanItem.d) {
              break;
            }
          }
        }
        i += 1;
      }
      label117:
      return null;
    }
    
    void a()
    {
      if (this.a != null) {
        Arrays.fill(this.a, -1);
      }
      this.b = null;
    }
    
    void a(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1 + paramInt2, this.a, paramInt1, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, this.a.length - paramInt2, this.a.length, -1);
      c(paramInt1, paramInt2);
    }
    
    void a(int paramInt, StaggeredGridLayoutManager.b paramb)
    {
      e(paramInt);
      this.a[paramInt] = paramb.d;
    }
    
    public void a(FullSpanItem paramFullSpanItem)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        if (localFullSpanItem.a == paramFullSpanItem.a) {
          this.b.remove(i);
        }
        if (localFullSpanItem.a >= paramFullSpanItem.a)
        {
          this.b.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      this.b.add(paramFullSpanItem);
    }
    
    int b(int paramInt)
    {
      if (this.a == null) {}
      while (paramInt >= this.a.length) {
        return -1;
      }
      int i = g(paramInt);
      if (i == -1)
      {
        Arrays.fill(this.a, paramInt, this.a.length, -1);
        return this.a.length;
      }
      Arrays.fill(this.a, paramInt, i + 1, -1);
      return i + 1;
    }
    
    void b(int paramInt1, int paramInt2)
    {
      if ((this.a == null) || (paramInt1 >= this.a.length)) {
        return;
      }
      e(paramInt1 + paramInt2);
      System.arraycopy(this.a, paramInt1, this.a, paramInt1 + paramInt2, this.a.length - paramInt1 - paramInt2);
      Arrays.fill(this.a, paramInt1, paramInt1 + paramInt2, -1);
      d(paramInt1, paramInt2);
    }
    
    int c(int paramInt)
    {
      if ((this.a == null) || (paramInt >= this.a.length)) {
        return -1;
      }
      return this.a[paramInt];
    }
    
    int d(int paramInt)
    {
      int i = this.a.length;
      while (i <= paramInt) {
        i *= 2;
      }
      return i;
    }
    
    void e(int paramInt)
    {
      if (this.a == null)
      {
        this.a = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(this.a, -1);
      }
      while (paramInt < this.a.length) {
        return;
      }
      int[] arrayOfInt = this.a;
      this.a = new int[d(paramInt)];
      System.arraycopy(arrayOfInt, 0, this.a, 0, arrayOfInt.length);
      Arrays.fill(this.a, arrayOfInt.length, this.a.length, -1);
    }
    
    public FullSpanItem f(int paramInt)
    {
      Object localObject;
      if (this.b == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int i = this.b.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label63;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)this.b.get(i);
        localObject = localFullSpanItem;
        if (localFullSpanItem.a == paramInt) {
          break;
        }
        i -= 1;
      }
      label63:
      return null;
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new bt();
      int a;
      int b;
      int[] c;
      boolean d;
      
      public FullSpanItem() {}
      
      public FullSpanItem(Parcel paramParcel)
      {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          this.d = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            this.c = new int[i];
            paramParcel.readIntArray(this.c);
          }
          return;
          bool = false;
        }
      }
      
      int a(int paramInt)
      {
        if (this.c == null) {
          return 0;
        }
        return this.c[paramInt];
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        paramParcel.writeInt(this.b);
        if (this.d) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((this.c == null) || (this.c.length <= 0)) {
            break;
          }
          paramParcel.writeInt(this.c.length);
          paramParcel.writeIntArray(this.c);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new bu();
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mVisibleAnchorPosition = paramParcel.readInt();
      this.mSpanOffsetsSize = paramParcel.readInt();
      if (this.mSpanOffsetsSize > 0)
      {
        this.mSpanOffsets = new int[this.mSpanOffsetsSize];
        paramParcel.readIntArray(this.mSpanOffsets);
      }
      this.mSpanLookupSize = paramParcel.readInt();
      if (this.mSpanLookupSize > 0)
      {
        this.mSpanLookup = new int[this.mSpanLookupSize];
        paramParcel.readIntArray(this.mSpanLookup);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.mReverseLayout = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        this.mAnchorLayoutFromEnd = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mLastLayoutRTL = bool1;
        this.mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.mSpanOffsetsSize = paramSavedState.mSpanOffsetsSize;
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mVisibleAnchorPosition = paramSavedState.mVisibleAnchorPosition;
      this.mSpanOffsets = paramSavedState.mSpanOffsets;
      this.mSpanLookupSize = paramSavedState.mSpanLookupSize;
      this.mSpanLookup = paramSavedState.mSpanLookup;
      this.mReverseLayout = paramSavedState.mReverseLayout;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
      this.mLastLayoutRTL = paramSavedState.mLastLayoutRTL;
      this.mFullSpanItems = paramSavedState.mFullSpanItems;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    void invalidateAnchorPositionInfo()
    {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mAnchorPosition = -1;
      this.mVisibleAnchorPosition = -1;
    }
    
    void invalidateSpanInfo()
    {
      this.mSpanOffsets = null;
      this.mSpanOffsetsSize = 0;
      this.mSpanLookupSize = 0;
      this.mSpanLookup = null;
      this.mFullSpanItems = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mVisibleAnchorPosition);
      paramParcel.writeInt(this.mSpanOffsetsSize);
      if (this.mSpanOffsetsSize > 0) {
        paramParcel.writeIntArray(this.mSpanOffsets);
      }
      paramParcel.writeInt(this.mSpanLookupSize);
      if (this.mSpanLookupSize > 0) {
        paramParcel.writeIntArray(this.mSpanLookup);
      }
      if (this.mReverseLayout)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.mAnchorLayoutFromEnd) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!this.mLastLayoutRTL) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(this.mFullSpanItems);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  private class a
  {
    int a;
    int b;
    boolean c;
    boolean d;
    
    private a() {}
    
    void a()
    {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
      this.d = false;
    }
    
    void a(int paramInt)
    {
      if (this.c)
      {
        this.b = (StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - paramInt);
        return;
      }
      this.b = (StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + paramInt);
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();; i = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding())
      {
        this.b = i;
        return;
      }
    }
  }
  
  class b
  {
    int a = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;
    int c = 0;
    final int d;
    private ArrayList<View> f = new ArrayList();
    
    private b(int paramInt)
    {
      this.d = paramInt;
    }
    
    int a(int paramInt)
    {
      if (this.a != Integer.MIN_VALUE) {
        paramInt = this.a;
      }
      while (this.f.size() == 0) {
        return paramInt;
      }
      a();
      return this.a;
    }
    
    int a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int k = -1;
      int m = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
      int n = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
      int i;
      if (paramInt2 > paramInt1) {
        i = 1;
      }
      for (;;)
      {
        int j = k;
        View localView;
        if (paramInt1 != paramInt2)
        {
          localView = (View)this.f.get(paramInt1);
          j = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(localView);
          int i1 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(localView);
          if ((j >= n) || (i1 <= m)) {
            break label147;
          }
          if (paramBoolean)
          {
            if ((j < m) || (i1 > n)) {
              break label147;
            }
            j = StaggeredGridLayoutManager.this.getPosition(localView);
          }
        }
        else
        {
          return j;
          i = -1;
          continue;
        }
        return StaggeredGridLayoutManager.this.getPosition(localView);
        label147:
        paramInt1 += i;
      }
    }
    
    public View a(int paramInt1, int paramInt2)
    {
      View localView2 = null;
      View localView1 = null;
      int i;
      if (paramInt2 == -1)
      {
        i = this.f.size();
        paramInt2 = 0;
        if (paramInt2 < i)
        {
          localView2 = (View)this.f.get(paramInt2);
          if (localView2.isFocusable())
          {
            if (StaggeredGridLayoutManager.this.getPosition(localView2) > paramInt1) {}
            for (int k = 1;; k = 0)
            {
              if (k != StaggeredGridLayoutManager.this.mReverseLayout) {
                break label92;
              }
              paramInt2 += 1;
              localView1 = localView2;
              break;
            }
          }
        }
        label92:
        return localView1;
      }
      paramInt2 = this.f.size() - 1;
      localView1 = localView2;
      if (paramInt2 >= 0)
      {
        localView2 = (View)this.f.get(paramInt2);
        if (localView2.isFocusable())
        {
          if (StaggeredGridLayoutManager.this.getPosition(localView2) > paramInt1)
          {
            i = 1;
            label148:
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
              break label184;
            }
          }
          label184:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              return localView1;
            }
            paramInt2 -= 1;
            localView1 = localView2;
            break;
            i = 0;
            break label148;
          }
        }
      }
      return localView1;
    }
    
    void a()
    {
      Object localObject = (View)this.f.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c((View)localObject);
      this.a = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart((View)localObject);
      if (localLayoutParams.mFullSpan)
      {
        localObject = StaggeredGridLayoutManager.this.mLazySpanLookup.f(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == -1)) {
          this.a -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(this.d);
        }
      }
    }
    
    void a(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(paramView);
      localLayoutParams.mSpan = this;
      this.f.add(0, paramView);
      this.a = Integer.MIN_VALUE;
      if (this.f.size() == 1) {
        this.b = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.c += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    void a(boolean paramBoolean, int paramInt)
    {
      int i;
      if (paramBoolean)
      {
        i = b(Integer.MIN_VALUE);
        e();
        if (i != Integer.MIN_VALUE) {
          break label32;
        }
      }
      label32:
      while (((paramBoolean) && (i < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding())) || ((!paramBoolean) && (i > StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding())))
      {
        return;
        i = a(Integer.MIN_VALUE);
        break;
      }
      int j = i;
      if (paramInt != Integer.MIN_VALUE) {
        j = i + paramInt;
      }
      this.b = j;
      this.a = j;
    }
    
    int b()
    {
      if (this.a != Integer.MIN_VALUE) {
        return this.a;
      }
      a();
      return this.a;
    }
    
    int b(int paramInt)
    {
      if (this.b != Integer.MIN_VALUE) {
        paramInt = this.b;
      }
      while (this.f.size() == 0) {
        return paramInt;
      }
      c();
      return this.b;
    }
    
    void b(View paramView)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(paramView);
      localLayoutParams.mSpan = this;
      this.f.add(paramView);
      this.b = Integer.MIN_VALUE;
      if (this.f.size() == 1) {
        this.a = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.c += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    StaggeredGridLayoutManager.LayoutParams c(View paramView)
    {
      return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    }
    
    void c()
    {
      Object localObject = (View)this.f.get(this.f.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c((View)localObject);
      this.b = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd((View)localObject);
      if (localLayoutParams.mFullSpan)
      {
        localObject = StaggeredGridLayoutManager.this.mLazySpanLookup.f(localLayoutParams.getViewLayoutPosition());
        if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).b == 1))
        {
          int i = this.b;
          this.b = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).a(this.d) + i);
        }
      }
    }
    
    void c(int paramInt)
    {
      this.a = paramInt;
      this.b = paramInt;
    }
    
    int d()
    {
      if (this.b != Integer.MIN_VALUE) {
        return this.b;
      }
      c();
      return this.b;
    }
    
    void d(int paramInt)
    {
      if (this.a != Integer.MIN_VALUE) {
        this.a += paramInt;
      }
      if (this.b != Integer.MIN_VALUE) {
        this.b += paramInt;
      }
    }
    
    void e()
    {
      this.f.clear();
      f();
      this.c = 0;
    }
    
    void f()
    {
      this.a = Integer.MIN_VALUE;
      this.b = Integer.MIN_VALUE;
    }
    
    void g()
    {
      int i = this.f.size();
      View localView = (View)this.f.remove(i - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(localView);
      localLayoutParams.mSpan = null;
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.c -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      if (i == 1) {
        this.a = Integer.MIN_VALUE;
      }
      this.b = Integer.MIN_VALUE;
    }
    
    void h()
    {
      View localView = (View)this.f.remove(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = c(localView);
      localLayoutParams.mSpan = null;
      if (this.f.size() == 0) {
        this.b = Integer.MIN_VALUE;
      }
      if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
        this.c -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(localView);
      }
      this.a = Integer.MIN_VALUE;
    }
    
    public int i()
    {
      return this.c;
    }
    
    public int j()
    {
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        return a(this.f.size() - 1, -1, false);
      }
      return a(0, this.f.size(), false);
    }
    
    public int k()
    {
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        return a(this.f.size() - 1, -1, true);
      }
      return a(0, this.f.size(), true);
    }
    
    public int l()
    {
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        return a(0, this.f.size(), false);
      }
      return a(this.f.size() - 1, -1, false);
    }
    
    public int m()
    {
      if (StaggeredGridLayoutManager.this.mReverseLayout) {
        return a(0, this.f.size(), true);
      }
      return a(this.f.size() - 1, -1, true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\StaggeredGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */