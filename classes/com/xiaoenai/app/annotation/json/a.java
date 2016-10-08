package com.xiaoenai.app.annotation.json;

import org.json.JSONObject;

public abstract class a
{
  private b jsonParserAdapter = new b();
  
  public void fromJson(Class paramClass, JSONObject paramJSONObject, a parama)
  {
    this.jsonParserAdapter.a(paramClass, paramJSONObject, parama);
  }
  
  public JSONObject toJson(a parama, Class paramClass)
  {
    return this.jsonParserAdapter.a(parama, paramClass);
  }
  
  public JSONObject toJson(a parama, Class paramClass, JSONObject paramJSONObject)
  {
    this.jsonParserAdapter.a(parama, paramClass, paramJSONObject);
    return paramJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\annotation\json\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */