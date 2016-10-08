package com.alibaba.nb.android.trade.web.interception.base.handler;

import com.alibaba.nb.android.trade.utils.d.a;
import com.alibaba.nb.android.trade.web.interception.base.c;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliTradeMatchInfo
  implements Serializable
{
  public static final String ALL_MATCH_TYPE = "all";
  public static final String[] HTTP_HTTPS_SCHEMES = { "http", "https" };
  public static final String PATTERN_MATCH_TYPE = "pattern";
  public static final String START_MATCH_TYPE = "start";
  private static final long serialVersionUID = -7326399112028499940L;
  public String name;
  private transient Pattern[] patterns;
  public String[] schemes;
  public String type;
  public String[] values;
  
  public boolean isMatch(c paramc)
  {
    Object localObject;
    String str;
    if ((this.schemes != null) && (this.schemes.length > 0))
    {
      localObject = paramc.getSchemelessUri();
      str = paramc.getScheme();
      if (str != null) {}
    }
    label103:
    label212:
    label216:
    label218:
    label265:
    label322:
    for (;;)
    {
      return false;
      String[] arrayOfString = this.schemes;
      int j = arrayOfString.length;
      int i = 0;
      if (i < j) {
        if (!str.equals(arrayOfString[i])) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label322;
        }
        for (;;)
        {
          if (!"all".equals(this.type)) {
            break label103;
          }
          return true;
          i += 1;
          break;
          localObject = paramc.getUri();
        }
        if (this.values == null)
        {
          i = 1;
          if (this.values.length != 0) {
            break label212;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i | j) != 0) {
            break label216;
          }
          if (!"pattern".equals(this.type)) {
            break label265;
          }
          if (this.patterns != null) {
            break label218;
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
          if (localObject[i].matcher(paramc.getUri()).matches()) {
            return true;
          }
          i += 1;
        }
        break;
        if (!"start".equals(this.type)) {
          break;
        }
        paramc = this.values;
        j = paramc.length;
        i = 0;
        while (i < j)
        {
          if (((String)localObject).startsWith(paramc[i])) {
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
      a.a("ui", localException);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\AliTradeMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */