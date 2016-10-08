package com.xiaoenai.app.data.entity.album;

import com.xiaoenai.app.utils.e.a.d;

public class CompressPhoto
{
  private String baseUrl;
  private int height;
  private boolean isOrigin;
  private String originPath;
  private String path;
  private long size;
  private String url;
  private int width;
  
  public String getBaseUrl()
  {
    return this.baseUrl;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getOriginPath()
  {
    return this.originPath;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public long getSize()
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
  
  public boolean isOrigin()
  {
    return this.isOrigin;
  }
  
  public void setBaseUrl(String paramString)
  {
    this.baseUrl = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setOrigin(boolean paramBoolean)
  {
    this.isOrigin = paramBoolean;
  }
  
  public void setOriginPath(String paramString)
  {
    this.originPath = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void transform(d paramd)
  {
    setWidth(paramd.a());
    setHeight(paramd.b());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\album\CompressPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */