package com.xiaoenai.app.classes.street.widget.AddressPicker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
{
  private String a;
  private List<a> b;
  private Map<String, a> c = new HashMap();
  private int d = -1;
  
  public c() {}
  
  public c(String paramString, List<a> paramList, int paramInt)
  {
    this.a = paramString;
    this.b = paramList;
    this.d = paramInt;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (a)paramString.next();
      this.c.put(paramList.a(), paramList);
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<a> paramList)
  {
    this.b = paramList;
  }
  
  public List<a> b()
  {
    return this.b;
  }
  
  public Map<String, a> c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "ProvinceModel [name=" + this.a + ", cityList=" + this.b + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\AddressPicker\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */