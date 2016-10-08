package com.alibaba.nb.android.trade.web.interception.base.handler;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliTradeHandlerInfo
  extends AliTradeMatchableInfo
  implements Serializable
{
  private static final long serialVersionUID = -776500659898673151L;
  public String action;
  public Map<String, String> actionParameters = new HashMap();
  public int[] scenarios;
  public String[] scopes;
  public String type;
  public boolean uiThread;
  
  public AliTradeHandler createHandler()
  {
    if (TextUtils.isEmpty(this.type)) {
      return new com.alibaba.nb.android.trade.web.interception.base.handler.a.a(this);
    }
    Class localClass = com.alibaba.nb.android.trade.utils.f.a.a(this.type);
    if (localClass == null) {
      throw new IllegalStateException("Fail to load the handler class with name " + this.name + " type = " + this.type);
    }
    return (AliTradeHandler)com.alibaba.nb.android.trade.utils.f.a.a(localClass, new Class[] { AliTradeHandlerInfo.class }, new Object[] { this });
  }
  
  public void merge(JSONObject paramJSONObject)
  {
    mergeMatchInfos(paramJSONObject);
    mergeOrderInfo(paramJSONObject);
    Object localObject = paramJSONObject.optString("scopes");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.scopes = ((String)localObject).split(",");
    }
    localObject = paramJSONObject.optString("scenarios");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("[,]");
      this.scenarios = new int[localObject.length];
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        this.scenarios[i] = Integer.parseInt(localObject[i].trim());
        i += 1;
      }
    }
    this.uiThread = paramJSONObject.optBoolean("uiThread", false);
    paramJSONObject = paramJSONObject.optJSONObject("action");
    if (paramJSONObject != null) {
      try
      {
        this.action = paramJSONObject.getString("type");
        paramJSONObject = paramJSONObject.getJSONObject("params");
        localObject = paramJSONObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.actionParameters.put(str, paramJSONObject.optString(str));
        }
        return;
      }
      catch (Exception paramJSONObject) {}
    }
  }
  
  public JSONObject toJSONObject()
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", this.name);
      localJSONObject.put("type", this.type);
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
        localJSONObject.put("scenarios", localObject1);
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
        localJSONObject.put("scopes", localObject1);
      }
      if (this.action != null) {
        localJSONObject.put("action", this.action);
      }
      localJSONObject.put("uiThread", this.uiThread);
      Object localObject1 = new JSONObject();
      Object localObject2 = this.actionParameters.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue());
      }
      localJSONObject.put("params", localObject1);
      localObject1 = toMatchInfoJSONArray();
      if (localObject1 != null) {
        localJSONObject.put("matches", localObject1);
      }
      localObject1 = toOrderJSONObject();
      if (localObject1 != null) {
        localJSONObject.put("order", localObject1);
      }
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\AliTradeHandlerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */