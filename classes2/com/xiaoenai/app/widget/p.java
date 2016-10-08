package com.xiaoenai.app.widget;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class p
  implements ParcelableCompatCreatorCallbacks<LoopViewPager.SavedState>
{
  public LoopViewPager.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new LoopViewPager.SavedState(paramParcel, paramClassLoader);
  }
  
  public LoopViewPager.SavedState[] a(int paramInt)
  {
    return new LoopViewPager.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */