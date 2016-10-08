package com.xiaoenai.app.data.entity.album;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class AlbumEntity
{
  @SerializedName(a="capacity_info")
  private AlbumCapacityEntity capacityInfo;
  @SerializedName(a="timelines")
  private ArrayList<AlbumGroupEntity> timeLines;
  
  public AlbumCapacityEntity getCapacityInfo()
  {
    return this.capacityInfo;
  }
  
  public ArrayList<AlbumGroupEntity> getTimeLines()
  {
    return this.timeLines;
  }
  
  public void setCapacityInfo(AlbumCapacityEntity paramAlbumCapacityEntity)
  {
    this.capacityInfo = paramAlbumCapacityEntity;
  }
  
  public void setTimeLines(ArrayList<AlbumGroupEntity> paramArrayList)
  {
    this.timeLines = paramArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\album\AlbumEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */