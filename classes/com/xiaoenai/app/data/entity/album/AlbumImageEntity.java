package com.xiaoenai.app.data.entity.album;

import com.google.gson.annotations.SerializedName;

public class AlbumImageEntity
{
  @SerializedName(a="height")
  private int height;
  @SerializedName(a="id")
  private int id;
  @SerializedName(a="is_origin")
  private int isOrigin;
  @SerializedName(a="fsize")
  private int size;
  @SerializedName(a="url")
  private String url;
  @SerializedName(a="width")
  private int width;
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public boolean getIsOrigin()
  {
    return this.isOrigin == 1;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsOrigin(int paramInt)
  {
    this.isOrigin = paramInt;
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\album\AlbumImageEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */