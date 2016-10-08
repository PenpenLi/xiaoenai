package com.xiaoenai.app.data.entity.album;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class AlbumGroupEntity
{
  @SerializedName(a="image_groups")
  private ArrayList<AlbumImageEntity> albumImageEntity;
  @SerializedName(a="created_ts")
  private long createdTs;
  @SerializedName(a="feeling")
  private String feeling;
  @SerializedName(a="group_id")
  private long groupId;
  
  public ArrayList<AlbumImageEntity> getAlbumImageEntity()
  {
    return this.albumImageEntity;
  }
  
  public long getCreatedTs()
  {
    return this.createdTs;
  }
  
  public String getFeeling()
  {
    return this.feeling;
  }
  
  public long getGroupId()
  {
    return this.groupId;
  }
  
  public void setAlbumImageEntity(ArrayList<AlbumImageEntity> paramArrayList)
  {
    this.albumImageEntity = paramArrayList;
  }
  
  public void setFeeling(String paramString)
  {
    this.feeling = paramString;
  }
  
  public void setGroupId(long paramLong)
  {
    this.groupId = paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\album\AlbumGroupEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */