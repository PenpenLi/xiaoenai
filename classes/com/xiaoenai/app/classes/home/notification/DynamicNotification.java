package com.xiaoenai.app.classes.home.notification;

import com.google.gson.j;
import com.xiaoenai.app.utils.ae;

public class DynamicNotification
{
  private String content;
  private int count;
  private String group;
  private String module;
  private Object params;
  private int readStatus;
  private String title;
  private long updated_at;
  private String url;
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getGroup()
  {
    return this.group;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public String getParams()
  {
    if (this.params != null) {
      return new j().a(this.params);
    }
    return "";
  }
  
  public int getReadStatus()
  {
    return this.readStatus;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public long getUpdated_at()
  {
    return this.updated_at;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setGroup(String paramString)
  {
    this.group = paramString;
  }
  
  public void setModule(String paramString)
  {
    this.module = paramString;
  }
  
  public void setParams(String paramString)
  {
    if (!ae.a(paramString)) {
      this.params = new j().a(paramString, Object.class);
    }
  }
  
  public void setReadStatus(int paramInt)
  {
    this.readStatus = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUpdated_at(long paramLong)
  {
    this.updated_at = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\notification\DynamicNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */