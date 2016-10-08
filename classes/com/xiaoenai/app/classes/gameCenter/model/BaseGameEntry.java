package com.xiaoenai.app.classes.gameCenter.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONException;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="appKey", b="appkey"), @com.xiaoenai.app.annotation.json.JsonElement(a="desUrl", b="desc_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="ext_info", b="ext_info")})
public class BaseGameEntry
  extends a
{
  private String appKey;
  private String desUrl;
  private int height;
  private int id;
  private String name;
  private String url;
  private int width;
  
  public void ext_infoJsonTransformer(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      setUrl(paramString.optString("url"));
      setWidth(paramString.optInt("width"));
      setHeight(paramString.optInt("height"));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void ext_infoJsonTransformer(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(BaseGameEntry.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public String getDesUrl()
  {
    return this.desUrl;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setDesUrl(String paramString)
  {
    this.desUrl = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\model\BaseGameEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */