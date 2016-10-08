package com.xiaoenai.app.classes.common.c;

import android.os.Bundle;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  implements b
{
  public g a(String paramString1, String paramString2)
  {
    if (ae.a(paramString1)) {
      return null;
    }
    Object localObject = new JSONObject();
    String str = a(paramString1);
    try
    {
      if (paramString1.contains("?"))
      {
        localObject = al.b(paramString1);
        if ((localObject == null) || (!((Bundle)localObject).containsKey("params"))) {
          break label101;
        }
      }
      label101:
      for (localObject = new JSONObject(((Bundle)localObject).getString("params"));; localObject = al.c(paramString1))
      {
        ((JSONObject)localObject).put("module_id", str);
        return new g.a().a(str).b(paramString2).c(((JSONObject)localObject).toString()).a();
      }
      return null;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public String a(String paramString)
  {
    if (ae.a(paramString)) {
      return null;
    }
    String str2 = g.a(paramString);
    String str1 = str2;
    if (str2.contains("?")) {
      str1 = str2.substring(0, str2.indexOf("?"));
    }
    a.c("============ _tmpModuleId: {} {}", new Object[] { str1, g.a(paramString) });
    return str1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */