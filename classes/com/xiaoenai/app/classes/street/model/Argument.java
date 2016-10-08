package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="Value", b="value")})
public class Argument
  extends a
{
  private String title;
  private String value;
  
  public Argument() {}
  
  public Argument(String paramString1, String paramString2)
  {
    this.title = paramString1;
    this.value = paramString2;
  }
  
  public Argument(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Argument.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Argument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */