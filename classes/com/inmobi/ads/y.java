package com.inmobi.ads;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class y
  extends PagerAdapter
{
  private static final String a = y.class.getSimpleName();
  private static Handler e = new Handler(Looper.getMainLooper());
  private boolean b;
  @NonNull
  private final x c;
  private ac d;
  @NonNull
  private Map<Integer, Runnable> f = new HashMap();
  
  y(@NonNull x paramx, @NonNull ac paramac)
  {
    this.c = paramx;
    this.d = paramac;
  }
  
  private ViewGroup a(int paramInt, @NonNull ViewGroup paramViewGroup, @NonNull v paramv)
  {
    ViewGroup localViewGroup = this.d.a(paramViewGroup, paramv);
    int i = Math.abs(this.d.a() - paramInt);
    paramViewGroup = new y.2(this, paramInt, localViewGroup, paramViewGroup, paramv);
    this.f.put(Integer.valueOf(paramInt), paramViewGroup);
    e.postDelayed(paramViewGroup, i * 50);
    return localViewGroup;
  }
  
  void a()
  {
    this.b = true;
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      e.removeCallbacks(localRunnable);
    }
    this.f.clear();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    paramViewGroup = (Runnable)this.f.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      e.removeCallbacks(paramViewGroup);
      Logger.a(Logger.InternalLogLevel.INTERNAL, aj.class.getSimpleName(), "Cleared pending task at position:" + paramInt);
    }
    e.post(new y.1(this, paramObject));
  }
  
  public int getCount()
  {
    return this.c.d();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null; (paramObject != null) && ((paramObject instanceof Integer)); paramObject = ((View)paramObject).getTag()) {
      return ((Integer)paramObject).intValue();
    }
    return -2;
  }
  
  @TargetApi(21)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, aj.class.getSimpleName(), "Inflating card at index:" + paramInt);
    v localv = this.c.a(paramInt);
    if (localv == null) {
      return null;
    }
    ViewGroup localViewGroup = a(paramInt, paramViewGroup, localv);
    localViewGroup.setLayoutParams(aj.a(localv, paramViewGroup));
    localViewGroup.setTag(Integer.valueOf(paramInt));
    paramViewGroup.addView(localViewGroup);
    return localViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */