package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.p;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;

public class UTHitBuilders
{
  public static class UTControlHitBuilder
    extends UTHitBuilders.UTHitBuilder
  {
    public UTControlHitBuilder(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Control name can not be empty.");
      }
      String str = UTPageHitHelper.getInstance().getCurrentPageName();
      if (TextUtils.isEmpty(str)) {
        throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
      }
      paramString = str + "_" + paramString;
      super.setProperty("_field_page", str);
      super.setProperty("_field_event_id", "2101");
      super.setProperty("_field_arg1", paramString);
    }
    
    public UTControlHitBuilder(String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("Control name can not be empty.");
      }
      if (TextUtils.isEmpty(paramString1)) {
        throw new IllegalArgumentException("Page name can not be empty.");
      }
      paramString2 = paramString1 + "_" + paramString2;
      super.setProperty("_field_page", paramString1);
      super.setProperty("_field_event_id", "2101");
      super.setProperty("_field_arg1", paramString2);
    }
  }
  
  public static class UTCustomHitBuilder
    extends UTHitBuilders.UTHitBuilder
  {
    public UTCustomHitBuilder(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        super.setProperty("_field_arg1", paramString);
      }
      super.setProperty("_field_event_id", "19999");
      super.setProperty("_field_arg3", "0");
    }
    
    public Map<String, String> build()
    {
      Map localMap = super.build();
      if (localMap != null)
      {
        String str1 = (String)localMap.get(LogField.PAGE.toString());
        String str2 = (String)localMap.get(LogField.ARG1.toString());
        if (str2 != null)
        {
          localMap.remove(LogField.ARG1.toString());
          localMap.remove(LogField.PAGE.toString());
          localMap = p.b(localMap);
          localMap.put(LogField.ARG1.toString(), str2);
          localMap.put(LogField.PAGE.toString(), str1);
          return localMap;
        }
      }
      return localMap;
    }
    
    public UTCustomHitBuilder setDurationOnEvent(long paramLong)
    {
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      super.setProperty("_field_arg3", "" + l);
      return this;
    }
    
    public UTCustomHitBuilder setEventPage(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        super.setProperty("_field_page", paramString);
      }
      return this;
    }
  }
  
  public static class UTHitBuilder
  {
    public static final String FIELD_ARG1 = "_field_arg1";
    public static final String FIELD_ARG2 = "_field_arg2";
    public static final String FIELD_ARG3 = "_field_arg3";
    public static final String FIELD_ARGS = "_field_args";
    public static final String FIELD_EVENT_ID = "_field_event_id";
    public static final String FIELD_PAGE = "_field_page";
    private Map<String, String> u = new HashMap();
    
    public UTHitBuilder()
    {
      if (!this.u.containsKey("_field_page")) {
        this.u.put("_field_page", "UT");
      }
    }
    
    private static boolean a(Map<String, String> paramMap)
    {
      if (paramMap != null)
      {
        if (paramMap.containsKey(null)) {
          paramMap.remove(null);
        }
        if (paramMap.containsKey("")) {
          paramMap.remove("");
        }
        if (paramMap.containsKey(LogField.PAGE.toString()))
        {
          i.a("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
          return false;
        }
        if (paramMap.containsKey(LogField.EVENTID.toString()))
        {
          i.a("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
          return false;
        }
        if (paramMap.containsKey(LogField.ARG1.toString()))
        {
          i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
          return false;
        }
        if (paramMap.containsKey(LogField.ARG2.toString()))
        {
          i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
          return false;
        }
        if (paramMap.containsKey(LogField.ARG3.toString()))
        {
          i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
          return false;
        }
      }
      return true;
    }
    
    private static void f(Map<String, String> paramMap)
    {
      if (paramMap != null)
      {
        String str;
        if (paramMap.containsKey("_field_page"))
        {
          str = (String)paramMap.get("_field_page");
          paramMap.remove("_field_page");
          paramMap.put(LogField.PAGE.toString(), str);
        }
        if (paramMap.containsKey("_field_arg1"))
        {
          str = (String)paramMap.get("_field_arg1");
          paramMap.remove("_field_arg1");
          paramMap.put(LogField.ARG1.toString(), str);
        }
        if (paramMap.containsKey("_field_arg2"))
        {
          str = (String)paramMap.get("_field_arg2");
          paramMap.remove("_field_arg2");
          paramMap.put(LogField.ARG2.toString(), str);
        }
        if (paramMap.containsKey("_field_arg3"))
        {
          str = (String)paramMap.get("_field_arg3");
          paramMap.remove("_field_arg3");
          paramMap.put(LogField.ARG3.toString(), str);
        }
        if (paramMap.containsKey("_field_args"))
        {
          str = (String)paramMap.get("_field_args");
          paramMap.remove("_field_args");
          paramMap.put(LogField.ARGS.toString(), str);
        }
        if (paramMap.containsKey("_field_event_id"))
        {
          str = (String)paramMap.get("_field_event_id");
          paramMap.remove("_field_event_id");
          paramMap.put(LogField.EVENTID.toString(), str);
        }
      }
    }
    
    private static void g(Map<String, String> paramMap)
    {
      if (paramMap != null)
      {
        if (paramMap.containsKey(LogField.PAGE.toString())) {
          paramMap.remove(LogField.PAGE.toString());
        }
        if (paramMap.containsKey(LogField.EVENTID.toString())) {
          paramMap.remove(LogField.EVENTID.toString());
        }
        if (paramMap.containsKey(LogField.ARG1.toString())) {
          paramMap.remove(LogField.ARG1.toString());
        }
        if (paramMap.containsKey(LogField.ARG2.toString())) {
          paramMap.remove(LogField.ARG2.toString());
        }
        if (paramMap.containsKey(LogField.ARG3.toString())) {
          paramMap.remove(LogField.ARG3.toString());
        }
        if (paramMap.containsKey(LogField.ARGS.toString())) {
          paramMap.remove(LogField.ARGS.toString());
        }
      }
    }
    
    public Map<String, String> build()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.u);
      if (!a(localHashMap)) {}
      do
      {
        return null;
        g(localHashMap);
        f(localHashMap);
      } while (!localHashMap.containsKey(LogField.EVENTID.toString()));
      return localHashMap;
    }
    
    public String getProperty(String paramString)
    {
      if ((paramString != null) && (this.u.containsKey(paramString))) {
        return (String)this.u.get(paramString);
      }
      return null;
    }
    
    public UTHitBuilder setProperties(Map<String, String> paramMap)
    {
      if (paramMap != null) {
        this.u.putAll(paramMap);
      }
      return this;
    }
    
    public UTHitBuilder setProperty(String paramString1, String paramString2)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null))
      {
        if (this.u.containsKey(paramString1)) {
          this.u.remove(paramString1);
        }
        this.u.put(paramString1, paramString2);
        return this;
      }
      i.a("setProperty", "key is null or key is empty or value is null,please check it!");
      return this;
    }
  }
  
  public static class UTPageHitBuilder
    extends UTHitBuilders.UTHitBuilder
  {
    public UTPageHitBuilder(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        super.setProperty("_field_page", paramString);
      }
      super.setProperty("_field_event_id", "2001");
      super.setProperty("_field_arg3", "0");
    }
    
    public UTPageHitBuilder setDurationOnPage(long paramLong)
    {
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      super.setProperty("_field_arg3", "" + l);
      return this;
    }
    
    public UTPageHitBuilder setReferPage(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        super.setProperty("_field_arg1", paramString);
      }
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\UTHitBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */