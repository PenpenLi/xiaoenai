package com.xiaoenai.app.data.entity;

public class ImageResultEntity
{
  private ImageEntity imageEntity;
  private String imagePath;
  private int progress;
  
  public ImageEntity getImageEntity()
  {
    return this.imageEntity;
  }
  
  public String getImagePath()
  {
    return this.imagePath;
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  public void setImageEntity(ImageEntity paramImageEntity)
  {
    this.imageEntity = paramImageEntity;
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\ImageResultEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */