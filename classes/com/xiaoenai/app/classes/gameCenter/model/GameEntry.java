package com.xiaoenai.app.classes.gameCenter.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.model.RedHintsInfo;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="appKey", b="appkey"), @com.xiaoenai.app.annotation.json.JsonElement(a="intro", b="intro"), @com.xiaoenai.app.annotation.json.JsonElement(a="icon_url", b="icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="mPackage", b="package"), @com.xiaoenai.app.annotation.json.JsonElement(a="startType", b="start_type"), @com.xiaoenai.app.annotation.json.JsonElement(a="loginUrl", b="login_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="downloadUrl", b="download_url")})
public class GameEntry
  extends BaseGameEntry
{
  public static final int GAME_HTML = 1;
  public static final int GAME_NATIVE = 0;
  private String downloadUrl;
  private int download_state = -1;
  private String icon_url;
  private String intro;
  private String loginUrl;
  private String mPackage;
  private RedHintsInfo redHintsInfo;
  private int startType;
  
  public void fromJson(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(GameEntry.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }
  
  public int getDownload_state()
  {
    return this.download_state;
  }
  
  public String getIcon_url()
  {
    return this.icon_url;
  }
  
  public String getIntro()
  {
    return this.intro;
  }
  
  public String getLoginUrl()
  {
    return this.loginUrl;
  }
  
  public String getMpackage()
  {
    return this.mPackage;
  }
  
  public RedHintsInfo getRedHintsInfo()
  {
    return this.redHintsInfo;
  }
  
  public int getStartType()
  {
    return this.startType;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public void setDownload_state(int paramInt)
  {
    this.download_state = paramInt;
  }
  
  public void setIcon_url(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setIntro(String paramString)
  {
    this.intro = paramString;
  }
  
  public void setLoginUrl(String paramString)
  {
    this.loginUrl = paramString;
  }
  
  public void setMpackage(String paramString)
  {
    this.mPackage = paramString;
  }
  
  public void setRedHintsInfo(RedHintsInfo paramRedHintsInfo)
  {
    this.redHintsInfo = paramRedHintsInfo;
  }
  
  public void setStartType(int paramInt)
  {
    this.startType = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\model\GameEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */