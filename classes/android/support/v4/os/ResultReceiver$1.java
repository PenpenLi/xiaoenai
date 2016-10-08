package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ResultReceiver$1
  implements Parcelable.Creator<ResultReceiver>
{
  public ResultReceiver createFromParcel(Parcel paramParcel)
  {
    return new ResultReceiver(paramParcel);
  }
  
  public ResultReceiver[] newArray(int paramInt)
  {
    return new ResultReceiver[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\os\ResultReceiver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */