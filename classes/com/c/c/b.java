package com.c.c;

import android.os.Build.VERSION;
import android.view.View;
import com.c.a.a.a;
import java.util.WeakHashMap;

public abstract class b
{
  private static final WeakHashMap<View, b> a = new WeakHashMap(0);
  
  public static b a(View paramView)
  {
    b localb = (b)a.get(paramView);
    Object localObject = localb;
    int i;
    if (localb == null)
    {
      i = Integer.valueOf(Build.VERSION.SDK).intValue();
      if (i < 14) {
        break label53;
      }
      localObject = new e(paramView);
    }
    for (;;)
    {
      a.put(paramView, localObject);
      return (b)localObject;
      label53:
      if (i >= 11) {
        localObject = new c(paramView);
      } else {
        localObject = new g(paramView);
      }
    }
  }
  
  public abstract b a(float paramFloat);
  
  public abstract b a(long paramLong);
  
  public abstract b a(a.a parama);
  
  public abstract b b(float paramFloat);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */