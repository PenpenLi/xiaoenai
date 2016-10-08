package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator<ActionMenuPresenter.SavedState>
{
  public ActionMenuPresenter.SavedState a(Parcel paramParcel)
  {
    return new ActionMenuPresenter.SavedState(paramParcel);
  }
  
  public ActionMenuPresenter.SavedState[] a(int paramInt)
  {
    return new ActionMenuPresenter.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */