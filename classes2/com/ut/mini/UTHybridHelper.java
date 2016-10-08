package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UTHybridHelper
{
  private static UTHybridHelper a = new UTHybridHelper();
  
  private void a(Date paramDate, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    String str1 = b((String)paramMap.get("urlpagename"), (String)paramMap.get("url"));
    if ((str1 == null) || (TextUtils.isEmpty(str1)))
    {
      i.a("h5Ctrl", new String[] { "pageName is null,return" });
      return;
    }
    String str2 = (String)paramMap.get("logkey");
    if ((str2 == null) || (TextUtils.isEmpty(str2)))
    {
      i.a("h5Ctrl", new String[] { "logkey is null,return" });
      return;
    }
    paramDate = (String)paramMap.get("utjstype");
    paramMap.remove("utjstype");
    if ((paramDate == null) || (paramDate.equals("0"))) {
      paramDate = e(paramMap);
    }
    for (;;)
    {
      paramDate = new UTOriginalCustomHitBuilder(str1, 2101, str2, null, null, paramDate);
      paramMap = UTAnalytics.getInstance().getDefaultTracker();
      if (paramMap != null)
      {
        paramMap.send(paramDate.build());
        return;
        if (paramDate.equals("1")) {
          paramDate = f(paramMap);
        }
      }
      else
      {
        i.a("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
        return;
      }
      paramDate = null;
    }
  }
  
  private void a(Date paramDate, Map<String, String> paramMap, Object paramObject)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    String str1 = b((String)paramMap.get("urlpagename"), (String)paramMap.get("url"));
    if ((str1 == null) || (TextUtils.isEmpty(str1)))
    {
      i.a("h5Page", "pageName is null,return");
      return;
    }
    String str2 = UTMIVariables.getInstance().getRefPage();
    paramDate = (String)paramMap.get("utjstype");
    paramMap.remove("utjstype");
    if ((paramDate == null) || (paramDate.equals("0"))) {
      paramDate = c(paramMap);
    }
    for (;;)
    {
      int i = 2006;
      if (UTPageHitHelper.getInstance().a(paramObject)) {
        i = 2001;
      }
      paramDate = new UTOriginalCustomHitBuilder(str1, i, str2, null, null, paramDate);
      if (2001 == i) {
        UTMIVariables.getInstance().setRefPage(str1);
      }
      paramMap = UTPageHitHelper.getInstance().b();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        paramDate.setProperties(paramMap);
      }
      paramMap = UTAnalytics.getInstance().getDefaultTracker();
      if (paramMap != null) {
        paramMap.send(paramDate.build());
      }
      for (;;)
      {
        UTPageHitHelper.getInstance().a(paramObject);
        return;
        if (!paramDate.equals("1")) {
          break label245;
        }
        paramDate = d(paramMap);
        break;
        i.a("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
      }
      label245:
      paramDate = null;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1))) {
      return paramString1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = paramString2.indexOf("?");
      if (i == -1) {
        return paramString2;
      }
      return paramString2.substring(0, i);
    }
    return "";
  }
  
  private Map<String, String> c(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    String str = (String)paramMap.get("url");
    Object localObject;
    if (str == null)
    {
      localObject = "";
      localHashMap.put("_h5url", localObject);
      if (str == null) {
        break label296;
      }
      localObject = Uri.parse(str);
      str = ((Uri)localObject).getQueryParameter("spm");
      if ((str == null) || (TextUtils.isEmpty(str))) {
        break label283;
      }
      localHashMap.put("spm", str);
      label88:
      localObject = ((Uri)localObject).getQueryParameter("scm");
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        localHashMap.put("scm", localObject);
      }
    }
    for (;;)
    {
      str = (String)paramMap.get("spmcnt");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("_spmcnt", localObject);
      str = (String)paramMap.get("spmpre");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("_spmpre", localObject);
      str = (String)paramMap.get("lzsid");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("_lzsid", localObject);
      str = (String)paramMap.get("extendargs");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("_h5ea", localObject);
      localObject = (String)paramMap.get("cna");
      paramMap = (Map<String, String>)localObject;
      if (localObject == null) {
        paramMap = "";
      }
      localHashMap.put("_cna", paramMap);
      localHashMap.put("_ish5", "1");
      return localHashMap;
      localObject = str;
      break;
      label283:
      localHashMap.put("spm", "0.0.0.0");
      break label88;
      label296:
      localHashMap.put("spm", "0.0.0.0");
    }
  }
  
  private Map<String, String> d(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    String str2 = (String)paramMap.get("url");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("_h5url", str1);
    str1 = (String)paramMap.get("extendargs");
    paramMap = str1;
    if (str1 == null) {
      paramMap = "";
    }
    localHashMap.put("_h5ea", paramMap);
    localHashMap.put("_ish5", "1");
    return localHashMap;
  }
  
  private Map<String, String> e(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    String str2 = (String)paramMap.get("logkeyargs");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("_lka", str1);
    str2 = (String)paramMap.get("cna");
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localHashMap.put("_cna", str1);
    str1 = (String)paramMap.get("extendargs");
    paramMap = str1;
    if (str1 == null) {
      paramMap = "";
    }
    localHashMap.put("_h5ea", paramMap);
    localHashMap.put("_ish5", "1");
    return localHashMap;
  }
  
  private Map<String, String> f(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    String str = (String)paramMap.get("extendargs");
    paramMap = str;
    if (str == null) {
      paramMap = "";
    }
    localHashMap.put("_h5ea", paramMap);
    localHashMap.put("_ish5", "1");
    return localHashMap;
  }
  
  public static UTHybridHelper getInstance()
  {
    return a;
  }
  
  public void h5UT(Map<String, String> paramMap, Object paramObject)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      i.a("h5UT", "dataMap is empty");
    }
    String str;
    Object localObject;
    do
    {
      return;
      str = (String)paramMap.get("functype");
      if (str == null)
      {
        i.a("h5UT", "funcType is null");
        return;
      }
      localObject = (String)paramMap.get("utjstype");
      if ((localObject != null) && (!((String)localObject).equals("0")) && (!((String)localObject).equals("1")))
      {
        i.a("h5UT", "utjstype should be 1 or 0 or null");
        return;
      }
      paramMap.remove("functype");
      localObject = new Date();
      if (str.equals("2001"))
      {
        a((Date)localObject, paramMap, paramObject);
        return;
      }
    } while (!str.equals("2101"));
    a((Date)localObject, paramMap);
  }
  
  public void setH5Url(String paramString)
  {
    if (paramString != null) {
      UTMIVariables.getInstance().setH5Url(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\UTHybridHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */