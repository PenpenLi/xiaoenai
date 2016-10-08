package com.xiaoenai.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaHelper;
import com.d.a.a.b.a.a;
import com.f.a.b.b;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;
import com.xiaoenai.app.classes.chat.BaseChatActivity;
import com.xiaoenai.app.classes.extentions.anniversary.ad;
import com.xiaoenai.app.classes.store.StickerService;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.g.a.a.a.p;
import com.xiaoenai.app.g.a.a.a.p.a;
import com.xiaoenai.app.g.a.a.a.v;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.service.DownloadService;
import com.xiaoenai.app.service.MessageService;
import com.xiaoenai.app.service.ProtectService;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a.c.a;
import java.io.File;
import java.util.LinkedList;
import java.util.UUID;
import javax.inject.Inject;
import org.cocos2dx.cpp.k;
import org.mzd.socket.SocketJNI;

public class Xiaoenai
  extends BaseApplication
{
  public static boolean F = false;
  private static String L;
  private static String N;
  private static String O;
  private static Xiaoenai R;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static LinkedList<String> u = new LinkedList();
  public static String v;
  public String A = null;
  public String B = null;
  public Integer C = null;
  public String D = "百度";
  public com.xiaoenai.app.classes.chat.messagelist.a E = null;
  @Inject
  protected com.xiaoenai.app.domain.e.c G;
  private com.d.a.a.f M = null;
  private IWeiboShareAPI P;
  private String Q = null;
  private boolean S = false;
  private a T;
  private long U = 0L;
  private boolean V = false;
  private boolean W = true;
  private String X;
  private com.xiaoenai.app.service.h Y;
  public boolean w = false;
  public String x = null;
  public String y = null;
  public String z = null;
  
  static
  {
    N = "http://";
    v = "192.168.1.179";
    O = v;
    R = null;
  }
  
  private void C()
  {
    this.M = new com.d.a.a.f(this, new a.a(this).a(new b(this)).c(1).b(1).d(1).a(120).a());
  }
  
  private void D()
  {
    unregisterReceiver(this.T);
    f();
    startService(new Intent(this, ProtectService.class));
  }
  
  private void E()
  {
    G();
    com.xiaoenai.app.net.a.a.a().b();
    UserConfig.setLong("initate_ts", ak.b());
    if (this.Y == null) {
      this.Y = new com.xiaoenai.app.service.h(this, new d(this));
    }
    if (AppModel.getInstance().isLogined())
    {
      com.xiaoenai.app.classes.chat.messagelist.a.a();
      e();
    }
    try
    {
      ad.c(this);
      this.T = new a();
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.HEADSET_PLUG");
      ((IntentFilter)localObject).addAction("com.xiaoenai.app.GAME_GET_SCHEDULE");
      ((IntentFilter)localObject).addAction("com.xiaoenai.app.GAME_CLEAR_NOTIFICATION");
      registerReceiver(this.T, (IntentFilter)localObject, getString(2131101650), null);
      com.xiaoenai.app.classes.chat.input.faces.d.a();
      com.xiaoenai.app.utils.h.a.a();
      if (as.e("com.xiaoenai.app:daemon") == 0) {
        startService(new Intent(this, ProtectService.class));
      }
      C();
      localObject = WeiboShareSDK.createWeiboAPI(this, "1683793224");
      ((IWeiboShareAPI)localObject).registerApp();
      this.P = ((IWeiboShareAPI)localObject);
      com.f.a.b.a(true);
      com.f.a.b.b(true);
      com.f.a.b.c(false);
      com.f.a.b.a(60000L);
      com.f.a.b.a(new b.b(this, "503899d75270154b560000f4", this.D));
      this.W = ((AudioManager)getSystemService("audio")).isWiredHeadsetOn();
      com.xiaoenai.app.utils.f.a.c("hasHeadSet = {}", new Object[] { Boolean.valueOf(this.W) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void F()
  {
    a(new e(this));
    a(new f(this), 300L);
  }
  
  private void G()
  {
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      this.B = localPackageInfo.versionName;
      this.C = Integer.valueOf(localPackageInfo.versionCode);
      this.x = m();
      this.y = Build.MODEL;
      this.z = Build.VERSION.RELEASE;
      this.A = Build.BRAND.toLowerCase();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void H()
  {
    CrashReport.initCrashReport(this, "900026937", false, (CrashReport.UserStrategy)new CrashReport.UserStrategy(this).setAppChannel(this.D));
  }
  
  public static String a(String paramString)
  {
    if ((paramString != null) && (!paramString.startsWith("http"))) {
      return (String)u.getFirst() + paramString;
    }
    return (String)u.getFirst();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("版本更新 oldCode = {}, oldCode = {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ai.s();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i1 = AppSettings.getInt("config_adhoc_gaptime_get", Integer.valueOf(43200)).intValue();
    long l1 = AppSettings.getInt("config_adhoc_gaptime_send", Integer.valueOf(60)).intValue() * 1000L;
    String str = AppSettings.getString("adhoc_client_id", "");
    com.xiaoenai.app.utils.f.a.c("GapTimeGetFlag = {} s", new Object[] { Integer.valueOf(i1) });
    com.xiaoenai.app.utils.f.a.c("GapTimeSendCacheData = {} ms", new Object[] { Long.valueOf(l1) });
    com.xiaoenai.app.h.a.a.a().a(this, paramString.equals(getResources().getStringArray(2131427329)[0]), str, i1, l1, as.o());
    boolean bool1 = com.xiaoenai.app.h.a.a.a().a(this, "mzd_https_enable", false);
    boolean bool2 = AppSettings.getBoolean("https_toggle", Boolean.valueOf(false)).booleanValue();
    com.xiaoenai.app.utils.f.a.c("adhoc enable_https = {} httpEnable = {}", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (paramString.equals(getResources().getStringArray(2131427329)[0])) {
      if ((bool2) && (bool1)) {
        z().x().a(1);
      }
    }
    try
    {
      System.loadLibrary("mzd");
      System.loadLibrary("locSDK4d");
      com.xiaoenai.app.utils.a.d.a(this);
      com.xiaoenai.app.h.c.a.a().a(this, new g(this));
      if (!paramBoolean) {}
    }
    catch (UnsatisfiedLinkError paramString)
    {
      try
      {
        for (;;)
        {
          SocketJNI.init(this);
          SocketJNI.setSavePidPath(j().getFilesDir().getPath() + File.separator);
          SocketJNI.setExStoragePath(Environment.getExternalStorageDirectory() + File.separator);
          as.p();
          return;
          z().x().a(0);
          continue;
          if (paramString.equals(getResources().getStringArray(2131427329)[3])) {
            if ((bool2) && (bool1)) {
              z().x().a(3);
            } else {
              z().x().a(2);
            }
          }
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = L + paramString;
      }
    }
    return str;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = k + paramString;
      }
    }
    return str;
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.startsWith("http")) {
        str = q + paramString;
      }
    }
    return str;
  }
  
  private void e(String paramString)
  {
    SocketJNI.setSerUrl(d.replaceFirst("http://", "").replaceAll("/", "") + "," + g.replaceFirst("http://", "").replaceAll("/", ""));
  }
  
  private void f(String paramString)
  {
    com.xiaoenai.app.utils.f.b.a(new c.a().a(6).a(new com.xiaoenai.app.g.b.a.d(this.G)).a(false).b(false).a());
    G();
    H();
    a(paramString, true);
    j(paramString);
    e(paramString);
    new h(this).a();
    com.xiaoenai.app.utils.e.d.a(this, as.n());
    AlibabaHelper.initSDK(this, "百度");
    com.xiaoenai.app.h.b.a.a(this);
  }
  
  private void g(String paramString)
  {
    G();
    a(paramString, false);
    j(paramString);
    if (AppModel.getInstance().isLogined()) {
      startService(new Intent(this, MessageService.class));
    }
    AppSettings.setInt("daemon_id", Integer.valueOf(as.e("com.xiaoenai.app:daemon")));
  }
  
  private void h(String paramString)
  {
    try
    {
      System.loadLibrary("locSDK4d");
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void i(String paramString)
  {
    G();
    a(paramString, false);
    j(paramString);
  }
  
  public static Xiaoenai j()
  {
    return R;
  }
  
  private void j(String paramString)
  {
    paramString = getResources().getStringArray(2131427329)[0];
    a = com.xiaoenai.app.net.b.b.a().a(this, "baseURL", paramString);
    b = com.xiaoenai.app.net.b.b.a().a(this, "appsURL", paramString);
    c = com.xiaoenai.app.net.b.b.a().a(this, "notificationURL", paramString);
    d = com.xiaoenai.app.net.b.b.a().a(this, "socketURL", paramString);
    e = com.xiaoenai.app.net.b.b.a().a(this, "forumUrl", paramString);
    L = com.xiaoenai.app.net.b.b.a().a(this, "imageBaseURL", paramString);
    f = com.xiaoenai.app.net.b.b.a().a(this, "voiceBaseURL", paramString);
    g = com.xiaoenai.app.net.b.b.a().a(this, "socketURL2", paramString);
    h = com.xiaoenai.app.net.b.b.a().a(this, "authSdkUrl", paramString);
    i = com.xiaoenai.app.net.b.b.a().a(this, "messageUrl", paramString);
    j = com.xiaoenai.app.net.b.b.a().a(this, "verifyUrl", paramString);
    k = com.xiaoenai.app.net.b.b.a().a(this, "forumImageURL", paramString);
    l = com.xiaoenai.app.net.b.b.a().a(this, "mallImageUploadURL", paramString);
    m = com.xiaoenai.app.net.b.b.a().a(this, "adsURL", paramString);
    n = com.xiaoenai.app.net.b.b.a().a(this, "configURL", paramString);
    com.xiaoenai.app.utils.f.a.c("config host = {}", new Object[] { n });
    o = com.xiaoenai.app.net.b.b.a().a(this, "forumShareURL", paramString);
    p = com.xiaoenai.app.net.b.b.a().a(this, "streetURL", paramString);
    q = com.xiaoenai.app.net.b.b.a().a(this, "streetImageUploadURL", paramString);
    r = com.xiaoenai.app.net.b.b.a().a(this, "statURL", paramString);
    s = com.xiaoenai.app.net.b.b.a().a(this, "gameURL", paramString);
    t = com.xiaoenai.app.net.b.b.a().a(this, "streetGuideURL", paramString);
    u.add("http://upxea.qiniu.com/");
    u.add("http://upxea2.qiniu.com/");
    u.add("http://up.qiniu.com/");
    com.xiaoenai.app.net.b.b.b();
  }
  
  public com.d.a.a.f a()
  {
    return this.M;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.H.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.H.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public void b()
  {
    B();
    this.V = false;
    if (AppModel.getInstance().isLogined())
    {
      this.U = System.currentTimeMillis();
      HomeModeSettings.getHomeMode(this);
    }
    com.xiaoenai.app.stat.c.a().a(101);
    sendBroadcast(new Intent("background_to_foreground"), getString(2131101650));
  }
  
  public void c()
  {
    A();
    this.V = true;
    sendBroadcast(new Intent("background_or_lock_screen"), getString(2131101650));
    a(new c(this));
  }
  
  public boolean d()
  {
    return this.V;
  }
  
  public void e()
  {
    startService(new Intent(this, MessageService.class));
    if (this.Y == null) {
      this.Y = new com.xiaoenai.app.service.h(this, new i(this));
    }
    this.Y.a(MessageService.class);
  }
  
  public void f()
  {
    stopService(new Intent(this, MessageService.class));
    if (this.Y != null) {
      this.Y.a();
    }
  }
  
  public void g()
  {
    stopService(new Intent(this, DownloadService.class));
  }
  
  public void h()
  {
    stopService(new Intent(this, ProtectService.class));
  }
  
  public void i()
  {
    stopService(new Intent(this, StickerService.class));
  }
  
  public Handler k()
  {
    return this.H;
  }
  
  public IWeiboShareAPI l()
  {
    return this.P;
  }
  
  public String m()
  {
    Object localObject = (TelephonyManager)getSystemService("phone");
    String str = "" + ((TelephonyManager)localObject).getDeviceId();
    localObject = "" + ((TelephonyManager)localObject).getSimSerialNumber();
    long l1 = ("" + Settings.Secure.getString(getContentResolver(), "android_id")).hashCode();
    long l2 = str.hashCode();
    return new UUID(l1, ((String)localObject).hashCode() | l2 << 32).toString();
  }
  
  public void n()
  {
    String str = (String)u.getFirst();
    u.removeFirst();
    u.add(str);
  }
  
  public boolean o()
  {
    return this.W;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    as.a(as.k());
  }
  
  public void onCreate()
  {
    R = this;
    this.Q = as.j(this);
    super.onCreate();
    if (this.Q != null)
    {
      if (!this.Q.equals("com.xiaoenai.app")) {
        break label51;
      }
      f(this.X);
      as.a(as.k());
    }
    label51:
    do
    {
      return;
      if (this.Q.equals("com.xiaoenai.app:daemon"))
      {
        g(this.X);
        return;
      }
      if (this.Q.equals("com.xiaoenai.app:lovepet"))
      {
        i(this.X);
        return;
      }
      if (this.Q.equals("com.xiaoenai.app:remote"))
      {
        h(this.X);
        return;
      }
      if (this.Q.equals("com.xiaoenai.app:push"))
      {
        a(this.X, false);
        return;
      }
      if (this.Q.equals("com.xiaoenai.app:pushservice"))
      {
        a(this.X, false);
        return;
      }
    } while (!this.Q.equals("com.xiaoenai.app:hotpatch"));
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    com.xiaoenai.app.utils.f.a.c("onTerminate", new Object[0]);
    String str = as.j(this);
    if (str != null)
    {
      com.xiaoenai.app.utils.f.a.c("terminate:{}", new Object[] { str });
      if (str.equals("com.xiaoenai.app")) {
        D();
      }
      return;
    }
    D();
  }
  
  protected boolean p()
  {
    return false;
  }
  
  public boolean q()
  {
    return this.S;
  }
  
  protected com.xiaoenai.app.common.view.b.a.a r()
  {
    return new com.xiaoenai.app.g.b.a.a(this);
  }
  
  protected com.xiaoenai.app.common.view.b.a.d s()
  {
    return new com.xiaoenai.app.g.b.a.e(this);
  }
  
  protected com.xiaoenai.app.domain.d.a.b t()
  {
    return new j(this);
  }
  
  protected com.xiaoenai.app.data.d.a.e u()
  {
    com.xiaoenai.app.data.d.a.e locale = new com.xiaoenai.app.data.d.a.e();
    if (!TextUtils.isEmpty(this.X))
    {
      if (!this.X.equals(getResources().getStringArray(2131427329)[0])) {
        break label47;
      }
      locale.a(0);
    }
    label47:
    do
    {
      return locale;
      if (this.X.equals(getResources().getStringArray(2131427329)[1]))
      {
        locale.a(1);
        return locale;
      }
      if (this.X.equals(getResources().getStringArray(2131427329)[2]))
      {
        locale.a(4);
        return locale;
      }
      if (this.X.equals(getResources().getStringArray(2131427329)[3]))
      {
        locale.a(2);
        return locale;
      }
      if (this.X.equals(getResources().getStringArray(2131427329)[4]))
      {
        locale.a(3);
        return locale;
      }
    } while (!this.X.equals(getResources().getStringArray(2131427329)[5]));
    locale.a(5);
    return locale;
  }
  
  protected com.xiaoenai.app.data.d.a v()
  {
    com.xiaoenai.app.data.d.a locala = new com.xiaoenai.app.data.d.a();
    locala.a("zh-CN");
    locala.b("android");
    locala.c("5.6.9");
    locala.d("百度");
    locala.a(5690);
    locala.e(Build.MODEL);
    locala.f(Build.VERSION.RELEASE);
    locala.g(m());
    locala.a(as.h());
    locala.a(System.currentTimeMillis());
    locala.h(this.Q);
    return locala;
  }
  
  protected void w()
  {
    this.X = AppSettings.getString("setting_environment", getResources().getStringArray(2131427329)[0]);
    super.w();
    p.a().a(z()).a(new com.xiaoenai.app.g.a.a.b.a()).a().a(this);
  }
  
  protected com.xiaoenai.app.common.application.a.a.a x()
  {
    return new com.xiaoenai.app.g.b.a.b(this);
  }
  
  protected com.xiaoenai.app.common.application.a.a.b y()
  {
    return new com.xiaoenai.app.g.b.a.c(this);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      if (str != null)
      {
        if (!str.equals("android.intent.action.HEADSET_PLUG")) {
          break label122;
        }
        if (paramIntent.hasExtra("state"))
        {
          if (paramIntent.getIntExtra("state", 0) != 0) {
            break label56;
          }
          Xiaoenai.a(Xiaoenai.this, false);
          com.xiaoenai.app.utils.f.a.e("headset not connected", new Object[0]);
        }
      }
      label56:
      label122:
      do
      {
        do
        {
          return;
        } while (paramIntent.getIntExtra("state", 0) != 1);
        Xiaoenai.a(Xiaoenai.this, true);
        paramContext = Xiaoenai.this.z().c().b(BaseChatActivity.class);
        if ((paramContext != null) && ((paramContext instanceof BaseChatActivity))) {
          ((BaseChatActivity)paramContext).k();
        }
        com.xiaoenai.app.utils.f.a.e("headset connected", new Object[0]);
        return;
        if (str.equals("android.intent.action.SCREEN_ON"))
        {
          com.xiaoenai.app.utils.f.a.e("ACTION_SCREEN_ON", new Object[0]);
          return;
        }
        if (str.equals("android.intent.action.SCREEN_OFF"))
        {
          com.xiaoenai.app.utils.f.a.e("ACTION_SCREEN_OFF", new Object[0]);
          Xiaoenai.this.a(true);
          Xiaoenai.this.c();
          return;
        }
        if (str.equals("com.xiaoenai.app.GAME_GET_SCHEDULE"))
        {
          k.a(paramContext, paramIntent.getStringExtra("module_id"));
          return;
        }
        if (str.equals("com.xiaoenai.app.GAME_CLEAR_NOTIFICATION"))
        {
          k.b(paramIntent.getStringExtra("module_id"));
          return;
        }
      } while (!str.equals("com.xiaoenai.app.GAME_REPORT_ERROR"));
      paramIntent.getStringExtra("module_id");
      paramContext = paramIntent.getStringExtra("message");
      com.f.a.b.a(Xiaoenai.this.getApplicationContext(), paramContext);
    }
  }
  
  class b
    extends AsyncTask<Integer, Integer, Integer>
  {
    b() {}
    
    protected Integer a(Integer... paramVarArgs)
    {
      return null;
    }
    
    public void a()
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[] { Integer.valueOf(0) });
        return;
      }
      execute(new Integer[] { Integer.valueOf(0) });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\Xiaoenai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */