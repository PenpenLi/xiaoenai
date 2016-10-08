package com.xiaoenai.app.classes.street.widget.AddressPicker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  private String a;
  private List<b> b;
  private Map<String, b> c = new HashMap();
  private int d = -1;
  
  public a() {}
  
  public a(String paramString, List<b> paramList, int paramInt)
  {
    this.a = paramString;
    this.b = paramList;
    this.d = paramInt;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (b)paramString.next();
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
  
  public void a(List<b> paramList)
  {
    this.b = paramList;
  }
  
  public List<b> b()
  {
    return this.b;
  }
  
  public Map<String, b> c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "CityModel [name=" + this.a + ", districtList=" + this.b + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\AddressPicker\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */