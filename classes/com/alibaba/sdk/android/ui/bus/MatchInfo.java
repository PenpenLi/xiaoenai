package com.alibaba.sdk.android.ui.bus;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class MatchInfo
  implements Serializable
{
  public static final String ALL_MATCH_TYPE = "all";
  public static final String[] HTTP_HTTPS_SCHEMES = { "http", "https" };
  public static final String PATTERN_MATCH_TYPE = "pattern";
  public static final String START_MATCH_TYPE = "start";
  public static final String[] TBOPEN_SCHEMA = { "tbopen" };
  private static final long serialVersionUID = -7326399112028499940L;
  public String name;
  private transient Pattern[] patterns;
  public String[] schemes;
  public String type;
  public String[] values;
  
  public boolean isMatch(UIBusContext paramUIBusContext)
  {
    Object localObject;
    if ((this.schemes != null) && (this.schemes.length > 0))
    {
      localObject = paramUIBusContext.getSchemelessUri();
      paramUIBusContext = paramUIBusContext.getScheme();
      if (paramUIBusContext != null) {}
    }
    label102:
    label211:
    label215:
    label217:
    label261:
    label318:
    for (;;)
    {
      return false;
      String[] arrayOfString = this.schemes;
      int j = arrayOfString.length;
      int i = 0;
      if (i < j) {
        if (!paramUIBusContext.equals(arrayOfString[i])) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label318;
        }
        for (paramUIBusContext = (UIBusContext)localObject;; paramUIBusContext = paramUIBusContext.getUri())
        {
          if (!"all".equals(this.type)) {
            break label102;
          }
          return true;
          i += 1;
          break;
        }
        if (this.values == null)
        {
          i = 1;
          if (this.values.length != 0) {
            break label211;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i | j) != 0) {
            break label215;
          }
          if (!"pattern".equals(this.type)) {
            break label261;
          }
          if (this.patterns != null) {
            break label217;
          }
          this.patterns = new Pattern[this.values.length];
          j = this.patterns.length;
          i = 0;
          while (i < j)
          {
            this.patterns[i] = Pattern.compile(this.values[i]);
            i += 1;
          }
          i = 0;
          break;
        }
        break;
        localObject = this.patterns;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          if (localObject[i].matcher(paramUIBusContext).matches()) {
            return true;
          }
          i += 1;
        }
        break;
        if (!"start".equals(this.type)) {
          break;
        }
        localObject = this.values;
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          if (paramUIBusContext.startsWith(localObject[i])) {
            return true;
          }
          i += 1;
        }
        break;
      }
    }
  }
  
  public JSONObject toJSONObject()
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.name);
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray;
      String[] arrayOfString;
      int k;
      int i;
      if (this.schemes != null)
      {
        localJSONArray = new JSONArray();
        arrayOfString = this.schemes;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          localJSONArray.put(arrayOfString[i]);
          i += 1;
        }
        localJSONObject.put("schemes", localJSONArray);
      }
      if (this.values != null)
      {
        localJSONArray = new JSONArray();
        arrayOfString = this.values;
        k = arrayOfString.length;
        i = j;
        while (i < k)
        {
          localJSONArray.put(arrayOfString[i]);
          i += 1;
        }
        localJSONObject.put("values", localJSONArray);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\MatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */