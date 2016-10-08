package com.xiaoenai.app.f;

import android.os.Handler;
import com.d.a.a.d;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.c.a;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.net.af;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends d
{
  private long a;
  private String b;
  private int c;
  private String d;
  private String[] e;
  private a f;
  private Handler g;
  private int h = 0;
  
  public j(com.d.a.a.k paramk, long paramLong, int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, a parama)
  {
    super(paramk);
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramString2;
    this.e = paramArrayOfString;
    this.f = parama;
    this.g = new Handler();
  }
  
  private void a(long paramLong, String paramString1, String paramString2, ImageInfo[] paramArrayOfImageInfo)
  {
    ae localae = new ae(new o(this, Xiaoenai.j()));
    JSONArray localJSONArray = new JSONArray();
    if (paramArrayOfImageInfo != null)
    {
      int j = paramArrayOfImageInfo.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          ImageInfo localImageInfo = paramArrayOfImageInfo[i];
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("url", Xiaoenai.d(localImageInfo.get_url()));
            localJSONObject.put("height", localImageInfo.get_height());
            localJSONObject.put("width", localImageInfo.get_width());
            localJSONArray.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (this.c == a.a) {
      localae.a(paramLong, paramString2);
    }
    do
    {
      return;
      if (this.c == a.c)
      {
        localae.a(paramLong, paramString1, paramString2, localJSONArray);
        return;
      }
    } while (this.c != a.b);
    localae.b(paramLong, paramString1, paramString2, localJSONArray);
  }
  
  private void a(String paramString, m paramm)
  {
    new af(paramm).b(paramString);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    if (paramInt == this.e.length) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(Throwable paramThrowable)
  {
    return false;
  }
  
  public void b()
  {
    this.f.a();
  }
  
  public void c()
  {
    ImageInfo[] arrayOfImageInfo;
    String[] arrayOfString;
    int j;
    int i;
    if ((this.e != null) && (this.e.length > 0))
    {
      arrayOfImageInfo = new ImageInfo[this.e.length];
      arrayOfString = this.e;
      j = arrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      String str = arrayOfString[i];
      a(g.a().a(str), new k(this, Xiaoenai.j(), arrayOfImageInfo));
      i += 1;
      continue;
      a(this.a, this.b, this.d, null);
    }
  }
  
  protected void d() {}
  
  protected int g()
  {
    return 1;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(JSONObject paramJSONObject);
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */