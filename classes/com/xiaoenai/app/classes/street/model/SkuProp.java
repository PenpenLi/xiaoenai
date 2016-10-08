package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Name", b="name"), @com.xiaoenai.app.annotation.json.JsonElement(a="Values", b="values")})
public class SkuProp
  extends a
{
  private HashMap<String, List<String>> containsSkuKeyMap = new HashMap();
  private String id;
  private String name;
  private String[] values;
  
  public SkuProp() {}
  
  protected SkuProp(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.values = paramParcel.createStringArray();
  }
  
  public SkuProp(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    this.id = paramString2;
    this.name = paramString1;
    this.values = paramArrayOfString;
  }
  
  public SkuProp(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(SkuProp.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public List<String> getContainsSkuKeyMap(String paramString)
  {
    return (List)this.containsSkuKeyMap.get(paramString);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String[] getValues()
  {
    return this.values;
  }
  
  public void setContainsValuesMap(Sku[] paramArrayOfSku)
  {
    String[] arrayOfString = this.values;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      ArrayList localArrayList = new ArrayList();
      int m = paramArrayOfSku.length;
      int j = 0;
      while (j < m)
      {
        Sku localSku = paramArrayOfSku[j];
        if (localSku.getKey().contains(str)) {
          localArrayList.add(localSku.getKey());
        }
        j += 1;
      }
      this.containsSkuKeyMap.put(str, localArrayList);
      i += 1;
    }
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValues(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      String[] arrayOfString = new String[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        arrayOfString[i] = paramJSONArray.optString(i);
        i += 1;
      }
      this.values = arrayOfString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\SkuProp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */