package org.cocos2dx.cpp;

import android.util.SparseArray;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.game.GamePushInfo;
import com.xiaoenai.app.utils.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  private static i b = null;
  private SparseArray<ArrayList<GamePushInfo>> a = null;
  private Comparator<GamePushInfo> c = new j(this);
  
  private i()
  {
    this.a.put(0, new ArrayList());
    this.a.put(1, new ArrayList());
    String str2 = UserConfig.getString("game_lovepet", null);
    String str1 = UserConfig.getString("game_wishtree", null);
    if (!ae.a(str2)) {}
    try
    {
      ((ArrayList)this.a.get(0)).addAll(a(new JSONObject(str2)));
      if (ae.a(str1)) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          ((ArrayList)this.a.get(1)).addAll(a(new JSONObject(str1)));
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localException2 = localException2;
        localException2.printStackTrace();
      }
    }
  }
  
  private List<GamePushInfo> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("data");
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new GamePushInfo(paramJSONObject.getJSONObject(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static i a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new i();
      }
      return b;
    }
    finally {}
  }
  
  public List<GamePushInfo> a(String paramString)
  {
    if ("xiaoenai.wishtree.index".equals(paramString))
    {
      paramString = (List)this.a.get(1);
      Collections.sort(paramString, this.c);
      return paramString;
    }
    if ("xiaoenai.lovepet.index".equals(paramString))
    {
      paramString = (List)this.a.get(0);
      Collections.sort(paramString, this.c);
      return paramString;
    }
    return new ArrayList();
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ("xiaoenai.wishtree.index".equals(paramString))
    {
      ((ArrayList)this.a.get(1)).clear();
      ((ArrayList)this.a.get(1)).addAll(a(paramJSONObject));
    }
    while (!"xiaoenai.lovepet.index".equals(paramString)) {
      return;
    }
    ((ArrayList)this.a.get(0)).clear();
    ((ArrayList)this.a.get(0)).addAll(a(paramJSONObject));
  }
  
  public void b()
  {
    UserConfig.remove("game_lovepet");
    UserConfig.remove("game_wishtree");
    ((ArrayList)this.a.get(0)).clear();
    ((ArrayList)this.a.get(1)).clear();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\cpp\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */