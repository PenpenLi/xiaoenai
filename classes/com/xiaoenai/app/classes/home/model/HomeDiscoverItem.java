package com.xiaoenai.app.classes.home.model;

import android.os.Bundle;
import com.google.gson.j;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="subTitle", b="info"), @com.xiaoenai.app.annotation.json.JsonElement(a="Module", b="module"), @com.xiaoenai.app.annotation.json.JsonElement(a="Title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="Params", b="params"), @com.xiaoenai.app.annotation.json.JsonElement(a="ClickUrl", b="click_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="Icon", b="icon"), @com.xiaoenai.app.annotation.json.JsonElement(a="is_show", b="is_show")})
public class HomeDiscoverItem
  extends HomeDiscoverBaseItem
{
  private String click_url;
  private ImageInfo icon;
  private int is_show = 1;
  private String module;
  private String params;
  private RedHintsInfo redHintsInfo;
  private String subTitle;
  private String title;
  
  public HomeDiscoverItem() {}
  
  public HomeDiscoverItem(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(HomeDiscoverItem.class, paramJSONObject, this);
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
  
  public ImageInfo getIcon()
  {
    return this.icon;
  }
  
  public int getIs_show()
  {
    return this.is_show;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public String getParams()
  {
    return this.params;
  }
  
  public RedHintsInfo getRedHintsInfo()
  {
    return this.redHintsInfo;
  }
  
  public String getSubTitle()
  {
    return this.subTitle;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setClickUrl(String paramString)
  {
    this.click_url = paramString;
    if ((!ae.a(paramString)) && (paramString.contains("?")))
    {
      paramString = al.b(paramString);
      if ((paramString != null) && (paramString.containsKey("params"))) {
        setParams(paramString.getString("params"));
      }
    }
  }
  
  public void setIcon(ImageInfo paramImageInfo)
  {
    this.icon = paramImageInfo;
  }
  
  public void setIcon(JSONObject paramJSONObject)
  {
    this.icon = ((ImageInfo)new j().a(paramJSONObject.toString(), ImageInfo.class));
  }
  
  public void setIs_show(int paramInt)
  {
    this.is_show = paramInt;
  }
  
  public void setModule(String paramString)
  {
    this.module = paramString;
  }
  
  public void setParams(String paramString)
  {
    this.params = paramString;
  }
  
  public void setParams(JSONObject paramJSONObject)
  {
    this.params = paramJSONObject.toString();
  }
  
  public void setRedHintsInfo(RedHintsInfo paramRedHintsInfo)
  {
    this.redHintsInfo = paramRedHintsInfo;
  }
  
  public void setSubTitle(String paramString)
  {
    this.subTitle = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\model\HomeDiscoverItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */