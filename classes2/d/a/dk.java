package d.a;

import android.content.Context;
import android.text.TextUtils;
import com.f.a.c;
import com.f.a.e;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class dk
{
  private static final byte[] a = "pbl0".getBytes();
  private static dk e;
  private s b;
  private a c = new a();
  private ak d = null;
  private Context f;
  
  dk(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private ak a(ak paramak1, ak paramak2)
  {
    if (paramak2 == null) {
      return paramak1;
    }
    Map localMap = paramak1.a();
    Iterator localIterator = paramak2.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((am)localEntry.getValue()).b()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      } else {
        localMap.remove(localEntry.getKey());
      }
    }
    paramak1.a(paramak2.c());
    paramak1.a(a(paramak1));
    return paramak1;
  }
  
  public static dk a(Context paramContext)
  {
    try
    {
      if (e == null)
      {
        e = new dk(paramContext);
        e.c();
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private boolean c(ak paramak)
  {
    if (!paramak.e().equals(a(paramak))) {
      return false;
    }
    paramak = paramak.a().values().iterator();
    while (paramak.hasNext())
    {
      Object localObject = (am)paramak.next();
      byte[] arrayOfByte = e.a(((am)localObject).e());
      localObject = a((am)localObject);
      int i = 0;
      while (i < 4)
      {
        if (arrayOfByte[i] != localObject[i]) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private ak d(ak paramak)
  {
    Map localMap = paramak.a();
    Object localObject = new ArrayList(localMap.size() / 2);
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((am)localEntry.getValue()).b()) {
        ((List)localObject).add(localEntry.getKey());
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localMap.remove((String)((Iterator)localObject).next());
    }
    return paramak;
  }
  
  public ak a()
  {
    try
    {
      ak localak = this.d;
      return localak;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String a(ak paramak)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = new TreeMap(paramak.a()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      if (((am)localEntry.getValue()).b()) {
        localStringBuilder.append(((am)localEntry.getValue()).a());
      }
      localStringBuilder.append(((am)localEntry.getValue()).c());
      localStringBuilder.append(((am)localEntry.getValue()).e());
    }
    localStringBuilder.append(paramak.b);
    return aw.a(localStringBuilder.toString()).toLowerCase(Locale.US);
  }
  
  public void a(s params)
  {
    this.b = params;
  }
  
  public byte[] a(am paramam)
  {
    Object localObject = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject).order(null);
    ((ByteBuffer)localObject).putLong(paramam.c());
    paramam = ((ByteBuffer)localObject).array();
    localObject = a;
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = ((byte)(paramam[i] ^ localObject[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public a b()
  {
    return this.c;
  }
  
  /* Error */
  public void b(ak paramak)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 218	d/a/dk:c	(Ld/a/ak;)Z
    //   12: ifeq -6 -> 6
    //   15: iconst_0
    //   16: istore 5
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 40	d/a/dk:d	Ld/a/ak;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnonnull +85 -> 113
    //   31: aconst_null
    //   32: astore_2
    //   33: aload 4
    //   35: ifnonnull +87 -> 122
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 220	d/a/dk:d	(Ld/a/ak;)Ld/a/ak;
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: putfield 40	d/a/dk:d	Ld/a/ak;
    //   49: aload_1
    //   50: ifnonnull +83 -> 133
    //   53: aload_3
    //   54: astore_1
    //   55: aload_0
    //   56: aload_2
    //   57: aload_1
    //   58: invokespecial 222	d/a/dk:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: ifne +6 -> 67
    //   64: iconst_1
    //   65: istore 5
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_0
    //   70: getfield 40	d/a/dk:d	Ld/a/ak;
    //   73: ifnull -67 -> 6
    //   76: iload 5
    //   78: ifeq -72 -> 6
    //   81: aload_0
    //   82: getfield 38	d/a/dk:c	Ld/a/dk$a;
    //   85: aload_0
    //   86: getfield 40	d/a/dk:d	Ld/a/ak;
    //   89: invokevirtual 224	d/a/dk$a:a	(Ld/a/ak;)V
    //   92: aload_0
    //   93: getfield 197	d/a/dk:b	Ld/a/s;
    //   96: ifnull -90 -> 6
    //   99: aload_0
    //   100: getfield 197	d/a/dk:b	Ld/a/s;
    //   103: aload_0
    //   104: getfield 38	d/a/dk:c	Ld/a/dk$a;
    //   107: invokeinterface 229 2 0
    //   112: return
    //   113: aload 4
    //   115: invokevirtual 118	d/a/ak:e	()Ljava/lang/String;
    //   118: astore_2
    //   119: goto -86 -> 33
    //   122: aload_0
    //   123: aload 4
    //   125: aload_1
    //   126: invokespecial 231	d/a/dk:a	(Ld/a/ak;Ld/a/ak;)Ld/a/ak;
    //   129: astore_1
    //   130: goto -86 -> 44
    //   133: aload_1
    //   134: invokevirtual 118	d/a/ak:e	()Ljava/lang/String;
    //   137: astore_1
    //   138: goto -83 -> 55
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	dk
    //   0	146	1	paramak	ak
    //   32	87	2	str	String
    //   1	53	3	localObject	Object
    //   24	100	4	localak	ak
    //   16	61	5	i	int
    // Exception table:
    //   from	to	target	type
    //   20	26	141	finally
    //   38	44	141	finally
    //   44	49	141	finally
    //   55	64	141	finally
    //   67	69	141	finally
    //   113	119	141	finally
    //   122	130	141	finally
    //   133	138	141	finally
    //   142	144	141	finally
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 235	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 42	d/a/dk:f	Landroid/content/Context;
    //   13: invokevirtual 241	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: ldc -13
    //   18: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: invokevirtual 249	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload_0
    //   29: getfield 42	d/a/dk:f	Landroid/content/Context;
    //   32: ldc -13
    //   34: invokevirtual 253	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_2
    //   40: aload_1
    //   41: invokestatic 256	d/a/aw:b	(Ljava/io/InputStream;)[B
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_1
    //   48: invokestatic 259	d/a/aw:c	(Ljava/io/InputStream;)V
    //   51: aload_2
    //   52: ifnull -25 -> 27
    //   55: new 45	d/a/ak
    //   58: dup
    //   59: invokespecial 260	d/a/ak:<init>	()V
    //   62: astore_1
    //   63: new 262	d/a/bd
    //   66: dup
    //   67: invokespecial 263	d/a/bd:<init>	()V
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual 266	d/a/bd:a	(Ld/a/ba;[B)V
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 40	d/a/dk:d	Ld/a/ak;
    //   80: aload_0
    //   81: getfield 38	d/a/dk:c	Ld/a/dk$a;
    //   84: aload_1
    //   85: invokevirtual 224	d/a/dk$a:a	(Ld/a/ak;)V
    //   88: return
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   94: return
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: invokestatic 259	d/a/aw:c	(Ljava/io/InputStream;)V
    //   108: aload 4
    //   110: astore_2
    //   111: goto -60 -> 51
    //   114: astore_1
    //   115: aload_2
    //   116: invokestatic 259	d/a/aw:c	(Ljava/io/InputStream;)V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -7 -> 115
    //   125: astore_3
    //   126: goto -28 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	dk
    //   37	48	1	localObject1	Object
    //   89	2	1	localException1	Exception
    //   97	8	1	localInputStream	java.io.InputStream
    //   114	6	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   1	115	2	localObject4	Object
    //   44	2	3	arrayOfByte	byte[]
    //   95	6	3	localException2	Exception
    //   125	1	3	localException3	Exception
    //   3	106	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   55	88	89	java/lang/Exception
    //   28	38	95	java/lang/Exception
    //   28	38	114	finally
    //   40	45	121	finally
    //   100	104	121	finally
    //   40	45	125	java/lang/Exception
  }
  
  public void d()
  {
    if (this.d == null) {
      return;
    }
    try
    {
      byte[] arrayOfByte = new bf().a(this.d);
      aw.a(new File(this.f.getFilesDir(), ".imprint"), arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static class a
  {
    private int a = -1;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private String f = null;
    private int g = -1;
    private String h = null;
    private int i = -1;
    private int j = -1;
    private String k = null;
    private String l = null;
    private String m = null;
    
    private int a(ak paramak, String paramString)
    {
      if ((paramak == null) || (!paramak.b())) {
        return -1;
      }
      paramak = (am)paramak.a().get(paramString);
      if ((paramak == null) || (TextUtils.isEmpty(paramak.a()))) {
        return -1;
      }
      try
      {
        int n = Integer.parseInt(paramak.a().trim());
        return n;
      }
      catch (Exception paramak) {}
      return -1;
    }
    
    private String b(ak paramak, String paramString)
    {
      if ((paramak == null) || (!paramak.b())) {
        return null;
      }
      paramak = (am)paramak.a().get(paramString);
      if ((paramak == null) || (TextUtils.isEmpty(paramak.a()))) {
        return null;
      }
      return paramak.a();
    }
    
    public int a(int paramInt)
    {
      if (this.a == -1) {}
      while ((this.a > 3) || (this.a < 0)) {
        return paramInt;
      }
      return this.a;
    }
    
    public long a(long paramLong)
    {
      if (this.j == -1) {}
      while (this.j < 48) {
        return paramLong;
      }
      return 3600000L * this.j;
    }
    
    public String a(String paramString)
    {
      if (this.k != null) {
        paramString = this.k;
      }
      return paramString;
    }
    
    public void a(ak paramak)
    {
      if (paramak == null) {
        return;
      }
      this.a = a(paramak, "defcon");
      this.b = a(paramak, "latent");
      this.c = a(paramak, "codex");
      this.d = a(paramak, "report_policy");
      this.e = a(paramak, "report_interval");
      this.f = b(paramak, "client_test");
      this.g = a(paramak, "test_report_interval");
      this.h = b(paramak, "umid");
      this.i = a(paramak, "integrated_test");
      this.j = a(paramak, "latent_hours");
      this.k = b(paramak, "country");
      this.l = b(paramak, "domain_p");
      this.m = b(paramak, "domain_s");
    }
    
    public boolean a()
    {
      return this.g != -1;
    }
    
    public int[] a(int paramInt1, int paramInt2)
    {
      if ((this.d == -1) || (!c.a(this.d))) {
        return new int[] { paramInt1, paramInt2 };
      }
      if ((this.e == -1) || (this.e < 90) || (this.e > 86400)) {
        this.e = 90;
      }
      return new int[] { this.d, this.e * 1000 };
    }
    
    public int b(int paramInt)
    {
      if (this.b == -1) {}
      while ((this.b < 0) || (this.b > 1800)) {
        return paramInt;
      }
      return this.b * 1000;
    }
    
    public String b(String paramString)
    {
      if ((this.f == null) || (!aa.a(this.f))) {
        return paramString;
      }
      return this.f;
    }
    
    public boolean b()
    {
      return this.i == 1;
    }
    
    public int c(int paramInt)
    {
      if ((this.c == 0) || (this.c == 1) || (this.c == -1)) {
        paramInt = this.c;
      }
      return paramInt;
    }
    
    public String c(String paramString)
    {
      return this.h;
    }
    
    public int d(int paramInt)
    {
      if ((this.g == -1) || (this.g < 90) || (this.g > 86400)) {
        return paramInt;
      }
      return this.g * 1000;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */