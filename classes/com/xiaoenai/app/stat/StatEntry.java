package com.xiaoenai.app.stat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="logId", b="log_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="deviceId", b="device_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="uid", b="uid"), @com.xiaoenai.app.annotation.json.JsonElement(a="net", b="net"), @com.xiaoenai.app.annotation.json.JsonElement(a="initate", b="initate"), @com.xiaoenai.app.annotation.json.JsonElement(a="timestamp", b="timestamp"), @com.xiaoenai.app.annotation.json.JsonElement(a="status", b="status"), @com.xiaoenai.app.annotation.json.JsonElement(a="refer", b="refer"), @com.xiaoenai.app.annotation.json.JsonElement(a="page", b="page"), @com.xiaoenai.app.annotation.json.JsonElement(a="follow", b="follow"), @com.xiaoenai.app.annotation.json.JsonElement(a="expId", b="exp_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="event", b="event"), @com.xiaoenai.app.annotation.json.JsonElement(a="expand", b="expand")})
public class StatEntry
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<StatEntry> CREATOR = new b();
  private String deviceId;
  private String event;
  private int expId;
  private String expand;
  private String follow;
  private int id;
  private long initate;
  private int logId;
  private String net;
  private String page;
  private String refer;
  private int status;
  private long timestamp;
  private int uid;
  
  public StatEntry() {}
  
  private StatEntry(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.logId = paramParcel.readInt();
    this.deviceId = paramParcel.readString();
    this.uid = paramParcel.readInt();
    this.net = paramParcel.readString();
    this.initate = paramParcel.readLong();
    this.timestamp = paramParcel.readLong();
    this.status = paramParcel.readInt();
    this.refer = paramParcel.readString();
    this.page = paramParcel.readString();
    this.follow = paramParcel.readString();
    this.expId = paramParcel.readInt();
    this.event = paramParcel.readString();
    this.expand = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getEvent()
  {
    return this.event;
  }
  
  public int getExpId()
  {
    return this.expId;
  }
  
  public String getExpand()
  {
    return this.expand;
  }
  
  public String getFollow()
  {
    return this.follow;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public long getInitate()
  {
    return this.initate;
  }
  
  public int getLogId()
  {
    return this.logId;
  }
  
  public String getNet()
  {
    return this.net;
  }
  
  public String getPage()
  {
    return this.page;
  }
  
  public String getRefer()
  {
    return this.refer;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getUid()
  {
    return this.uid;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setEvent(String paramString)
  {
    this.event = paramString;
  }
  
  public void setExpId(int paramInt)
  {
    this.expId = paramInt;
  }
  
  public void setExpand(String paramString)
  {
    this.expand = paramString;
  }
  
  public void setFollow(String paramString)
  {
    this.follow = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setInitate(long paramLong)
  {
    this.initate = paramLong;
  }
  
  public void setLogId(int paramInt)
  {
    this.logId = paramInt;
  }
  
  public void setNet(String paramString)
  {
    this.net = paramString;
  }
  
  public void setPage(String paramString)
  {
    this.page = paramString;
  }
  
  public void setRefer(String paramString)
  {
    this.refer = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setUid(int paramInt)
  {
    this.uid = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.logId);
    paramParcel.writeString(this.deviceId);
    paramParcel.writeInt(this.uid);
    paramParcel.writeString(this.net);
    paramParcel.writeLong(this.initate);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.refer);
    paramParcel.writeString(this.page);
    paramParcel.writeString(this.follow);
    paramParcel.writeInt(this.expId);
    paramParcel.writeString(this.event);
    paramParcel.writeString(this.expand);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\stat\StatEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */