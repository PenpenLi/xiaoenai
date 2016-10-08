package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="expressName", b="express_name"), @com.xiaoenai.app.annotation.json.JsonElement(a="iconUrl", b="icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="status", b="status"), @com.xiaoenai.app.annotation.json.JsonElement(a="tracks", b="tracks")})
public class Delivery
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Delivery> CREATOR = new Delivery.1();
  public static final int DELIVERY_STATE_PULLING = 1;
  public static final int DELIVERY_STATE_RECEIVED = 3;
  public static final int DELIVERY_STATE_ROUTE = 0;
  public static final int DELIVERY_STATE_TROUBLE = 2;
  private String express_name;
  private String icon_url;
  private String id;
  private int status;
  private Track[] tracks;
  
  public Delivery() {}
  
  protected Delivery(Parcel paramParcel)
  {
    this.status = paramParcel.readInt();
    this.tracks = ((Track[])paramParcel.createTypedArray(Track.CREATOR));
    this.id = paramParcel.readString();
    this.express_name = paramParcel.readString();
    this.icon_url = paramParcel.readString();
  }
  
  public Delivery(String paramString1, String paramString2, String paramString3, int paramInt, Track[] paramArrayOfTrack)
  {
    this.tracks = paramArrayOfTrack;
    this.id = paramString1;
    this.express_name = paramString2;
    this.icon_url = paramString3;
    this.status = paramInt;
  }
  
  public Delivery(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Delivery.class, paramJSONObject, this);
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
  
  public String getExpressName()
  {
    return this.express_name;
  }
  
  public String getIconUrl()
  {
    return this.icon_url;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public Track[] getTracks()
  {
    return this.tracks;
  }
  
  public void setExpressName(String paramString)
  {
    this.express_name = paramString;
  }
  
  public void setIconUrl(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTracks(Track[] paramArrayOfTrack)
  {
    this.tracks = paramArrayOfTrack;
  }
  
  public void tracksJsonTransformer(Object paramObject)
  {
    paramObject = (JSONArray)paramObject;
    this.tracks = new Track[((JSONArray)paramObject).length()];
    int i = 0;
    for (;;)
    {
      if (i < ((JSONArray)paramObject).length())
      {
        this.tracks[i] = new Track();
        try
        {
          this.tracks[i].fromJson(Track.class, ((JSONArray)paramObject).optJSONObject(i), this.tracks[i]);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.status);
    paramParcel.writeTypedArray(this.tracks, paramInt);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.express_name);
    paramParcel.writeString(this.icon_url);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Delivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */