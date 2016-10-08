package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import com.ta.utdid2.b.a.f;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.b.a.j;

public class a
{
  private static final String TAG = a.class.getName();
  private static a a = null;
  private Context mContext;
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private String b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/ta/utdid2/a/a:mContext	Landroid/content/Context;
    //   6: ifnonnull +21 -> 27
    //   9: getstatic 22	com/ta/utdid2/a/a:TAG	Ljava/lang/String;
    //   12: ldc 36
    //   14: invokestatic 42	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: ldc 44
    //   20: astore 4
    //   22: aload_0
    //   23: monitorexit
    //   24: aload 4
    //   26: areturn
    //   27: ldc 44
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 29	com/ta/utdid2/a/a:mContext	Landroid/content/Context;
    //   35: invokestatic 49	com/ta/utdid2/b/a/f:a	(Landroid/content/Context;)Z
    //   38: ifeq +27 -> 65
    //   41: aload_0
    //   42: getfield 29	com/ta/utdid2/a/a:mContext	Landroid/content/Context;
    //   45: invokestatic 54	com/ta/utdid2/a/b:a	(Landroid/content/Context;)Lcom/ta/utdid2/a/b;
    //   48: aload_1
    //   49: aload_2
    //   50: aload_3
    //   51: aload_0
    //   52: getfield 29	com/ta/utdid2/a/a:mContext	Landroid/content/Context;
    //   55: aload_1
    //   56: aload_2
    //   57: invokestatic 59	com/ta/utdid2/a/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: invokevirtual 62	com/ta/utdid2/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 29	com/ta/utdid2/a/a:mContext	Landroid/content/Context;
    //   69: aload_1
    //   70: aload 4
    //   72: aload_2
    //   73: invokestatic 65	com/ta/utdid2/a/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   76: goto -54 -> 22
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	a
    //   0	84	1	paramString1	String
    //   0	84	2	paramString2	String
    //   0	84	3	paramString3	String
    //   20	51	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	18	79	finally
    //   31	65	79	finally
    //   65	76	79	finally
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if ((this.mContext == null) || (i.a(paramString1)) || (i.a(paramString2)))
    {
      paramString3 = TAG;
      localObject = new StringBuilder().append("mContext:").append(this.mContext).append("; has appName:");
      if (!i.a(paramString1))
      {
        bool1 = true;
        paramString1 = ((StringBuilder)localObject).append(bool1).append("; has token:");
        if (i.a(paramString2)) {
          break label115;
        }
        bool1 = bool2;
        label88:
        Log.e(paramString3, bool1);
        localObject = "";
      }
    }
    label115:
    label160:
    do
    {
      String str;
      do
      {
        return (String)localObject;
        bool1 = false;
        break;
        bool1 = false;
        break label88;
        str = c.a(this.mContext, paramString1, paramString2);
        if (i.a(str)) {
          break label160;
        }
        localObject = str;
      } while (j.a(c.a(this.mContext, paramString1, paramString2), 1));
      localObject = str;
    } while (!f.a(this.mContext));
    return b(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, com.ut.device.a parama)
  {
    boolean bool2 = true;
    if (parama == null)
    {
      Log.e(TAG, "callback is null!");
      return;
    }
    if ((this.mContext == null) || (i.a(paramString1)) || (i.a(paramString2)))
    {
      paramString3 = TAG;
      localObject = new StringBuilder().append("mContext:").append(this.mContext).append("; callback:").append(parama).append("; has appName:");
      if (!i.a(paramString1))
      {
        bool1 = true;
        paramString1 = ((StringBuilder)localObject).append(bool1).append("; has token:");
        if (i.a(paramString2)) {
          break label146;
        }
      }
      label146:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Log.e(paramString3, bool1);
        parama.a(1002, "");
        return;
        bool1 = false;
        break;
      }
    }
    Object localObject = c.a(this.mContext, paramString1, paramString2);
    if ((!i.a((String)localObject)) && (j.a(c.a(this.mContext, paramString1, paramString2), 1)))
    {
      parama.a(1001, (String)localObject);
      return;
    }
    if (f.a(this.mContext))
    {
      b.a(this.mContext).a(paramString1, paramString2, paramString3, (String)localObject, parama);
      return;
    }
    parama.a(1003, (String)localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */