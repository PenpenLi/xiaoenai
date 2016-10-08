package com.xiaoenai.app.f;

import android.os.Handler;
import com.d.a.a.k;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.Forum.Post.a;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.h;
import com.xiaoenai.app.net.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends com.d.a.a.d
{
  private String a;
  private String b;
  private String[] c;
  private a d;
  private Handler e;
  private int f = 0;
  private boolean g = true;
  
  public d(k paramk, String paramString1, String paramString2, String[] paramArrayOfString, a parama, boolean paramBoolean)
  {
    super(paramk);
    this.c = paramArrayOfString;
    this.a = paramString1;
    this.b = paramString2;
    this.d = parama;
    this.e = new Handler();
    this.g = paramBoolean;
  }
  
  private void a(String paramString, m paramm)
  {
    new h(paramm).b(paramString);
  }
  
  private void a(String paramString1, String paramString2, Post.a[] paramArrayOfa)
  {
    int i = 0;
    com.xiaoenai.app.net.g localg = new com.xiaoenai.app.net.g(new i(this, Xiaoenai.j()));
    Object localObject;
    JSONArray localJSONArray;
    if (paramArrayOfa != null)
    {
      localObject = new JSONObject();
      localJSONArray = new JSONArray();
      int j = paramArrayOfa.length;
      for (;;)
      {
        if (i < j)
        {
          Post.a locala = paramArrayOfa[i];
          JSONObject localJSONObject = new JSONObject();
          try
          {
            com.xiaoenai.app.utils.f.a.c("========================== data obj: {}", new Object[] { locala });
            localJSONObject.put("url", Xiaoenai.c(locala.c()));
            localJSONObject.put("height", locala.a());
            localJSONObject.put("width", locala.b());
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
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("image_urls", localJSONArray);
        paramArrayOfa = (Post.a[])localObject;
      }
      catch (JSONException paramArrayOfa)
      {
        paramArrayOfa.printStackTrace();
        paramArrayOfa = (Post.a[])localObject;
        continue;
        i = -1;
        continue;
      }
      localObject = paramString2;
      if (paramString2 != null) {
        localObject = io.github.rockerhieu.emojicon.a.a(Xiaoenai.j(), paramString2);
      }
      if (this.g)
      {
        i = f.d().g;
        localg.a(paramString1, (String)localObject, paramArrayOfa, i);
        return;
      }
      paramArrayOfa = null;
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    if (paramInt == this.c.length) {
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
    this.d.a();
  }
  
  public void c()
  {
    int i = 0;
    com.xiaoenai.app.utils.f.a.c("============== {}", new Object[] { Integer.valueOf(this.c.length) });
    Post.a[] arrayOfa;
    String[] arrayOfString;
    int j;
    if ((this.c != null) && (this.c.length > 0))
    {
      arrayOfa = new Post.a[this.c.length];
      arrayOfString = this.c;
      j = arrayOfString.length;
    }
    while (i < j)
    {
      String str = arrayOfString[i];
      a(com.xiaoenai.app.utils.g.a().a(str), new e(this, Xiaoenai.j(), arrayOfa));
      i += 1;
      continue;
      a(this.a, this.b, null);
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
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */