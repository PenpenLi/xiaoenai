package com.qiniu.android.dns.b;

import com.qiniu.android.dns.c;
import com.qiniu.android.dns.g;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public final class f
{
  private final Hashtable<String, ArrayList<a>> a = new Hashtable();
  private final Random b = new Random();
  
  private ArrayList<a> a(ArrayList<a> paramArrayList, g paramg)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      if (locala.b == 0) {
        localArrayList1.add(locala);
      }
      if ((paramg.c != 0) && (locala.b == paramg.c)) {
        localArrayList2.add(locala);
      }
    }
    if (localArrayList2.size() != 0) {
      return localArrayList2;
    }
    return localArrayList1;
  }
  
  public String[] a(c paramc, g paramg)
  {
    paramc = (ArrayList)this.a.get(paramc.a);
    if ((paramc == null) || (paramc.isEmpty())) {
      return null;
    }
    return a(a(paramc, paramg));
  }
  
  public String[] a(ArrayList<a> paramArrayList)
  {
    int j = paramArrayList.size();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((a)paramArrayList.get(i)).a;
      i += 1;
    }
    return arrayOfString;
  }
  
  public static class a
  {
    public final String a;
    public final int b;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof a))) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((this.a.equals(((a)paramObject).a)) && (this.b == ((a)paramObject).b));
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */