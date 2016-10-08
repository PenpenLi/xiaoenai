package com.alibaba.nb.android.trade.web.interception.base;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.utils.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class c
{
  public static final String SKIP_UI_COMPONENT_PREFIX = "skip_";
  private Map<String, String> contextParameters;
  private Map<String, Object> extraParameters;
  protected String fragment;
  protected Uri internalUri;
  protected Map<String, List<String>> queryParameters = new LinkedHashMap();
  private int scenario;
  private String schemelessUri;
  private String scope;
  private String uri;
  
  public c(int paramInt, Uri paramUri, Map<String, Object> paramMap)
  {
    this(paramInt, paramUri.toString(), paramMap);
    this.internalUri = paramUri;
  }
  
  public c(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    this.uri = paramString;
    this.scenario = paramInt;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = new HashMap();
    }
    this.extraParameters = paramString;
    paramString = (Map)this.extraParameters.get("ui_contextParams");
    if (paramString == null) {}
    for (paramString = new HashMap();; paramString = new HashMap(paramString))
    {
      this.contextParameters = paramString;
      parseUri();
      return;
    }
  }
  
  private void parseUri()
  {
    for (;;)
    {
      int i;
      int j;
      Object localObject2;
      Object localObject3;
      try
      {
        Object localObject1 = getUri();
        i = ((String)localObject1).indexOf("#");
        if (i == -1)
        {
          this.fragment = null;
          j = ((String)localObject1).indexOf("?");
          this.queryParameters.clear();
          if ((j != -1) && (j != ((String)localObject1).length() - 1) && ((i == -1) || (j < i)))
          {
            if (i != -1) {
              break label275;
            }
            localObject1 = ((String)localObject1).substring(j + 1);
            localObject1 = ((String)localObject1).split("[\\&]");
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label298;
              }
              int k = ((String)localObject2).indexOf('=');
              if ((k == -1) || (k == ((String)localObject2).length() - 1)) {
                break label298;
              }
              String str2 = Uri.decode(((String)localObject2).substring(0, k));
              localObject2 = Uri.decode(((String)localObject2).substring(k + 1));
              localObject3 = (List)this.queryParameters.get(str2);
              if (localObject3 != null) {
                break label289;
              }
              localObject3 = new ArrayList(2);
              ((List)localObject3).add(localObject2);
              this.queryParameters.put(str2, localObject3);
              break label298;
            }
          }
        }
        else
        {
          if (i == ((String)localObject1).length() - 1) {
            continue;
          }
          this.fragment = ((String)localObject1).substring(i + 1);
          continue;
        }
        return;
      }
      catch (Exception localException)
      {
        a.a("ui", "fail to parse the uri " + getUri(), localException);
      }
      label275:
      String str1 = localException.substring(j + 1, i);
      continue;
      label289:
      ((List)localObject3).add(localObject2);
      label298:
      i += 1;
    }
  }
  
  public String getContextParameter(String paramString)
  {
    return (String)this.contextParameters.get(paramString);
  }
  
  public Map<String, String> getContextParameters()
  {
    return this.contextParameters;
  }
  
  public Object getExtraParameter()
  {
    if (this.extraParameters == null) {
      return null;
    }
    return this.extraParameters;
  }
  
  public Object getExtraParameter(String paramString)
  {
    if (this.extraParameters == null) {
      return null;
    }
    return this.extraParameters.get(paramString);
  }
  
  public String getFragment()
  {
    return this.fragment;
  }
  
  public String getHost()
  {
    if (this.internalUri == null) {
      this.internalUri = Uri.parse(this.uri);
    }
    return this.internalUri.getHost();
  }
  
  public String getQueryParameter(String paramString)
  {
    paramString = (List)this.queryParameters.get(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    return (String)paramString.get(0);
  }
  
  public Map<String, String> getQueryParameters()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.queryParameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, ((List)this.queryParameters.get(str)).get(0));
    }
    return localHashMap;
  }
  
  public String[] getQueryParameters(String paramString)
  {
    paramString = (List)this.queryParameters.get(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    return (String[])paramString.toArray(new String[paramString.size()]);
  }
  
  public String getQueryString()
  {
    if (this.internalUri == null) {
      this.internalUri = Uri.parse(this.uri);
    }
    return this.internalUri.getEncodedQuery();
  }
  
  public int getScenario()
  {
    return this.scenario;
  }
  
  public String getScheme()
  {
    if (this.internalUri == null) {
      this.internalUri = Uri.parse(this.uri);
    }
    return this.internalUri.getScheme().trim();
  }
  
  public String getSchemelessUri()
  {
    if (this.schemelessUri != null) {
      return this.schemelessUri;
    }
    if (this.internalUri == null) {
      this.internalUri = Uri.parse(this.uri);
    }
    String str = this.internalUri.getSchemeSpecificPart();
    if ((str != null) && (str.length() > 2))
    {
      this.schemelessUri = str.substring(2);
      if (this.internalUri.getFragment() == null) {}
    }
    for (this.schemelessUri = (this.schemelessUri + "#" + this.internalUri.getFragment());; this.schemelessUri = "") {
      return this.schemelessUri;
    }
  }
  
  public String getScope()
  {
    return this.scope;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public void setContextParameter(String paramString1, String paramString2)
  {
    this.contextParameters.put(paramString1, paramString2);
  }
  
  public void setScope(String paramString)
  {
    this.scope = paramString;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
    this.internalUri = null;
    this.fragment = null;
    this.schemelessUri = null;
    parseUri();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */