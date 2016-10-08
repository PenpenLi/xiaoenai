package com.alibaba.sdk.android.ui.bus.filter;

import android.net.Uri;
import com.alibaba.sdk.android.ui.bus.UIBusContext;
import com.alibaba.sdk.android.util.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FilterContext
  extends UIBusContext
{
  private boolean dirty = false;
  
  public FilterContext(int paramInt, Uri paramUri, Map<String, Object> paramMap)
  {
    super(paramInt, paramUri, paramMap);
  }
  
  public FilterContext(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    super(paramInt, paramString, paramMap);
  }
  
  private String buildQueryString()
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
      List localList = (List)localEntry.getValue();
      int m = localList.size();
      int j = 0;
      int i = k;
      k = i;
      if (j < m)
      {
        if (i != 0) {
          localStringBuilder.append("&");
        }
        for (;;)
        {
          localStringBuilder.append(Uri.encode((String)localEntry.getKey())).append("=").append(Uri.encode((String)localList.get(j)));
          j += 1;
          break;
          i = 1;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void appendQueryParameter(String paramString1, String paramString2)
  {
    List localList = (List)this.queryParameters.get(paramString1);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(2);
      this.queryParameters.put(paramString1, localObject);
    }
    ((List)localObject).add(paramString2);
    this.dirty = true;
  }
  
  public void commit()
  {
    if (!this.dirty) {
      return;
    }
    String str = getUri();
    int i = str.indexOf("?");
    StringBuilder localStringBuilder = new StringBuilder();
    if (i != -1) {
      localStringBuilder.append(str.substring(0, i));
    }
    for (;;)
    {
      str = buildQueryString();
      if (str != null) {
        localStringBuilder.append("?").append(str);
      }
      if (this.fragment != null) {
        localStringBuilder.append("#").append(this.fragment);
      }
      super.setUri(localStringBuilder.toString());
      this.dirty = false;
      return;
      i = str.indexOf("#");
      if (i != -1) {
        localStringBuilder.append(str.subSequence(0, i));
      } else {
        localStringBuilder.append(str);
      }
    }
  }
  
  public String removeQueryParameter(String paramString)
  {
    paramString = (List)this.queryParameters.get(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    this.dirty = true;
    return (String)paramString.remove(0);
  }
  
  public String[] removeQueryParameters(String paramString)
  {
    paramString = (List)this.queryParameters.remove(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      this.dirty = true;
      return (String[])paramString.toArray(new String[0]);
    }
    return null;
  }
  
  public String updateQueryParameter(String paramString1, String paramString2)
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
      if (!CommonUtils.isEqual(paramString1, paramString2)) {
        this.dirty = true;
      }
      return paramString1;
      ((List)localObject).add(paramString2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\FilterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */