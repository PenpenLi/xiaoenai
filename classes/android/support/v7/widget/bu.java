package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bu
  implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState>
{
  public StaggeredGridLayoutManager.SavedState a(Parcel paramParcel)
  {
    return new StaggeredGridLayoutManager.SavedState(paramParcel);
  }
  
  public StaggeredGridLayoutManager.SavedState[] a(int paramInt)
  {
    return new StaggeredGridLayoutManager.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */