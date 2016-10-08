package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ay
  implements Parcelable.Creator<RecyclerView.SavedState>
{
  public RecyclerView.SavedState a(Parcel paramParcel)
  {
    return new RecyclerView.SavedState(paramParcel);
  }
  
  public RecyclerView.SavedState[] a(int paramInt)
  {
    return new RecyclerView.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */