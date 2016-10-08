package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.f.a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cn
{
  private static Context i;
  private ck a = null;
  private da b = null;
  private dc c = null;
  private boolean d = false;
  private boolean e = false;
  private long f = 0L;
  private final String g = "main_fest_mode";
  private final String h = "main_fest_timestamp";
  private List<String> j = new ArrayList();
  private a k = null;
  private final Thread l = new Thread(new co(this));
  
  private cn()
  {
    if (i != null)
    {
      if (this.a == null) {
        this.a = new ck();
      }
      if (this.b == null) {
        this.b = da.a(i);
      }
      if (this.c == null) {
        this.c = new dc();
      }
    }
    this.l.start();
  }
  
  public static final cn a(Context paramContext)
  {
    i = paramContext;
    return b.a();
  }
  
  private void e()
  {
    long l1 = System.currentTimeMillis();
    this.k.sendEmptyMessageDelayed(48, dd.b(l1));
    this.k.sendEmptyMessageDelayed(49, dd.c(l1));
  }
  
  private void f()
  {
    SharedPreferences.Editor localEditor = t.a(i).edit();
    localEditor.putBoolean("main_fest_mode", false);
    localEditor.putLong("main_fest_timestamp", 0L);
    localEditor.commit();
    this.e = false;
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = t.a(i);
    this.e = localSharedPreferences.getBoolean("main_fest_mode", false);
    this.f = localSharedPreferences.getLong("main_fest_timestamp", 0L);
  }
  
  private void h()
  {
    Iterator localIterator = this.a.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)((Map.Entry)localIterator.next()).getKey();
      if (!this.j.contains(localList)) {
        this.j.add(cd.a(localList));
      }
    }
    if (this.j.size() > 0) {
      this.b.a(new cj(), this.j);
    }
  }
  
  private void i()
  {
    try
    {
      if (this.a.a().size() > 0) {
        this.b.c(new cs(this), this.a.a());
      }
      if (this.c.a().size() > 0) {
        this.b.b(new ct(this), this.c.a());
      }
      if (this.j.size() > 0) {
        this.b.a(new cj(), this.j);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ax.a("converyMemoryToDataTable happen error: " + localThrowable.toString());
    }
  }
  
  private void j()
  {
    try
    {
      if (this.a.a().size() > 0) {
        this.b.a(new cu(this), this.a.a());
      }
      if (this.c.a().size() > 0) {
        this.b.b(new cv(this), this.c.a());
      }
      if (this.j.size() > 0) {
        this.b.a(new cj(), this.j);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ax.a("convertMemoryToCacheTable happen error: " + localThrowable.toString());
    }
  }
  
  private void k()
  {
    List localList = this.b.b();
    if (localList != null) {
      this.j = localList;
    }
  }
  
  public void a()
  {
    j();
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    this.b.a(new cr(this), paramString, paramLong1, paramLong2);
  }
  
  public void a(cj paramcj)
  {
    if (this.d) {
      return;
    }
    m.b(new cw(this, paramcj));
  }
  
  public void a(z paramz)
  {
    if (paramz.b.h != null)
    {
      paramz.b.h.a = b(new cj());
      paramz.b.h.b = c(new cj());
    }
  }
  
  public Map<String, List<z.d>> b(cj paramcj)
  {
    paramcj = this.b.a();
    HashMap localHashMap = new HashMap();
    if ((paramcj == null) || (paramcj.size() <= 0)) {
      return null;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramcj.containsKey(str)) {
        localHashMap.put(str, paramcj.get(str));
      }
    }
    return localHashMap;
  }
  
  public void b()
  {
    j();
  }
  
  public Map<String, List<z.e>> c(cj paramcj)
  {
    if (this.c.a().size() > 0) {
      this.b.b(new cp(this), this.c.a());
    }
    return this.b.b(new cj());
  }
  
  public void c()
  {
    j();
  }
  
  public void d(cj paramcj)
  {
    boolean bool = false;
    if (this.e)
    {
      if (this.f == 0L) {
        g();
      }
      bool = dd.a(System.currentTimeMillis(), this.f);
    }
    if (!bool)
    {
      f();
      this.j.clear();
    }
    this.c.b();
    this.b.a(new cq(this), bool);
  }
  
  private static class a
    extends Handler
  {
    private final WeakReference<cn> a;
    
    public a(cn paramcn)
    {
      this.a = new WeakReference(paramcn);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.a != null) {}
      switch (paramMessage.what)
      {
      default: 
        return;
      case 48: 
        sendEmptyMessageDelayed(48, dd.b(System.currentTimeMillis()));
        cn.c(cn.a(cn.d()));
        return;
      }
      sendEmptyMessageDelayed(49, dd.c(System.currentTimeMillis()));
      cn.d(cn.a(cn.d()));
    }
  }
  
  private static class b
  {
    private static final cn a = new cn(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */