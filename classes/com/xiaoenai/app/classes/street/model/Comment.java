package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="CouplePhoto", b="couple_photo"), @com.xiaoenai.app.annotation.json.JsonElement(a="Content", b="content"), @com.xiaoenai.app.annotation.json.JsonElement(a="CreatedTime", b="created_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="Uid", b="uid")})
public class Comment
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Comment> CREATOR = new Comment.1();
  private String content;
  private String couple_photo;
  private long created_time;
  private int id;
  private String name;
  private int uid;
  
  public Comment() {}
  
  public Comment(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.id = paramInt1;
    this.uid = paramInt2;
    this.name = paramString1;
    this.couple_photo = paramString2;
    this.content = paramString3;
    this.created_time = paramLong;
  }
  
  protected Comment(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.uid = paramParcel.readInt();
    this.name = paramParcel.readString();
    this.couple_photo = paramParcel.readString();
    this.content = paramParcel.readString();
    this.created_time = paramParcel.readLong();
  }
  
  public Comment(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Comment.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static ArrayList<Comment> getCommentList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(new Comment(paramJSONArray.optJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getCouplePhoto()
  {
    return this.couple_photo;
  }
  
  public long getCreatedTime()
  {
    return this.created_time;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getUid()
  {
    return this.uid;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCouplePhoto(String paramString)
  {
    this.couple_photo = paramString;
  }
  
  public void setCreatedTime(long paramLong)
  {
    this.created_time = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setUid(int paramInt)
  {
    this.uid = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.uid);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.couple_photo);
    paramParcel.writeString(this.content);
    paramParcel.writeLong(this.created_time);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Comment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */