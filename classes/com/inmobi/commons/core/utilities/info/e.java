package com.inmobi.commons.core.utilities.info;

import android.location.Location;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.b.c;
import java.util.HashMap;
import java.util.Locale;

public class e
{
  private static int a = Integer.MIN_VALUE;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static int h = Integer.MIN_VALUE;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static int m = Integer.MIN_VALUE;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static Location s;
  
  public static String a()
  {
    return c.a("user_info_store");
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      str1 = str2;
      if (paramString1.trim().length() != 0) {
        str1 = paramString1.trim();
      }
    }
    paramString1 = str1;
    if (paramString2 != null)
    {
      paramString1 = str1;
      if (paramString2.trim().length() != 0) {
        paramString1 = str1 + "-" + paramString2.trim();
      }
    }
    paramString2 = paramString1;
    if (paramString3 != null)
    {
      paramString2 = paramString1;
      if (paramString3.trim().length() != 0) {
        paramString2 = paramString1 + "-" + paramString3.trim();
      }
    }
    return paramString2;
  }
  
  public static void a(int paramInt)
  {
    if ((a.a()) && (paramInt != Integer.MIN_VALUE))
    {
      c.b("user_info_store").a("user_age", paramInt);
      return;
    }
    a = paramInt;
  }
  
  public static void a(Location paramLocation)
  {
    if ((a.a()) && (paramLocation != null))
    {
      paramLocation = b(paramLocation);
      c.b("user_info_store").a("user_location", paramLocation);
      return;
    }
    s = paramLocation;
  }
  
  public static void a(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_age_group", paramString);
      return;
    }
    b = paramString;
  }
  
  private static String b(Location paramLocation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocation.getLatitude());
    localStringBuilder.append(",");
    localStringBuilder.append(paramLocation.getLongitude());
    localStringBuilder.append(",");
    localStringBuilder.append((int)paramLocation.getAccuracy());
    localStringBuilder.append(",");
    localStringBuilder.append(paramLocation.getTime());
    return localStringBuilder.toString();
  }
  
  public static void b()
  {
    a(a);
    a(b);
    b(c);
    c(d);
    d(e);
    e(f);
    f(g);
    b(h);
    g(i);
    h(j);
    i(k);
    j(l);
    c(m);
    k(n);
    l(o);
    m(p);
    n(q);
    e(r);
    a(s);
  }
  
  public static void b(int paramInt)
  {
    if ((a.a()) && (paramInt != Integer.MIN_VALUE))
    {
      c.b("user_info_store").a("user_yob", paramInt);
      return;
    }
    h = paramInt;
  }
  
  public static void b(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_area_code", paramString);
      return;
    }
    c = paramString;
  }
  
  public static String c()
  {
    if (d != null) {
      return d;
    }
    return c.b("user_info_store").b("user_post_code", null);
  }
  
  public static void c(int paramInt)
  {
    if ((a.a()) && (paramInt != Integer.MIN_VALUE))
    {
      c.b("user_info_store").a("user_income", paramInt);
      return;
    }
    m = paramInt;
  }
  
  public static void c(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_post_code", paramString);
      return;
    }
    d = paramString;
  }
  
  public static String d()
  {
    if (q != null) {
      return q;
    }
    return c.b("user_info_store").b("user_login_id", null);
  }
  
  public static void d(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_city_code", paramString);
      return;
    }
    e = paramString;
  }
  
  public static String e()
  {
    if (r != null) {
      return r;
    }
    return c.b("user_info_store").b("user_session_id", null);
  }
  
  public static void e(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_state_code", paramString);
      return;
    }
    f = paramString;
  }
  
  public static Location f()
  {
    Location localLocation = null;
    if (s != null) {
      localLocation = s;
    }
    Object localObject3;
    do
    {
      return localLocation;
      localObject3 = c.b("user_info_store").b("user_location", null);
    } while (localObject3 == null);
    localLocation = new Location("");
    try
    {
      localObject3 = ((String)localObject3).split(",");
      localLocation.setLatitude(Double.parseDouble(localObject3[0]));
      localLocation.setLongitude(Double.parseDouble(localObject3[1]));
      localLocation.setAccuracy(Float.parseFloat(localObject3[2]));
      localLocation.setTime(Long.parseLong(localObject3[3]));
      return localLocation;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        Object localObject1 = null;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        localArrayIndexOutOfBoundsException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public static void f(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_country_code", paramString);
      return;
    }
    g = paramString;
  }
  
  public static HashMap<String, String> g()
  {
    HashMap localHashMap = new HashMap();
    int i1 = h();
    if ((i1 != Integer.MIN_VALUE) && (i1 > 0)) {
      localHashMap.put("u-age", String.valueOf(i1));
    }
    i1 = n();
    if ((i1 != Integer.MIN_VALUE) && (i1 > 0)) {
      localHashMap.put("u-yearofbirth", String.valueOf(i1));
    }
    i1 = s();
    if ((i1 != Integer.MIN_VALUE) && (i1 > 0)) {
      localHashMap.put("u-income", String.valueOf(i1));
    }
    String str = a(k(), l(), m());
    if ((str != null) && (str.trim().length() != 0)) {
      localHashMap.put("u-location", str);
    }
    str = i();
    if (str != null) {
      localHashMap.put("u-agegroup", str.toString().toLowerCase(Locale.ENGLISH));
    }
    str = j();
    if (str != null) {
      localHashMap.put("u-areacode", str);
    }
    str = c();
    if (str != null) {
      localHashMap.put("u-postalcode", str);
    }
    str = o();
    if (str != null) {
      localHashMap.put("u-gender", str);
    }
    str = p();
    if (str != null) {
      localHashMap.put("u-ethnicity", str);
    }
    str = q();
    if (str != null) {
      localHashMap.put("u-education", str);
    }
    str = r();
    if (str != null) {
      localHashMap.put("u-language", str);
    }
    str = t();
    if (str != null) {
      localHashMap.put("u-householdincome", str);
    }
    str = u();
    if (str != null) {
      localHashMap.put("u-interests", str);
    }
    str = v();
    if (str != null) {
      localHashMap.put("u-nationality", str);
    }
    return localHashMap;
  }
  
  public static void g(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_gender", paramString);
      return;
    }
    i = paramString;
  }
  
  private static int h()
  {
    if (a != Integer.MIN_VALUE) {
      return a;
    }
    return c.b("user_info_store").b("user_age", Integer.MIN_VALUE);
  }
  
  public static void h(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_ethnicity", paramString);
      return;
    }
    j = paramString;
  }
  
  private static String i()
  {
    if (b != null) {
      return b;
    }
    return c.b("user_info_store").b("user_age_group", null);
  }
  
  public static void i(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_education", paramString);
      return;
    }
    k = paramString;
  }
  
  private static String j()
  {
    if (c != null) {
      return c;
    }
    return c.b("user_info_store").b("user_area_code", null);
  }
  
  public static void j(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_language", paramString);
      return;
    }
    l = paramString;
  }
  
  private static String k()
  {
    if (e != null) {
      return e;
    }
    return c.b("user_info_store").b("user_city_code", null);
  }
  
  public static void k(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_house_income", paramString);
      return;
    }
    n = paramString;
  }
  
  private static String l()
  {
    if (f != null) {
      return f;
    }
    return c.b("user_info_store").b("user_state_code", null);
  }
  
  public static void l(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_interest", paramString);
      return;
    }
    o = paramString;
  }
  
  private static String m()
  {
    if (g != null) {
      return g;
    }
    return c.b("user_info_store").b("user_country_code", null);
  }
  
  public static void m(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_nationality", paramString);
      return;
    }
    p = paramString;
  }
  
  private static int n()
  {
    if (h != Integer.MIN_VALUE) {
      return h;
    }
    return c.b("user_info_store").b("user_yob", Integer.MIN_VALUE);
  }
  
  public static void n(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_login_id", paramString);
      return;
    }
    q = paramString;
  }
  
  private static String o()
  {
    if (i != null) {
      return i;
    }
    return c.b("user_info_store").b("user_gender", null);
  }
  
  public static void o(String paramString)
  {
    if ((a.a()) && (paramString != null))
    {
      c.b("user_info_store").a("user_session_id", paramString);
      return;
    }
    r = paramString;
  }
  
  private static String p()
  {
    if (j != null) {
      return j;
    }
    return c.b("user_info_store").b("user_ethnicity", null);
  }
  
  private static String q()
  {
    if (k != null) {
      return k;
    }
    return c.b("user_info_store").b("user_education", null);
  }
  
  private static String r()
  {
    if (l != null) {
      return l;
    }
    return c.b("user_info_store").b("user_language", null);
  }
  
  private static int s()
  {
    if (m != Integer.MIN_VALUE) {
      return m;
    }
    return c.b("user_info_store").b("user_income", Integer.MIN_VALUE);
  }
  
  private static String t()
  {
    if (n != null) {
      return n;
    }
    return c.b("user_info_store").b("user_house_income", null);
  }
  
  private static String u()
  {
    if (o != null) {
      return o;
    }
    return c.b("user_info_store").b("user_interest", null);
  }
  
  private static String v()
  {
    if (p != null) {
      return p;
    }
    return c.b("user_info_store").b("user_nationality", null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\info\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */