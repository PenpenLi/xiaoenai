package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class InMobiStrandAdapter
  extends BaseAdapter
{
  private static final String TAG = InMobiStrandAdapter.class.getSimpleName();
  private boolean mIsInitialized = false;
  private Handler mListViewHandler;
  @Nullable
  private NativeStrandAdListener mListener;
  @NonNull
  private ad mNativeStrandController;
  @NonNull
  private Adapter mOriginalAdapter;
  @NonNull
  private WeakHashMap<View, Integer> mViewPositionMap;
  @NonNull
  private ap mVisibilityTracker;
  
  public InMobiStrandAdapter(@NonNull Context paramContext, long paramLong, @NonNull Adapter paramAdapter, @NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    if (paramAdapter == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Original Adapter is null!, InMobiStrandAdapter could not be initialized");
      throw new IllegalArgumentException("Invalid original adapter:null");
    }
    if (paramContext == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Context is null, InMobiStrandAdapter could not be initialized");
      this.mIsInitialized = false;
    }
    while (this.mIsInitialized)
    {
      initWithPlacer(paramContext, paramLong, paramAdapter, paramInMobiClientPositioning);
      return;
      if (!(paramContext instanceof Activity))
      {
        Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Context is not Activity, InMobiStrandAdapter could not be initialized");
        this.mIsInitialized = false;
      }
      else if (paramInMobiClientPositioning == null)
      {
        Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ClientPositioning is null, InMobiStrandAdapter could not be initialized");
        this.mIsInitialized = false;
      }
      else if (!com.inmobi.commons.a.a.a())
      {
        Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobi SDK is not initialized! InMobiStrandAdapter could not be initialized");
        this.mIsInitialized = false;
      }
      else
      {
        this.mIsInitialized = true;
      }
    }
    initWithoutPlacer(paramAdapter);
  }
  
  private void handleAdLoaded(int paramInt)
  {
    notifyDataSetChanged();
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", Integer.valueOf(paramInt));
    com.inmobi.commons.core.c.a.a().a("ads", "StrandPlaced", localHashMap);
    if (this.mListener != null) {
      this.mListener.onAdLoadSucceeded(paramInt);
    }
  }
  
  private void handleAdRemoved(int paramInt)
  {
    notifyDataSetChanged();
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", Integer.valueOf(paramInt));
    com.inmobi.commons.core.c.a.a().a("ads", "StrandRemoved", localHashMap);
    if (this.mListener != null) {
      this.mListener.onAdRemoved(paramInt);
    }
  }
  
  private void handleVisibilityChange(@NonNull List<View> paramList)
  {
    paramList = paramList.iterator();
    int j = Integer.MAX_VALUE;
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (View)paramList.next();
      localObject = (Integer)this.mViewPositionMap.get(localObject);
      if (localObject != null)
      {
        j = Math.min(((Integer)localObject).intValue(), j);
        i = Math.max(((Integer)localObject).intValue(), i);
      }
    }
    this.mNativeStrandController.a(j, i + 1);
  }
  
  private void initWithPlacer(@NonNull Context paramContext, long paramLong, @NonNull Adapter paramAdapter, @NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    this.mNativeStrandController = new ad(paramContext, paramLong, paramInMobiClientPositioning);
    this.mOriginalAdapter = paramAdapter;
    this.mOriginalAdapter.registerDataSetObserver(new InMobiStrandAdapter.1(this));
    this.mListViewHandler = new Handler();
    this.mVisibilityTracker = new m(ap.a, (Activity)paramContext);
    this.mVisibilityTracker.a(new InMobiStrandAdapter.3(this));
    this.mViewPositionMap = new WeakHashMap();
    this.mOriginalAdapter.registerDataSetObserver(new InMobiStrandAdapter.4(this));
    this.mNativeStrandController.a(new InMobiStrandAdapter.5(this));
  }
  
  private void initWithoutPlacer(@NonNull Adapter paramAdapter)
  {
    this.mOriginalAdapter = paramAdapter;
    this.mListViewHandler = new Handler();
    this.mOriginalAdapter.registerDataSetObserver(new InMobiStrandAdapter.6(this));
  }
  
  public void clearStrands()
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.clearStrands()");
      return;
    }
    this.mVisibilityTracker.c();
    this.mNativeStrandController.d();
  }
  
  public void destroy()
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.destroy()");
      return;
    }
    this.mNativeStrandController.e();
    this.mVisibilityTracker.e();
  }
  
  public int getAdjustedPosition(int paramInt)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
      return paramInt;
    }
    return this.mNativeStrandController.f(paramInt);
  }
  
  public int getCount()
  {
    if (!this.mIsInitialized) {
      return this.mOriginalAdapter.getCount();
    }
    return this.mNativeStrandController.h(this.mOriginalAdapter.getCount());
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject1;
    if (!this.mIsInitialized) {
      localObject1 = this.mOriginalAdapter.getItem(paramInt);
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = this.mNativeStrandController.a(paramInt);
      localObject1 = localObject2;
    } while (localObject2 != null);
    return this.mOriginalAdapter.getItem(this.mNativeStrandController.e(paramInt));
  }
  
  public long getItemId(int paramInt)
  {
    if (!this.mIsInitialized) {
      return this.mOriginalAdapter.getItemId(paramInt);
    }
    Object localObject = this.mNativeStrandController.a(paramInt);
    if (localObject != null) {
      return (System.identityHashCode(localObject) ^ 0xFFFFFFFF) + 1;
    }
    return this.mOriginalAdapter.getItemId(this.mNativeStrandController.e(paramInt));
  }
  
  public int getItemViewType(int paramInt)
  {
    if (!this.mIsInitialized) {
      return this.mOriginalAdapter.getItemViewType(paramInt);
    }
    int i = this.mNativeStrandController.d(paramInt);
    if (i != 0) {
      return i + this.mOriginalAdapter.getViewTypeCount() - 1;
    }
    return this.mOriginalAdapter.getItemViewType(this.mNativeStrandController.e(paramInt));
  }
  
  public int getOriginalPosition(int paramInt)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
      return paramInt;
    }
    return this.mNativeStrandController.e(paramInt);
  }
  
  @Nullable
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!this.mIsInitialized)
    {
      paramViewGroup = this.mOriginalAdapter.getView(paramInt, paramView, paramViewGroup);
      return paramViewGroup;
    }
    View localView = this.mNativeStrandController.a(paramInt, paramView, paramViewGroup);
    if (localView != null) {}
    for (paramView = localView;; paramView = this.mOriginalAdapter.getView(this.mNativeStrandController.e(paramInt), paramView, paramViewGroup))
    {
      this.mViewPositionMap.put(paramView, Integer.valueOf(paramInt));
      paramViewGroup = paramView;
      if (this.mVisibilityTracker.f()) {
        break;
      }
      this.mVisibilityTracker.a(paramView, null, 0);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    if (!this.mIsInitialized) {
      return this.mOriginalAdapter.getViewTypeCount();
    }
    return this.mOriginalAdapter.getViewTypeCount() + this.mNativeStrandController.c();
  }
  
  public boolean hasStableIds()
  {
    return this.mOriginalAdapter.hasStableIds();
  }
  
  public void insertItem(int paramInt)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter ignoring InMobiStrandAdapter.insertItem()");
      return;
    }
    this.mNativeStrandController.i(paramInt);
  }
  
  public boolean isEmpty()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.mIsInitialized) {
      bool1 = this.mOriginalAdapter.isEmpty();
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.mOriginalAdapter.isEmpty());
      bool1 = bool2;
    } while (this.mNativeStrandController.h(0) != 0);
    return true;
  }
  
  public boolean isStrand(int paramInt)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.isStrand()");
      return false;
    }
    return this.mNativeStrandController.b(paramInt);
  }
  
  public void load()
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.load()");
      return;
    }
    this.mVisibilityTracker.d();
    this.mNativeStrandController.a();
  }
  
  public void refreshAds(@NonNull ListView paramListView)
  {
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot refresh ads");
      return;
    }
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized! ignoring InMobiStrandAdapter.refreshAds()");
      return;
    }
    View localView = paramListView.getChildAt(0);
    if (localView == null) {}
    int m;
    for (int i = 0;; i = localView.getTop())
    {
      m = paramListView.getFirstVisiblePosition();
      j = Math.max(m - 1, 0);
      while ((this.mNativeStrandController.b(j)) && (j > 0)) {
        j -= 1;
      }
    }
    int k = paramListView.getLastVisiblePosition();
    while ((this.mNativeStrandController.b(k)) && (k < getCount() - 1)) {
      k += 1;
    }
    int j = this.mNativeStrandController.e(j);
    k = this.mNativeStrandController.g(k + 1);
    int n = this.mNativeStrandController.g(getCount());
    this.mNativeStrandController.b(k, n);
    j = this.mNativeStrandController.b(0, j);
    if (j > 0) {
      paramListView.setSelectionFromTop(m - j, i);
    }
    load();
  }
  
  public void removeItem(int paramInt)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter,ignoring InMobiStrandAdapter.removeItem()");
      return;
    }
    this.mNativeStrandController.j(paramInt);
  }
  
  public final void setExtras(Map<String, String> paramMap)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.setExtras()");
      return;
    }
    this.mNativeStrandController.a(paramMap);
  }
  
  public void setKeywords(String paramString)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.setKeywords()");
      return;
    }
    this.mNativeStrandController.a(paramString);
  }
  
  public void setListener(@Nullable NativeStrandAdListener paramNativeStrandAdListener)
  {
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, ignoring InMobiStrandAdapter.setListener()");
      return;
    }
    if (paramNativeStrandAdListener == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand.NativeStrandAdListener supplied as null.");
      return;
    }
    this.mListener = paramNativeStrandAdListener;
  }
  
  public void setOnClickListener(@NonNull ListView paramListView, @Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (!this.mIsInitialized) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
    }
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot set onClickListener");
      return;
    }
    if (paramOnItemClickListener == null)
    {
      paramListView.setOnItemClickListener(null);
      return;
    }
    paramListView.setOnItemClickListener(new InMobiStrandAdapter.7(this, paramOnItemClickListener));
  }
  
  public void setOnItemLongClickListener(@NonNull ListView paramListView, @Nullable AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!this.mIsInitialized) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
    }
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot set OnItemLongClickListener");
      return;
    }
    if (paramOnItemLongClickListener == null)
    {
      paramListView.setOnItemLongClickListener(null);
      return;
    }
    paramListView.setOnItemLongClickListener(new InMobiStrandAdapter.8(this, paramOnItemLongClickListener));
  }
  
  public void setOnItemSelectedListener(@NonNull ListView paramListView, @Nullable AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (!this.mIsInitialized) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
    }
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot set OnItemSelectedListener");
      return;
    }
    if (paramOnItemSelectedListener == null)
    {
      paramListView.setOnItemSelectedListener(null);
      return;
    }
    paramListView.setOnItemSelectedListener(new InMobiStrandAdapter.9(this, paramOnItemSelectedListener));
  }
  
  public void setSelection(@NonNull ListView paramListView, int paramInt)
  {
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot set selection");
      return;
    }
    if (!this.mIsInitialized)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiStrandAdapter is not initialized!, Initialize InMobiSdk before creating InMobiStrandAdapter");
      paramListView.setSelection(paramInt);
      return;
    }
    paramListView.setSelection(this.mNativeStrandController.f(paramInt));
  }
  
  public void smoothScrollToPosition(@NonNull ListView paramListView, int paramInt)
  {
    if (paramListView == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "ListView is null cannot smoothScrollToPosition:" + paramInt);
      return;
    }
    if (!this.mIsInitialized) {}
    for (;;)
    {
      paramListView.setOnScrollListener(new InMobiStrandAdapter.10(this, paramListView, paramInt));
      this.mListViewHandler.post(new InMobiStrandAdapter.2(this, paramListView, paramInt));
      return;
      paramInt = this.mNativeStrandController.f(paramInt);
    }
  }
  
  public static abstract interface NativeStrandAdListener
  {
    public abstract void onAdLoadSucceeded(int paramInt);
    
    public abstract void onAdRemoved(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */