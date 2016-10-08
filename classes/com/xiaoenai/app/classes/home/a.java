package com.xiaoenai.app.classes.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.c.d;
import com.xiaoenai.app.classes.common.c.e;
import com.xiaoenai.app.classes.common.c.g;
import com.xiaoenai.app.classes.common.c.i;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.d.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  private static HashMap<String, Object> a;
  private static HashMap<String, b> b;
  private static a c;
  private a[] d;
  
  public static a a()
  {
    if (c == null) {}
    try
    {
      if (c == null)
      {
        a = new HashMap();
        b = new HashMap();
        c = new a();
      }
      return c;
    }
    finally {}
  }
  
  private void a(a[] paramArrayOfa)
  {
    int i = 0;
    if ((paramArrayOfa != null) && (paramArrayOfa.length > 0) && (paramArrayOfa[0] != null) && (paramArrayOfa[0].f != null))
    {
      paramArrayOfa = paramArrayOfa[0].f;
      int j = paramArrayOfa.length;
      while (i < j)
      {
        a locala = paramArrayOfa[i];
        if (locala.c != null) {
          com.xiaoenai.app.utils.e.b.c(locala.c);
        }
        i += 1;
      }
    }
  }
  
  private a[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray("ads");
      this.d = new a[paramJSONObject.length()];
      int i = 0;
      while (i < paramJSONObject.length())
      {
        this.d[i] = new a();
        Object localObject1 = paramJSONObject.optJSONObject(i);
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("image_urls");
        int j = ((JSONObject)localObject1).optInt("duration_time");
        boolean bool1 = ((JSONObject)localObject1).optBoolean("can_skip");
        int k = ((JSONObject)localObject1).optInt("skip_place");
        long l1 = ((JSONObject)localObject1).optLong("group_id");
        long l2 = ((JSONObject)localObject1).optLong("creative_id");
        boolean bool2 = ((JSONObject)localObject1).optBoolean("is_default_ad");
        Object localObject2 = ((JSONObject)localObject1).optString("report_url");
        String str = ((JSONObject)localObject1).optString("click_url");
        int m = ((JSONObject)localObject1).optInt("duration_count", 0);
        int n = ((JSONObject)localObject1).optInt("member_id", 0);
        this.d[i].d = j;
        this.d[i].a = bool1;
        this.d[i].i = k;
        this.d[i].e = l1;
        this.d[i].c = l2;
        this.d[i].g = bool2;
        this.d[i].h = ((String)localObject2);
        this.d[i].f = new c[localJSONArray.length()];
        this.d[i].b = str;
        this.d[i].k = m;
        this.d[i].l = n;
        if ((i == 0) && (AppModel.getInstance().isLogined()))
        {
          localObject1 = UserConfig.getString("launcher_ads_display_key", "");
          localObject2 = String.format(Locale.getDefault(), "%d%d%d", new Object[] { Long.valueOf(this.d[0].e), Long.valueOf(this.d[0].c), Integer.valueOf(this.d[0].l) });
          com.xiaoenai.app.utils.f.a.c("flag = {}", new Object[] { localObject2 });
          localObject2 = com.xiaoenai.app.utils.d.m.a((String)localObject2);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localObject2)))
          {
            UserConfig.setString("launcher_ads_display_key", (String)localObject2);
            UserConfig.setInt("launcher_ads_display_count", m);
          }
        }
        j = 0;
        while (j < localJSONArray.length())
        {
          localObject2 = localJSONArray.optJSONObject(j);
          localObject1 = ((JSONObject)localObject2).optString("url");
          k = ((JSONObject)localObject2).optInt("height");
          m = ((JSONObject)localObject2).optInt("width");
          localObject2 = new c();
          ((c)localObject2).b = m;
          ((c)localObject2).a = k;
          ((c)localObject2).c = ((String)localObject1);
          this.d[i].f[j] = localObject2;
          j += 1;
        }
        i += 1;
      }
    }
    return this.d;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    File localFile = f.a(Xiaoenai.j(), "launcher_ads_data_file");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      f.a(paramJSONObject, localFile);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private a[] d()
  {
    if (this.d == null) {
      this.d = a(f.a(f.a(Xiaoenai.j(), "launcher_ads_data_file")));
    }
    return this.d;
  }
  
  public b a(String paramString)
  {
    return (b)b.get(paramString);
  }
  
  public void a(Context paramContext)
  {
    new com.xiaoenai.app.net.a(new c(this, paramContext, paramContext)).a("10020001", 0, 1);
  }
  
  public void a(Context paramContext, String paramString, com.xiaoenai.app.net.m paramm)
  {
    paramm = new com.xiaoenai.app.net.a(new b(this, paramContext, paramString, paramm));
    paramContext = "10020002";
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      paramm.a(paramContext, 0, 1);
      return;
      if (!paramString.equals("index")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("discover")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("noti")) {
        break;
      }
      i = 2;
      break;
      paramContext = "10020002";
      continue;
      paramContext = "10020003";
      continue;
      paramContext = "10020004";
    }
  }
  
  public void a(String paramString, Activity paramActivity)
  {
    paramString = (b)b.get(paramString);
    Object localObject = new com.xiaoenai.app.classes.common.c.a();
    if (paramString.j == 0)
    {
      localObject = ((com.xiaoenai.app.classes.common.c.a)localObject).a(paramString.b, "ads");
      new e().a(paramActivity, (g)localObject);
    }
    for (;;)
    {
      a(paramString.h, paramActivity, "click");
      return;
      localObject = ((com.xiaoenai.app.classes.common.c.a)localObject).a(paramString.b);
      new i().a(paramActivity, (g)localObject);
    }
  }
  
  public void a(String paramString1, Activity paramActivity, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = al.a(paramString1);
      new com.xiaoenai.app.net.a(paramActivity).a(paramString1.getString("ad_zone_id"), paramString1.getString("token"), paramString1.getString("text"), paramString2);
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("ads");
      int i = 0;
      while (i < localJSONArray1.length())
      {
        paramJSONObject = localJSONArray1.optJSONObject(i);
        JSONArray localJSONArray2 = paramJSONObject.optJSONArray("image_urls");
        long l1 = paramJSONObject.optLong("group_id");
        long l2 = paramJSONObject.optLong("creative_id");
        String str = paramJSONObject.optString("report_url");
        Object localObject = paramJSONObject.optString("click_url");
        int j = paramJSONObject.optInt("is_outer");
        if ((b.containsKey(paramString)) && (((b)b.get(paramString)).e == l1)) {}
        for (paramJSONObject = (b)b.get(paramString);; paramJSONObject = new b())
        {
          paramJSONObject.e = l1;
          paramJSONObject.c = l2;
          paramJSONObject.h = str;
          paramJSONObject.f = new c[localJSONArray2.length()];
          paramJSONObject.b = ((String)localObject);
          paramJSONObject.j = j;
          j = 0;
          while (j < localJSONArray2.length())
          {
            localObject = localJSONArray2.optJSONObject(j);
            str = ((JSONObject)localObject).optString("url");
            int k = ((JSONObject)localObject).optInt("height");
            int m = ((JSONObject)localObject).optInt("width");
            localObject = new c();
            ((c)localObject).b = m;
            ((c)localObject).a = k;
            ((c)localObject).c = str;
            paramJSONObject.f[j] = localObject;
            j += 1;
          }
        }
        if (UserConfig.getLong("ads_" + paramString, 0L) == l1) {
          paramJSONObject.a(false);
        }
        b.put(paramString, paramJSONObject);
        i += 1;
      }
    }
  }
  
  public void b()
  {
    a.clear();
    b.clear();
    b = null;
    a = null;
    c = null;
  }
  
  public a[] c()
  {
    return d();
  }
  
  public class a
  {
    public boolean a;
    public String b;
    public long c;
    public int d;
    public long e;
    public a.c[] f;
    public boolean g;
    public String h;
    public int i;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    
    public a() {}
  }
  
  public class b
    extends a.a
  {
    private boolean o = true;
    
    public b()
    {
      super();
    }
    
    public int a(int paramInt1, int paramInt2)
    {
      return ab.b() * paramInt2 / paramInt1;
    }
    
    public void a(boolean paramBoolean)
    {
      this.o = paramBoolean;
    }
    
    public boolean a()
    {
      return this.o;
    }
  }
  
  public class c
  {
    public int a;
    public int b;
    public String c;
    
    public c() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */