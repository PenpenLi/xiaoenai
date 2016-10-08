package com.inmobi.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.inmobi.commons.core.configs.c;
import com.inmobi.commons.core.utilities.info.e;
import com.inmobi.rendering.mraid.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class a
{
  private static Set<String> a()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("adcache.db");
    localHashSet.add("appengage.db");
    localHashSet.add("im.db");
    localHashSet.add("ltvp.db");
    localHashSet.add("analytics.db");
    localHashSet.add("com.im.db");
    return localHashSet;
  }
  
  @SuppressLint({"SdCardPath"})
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    List localList = Arrays.asList(new String[] { "carbpreference", "IMAdMLtvpRuleCache", "inmobiAppAnalyticsSession", "aeskeygenerate", "impref", "IMAdTrackerStatusUpload", "IMAdMMediationCache", "inmobiAppAnalyticsAppId", "inmobiAppAnalyticsSession", "inmobisdkaid", "IMAdTrackerStatusUpload", "testAppPref" });
    int i = 0;
    File localFile;
    while (i < localList.size())
    {
      localFile = new File("/data/data/" + paramContext.getPackageName() + "/shared_prefs/" + (String)localList.get(i) + ".xml");
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    localList = Arrays.asList(new String[] { com.inmobi.signals.a.a(), c.a(), com.inmobi.commons.core.utilities.a.a.a(), i.a(), e.a() });
    i = 0;
    while (i < localList.size())
    {
      localFile = new File("/data/data/" + paramContext.getPackageName() + "/shared_prefs/" + (String)localList.get(i) + ".xml");
      if (localFile.exists()) {
        localFile.delete();
      }
      i += 1;
    }
    localList = Arrays.asList(new String[] { "inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp" });
    i = 0;
    while (i < localList.size())
    {
      if (paramContext.getCacheDir() != null)
      {
        localFile = new File(paramContext.getCacheDir(), (String)localList.get(i));
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      i += 1;
    }
    localList = Arrays.asList(new String[] { "eventlog", "imai_click_events" });
    i = 0;
    while (i < localList.size())
    {
      if (paramContext.getDir("data", 0) != null)
      {
        localFile = new File(paramContext.getDir("data", 0), (String)localList.get(i));
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      i += 1;
    }
    if (b(paramContext).size() != 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    File localFile = paramContext.getDatabasePath(paramString);
    return (localFile == null) || (!localFile.exists()) || (paramContext.deleteDatabase(paramString));
  }
  
  public static List<String> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Set localSet = a();
    String[] arrayOfString = paramContext.databaseList();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((localSet.contains(str)) && (!a(paramContext, str))) {
          localArrayList.add(str);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((str.matches("com\\.im_([0-9]+\\.){3}db")) && (!str.equals(com.inmobi.commons.core.b.a.a)) && (!a(paramContext, str))) {
            localArrayList.add(str);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\sdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */