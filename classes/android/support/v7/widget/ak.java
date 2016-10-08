package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ak
  implements Parcelable.Creator<LinearLayoutManager.SavedState>
{
  public LinearLayoutManager.SavedState a(Parcel paramParcel)
  {
    return new LinearLayoutManager.SavedState(paramParcel);
  }
  
  public LinearLayoutManager.SavedState[] a(int paramInt)
  {
    return new LinearLayoutManager.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */