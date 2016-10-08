package com.xiaoenai.app.database.bean;

public class AlbumData
{
  private Long createdTs;
  private String feeling;
  private Long groupId;
  private Integer height;
  private Long id;
  private Boolean isOrigin;
  private Integer size;
  private String url;
  private Integer width;
  
  public AlbumData() {}
  
  public AlbumData(Integer paramInteger1, Boolean paramBoolean, Long paramLong1, Integer paramInteger2, Integer paramInteger3, Long paramLong2, String paramString1, String paramString2, Long paramLong3)
  {
    this.width = paramInteger1;
    this.isOrigin = paramBoolean;
    this.id = paramLong1;
    this.height = paramInteger2;
    this.size = paramInteger3;
    this.groupId = paramLong2;
    this.url = paramString1;
    this.feeling = paramString2;
    this.createdTs = paramLong3;
  }
  
  public AlbumData(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public Long getCreatedTs()
  {
    return this.createdTs;
  }
  
  public String getFeeling()
  {
    return this.feeling;
  }
  
  public Long getGroupId()
  {
    return this.groupId;
  }
  
  public Integer getHeight()
  {
    return this.height;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public Boolean getIsOrigin()
  {
    return this.isOrigin;
  }
  
  public Integer getSize()
  {
    return this.size;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public Integer getWidth()
  {
    return this.width;
  }
  
  public void setCreatedTs(Long paramLong)
  {
    this.createdTs = paramLong;
  }
  
  public void setFeeling(String paramString)
  {
    this.feeling = paramString;
  }
  
  public void setGroupId(Long paramLong)
  {
    this.groupId = paramLong;
  }
  
  public void setHeight(Integer paramInteger)
  {
    this.height = paramInteger;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIsOrigin(Boolean paramBoolean)
  {
    this.isOrigin = paramBoolean;
  }
  
  public void setSize(Integer paramInteger)
  {
    this.size = paramInteger;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(Integer paramInteger)
  {
    this.width = paramInteger;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\AlbumData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */