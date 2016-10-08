package com.google.gson.a.a;

import com.google.gson.annotations.SerializedName;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import com.google.gson.u;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class v
{
  public static final com.google.gson.af<String> A = new ad();
  public static final com.google.gson.af<BigDecimal> B = new ae();
  public static final com.google.gson.af<BigInteger> C = new af();
  public static final com.google.gson.ah D = a(String.class, A);
  public static final com.google.gson.af<StringBuilder> E = new ag();
  public static final com.google.gson.ah F = a(StringBuilder.class, E);
  public static final com.google.gson.af<StringBuffer> G = new ai();
  public static final com.google.gson.ah H = a(StringBuffer.class, G);
  public static final com.google.gson.af<URL> I = new aj();
  public static final com.google.gson.ah J = a(URL.class, I);
  public static final com.google.gson.af<URI> K = new ak();
  public static final com.google.gson.ah L = a(URI.class, K);
  public static final com.google.gson.af<InetAddress> M = new al();
  public static final com.google.gson.ah N = b(InetAddress.class, M);
  public static final com.google.gson.af<UUID> O = new am();
  public static final com.google.gson.ah P = a(UUID.class, O);
  public static final com.google.gson.af<Currency> Q = new an().a();
  public static final com.google.gson.ah R = a(Currency.class, Q);
  public static final com.google.gson.ah S = new ao();
  public static final com.google.gson.af<Calendar> T = new aq();
  public static final com.google.gson.ah U = b(Calendar.class, GregorianCalendar.class, T);
  public static final com.google.gson.af<Locale> V = new ar();
  public static final com.google.gson.ah W = a(Locale.class, V);
  public static final com.google.gson.af<u> X = new as();
  public static final com.google.gson.ah Y = b(u.class, X);
  public static final com.google.gson.ah Z = new au();
  public static final com.google.gson.af<Class> a = new w();
  public static final com.google.gson.ah b = a(Class.class, a);
  public static final com.google.gson.af<BitSet> c = new ah();
  public static final com.google.gson.ah d = a(BitSet.class, c);
  public static final com.google.gson.af<Boolean> e = new at();
  public static final com.google.gson.af<Boolean> f = new bb();
  public static final com.google.gson.ah g = a(Boolean.TYPE, Boolean.class, e);
  public static final com.google.gson.af<Number> h = new bc();
  public static final com.google.gson.ah i = a(Byte.TYPE, Byte.class, h);
  public static final com.google.gson.af<Number> j = new bd();
  public static final com.google.gson.ah k = a(Short.TYPE, Short.class, j);
  public static final com.google.gson.af<Number> l = new be();
  public static final com.google.gson.ah m = a(Integer.TYPE, Integer.class, l);
  public static final com.google.gson.af<AtomicInteger> n = new bf().a();
  public static final com.google.gson.ah o = a(AtomicInteger.class, n);
  public static final com.google.gson.af<AtomicBoolean> p = new bg().a();
  public static final com.google.gson.ah q = a(AtomicBoolean.class, p);
  public static final com.google.gson.af<AtomicIntegerArray> r = new x().a();
  public static final com.google.gson.ah s = a(AtomicIntegerArray.class, r);
  public static final com.google.gson.af<Number> t = new y();
  public static final com.google.gson.af<Number> u = new z();
  public static final com.google.gson.af<Number> v = new aa();
  public static final com.google.gson.af<Number> w = new ab();
  public static final com.google.gson.ah x = a(Number.class, w);
  public static final com.google.gson.af<Character> y = new ac();
  public static final com.google.gson.ah z = a(Character.TYPE, Character.class, y);
  
  public static <TT> com.google.gson.ah a(Class<TT> paramClass, com.google.gson.af<TT> paramaf)
  {
    return new av(paramClass, paramaf);
  }
  
  public static <TT> com.google.gson.ah a(Class<TT> paramClass1, Class<TT> paramClass2, com.google.gson.af<? super TT> paramaf)
  {
    return new aw(paramClass1, paramClass2, paramaf);
  }
  
  public static <T1> com.google.gson.ah b(Class<T1> paramClass, com.google.gson.af<T1> paramaf)
  {
    return new ay(paramClass, paramaf);
  }
  
  public static <TT> com.google.gson.ah b(Class<TT> paramClass, Class<? extends TT> paramClass1, com.google.gson.af<? super TT> paramaf)
  {
    return new ax(paramClass, paramClass1, paramaf);
  }
  
  private static final class a<T extends Enum<T>>
    extends com.google.gson.af<T>
  {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();
    
    public a(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (SerializedName)paramClass.getField((String)localObject1).getAnnotation(SerializedName.class);
          if (localObject2 != null)
          {
            String str = ((SerializedName)localObject2).a();
            localObject2 = ((SerializedName)localObject2).b();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.a.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.a.put(localObject1, localEnum);
          this.b.put(localEnum, localObject1);
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new AssertionError("Missing field in " + paramClass.getName(), localNoSuchFieldException);
      }
    }
    
    public T a(a parama)
    {
      if (parama.f() == c.i)
      {
        parama.j();
        return null;
      }
      return (Enum)this.a.get(parama.h());
    }
    
    public void a(d paramd, T paramT)
    {
      if (paramT == null) {}
      for (paramT = null;; paramT = (String)this.b.get(paramT))
      {
        paramd.b(paramT);
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */