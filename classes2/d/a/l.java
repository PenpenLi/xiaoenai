package d.a;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class l
{
  private final int a = 128;
  private final int b = 256;
  private final int c = 10;
  private Context d;
  private g e;
  
  public l(Context paramContext)
  {
    if (paramContext == null) {
      throw new RuntimeException("Context is null, can't track event");
    }
    this.d = paramContext.getApplicationContext();
    this.e = g.a(this.d);
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.trim().getBytes().length;
      if ((i > 0) && (i <= 128)) {
        return true;
      }
    }
    ax.d("Event id is empty or too long in tracking Event");
    return false;
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().getBytes().length <= 256) {
      return true;
    }
    ax.d("Event label or value is empty or too long in tracking Event");
    return false;
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((!a(paramString1)) || (!b(paramString2))) {
      return;
    }
    Object localObject = new HashMap();
    if (paramString2 == null) {}
    for (String str = "";; str = paramString2)
    {
      ((Map)localObject).put(paramString1, str);
      localObject = new z.i();
      ((z.i)localObject).c = paramString1;
      ((z.i)localObject).d = System.currentTimeMillis();
      if (paramLong > 0L) {
        ((z.i)localObject).e = paramLong;
      }
      ((z.i)localObject).a = 1;
      Map localMap = ((z.i)localObject).f;
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localMap.put(paramString1, str);
      if (((z.i)localObject).b == null) {
        ((z.i)localObject).b = w.g(this.d);
      }
      this.e.a((n)localObject);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */