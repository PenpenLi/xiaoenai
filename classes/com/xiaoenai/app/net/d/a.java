package com.xiaoenai.app.net.d;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

public class a
  extends com.xiaoenai.app.net.c.a.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public a(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    if (paramString != null) {
      return Xiaoenai.i + paramString;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("limit", paramInt2);
      if (paramInt1 > 0) {
        localJSONObject.put("message_ts", paramInt1);
      }
      b("v2/im_history/get_prev", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("message_ts", paramInt);
      localJSONObject.put("direction", paramString);
      a("v2/im_history/get", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void a(Integer[] paramArrayOfInteger, Long... paramVarArgs)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localJSONObject = new JSONObject();
        localStringBuilder = new StringBuilder();
        if (paramVarArgs.length <= 1) {
          break label146;
        }
        i = 0;
        if (i < paramVarArgs.length) {
          if (i == paramVarArgs.length - 1)
          {
            localStringBuilder.append(paramVarArgs[i]);
            localStringBuilder.append(":");
            localStringBuilder.append(paramArrayOfInteger[i]);
          }
          else
          {
            localStringBuilder.append(paramVarArgs[i]);
            localStringBuilder.append(":");
            localStringBuilder.append(paramArrayOfInteger[i]);
            localStringBuilder.append(",");
          }
        }
      }
      catch (Exception paramArrayOfInteger)
      {
        paramArrayOfInteger.printStackTrace();
        this.a.a(0);
        return;
      }
      localJSONObject.put("ids", localStringBuilder.toString());
      for (;;)
      {
        a("v2/im_history/del", localJSONObject);
        return;
        label146:
        if (paramVarArgs.length < 1) {
          localJSONObject.put("ids", 0L);
        } else {
          localJSONObject.put("ids", paramVarArgs[0] + ":" + paramArrayOfInteger[0]);
        }
      }
      i += 1;
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */