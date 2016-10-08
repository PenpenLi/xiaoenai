package com.alibaba.sdk.android.ui.bus;

import android.text.TextUtils;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.SortUtils.SortInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchableInfo
  extends SortUtils.SortInfo
{
  private static final long serialVersionUID = -3028143812046625177L;
  public LinkedHashMap<String, MatchInfo> matchInfos = new LinkedHashMap();
  
  private String toCommaSeparatorString(String[] paramArrayOfString)
  {
    boolean bool = false;
    if (paramArrayOfString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if (bool) {
        localStringBuilder.append(bool);
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i += 1;
        break;
        bool = true;
      }
    }
    return localStringBuilder.toString();
  }
  
  protected void mergeMatchInfos(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("matches");
    int k;
    int i;
    if (paramJSONObject != null)
    {
      k = paramJSONObject.length();
      i = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        MatchInfo localMatchInfo;
        try
        {
          Object localObject1 = paramJSONObject.getJSONObject(i);
          String str = ((JSONObject)localObject1).optString("name");
          if (((JSONObject)localObject1).optBoolean("disabled", false))
          {
            this.matchInfos.remove(str);
            break label272;
          }
          localMatchInfo = new MatchInfo();
          localMatchInfo.name = str;
          localMatchInfo.type = ((JSONObject)localObject1).optString("type");
          Object localObject2 = ((JSONObject)localObject1).optString("value");
          String[] arrayOfString;
          int j;
          if (localObject2 == null)
          {
            localObject2 = ((JSONObject)localObject1).optJSONArray("values");
            if (localObject2 != null)
            {
              arrayOfString = new String[((JSONArray)localObject2).length()];
              j = ((JSONArray)localObject2).length() - 1;
              while (j >= 0)
              {
                arrayOfString[j] = ((JSONArray)localObject2).optString(j);
                j -= 1;
              }
            }
          }
          for (localMatchInfo.values = arrayOfString;; localMatchInfo.values = new String[] { localObject2 })
          {
            localObject1 = ((JSONObject)localObject1).optJSONArray("schemes");
            if (localObject1 == null) {
              break label258;
            }
            localObject2 = new String[((JSONArray)localObject1).length()];
            j = ((JSONArray)localObject1).length() - 1;
            while (j >= 0)
            {
              localObject2[j] = ((JSONArray)localObject1).optString(j);
              j -= 1;
            }
          }
          localMatchInfo.schemes = ((String[])localObject2);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        label258:
        this.matchInfos.put(localJSONException, localMatchInfo);
      }
      else
      {
        return;
      }
      label272:
      i += 1;
    }
  }
  
  protected void mergeOrderInfo(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("order");
    if (paramJSONObject == null) {
      return;
    }
    this.before = null;
    this.after = null;
    this.beforeAll = null;
    this.afterAll = null;
    String str = paramJSONObject.optString("before");
    if (!TextUtils.isEmpty(str)) {
      this.before = str.split("[,]");
    }
    str = paramJSONObject.optString("after");
    if (!TextUtils.isEmpty(str)) {
      this.after = str.split("[,]");
    }
    this.beforeAll = Boolean.valueOf(paramJSONObject.optBoolean("beforeAll", false));
    this.afterAll = Boolean.valueOf(paramJSONObject.optBoolean("afterAll", false));
  }
  
  protected JSONArray toMatchInfoJSONArray()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.matchInfos.values().iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = ((MatchInfo)localIterator.next()).toJSONObject();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      return localException;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("ui", localException);
      return null;
    }
  }
  
  protected JSONObject toOrderJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.afterAll != null) {
        localJSONObject.put("afterAll", this.afterAll);
      }
      if (this.beforeAll != null) {
        localJSONObject.put("beforeAll", this.beforeAll);
      }
      if (this.before != null) {
        localJSONObject.put("before", toCommaSeparatorString(this.before));
      }
      if (this.after != null) {
        localJSONObject.put("after", toCommaSeparatorString(this.after));
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("ui", localException);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\MatchableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */