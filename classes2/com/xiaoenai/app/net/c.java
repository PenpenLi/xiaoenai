package com.xiaoenai.app.net;

import android.os.AsyncTask;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.a;
import com.xiaoenai.app.net.c.a.k;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends a
{
  public c(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.a + paramString;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(String paramString)
  {
    new a(null).execute(new String[] { paramString });
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  private class a
    extends AsyncTask<String, Void, JSONObject>
  {
    private a() {}
    
    protected JSONObject a(String... paramVarArgs)
    {
      try
      {
        JSONObject localJSONObject = c.this.c(new JSONObject());
        Object localObject = new k(c.b(c.this));
        ((k)localObject).a(c.this.a("v2/upload/voice_token"), localJSONObject);
        localJSONObject = ((k)localObject).b();
        if (localJSONObject.getInt("httpStatusCode") != 200) {
          return localJSONObject;
        }
        localObject = localJSONObject.getJSONObject("httpRetJson");
        localJSONObject = new JSONObject();
        localJSONObject.put("token", ((JSONObject)localObject).getString("upload_token"));
        localObject = new k(c.c(c.this));
        ((k)localObject).a(Xiaoenai.a(null), localJSONObject, paramVarArgs[0]);
        localJSONObject = ((k)localObject).b();
        paramVarArgs = localJSONObject;
        if (localJSONObject.getInt("httpStatusCode") == 200)
        {
          c.this.a(localJSONObject.getJSONObject("httpRetJson"));
          return localJSONObject;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        paramVarArgs = null;
      }
      return paramVarArgs;
    }
    
    protected void a(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null) {}
      for (;;)
      {
        try
        {
          int i = paramJSONObject.getInt("httpStatusCode");
          localJSONObject1 = paramJSONObject.getJSONObject("httpRetJson");
          if (i != 200) {
            continue;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("url", localJSONObject1.getString("base_url") + localJSONObject1.getString("key"));
          localJSONObject2.put("key", localJSONObject1.getString("key"));
          c.this.b(localJSONObject1);
          c.d(c.this).a(localJSONObject2);
        }
        catch (JSONException localJSONException)
        {
          JSONObject localJSONObject1;
          c.e(c.this).a(0);
          Xiaoenai.j().n();
          localJSONException.printStackTrace();
          continue;
        }
        super.onPostExecute(paramJSONObject);
        return;
        c.a(c.this, localJSONObject1);
        Xiaoenai.j().n();
        continue;
        c.f(c.this).a(0);
        Xiaoenai.j().n();
      }
    }
    
    protected void onPreExecute()
    {
      c.a(c.this).a();
      super.onPreExecute();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */