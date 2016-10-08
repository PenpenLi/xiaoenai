package com.google.gson.a.a;

import com.google.gson.a.aa;
import com.google.gson.a.b;
import com.google.gson.a.r;
import com.google.gson.a.z;
import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.b.a<*>;
import com.google.gson.c.d;
import com.google.gson.i;
import com.google.gson.j;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  implements ah
{
  private final com.google.gson.a.c a;
  private final i b;
  private final r c;
  
  public o(com.google.gson.a.c paramc, i parami, r paramr)
  {
    this.a = paramc;
    this.b = parami;
    this.c = paramr;
  }
  
  private b a(j paramj, Field paramField, String paramString, com.google.gson.b.a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new p(this, paramString, paramBoolean1, paramBoolean2, paramj, paramField, parama, aa.a(parama.getRawType()));
  }
  
  private af<?> a(j paramj, Field paramField, com.google.gson.b.a<?> parama)
  {
    paramField = (JsonAdapter)paramField.getAnnotation(JsonAdapter.class);
    if (paramField != null)
    {
      paramField = f.a(this.a, paramj, parama, paramField);
      if (paramField != null) {
        return paramField;
      }
    }
    return paramj.a(parama);
  }
  
  static List<String> a(i parami, Field paramField)
  {
    SerializedName localSerializedName = (SerializedName)paramField.getAnnotation(SerializedName.class);
    LinkedList localLinkedList = new LinkedList();
    if (localSerializedName == null) {
      localLinkedList.add(parami.a(paramField));
    }
    for (;;)
    {
      return localLinkedList;
      localLinkedList.add(localSerializedName.a());
      parami = localSerializedName.b();
      int j = parami.length;
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(parami[i]);
        i += 1;
      }
    }
  }
  
  private List<String> a(Field paramField)
  {
    return a(this.b, paramField);
  }
  
  private Map<String, b> a(j paramj, com.google.gson.b.a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = parama.getType();
    Object localObject1 = paramClass;
    paramClass = parama;
    label94:
    int j;
    if (localObject1 != Object.class)
    {
      Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
      int k = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Field localField = arrayOfField[i];
          boolean bool1 = a(localField, true);
          boolean bool2 = a(localField, false);
          if ((!bool1) && (!bool2))
          {
            i += 1;
          }
          else
          {
            localField.setAccessible(true);
            Type localType2 = b.a(paramClass.getType(), (Class)localObject1, localField.getGenericType());
            List localList = a(localField);
            parama = null;
            j = 0;
            label138:
            if (j < localList.size())
            {
              Object localObject2 = (String)localList.get(j);
              if (j != 0) {
                bool1 = false;
              }
              localObject2 = (b)localLinkedHashMap.put(localObject2, a(paramj, localField, (String)localObject2, com.google.gson.b.a.get(localType2), bool1, bool2));
              if (parama != null) {
                break label289;
              }
              parama = (com.google.gson.b.a<?>)localObject2;
            }
          }
        }
      }
    }
    label289:
    for (;;)
    {
      j += 1;
      break label138;
      if (parama == null) {
        break label94;
      }
      throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + parama.g);
      paramClass = com.google.gson.b.a.get(b.a(paramClass.getType(), (Class)localObject1, ((Class)localObject1).getGenericSuperclass()));
      localObject1 = paramClass.getRawType();
      break;
      return localLinkedHashMap;
    }
  }
  
  static boolean a(Field paramField, boolean paramBoolean, r paramr)
  {
    return (!paramr.a(paramField.getType(), paramBoolean)) && (!paramr.a(paramField, paramBoolean));
  }
  
  public <T> af<T> a(j paramj, com.google.gson.b.a<T> parama)
  {
    Class localClass = parama.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new a(this.a.a(parama), a(paramj, parama, localClass), null);
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    return a(paramField, paramBoolean, this.c);
  }
  
  public static final class a<T>
    extends af<T>
  {
    private final z<T> a;
    private final Map<String, o.b> b;
    
    private a(z<T> paramz, Map<String, o.b> paramMap)
    {
      this.a = paramz;
      this.b = paramMap;
    }
    
    public void a(d paramd, T paramT)
    {
      if (paramT == null)
      {
        paramd.f();
        return;
      }
      paramd.d();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          o.b localb = (o.b)localIterator.next();
          if (localb.a(paramT))
          {
            paramd.a(localb.g);
            localb.a(paramd, paramT);
          }
        }
        paramd.e();
      }
      catch (IllegalAccessException paramd)
      {
        throw new AssertionError(paramd);
      }
    }
    
    public T b(com.google.gson.c.a parama)
    {
      if (parama.f() == com.google.gson.c.c.i)
      {
        parama.j();
        return null;
      }
      Object localObject1 = this.a.a();
      try
      {
        parama.c();
        for (;;)
        {
          if (!parama.e()) {
            break label103;
          }
          localObject2 = parama.g();
          localObject2 = (o.b)this.b.get(localObject2);
          if ((localObject2 != null) && (((o.b)localObject2).i)) {
            break;
          }
          parama.n();
        }
      }
      catch (IllegalStateException parama)
      {
        for (;;)
        {
          Object localObject2;
          throw new ab(parama);
          ((o.b)localObject2).a(parama, localObject1);
        }
      }
      catch (IllegalAccessException parama)
      {
        throw new AssertionError(parama);
      }
      label103:
      parama.d();
      return (T)localObject1;
    }
  }
  
  static abstract class b
  {
    final String g;
    final boolean h;
    final boolean i;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.g = paramString;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
    }
    
    abstract void a(com.google.gson.c.a parama, Object paramObject);
    
    abstract void a(d paramd, Object paramObject);
    
    abstract boolean a(Object paramObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */