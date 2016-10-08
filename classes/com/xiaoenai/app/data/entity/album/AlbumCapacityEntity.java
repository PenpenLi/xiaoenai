package com.xiaoenai.app.data.entity.album;

import com.google.gson.annotations.SerializedName;

public class AlbumCapacityEntity
{
  @SerializedName(a="max_capacity")
  private int maxCapacity;
  @SerializedName(a="used")
  private int used;
  
  public int getMaxCapacity()
  {
    return this.maxCapacity;
  }
  
  public int getUsed()
  {
    return this.used;
  }
  
  public void setMaxCapacity(int paramInt)
  {
    this.maxCapacity = paramInt;
  }
  
  public void setUsed(int paramInt)
  {
    this.used = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\album\AlbumCapacityEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */