package a.a.a.c;

import a.a.a.b.b;
import a.a.a.b.c;
import a.a.a.g;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Cloneable
{
  public final SQLiteDatabase a;
  public final String b;
  public final g[] c;
  public final String[] d;
  public final String[] e;
  public final String[] f;
  public final g g;
  public final boolean h;
  public final e i;
  private a.a.a.b.a<?, ?> j;
  
  public a(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f;
    this.g = parama.g;
    this.i = parama.i;
    this.h = parama.h;
  }
  
  public a(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>> paramClass)
  {
    this.a = paramSQLiteDatabase;
    for (;;)
    {
      int k;
      try
      {
        this.b = ((String)paramClass.getField("TABLENAME").get(null));
        g[] arrayOfg = a(paramClass);
        this.c = arrayOfg;
        this.d = new String[arrayOfg.length];
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        k = 0;
        paramClass = null;
        if (k < arrayOfg.length)
        {
          g localg = arrayOfg[k];
          String str = localg.e;
          this.d[k] = str;
          if (localg.d)
          {
            localArrayList1.add(str);
            paramClass = localg;
          }
          else
          {
            localArrayList2.add(str);
          }
        }
        else
        {
          this.f = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
          this.e = ((String[])localArrayList1.toArray(new String[localArrayList1.size()]));
          if (this.e.length != 1) {
            break label355;
          }
          this.g = paramClass;
          this.i = new e(paramSQLiteDatabase, this.b, this.d, this.e);
          if (this.g != null)
          {
            paramSQLiteDatabase = this.g.b;
            if ((paramSQLiteDatabase.equals(Long.TYPE)) || (paramSQLiteDatabase.equals(Long.class)) || (paramSQLiteDatabase.equals(Integer.TYPE)) || (paramSQLiteDatabase.equals(Integer.class)) || (paramSQLiteDatabase.equals(Short.TYPE)) || (paramSQLiteDatabase.equals(Short.class)) || (paramSQLiteDatabase.equals(Byte.TYPE))) {
              break label349;
            }
            if (!paramSQLiteDatabase.equals(Byte.class)) {
              break label360;
            }
            break label349;
            this.h = bool;
            return;
          }
          this.h = false;
          return;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        throw new a.a.a.d("Could not init DAOConfig", paramSQLiteDatabase);
      }
      k += 1;
      continue;
      label349:
      boolean bool = true;
      continue;
      label355:
      paramClass = null;
      continue;
      label360:
      bool = false;
    }
  }
  
  private static g[] a(Class<? extends a.a.a.a<?, ?>> paramClass)
  {
    Object localObject1 = Class.forName(paramClass.getName() + "$Properties").getDeclaredFields();
    paramClass = new ArrayList();
    int m = localObject1.length;
    int k = 0;
    Object localObject2;
    while (k < m)
    {
      localObject2 = localObject1[k];
      if ((((Field)localObject2).getModifiers() & 0x9) == 9)
      {
        localObject2 = ((Field)localObject2).get(null);
        if ((localObject2 instanceof g)) {
          paramClass.add((g)localObject2);
        }
      }
      k += 1;
    }
    localObject1 = new g[paramClass.size()];
    paramClass = paramClass.iterator();
    while (paramClass.hasNext())
    {
      localObject2 = (g)paramClass.next();
      if (localObject1[localObject2.a] != null) {
        throw new a.a.a.d("Duplicate property ordinals");
      }
      localObject1[localObject2.a] = localObject2;
    }
    return (g[])localObject1;
  }
  
  public a a()
  {
    return new a(this);
  }
  
  public void a(a.a.a.b.d paramd)
  {
    if (paramd == a.a.a.b.d.b)
    {
      this.j = null;
      return;
    }
    if (paramd == a.a.a.b.d.a)
    {
      if (this.h)
      {
        this.j = new b();
        return;
      }
      this.j = new c();
      return;
    }
    throw new IllegalArgumentException("Unsupported type: " + paramd);
  }
  
  public a.a.a.b.a<?, ?> b()
  {
    return this.j;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */