package com.meiqia.core;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.meiqia.core.b.c;
import com.meiqia.core.b.g;
import com.meiqia.core.b.j;
import com.meiqia.core.b.l;
import com.meiqia.core.c.b;
import com.meiqia.core.c.e;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class MeiQiaService
  extends Service
{
  public static boolean a = false;
  public static boolean b = false;
  protected static boolean c = false;
  private boolean d = false;
  private j e;
  private a f;
  private n g;
  private Handler h;
  private com.meiqia.core.a.a.a.a i;
  private String j;
  private boolean k;
  private AtomicBoolean l = new AtomicBoolean(false);
  
  private void a()
  {
    String str4;
    if (((this.i == null) || (!this.i.e().b())) && (ah.a != null))
    {
      this.j = ah.a.b();
      g.b("socket init");
      String str1 = e();
      ah.a.e(str1);
      l.a(ah.a, this.e);
      str1 = ah.a.e();
      String str2 = ah.a.b();
      str4 = ah.a.d() + "";
      String str3 = ah.a.g();
      String str5 = ah.a.f();
      String str6 = System.currentTimeMillis() + "";
      str4 = "?browser_id=" + str1 + "&" + "ent_id=" + str4 + "&" + "visit_id=" + str3 + "&" + "visit_page_id=" + str5 + "&" + "track_id=" + str2 + "&time=" + str6;
      g.b("socket: t = " + str2 + " b = " + str1 + " v = " + str3);
    }
    try
    {
      this.i = new ap(this, new URI("ws://eco-push-api-client.meiqia.com/pusher/websocket" + str4));
      this.i.c();
      return;
    }
    catch (AssertionError localAssertionError)
    {
      c = true;
      g.a("socket AssertionError");
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      c = true;
      g.a("socket URISyntaxException");
    }
  }
  
  private void a(com.meiqia.core.c.a parama)
  {
    a.a(this).a(parama);
    Intent localIntent = new Intent("agent_change_action");
    localIntent.putExtra("client_is_redirected", true);
    l.a(this, localIntent);
    if (a) {
      g.b("action directAgent : agentName = " + parama.b());
    }
  }
  
  private void a(e parame)
  {
    if ("ending".equals(parame.j())) {
      a.a(this).a(null);
    }
    if ("audio".equals(parame.j()))
    {
      parame.a(false);
      b(parame);
      return;
    }
    this.g.a(parame);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("body");
    if (paramJSONObject != null)
    {
      paramJSONObject = c.a(paramJSONObject);
      paramJSONObject.k(paramJSONObject.h() + "");
      paramJSONObject.d(System.currentTimeMillis());
      a(paramJSONObject);
      this.e.b(System.currentTimeMillis());
    }
  }
  
  private void b()
  {
    if (this.i != null)
    {
      this.i.d();
      this.i = null;
    }
  }
  
  private void b(e parame)
  {
    Object localObject = getExternalCacheDir();
    String str1 = parame.o();
    if ((localObject != null) && (l.a()))
    {
      localObject = ((File)localObject).getAbsolutePath();
      String str2 = parame.h() + "";
      as.a().a(str1, (String)localObject, str2, new aq(this, parame));
      return;
    }
    a(parame);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("target_id");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return;
    }
    Intent localIntent = new Intent("invite_evaluation");
    localIntent.putExtra("conversation_id", paramJSONObject);
    l.a(this, localIntent);
  }
  
  private void c()
  {
    if ((!c) && (!this.l.get()) && (!b) && (l.f(this)) && (ah.a != null))
    {
      this.l.set(true);
      this.d = true;
      this.h.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("body");
    if (paramJSONObject != null)
    {
      paramJSONObject = c.b(paramJSONObject);
      com.meiqia.core.c.a locala = a.a(this).b();
      if (locala != null)
      {
        paramJSONObject.c(locala.b());
        a.a(this).a(paramJSONObject);
        l.a(this, new Intent("action_agent_status_update_event"));
      }
    }
  }
  
  private void d()
  {
    this.k = true;
    a.a(this).a(null);
    a.a(this).a(false);
    l.a(this, new Intent("action_queueing_remove"));
  }
  
  private void d(JSONObject paramJSONObject)
  {
    if (TextUtils.equals(paramJSONObject.optString("track_id"), this.j))
    {
      a.a(this).a(null);
      l.a(this, new Intent("action_black_add"));
    }
  }
  
  private String e()
  {
    String str1 = "";
    String str2 = System.currentTimeMillis() + "";
    Random localRandom = new Random();
    int m = 0;
    while (m < 5)
    {
      str1 = str1 + localRandom.nextInt(10);
      m += 1;
    }
    return str1 + str2;
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (TextUtils.equals(paramJSONObject.optString("track_id"), this.j)) {
      l.a(this, new Intent("action_black_del"));
    }
  }
  
  private void f()
  {
    a.a(this).a(new ar(this));
  }
  
  private void f(JSONObject paramJSONObject)
  {
    if (this.k)
    {
      paramJSONObject = paramJSONObject.optJSONObject("body");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("agent");
        if (paramJSONObject != null)
        {
          paramJSONObject = c.b(paramJSONObject);
          paramJSONObject.a(true);
          a.a(this).a(paramJSONObject);
          l.a(this, new Intent("action_queueing_init_conv"));
          this.k = false;
        }
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.h = new Handler();
    this.f = new a(null);
    this.e = new j(this);
    this.g = n.a(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.f, localIntentFilter);
    this.h = new Handler(new ao(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      unregisterReceiver(this.f);
      b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (ah.a == null) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (!"ACTION_OPEN_SOCKET".equals(str)) {
        break label106;
      }
      b = false;
      this.d = false;
      if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(ah.a.b())) && (!ah.a.b().equals(this.j))) {
        b();
      }
      a();
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      str = "ACTION_OPEN_SOCKET";
      break;
      label106:
      b();
    }
  }
  
  private class a
    extends BroadcastReceiver
  {
    private boolean b = true;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        if ((l.f(paramContext)) && (!this.b))
        {
          g.b("socket net reconnect");
          MeiQiaService.h(MeiQiaService.this);
        }
        this.b = false;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\MeiQiaService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */