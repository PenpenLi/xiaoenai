package com.inmobi.commons.core.c;

import android.content.ContentValues;
import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static final String a = d.class.getSimpleName();
  
  public d()
  {
    b localb = b.a();
    localb.a("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
    localb.a("metric", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL )");
    localb.b();
  }
  
  private void b(List<ContentValues> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    b localb = b.a();
    String str = "";
    int i = 0;
    while (i < paramList.size() - 1)
    {
      str = str + ((ContentValues)paramList.get(i)).getAsString("id") + ",";
      i += 1;
    }
    paramList = str + ((ContentValues)paramList.get(paramList.size() - 1)).getAsString("id");
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Deleting events with id: " + paramList);
    i = localb.a("telemetry", "id IN (" + paramList + ")", null);
    localb.b();
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Deleted Count: " + i);
  }
  
  public List<ContentValues> a()
  {
    b localb = b.a();
    List localList = localb.a("metric", null, null, null, null, null, null, null);
    localb.b();
    b();
    return localList;
  }
  
  public List<e> a(int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Querying db for events");
    Object localObject = b.a();
    List localList = ((b)localObject).a("telemetry", null, null, null, null, null, "ts ASC", String.valueOf(paramInt));
    b(localList);
    ArrayList localArrayList = new ArrayList();
    ((b)localObject).b();
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(e.a((ContentValues)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void a(e parame)
  {
    b localb = b.a();
    localb.a("telemetry", parame.e());
    localb.b();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    b localb = b.a();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("componentType", paramString1);
    localContentValues.put("eventType", paramString2);
    localContentValues.put("payload", paramString3);
    localb.a("metric", localContentValues);
    localb.b();
  }
  
  public void a(List<e> paramList)
  {
    b localb = b.a();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localb.a("telemetry", ((e)paramList.next()).e());
    }
    localb.b();
  }
  
  public void b()
  {
    b localb = b.a();
    localb.a("metric", null, null);
    localb.b();
  }
  
  public int c()
  {
    b localb = b.a();
    int i = localb.a("telemetry");
    localb.b();
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */