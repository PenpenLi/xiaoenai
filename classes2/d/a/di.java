package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class di
{
  public static di a;
  private final String b = "umeng_it.cache";
  private File c;
  private ai d = null;
  private long e;
  private long f;
  private Set<de> g = new HashSet();
  private a h = null;
  
  di(Context paramContext)
  {
    this.c = new File(paramContext.getFilesDir(), "umeng_it.cache");
    this.f = 86400000L;
    this.h = new a(paramContext);
    this.h.b();
  }
  
  public static di a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new di(paramContext);
        a.a(new dj(paramContext));
        a.a(new df(paramContext));
        a.a(new c(paramContext));
        a.a(new b(paramContext));
        a.a(new dh(paramContext));
        a.a(new dl(paramContext));
        a.a(new dm());
        a.a(new d(paramContext));
        a.d();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(ai paramai)
  {
    if (paramai != null) {}
    try
    {
      try
      {
        paramai = new bf().a(paramai);
        if (paramai != null) {
          aw.a(this.c, paramai);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception paramai)
    {
      paramai.printStackTrace();
    }
  }
  
  private void f()
  {
    ai localai = new ai();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      de localde = (de)localIterator.next();
      if (localde.d())
      {
        if (localde.e() != null) {
          localHashMap.put(localde.c(), localde.e());
        }
        if ((localde.f() != null) && (!localde.f().isEmpty())) {
          localArrayList.addAll(localde.f());
        }
      }
    }
    localai.a(localArrayList);
    localai.a(localHashMap);
    try
    {
      this.d = localai;
      return;
    }
    finally {}
  }
  
  /* Error */
  private ai g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	d/a/di:c	Ljava/io/File;
    //   4: invokevirtual 175	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 177	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 53	d/a/di:c	Ljava/io/File;
    //   20: invokespecial 180	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: invokestatic 183	d/a/aw:b	(Ljava/io/InputStream;)[B
    //   30: astore_3
    //   31: aload_2
    //   32: astore_1
    //   33: new 114	d/a/ai
    //   36: dup
    //   37: invokespecial 115	d/a/ai:<init>	()V
    //   40: astore 4
    //   42: aload_2
    //   43: astore_1
    //   44: new 185	d/a/bd
    //   47: dup
    //   48: invokespecial 186	d/a/bd:<init>	()V
    //   51: aload 4
    //   53: aload_3
    //   54: invokevirtual 189	d/a/bd:a	(Ld/a/ba;[B)V
    //   57: aload_2
    //   58: invokestatic 192	d/a/aw:c	(Ljava/io/InputStream;)V
    //   61: aload 4
    //   63: areturn
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   73: aload_2
    //   74: invokestatic 192	d/a/aw:c	(Ljava/io/InputStream;)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_1
    //   83: astore_2
    //   84: aload_3
    //   85: invokestatic 192	d/a/aw:c	(Ljava/io/InputStream;)V
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: goto -9 -> 84
    //   96: astore_3
    //   97: goto -30 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	di
    //   25	44	1	localObject1	Object
    //   79	13	1	localObject2	Object
    //   23	66	2	localObject3	Object
    //   90	1	2	localObject4	Object
    //   30	24	3	arrayOfByte	byte[]
    //   64	6	3	localException1	Exception
    //   81	12	3	localObject5	Object
    //   96	1	3	localException2	Exception
    //   40	22	4	localai	ai
    // Exception table:
    //   from	to	target	type
    //   12	24	64	java/lang/Exception
    //   12	24	79	finally
    //   26	31	90	finally
    //   33	42	90	finally
    //   44	57	90	finally
    //   69	73	90	finally
    //   26	31	96	java/lang/Exception
    //   33	42	96	java/lang/Exception
    //   44	57	96	java/lang/Exception
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (l - this.e >= this.f)
    {
      Iterator localIterator = this.g.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        de localde = (de)localIterator.next();
        if (localde.d()) {
          if (localde.b())
          {
            int j = 1;
            i = j;
            if (!localde.d())
            {
              this.h.b(localde.c());
              i = j;
            }
          }
        }
      }
      if (i != 0)
      {
        f();
        this.h.a();
        e();
      }
      this.e = l;
    }
  }
  
  public boolean a(de paramde)
  {
    if (this.h.a(paramde.c())) {
      return this.g.add(paramde);
    }
    return false;
  }
  
  public ai b()
  {
    return this.d;
  }
  
  public void c()
  {
    Iterator localIterator = this.g.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      de localde = (de)localIterator.next();
      if (localde.d())
      {
        if ((localde.f() == null) || (localde.f().isEmpty())) {
          break label84;
        }
        localde.a(null);
        i = 1;
      }
    }
    label84:
    for (;;)
    {
      break;
      if (i != 0)
      {
        this.d.b(false);
        e();
      }
      return;
    }
  }
  
  public void d()
  {
    Object localObject2 = g();
    if (localObject2 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.g.size());
    try
    {
      this.d = ((ai)localObject2);
      localObject2 = this.g.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        de localde = (de)((Iterator)localObject2).next();
        localde.a(this.d);
        if (!localde.d()) {
          localArrayList.add(localde);
        }
      }
      localIterator = ((List)localObject1).iterator();
    }
    finally {}
    Iterator localIterator;
    while (localIterator.hasNext())
    {
      localObject2 = (de)localIterator.next();
      this.g.remove(localObject2);
    }
    f();
  }
  
  public void e()
  {
    if (this.d != null) {
      a(this.d);
    }
  }
  
  public static class a
  {
    private Context a;
    private Set<String> b = new HashSet();
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void a()
    {
      if (!this.b.isEmpty())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append((String)localIterator.next());
          localStringBuilder.append(',');
        }
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        t.a(this.a).edit().putString("invld_id", localStringBuilder.toString()).commit();
      }
    }
    
    public boolean a(String paramString)
    {
      return !this.b.contains(paramString);
    }
    
    public void b()
    {
      Object localObject = t.a(this.a).getString("invld_id", null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if (!TextUtils.isEmpty(localCharSequence)) {
              this.b.add(localCharSequence);
            }
            i += 1;
          }
        }
      }
    }
    
    public void b(String paramString)
    {
      this.b.add(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */