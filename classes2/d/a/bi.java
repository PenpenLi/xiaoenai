package d.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class bi
  implements Serializable
{
  private static Map<Class<? extends ba>, Map<? extends Object, bi>> d = new HashMap();
  public final String a;
  public final byte b;
  public final bj c;
  
  public bi(String paramString, byte paramByte, bj parambj)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = parambj;
  }
  
  public static void a(Class<? extends ba> paramClass, Map<? extends Object, bi> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */