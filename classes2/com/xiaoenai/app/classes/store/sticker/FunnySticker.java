package com.xiaoenai.app.classes.store.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class FunnySticker
  extends BaseSticker
{
  public static final Parcelable.Creator<BaseSticker> CREATOR = new b();
  private String[] allUrl;
  private String bgUrl;
  private float discount;
  
  public FunnySticker() {}
  
  private FunnySticker(Parcel paramParcel)
  {
    read(paramParcel);
  }
  
  public String[] getAllUrl()
  {
    return this.allUrl;
  }
  
  public String getBgUrl()
  {
    return this.bgUrl;
  }
  
  public float getDiscount()
  {
    return this.discount;
  }
  
  public void setAllUrl(String[] paramArrayOfString)
  {
    this.allUrl = paramArrayOfString;
  }
  
  public void setBgUrl(String paramString)
  {
    this.bgUrl = paramString;
  }
  
  public void setDiscount(float paramFloat)
  {
    this.discount = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\FunnySticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */