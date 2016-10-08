package com.xiaoenai.app.annotation.json;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

public class b<T>
{
  private String a(String paramString)
  {
    paramString = paramString.substring(0, 1).toUpperCase() + paramString.substring(1, paramString.length());
    return "set" + paramString;
  }
  
  private String b(String paramString)
  {
    paramString = paramString.substring(0, 1).toUpperCase() + paramString.substring(1, paramString.length());
    return "get" + paramString;
  }
  
  private String c(String paramString)
  {
    paramString = paramString.substring(0, 1).toUpperCase() + paramString.substring(1, paramString.length());
    return "is" + paramString;
  }
  
  public JSONObject a(T paramT, Class paramClass)
  {
    JSONObject localJSONObject = new JSONObject();
    a(paramT, paramClass, localJSONObject);
    return localJSONObject;
  }
  
  public JSONObject a(T paramT, Class paramClass, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (paramT != null)
    {
      paramJSONObject = (JsonParser)paramClass.getAnnotation(JsonParser.class);
      HashMap localHashMap = new HashMap();
      paramClass = paramClass.getMethods();
      int j = paramClass.length;
      int i = 0;
      String str1;
      if (i < j)
      {
        localObject = paramClass[i];
        str1 = ((Method)localObject).getName();
        if ((str1.startsWith("get")) || (str1.startsWith("is"))) {
          localHashMap.put(str1, localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          if (str1.endsWith("TransformerToJson")) {
            localHashMap.put(str1, localObject);
          }
        }
      }
      Object localObject = paramJSONObject.a();
      j = localObject.length;
      i = 0;
      if (i < j)
      {
        paramClass = localObject[i];
        String str2 = paramClass.a();
        str1 = paramClass.b();
        paramClass = (Method)localHashMap.get(str2 + "TransformerToJson");
        if (paramClass != null) {}
        for (paramClass = paramClass.invoke(paramT, new Object[0]);; paramClass = paramClass.invoke(paramT, new Object[0]))
        {
          localJSONObject.put(str1, paramClass);
          i += 1;
          break;
          paramJSONObject = (Method)localHashMap.get(b(str2));
          paramClass = paramJSONObject;
          if (paramJSONObject == null) {
            paramClass = (Method)localHashMap.get(c(str2));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public void a(Class paramClass, JSONObject paramJSONObject, T paramT)
  {
    if (paramJSONObject == null) {
      return;
    }
    Object localObject1 = (JsonParser)paramClass.getAnnotation(JsonParser.class);
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (i < j)
    {
      localObject2 = paramClass[i];
      localObject3 = ((Method)localObject2).getName();
      if (((String)localObject3).startsWith("set")) {
        localHashMap.put(localObject3, localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject3).endsWith("JsonTransformer")) {
          localHashMap.put(localObject3, localObject2);
        }
      }
    }
    paramClass = ((JsonParser)localObject1).a();
    j = paramClass.length;
    i = 0;
    label124:
    if (i < j)
    {
      localObject1 = paramClass[i];
      localObject2 = ((JsonElement)localObject1).a();
      localObject3 = ((JsonElement)localObject1).b();
      localObject1 = paramJSONObject.opt((String)localObject3);
      Method localMethod = (Method)localHashMap.get((String)localObject2 + "JsonTransformer");
      if (localMethod == null) {
        break label260;
      }
      if ((localObject1 != null) && (!paramJSONObject.isNull((String)localObject3)) && ((!localObject1.equals("null")) || (!localObject1.toString().equals("null")))) {
        localMethod.invoke(paramT, new Object[] { localObject1 });
      }
    }
    for (;;)
    {
      i += 1;
      break label124;
      break;
      label260:
      localObject2 = (Method)localHashMap.get(a((String)localObject2));
      if ((localObject1 != null) && (!paramJSONObject.isNull((String)localObject3)) && ((!localObject1.equals("null")) || (!localObject1.toString().equals("null"))))
      {
        localObject3 = ((Method)localObject2).getParameterTypes();
        if ((Long.TYPE.getName() == localObject3[0].getName()) && ((localObject1 instanceof Integer))) {
          ((Method)localObject2).invoke(paramT, new Object[] { Long.valueOf(Long.parseLong(localObject1.toString())) });
        } else {
          ((Method)localObject2).invoke(paramT, new Object[] { localObject1 });
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\annotation\json\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */