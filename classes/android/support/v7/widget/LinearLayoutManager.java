package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements ItemTouchHelper.ViewDropHandler
{
  private static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = Integer.MIN_VALUE;
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final a mAnchorInfo = new a();
  private boolean mLastStackFromEnd;
  private b mLayoutState;
  int mOrientation;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
    setAutoMeasureEnabled(true);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setReverseLayout(paramContext.reverseLayout);
    setStackFromEnd(paramContext.stackFromEnd);
    setAutoMeasureEnabled(true);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.a(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.a(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return bc.b(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findFirstReferenceChild(paramRecycler, paramState);
    }
    return findLastReferenceChild(paramRecycler, paramState);
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findLastReferenceChild(paramRecycler, paramState);
    }
    return findFirstReferenceChild(paramRecycler, paramState);
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      int j = -scrollBy(-i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      int j = -scrollBy(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.mOrientationHelper.getStartAfterPadding();
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View getChildClosestToEnd()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View getChildClosestToStart()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((!paramState.willRunPredictiveAnimations()) || (getChildCount() == 0) || (paramState.isPreLayout()) || (!supportsPredictiveItemAnimations())) {
      return;
    }
    int i = 0;
    int j = 0;
    List localList = paramRecycler.getScrapList();
    int n = localList.size();
    int i1 = getPosition(getChildAt(0));
    int k = 0;
    if (k < n)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localList.get(k);
      int m;
      if (localViewHolder.isRemoved())
      {
        m = j;
        j = i;
        i = m;
      }
      for (;;)
      {
        m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        int i2;
        if (localViewHolder.getLayoutPosition() < i1)
        {
          i2 = 1;
          label143:
          if (i2 == this.mShouldReverseLayout) {
            break label195;
          }
        }
        label195:
        for (m = -1;; m = 1)
        {
          if (m != -1) {
            break label201;
          }
          m = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + i;
          i = j;
          j = m;
          break;
          i2 = 0;
          break label143;
        }
        label201:
        m = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + j;
        j = i;
        i = m;
      }
    }
    this.mLayoutState.k = localList;
    if (i > 0)
    {
      updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
      this.mLayoutState.h = i;
      this.mLayoutState.c = 0;
      this.mLayoutState.a();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    if (j > 0)
    {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.h = j;
      this.mLayoutState.c = 0;
      this.mLayoutState.a();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    this.mLayoutState.k = null;
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      Log.d("LinearLayoutManager", "item " + getPosition(localView) + ", coord:" + this.mOrientationHelper.getDecoratedStart(localView));
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, b paramb)
  {
    if ((!paramb.a) || (paramb.l)) {
      return;
    }
    if (paramb.f == -1)
    {
      recycleViewsFromEnd(paramRecycler, paramb.g);
      return;
    }
    recycleViewsFromStart(paramRecycler, paramb.g);
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          removeAndRecycleViewAt(paramInt2, paramRecycler);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          removeAndRecycleViewAt(i, paramRecycler);
          i -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int j = this.mOrientationHelper.getEnd() - paramInt;
      View localView;
      if (this.mShouldReverseLayout)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          localView = getChildAt(paramInt);
          if (this.mOrientationHelper.getDecoratedStart(localView) < j)
          {
            recycleChildren(paramRecycler, 0, paramInt);
            return;
          }
          paramInt += 1;
        }
      }
      else
      {
        paramInt = i - 1;
        while (paramInt >= 0)
        {
          localView = getChildAt(paramInt);
          if (this.mOrientationHelper.getDecoratedStart(localView) < j)
          {
            recycleChildren(paramRecycler, i - 1, paramInt);
            return;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int j = getChildCount();
      int i;
      View localView;
      if (this.mShouldReverseLayout)
      {
        i = j - 1;
        while (i >= 0)
        {
          localView = getChildAt(i);
          if (this.mOrientationHelper.getDecoratedEnd(localView) > paramInt)
          {
            recycleChildren(paramRecycler, j - 1, i);
            return;
          }
          i -= 1;
        }
      }
      else
      {
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (this.mOrientationHelper.getDecoratedEnd(localView) > paramInt)
          {
            recycleChildren(paramRecycler, 0, i);
            return;
          }
          i += 1;
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
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, a parama)
  {
    int i = 0;
    if (getChildCount() == 0) {}
    do
    {
      return false;
      View localView = getFocusedChild();
      if ((localView != null) && (a.a(parama, localView, paramState)))
      {
        parama.a(localView);
        return true;
      }
    } while (this.mLastStackFromEnd != this.mStackFromEnd);
    if (parama.c)
    {
      paramRecycler = findReferenceChildClosestToEnd(paramRecycler, paramState);
      label66:
      if (paramRecycler == null) {
        break label165;
      }
      parama.b(paramRecycler);
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(paramRecycler) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(paramRecycler) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0) {
          if (!parama.c) {
            break label167;
          }
        }
      }
    }
    label165:
    label167:
    for (i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
    {
      parama.b = i;
      return true;
      paramRecycler = findReferenceChildClosestToStart(paramRecycler, paramState);
      break label66;
      break;
    }
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, a parama)
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
    parama.a = this.mPendingScrollPosition;
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
    {
      parama.c = this.mPendingSavedState.mAnchorLayoutFromEnd;
      if (parama.c)
      {
        parama.b = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
        return true;
      }
      parama.b = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
      return true;
    }
    if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE)
    {
      paramState = findViewByPosition(this.mPendingScrollPosition);
      int i;
      if (paramState != null)
      {
        if (this.mOrientationHelper.getDecoratedMeasurement(paramState) > this.mOrientationHelper.getTotalSpace())
        {
          parama.b();
          return true;
        }
        if (this.mOrientationHelper.getDecoratedStart(paramState) - this.mOrientationHelper.getStartAfterPadding() < 0)
        {
          parama.b = this.mOrientationHelper.getStartAfterPadding();
          parama.c = false;
          return true;
        }
        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramState) < 0)
        {
          parama.b = this.mOrientationHelper.getEndAfterPadding();
          parama.c = true;
          return true;
        }
        if (parama.c) {}
        for (i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();; i = this.mOrientationHelper.getDecoratedStart(paramState))
        {
          parama.b = i;
          return true;
        }
      }
      if (getChildCount() > 0)
      {
        i = getPosition(getChildAt(0));
        if (this.mPendingScrollPosition >= i) {
          break label351;
        }
      }
      label351:
      for (int j = 1;; j = 0)
      {
        if (j == this.mShouldReverseLayout) {
          bool = true;
        }
        parama.c = bool;
        parama.b();
        return true;
      }
    }
    parama.c = this.mShouldReverseLayout;
    if (this.mShouldReverseLayout)
    {
      parama.b = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
      return true;
    }
    parama.b = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
    return true;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, a parama)
  {
    if (updateAnchorFromPendingData(paramState, parama)) {}
    while (updateAnchorFromChildren(paramRecycler, paramState, parama)) {
      return;
    }
    parama.b();
    if (this.mStackFromEnd) {}
    for (int i = paramState.getItemCount() - 1;; i = 0)
    {
      parama.a = i;
      return;
    }
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    int i = -1;
    int j = 1;
    this.mLayoutState.l = resolveIsInfinite();
    this.mLayoutState.h = getExtraLayoutSpace(paramState);
    this.mLayoutState.f = paramInt1;
    if (paramInt1 == 1)
    {
      paramState = this.mLayoutState;
      paramState.h += this.mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localb = this.mLayoutState;
      if (this.mShouldReverseLayout) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localb.e = paramInt1;
        this.mLayoutState.d = (getPosition(paramState) + this.mLayoutState.e);
        this.mLayoutState.b = this.mOrientationHelper.getDecoratedEnd(paramState);
        paramInt1 = this.mOrientationHelper.getDecoratedEnd(paramState) - this.mOrientationHelper.getEndAfterPadding();
        this.mLayoutState.c = paramInt2;
        if (paramBoolean)
        {
          paramState = this.mLayoutState;
          paramState.c -= paramInt1;
        }
        this.mLayoutState.g = paramInt1;
        return;
      }
    }
    paramState = getChildClosestToStart();
    b localb = this.mLayoutState;
    localb.h += this.mOrientationHelper.getStartAfterPadding();
    localb = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localb.e = paramInt1;
      this.mLayoutState.d = (getPosition(paramState) + this.mLayoutState.e);
      this.mLayoutState.b = this.mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(paramState) + this.mOrientationHelper.getStartAfterPadding();
      break;
    }
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.c = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    b localb = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (int i = -1;; i = 1)
    {
      localb.e = i;
      this.mLayoutState.d = paramInt1;
      this.mLayoutState.f = 1;
      this.mLayoutState.b = paramInt2;
      this.mLayoutState.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void updateLayoutStateToFillEnd(a parama)
  {
    updateLayoutStateToFillEnd(parama.a, parama.b);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.c = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mLayoutState.d = paramInt1;
    b localb = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localb.e = paramInt1;
      this.mLayoutState.f = -1;
      this.mLayoutState.b = paramInt2;
      this.mLayoutState.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void updateLayoutStateToFillStart(a parama)
  {
    updateLayoutStateToFillStart(parama.a, parama.b);
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
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.mShouldReverseLayout) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
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
  
  int convertFocusDirectionToLayoutDirection(int paramInt)
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
  
  b createLayoutState()
  {
    return new b();
  }
  
  void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = createLayoutState();
    }
    if (this.mOrientationHelper == null) {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    }
  }
  
  int fill(RecyclerView.Recycler paramRecycler, b paramb, RecyclerView.State paramState, boolean paramBoolean)
  {
    int k = paramb.c;
    if (paramb.g != Integer.MIN_VALUE)
    {
      if (paramb.c < 0) {
        paramb.g += paramb.c;
      }
      recycleByLayoutState(paramRecycler, paramb);
    }
    int i = paramb.c + paramb.h;
    LayoutChunkResult localLayoutChunkResult = new LayoutChunkResult();
    if (((paramb.l) || (i > 0)) && (paramb.a(paramState)))
    {
      localLayoutChunkResult.resetInternal();
      layoutChunk(paramRecycler, paramState, paramb, localLayoutChunkResult);
      if (!localLayoutChunkResult.mFinished) {
        break label111;
      }
    }
    for (;;)
    {
      return k - paramb.c;
      label111:
      paramb.b += localLayoutChunkResult.mConsumed * paramb.f;
      int j;
      if ((localLayoutChunkResult.mIgnoreConsumed) && (this.mLayoutState.k == null))
      {
        j = i;
        if (paramState.isPreLayout()) {}
      }
      else
      {
        paramb.c -= localLayoutChunkResult.mConsumed;
        j = i - localLayoutChunkResult.mConsumed;
      }
      if (paramb.g != Integer.MIN_VALUE)
      {
        paramb.g += localLayoutChunkResult.mConsumed;
        if (paramb.c < 0) {
          paramb.g += paramb.c;
        }
        recycleByLayoutState(paramRecycler, paramb);
      }
      i = j;
      if (!paramBoolean) {
        break;
      }
      i = j;
      if (!localLayoutChunkResult.mFocusable) {
        break;
      }
    }
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label130;
      }
      localView = getChildAt(paramInt1);
      int m = this.mOrientationHelper.getDecoratedStart(localView);
      int n = this.mOrientationHelper.getDecoratedEnd(localView);
      if ((m >= k) || (n <= j)) {
        break label133;
      }
      if ((paramBoolean1) && ((m < j) || (n > k))) {
        break;
      }
      return localView;
    }
    if ((paramBoolean2) && (localObject == null)) {
      localObject = localView;
    }
    label130:
    label133:
    for (;;)
    {
      paramInt1 += i;
      break;
      return (View)localObject;
    }
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    paramState = null;
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    label35:
    Object localObject1;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramRecycler = null;
      if (paramInt1 == paramInt2) {
        break label157;
      }
      localObject1 = getChildAt(paramInt1);
      int m = getPosition((View)localObject1);
      if ((m < 0) || (m >= paramInt3)) {
        break label172;
      }
      if (!((RecyclerView.LayoutParams)((View)localObject1).getLayoutParams()).isItemRemoved()) {
        break label113;
      }
      if (paramRecycler != null) {
        break label172;
      }
      paramRecycler = paramState;
      paramState = (RecyclerView.State)localObject1;
    }
    for (;;)
    {
      paramInt1 += i;
      localObject1 = paramState;
      paramState = paramRecycler;
      paramRecycler = (RecyclerView.Recycler)localObject1;
      break label35;
      i = -1;
      break;
      label113:
      Object localObject2;
      if (this.mOrientationHelper.getDecoratedStart((View)localObject1) < k)
      {
        localObject2 = localObject1;
        if (this.mOrientationHelper.getDecoratedEnd((View)localObject1) >= j) {}
      }
      else
      {
        if (paramState != null) {
          break label172;
        }
        paramState = paramRecycler;
        paramRecycler = (RecyclerView.Recycler)localObject1;
        continue;
        label157:
        if (paramState == null) {
          break label167;
        }
      }
      for (;;)
      {
        localObject2 = paramState;
        return (View)localObject2;
        label167:
        paramState = paramRecycler;
      }
      label172:
      localObject1 = paramRecycler;
      paramRecycler = paramState;
      paramState = (RecyclerView.State)localObject1;
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int j = paramInt - getPosition(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (getPosition(localView) == paramInt);
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  protected boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, b paramb, LayoutChunkResult paramLayoutChunkResult)
  {
    paramRecycler = paramb.a(paramRecycler);
    if (paramRecycler == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    paramState = (RecyclerView.LayoutParams)paramRecycler.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61:
    int i;
    int j;
    label120:
    int k;
    int m;
    if (paramb.k == null)
    {
      bool2 = this.mShouldReverseLayout;
      if (paramb.f == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramRecycler);
        measureChildWithMargins(paramRecycler, 0, 0);
        paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        if (this.mOrientation != 1) {
          break label322;
        }
        if (!isLayoutRTL()) {
          break label271;
        }
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        if (paramb.f != -1) {
          break label293;
        }
        k = paramb.b;
        m = paramb.b - paramLayoutChunkResult.mConsumed;
      }
    }
    for (;;)
    {
      layoutDecorated(paramRecycler, j + paramState.leftMargin, m + paramState.topMargin, i - paramState.rightMargin, k - paramState.bottomMargin);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable = paramRecycler.isFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramRecycler, 0);
      break label61;
      bool2 = this.mShouldReverseLayout;
      if (paramb.f == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label262;
        }
        addDisappearingView(paramRecycler);
        break;
      }
      label262:
      addDisappearingView(paramRecycler, 0);
      break label61;
      label271:
      j = getPaddingLeft();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
      break label120;
      label293:
      m = paramb.b;
      k = paramb.b;
      int n = paramLayoutChunkResult.mConsumed;
      k += n;
      continue;
      label322:
      m = getPaddingTop();
      k = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
      if (paramb.f == -1)
      {
        i = paramb.b;
        j = paramb.b - paramLayoutChunkResult.mConsumed;
      }
      else
      {
        j = paramb.b;
        i = paramb.b;
        n = paramLayoutChunkResult.mConsumed;
        i += n;
      }
    }
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, a parama, int paramInt) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {}
    label42:
    label133:
    label135:
    label141:
    for (;;)
    {
      return null;
      paramInt = convertFocusDirectionToLayoutDirection(paramInt);
      if (paramInt != Integer.MIN_VALUE)
      {
        ensureLayoutState();
        if (paramInt == -1)
        {
          paramView = findReferenceChildClosestToStart(paramRecycler, paramState);
          if (paramView == null) {
            break label133;
          }
          ensureLayoutState();
          updateLayoutState(paramInt, (int)(0.33333334F * this.mOrientationHelper.getTotalSpace()), false, paramState);
          this.mLayoutState.g = Integer.MIN_VALUE;
          this.mLayoutState.a = false;
          fill(paramRecycler, this.mLayoutState, paramState, true);
          if (paramInt != -1) {
            break label135;
          }
        }
        for (paramRecycler = getChildClosestToStart();; paramRecycler = getChildClosestToEnd())
        {
          if ((paramRecycler == paramView) || (!paramRecycler.isFocusable())) {
            break label141;
          }
          return paramRecycler;
          paramView = findReferenceChildClosestToEnd(paramRecycler, paramState);
          break label42;
          break;
        }
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.a = false;
    resolveShouldLayoutReverse();
    this.mAnchorInfo.a();
    this.mAnchorInfo.c = (this.mShouldReverseLayout ^ this.mStackFromEnd);
    updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
    int i = getExtraLayoutSpace(paramState);
    int j;
    int m;
    int n;
    int k;
    Object localObject;
    if (this.mLayoutState.j >= 0)
    {
      j = 0;
      m = j + this.mOrientationHelper.getStartAfterPadding();
      n = i + this.mOrientationHelper.getEndPadding();
      j = n;
      k = m;
      if (paramState.isPreLayout())
      {
        j = n;
        k = m;
        if (this.mPendingScrollPosition != -1)
        {
          j = n;
          k = m;
          if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE)
          {
            localObject = findViewByPosition(this.mPendingScrollPosition);
            j = n;
            k = m;
            if (localObject != null)
            {
              if (!this.mShouldReverseLayout) {
                break label662;
              }
              i = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject) - this.mPendingScrollPositionOffset;
              label248:
              if (i <= 0) {
                break label696;
              }
              k = m + i;
              j = n;
            }
          }
        }
      }
      label264:
      if (!this.mAnchorInfo.c) {
        break label716;
      }
      if (!this.mShouldReverseLayout) {
        break label710;
      }
      i = 1;
      label284:
      onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, i);
      detachAndScrapAttachedViews(paramRecycler);
      this.mLayoutState.l = resolveIsInfinite();
      this.mLayoutState.i = paramState.isPreLayout();
      if (!this.mAnchorInfo.c) {
        break label735;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.h = k;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.b;
      n = this.mLayoutState.d;
      i = j;
      if (this.mLayoutState.c > 0) {
        i = j + this.mLayoutState.c;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.h = i;
      localObject = this.mLayoutState;
      ((b)localObject).d += this.mLayoutState.e;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      k = this.mLayoutState.b;
      if (this.mLayoutState.c <= 0) {
        break label988;
      }
      i = this.mLayoutState.c;
      updateLayoutStateToFillStart(n, m);
      this.mLayoutState.h = i;
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    label530:
    label662:
    label696:
    label710:
    label716:
    label735:
    label939:
    label988:
    for (i = this.mLayoutState.b;; i = m)
    {
      j = i;
      i = k;
      k = i;
      m = j;
      if (getChildCount() > 0)
      {
        if (!(this.mShouldReverseLayout ^ this.mStackFromEnd)) {
          break label939;
        }
        k = fixLayoutEndGap(i, paramRecycler, paramState, true);
        m = j + k;
        j = fixLayoutStartGap(m, paramRecycler, paramState, false);
        m += j;
      }
      for (k = i + k + j;; k = i + n)
      {
        layoutForPredictiveAnimations(paramRecycler, paramState, m, k);
        if (!paramState.isPreLayout())
        {
          this.mPendingScrollPosition = -1;
          this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
          this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
        this.mPendingSavedState = null;
        return;
        j = i;
        i = 0;
        break;
        i = this.mOrientationHelper.getDecoratedStart((View)localObject);
        j = this.mOrientationHelper.getStartAfterPadding();
        i = this.mPendingScrollPositionOffset - (i - j);
        break label248;
        j = n - i;
        k = m;
        break label264;
        i = -1;
        break label284;
        if (this.mShouldReverseLayout)
        {
          i = -1;
          break label284;
        }
        i = 1;
        break label284;
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        this.mLayoutState.h = j;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        m = this.mLayoutState.b;
        n = this.mLayoutState.d;
        i = k;
        if (this.mLayoutState.c > 0) {
          i = k + this.mLayoutState.c;
        }
        updateLayoutStateToFillStart(this.mAnchorInfo);
        this.mLayoutState.h = i;
        localObject = this.mLayoutState;
        ((b)localObject).d += this.mLayoutState.e;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        k = this.mLayoutState.b;
        i = m;
        j = k;
        if (this.mLayoutState.c <= 0) {
          break label530;
        }
        i = this.mLayoutState.c;
        updateLayoutStateToFillEnd(n, m);
        this.mLayoutState.h = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i = this.mLayoutState.b;
        j = k;
        break label530;
        k = fixLayoutStartGap(j, paramRecycler, paramState, true);
        i += k;
        n = fixLayoutEndGap(i, paramRecycler, paramState, false);
        m = j + k + n;
      }
    }
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
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localView = getChildClosestToEnd();
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView));
        localSavedState.mAnchorPosition = getPosition(localView);
        return localSavedState;
      }
      View localView = getChildClosestToStart();
      localSavedState.mAnchorPosition = getPosition(localView);
      localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }
  
  public void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    }
    while (this.mShouldReverseLayout) {
      if (paramInt1 == 1)
      {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
        paramInt1 = -1;
      }
      else
      {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
        return;
      }
    }
    if (paramInt1 == -1)
    {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
  }
  
  boolean resolveIsInfinite()
  {
    return (this.mOrientationHelper.getMode() == 0) && (this.mOrientationHelper.getEnd() == 0);
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.mLayoutState.a = true;
    ensureLayoutState();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      k = this.mLayoutState.g + fill(paramRecycler, this.mLayoutState, paramState, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.mOrientationHelper.offsetChildren(-paramInt);
    this.mLayoutState.j = paramInt;
    return paramInt;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.mOrientationHelper = null;
    requestLayout();
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout) {
      return;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean) {
      return;
    }
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new aj(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd);
  }
  
  void validateChildOrder()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Log.d("LinearLayoutManager", "validating child count " + getChildCount());
    if (getChildCount() < 1) {}
    for (;;)
    {
      return;
      int j = getPosition(getChildAt(0));
      int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
      int i;
      Object localObject;
      int m;
      int n;
      if (this.mShouldReverseLayout)
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (;;)
            {
              throw new RuntimeException(bool1);
              bool1 = false;
            }
          }
          if (n > k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
      else
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (bool1 = bool2;; bool1 = false) {
              throw new RuntimeException(bool1);
            }
          }
          if (n < k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
    }
  }
  
  protected static class LayoutChunkResult
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
    
    void resetInternal()
    {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new ak();
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mAnchorOffset = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.mAnchorLayoutFromEnd = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mAnchorOffset = paramSavedState.mAnchorOffset;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    boolean hasValidAnchor()
    {
      return this.mAnchorPosition >= 0;
    }
    
    void invalidateAnchor()
    {
      this.mAnchorPosition = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mAnchorPosition);
      paramParcel.writeInt(this.mAnchorOffset);
      if (this.mAnchorLayoutFromEnd) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  class a
  {
    int a;
    int b;
    boolean c;
    
    a() {}
    
    private boolean a(View paramView, RecyclerView.State paramState)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramState.getItemCount());
    }
    
    void a()
    {
      this.a = -1;
      this.b = Integer.MIN_VALUE;
      this.c = false;
    }
    
    public void a(View paramView)
    {
      int j = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
      if (j >= 0) {
        b(paramView);
      }
      int i;
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              return;
              this.a = LinearLayoutManager.this.getPosition(paramView);
              if (!this.c) {
                break;
              }
              i = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - j - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(paramView);
              this.b = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - i);
            } while (i <= 0);
            j = LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(paramView);
            k = this.b;
            m = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            j = k - j - (m + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(paramView) - m, 0));
          } while (j >= 0);
          k = this.b;
          this.b = (Math.min(i, -j) + k);
          return;
          k = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(paramView);
          i = k - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
          this.b = k;
        } while (i <= 0);
        int m = LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(paramView);
        int n = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
        int i1 = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(paramView);
        j = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(0, n - j - i1) - (k + m);
      } while (j >= 0);
      this.b -= Math.min(i, -j);
    }
    
    void b()
    {
      if (this.c) {}
      for (int i = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();; i = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding())
      {
        this.b = i;
        return;
      }
    }
    
    public void b(View paramView)
    {
      if (this.c) {}
      for (this.b = (LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(paramView) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange());; this.b = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(paramView))
      {
        this.a = LinearLayoutManager.this.getPosition(paramView);
        return;
      }
    }
    
    public String toString()
    {
      return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }
  }
  
  static class b
  {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List<RecyclerView.ViewHolder> k = null;
    boolean l;
    
    private View b()
    {
      int n = this.k.size();
      int m = 0;
      if (m < n)
      {
        View localView = ((RecyclerView.ViewHolder)this.k.get(m)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isItemRemoved()) {}
        while (this.d != localLayoutParams.getViewLayoutPosition())
        {
          m += 1;
          break;
        }
        a(localView);
        return localView;
      }
      return null;
    }
    
    View a(RecyclerView.Recycler paramRecycler)
    {
      if (this.k != null) {
        return b();
      }
      paramRecycler = paramRecycler.getViewForPosition(this.d);
      this.d += this.e;
      return paramRecycler;
    }
    
    public void a()
    {
      a(null);
    }
    
    public void a(View paramView)
    {
      paramView = b(paramView);
      if (paramView == null)
      {
        this.d = -1;
        return;
      }
      this.d = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    boolean a(RecyclerView.State paramState)
    {
      return (this.d >= 0) && (this.d < paramState.getItemCount());
    }
    
    public View b(View paramView)
    {
      int i2 = this.k.size();
      Object localObject = null;
      int m = Integer.MAX_VALUE;
      int n = 0;
      if (n < i2)
      {
        View localView = ((RecyclerView.ViewHolder)this.k.get(n)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if (localView != paramView) {
          if (!localLayoutParams.isItemRemoved()) {}
        }
        for (;;)
        {
          n += 1;
          break;
          int i1 = (localLayoutParams.getViewLayoutPosition() - this.d) * this.e;
          if (i1 >= 0) {
            if (i1 < m)
            {
              if (i1 == 0) {
                return localView;
              }
              localObject = localView;
              m = i1;
            }
          }
        }
      }
      return (View)localObject;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */