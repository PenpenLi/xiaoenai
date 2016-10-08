package com.inmobi.rendering.a;

import android.content.ContentValues;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
{
  public static final String[] a = { "id", "pending_attempts", "url", "ping_in_webview", "follow_redirect", "ts", "created_ts" };
  private static final String b = b.class.getSimpleName();
  
  public b()
  {
    com.inmobi.commons.core.b.b localb = com.inmobi.commons.core.b.b.a();
    localb.a("click", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, ping_in_webview TEXT NOT NULL, follow_redirect TEXT NOT NULL, ts TEXT NOT NULL, created_ts TEXT NOT NULL)");
    localb.b();
  }
  
  public a a(ContentValues paramContentValues)
  {
    int i = paramContentValues.getAsInteger("id").intValue();
    int j = paramContentValues.getAsInteger("pending_attempts").intValue();
    String str = paramContentValues.getAsString("url");
    long l1 = Long.valueOf(paramContentValues.getAsString("ts")).longValue();
    long l2 = Long.valueOf(paramContentValues.getAsString("created_ts")).longValue();
    return new a(i, str, Boolean.valueOf(paramContentValues.getAsString("follow_redirect")).booleanValue(), Boolean.valueOf(paramContentValues.getAsString("ping_in_webview")).booleanValue(), j, l1, l2);
  }
  
  public List<a> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    com.inmobi.commons.core.b.b localb = com.inmobi.commons.core.b.b.a();
    if (localb.a("click") == 0) {
      return localArrayList;
    }
    if (-1 == paramInt1) {}
    for (Object localObject = null;; localObject = Integer.toString(paramInt1))
    {
      localObject = localb.a("click", a, null, null, "ts", "ts < " + (System.currentTimeMillis() - paramInt2), "ts ASC ", (String)localObject);
      localb.b();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(a((ContentValues)((Iterator)localObject).next()));
      }
    }
    return localArrayList;
  }
  
  public void a(a parama)
  {
    com.inmobi.commons.core.b.b localb = com.inmobi.commons.core.b.b.a();
    int i = parama.a;
    localb.b("click", c(parama), "id = ?", new String[] { String.valueOf(i) });
    localb.b();
  }
  
  public boolean a()
  {
    return com.inmobi.commons.core.b.b.a().a("click") == 0;
  }
  
  public boolean a(a parama, int paramInt)
  {
    try
    {
      parama = c(parama);
      com.inmobi.commons.core.b.b localb = com.inmobi.commons.core.b.b.a();
      if (localb.a("click") >= paramInt)
      {
        Object localObject = new HashMap();
        ((Map)localObject).put("errorCode", "MaxDbLimitBreach");
        com.inmobi.commons.core.c.a.a().a("ads", "PingDiscarded", (Map)localObject);
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Pruning persistent store to remove the oldest entry ...");
        localObject = a((ContentValues)localb.a("click", a, "ts= (SELECT MIN(ts) FROM click LIMIT 1)", null, null, null, null, null).get(0));
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Deleting click (" + ((a)localObject).a + ")");
        b((a)localObject);
      }
      localb.a("click", parama);
      localb.b();
      return true;
    }
    finally {}
  }
  
  public void b(a parama)
  {
    com.inmobi.commons.core.b.b localb = com.inmobi.commons.core.b.b.a();
    localb.a("click", "id = ?", new String[] { String.valueOf(parama.a) });
    localb.b();
  }
  
  public ContentValues c(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", Integer.valueOf(parama.a));
    localContentValues.put("url", parama.b);
    localContentValues.put("pending_attempts", Integer.valueOf(parama.f));
    localContentValues.put("ts", Long.toString(parama.d));
    localContentValues.put("created_ts", Long.toString(parama.e));
    localContentValues.put("follow_redirect", Boolean.toString(parama.i));
    localContentValues.put("ping_in_webview", Boolean.toString(parama.h));
    return localContentValues;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */