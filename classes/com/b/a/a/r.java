package com.b.a.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class r
  implements Serializable
{
  protected final ConcurrentHashMap<String, String> a;
  protected final ConcurrentHashMap<String, Object> b;
  protected final ConcurrentHashMap<String, Object> c;
  protected final ConcurrentHashMap<String, List<Object>> d;
  protected final ConcurrentHashMap<String, Object> e;
  protected String f;
  
  private List<BasicNameValuePair> a(String paramString, Object paramObject)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramObject instanceof Map))
    {
      Map localMap = (Map)paramObject;
      paramObject = new ArrayList(localMap.keySet());
      if ((((List)paramObject).size() > 0) && ((((List)paramObject).get(0) instanceof Comparable))) {
        Collections.sort((List)paramObject);
      }
      Iterator localIterator = ((List)paramObject).iterator();
      Object localObject;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramObject = localIterator.next();
        } while (!(paramObject instanceof String));
        localObject = localMap.get(paramObject);
      } while (localObject == null);
      if (paramString == null) {}
      for (paramObject = (String)paramObject;; paramObject = String.format(Locale.US, "%s[%s]", new Object[] { paramString, paramObject }))
      {
        localLinkedList.addAll(a((String)paramObject, localObject));
        break;
      }
    }
    int j;
    int i;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      j = ((List)paramObject).size();
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), ((List)paramObject).get(i)));
        i += 1;
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localLinkedList.addAll(a(String.format(Locale.US, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof Set))
    {
      paramObject = ((Set)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        localLinkedList.addAll(a(paramString, ((Iterator)paramObject).next()));
      }
    }
    localLinkedList.add(new BasicNameValuePair(paramString, paramObject.toString()));
    return localLinkedList;
  }
  
  protected List<BasicNameValuePair> a()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localLinkedList.addAll(a(null, this.e));
    return localLinkedList;
  }
  
  protected String b()
  {
    return URLEncodedUtils.format(a(), this.f);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)((Map.Entry)localObject).getValue());
    }
    localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("STREAM");
    }
    localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILE");
    }
    localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILES(SIZE=").append(((List)((Map.Entry)localObject).getValue()).size()).append(")");
    }
    localIterator = a(null, this.e).iterator();
    while (localIterator.hasNext())
    {
      localObject = (BasicNameValuePair)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(((BasicNameValuePair)localObject).getName());
      localStringBuilder.append("=");
      localStringBuilder.append(((BasicNameValuePair)localObject).getValue());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */