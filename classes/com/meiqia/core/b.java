package com.meiqia.core;

import android.content.Context;
import com.meiqia.core.c.a;
import com.meiqia.core.c.e;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static b a;
  private Map<String, e> b = new HashMap();
  private String c = "";
  private a d;
  
  private b(Context paramContext) {}
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext);
    }
    return a;
  }
  
  public a a()
  {
    return this.d;
  }
  
  public e a(String paramString)
  {
    e locale = (e)this.b.get(paramString);
    if ((this.c != null) && (!this.c.equals(paramString))) {
      this.b.remove(this.c);
    }
    this.c = paramString;
    return locale;
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  protected void a(e parame)
  {
    this.b.put(parame.h() + "", parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */