package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class y
{
  private final Map<String, Long> a = new HashMap();
  private final ArrayList<z.k> b = new ArrayList();
  
  public static void a(SharedPreferences paramSharedPreferences, z.n paramn)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getString("activities", "");
    if (TextUtils.isEmpty(paramSharedPreferences)) {}
    for (;;)
    {
      return;
      try
      {
        paramSharedPreferences = paramSharedPreferences.split(";");
        while (i < paramSharedPreferences.length)
        {
          JSONArray localJSONArray = new JSONArray(paramSharedPreferences[i]);
          z.k localk = new z.k();
          localk.a = localJSONArray.getString(0);
          localk.b = localJSONArray.getInt(1);
          paramn.h.add(localk);
          i += 1;
        }
        return;
      }
      catch (Exception paramSharedPreferences)
      {
        ax.a(paramSharedPreferences);
      }
    }
  }
  
  public void a()
  {
    String str = null;
    long l = 0L;
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Long)localEntry.getValue()).longValue() > l)
          {
            l = ((Long)localEntry.getValue()).longValue();
            str = (String)localEntry.getKey();
          }
        }
        else
        {
          if (str != null) {
            b(str);
          }
          return;
        }
      }
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject1 = t.a(paramContext);
    paramContext = ((SharedPreferences)localObject1).edit();
    if (this.b.size() > 0)
    {
      ??? = ((SharedPreferences)localObject1).getString("activities", "");
      localObject1 = new StringBuilder();
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        ((StringBuilder)localObject1).append((String)???);
        ((StringBuilder)localObject1).append(";");
      }
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          z.k localk = (z.k)localIterator.next();
          ((StringBuilder)localObject1).append(String.format("[\"%s\",%d]", new Object[] { localk.a, Long.valueOf(localk.b) }));
          ((StringBuilder)localObject1).append(";");
        }
      }
      this.b.clear();
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      paramContext.remove("activities");
      paramContext.putString("activities", ((StringBuilder)localObject1).toString());
    }
    paramContext.commit();
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.a)
      {
        this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    Object localObject2;
    synchronized (this.a)
    {
      localObject2 = (Long)this.a.remove(paramString);
      if (localObject2 == null)
      {
        ax.c("please call 'onPageStart(%s)' before onPageEnd", new Object[] { paramString });
        return;
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)localObject2).longValue();
    synchronized (this.b)
    {
      localObject2 = new z.k();
      ((z.k)localObject2).a = paramString;
      ((z.k)localObject2).b = (l1 - l2);
      this.b.add(localObject2);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */