package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public final class b
{
  String a;
  String b;
  String c;
  String d;
  String e;
  boolean f;
  boolean g = true;
  boolean h = true;
  String i;
  String j;
  String k;
  JSONObject l;
  
  private b(String paramString)
  {
    this.a = paramString;
  }
  
  private static b a(String paramString, a parama)
  {
    return a(paramString, parama.f(), parama.l(), parama.g(), parama.h(), parama.i(), parama.j(), parama.k(), parama.c(), parama.d(), parama.b(), parama.a());
  }
  
  private static b a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString6, String paramString7, String paramString8, JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    b localb = new b(paramString1);
    localb.a = paramString1;
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = (String)localObject;; paramString1 = paramString2.trim())
    {
      localb.b = paramString1;
      localb.c = paramString3;
      localb.d = paramString4;
      localb.e = paramString5;
      localb.f = paramBoolean1;
      localb.g = paramBoolean2;
      localb.h = paramBoolean3;
      localb.i = paramString6;
      localb.j = paramString7;
      localb.k = paramString8;
      localb.l = paramJSONObject;
      return localb;
    }
  }
  
  private static b a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    boolean bool4 = true;
    if ((paramJSONObject != null) && (paramJSONObject.has("name"))) {}
    for (String str1 = paramJSONObject.optString("name");; str1 = null)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("host"))) {}
      for (String str2 = paramJSONObject.optString("host");; str2 = null)
      {
        if ((paramJSONObject != null) && (paramJSONObject.has("params"))) {}
        for (String str3 = paramJSONObject.optString("params");; str3 = null)
        {
          if ((paramJSONObject != null) && (paramJSONObject.has("enctype"))) {}
          for (String str4 = paramJSONObject.optString("enctype");; str4 = null)
          {
            Object localObject1 = localObject2;
            if (paramJSONObject != null)
            {
              localObject1 = localObject2;
              if (paramJSONObject.has("request_param")) {
                localObject1 = paramJSONObject.optString("request_param");
              }
            }
            if ((paramJSONObject != null) && (paramJSONObject.has("validate"))) {}
            for (boolean bool2 = paramJSONObject.optBoolean("validate", true);; bool2 = true)
            {
              boolean bool1;
              if ((paramJSONObject != null) && (paramJSONObject.has("https"))) {
                if (!paramJSONObject.optBoolean("https")) {
                  bool1 = true;
                }
              }
              for (;;)
              {
                boolean bool3 = bool4;
                if (paramJSONObject != null)
                {
                  bool3 = bool4;
                  if (paramJSONObject.has("formSubmit")) {
                    bool3 = paramJSONObject.optBoolean("formSubmit");
                  }
                }
                Object localObject3 = "";
                localObject2 = localObject3;
                if (paramJSONObject != null)
                {
                  localObject2 = localObject3;
                  if (paramJSONObject.has("namespace")) {
                    localObject2 = paramJSONObject.optString("namespace");
                  }
                }
                Object localObject4 = "";
                localObject3 = localObject4;
                if (paramJSONObject != null)
                {
                  localObject3 = localObject4;
                  if (paramJSONObject.has("apiVersion")) {
                    localObject3 = paramJSONObject.optString("apiVersion");
                  }
                }
                String str5 = "";
                localObject4 = str5;
                if (paramJSONObject != null)
                {
                  localObject4 = str5;
                  if (paramJSONObject.has("apiName")) {
                    localObject4 = paramJSONObject.optString("apiName");
                  }
                }
                return a(str1, str2, str3, str4, (String)localObject1, bool2, bool1, bool3, (String)localObject2, (String)localObject3, (String)localObject4, paramJSONObject);
                bool1 = false;
                continue;
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  public static b a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = null;
    boolean bool4 = true;
    JSONObject localJSONObject = paramJSONObject.optJSONObject(paramString);
    if ((localJSONObject != null) && (localJSONObject.has("name"))) {}
    for (paramJSONObject = localJSONObject.optString("name");; paramJSONObject = null)
    {
      if ((localJSONObject != null) && (localJSONObject.has("host"))) {}
      for (paramString = localJSONObject.optString("host");; paramString = null)
      {
        if ((localJSONObject != null) && (localJSONObject.has("params"))) {}
        for (String str1 = localJSONObject.optString("params");; str1 = null)
        {
          if ((localJSONObject != null) && (localJSONObject.has("enctype"))) {}
          for (String str2 = localJSONObject.optString("enctype");; str2 = null)
          {
            Object localObject1 = localObject2;
            if (localJSONObject != null)
            {
              localObject1 = localObject2;
              if (localJSONObject.has("request_param")) {
                localObject1 = localJSONObject.optString("request_param");
              }
            }
            if ((localJSONObject != null) && (localJSONObject.has("validate"))) {}
            for (boolean bool2 = localJSONObject.optBoolean("validate", true);; bool2 = true)
            {
              boolean bool1;
              if ((localJSONObject != null) && (localJSONObject.has("https"))) {
                if (!localJSONObject.optBoolean("https")) {
                  bool1 = true;
                }
              }
              for (;;)
              {
                boolean bool3 = bool4;
                if (localJSONObject != null)
                {
                  bool3 = bool4;
                  if (localJSONObject.has("formSubmit")) {
                    bool3 = localJSONObject.optBoolean("formSubmit");
                  }
                }
                Object localObject3 = "";
                localObject2 = localObject3;
                if (localJSONObject != null)
                {
                  localObject2 = localObject3;
                  if (localJSONObject.has("namespace")) {
                    localObject2 = localJSONObject.optString("namespace");
                  }
                }
                Object localObject4 = "";
                localObject3 = localObject4;
                if (localJSONObject != null)
                {
                  localObject3 = localObject4;
                  if (localJSONObject.has("apiVersion")) {
                    localObject3 = localJSONObject.optString("apiVersion");
                  }
                }
                String str3 = "";
                localObject4 = str3;
                if (localJSONObject != null)
                {
                  localObject4 = str3;
                  if (localJSONObject.has("apiName")) {
                    localObject4 = localJSONObject.optString("apiName");
                  }
                }
                return a(paramJSONObject, paramString, str1, str2, (String)localObject1, bool2, bool1, bool3, (String)localObject2, (String)localObject3, (String)localObject4, localJSONObject);
                bool1 = false;
                continue;
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  private JSONObject b()
  {
    return this.l;
  }
  
  private String c()
  {
    return this.k;
  }
  
  private String d()
  {
    return this.i;
  }
  
  private String e()
  {
    return this.j;
  }
  
  private String f()
  {
    return this.a;
  }
  
  private String g()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = com.alipay.sdk.cons.a.b;
    }
    return this.b;
  }
  
  private String h()
  {
    return this.c;
  }
  
  private String i()
  {
    return this.d;
  }
  
  private String j()
  {
    return this.e;
  }
  
  private boolean k()
  {
    return this.f;
  }
  
  private boolean l()
  {
    return this.g;
  }
  
  private boolean m()
  {
    return this.h;
  }
  
  public final JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */