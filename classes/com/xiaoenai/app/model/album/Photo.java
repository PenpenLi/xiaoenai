package com.xiaoenai.app.model.album;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="url", b="url"), @com.xiaoenai.app.annotation.json.JsonElement(a="createAt", b="ts"), @com.xiaoenai.app.annotation.json.JsonElement(a="isOriginal", b="is_original"), @com.xiaoenai.app.annotation.json.JsonElement(a="width", b="width"), @com.xiaoenai.app.annotation.json.JsonElement(a="height", b="height")})
public class Photo
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Photo> CREATOR = new Photo.1();
  private int createAt;
  private int height;
  private int id = -1;
  private int isOriginal;
  private boolean selected = false;
  private String url;
  private int width;
  
  public Photo() {}
  
  public Photo(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    this.id = paramInt1;
    this.createAt = paramInt2;
    this.url = paramString;
    this.isOriginal = paramInt3;
    this.width = paramInt4;
    this.height = paramInt5;
  }
  
  protected Photo(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.createAt = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.isOriginal = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.selected = bool;
  }
  
  public Photo(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Photo.class, paramJSONObject, this);
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
  
  public int getCreateAt()
  {
    return this.createAt;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int isOriginal()
  {
    return this.isOriginal;
  }
  
  public boolean isSelected()
  {
    return this.selected;
  }
  
  public void setCreateAt(int paramInt)
  {
    this.createAt = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsOriginal(int paramInt)
  {
    this.isOriginal = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.selected = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.createAt);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.isOriginal);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\album\Photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */