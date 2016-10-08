package com.taobao.applink.param;

import android.util.Log;
import com.taobao.applink.api.TBAPIType;
import com.taobao.applink.util.TBAppLinkStringUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class TBNavParam
  extends TBBaseParam
{
  public static final String ACTION_NAME = "ali.open.nav";
  
  protected TBNavParam()
  {
    super(TBAPIType.JUMP);
    this.mParams.put("action", "ali.open.nav");
  }
  
  private void setExtraParams(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      try
      {
        String str1 = URLEncoder.encode((String)localIterator.next(), "UTF-8");
        String str2 = URLEncoder.encode(paramJSONObject.getString(str1), "UTF-8");
        this.mExtraParams.put(str1, str2);
      }
      catch (Throwable localThrowable)
      {
        Log.d("AppLink", localThrowable.toString());
      }
    }
  }
  
  public boolean checkParams(JSONObject paramJSONObject)
  {
    return false;
  }
  
  public String getH5URL()
  {
    return super.getH5URL(null);
  }
  
  public void setParams(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str3;
        try
        {
          String str1 = URLEncoder.encode((String)localIterator.next(), "UTF-8");
          str3 = URLEncoder.encode(paramJSONObject.getString(str1), "UTF-8");
          if (TBAppLinkStringUtil.isBlank(str3)) {
            continue;
          }
          if (!"e".equals(str1)) {
            break label87;
          }
          setE(str3);
        }
        catch (Throwable localThrowable)
        {
          Log.d("AppLink", localThrowable.toString());
        }
        continue;
        label87:
        if ("type".equals(localThrowable))
        {
          setType(str3);
        }
        else if ("pid".equals(localThrowable))
        {
          this.mExtraParams.put("pid", str3);
        }
        else
        {
          String str2;
          if ("params".equals(localThrowable))
          {
            str2 = paramJSONObject.getString("params");
            if (!TBAppLinkStringUtil.isBlank(str2)) {
              setExtraParams(new JSONObject(str2));
            }
          }
          else
          {
            this.mParams.put(str2, str3);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBNavParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */