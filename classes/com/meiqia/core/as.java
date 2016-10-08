package com.meiqia.core;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.ae;
import b.af;
import b.af.a;
import b.ag;
import b.ag.a;
import b.al;
import b.al.a;
import b.an;
import b.aq;
import com.meiqia.core.c.b;
import com.meiqia.core.c.e;
import com.meiqia.core.d.h;
import com.meiqia.core.d.i;
import com.meiqia.core.d.k;
import com.meiqia.core.d.q;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class as
{
  public static final ae a = ae.a("application/json; charset=utf-8");
  private static as b;
  private static ag c;
  private Handler d = new Handler(Looper.getMainLooper());
  
  private as()
  {
    c = new ag.a().a(30L, TimeUnit.SECONDS).a();
  }
  
  private al.a a(String paramString)
  {
    al.a locala = new al.a();
    String str1 = a.a;
    String str2 = System.currentTimeMillis() / 1000L + 60L + "";
    paramString = str1 + ":" + paramString + ":" + str2;
    str1 = ("Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " " + Build.DEVICE + ") MeiqiaSDK/ " + "Source/SDK " + a.d() + " Language/" + Locale.getDefault().getLanguage()).replaceAll("[^\\x00-\\x7F]", "");
    locala.b("Authorization", paramString);
    locala.b("User-Agent", str1);
    locala.b("app_version", a.d());
    locala.b("app_platform", "android_sdk");
    locala.b("app_channel", "sdk");
    return locala;
  }
  
  public static as a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new as();
      }
      return b;
    }
    finally {}
  }
  
  private String a(Map<String, Object> paramMap)
  {
    String str = com.meiqia.core.b.c.a(paramMap).toString();
    if (ah.a != null) {}
    for (paramMap = ah.a.c();; paramMap = "") {
      return com.meiqia.core.b.a.a(paramMap, str);
    }
  }
  
  private void a(al paramal, b paramb, h paramh)
  {
    com.meiqia.core.b.g.a(paramal);
    c.a(paramal).a(new bl(this, paramh, paramb));
  }
  
  private void a(String paramString, Map<String, Object> paramMap, b paramb, h paramh)
  {
    a(true, paramString, paramMap, paramb, paramh);
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, Map<String, Object> paramMap, Map<String, String> paramMap1, b paramb, h paramh)
  {
    al.a locala;
    try
    {
      locala = a(paramString1);
      if (paramMap1 != null)
      {
        paramString1 = paramMap1.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramMap1 = (Map.Entry)paramString1.next();
          locala.b((String)paramMap1.getKey(), (String)paramMap1.getValue());
        }
      }
      if (paramBoolean) {
        break label153;
      }
    }
    catch (Exception paramString1)
    {
      if (paramh != null) {
        this.d.post(new at(this, paramh));
      }
      return;
    }
    paramString1 = com.meiqia.core.b.c.a(paramMap).toString();
    paramString1 = an.a(a, paramString1);
    locala.b("Authorization");
    for (;;)
    {
      locala.a(paramString2).a(paramString1);
      a(locala.b(), paramb, paramh);
      return;
      label153:
      paramString1 = an.a(a, a(paramMap));
    }
  }
  
  private void a(boolean paramBoolean, String paramString, Map<String, Object> paramMap, b paramb, h paramh)
  {
    a(paramBoolean, b(), paramString, paramMap, null, paramb, paramh);
  }
  
  private String b()
  {
    String str = "0";
    if (ah.a != null) {
      str = ah.a.b();
    }
    return str;
  }
  
  private void b(String paramString, Map<String, String> paramMap, b paramb, h paramh)
  {
    try
    {
      paramMap = com.meiqia.core.b.c.a(paramString, paramMap);
      al.a locala = c();
      if ((paramb != null) && ((paramb instanceof c))) {
        locala.b("Authorization");
      }
      locala.a(paramString);
      a(locala.a(paramString + paramMap).a().b(), paramb, paramh);
      return;
    }
    catch (Exception paramString)
    {
      this.d.post(new bb(this, paramh));
    }
  }
  
  private al.a c()
  {
    return a(b());
  }
  
  private void c(String paramString, Map<String, Object> paramMap, b paramb, h paramh)
  {
    try
    {
      paramMap = an.a(a, a(paramMap));
      a(c().a(paramString).b(paramMap).b(), paramb, paramh);
      return;
    }
    catch (Exception paramString)
    {
      this.d.post(new bk(this, paramh));
    }
  }
  
  public void a(long paramLong, e parame)
  {
    String str = "https://eco-api.meiqia.com/client/tickets_v2/" + paramLong;
    HashMap localHashMap = new HashMap();
    localHashMap.put("track_id", ah.a.b());
    b(str, localHashMap, new bg(this, parame), parame);
  }
  
  public void a(d paramd)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("track_id", ah.a.b());
    localHashMap.put("ent_id", ah.a.d());
    b("https://eco-api.meiqia.com/client/queue/position", localHashMap, new bj(this, paramd), paramd);
  }
  
  public void a(i parami)
  {
    a(null, parami);
  }
  
  public void a(File paramFile, b paramb, h paramh)
  {
    paramFile = an.a(ae.a("image/jpeg"), paramFile);
    paramFile = new af.a().a(af.e).a("file", "file.jpeg", paramFile).a();
    a(new al.a().a("https://eco-api-upload.meiqia.com/upload").a(paramFile).b(), new bs(this, paramb), paramh);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, k paramk)
  {
    paramString1 = "https://eco-api.meiqia.com/conversation/" + paramString1 + "/messages_streams";
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", paramInt1 + "");
    localHashMap.put("ent_id", paramInt3 + "");
    localHashMap.put("last_message_created_on", paramString2);
    localHashMap.put("ascending", paramInt4 + "");
    localHashMap.put("_time", String.valueOf(System.currentTimeMillis()));
    b(paramString1, localHashMap, new av(this, paramk), paramk);
  }
  
  public void a(String paramString, i parami)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_key", a.a);
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("track_id", paramString);
    }
    a(false, "https://eco-api.meiqia.com/sdk/init_sdk_user", localHashMap, new ax(this, parami), parami);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, q paramq)
  {
    paramString2 = new File(paramString2, paramString3);
    paramString1 = new al.a().a(paramString1).b();
    c.a(paramString1).a(new bc(this, paramq, paramString2));
  }
  
  public void a(String paramString, Map<String, Object> paramMap, f paramf)
  {
    a(paramString, paramMap, new br(this, paramf), paramf);
  }
  
  public void a(String paramString, Map<String, Object> paramMap, q paramq)
  {
    a(true, paramString, "https://eco-api.meiqia.com/sdk/statistics", paramMap, null, new ba(this, paramString, paramq), paramq);
  }
  
  public void a(Map<String, Object> paramMap, long paramLong, f paramf)
  {
    a(false, "https://eco-api.meiqia.com/client/tickets_v2/" + paramLong + "/replies", paramMap, new bf(this, paramf), paramf);
  }
  
  public void a(Map<String, Object> paramMap, a parama)
  {
    a("https://eco-api.meiqia.com/scheduler", paramMap, new au(this, parama, paramMap), parama);
  }
  
  public void a(Map<String, Object> paramMap, e parame)
  {
    a(false, "https://eco-api.meiqia.com/sdk/init", paramMap, new bh(this, parame), parame);
  }
  
  public void a(Map<String, Object> paramMap, f paramf)
  {
    a(false, "https://eco-api.meiqia.com/client/tickets_v2", paramMap, new be(this, paramf), paramf);
  }
  
  public void a(Map<String, Object> paramMap, com.meiqia.core.d.c paramc)
  {
    com.meiqia.core.b.g.b("setAttrs");
    c("https://eco-api.meiqia.com/client/attrs", paramMap, new az(this, paramc), paramc);
  }
  
  public void a(Map<String, String> paramMap, k paramk)
  {
    b("https://eco-api.meiqia.com/client/tickets_v2/" + ah.a.b() + "/replies", paramMap, new aw(this, paramk), paramk);
  }
  
  public void b(File paramFile, b paramb, h paramh)
  {
    paramFile.exists();
    paramFile = an.a(ae.a("audio/amr"), paramFile);
    paramFile = new af.a().a(af.e).a("file", "file.amr", paramFile).a();
    a(new al.a().a("https://eco-api-upload.meiqia.com/upload").a(paramFile).b(), new bt(this, paramb), paramh);
  }
  
  public void b(String paramString, i parami)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dev_client_id", paramString);
    a("https://eco-api.meiqia.com/sdk/get_dev_client_id", localHashMap, new ay(this, parami), parami);
  }
  
  public static abstract interface a
    extends h
  {
    public abstract void a(boolean paramBoolean, com.meiqia.core.c.a parama, com.meiqia.core.c.c paramc, List<e> paramList);
  }
  
  public static abstract interface b
  {
    public abstract void a(JSONObject paramJSONObject, aq paramaq);
  }
  
  private class c
    implements as.b
  {
    public void a(JSONObject paramJSONObject, aq paramaq) {}
  }
  
  public static abstract interface d
    extends h
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface e
    extends h
  {
    public abstract void a(JSONObject paramJSONObject);
  }
  
  public static abstract interface f
    extends h
  {
    public abstract void a(String paramString, long paramLong);
  }
  
  public static abstract interface g
    extends h
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface h
    extends h
  {
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */