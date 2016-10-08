package com.alibaba.sdk.android.httpdns;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpdnsMini
{
  private static final int EMPTY_RESULT_HOST_TTL = 30;
  private static final int MAX_HOLD_HOST_NUM = 100;
  private static final int MAX_THREAD_NUM = 5;
  private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
  private static final String SERVER_HOST = "httpdns.aliyuncs.com";
  private static final String SERVER_IP = "140.205.143.143";
  private static final String TAG = "HttpDnsMini";
  private static final int THRESHOLD_DEGRADE_HOST = 5;
  private static AtomicInteger globalNetworkError = new AtomicInteger(0);
  private static HttpdnsMini instance = new HttpdnsMini();
  private HttpdnsQueryPolicy defaultPolicy = new HttpdnsQueryPolicy();
  private ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
  private ExecutorService pool = Executors.newFixedThreadPool(5);
  
  public static HttpdnsMini getInstance()
  {
    return instance;
  }
  
  public HttpdnsQueryPolicy getDefaultQueryPolicy()
  {
    return this.defaultPolicy;
  }
  
  public ExecutorService getExecutorService()
  {
    return this.pool;
  }
  
  public String getIpByHost(String paramString)
  {
    return getIpByHost(paramString, this.defaultPolicy);
  }
  
  public String getIpByHost(String paramString, HttpdnsQueryPolicy paramHttpdnsQueryPolicy)
  {
    Object localObject = (HostObject)this.hostManager.get(paramString);
    if ((localObject == null) || (((HostObject)localObject).isExpired()))
    {
      DpaLog.logD("HttpDnsMini", "[getIpByHost] - refresh host: " + paramString);
      ExecutorService localExecutorService = this.pool;
      localObject = paramHttpdnsQueryPolicy;
      if (paramHttpdnsQueryPolicy == null) {
        localObject = this.defaultPolicy;
      }
      paramString = localExecutorService.submit(new QueryHostTask(paramString, (HttpdnsQueryPolicy)localObject));
      try
      {
        paramString = (String)paramString.get();
        return paramString;
      }
      catch (Exception paramString)
      {
        if (DpaLog.isEnableLog()) {
          paramString.printStackTrace();
        }
        return null;
      }
    }
    return ((HostObject)localObject).getIp();
  }
  
  public String getIpByHostAsync(String paramString)
  {
    return getIpByHostAsync(paramString, this.defaultPolicy);
  }
  
  public String getIpByHostAsync(String paramString, HttpdnsQueryPolicy paramHttpdnsQueryPolicy)
  {
    HostObject localHostObject = (HostObject)this.hostManager.get(paramString);
    if ((localHostObject == null) || (localHostObject.isExpired()))
    {
      DpaLog.logD("HttpDnsMini", "[getIpByHostAsync] - refresh host: " + paramString);
      ExecutorService localExecutorService = this.pool;
      HttpdnsQueryPolicy localHttpdnsQueryPolicy = paramHttpdnsQueryPolicy;
      if (paramHttpdnsQueryPolicy == null) {
        localHttpdnsQueryPolicy = this.defaultPolicy;
      }
      localExecutorService.submit(new QueryHostTask(paramString, localHttpdnsQueryPolicy));
    }
    if (localHostObject != null)
    {
      if (localHostObject.isStillAvailable()) {
        return localHostObject.getIp();
      }
      return null;
    }
    return null;
  }
  
  public void setExecutorService(ExecutorService paramExecutorService)
  {
    this.pool = paramExecutorService;
  }
  
  class HostObject
  {
    private String hostName;
    private String ip;
    private long queryTime;
    private long ttl;
    
    HostObject() {}
    
    public String getHostName()
    {
      return this.hostName;
    }
    
    public String getIp()
    {
      return this.ip;
    }
    
    public long getQueryTime()
    {
      return this.queryTime;
    }
    
    public long getTtl()
    {
      return this.ttl;
    }
    
    public boolean isExpired()
    {
      return getQueryTime() + this.ttl < System.currentTimeMillis() / 1000L;
    }
    
    public boolean isStillAvailable()
    {
      return getQueryTime() + this.ttl + 600L > System.currentTimeMillis() / 1000L;
    }
    
    public void setHostName(String paramString)
    {
      this.hostName = paramString;
    }
    
    public void setIp(String paramString)
    {
      this.ip = paramString;
    }
    
    public void setQueryTime(long paramLong)
    {
      this.queryTime = paramLong;
    }
    
    public void setTtl(long paramLong)
    {
      this.ttl = paramLong;
    }
    
    public String toString()
    {
      return "HostObject [hostName=" + this.hostName + ", ip=" + this.ip + ", ttl=" + this.ttl + ", queryTime=" + this.queryTime + "]";
    }
  }
  
  public static class HttpdnsQueryPolicy
  {
    public int connectionTimeout = 10000;
    public int readTimeout = 10000;
    public boolean retryOnFailure = true;
  }
  
  class QueryHostTask
    implements Callable<String>
  {
    private boolean hasRetryed = false;
    private String hostName;
    private HttpdnsMini.HttpdnsQueryPolicy queryPolicy;
    
    public QueryHostTask(String paramString, HttpdnsMini.HttpdnsQueryPolicy paramHttpdnsQueryPolicy)
    {
      this.hostName = paramString;
      this.queryPolicy = paramHttpdnsQueryPolicy;
    }
    
    public String call()
    {
      Object localObject1 = "140.205.143.143";
      if (HttpdnsMini.globalNetworkError.get() > 5) {
        localObject1 = "httpdns.aliyuncs.com";
      }
      localObject1 = "http://" + (String)localObject1 + "/d?host=" + this.hostName;
      DpaLog.logD("HttpDnsMini", "[run] - buildUrl: " + (String)localObject1);
      try
      {
        localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        ((HttpURLConnection)localObject1).setConnectTimeout(this.queryPolicy.connectionTimeout);
        ((HttpURLConnection)localObject1).setReadTimeout(this.queryPolicy.readTimeout);
        if (((HttpURLConnection)localObject1).getResponseCode() != 200)
        {
          DpaLog.logD("HttpDnsMini", "[run] - responseCodeNot 200, but: " + ((HttpURLConnection)localObject1).getResponseCode());
          if ((this.queryPolicy.retryOnFailure) && (!this.hasRetryed))
          {
            this.hasRetryed = true;
            localObject3 = call();
            return (String)localObject3;
          }
        }
        else
        {
          HttpdnsMini.globalNetworkError.decrementAndGet();
          localObject1 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream(), "UTF-8"));
          localObject3 = new StringBuilder();
          for (;;)
          {
            localObject4 = ((BufferedReader)localObject1).readLine();
            if (localObject4 == null) {
              break;
            }
            ((StringBuilder)localObject3).append((String)localObject4);
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        long l2;
        do
        {
          for (;;)
          {
            HttpdnsMini.globalNetworkError.incrementAndGet();
            if (DpaLog.isEnableLog()) {
              localException.printStackTrace();
            }
          }
          localObject2 = new JSONObject(((StringBuilder)localObject3).toString());
          localObject3 = ((JSONObject)localObject2).getString("host");
          l2 = ((JSONObject)localObject2).getLong("ttl");
          localObject2 = ((JSONObject)localObject2).getJSONArray("ips");
        } while (localObject3 == null);
        long l1 = l2;
        if (l2 == 0L) {
          l1 = 30L;
        }
        Object localObject4 = new HttpdnsMini.HostObject(HttpdnsMini.this);
        if (localObject2 == null) {}
        for (Object localObject2 = null;; localObject2 = ((JSONArray)localObject2).getString(0))
        {
          DpaLog.logD("HttpDnsMini", "[run] - resolve host:" + (String)localObject3 + " ip:" + (String)localObject2 + " ttl:" + l1);
          ((HttpdnsMini.HostObject)localObject4).setHostName((String)localObject3);
          ((HttpdnsMini.HostObject)localObject4).setTtl(l1);
          ((HttpdnsMini.HostObject)localObject4).setIp((String)localObject2);
          ((HttpdnsMini.HostObject)localObject4).setQueryTime(System.currentTimeMillis() / 1000L);
          localObject3 = localObject2;
          if (HttpdnsMini.this.hostManager.size() >= 100) {
            break;
          }
          HttpdnsMini.this.hostManager.put(this.hostName, localObject4);
          return (String)localObject2;
        }
      }
      return null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\httpdns\HttpdnsMini.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */