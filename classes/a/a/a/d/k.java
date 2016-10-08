package a.a.a.d;

import a.a.a.g;
import java.util.Date;
import java.util.List;

public abstract interface k
{
  public abstract void a(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void a(List<Object> paramList);
  
  public static abstract class a
    implements k
  {
    protected final boolean a;
    protected final Object b;
    protected final Object[] c;
    
    public a(Object paramObject)
    {
      this.b = paramObject;
      this.a = true;
      this.c = null;
    }
    
    public void a(List<Object> paramList)
    {
      if (this.a) {
        paramList.add(this.b);
      }
      for (;;)
      {
        return;
        if (this.c != null)
        {
          Object[] arrayOfObject = this.c;
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            paramList.add(arrayOfObject[i]);
            i += 1;
          }
        }
      }
    }
  }
  
  public static class b
    extends k.a
  {
    public final g d;
    public final String e;
    
    public b(g paramg, String paramString, Object paramObject)
    {
      super();
      this.d = paramg;
      this.e = paramString;
    }
    
    private static Object a(g paramg, Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass().isArray())) {
        throw new a.a.a.d("Illegal value: found array, but simple object required");
      }
      Object localObject;
      if (paramg.b == Date.class) {
        if ((paramObject instanceof Date)) {
          localObject = Long.valueOf(((Date)paramObject).getTime());
        }
      }
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject;
                localObject = paramObject;
              } while ((paramObject instanceof Long));
              throw new a.a.a.d("Illegal date value: expected java.util.Date or Long for value " + paramObject);
              if (paramg.b == Boolean.TYPE) {
                break;
              }
              localObject = paramObject;
            } while (paramg.b != Boolean.class);
            if ((paramObject instanceof Boolean))
            {
              if (((Boolean)paramObject).booleanValue()) {}
              for (i = 1;; i = 0) {
                return Integer.valueOf(i);
              }
            }
            if (!(paramObject instanceof Number)) {
              break;
            }
            i = ((Number)paramObject).intValue();
            localObject = paramObject;
          } while (i == 0);
          localObject = paramObject;
        } while (i == 1);
        throw new a.a.a.d("Illegal boolean value: numbers must be 0 or 1, but was " + paramObject);
        localObject = paramObject;
      } while (!(paramObject instanceof String));
      paramg = (String)paramObject;
      if ("TRUE".equalsIgnoreCase(paramg)) {
        return Integer.valueOf(1);
      }
      if ("FALSE".equalsIgnoreCase(paramg)) {
        return Integer.valueOf(0);
      }
      throw new a.a.a.d("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + paramObject);
    }
    
    public void a(StringBuilder paramStringBuilder, String paramString)
    {
      a.a.a.c.d.a(paramStringBuilder, paramString, this.d).append(this.e);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */