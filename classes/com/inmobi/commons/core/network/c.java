package com.inmobi.commons.core.network;

import java.util.List;
import java.util.Map;

public class c
{
  private NetworkRequest a;
  private String b;
  private NetworkError c;
  private Map<String, List<String>> d;
  
  public c(NetworkRequest paramNetworkRequest)
  {
    this.a = paramNetworkRequest;
  }
  
  public void a(NetworkError paramNetworkError)
  {
    this.c = paramNetworkError;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(Map<String, List<String>> paramMap)
  {
    this.d = paramMap;
  }
  
  public boolean a()
  {
    return this.c != null;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public NetworkError c()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\network\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */