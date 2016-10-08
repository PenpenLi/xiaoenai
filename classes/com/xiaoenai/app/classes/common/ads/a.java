package com.xiaoenai.app.classes.common.ads;

import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public int a = 1;
  private String b;
  private String c;
  private a[] d;
  private int e;
  private String f = null;
  private String g;
  private String h;
  private int i = 1;
  
  public a() {}
  
  public a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("type");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("ext_info");
    this.b = localJSONObject.toString();
    this.c = localJSONObject.optString("click_url");
    this.e = localJSONObject.optInt("replies_count");
    this.g = localJSONObject.optString("title");
    paramJSONObject = paramJSONObject.optJSONObject("author");
    if (paramJSONObject != null)
    {
      this.h = paramJSONObject.optString("avatar_url");
      this.f = paramJSONObject.optString("nickname");
    }
    paramJSONObject = localJSONObject.optJSONArray("image_urls");
    this.d = new a[paramJSONObject.length()];
    int j = 0;
    while (j < this.d.length)
    {
      this.d[j] = new a(paramJSONObject.optJSONObject(j));
      j += 1;
    }
  }
  
  public static ArrayList<a> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(j);
      if (((JSONObject)localObject).optInt("type") == 4) {}
      for (localObject = new a((JSONObject)localObject);; localObject = new d((JSONObject)localObject))
      {
        localArrayList.add(localObject);
        j += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  public static List<a> a(JSONObject paramJSONObject, String paramString)
  {
    localArrayList = new ArrayList();
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramString = paramJSONObject.getJSONArray(paramString);
        int j = 0;
        if (j < paramString.length())
        {
          paramJSONObject = paramString.optJSONObject(j);
          if (paramJSONObject.optInt("type") == 4) {}
          for (paramJSONObject = new a(paramJSONObject);; paramJSONObject = new Post(paramJSONObject))
          {
            localArrayList.add(paramJSONObject);
            j += 1;
            break;
          }
        }
        return localArrayList;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static ArrayList<a> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(j);
      if (((JSONObject)localObject).optInt("type") == 4) {
        localObject = new a((JSONObject)localObject);
      }
      for (;;)
      {
        localArrayList.add(localObject);
        j += 1;
        break;
        localObject = new d((JSONObject)localObject);
        ((a)localObject).a = 2;
      }
    }
    return localArrayList;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public a[] c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public class a
  {
    public int a;
    public int b;
    public String c;
    
    public a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.optInt("height");
      this.b = paramJSONObject.optInt("width");
      this.c = paramJSONObject.optString("url");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\ads\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */