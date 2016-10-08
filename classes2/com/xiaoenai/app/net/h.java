package com.xiaoenai.app.net;

import android.os.AsyncTask;
import com.sina.weibo.sdk.utils.MD5;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.a;
import com.xiaoenai.app.utils.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a
{
  public h(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.e + paramString;
    }
    return str;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(String paramString)
  {
    new a(null).execute(new String[] { paramString });
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    super.c(paramJSONObject);
    return paramJSONObject;
  }
  
  private class a
    extends AsyncTask<String, Void, JSONObject>
  {
    private a() {}
    
    protected JSONObject a(String... paramVarArgs)
    {
      try
      {
        File localFile1 = new File(paramVarArgs[0]);
        Object localObject = new File(e.a);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        File localFile2 = new File(e.a, MD5.hexdigest(localFile1.getName()));
        if (!localFile2.exists())
        {
          localFile2.createNewFile();
          com.xiaoenai.app.utils.k.d(paramVarArgs[0], localFile2.getAbsolutePath());
        }
        paramVarArgs = h.this.c(new JSONObject());
        localObject = new com.xiaoenai.app.net.c.a.k(h.b(h.this));
        ((com.xiaoenai.app.net.c.a.k)localObject).b(h.this.a("v2/image_upload_key"), paramVarArgs);
        paramVarArgs = ((com.xiaoenai.app.net.c.a.k)localObject).b();
        if (paramVarArgs.getInt("httpStatusCode") != 200) {
          return paramVarArgs;
        }
        localObject = paramVarArgs.getJSONObject("httpRetJson");
        paramVarArgs = new JSONObject();
        paramVarArgs.put("token", ((JSONObject)localObject).getString("upload_token"));
        localObject = new com.xiaoenai.app.net.c.a.k(h.c(h.this));
        ((com.xiaoenai.app.net.c.a.k)localObject).a(Xiaoenai.a(null), paramVarArgs, localFile2.getAbsolutePath());
        localObject = ((com.xiaoenai.app.net.c.a.k)localObject).b();
        paramVarArgs = (String[])localObject;
        if (((JSONObject)localObject).getInt("httpStatusCode") == 200)
        {
          if (!localFile2.getAbsolutePath().equals(localFile1.getAbsolutePath())) {
            localFile2.delete();
          }
          h.this.a(((JSONObject)localObject).getJSONObject("httpRetJson"));
          return (JSONObject)localObject;
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
      if (paramJSONObject != null) {
        try
        {
          int i = paramJSONObject.getInt("httpStatusCode");
          paramJSONObject = paramJSONObject.getJSONObject("httpRetJson");
          if (i == 200)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("url", paramJSONObject.getString("key"));
            localJSONObject.put("width", paramJSONObject.getInt("width"));
            localJSONObject.put("height", paramJSONObject.getInt("height"));
            if (h.d(h.this) != null) {
              h.e(h.this).a(localJSONObject);
            }
            h.this.b(paramJSONObject);
            return;
          }
          h.a(h.this, paramJSONObject);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          if (h.f(h.this) != null) {
            h.g(h.this).a(0);
          }
          paramJSONObject.printStackTrace();
          return;
        }
      }
      if (h.h(h.this) != null) {
        h.i(h.this).a(0);
      }
    }
    
    protected void onPreExecute()
    {
      h.a(h.this).a();
      super.onPreExecute();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */