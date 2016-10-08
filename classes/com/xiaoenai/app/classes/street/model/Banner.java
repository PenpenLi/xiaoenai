package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="ClickUrl", b="click_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="Module", b="module"), @com.xiaoenai.app.annotation.json.JsonElement(a="Title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="Image", b="image_url")})
public class Banner
  extends a
{
  private String click_url;
  private ImageInfo image;
  private String module;
  private String title;
  private String xea_url;
  
  public Banner() {}
  
  public Banner(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Banner.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getClickUrl()
  {
    return this.click_url;
  }
  
  public ImageInfo getImageInfo()
  {
    return this.image;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getXea_url()
  {
    return this.xea_url;
  }
  
  public void setClickUrl(String paramString)
  {
    this.click_url = paramString;
  }
  
  public void setImageInfo(JSONObject paramJSONObject)
  {
    this.image = new ImageInfo(paramJSONObject);
  }
  
  public void setModule(String paramString)
  {
    this.module = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setXea_url(String paramString)
  {
    this.xea_url = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Banner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */