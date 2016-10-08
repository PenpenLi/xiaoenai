package com.xiaoenai.app.model.status;

import com.xiaoenai.app.utils.as;

public class Status
{
  public static final String STATUS_TYPE_DIY = "030";
  private static final long serialVersionUID = 1L;
  private String content;
  private long createAt;
  private int id;
  private String type = "030";
  
  public Status() {}
  
  public Status(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.content = paramString;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public long getCreateAt()
  {
    return this.createAt;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getShortContent()
  {
    if (this.type.equals("025")) {
      return as.a(2131100034);
    }
    if (this.type.equals("010")) {
      return as.a(2131100032);
    }
    return this.content;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCreateAt(long paramLong)
  {
    this.createAt = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public String toString()
  {
    return this.content;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\status\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */