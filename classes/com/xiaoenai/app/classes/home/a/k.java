package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import android.content.res.Resources;
import com.xiaoenai.app.classes.home.HomeBottomBar;
import com.xiaoenai.app.classes.home.model.HomeDiscoverBaseItem;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.model.HomeLifeServiceItem;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  private static k a;
  private static List<HomeDiscoverBaseItem> b;
  private static HashMap<String, HomeDiscoverItem> c;
  private static List<HomeDiscoverItem> d;
  private static String e;
  
  /* Error */
  public static k a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	com/xiaoenai/app/classes/home/a/k:a	Lcom/xiaoenai/app/classes/home/a/k;
    //   6: ifnonnull +55 -> 61
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 24	com/xiaoenai/app/classes/home/a/k:a	Lcom/xiaoenai/app/classes/home/a/k;
    //   15: ifnonnull +43 -> 58
    //   18: new 2	com/xiaoenai/app/classes/home/a/k
    //   21: dup
    //   22: invokespecial 25	com/xiaoenai/app/classes/home/a/k:<init>	()V
    //   25: putstatic 24	com/xiaoenai/app/classes/home/a/k:a	Lcom/xiaoenai/app/classes/home/a/k;
    //   28: new 27	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 28	java/util/ArrayList:<init>	()V
    //   35: putstatic 30	com/xiaoenai/app/classes/home/a/k:b	Ljava/util/List;
    //   38: new 32	java/util/HashMap
    //   41: dup
    //   42: invokespecial 33	java/util/HashMap:<init>	()V
    //   45: putstatic 35	com/xiaoenai/app/classes/home/a/k:c	Ljava/util/HashMap;
    //   48: new 27	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 28	java/util/ArrayList:<init>	()V
    //   55: putstatic 37	com/xiaoenai/app/classes/home/a/k:d	Ljava/util/List;
    //   58: ldc 2
    //   60: monitorexit
    //   61: getstatic 24	com/xiaoenai/app/classes/home/a/k:a	Lcom/xiaoenai/app/classes/home/a/k;
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   64	5	0	localk	k
    //   70	5	0	localObject1	Object
    //   76	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	58	70	finally
    //   58	61	70	finally
    //   71	74	70	finally
    //   3	12	76	finally
    //   61	65	76	finally
    //   74	76	76	finally
  }
  
  public static Set a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    if (paramJSONObject != null)
    {
      com.xiaoenai.app.utils.f.a.c("===========parseDiscoverItem====== jsonData = {}", new Object[] { paramJSONObject.toString() });
      Object localObject1;
      if (paramJSONObject.has("discover_list"))
      {
        localObject1 = paramJSONObject.optJSONArray("discover_list");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = new HomeDiscoverBaseItem();
          ((HomeDiscoverBaseItem)localObject2).setType(1);
          localArrayList.add(localObject2);
          localObject2 = ((JSONArray)localObject1).optJSONArray(i);
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            HomeDiscoverItem localHomeDiscoverItem = new HomeDiscoverItem(((JSONArray)localObject2).optJSONObject(j));
            localArrayList.add(localHomeDiscoverItem);
            localHashMap.put(localHomeDiscoverItem.getModule(), localHomeDiscoverItem);
            j += 1;
          }
          i += 1;
        }
      }
      if (paramJSONObject.has("lovers_service"))
      {
        paramJSONObject = paramJSONObject.optJSONObject("lovers_service");
        if ((paramJSONObject != null) && (paramJSONObject.has("service_list")) && (paramJSONObject.has("info")))
        {
          e = paramJSONObject.optString("info");
          paramJSONObject = paramJSONObject.optJSONArray("service_list");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            paramJSONObject = paramJSONObject.toString();
            localObject1 = new HomeLifeServiceItem();
            ((HomeLifeServiceItem)localObject1).setmLifeServiceItemList(paramJSONObject);
            ((HomeLifeServiceItem)localObject1).setType(2);
            localArrayList.add(localObject1);
            localHashMap.put("xiaoenai.discovery.life", localObject1);
          }
        }
      }
      paramJSONObject = new HomeDiscoverBaseItem();
      paramJSONObject.setType(1);
      localArrayList.add(paramJSONObject);
      localHashSet.add(localArrayList);
      localHashSet.add(localHashMap);
    }
    return localHashSet;
  }
  
  private void a(RedHintsInfo paramRedHintsInfo)
  {
    Object localObject = (HomeLifeServiceItem)a("xiaoenai.discovery.life");
    if ((localObject != null) && (((HomeLifeServiceItem)localObject).getmLifeServiceItemList() != null) && (((HomeLifeServiceItem)localObject).getmLifeServiceItemList().size() > 0))
    {
      localObject = ((HomeLifeServiceItem)localObject).getmLifeServiceItemList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        HomeDiscoverItem localHomeDiscoverItem = (HomeDiscoverItem)((Iterator)localObject).next();
        if ((localHomeDiscoverItem != null) && (localHomeDiscoverItem.getModule().equals(paramRedHintsInfo.getModule()))) {
          localHomeDiscoverItem.setRedHintsInfo(paramRedHintsInfo);
        }
      }
    }
  }
  
  private void g()
  {
    Object localObject = (HomeLifeServiceItem)a("xiaoenai.discovery.life");
    if ((localObject != null) && (((HomeLifeServiceItem)localObject).getmLifeServiceItemList() != null) && (((HomeLifeServiceItem)localObject).getmLifeServiceItemList().size() > 0))
    {
      localObject = ((HomeLifeServiceItem)localObject).getmLifeServiceItemList();
      d.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HomeDiscoverItem localHomeDiscoverItem = (HomeDiscoverItem)((Iterator)localObject).next();
        if (localHomeDiscoverItem.getIs_show() == 0) {
          d.add(localHomeDiscoverItem);
        }
      }
    }
  }
  
  public HomeDiscoverBaseItem a(String paramString)
  {
    HomeDiscoverBaseItem localHomeDiscoverBaseItem = null;
    if (c != null) {
      localHomeDiscoverBaseItem = (HomeDiscoverBaseItem)c.get(paramString);
    }
    return localHomeDiscoverBaseItem;
  }
  
  public void a(int paramInt, String paramString, Context paramContext)
  {
    HomeDiscoverItem localHomeDiscoverItem = (HomeDiscoverItem)a().a(paramString);
    if (localHomeDiscoverItem != null)
    {
      paramString = "";
      if (paramInt > 0) {
        paramString = String.format(paramContext.getResources().getString(2131100546), new Object[] { Integer.valueOf(paramInt) });
      }
      localHomeDiscoverItem.setSubTitle(paramString);
    }
  }
  
  public void a(HomeBottomBar paramHomeBottomBar)
  {
    boolean bool = false;
    if ((b == null) || (b.size() == 0)) {
      b();
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(c.values());
    Object localObject2 = (HomeLifeServiceItem)a("xiaoenai.discovery.life");
    if ((localObject2 != null) && (((HomeLifeServiceItem)localObject2).getmLifeServiceItemList().size() > 0)) {
      ((List)localObject1).addAll(((HomeLifeServiceItem)localObject2).getmLifeServiceItemList());
    }
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HomeDiscoverBaseItem)((Iterator)localObject1).next();
      if (!(localObject2 instanceof HomeDiscoverItem)) {
        break label253;
      }
      localObject2 = ((HomeDiscoverItem)localObject2).getRedHintsInfo();
      if (localObject2 == null) {
        break label253;
      }
      if ((((RedHintsInfo)localObject2).getChildren().size() > 0) && (((RedHintsInfo)localObject2).getChildShowCount() > 0))
      {
        if (1 != ((RedHintsInfo)localObject2).getStyle()) {
          break label247;
        }
        j = ((RedHintsInfo)localObject2).getChildNumSum();
        bool = true;
        i += j;
      }
    }
    label247:
    label253:
    for (;;)
    {
      break;
      if (((RedHintsInfo)localObject2).isShow()) {
        if ((1 == ((RedHintsInfo)localObject2).getStyle()) && (((RedHintsInfo)localObject2).getValue() != null) && (((RedHintsInfo)localObject2).getValue().length() > 0))
        {
          j = Integer.valueOf(((RedHintsInfo)localObject2).getValue()).intValue();
          bool = true;
          i += j;
          continue;
          if (paramHomeBottomBar != null) {
            paramHomeBottomBar.b(i, bool);
          }
        }
        else
        {
          bool = true;
        }
      }
    }
  }
  
  public void a(Set<Object> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() == 2))
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        Object localObject = paramSet.next();
        if ((localObject instanceof List))
        {
          b = (List)localObject;
        }
        else if ((localObject instanceof HashMap))
        {
          c = (HashMap)localObject;
          g();
        }
      }
      d();
    }
  }
  
  public List<HomeDiscoverBaseItem> b()
  {
    if ((b == null) || (b.size() == 0))
    {
      JSONObject localJSONObject = e();
      if ((localJSONObject != null) && (localJSONObject.optBoolean("success")) && (localJSONObject.has("data"))) {
        a(a(localJSONObject.optJSONObject("data")));
      }
    }
    return b;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      AppSettings.setString("discovery_list_data_v1", paramJSONObject.toString());
      return;
    }
    AppSettings.remove("discovery_list_data_v1");
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    if (c != null) {
      bool = c.containsKey(paramString);
    }
    return bool;
  }
  
  public List<HomeDiscoverItem> c()
  {
    return d;
  }
  
  public void d()
  {
    List localList = com.xiaoenai.app.widget.remindButton.a.a().b("xiaoenai.discovery");
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        RedHintsInfo localRedHintsInfo = (RedHintsInfo)localList.get(i);
        HomeDiscoverItem localHomeDiscoverItem = (HomeDiscoverItem)a(localRedHintsInfo.getModule());
        if ((localHomeDiscoverItem != null) && (localHomeDiscoverItem.getModule().equals(localRedHintsInfo.getModule()))) {
          localHomeDiscoverItem.setRedHintsInfo(localRedHintsInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          a(localRedHintsInfo);
        }
      }
    }
  }
  
  public JSONObject e()
  {
    try
    {
      Object localObject = AppSettings.getString("discovery_list_data_v1", null);
      if (!ae.a((String)localObject))
      {
        localObject = new JSONObject((String)localObject);
        return (JSONObject)localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String f()
  {
    return e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */