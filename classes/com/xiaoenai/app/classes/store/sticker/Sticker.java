package com.xiaoenai.app.classes.store.sticker;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="url", b="url"), @com.xiaoenai.app.annotation.json.JsonElement(a="rank", b="rank")})
public class Sticker
  extends a
{
  private int id;
  private int rank;
  private String url;
  
  public void fromJson(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Sticker.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getRank()
  {
    return this.rank;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setRank(int paramInt)
  {
    this.rank = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\Sticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */