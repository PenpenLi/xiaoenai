package com.inmobi.commons.core.configs;

import java.util.HashMap;
import org.json.JSONObject;

public abstract class a
{
  private a a = new a();
  
  public abstract String a();
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("includeIds");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      a.a(this.a).put("O1", Boolean.valueOf(paramJSONObject.getBoolean("O1")));
      a.a(this.a).put("SID", Boolean.valueOf(paramJSONObject.getBoolean("SID")));
      a.a(this.a).put("LID", Boolean.valueOf(paramJSONObject.getBoolean("LID")));
      a.a(this.a).put("UM5", Boolean.valueOf(paramJSONObject.getBoolean("UM5")));
      a.a(this.a).put("GPID", Boolean.valueOf(paramJSONObject.getBoolean("GPID")));
      a.a(this.a).put("IMID", Boolean.valueOf(paramJSONObject.getBoolean("IMID")));
      a.a(this.a).put("AIDL", Boolean.valueOf(paramJSONObject.getBoolean("AIDL")));
      i += 1;
    }
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("O1", a.a(this.a).get("O1"));
    localJSONObject2.put("SID", a.a(this.a).get("SID"));
    localJSONObject2.put("LID", a.a(this.a).get("LID"));
    localJSONObject2.put("UM5", a.a(this.a).get("UM5"));
    localJSONObject2.put("GPID", a.a(this.a).get("GPID"));
    localJSONObject2.put("IMID", a.a(this.a).get("IMID"));
    localJSONObject2.put("AIDL", a.a(this.a).get("AIDL"));
    localJSONObject1.put("includeIds", localJSONObject2);
    return localJSONObject1;
  }
  
  public abstract boolean c();
  
  public abstract a d();
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    while (!a().equals(((a)paramObject).a())) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public a o()
  {
    return this.a;
  }
  
  public static final class a
  {
    private HashMap<String, Boolean> a = new HashMap();
    
    public a()
    {
      this.a.put("O1", Boolean.valueOf(true));
      this.a.put("SID", Boolean.valueOf(true));
      this.a.put("LID", Boolean.valueOf(true));
      this.a.put("UM5", Boolean.valueOf(true));
      this.a.put("GPID", Boolean.valueOf(true));
      this.a.put("IMID", Boolean.valueOf(true));
      this.a.put("AIDL", Boolean.valueOf(true));
    }
    
    public HashMap<String, Boolean> a()
    {
      return this.a;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */