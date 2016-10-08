package com.d.a.a.g;

import com.d.a.a.e;
import java.util.Comparator;

public class i
  implements Comparator<e>
{
  final Comparator<e> a;
  
  public i(Comparator<e> paramComparator)
  {
    this.a = paramComparator;
  }
  
  public int a(e parame1, e parame2)
  {
    int j = 0;
    int k = 1;
    long l = System.nanoTime();
    int i;
    if (parame1.g() <= l)
    {
      i = 1;
      if (parame2.g() <= l) {
        j = 1;
      }
      if (i == 0) {
        break label73;
      }
      if (j == 0) {
        break label68;
      }
      i = this.a.compare(parame1, parame2);
      label57:
      j = i;
    }
    label68:
    label73:
    label98:
    do
    {
      do
      {
        return j;
        i = 0;
        break;
        i = -1;
        break label57;
        if (j == 0) {
          break label98;
        }
        j = k;
      } while (i == 0);
      return this.a.compare(parame1, parame2);
      if (parame1.g() < parame2.g()) {
        return -1;
      }
      j = k;
    } while (parame1.g() > parame2.g());
    return this.a.compare(parame1, parame2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */