package com.alibaba.nb.android.trade.web.interception.base.filter;

import android.net.Uri;
import com.alibaba.nb.android.trade.utils.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends com.alibaba.nb.android.trade.web.interception.base.c
{
  private boolean a = false;
  private final int b = 10240;
  private final Set<String> c = new HashSet();
  private String[] d = { "ttid" };
  
  public c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    super(paramInt, paramString, paramMap);
    this.c.add("ybhpss");
  }
  
  private String a(int paramInt)
  {
    if (this.queryParameters == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.queryParameters.entrySet().iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((1 != paramInt) || (!this.c.contains(localEntry.getKey())))
      {
        List localList = (List)localEntry.getValue();
        int m = localList.size();
        int j = 0;
        int i = k;
        k = i;
        if (j < m)
        {
          if (i != 0)
          {
            localStringBuilder.append("&");
            label130:
            if (b((String)localEntry.getKey())) {
              break label203;
            }
            localStringBuilder.append(Uri.encode((String)localEntry.getKey())).append("=").append(Uri.encode((String)localList.get(j)));
          }
          for (;;)
          {
            j += 1;
            break;
            i = 1;
            break label130;
            label203:
            localStringBuilder.append(Uri.encode((String)localEntry.getKey())).append("=").append((String)localList.get(j));
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = this.d;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    List localList = (List)this.queryParameters.get(paramString1);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(2);
      this.queryParameters.put(paramString1, localObject);
    }
    if (((List)localObject).size() > 0) {}
    for (paramString1 = (String)((List)localObject).set(0, paramString2);; paramString1 = null)
    {
      if (!b.a(paramString1, paramString2)) {
        this.a = true;
      }
      return paramString1;
      ((List)localObject).add(paramString2);
    }
  }
  
  public final void a()
  {
    if (!this.a) {
      return;
    }
    int i = 0;
    for (;;)
    {
      String str = getUri();
      int j = str.indexOf("?");
      StringBuilder localStringBuilder = new StringBuilder();
      if (j != -1) {
        localStringBuilder.append(str.substring(0, j));
      }
      for (;;)
      {
        str = a(i);
        if (str != null) {
          localStringBuilder.append("?").append(str);
        }
        if (this.fragment != null) {
          localStringBuilder.append("#").append(this.fragment);
        }
        super.setUri(localStringBuilder.toString());
        if ((getUri().length() > 10240) && (i != 1)) {
          break;
        }
        this.a = false;
        return;
        j = str.indexOf("#");
        if (j != -1) {
          localStringBuilder.append(str.subSequence(0, j));
        } else {
          localStringBuilder.append(str);
        }
      }
      i += 1;
    }
  }
  
  public final String[] a(String paramString)
  {
    paramString = (List)this.queryParameters.remove(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      this.a = true;
      return (String[])paramString.toArray(new String[0]);
    }
    return null;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Object localObject = (List)this.queryParameters.get(paramString1);
    if (localObject == null)
    {
      localObject = new ArrayList(2);
      this.queryParameters.put(paramString1, localObject);
    }
    for (paramString1 = (String)localObject;; paramString1 = (String)localObject)
    {
      localObject = paramString1.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((String)((Iterator)localObject).next()).equals(paramString2)) {
          return;
        }
      }
      paramString1.add(paramString2);
      this.a = true;
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */