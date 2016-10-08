package io.github.rockerhieu.emojicon.emoji;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Emojicon
  implements Parcelable
{
  public static final Parcelable.Creator<Emojicon> CREATOR = new a();
  private int a;
  private char b;
  private String c;
  
  private Emojicon() {}
  
  public Emojicon(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = ((char)paramParcel.readInt());
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Emojicon)) && (this.c.equals(((Emojicon)paramObject).c));
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
  }
  
  public static @interface Alignment {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\io\github\rockerhieu\emojicon\emoji\Emojicon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */