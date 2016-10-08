package com.xiaoenai.app.model.game;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import com.xiaoenai.app.utils.ak;
import org.json.JSONException;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Message", b="message"), @com.xiaoenai.app.annotation.json.JsonElement(a="Module", b="module"), @com.xiaoenai.app.annotation.json.JsonElement(a="PushTime", b="push_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="Title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="NotifyId", b="notify_id")})
public class GamePushInfo
  extends a
{
  private String message;
  private String module;
  private int notifyId;
  private long pushTime;
  private String title;
  
  public GamePushInfo() {}
  
  public GamePushInfo(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(GamePushInfo.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public int getNotifyId()
  {
    return this.notifyId + 2000;
  }
  
  public long getPushTime()
  {
    return this.pushTime;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public Boolean isPast()
  {
    if (this.pushTime > ak.b()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setModule(String paramString)
  {
    this.module = paramString;
  }
  
  public void setNotifyId(int paramInt)
  {
    this.notifyId = paramInt;
  }
  
  public void setPushTime(long paramLong)
  {
    this.pushTime = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", this.message);
      localJSONObject.put("module", this.module);
      localJSONObject.put("push_time", this.pushTime);
      localJSONObject.put("title", this.title);
      localJSONObject.put("notify_id", this.notifyId);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\game\GamePushInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */