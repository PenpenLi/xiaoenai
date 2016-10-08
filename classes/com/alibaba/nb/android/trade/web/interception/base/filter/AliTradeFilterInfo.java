package com.alibaba.nb.android.trade.web.interception.base.filter;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.web.interception.base.filter.a.c;
import com.alibaba.nb.android.trade.web.interception.base.filter.a.d;
import com.alibaba.nb.android.trade.web.interception.base.filter.a.e;
import com.alibaba.nb.android.trade.web.interception.base.filter.a.f;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeMatchableInfo;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliTradeFilterInfo
  extends AliTradeMatchableInfo
  implements Serializable
{
  private static final long serialVersionUID = -1324924959146054653L;
  public LinkedHashMap<String, ActionInfo> actionInfos = new LinkedHashMap();
  public boolean procceed = true;
  public int[] scenarios;
  public String[] scopes;
  public String type;
  
  public a createFilter()
  {
    if (TextUtils.isEmpty(this.type)) {
      return new f(this);
    }
    Class localClass = com.alibaba.nb.android.trade.utils.f.a.a(this.type);
    if (localClass == null) {
      throw new IllegalStateException("Fail to load the filter class with name " + this.name + " type = " + this.type);
    }
    return (a)com.alibaba.nb.android.trade.utils.f.a.a(localClass, new Class[] { AliTradeFilterInfo.class }, new Object[] { this });
  }
  
  public void merge(JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optString("type");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.type = ((String)localObject1);
    }
    localObject1 = paramJSONObject.optString("scopes");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.scopes = ((String)localObject1).split(",");
    }
    localObject1 = paramJSONObject.optString("scenarios");
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("[,]");
      this.scenarios = new int[localObject1.length];
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        this.scenarios[i] = Integer.parseInt(localObject1[i].trim());
        i += 1;
      }
    }
    if ("stop".equals(paramJSONObject.optString("procceed"))) {
      this.procceed = false;
    }
    for (;;)
    {
      mergeMatchInfos(paramJSONObject);
      mergeOrderInfo(paramJSONObject);
      localObject1 = paramJSONObject.optJSONArray("actions");
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        label161:
        if (i < j)
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          try
          {
            String str1 = ((JSONObject)localObject2).getString("name");
            str2 = ((JSONObject)localObject2).getString("type");
            if (((JSONObject)localObject2).optBoolean("disabled", false))
            {
              this.actionInfos.remove(str1);
              i += 1;
              break label161;
              this.procceed = true;
            }
            else
            {
              localHashMap = new HashMap();
              localObject2 = ((JSONObject)localObject2).optJSONObject("params");
              if (localObject2 != null)
              {
                Iterator localIterator = ((JSONObject)localObject2).keys();
                while (localIterator.hasNext())
                {
                  String str3 = (String)localIterator.next();
                  localHashMap.put(str3, ((JSONObject)localObject2).optString(str3));
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              String str2;
              HashMap localHashMap;
              com.alibaba.nb.android.trade.utils.d.a.a("ui", "fail to merge filter info " + paramJSONObject + " , the error message is " + localException.getMessage(), localException);
              continue;
              localObject2 = new ActionInfo();
              ((ActionInfo)localObject2).name = localException;
              ((ActionInfo)localObject2).type = str2;
              ((ActionInfo)localObject2).parameters = localHashMap;
              this.actionInfos.put(localException, localObject2);
            }
          }
        }
      }
    }
  }
  
  public JSONObject toJSONObject()
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", this.name);
      localJSONObject1.put("type", this.type);
      int k;
      int i;
      if (this.scenarios != null)
      {
        localObject1 = new JSONArray();
        localObject2 = this.scenarios;
        k = localObject2.length;
        i = 0;
        while (i < k)
        {
          ((JSONArray)localObject1).put(localObject2[i]);
          i += 1;
        }
        localJSONObject1.put("scenarios", localObject1);
      }
      if (this.scopes != null)
      {
        localObject1 = new JSONArray();
        localObject2 = this.scopes;
        k = localObject2.length;
        i = j;
        while (i < k)
        {
          ((JSONArray)localObject1).put(localObject2[i]);
          i += 1;
        }
        localJSONObject1.put("scopes", localObject1);
      }
      if (!this.procceed) {
        localJSONObject1.put("procceed", "stop");
      }
      localObject1 = new JSONArray();
      Object localObject2 = this.actionInfos.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JSONObject localJSONObject2 = ((ActionInfo)((Iterator)localObject2).next()).toJSONObject();
        if (localJSONObject2 != null) {
          ((JSONArray)localObject1).put(localJSONObject2);
        }
      }
      localException.put("actions", localObject1);
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("ui", localException);
      return null;
    }
    Object localObject1 = toMatchInfoJSONArray();
    if (localObject1 != null) {
      localException.put("matches", localObject1);
    }
    localObject1 = toOrderJSONObject();
    if (localObject1 != null) {
      localException.put("order", localObject1);
    }
    return localException;
  }
  
  public static class ActionInfo
    implements Serializable
  {
    public static final String INVOKE_SERVICE = "invokeService";
    public static final String REPLACE_ALL = "replaceAll";
    public static final String SET_CONTEXT_ATTRIBUTE = "setContextAttribute";
    public static final String UPDATE_PARAMETER = "updateParameter";
    public static final String UT_LOGGER = "utLogger";
    private static final long serialVersionUID = 2930551562797715432L;
    public String name;
    public Map<String, String> parameters = new HashMap();
    public String type;
    
    public b createAction()
    {
      if ("utLogger".equals(this.type)) {
        return new com.alibaba.nb.android.trade.web.interception.base.filter.a.b(this);
      }
      if ("updateParameter".equals(this.type)) {
        return new e(this);
      }
      if ("replaceAll".equals(this.type)) {
        return new c(this);
      }
      if ("setContextAttribute".equals(this.type)) {
        return new d(this);
      }
      if ("invokeService".equals(this.type)) {
        return new com.alibaba.nb.android.trade.web.interception.base.filter.a.a(this);
      }
      for (;;)
      {
        try
        {
          localObject = com.alibaba.nb.android.trade.utils.f.a.a(this.type, new String[] { ActionInfo.class.getName() }, new Object[] { this });
          if ((localObject instanceof b)) {
            return (b)localObject;
          }
          StringBuilder localStringBuilder = new StringBuilder("the create filterAction is of type ");
          if (localObject == null) {
            continue;
          }
          localObject = localObject.getClass().getName();
          com.alibaba.nb.android.trade.utils.d.a.d("ui", (String)localObject);
        }
        catch (Exception localException)
        {
          Object localObject;
          com.alibaba.nb.android.trade.utils.d.a.a("ui", "fail to create filterAction with type " + this.type, localException);
          continue;
        }
        return null;
        localObject = null;
      }
    }
    
    public JSONObject toJSONObject()
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("name", this.name);
        localJSONObject1.put("type", this.type);
        if (this.parameters != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          Iterator localIterator = this.parameters.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
          }
          localException.put("params", localJSONObject2);
        }
      }
      catch (Exception localException)
      {
        com.alibaba.nb.android.trade.utils.d.a.a("ui", localException);
        return null;
      }
      return localException;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\AliTradeFilterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */