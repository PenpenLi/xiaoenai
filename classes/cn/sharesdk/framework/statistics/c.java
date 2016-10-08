package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.a.i;
import com.mob.tools.a.l;
import com.mob.tools.a.l.a;
import com.mob.tools.b.b;
import com.mob.tools.b.g;
import java.util.ArrayList;
import java.util.HashMap;

public class c
{
  private String a;
  private Context b;
  private cn.sharesdk.framework.statistics.a.e c;
  private com.mob.tools.b.c d;
  private l e;
  private com.mob.tools.b.e f;
  private String g;
  private String h;
  private boolean i;
  private HashMap<String, String> j;
  
  public c(Context paramContext, String paramString)
  {
    this.a = paramString;
    this.b = paramContext.getApplicationContext();
    this.c = cn.sharesdk.framework.statistics.a.e.a(this.b);
    this.d = com.mob.tools.b.c.a(this.b);
    this.e = new l();
    this.f = new com.mob.tools.b.e();
    paramContext = this.c.k("buffered_server_paths");
    try
    {
      this.j = ((HashMap)paramContext);
      i();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.j = new HashMap();
      }
    }
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    try
    {
      k = Integer.parseInt(this.d.p());
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "BSINFO");
      localHashMap.put("plat", Integer.valueOf(this.d.v()));
      localHashMap.put("device", this.d.w());
      localHashMap.put("carrier", Integer.valueOf(k));
      localHashMap.put("simopname", this.d.q());
      localHashMap.put("lac", Integer.valueOf(paramInt2));
      localHashMap.put("cell", Integer.valueOf(paramInt1));
      return this.f.a(localHashMap);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().d(localThrowable);
        int k = -1;
      }
    }
  }
  
  private String d(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("type", "DEVICE");
    paramHashMap.put("key", this.d.w());
    paramHashMap.put("carrier", this.d.p());
    paramHashMap.put("appkey", this.a);
    paramHashMap.put("apppkg", this.d.x());
    paramHashMap.put("appver", String.valueOf(this.d.z()));
    paramHashMap.put("sdkver", Integer.valueOf(60000 + ShareSDK.getSDKVersionCode()));
    paramHashMap.put("networktype", this.d.u());
    return this.f.a(paramHashMap);
  }
  
  private String e(String paramString)
  {
    boolean bool1 = this.c.b();
    boolean bool2 = this.c.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.c(this.d.x(), "utf-8")).append("|");
    localStringBuilder.append(b.c(this.d.A(), "utf-8")).append("|");
    localStringBuilder.append(b.c(String.valueOf(60000 + ShareSDK.getSDKVersionCode()), "utf-8")).append("|");
    localStringBuilder.append(b.c(String.valueOf(this.d.v()), "utf-8")).append("|");
    localStringBuilder.append(b.c(this.d.u(), "utf-8")).append("|");
    if (bool1)
    {
      localStringBuilder.append(b.c(String.valueOf(this.d.l()), "utf-8")).append("|");
      localStringBuilder.append(b.c(this.d.o(), "utf-8")).append("|");
      localStringBuilder.append(b.c(this.d.e(), "utf-8")).append("|");
      localStringBuilder.append(b.c(this.d.d(), "utf-8")).append("|");
      localStringBuilder.append(b.c(this.d.p(), "utf-8")).append("|");
      if (!bool2) {
        break label338;
      }
      localStringBuilder.append(paramString);
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      cn.sharesdk.framework.utils.d.a().i("shorLinkMsg ===>>>>", new Object[] { paramString });
      return Base64.encodeToString(b.a(b.c(String.format("%s:%s", new Object[] { this.d.w(), this.a })), paramString), 2);
      localStringBuilder.append("|||||");
      break;
      label338:
      localStringBuilder.append(paramString.split("\\|")[0]);
      localStringBuilder.append("|||||");
    }
  }
  
  private void i()
  {
    String str1 = this.d.x() + "/" + this.d.A();
    String str2 = "ShareSDK/" + ShareSDK.getSDKVersionName();
    String str3 = "Android/" + this.d.l();
    this.g = (str1 + " " + str2 + " " + str3);
    this.h = "http://api.share.mob.com:80";
    this.i = true;
  }
  
  private String j()
  {
    return this.h + "/conn";
  }
  
  private String k()
  {
    if ((this.j != null) && (this.j.containsKey("/date"))) {
      return (String)this.j.get("/date") + "/date";
    }
    return this.h + "/date";
  }
  
  private String l()
  {
    return this.h + "/conf5";
  }
  
  private String m()
  {
    if ((this.j != null) && (this.j.containsKey("/data2"))) {
      return (String)this.j.get("/data2") + "/data2";
    }
    return this.h + "/data2";
  }
  
  private String n()
  {
    return "http://up.sharesdk.cn/upload/image";
  }
  
  private String o()
  {
    if ((this.j != null) && (this.j.containsKey("/log4"))) {
      return (String)this.j.get("/log4") + "/log4";
    }
    return this.h + "/log4";
  }
  
  private String p()
  {
    return "http://l.mob.com/url/ShareSdkMapping.do";
  }
  
  private String q()
  {
    if ((this.j != null) && (this.j.containsKey("/snsconf"))) {
      return (String)this.j.get("/snsconf") + "/snsconf";
    }
    return this.h + "/snsconf";
  }
  
  public HashMap<String, Object> a()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new i("appkey", this.a));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 30000;
    locala.b = 30000;
    localObject = this.e.httpPost(j(), (ArrayList)localObject, null, localArrayList, locala);
    cn.sharesdk.framework.utils.d.a().i(" isConnectToServer response == %s", new Object[] { localObject });
    return this.f.a((String)localObject);
  }
  
  public HashMap<String, Object> a(String paramString1, ArrayList<String> paramArrayList, int paramInt, String paramString2)
  {
    if (!this.i) {}
    do
    {
      do
      {
        return null;
        paramString1 = new ArrayList();
        paramString1.add(new i("key", this.a));
        int k = 0;
        while (k < paramArrayList.size())
        {
          paramString1.add(new i("urls", ((String)paramArrayList.get(k)).toString()));
          k += 1;
        }
        paramString1.add(new i("deviceid", this.d.w()));
        paramString1.add(new i("snsplat", String.valueOf(paramInt)));
        paramArrayList = e(paramString2);
      } while (TextUtils.isEmpty(paramArrayList));
      paramString1.add(new i("m", paramArrayList));
      paramArrayList = new ArrayList();
      paramArrayList.add(new i("User-Agent", this.g));
      paramString2 = new l.a();
      paramString2.a = 5000;
      paramString2.b = 5000;
      paramString1 = this.e.httpPost(p(), paramString1, null, paramArrayList, paramString2);
      cn.sharesdk.framework.utils.d.a().i("> SERVER_SHORT_LINK_URL  resp: %s", new Object[] { paramString1 });
      if (TextUtils.isEmpty(paramString1))
      {
        this.i = false;
        return null;
      }
      paramString1 = this.f.a(paramString1);
    } while (((Integer)paramString1.get("status")).intValue() != 200);
    return paramString1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new i("m", b.b(b(paramInt1, paramInt2), "sdk.sharesdk.sdk")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 30000;
    locala.b = 30000;
    localObject = this.e.httpPost(m(), (ArrayList)localObject, null, localArrayList, locala);
    cn.sharesdk.framework.utils.d.a().i("> uploadCellInfo  resp: %s", new Object[] { localObject });
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    cn.sharesdk.framework.statistics.a.d.a(this.b, paramc.toString(), paramc.e);
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("type", paramString);
    ((HashMap)localObject).put("plat", Integer.valueOf(this.d.v()));
    ((HashMap)localObject).put("device", this.d.w());
    ((HashMap)localObject).put("list", paramArrayList);
    paramArrayList = new com.mob.tools.b.e().a((HashMap)localObject);
    paramString = new ArrayList();
    paramString.add(new i("m", b.b(paramArrayList, "sdk.sharesdk.sdk")));
    paramArrayList = new ArrayList();
    paramArrayList.add(new i("User-Agent", this.g));
    localObject = new l.a();
    ((l.a)localObject).a = 30000;
    ((l.a)localObject).b = 30000;
    paramString = this.e.httpPost(m(), paramString, null, paramArrayList, (l.a)localObject);
    cn.sharesdk.framework.utils.d.a().i("> uploadApps list resp: %s", new Object[] { paramString });
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    cn.sharesdk.framework.statistics.a.d.a(this.b, paramArrayList);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.j = paramHashMap;
    this.c.a("buffered_server_paths", this.j);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ("none".equals(this.d.u())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("m", paramString));
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localArrayList.add(new i("t", paramString));
      paramString = new ArrayList();
      paramString.add(new i("User-Agent", this.g));
      l.a locala = new l.a();
      locala.a = 30000;
      locala.b = 30000;
      paramString = this.e.httpPost(o(), localArrayList, null, paramString, locala);
      cn.sharesdk.framework.utils.d.a().i("> Upload All Log  resp: %s", new Object[] { paramString });
      if ((TextUtils.isEmpty(paramString)) || (((Integer)this.f.a(paramString).get("status")).intValue() == 200)) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public long b()
  {
    if (!this.c.i()) {
      return 0L;
    }
    Object localObject = "{}";
    try
    {
      String str = this.e.httpGet(k(), null, null, null);
      localObject = str;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable2);
      }
    }
    localObject = this.f.a((String)localObject);
    if (((HashMap)localObject).containsKey("timestamp")) {
      try
      {
        long l = g.e(String.valueOf(((HashMap)localObject).get("timestamp")));
        l = System.currentTimeMillis() - l;
        this.c.a("service_time", Long.valueOf(l));
        return l;
      }
      catch (Throwable localThrowable1)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable1);
        return this.c.a();
      }
    }
    return this.c.a();
  }
  
  public void b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("m", paramString));
    paramString = new ArrayList();
    paramString.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 10000;
    locala.b = 10000;
    paramString = this.e.httpPost(m(), localArrayList, null, paramString, locala);
    cn.sharesdk.framework.utils.d.a().i("> uploadEXTDeviceData  resp: %s", new Object[] { paramString });
  }
  
  public void b(HashMap<String, Object> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("m", b.b(d(paramHashMap), "sdk.sharesdk.sdk")));
    paramHashMap = new ArrayList();
    paramHashMap.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 30000;
    locala.b = 30000;
    paramHashMap = this.e.httpPost(m(), localArrayList, null, paramHashMap, locala);
    cn.sharesdk.framework.utils.d.a().i("> uploadDeviceData  resp: %s", new Object[] { paramHashMap });
  }
  
  public HashMap<String, Object> c()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new i("appkey", this.a));
    ((ArrayList)localObject).add(new i("device", this.d.w()));
    ((ArrayList)localObject).add(new i("plat", String.valueOf(this.d.v())));
    ((ArrayList)localObject).add(new i("apppkg", this.d.x()));
    ((ArrayList)localObject).add(new i("appver", String.valueOf(this.d.z())));
    ((ArrayList)localObject).add(new i("sdkver", String.valueOf(60000 + ShareSDK.getSDKVersionCode())));
    ((ArrayList)localObject).add(new i("networktype", this.d.u()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 10000;
    locala.b = 10000;
    localObject = this.e.httpPost(l(), (ArrayList)localObject, null, localArrayList, locala);
    cn.sharesdk.framework.utils.d.a().i(" get server config response == %s", new Object[] { localObject });
    return this.f.a((String)localObject);
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    paramString = new i("file", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("User-Agent", this.g));
    paramString = this.e.httpPost(n(), null, paramString, localArrayList, null);
    cn.sharesdk.framework.utils.d.a().i("upload file response == %s", new Object[] { paramString });
    return this.f.a(paramString);
  }
  
  public void c(HashMap<String, Object> paramHashMap)
  {
    paramHashMap = this.f.a(paramHashMap);
    this.c.a(this.a, paramHashMap);
  }
  
  public HashMap<String, Object> d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mac", this.d.c());
    localHashMap.put("udid", this.d.f());
    localHashMap.put("model", this.d.d());
    localHashMap.put("factory", this.d.e());
    localHashMap.put("plat", Integer.valueOf(this.d.v()));
    localHashMap.put("sysver", String.valueOf(this.d.l()));
    localHashMap.put("breaked", Boolean.valueOf(false));
    localHashMap.put("screensize", this.d.o());
    localHashMap.put("androidid", this.d.E());
    String str = this.d.F();
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("adsid", str);
    }
    return localHashMap;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    paramString = Base64.decode(paramString, 2);
    String str = this.d.w();
    paramString = new String(b.b(b.c(this.a + ":" + str), paramString), "UTF-8").trim();
    return this.f.a(paramString);
  }
  
  public String e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "DEVEXT");
    localHashMap.put("plat", Integer.valueOf(this.d.v()));
    localHashMap.put("device", this.d.w());
    localHashMap.put("phonename", this.d.r());
    localHashMap.put("signmd5", this.d.s());
    if (this.d.u().equals("wifi"))
    {
      localHashMap.put("ssid", this.d.a());
      localHashMap.put("bssid", this.d.b());
    }
    return this.f.a(localHashMap);
  }
  
  public HashMap<String, Object> f()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new i("appkey", this.a));
    ((ArrayList)localObject).add(new i("device", this.d.w()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("User-Agent", this.g));
    l.a locala = new l.a();
    locala.a = 10000;
    locala.b = 10000;
    localObject = this.e.httpPost(q(), (ArrayList)localObject, null, localArrayList, locala);
    return this.f.a((String)localObject);
  }
  
  public ArrayList<cn.sharesdk.framework.statistics.a.c> g()
  {
    ArrayList localArrayList2 = cn.sharesdk.framework.statistics.a.d.a(this.b);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public HashMap<String, Object> h()
  {
    String str = this.c.e(this.a);
    return this.f.a(str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\statistics\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */