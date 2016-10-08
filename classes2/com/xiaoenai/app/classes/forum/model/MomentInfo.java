package com.xiaoenai.app.classes.forum.model;

import com.xiaoenai.app.model.ImageInfo;

public class MomentInfo
{
  private String content;
  private int end_ts;
  private int id;
  private ImageInfo image_info;
  private int start_ts;
  private int status;
  private String title;
  private String url;
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getEnd_ts()
  {
    return this.end_ts;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ImageInfo getImage_info()
  {
    return this.image_info;
  }
  
  public int getStart_ts()
  {
    return this.start_ts;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setEnd_ts(int paramInt)
  {
    this.end_ts = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImage_info(ImageInfo paramImageInfo)
  {
    this.image_info = paramImageInfo;
  }
  
  public void setStart_ts(int paramInt)
  {
    this.start_ts = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\model\MomentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */