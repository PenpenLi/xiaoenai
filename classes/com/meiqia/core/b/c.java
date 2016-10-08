package com.meiqia.core.b;

import android.text.TextUtils;
import b.aq;
import b.as;
import com.meiqia.core.c.a;
import com.meiqia.core.c.d;
import com.meiqia.core.c.d.a;
import com.meiqia.core.c.d.b;
import com.meiqia.core.c.d.c;
import com.meiqia.core.c.d.d;
import com.meiqia.core.c.d.e;
import com.meiqia.core.c.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static e a(JSONObject paramJSONObject)
  {
    e locale = new e("text");
    long l1 = paramJSONObject.optLong("id");
    long l2 = paramJSONObject.optLong("conversation_id");
    String str5 = paramJSONObject.optString("content_type");
    String str6 = paramJSONObject.optString("content");
    String str7 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("created_on");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramJSONObject.optString("created_at");
    }
    long l3 = k.a(str1);
    String str8 = paramJSONObject.optString("from_type");
    String str9 = paramJSONObject.optString("track_id");
    Object localObject = paramJSONObject.optJSONObject("agent");
    String str3 = "";
    str2 = "";
    str1 = "";
    if (localObject != null)
    {
      str3 = ((JSONObject)localObject).optString("nickname");
      str2 = ((JSONObject)localObject).optString("avatar");
      str1 = ((JSONObject)localObject).optString("token");
    }
    String str10 = paramJSONObject.optString("media_url");
    long l4 = paramJSONObject.optLong("enterprise_id");
    String str4 = paramJSONObject.optString("extra");
    localObject = str4;
    if (TextUtils.equals("bot", str8)) {
      localObject = a(paramJSONObject, str4);
    }
    locale.k((String)localObject);
    locale.c(l4);
    locale.a(str1);
    locale.d(l1);
    locale.a(l2);
    locale.c(str5);
    locale.f(str7);
    locale.b(l3);
    locale.b(str6);
    locale.d(str8);
    locale.e(str9);
    locale.h(str3);
    locale.i(str2);
    locale.j(str10);
    a(locale);
    return locale;
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return "";
    }
    paramString = new StringBuffer();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == 0) {
        paramString.append("?");
      }
      for (;;)
      {
        paramString.append(str).append("=").append((String)paramMap.get(str));
        i += 1;
        break;
        paramString.append("&");
      }
    }
    return paramString.toString();
  }
  
  private static String a(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("content_robot", paramJSONObject.optString("content_robot"));
        localJSONObject.put("sub_type", paramJSONObject.optString("sub_type"));
        localJSONObject.put("question_id", paramJSONObject.optLong("question_id"));
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        continue;
      }
      try
      {
        paramJSONObject = new JSONObject(paramString);
        localJSONObject.put("content", paramJSONObject.optString("content"));
        localJSONObject.put("summary", paramJSONObject.optString("summary"));
        localJSONObject.put("thumbnail", paramJSONObject.optString("thumbnail"));
        return localJSONObject.toString();
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static List<e> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          String str = localJSONObject.optString("action");
          if (("message".equals(str)) || ("ticket_reply".equals(str))) {
            localArrayList.add(a(localJSONObject));
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static JSONArray a(Object paramObject)
  {
    if (!paramObject.getClass().isArray()) {
      throw new JSONException("Not a primitive data: " + paramObject.getClass());
    }
    int j = Array.getLength(paramObject);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(b(Array.get(paramObject, i)));
      i += 1;
    }
    return localJSONArray;
  }
  
  public static JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localJSONArray.put(b(paramCollection.next()));
      }
    }
    return localJSONArray;
  }
  
  public static JSONObject a(aq paramaq)
  {
    try
    {
      paramaq = new JSONObject(b(paramaq));
      return paramaq;
    }
    catch (Exception paramaq)
    {
      JSONObject localJSONObject = new JSONObject();
      g.a("responseToJsonObj : " + paramaq.toString());
      return localJSONObject;
    }
  }
  
  public static JSONObject a(Map<?, ?> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if (str == null) {
        throw new NullPointerException("key == null");
      }
      try
      {
        localJSONObject.put(str, b(localEntry.getValue()));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  public static void a(d paramd, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ticket_config");
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("service_evaluation_config");
    JSONObject localJSONObject3 = paramJSONObject.optJSONObject("robot_settings");
    JSONObject localJSONObject4 = paramJSONObject.optJSONObject("survey");
    paramJSONObject = paramJSONObject.optJSONObject("form");
    if (localJSONObject1 != null)
    {
      paramd.c.d(localJSONObject1.optString("intro"));
      paramd.c.a(localJSONObject1.optString("contactRule"));
      paramd.c.b(localJSONObject1.optString("defaultTemplateContent"));
      paramd.c.c(localJSONObject1.optString("email"));
      paramd.c.e(localJSONObject1.optString("qq"));
      paramd.c.f(localJSONObject1.optString("tel"));
      paramd.c.g(localJSONObject1.optString("wechat"));
    }
    if (localJSONObject2 != null) {
      paramd.b.a(localJSONObject2.optString("prompt_text"));
    }
    if (localJSONObject3 != null) {
      paramd.a.a(localJSONObject3.optBoolean("show_switch"));
    }
    if (localJSONObject4 != null)
    {
      paramd.d.a(localJSONObject4.optBoolean("has_submitted_form"));
      paramd.d.a(localJSONObject4.optString("status"));
    }
    if (paramJSONObject != null) {
      paramd.e.a(paramJSONObject.optString("form_def"));
    }
  }
  
  public static void a(e parame)
  {
    if (parame.s()) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(parame.p());
      parame.m(localJSONObject.optString("content_robot"));
      parame.l(localJSONObject.optString("sub_type"));
      parame.e(localJSONObject.optLong("question_id"));
      if (!e.a.contains(parame.q())) {
        parame.l("unknown");
      }
      return;
    }
    catch (JSONException parame)
    {
      parame.printStackTrace();
    }
  }
  
  public static a b(JSONObject paramJSONObject)
  {
    a locala = new a();
    long l = paramJSONObject.optLong("enterprise_id");
    String str1 = paramJSONObject.optString("avatar");
    String str2 = paramJSONObject.optString("cellphone");
    String str3 = paramJSONObject.optString("nickname");
    String str4 = paramJSONObject.optString("public_cellphone");
    String str5 = paramJSONObject.optString("public_email");
    String str6 = paramJSONObject.optString("qq");
    String str7 = paramJSONObject.optString("signature");
    String str8 = paramJSONObject.optString("telephone");
    String str9 = paramJSONObject.optString("weixin");
    String str10 = paramJSONObject.optString("token");
    String str11 = paramJSONObject.optString("status");
    boolean bool = paramJSONObject.optBoolean("is_online");
    paramJSONObject = paramJSONObject.optString("privilege");
    locala.a(l);
    locala.a(str1);
    locala.b(str2);
    locala.c(str3);
    locala.d(str4);
    locala.e(str5);
    locala.f(str6);
    locala.g(str7);
    locala.i(str8);
    locala.j(str9);
    locala.k(str10);
    locala.h(str11);
    locala.a(bool);
    locala.l(paramJSONObject);
    return locala;
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!(paramObject instanceof JSONObject)) {
          try
          {
            if ((paramObject instanceof Collection)) {
              return a((Collection)paramObject);
            }
            if (paramObject.getClass().isArray()) {
              return a(paramObject);
            }
            if ((paramObject instanceof Map)) {
              return a((Map)paramObject);
            }
            localObject = paramObject;
            if (!(paramObject instanceof Boolean))
            {
              localObject = paramObject;
              if (!(paramObject instanceof Byte))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Character))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Double))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Float))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Integer))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Long))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Short))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof String)) {
                              if (paramObject.getClass().getPackage().getName().startsWith("java."))
                              {
                                paramObject = paramObject.toString();
                                return paramObject;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramObject) {}
        }
      }
    }
    return null;
  }
  
  public static String b(aq paramaq)
  {
    try
    {
      paramaq = new String(paramaq.g().d(), "UTF-8");
      return paramaq;
    }
    catch (Exception paramaq)
    {
      g.a("responseToJsonObj : " + paramaq.toString());
    }
    return null;
  }
  
  public static com.meiqia.core.c.c c(JSONObject paramJSONObject)
  {
    com.meiqia.core.c.c localc = new com.meiqia.core.c.c();
    long l1 = paramJSONObject.optLong("id");
    int i = paramJSONObject.optInt("assignee");
    long l2 = paramJSONObject.optLong("enterprise_id");
    long l3 = k.a(paramJSONObject.optString("created_on"));
    localc.a(i);
    localc.b(l2);
    localc.a(l3);
    localc.c(l1);
    return localc;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */