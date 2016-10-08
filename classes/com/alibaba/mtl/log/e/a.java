package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static a a(String paramString)
  {
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("success"))
      {
        String str = paramString.getString("success");
        if ((!TextUtils.isEmpty(str)) && (str.equals("success"))) {
          locala.G = true;
        }
      }
      if (paramString.has("ret")) {
        locala.ae = paramString.getString("ret");
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return locala;
  }
  
  public static class a
  {
    public static a a = new a();
    public boolean G = false;
    public String ae = null;
    
    public boolean i()
    {
      return "E0102".equalsIgnoreCase(this.ae);
    }
    
    public boolean j()
    {
      return ("E0111".equalsIgnoreCase(this.ae)) || ("E0112".equalsIgnoreCase(this.ae));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */