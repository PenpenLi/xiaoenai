package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.mob.tools.a.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private b a = new b();
  private b b = new b("-._~", false);
  
  private ArrayList<i<String>> a(long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("oauth_consumer_key", this.a.a));
    localArrayList.add(new i("oauth_signature_method", paramString));
    localArrayList.add(new i("oauth_timestamp", String.valueOf(paramLong / 1000L)));
    localArrayList.add(new i("oauth_nonce", String.valueOf(paramLong)));
    localArrayList.add(new i("oauth_version", "1.0"));
    paramString = this.a.c;
    if ((paramString != null) && (paramString.length() > 0)) {
      localArrayList.add(new i("oauth_token", paramString));
    }
    return localArrayList;
  }
  
  private ArrayList<i<String>> a(long paramLong, ArrayList<i<String>> paramArrayList, String paramString)
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    i locali;
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        locali = (i)paramArrayList.next();
        localHashMap.put(a(locali.a), a((String)locali.b));
      }
    }
    paramArrayList = a(paramLong, paramString);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (i)paramArrayList.next();
        localHashMap.put(a(paramString.a), a((String)paramString.b));
      }
    }
    paramArrayList = new String[localHashMap.size()];
    paramString = localHashMap.entrySet().iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      paramArrayList[i] = ((String)((Map.Entry)paramString.next()).getKey());
      i += 1;
    }
    Arrays.sort(paramArrayList);
    paramString = new ArrayList();
    int k = paramArrayList.length;
    i = j;
    while (i < k)
    {
      locali = paramArrayList[i];
      paramString.add(new i(locali, localHashMap.get(locali)));
      i += 1;
    }
    return paramString;
  }
  
  private ArrayList<i<String>> a(String paramString1, String paramString2, ArrayList<i<String>> paramArrayList, a parama)
  {
    Mac localMac = null;
    long l = System.currentTimeMillis();
    switch (1.a[parama.ordinal()])
    {
    default: 
      paramString2 = null;
      paramString1 = localMac;
    }
    for (;;)
    {
      paramString1 = a(l, paramString1);
      paramString1.add(new i("oauth_signature", paramString2));
      return paramString1;
      parama = "HMAC-SHA1";
      SecretKeySpec localSecretKeySpec = new SecretKeySpec((a(this.a.b) + '&' + a(this.a.d)).getBytes("utf-8"), "HMAC-SHA1");
      localMac = Mac.getInstance("HMAC-SHA1");
      localMac.init(localSecretKeySpec);
      paramArrayList = b(a(l, paramArrayList, "HMAC-SHA1"));
      paramString2 = new String(Base64.encode(localMac.doFinal((paramString2 + '&' + a(paramString1.toLowerCase()) + '&' + a(paramArrayList)).getBytes("utf-8")), 0)).trim();
      paramString1 = parama;
      continue;
      paramString1 = "PLAINTEXT";
      paramString2 = a(this.a.b) + '&' + a(this.a.d);
    }
  }
  
  private String b(ArrayList<i<String>> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      i locali = (i)paramArrayList.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      localStringBuilder.append(locali.a).append('=').append((String)locali.b);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public b a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return this.b.escape(paramString);
  }
  
  public ArrayList<i<String>> a(String paramString, ArrayList<i<String>> paramArrayList)
  {
    return a(paramString, paramArrayList, a.a);
  }
  
  public ArrayList<i<String>> a(String paramString, ArrayList<i<String>> paramArrayList, a parama)
  {
    return a(paramString, "POST", paramArrayList, parama);
  }
  
  public ArrayList<i<String>> a(ArrayList<i<String>> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("OAuth ");
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      i locali = (i)paramArrayList.next();
      if (i > 0) {
        localStringBuilder.append(',');
      }
      String str = a((String)locali.b);
      localStringBuilder.append(locali.a).append("=\"").append(str).append("\"");
      i += 1;
    }
    paramArrayList = new ArrayList();
    paramArrayList.add(new i("Authorization", localStringBuilder.toString()));
    paramArrayList.add(new i("Content-Type", "application/x-www-form-urlencoded"));
    return paramArrayList;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.c = paramString1;
    this.a.d = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a = paramString1;
    this.a.b = paramString2;
    this.a.e = paramString3;
  }
  
  public ArrayList<i<String>> b(String paramString, ArrayList<i<String>> paramArrayList)
  {
    return b(paramString, paramArrayList, a.a);
  }
  
  public ArrayList<i<String>> b(String paramString, ArrayList<i<String>> paramArrayList, a parama)
  {
    return a(paramString, "GET", paramArrayList, parama);
  }
  
  public ArrayList<i<String>> c(String paramString, ArrayList<i<String>> paramArrayList, a parama)
  {
    return a(paramString, "PUT", paramArrayList, parama);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static class b
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */