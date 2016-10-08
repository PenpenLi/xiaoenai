package com.meiqia.core;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.meiqia.core.c.a;
import com.meiqia.core.c.e;
import com.meiqia.core.d.m;
import com.meiqia.core.d.n;
import com.meiqia.core.d.q;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class ah
{
  protected static com.meiqia.core.c.b a;
  private final com.meiqia.core.b.j b;
  private final Handler c;
  private final ab d;
  private final Context e;
  private a f;
  private com.meiqia.core.c.c g;
  private com.meiqia.core.c.d h;
  private as i;
  private String j;
  private String k;
  private c l = c.c;
  private boolean m = false;
  
  public ah(Context paramContext, com.meiqia.core.b.j paramj, ab paramab, Handler paramHandler)
  {
    this.e = paramContext;
    this.b = paramj;
    this.c = paramHandler;
    this.i = as.a();
    this.d = paramab;
  }
  
  private void a(long paramLong, as.g paramg)
  {
    this.i.a(paramLong, new j(this, paramg));
  }
  
  private void a(as.a parama)
  {
    a(new s(this, parama));
  }
  
  private void a(com.meiqia.core.c.c paramc)
  {
    this.g = paramc;
  }
  
  private void a(e parame)
  {
    parame.i(this.b.s());
    parame.d("client");
    parame.f("message");
    String str = a.b();
    if (!TextUtils.isEmpty(str)) {
      parame.e(str);
    }
    if ((this.g != null) && (this.f != null))
    {
      parame.h(this.f.b());
      parame.a(this.g.c());
      parame.a(this.g.a());
      parame.c(this.g.b());
    }
  }
  
  private void a(e parame, long paramLong)
  {
    parame.k(parame.h() + "");
    parame.d(paramLong);
  }
  
  private void a(e parame, n paramn)
  {
    if (this.f != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("browser_id", a.e());
      localHashMap.put("track_id", a.b());
      localHashMap.put("ent_id", a.d());
      localHashMap.put("type", parame.c());
      localHashMap.put("content", parame.b());
      this.i.a("https://eco-api.meiqia.com/client/send_msg", localHashMap, new v(this, parame, paramn));
      return;
    }
    b(parame, paramn);
  }
  
  private void a(e parame, Map<String, String> paramMap, as.f paramf)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("enterprise_id", a.d());
    localHashMap.put("track_id", a.b());
    localHashMap.put("visit_id", a.g());
    localHashMap.put("channel", "sdk");
    localHashMap.put("content_type", parame.c());
    localHashMap.put("content", parame.b());
    this.i.a(localHashMap, paramf);
    b(paramMap, null);
  }
  
  private void a(Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }
  
  private void a(String paramString, q paramq)
  {
    try
    {
      String str1 = this.b.p();
      Object localObject = this.b.r();
      this.b.l(paramString);
      String str2 = this.b.p();
      this.b.l((String)localObject);
      localObject = com.meiqia.core.b.l.e(this.e);
      String str3 = com.meiqia.core.b.c.a((Map)localObject).toString();
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)) || ((!TextUtils.isEmpty(str1)) && (!str1.equals(str3))))
      {
        this.i.a(paramString, (Map)localObject, new cj(this, str2, paramString, str3, paramq));
        return;
      }
      if (paramq != null)
      {
        a(new cm(this, paramq));
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramq != null) {
        a(new cn(this, paramq));
      }
    }
  }
  
  private void a(String paramString1, String paramString2, as.h paramh)
  {
    for (;;)
    {
      int n;
      try
      {
        paramString2 = new File(paramString2);
        n = -1;
        switch (paramString1.hashCode())
        {
        default: 
          switch (n)
          {
          default: 
            paramh.a(20001, "unknown contentType");
          case 2: 
            return;
          }
          break;
        }
      }
      catch (Exception paramString1)
      {
        paramh.a(19996, "file not found");
        return;
      }
      if (paramString1.equals("photo"))
      {
        n = 0;
        continue;
        if (paramString1.equals("audio"))
        {
          n = 1;
          continue;
          if (paramString1.equals("file")) {
            n = 2;
          }
        }
      }
    }
    paramString1 = new File(com.meiqia.core.b.l.a(this.e), System.currentTimeMillis() + "");
    com.meiqia.core.b.b.a(paramString2, paramString1);
    this.i.a(paramString1, new bv(this, paramh), paramh);
    return;
    this.i.b(paramString2, new bx(this, paramh), paramh);
  }
  
  private void a(@NonNull List<e> paramList, com.meiqia.core.d.k paramk)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("enterprise_id", a.d());
    localHashMap.put("begin", com.meiqia.core.b.k.a(this.b.c()));
    this.i.a(localHashMap, new f(this, paramList, paramk));
  }
  
  private void a(Map<String, Object> paramMap, List<e> paramList, as.a parama)
  {
    a(a.b(), new o(this, paramMap, paramList, parama));
  }
  
  private boolean a(String paramString)
  {
    return com.meiqia.core.b.l.a(paramString, this.b) != null;
  }
  
  private void b(e parame, n paramn)
  {
    a(this.d, this.j, this.k, false, this.l, new x(this, parame, paramn));
  }
  
  private void b(e parame, Map<String, String> paramMap, as.f paramf)
  {
    long l1 = this.b.l();
    HashMap localHashMap = new HashMap();
    localHashMap.put("enterprise_id", a.d());
    localHashMap.put("type", "sdk");
    localHashMap.put("content_type", parame.c());
    localHashMap.put("source", "client");
    localHashMap.put("content", parame.b());
    this.i.a(localHashMap, l1, paramf);
    b(paramMap, null);
  }
  
  private void b(com.meiqia.core.d.k paramk)
  {
    a(new k(this, paramk));
  }
  
  private void b(Map<String, Object> paramMap, List<e> paramList, as.a parama)
  {
    this.i.a(paramMap, new r(this, paramList, parama));
  }
  
  public void a()
  {
    a(new u(this));
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, com.meiqia.core.d.k paramk)
  {
    int n = Integer.parseInt(a.d());
    String str1 = com.meiqia.core.b.k.a(paramLong);
    String str2 = a.b();
    this.i.a(str2, paramInt1, paramInt2, n, str1, paramInt3, new bz(this, paramLong, paramInt1, paramk));
  }
  
  public void a(long paramLong)
  {
    this.d.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MeiQiaService.class);
    localIntent.setAction("ACTION_OPEN_SOCKET");
    paramContext.startService(localIntent);
    a();
  }
  
  public void a(ab paramab, String paramString1, String paramString2, boolean paramBoolean, c paramc, as.a parama)
  {
    if ((!paramBoolean) && (MeiQiaService.c) && (this.f != null) && (parama != null) && (this.b.d()))
    {
      a(parama);
      return;
    }
    String str1 = a.b();
    String str2 = a.g();
    String str3 = a.d();
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("group_token", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("agent_token", paramString2);
    }
    localHashMap.put("fallback", Integer.valueOf(paramc.a()));
    localHashMap.put("visit_id", str2);
    localHashMap.put("track_id", str1);
    localHashMap.put("ent_id", Long.valueOf(str3));
    if ((paramBoolean) && (this.f != null)) {
      localHashMap.put("exclude_agent_tokens", Arrays.asList(new String[] { this.f.c() }));
    }
    if (!TextUtils.isEmpty(this.b.i())) {
      localHashMap.put("exclude_agent_tokens", Arrays.asList(new String[] { this.b.i() }));
    }
    localHashMap.put("queueing", Boolean.valueOf(true));
    if (!this.b.d())
    {
      a(localHashMap, null, parama);
      return;
    }
    b(new cl(this, paramab, localHashMap, parama));
  }
  
  public void a(as.d paramd)
  {
    this.i.a(new p(this, paramd));
  }
  
  public void a(a parama)
  {
    this.f = parama;
    if ((this.f != null) && (!this.f.e())) {
      this.b.f(null);
    }
    b.a(this.e).a(parama);
  }
  
  public void a(com.meiqia.core.c.b paramb)
  {
    if (paramb != null)
    {
      a = paramb;
      this.b.l(a.b());
      String str = "current info: t = " + paramb.b();
      str = str + " b " + paramb.e();
      com.meiqia.core.b.g.b(str + " e " + paramb.d());
    }
  }
  
  public void a(com.meiqia.core.d.j paramj)
  {
    this.i.a(new a(paramj));
  }
  
  public void a(com.meiqia.core.d.k paramk)
  {
    long l1 = this.b.b();
    int n = Integer.parseInt(a.d());
    String str1 = com.meiqia.core.b.k.a(l1);
    String str2 = a.b();
    this.i.a(str2, Integer.MAX_VALUE, 0, n, str1, 1, new d(this, paramk));
  }
  
  public void a(m paramm)
  {
    com.meiqia.core.c.b localb = c();
    int n;
    if (localb != null)
    {
      n = 1;
      if (n != 0) {
        break label34;
      }
      a(new bd(this, paramm));
    }
    label34:
    while (paramm == null)
    {
      return;
      n = 0;
      break;
    }
    paramm.a(localb.b());
  }
  
  public void a(@Nullable q paramq)
  {
    long l1 = this.b.k();
    if (System.currentTimeMillis() - l1 < 600000L)
    {
      if (paramq != null) {
        paramq.a(20000, "request limit");
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ent_id", a.d());
    localHashMap.put("track_id", a.b());
    this.i.a(localHashMap, new l(this, paramq));
  }
  
  public void a(String paramString, com.meiqia.core.d.j paramj)
  {
    this.i.a(paramString, new a(paramj));
  }
  
  public void a(String paramString, m paramm)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (paramm != null) {
        paramm.a(20001, "customizedId can't be empty");
      }
    }
    String str;
    do
    {
      return;
      str = this.b.p(paramString);
      if ((!TextUtils.isEmpty(str)) && (a(str))) {}
      for (int n = 1; n == 0; n = 0)
      {
        this.i.b(paramString, new ch(this, paramString, paramm));
        return;
      }
      this.b.l(str);
    } while (paramm == null);
    paramm.a(str);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, n paramn)
  {
    e locale = new e(paramString2);
    locale.b(paramString1);
    locale.j(paramString3);
    locale.d("client");
    a(locale);
    this.d.a(locale);
    if ("text".equals(paramString2))
    {
      a(locale, paramn);
      return;
    }
    a(paramString2, paramString3, new bu(this, locale, paramString2, paramn));
  }
  
  public void a(Map<String, String> paramMap, @Nullable com.meiqia.core.d.c paramc)
  {
    try
    {
      String str1 = com.meiqia.core.b.c.a(paramMap).toString();
      if (str1.equals(this.b.q()))
      {
        paramc.a();
        return;
      }
      String str2 = a.b();
      String str3 = a.d();
      JSONObject localJSONObject = com.meiqia.core.b.c.a(new HashMap(paramMap));
      HashMap localHashMap = new HashMap();
      localHashMap.put("attrs", localJSONObject);
      localHashMap.put("track_id", str2);
      localHashMap.put("ent_id", str3);
      if (paramMap.containsKey("avatar")) {
        this.b.m((String)paramMap.get("avatar"));
      }
      this.i.a(localHashMap, new cd(this, str1, paramc));
      return;
    }
    catch (Exception paramMap)
    {
      if (paramc != null) {
        paramc.a(20001, "parameter error");
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.m)
    {
      if ((this.f != null) && (this.f.e())) {
        this.b.f(this.f.c());
      }
      return;
    }
    this.b.f(null);
  }
  
  public void a(boolean paramBoolean, e parame, Map<String, String> paramMap, n paramn)
  {
    paramn = new g(this, parame, paramBoolean, paramn);
    long l1 = this.b.l();
    if (l1 == -1L)
    {
      a(parame, paramMap, paramn);
      return;
    }
    a(l1, new i(this, parame, paramMap, paramn));
  }
  
  public String b()
  {
    return a.b();
  }
  
  public void b(Map<String, String> paramMap, @Nullable com.meiqia.core.d.c paramc)
  {
    try
    {
      if (TextUtils.isEmpty(this.b.q()))
      {
        a(paramMap, paramc);
        return;
      }
      String str1 = a.b();
      String str2 = a.d();
      paramMap = com.meiqia.core.b.c.a(paramMap);
      HashMap localHashMap = new HashMap();
      localHashMap.put("attrs", paramMap);
      localHashMap.put("track_id", str1);
      localHashMap.put("ent_id", str2);
      localHashMap.put("overwrite", Boolean.valueOf(true));
      this.i.a(localHashMap, new cf(this, paramc));
      return;
    }
    catch (Exception paramMap)
    {
      if (paramc != null) {
        paramc.a(20001, "parameter error");
      }
    }
  }
  
  public com.meiqia.core.c.b c()
  {
    return com.meiqia.core.b.l.a(this.b.e(), this.b);
  }
  
  public a d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.m;
  }
  
  public com.meiqia.core.c.d f()
  {
    Object localObject;
    if (this.h == null)
    {
      this.h = new com.meiqia.core.c.d();
      localObject = this.b.m();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      com.meiqia.core.b.c.a(this.h, (JSONObject)localObject);
      return this.h;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private class a
    implements com.meiqia.core.d.i
  {
    private com.meiqia.core.d.j b;
    
    public a(com.meiqia.core.d.j paramj)
    {
      this.b = paramj;
    }
    
    public void a(int paramInt, String paramString)
    {
      if (this.b != null) {
        this.b.a(paramInt, paramString);
      }
    }
    
    public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      com.meiqia.core.b.l.a(paramString2, ah.a(ah.this), paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
      ah.a(ah.this, new z(this, paramString2));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */