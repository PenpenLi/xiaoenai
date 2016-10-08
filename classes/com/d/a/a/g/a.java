package com.d.a.a.g;

import com.d.a.a.e;
import java.util.Comparator;

public class a
  implements Comparator<e>
{
  final Comparator<e> a;
  
  public a(Comparator<e> paramComparator)
  {
    this.a = paramComparator;
  }
  
  public int a(e parame1, e parame2)
  {
    if (parame1.g() < parame2.g()) {
      return -1;
    }
    if (parame1.g() > parame2.g()) {
      return 1;
    }
    return this.a.compare(parame1, parame2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */