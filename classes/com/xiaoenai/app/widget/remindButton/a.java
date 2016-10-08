package com.xiaoenai.app.widget.remindButton;

import com.google.gson.j;
import com.xiaoenai.app.classes.common.c.a.d;
import com.xiaoenai.app.classes.common.c.a.e;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.model.UserConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static a a;
  private HashMap<String, RedHintsInfo> b = new HashMap();
  private com.xiaoenai.app.d.ae c = new com.xiaoenai.app.d.ae();
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  public static HashMap<String, RedHintsInfo> a(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      com.xiaoenai.app.utils.f.a.c("===========parserRedHints======  jsonData = {}", new Object[] { paramJSONArray.toString() });
      int i = 0;
      while (i < paramJSONArray.length())
      {
        a(localHashMap, paramJSONArray.optJSONObject(i));
        a(localHashMap, (RedHintsInfo)localHashMap.get("xiaoenai.discovery"), "xiaoenai.discovery.game");
        a(localHashMap, (RedHintsInfo)localHashMap.get("xiaoenai.mine"), "xiaoenai.mine.face");
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a(RedHintsInfo paramRedHintsInfo)
  {
    if (new com.xiaoenai.app.d.ae().a(paramRedHintsInfo.getModule() + "_" + paramRedHintsInfo.getId()) == paramRedHintsInfo.getId()) {
      paramRedHintsInfo.setIsShow(false);
    }
  }
  
  private static void a(HashMap<String, RedHintsInfo> paramHashMap, RedHintsInfo paramRedHintsInfo, String paramString)
  {
    if ((paramRedHintsInfo != null) && (paramRedHintsInfo.getChildren() != null) && (paramRedHintsInfo.getChildren().size() > 0))
    {
      paramRedHintsInfo = paramRedHintsInfo.getChildren().iterator();
      while (paramRedHintsInfo.hasNext())
      {
        RedHintsInfo localRedHintsInfo = (RedHintsInfo)paramRedHintsInfo.next();
        if (paramString.equals(localRedHintsInfo.getModule())) {
          paramHashMap.put(localRedHintsInfo.getModule(), localRedHintsInfo);
        }
      }
    }
  }
  
  private static void a(HashMap<String, RedHintsInfo> paramHashMap, JSONObject paramJSONObject)
  {
    j localj = new j();
    if (paramJSONObject != null)
    {
      paramJSONObject = (RedHintsInfo)localj.a(paramJSONObject.toString(), RedHintsInfo.class);
      a(paramJSONObject);
      c(paramJSONObject);
      paramHashMap.put(paramJSONObject.getModule(), paramJSONObject);
    }
  }
  
  private boolean a(RemindButton paramRemindButton, int paramInt, String paramString, Boolean paramBoolean)
  {
    if (paramRemindButton != null)
    {
      if (paramBoolean.booleanValue())
      {
        if (paramInt == 0) {
          paramRemindButton.a();
        }
        do
        {
          return true;
          if (paramInt == 2)
          {
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramRemindButton.a(paramString);
              return true;
            }
            paramRemindButton.a();
            return true;
          }
        } while ((paramInt != 1) || (paramString == null) || (paramString.length() <= 0));
        paramRemindButton.a(Integer.parseInt(paramString));
        return true;
      }
      paramRemindButton.b();
    }
    return false;
  }
  
  public static void b()
  {
    if (a != null)
    {
      a.c();
      a = null;
    }
  }
  
  private static void c(RedHintsInfo paramRedHintsInfo)
  {
    if ((paramRedHintsInfo.getChildren() != null) && (paramRedHintsInfo.getChildren().size() > 0))
    {
      Iterator localIterator = paramRedHintsInfo.getChildren().iterator();
      while (localIterator.hasNext())
      {
        RedHintsInfo localRedHintsInfo = (RedHintsInfo)localIterator.next();
        a(localRedHintsInfo);
        c(localRedHintsInfo);
        localRedHintsInfo.setParentNode(paramRedHintsInfo);
        if (localRedHintsInfo.isShow()) {
          paramRedHintsInfo.addChildNodeCount(localRedHintsInfo);
        }
      }
    }
  }
  
  private List<RedHintsInfo> d(String paramString)
  {
    Object localObject = new ArrayList();
    if ("discovery".equalsIgnoreCase(paramString)) {
      localObject = e("xiaoenai.discovery");
    }
    do
    {
      return (List<RedHintsInfo>)localObject;
      if ("mine".equalsIgnoreCase(paramString)) {
        return e("xiaoenai.mine");
      }
      if ("game".equalsIgnoreCase(paramString)) {
        return e("xiaoenai.discovery.game");
      }
    } while (!"face".equalsIgnoreCase(paramString));
    return e("xiaoenai.mine.face");
  }
  
  private List<RedHintsInfo> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (this.b != null)
    {
      localObject = localArrayList;
      if (this.b.get(paramString) != null) {
        localObject = ((RedHintsInfo)this.b.get(paramString)).getChildren();
      }
    }
    return (List<RedHintsInfo>)localObject;
  }
  
  private RedHintsInfo f(String paramString)
  {
    Object localObject2 = null;
    RedHintsInfo localRedHintsInfo = null;
    List localList = d(new e(paramString).a().b);
    Object localObject1 = localObject2;
    int i;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0)
      {
        i = 0;
        localObject1 = localRedHintsInfo;
        if (i < localList.size())
        {
          if (!((RedHintsInfo)localList.get(i)).getModule().equalsIgnoreCase(paramString)) {
            break label109;
          }
          localRedHintsInfo = (RedHintsInfo)localList.get(i);
        }
      }
    }
    label109:
    for (;;)
    {
      i += 1;
      break;
      return (RedHintsInfo)localObject1;
    }
  }
  
  public RedHintsInfo a(String paramString)
  {
    if (this.b != null) {
      return (RedHintsInfo)this.b.get(paramString);
    }
    return null;
  }
  
  public void a(RemindButton paramRemindButton, RedHintsInfo paramRedHintsInfo)
  {
    String str2 = paramRedHintsInfo.getValue();
    String str1 = str2;
    if (paramRedHintsInfo.getChildren().size() > 0)
    {
      str1 = str2;
      if (1 == paramRedHintsInfo.getStyle()) {
        str1 = String.valueOf(paramRedHintsInfo.getChildNumSum());
      }
    }
    a(paramRemindButton, paramRedHintsInfo.getStyle(), str1, Boolean.valueOf(paramRedHintsInfo.isShow()));
  }
  
  public void a(HashMap<String, RedHintsInfo> paramHashMap)
  {
    if (paramHashMap != null)
    {
      this.b = paramHashMap;
      return;
    }
    this.b = new HashMap();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      UserConfig.setString("redhints_data", paramJSONObject.toString());
      return;
    }
    UserConfig.remove("redhints_data");
  }
  
  public List<RedHintsInfo> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = localArrayList;
    if (this.b != null)
    {
      localObject = localArrayList;
      if (this.b.size() > 0)
      {
        localObject = localArrayList;
        if (this.b.containsKey(paramString)) {
          localObject = ((RedHintsInfo)this.b.get(paramString)).getChildren();
        }
      }
    }
    return (List<RedHintsInfo>)localObject;
  }
  
  public void b(RedHintsInfo paramRedHintsInfo)
  {
    if ((paramRedHintsInfo != null) && (paramRedHintsInfo.getChildren().size() == 0) && (paramRedHintsInfo.isShow()))
    {
      paramRedHintsInfo.minusChildNodeCount(paramRedHintsInfo);
      this.c.a(paramRedHintsInfo);
    }
  }
  
  public void c()
  {
    this.c = null;
    this.b = null;
  }
  
  public void c(String paramString)
  {
    paramString = f(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  public JSONObject d()
  {
    try
    {
      Object localObject = UserConfig.getString("redhints_data", null);
      if (!com.xiaoenai.app.utils.ae.a((String)localObject))
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\remindButton\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */