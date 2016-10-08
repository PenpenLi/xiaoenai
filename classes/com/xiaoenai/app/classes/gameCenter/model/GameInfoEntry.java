package com.xiaoenai.app.classes.gameCenter.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="app_developer", b="app_developer"), @com.xiaoenai.app.annotation.json.JsonElement(a="app_type", b="app_type"), @com.xiaoenai.app.annotation.json.JsonElement(a="app_size", b="app_size"), @com.xiaoenai.app.annotation.json.JsonElement(a="app_version", b="app_version"), @com.xiaoenai.app.annotation.json.JsonElement(a="desc", b="desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="desc_icon_url", b="desc_icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="download_url", b="download_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="packageName", b="package"), @com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="icon_url", b="icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="last_modify_at", b="last_modify_at"), @com.xiaoenai.app.annotation.json.JsonElement(a="play_count", b="play_count"), @com.xiaoenai.app.annotation.json.JsonElement(a="login_url", b="login_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="start_type", b="start_type")})
public class GameInfoEntry
  extends BaseGameEntry
{
  private String app_developer;
  private String app_size;
  private String app_type;
  private String app_version;
  private String desc;
  private ImageInfo[] desc_icon_url;
  private String download_url;
  private String icon_url;
  private long last_modify_at;
  private String login_url;
  private String packageName;
  private int play_count;
  private int start_type;
  
  public void desc_icon_urlJsonTransformer(JSONArray paramJSONArray)
  {
    setDesc_icon_url(paramJSONArray);
  }
  
  public void fromJson(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(GameInfoEntry.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getApp_developer()
  {
    return this.app_developer;
  }
  
  public String getApp_size()
  {
    return this.app_size;
  }
  
  public String getApp_type()
  {
    return this.app_type;
  }
  
  public String getApp_version()
  {
    return this.app_version;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public ImageInfo[] getDesc_icon_url()
  {
    return this.desc_icon_url;
  }
  
  public String getDownload_url()
  {
    return this.download_url;
  }
  
  public String getIcon_url()
  {
    return this.icon_url;
  }
  
  public long getLast_modify_at()
  {
    return this.last_modify_at;
  }
  
  public String getLogin_url()
  {
    return this.login_url;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public int getPlay_count()
  {
    return this.play_count;
  }
  
  public int getStart_type()
  {
    return this.start_type;
  }
  
  public void setApp_developer(String paramString)
  {
    this.app_developer = paramString;
  }
  
  public void setApp_size(String paramString)
  {
    this.app_size = paramString;
  }
  
  public void setApp_type(String paramString)
  {
    this.app_type = paramString;
  }
  
  public void setApp_version(String paramString)
  {
    this.app_version = paramString;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setDesc_icon_url(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      this.desc_icon_url = new ImageInfo[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        this.desc_icon_url[i] = new ImageInfo(paramJSONArray.optJSONObject(i));
        i += 1;
      }
    }
  }
  
  public void setDownload_url(String paramString)
  {
    this.download_url = paramString;
  }
  
  public void setIcon_url(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setLast_modify_at(long paramLong)
  {
    this.last_modify_at = paramLong;
  }
  
  public void setLogin_url(String paramString)
  {
    this.login_url = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setPlay_count(int paramInt)
  {
    this.play_count = paramInt;
  }
  
  public void setStart_type(int paramInt)
  {
    this.start_type = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\model\GameInfoEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */