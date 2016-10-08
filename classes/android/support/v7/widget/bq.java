package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bq
  implements Parcelable.Creator<SearchView.SavedState>
{
  public SearchView.SavedState a(Parcel paramParcel)
  {
    return new SearchView.SavedState(paramParcel);
  }
  
  public SearchView.SavedState[] a(int paramInt)
  {
    return new SearchView.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */