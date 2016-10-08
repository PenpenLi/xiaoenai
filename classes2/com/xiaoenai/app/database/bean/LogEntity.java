package com.xiaoenai.app.database.bean;

public class LogEntity
{
  private Long id;
  private String message;
  private Integer priority;
  private Long ts;
  
  public LogEntity() {}
  
  public LogEntity(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public LogEntity(Long paramLong1, Long paramLong2, Integer paramInteger, String paramString)
  {
    this.id = paramLong1;
    this.ts = paramLong2;
    this.priority = paramInteger;
    this.message = paramString;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public Integer getPriority()
  {
    return this.priority;
  }
  
  public Long getTs()
  {
    return this.ts;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setPriority(Integer paramInteger)
  {
    this.priority = paramInteger;
  }
  
  public void setTs(Long paramLong)
  {
    this.ts = paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\LogEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */