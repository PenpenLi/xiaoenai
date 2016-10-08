package com.xiaoenai.app.utils;

import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Parcel;

class z
  extends Binder
{
  z(OpenUDID_service paramOpenUDID_service) {}
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("openudid_prefs", 0);
    paramParcel2.writeInt(paramParcel1.readInt());
    paramParcel2.writeString(localSharedPreferences.getString("openudid", null));
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */