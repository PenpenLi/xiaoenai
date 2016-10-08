package com.qiniu.android.dns.c;

import java.util.HashMap;
import java.util.LinkedList;

public final class b<K, V>
{
  private LinkedList<K> a = new LinkedList();
  private HashMap<K, V> b = new HashMap();
  private int c;
  
  public b()
  {
    this(256);
  }
  
  public b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public b a(K paramK, V paramV)
  {
    if (this.a.size() == this.c)
    {
      Object localObject = this.a.pollLast();
      this.b.remove(localObject);
    }
    this.b.put(paramK, paramV);
    this.a.push(paramK);
    return this;
  }
  
  public V a(K paramK)
  {
    Object localObject = this.b.get(paramK);
    this.a.remove(paramK);
    this.a.push(paramK);
    return (V)localObject;
  }
  
  public void a()
  {
    this.a.clear();
    this.b.clear();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */