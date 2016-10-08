package com.meiqia.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.meiqia.core.b.j;
import com.meiqia.core.d.h;
import com.meiqia.core.d.k;
import com.meiqia.core.d.m;
import com.meiqia.core.d.n;
import com.meiqia.core.d.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  protected static String a;
  private static a b;
  private static ah c;
  private static j d;
  private static boolean m;
  private ab e;
  private Handler f;
  private boolean g = true;
  private String h = "";
  private String i = "";
  private c j = c.c;
  private boolean k;
  private Context l;
  
  private a(Context paramContext)
  {
    d = new j(paramContext);
    this.e = new ab(paramContext);
    this.f = new Handler(Looper.getMainLooper());
    c = new ah(paramContext, d, this.e, this.f);
    this.l = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a(paramContext.getApplicationContext());
      }
      return b;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString, m paramm)
  {
    Object localObject = paramm;
    if (paramm == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!b(paramContext)) {
      return;
    }
    b = a(paramContext.getApplicationContext());
    if (TextUtils.isEmpty(paramString)) {
      paramString = d.a();
    }
    for (;;)
    {
      a = paramString;
      c.a(new ac((m)localObject));
      return;
      d.a(paramString);
    }
  }
  
  private void a(r paramr, h paramh)
  {
    r localr = paramr;
    if (paramr == null) {
      localr = new r();
    }
    paramr = paramh;
    if (paramh == null) {
      paramr = new com.meiqia.core.d.a();
    }
    if (m)
    {
      localr.a();
      return;
    }
    a(this.l, a, new ae(this, localr, paramr));
  }
  
  private boolean a(h paramh)
  {
    Object localObject = paramh;
    if (paramh == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!m)
    {
      ((h)localObject).a(19995, "meiqia sdk init failed");
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, n paramn)
  {
    Object localObject = paramn;
    if (paramn == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!m)
    {
      paramString1 = new com.meiqia.core.c.e(paramString1);
      paramString1.b(paramString3);
      paramString1.j(paramString2);
      paramString1.d("client");
      paramString1.g("failed");
      ((n)localObject).a(paramString1, 19995, "meiqia sdk init failed");
    }
    return true;
  }
  
  private void b(@NonNull com.meiqia.core.d.d paramd)
  {
    c.a(this.e, this.h, this.i, this.k, this.j, new am(this, paramd));
    this.k = false;
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      paramContext = paramContext.getPackageName();
      int n = Process.myPid();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == n)
        {
          boolean bool = paramContext.equals(localRunningAppProcessInfo.processName);
          if (bool) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static String d()
  {
    return "3.3.0";
  }
  
  private void m()
  {
    a(null);
  }
  
  public void a()
  {
    MeiQiaService.b = true;
    Intent localIntent = new Intent(this.l, MeiQiaService.class);
    localIntent.setAction("ACTION_CLOSE_SOCKET");
    this.l.startService(localIntent);
  }
  
  public void a(long paramLong)
  {
    c.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt, k paramk)
  {
    if (paramk == null) {
      paramk = new com.meiqia.core.d.a();
    }
    for (;;)
    {
      if (!a(paramk)) {
        return;
      }
      c.a(paramInt, 0, paramLong, 2, paramk);
      return;
    }
  }
  
  protected void a(com.meiqia.core.c.a parama)
  {
    c.a(parama);
  }
  
  public void a(com.meiqia.core.d.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = new com.meiqia.core.d.a();
    }
    a(new ag(this, (com.meiqia.core.d.d)localObject), (h)localObject);
  }
  
  public void a(com.meiqia.core.d.e parame)
  {
    Object localObject = parame;
    if (parame == null) {
      localObject = new com.meiqia.core.d.a();
    }
    c.a(new af(this, (com.meiqia.core.d.e)localObject));
  }
  
  protected void a(k paramk)
  {
    Object localObject = paramk;
    if (paramk == null) {
      localObject = new com.meiqia.core.d.a();
    }
    c.a(new ad(this, (k)localObject));
  }
  
  public void a(String paramString, com.meiqia.core.d.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = new com.meiqia.core.d.a();
    }
    a(new ai(this, paramString, (com.meiqia.core.d.d)localObject), (h)localObject);
  }
  
  public void a(String paramString, n paramn)
  {
    Object localObject = paramn;
    if (paramn == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!a("text", "", paramString, (n)localObject)) {
      return;
    }
    c.a(paramString, "text", null, (n)localObject);
  }
  
  public void a(Map<String, String> paramMap, com.meiqia.core.d.c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!a((h)localObject)) {
      return;
    }
    c.a(paramMap, (com.meiqia.core.d.c)localObject);
  }
  
  void a(boolean paramBoolean)
  {
    c.a(paramBoolean);
  }
  
  public com.meiqia.core.c.a b()
  {
    return c.d();
  }
  
  public void b(long paramLong)
  {
    d.f(paramLong);
  }
  
  public void b(long paramLong, int paramInt, k paramk)
  {
    Object localObject = paramk;
    if (paramk == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!a((h)localObject)) {
      return;
    }
    this.e.a(paramLong, paramInt, new an(this, (k)localObject));
  }
  
  public void b(String paramString, com.meiqia.core.d.d paramd)
  {
    Object localObject = paramd;
    if (paramd == null) {
      localObject = new com.meiqia.core.d.a();
    }
    a(new ak(this, paramString, (com.meiqia.core.d.d)localObject), (h)localObject);
  }
  
  public void b(String paramString, n paramn)
  {
    Object localObject = paramn;
    if (paramn == null) {
      localObject = new com.meiqia.core.d.a();
    }
    if (!a("photo", paramString, "", (n)localObject)) {
      return;
    }
    c.a("", "photo", paramString, (n)localObject);
  }
  
  public String c()
  {
    if (!m) {
      return null;
    }
    return c.b();
  }
  
  public void e()
  {
    a();
  }
  
  public void f()
  {
    if (!m) {
      return;
    }
    c.a(this.l);
  }
  
  public void g()
  {
    com.meiqia.core.b.e.a(this.l).b();
  }
  
  public void h()
  {
    com.meiqia.core.b.e.a(this.l).c();
    com.meiqia.core.b.e.a(this.l).a();
  }
  
  public boolean i()
  {
    return c.e();
  }
  
  public com.meiqia.core.c.d j()
  {
    return c.f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */