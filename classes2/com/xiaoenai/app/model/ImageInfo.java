package com.xiaoenai.app.model;

import org.json.JSONObject;

public class ImageInfo
{
  private Integer height = null;
  private String url = null;
  private int viewHeight = 0;
  private int viewWidth = 0;
  private Integer width = null;
  
  public ImageInfo(String paramString, Integer paramInteger1, Integer paramInteger2)
  {
    this.url = paramString;
    this.height = paramInteger1;
    this.width = paramInteger2;
  }
  
  public ImageInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.url = paramJSONObject.optString("url", "");
      this.height = Integer.valueOf(paramJSONObject.optInt("height", 0));
      this.width = Integer.valueOf(paramJSONObject.optInt("width", 0));
      return;
    }
    this.url = "";
    this.height = Integer.valueOf(0);
    this.width = Integer.valueOf(0);
  }
  
  public String getCommonUrl()
  {
    if ((this.url != null) && (this.url.contains("?"))) {
      return this.url;
    }
    if ((this.viewWidth > 0) && (this.viewHeight > 0)) {
      return this.url + "?imageView/1/w/" + this.viewWidth + "/h/" + this.viewHeight;
    }
    if ((this.width.intValue() > 0) && (this.height.intValue() > 0)) {
      return this.url + "?imageView/1/w/" + this.width + "/h/" + this.height;
    }
    return this.url;
  }
  
  public Integer get_height()
  {
    return this.height;
  }
  
  public String get_url()
  {
    return this.url;
  }
  
  public Integer get_width()
  {
    return this.width;
  }
  
  public void setViewScale(int paramInt1, int paramInt2)
  {
    this.viewWidth = paramInt1;
    this.viewHeight = paramInt2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */