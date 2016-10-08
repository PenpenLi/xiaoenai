package com.inmobi.rendering.mraid;

import android.os.AsyncTask;
import android.os.Environment;
import android.webkit.URLUtil;
import com.inmobi.ads.b.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends AsyncTask<Void, Void, String>
{
  private static final String a = c.class.getSimpleName();
  private int b;
  private File c;
  private String d;
  private String e;
  private String f;
  private WeakReference<RenderView> g;
  private a h;
  private List<String> i;
  private long j;
  private String k;
  
  public c(String paramString1, File paramFile, String paramString2, String paramString3, RenderView paramRenderView)
  {
    this.k = paramString1;
    this.c = paramFile;
    this.d = paramString2;
    this.e = paramString3;
    this.i = paramRenderView.getRenderingConfig().h();
    this.j = paramRenderView.getRenderingConfig().g();
    this.g = new WeakReference(paramRenderView);
  }
  
  public String a()
  {
    return this.e;
  }
  
  protected String a(Void... paramVarArgs)
  {
    if (!com.inmobi.commons.core.utilities.c.a())
    {
      this.b = 8;
      return "fail";
    }
    if ((!this.e.matches("[A-Za-z0-9]+")) || (this.e.equals("")))
    {
      this.b = 2;
      return "fail";
    }
    if ((this.d.equals("")) || (!URLUtil.isValidUrl(this.d)))
    {
      this.b = 3;
      return "fail";
    }
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      this.b = 10;
      return "fail";
    }
    Object localObject1 = (String[])this.i.toArray(new String[this.i.size()]);
    for (;;)
    {
      try
      {
        long l2 = System.currentTimeMillis();
        paramVarArgs = (HttpURLConnection)new URL(this.d).openConnection();
        paramVarArgs.setRequestMethod("GET");
        paramVarArgs.setConnectTimeout(5000);
        m = paramVarArgs.getResponseCode();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Response code: " + m);
        if (m < 400)
        {
          localObject2 = paramVarArgs.getContentType();
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Content Type: " + (String)localObject2);
          m = 0;
          if (m >= localObject1.length) {
            break label822;
          }
          String str = localObject1[m];
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Allowed Type: " + str);
          if ((localObject2 == null) || (!str.toLowerCase(Locale.ENGLISH).equals(((String)localObject2).toLowerCase(Locale.ENGLISH)))) {
            break label828;
          }
          m = 1;
          if (m == 0)
          {
            this.b = 6;
            return "fail";
          }
        }
        l1 = paramVarArgs.getContentLength();
        if (l1 >= 0L)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "ContentSize: " + l1 + " max size: " + this.j);
          if (l1 > this.j)
          {
            this.b = 7;
            return "fail";
          }
        }
        paramVarArgs.connect();
        localObject1 = new FileOutputStream(this.c);
        paramVarArgs = paramVarArgs.getInputStream();
        localObject2 = new byte['Ѐ'];
        l1 = 0L;
        m = paramVarArgs.read((byte[])localObject2);
        if ((m > 0) && (!isCancelled())) {
          continue;
        }
        ((FileOutputStream)localObject1).close();
        l1 = System.currentTimeMillis();
        if (isCancelled()) {
          continue;
        }
        paramVarArgs = "file://" + this.c.getAbsolutePath();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "file path of video: " + paramVarArgs);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("url", this.d);
        ((JSONObject)localObject1).put("saved_url", paramVarArgs);
        ((JSONObject)localObject1).put("size_in_bytes", this.c.length());
        ((JSONObject)localObject1).put("download_started_at", l2);
        ((JSONObject)localObject1).put("download_ended_at", l1);
        this.f = ((JSONObject)localObject1).toString().replace("\"", "\\\"");
      }
      catch (SocketTimeoutException paramVarArgs)
      {
        Object localObject2;
        long l1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "SocketTimeoutException");
        this.b = 4;
        return "fail";
        boolean bool = this.c.delete();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "cancelSaveContent called.File: " + this.c.getAbsolutePath() + " deleted: " + bool);
        continue;
      }
      catch (FileNotFoundException paramVarArgs)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "FileNotFoundException");
        this.b = 4;
        return "fail";
      }
      catch (MalformedURLException paramVarArgs)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "MalformedURLException");
        this.b = 3;
        return "fail";
      }
      catch (ProtocolException paramVarArgs)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "ProtocolException");
        this.b = 8;
        return "fail";
      }
      catch (IOException paramVarArgs)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "IOException");
        this.b = 8;
        return "fail";
      }
      catch (JSONException paramVarArgs)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "JSONException");
        this.b = 0;
        return "fail";
      }
      return "success";
      l1 += m;
      if (l1 > this.j)
      {
        this.b = 7;
        return "fail";
      }
      ((FileOutputStream)localObject1).write((byte[])localObject2, 0, m);
      continue;
      label822:
      int m = 0;
      continue;
      label828:
      m += 1;
    }
  }
  
  protected void a(String paramString)
  {
    if (paramString.equals("success"))
    {
      if (this.g.get() != null) {
        ((RenderView)this.g.get()).a(this.k, "sendSaveContentResult(\"saveContent_" + this.e + "\", 'success', \"" + this.f + "\");");
      }
      if (this.h != null) {
        this.h.a();
      }
    }
    for (;;)
    {
      super.onPostExecute(paramString);
      return;
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("url", this.d);
        ((JSONObject)localObject).put("reason", this.b);
        localObject = ((JSONObject)localObject).toString().replace("\"", "\\\"");
        if (this.g.get() != null) {
          ((RenderView)this.g.get()).a(this.k, "sendSaveContentResult(\"saveContent_" + this.e + "\", 'failed', \"" + (String)localObject + "\");");
        }
        if (this.h == null) {
          continue;
        }
        this.h.a(this.b);
      }
      catch (JSONException localJSONException) {}
      if (this.g.get() != null) {
        ((RenderView)this.g.get()).a(this.k, "sendSaveContentResult(\"saveContent_" + this.e + "\", 'failed', \"JSONException\");");
      }
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */