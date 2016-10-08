package d.a;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class aq
  implements ba<aq, e>, Serializable, Cloneable
{
  public static final Map<e, bi> k;
  private static final bx l = new bx("UMEnvelope");
  private static final bp m = new bp("version", (byte)11, (short)1);
  private static final bp n = new bp("address", (byte)11, (short)2);
  private static final bp o = new bp("signature", (byte)11, (short)3);
  private static final bp p = new bp("serial_num", (byte)8, (short)4);
  private static final bp q = new bp("ts_secs", (byte)8, (short)5);
  private static final bp r = new bp("length", (byte)8, (short)6);
  private static final bp s = new bp("entity", (byte)11, (short)7);
  private static final bp t = new bp("guid", (byte)11, (short)8);
  private static final bp u = new bp("checksum", (byte)11, (short)9);
  private static final bp v = new bp("codex", (byte)8, (short)10);
  private static final Map<Class<? extends bz>, ca> w = new HashMap();
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public ByteBuffer g;
  public String h;
  public String i;
  public int j;
  private byte x = 0;
  private e[] y = { e.j };
  
  static
  {
    w.put(cb.class, new b(null));
    w.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("version", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.b, new bi("address", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.c, new bi("signature", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.d, new bi("serial_num", (byte)1, new bj((byte)8)));
    localEnumMap.put(e.e, new bi("ts_secs", (byte)1, new bj((byte)8)));
    localEnumMap.put(e.f, new bi("length", (byte)1, new bj((byte)8)));
    localEnumMap.put(e.g, new bi("entity", (byte)1, new bj((byte)11, true)));
    localEnumMap.put(e.h, new bi("guid", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.i, new bi("checksum", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.j, new bi("codex", (byte)2, new bj((byte)8)));
    k = Collections.unmodifiableMap(localEnumMap);
    bi.a(aq.class, k);
  }
  
  public aq a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }
  
  public aq a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public aq a(ByteBuffer paramByteBuffer)
  {
    this.g = paramByteBuffer;
    return this;
  }
  
  public aq a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = (ByteBuffer)null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
    {
      a(paramArrayOfByte);
      return this;
    }
  }
  
  public void a(bs parambs)
  {
    ((ca)w.get(parambs.y())).b().b(parambs, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return ay.a(this.x, 0);
  }
  
  public aq b(int paramInt)
  {
    this.e = paramInt;
    e(true);
    return this;
  }
  
  public aq b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(bs parambs)
  {
    ((ca)w.get(parambs.y())).b().a(parambs, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return ay.a(this.x, 1);
  }
  
  public aq c(int paramInt)
  {
    this.f = paramInt;
    f(true);
    return this;
  }
  
  public aq c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return ay.a(this.x, 2);
  }
  
  public aq d(int paramInt)
  {
    this.j = paramInt;
    j(true);
    return this;
  }
  
  public aq d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.x = ay.a(this.x, 0, paramBoolean);
  }
  
  public boolean d()
  {
    return ay.a(this.x, 3);
  }
  
  public aq e(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new bt("Required field 'version' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new bt("Required field 'address' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new bt("Required field 'signature' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new bt("Required field 'entity' was not present! Struct: " + toString());
    }
    if (this.h == null) {
      throw new bt("Required field 'guid' was not present! Struct: " + toString());
    }
    if (this.i == null) {
      throw new bt("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.x = ay.a(this.x, 1, paramBoolean);
  }
  
  public void f(boolean paramBoolean)
  {
    this.x = ay.a(this.x, 2, paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.g = null;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i = null;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    this.x = ay.a(this.x, 3, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UMEnvelope(");
    localStringBuilder.append("version:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("address:");
      if (this.b != null) {
        break label321;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("signature:");
      if (this.c != null) {
        break label333;
      }
      localStringBuilder.append("null");
      label96:
      localStringBuilder.append(", ");
      localStringBuilder.append("serial_num:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", ");
      localStringBuilder.append("ts_secs:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append("length:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
      localStringBuilder.append("entity:");
      if (this.g != null) {
        break label345;
      }
      localStringBuilder.append("null");
      label202:
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.h != null) {
        break label356;
      }
      localStringBuilder.append("null");
      label233:
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.i != null) {
        break label368;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("codex:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label321:
      localStringBuilder.append(this.b);
      break label65;
      label333:
      localStringBuilder.append(this.c);
      break label96;
      label345:
      bb.a(this.g, localStringBuilder);
      break label202;
      label356:
      localStringBuilder.append(this.h);
      break label233;
      label368:
      localStringBuilder.append(this.i);
    }
  }
  
  private static class a
    extends cb<aq>
  {
    public void a(bs parambs, aq paramaq)
    {
      parambs.f();
      bp localbp = parambs.h();
      if (localbp.b == 0)
      {
        parambs.g();
        if (!paramaq.a()) {
          throw new bt("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (localbp.c)
        {
        default: 
          bv.a(parambs, localbp.b);
        }
        for (;;)
        {
          parambs.i();
          break;
          if (localbp.b == 11)
          {
            paramaq.a = parambs.v();
            paramaq.a(true);
          }
          else
          {
            bv.a(parambs, localbp.b);
            continue;
            if (localbp.b == 11)
            {
              paramaq.b = parambs.v();
              paramaq.b(true);
            }
            else
            {
              bv.a(parambs, localbp.b);
              continue;
              if (localbp.b == 11)
              {
                paramaq.c = parambs.v();
                paramaq.c(true);
              }
              else
              {
                bv.a(parambs, localbp.b);
                continue;
                if (localbp.b == 8)
                {
                  paramaq.d = parambs.s();
                  paramaq.d(true);
                }
                else
                {
                  bv.a(parambs, localbp.b);
                  continue;
                  if (localbp.b == 8)
                  {
                    paramaq.e = parambs.s();
                    paramaq.e(true);
                  }
                  else
                  {
                    bv.a(parambs, localbp.b);
                    continue;
                    if (localbp.b == 8)
                    {
                      paramaq.f = parambs.s();
                      paramaq.f(true);
                    }
                    else
                    {
                      bv.a(parambs, localbp.b);
                      continue;
                      if (localbp.b == 11)
                      {
                        paramaq.g = parambs.w();
                        paramaq.g(true);
                      }
                      else
                      {
                        bv.a(parambs, localbp.b);
                        continue;
                        if (localbp.b == 11)
                        {
                          paramaq.h = parambs.v();
                          paramaq.h(true);
                        }
                        else
                        {
                          bv.a(parambs, localbp.b);
                          continue;
                          if (localbp.b == 11)
                          {
                            paramaq.i = parambs.v();
                            paramaq.i(true);
                          }
                          else
                          {
                            bv.a(parambs, localbp.b);
                            continue;
                            if (localbp.b == 8)
                            {
                              paramaq.j = parambs.s();
                              paramaq.j(true);
                            }
                            else
                            {
                              bv.a(parambs, localbp.b);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (!paramaq.b()) {
        throw new bt("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
      }
      if (!paramaq.c()) {
        throw new bt("Required field 'length' was not found in serialized data! Struct: " + toString());
      }
      paramaq.e();
    }
    
    public void b(bs parambs, aq paramaq)
    {
      paramaq.e();
      parambs.a(aq.f());
      if (paramaq.a != null)
      {
        parambs.a(aq.g());
        parambs.a(paramaq.a);
        parambs.b();
      }
      if (paramaq.b != null)
      {
        parambs.a(aq.h());
        parambs.a(paramaq.b);
        parambs.b();
      }
      if (paramaq.c != null)
      {
        parambs.a(aq.i());
        parambs.a(paramaq.c);
        parambs.b();
      }
      parambs.a(aq.j());
      parambs.a(paramaq.d);
      parambs.b();
      parambs.a(aq.k());
      parambs.a(paramaq.e);
      parambs.b();
      parambs.a(aq.l());
      parambs.a(paramaq.f);
      parambs.b();
      if (paramaq.g != null)
      {
        parambs.a(aq.m());
        parambs.a(paramaq.g);
        parambs.b();
      }
      if (paramaq.h != null)
      {
        parambs.a(aq.n());
        parambs.a(paramaq.h);
        parambs.b();
      }
      if (paramaq.i != null)
      {
        parambs.a(aq.o());
        parambs.a(paramaq.i);
        parambs.b();
      }
      if (paramaq.d())
      {
        parambs.a(aq.p());
        parambs.a(paramaq.j);
        parambs.b();
      }
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public aq.a a()
    {
      return new aq.a(null);
    }
  }
  
  private static class c
    extends cc<aq>
  {
    public void a(bs parambs, aq paramaq)
    {
      parambs = (by)parambs;
      parambs.a(paramaq.a);
      parambs.a(paramaq.b);
      parambs.a(paramaq.c);
      parambs.a(paramaq.d);
      parambs.a(paramaq.e);
      parambs.a(paramaq.f);
      parambs.a(paramaq.g);
      parambs.a(paramaq.h);
      parambs.a(paramaq.i);
      BitSet localBitSet = new BitSet();
      if (paramaq.d()) {
        localBitSet.set(0);
      }
      parambs.a(localBitSet, 1);
      if (paramaq.d()) {
        parambs.a(paramaq.j);
      }
    }
    
    public void b(bs parambs, aq paramaq)
    {
      parambs = (by)parambs;
      paramaq.a = parambs.v();
      paramaq.a(true);
      paramaq.b = parambs.v();
      paramaq.b(true);
      paramaq.c = parambs.v();
      paramaq.c(true);
      paramaq.d = parambs.s();
      paramaq.d(true);
      paramaq.e = parambs.s();
      paramaq.e(true);
      paramaq.f = parambs.s();
      paramaq.f(true);
      paramaq.g = parambs.w();
      paramaq.g(true);
      paramaq.h = parambs.v();
      paramaq.h(true);
      paramaq.i = parambs.v();
      paramaq.i(true);
      if (parambs.b(1).get(0))
      {
        paramaq.j = parambs.s();
        paramaq.j(true);
      }
    }
  }
  
  private static class d
    implements ca
  {
    public aq.c a()
    {
      return new aq.c(null);
    }
  }
  
  public static enum e
  {
    private static final Map<String, e> k;
    private final short l;
    private final String m;
    
    static
    {
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        k.put(locale.a(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
    }
    
    public String a()
    {
      return this.m;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */