package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="url", b="url"), @com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="width", b="width"), @com.xiaoenai.app.annotation.json.JsonElement(a="height", b="height")})
public class ImageInfo
  extends a
{
  private int height = 0;
  private int id = 0;
  private String url = "";
  private int width = 0;
  
  public ImageInfo() {}
  
  public ImageInfo(String paramString)
  {
    try
    {
      fromJson(ImageInfo.class, new JSONObject(paramString), this);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public ImageInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.url = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public ImageInfo(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(ImageInfo.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void fromJson(Class paramClass, JSONObject paramJSONObject, a parama)
  {
    super.fromJson(paramClass, paramJSONObject, parama);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */