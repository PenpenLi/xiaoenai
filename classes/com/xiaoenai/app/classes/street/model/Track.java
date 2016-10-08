package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Context", b="context"), @com.xiaoenai.app.annotation.json.JsonElement(a="Time", b="time")})
public class Track
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Track> CREATOR = new Track.1();
  private String context;
  private String time;
  
  public Track() {}
  
  protected Track(Parcel paramParcel)
  {
    this.time = paramParcel.readString();
    this.context = paramParcel.readString();
  }
  
  public Track(String paramString1, String paramString2)
  {
    this.time = paramString1;
    this.context = paramString2;
  }
  
  public Track(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Track.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContext()
  {
    return this.context;
  }
  
  public String getTime()
  {
    return this.time;
  }
  
  public void setContext(String paramString)
  {
    this.context = paramString;
  }
  
  public void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.time);
    paramParcel.writeString(this.context);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Track.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */