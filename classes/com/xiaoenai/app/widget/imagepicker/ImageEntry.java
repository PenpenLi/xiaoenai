package com.xiaoenai.app.widget.imagepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageEntry
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ImageEntry> CREATOR = new r();
  private int a;
  private String b;
  private boolean c = false;
  private String d;
  
  public ImageEntry() {}
  
  public ImageEntry(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
  }
  
  public String a()
  {
    return "file://" + this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    if (this.c) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.d);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\ImageEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */