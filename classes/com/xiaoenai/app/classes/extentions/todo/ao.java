package com.xiaoenai.app.classes.extentions.todo;

import android.util.SparseArray;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.d.av;
import com.xiaoenai.app.model.UserConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ao
{
  private static volatile ao b = null;
  Comparator<b> a = new ap(this);
  private ArrayList<b> c = null;
  private SparseArray<b> d = new SparseArray();
  private av e = new av();
  private boolean f = true;
  
  private ao()
  {
    String str = UserConfig.getString("extention_todo", null);
    if (str != null) {}
    for (;;)
    {
      try
      {
        a(new JSONObject(str));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject = this.e.a();
      this.c.addAll((Collection)localObject);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        this.d.put(localb.e(), localb);
      }
    }
  }
  
  public static ao a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ao();
      }
      return b;
    }
    finally {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      if (!paramJSONObject.getBoolean("success")) {
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int j = paramJSONObject.length();
      int i = 0;
      b localb;
      while (i < j)
      {
        localb = b.a(paramJSONObject.getJSONObject(i));
        this.d.put(localb.e(), localb);
        i += 1;
      }
      paramJSONObject = this.c.iterator();
      while (paramJSONObject.hasNext())
      {
        localb = (b)paramJSONObject.next();
        this.e.a(localb);
      }
      UserConfig.remove("extention_todo");
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
  }
  
  public static void g()
  {
    b = null;
  }
  
  public b a(int paramInt)
  {
    return (b)this.c.get(paramInt);
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/xiaoenai/app/classes/extentions/todo/ao:d	Landroid/util/SparseArray;
    //   6: aload_1
    //   7: invokevirtual 100	com/xiaoenai/app/classes/extentions/todo/a/b:e	()I
    //   10: invokevirtual 144	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   13: checkcast 97	com/xiaoenai/app/classes/extentions/todo/a/b
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +85 -> 103
    //   21: aload_0
    //   22: getfield 48	com/xiaoenai/app/classes/extentions/todo/ao:d	Landroid/util/SparseArray;
    //   25: invokevirtual 147	android/util/SparseArray:size	()I
    //   28: ifle +43 -> 71
    //   31: aload_0
    //   32: getfield 48	com/xiaoenai/app/classes/extentions/todo/ao:d	Landroid/util/SparseArray;
    //   35: iconst_0
    //   36: invokevirtual 150	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   39: checkcast 97	com/xiaoenai/app/classes/extentions/todo/a/b
    //   42: invokevirtual 153	com/xiaoenai/app/classes/extentions/todo/a/b:b	()J
    //   45: aload_1
    //   46: invokevirtual 153	com/xiaoenai/app/classes/extentions/todo/a/b:b	()J
    //   49: lcmp
    //   50: ifge +21 -> 71
    //   53: aload_1
    //   54: invokevirtual 155	com/xiaoenai/app/classes/extentions/todo/a/b:d	()I
    //   57: invokestatic 161	com/xiaoenai/app/model/User:getInstance	()Lcom/xiaoenai/app/model/User;
    //   60: invokevirtual 164	com/xiaoenai/app/model/User:getUserId	()I
    //   63: if_icmpeq +8 -> 71
    //   66: aload_1
    //   67: iconst_1
    //   68: invokevirtual 167	com/xiaoenai/app/classes/extentions/todo/a/b:a	(Z)V
    //   71: aload_0
    //   72: getfield 48	com/xiaoenai/app/classes/extentions/todo/ao:d	Landroid/util/SparseArray;
    //   75: aload_1
    //   76: invokevirtual 100	com/xiaoenai/app/classes/extentions/todo/a/b:e	()I
    //   79: aload_1
    //   80: invokevirtual 104	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   83: aload_0
    //   84: getfield 53	com/xiaoenai/app/classes/extentions/todo/ao:e	Lcom/xiaoenai/app/d/av;
    //   87: aload_1
    //   88: invokevirtual 134	com/xiaoenai/app/d/av:a	(Lcom/xiaoenai/app/classes/extentions/todo/a/b;)V
    //   91: aload_0
    //   92: getfield 31	com/xiaoenai/app/classes/extentions/todo/ao:c	Ljava/util/ArrayList;
    //   95: aload_1
    //   96: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 174	com/xiaoenai/app/classes/extentions/todo/ao:b	(Lcom/xiaoenai/app/classes/extentions/todo/a/b;)Z
    //   108: ifne +12 -> 120
    //   111: aload_0
    //   112: getfield 31	com/xiaoenai/app/classes/extentions/todo/ao:c	Ljava/util/ArrayList;
    //   115: aload_1
    //   116: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: aload_2
    //   121: invokevirtual 153	com/xiaoenai/app/classes/extentions/todo/a/b:b	()J
    //   124: aload_1
    //   125: invokevirtual 153	com/xiaoenai/app/classes/extentions/todo/a/b:b	()J
    //   128: lcmp
    //   129: ifeq +59 -> 188
    //   132: aload_1
    //   133: invokevirtual 155	com/xiaoenai/app/classes/extentions/todo/a/b:d	()I
    //   136: invokestatic 161	com/xiaoenai/app/model/User:getInstance	()Lcom/xiaoenai/app/model/User;
    //   139: invokevirtual 164	com/xiaoenai/app/model/User:getUserId	()I
    //   142: if_icmpeq +8 -> 150
    //   145: aload_1
    //   146: iconst_1
    //   147: invokevirtual 167	com/xiaoenai/app/classes/extentions/todo/a/b:a	(Z)V
    //   150: aload_2
    //   151: invokevirtual 155	com/xiaoenai/app/classes/extentions/todo/a/b:d	()I
    //   154: invokestatic 161	com/xiaoenai/app/model/User:getInstance	()Lcom/xiaoenai/app/model/User;
    //   157: invokevirtual 164	com/xiaoenai/app/model/User:getUserId	()I
    //   160: if_icmpeq +8 -> 168
    //   163: aload_2
    //   164: iconst_1
    //   165: invokevirtual 167	com/xiaoenai/app/classes/extentions/todo/a/b:a	(Z)V
    //   168: aload_0
    //   169: getfield 48	com/xiaoenai/app/classes/extentions/todo/ao:d	Landroid/util/SparseArray;
    //   172: aload_1
    //   173: invokevirtual 100	com/xiaoenai/app/classes/extentions/todo/a/b:e	()I
    //   176: aload_1
    //   177: invokevirtual 104	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   180: aload_0
    //   181: getfield 53	com/xiaoenai/app/classes/extentions/todo/ao:e	Lcom/xiaoenai/app/d/av;
    //   184: aload_1
    //   185: invokevirtual 134	com/xiaoenai/app/d/av:a	(Lcom/xiaoenai/app/classes/extentions/todo/a/b;)V
    //   188: aload_2
    //   189: aload_1
    //   190: invokevirtual 175	com/xiaoenai/app/classes/extentions/todo/a/b:a	(Lcom/xiaoenai/app/classes/extentions/todo/a/b;)V
    //   193: goto -93 -> 100
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	ao
    //   0	201	1	paramb	b
    //   16	173	2	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	17	196	finally
    //   21	71	196	finally
    //   71	100	196	finally
    //   103	120	196	finally
    //   120	150	196	finally
    //   150	168	196	finally
    //   168	188	196	finally
    //   188	193	196	finally
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public b b(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.e() == paramInt) {
        return localb;
      }
    }
    return (b)this.d.get(paramInt);
  }
  
  public List<b> b()
  {
    return this.c;
  }
  
  public boolean b(b paramb)
  {
    if (this.c.contains(paramb)) {
      return true;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramb.e() == localb.e()) {
        return true;
      }
    }
    return false;
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public void c(b paramb)
  {
    try
    {
      this.d.put(paramb.e(), paramb);
      this.e.a(paramb);
      this.c.add(0, paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void d()
  {
    this.c.clear();
  }
  
  public void d(b paramb)
  {
    this.e.a(paramb);
  }
  
  public void e()
  {
    this.e.b();
    this.c.clear();
    TodoDetailActivity.d();
  }
  
  public void e(b paramb)
  {
    try
    {
      this.d.remove(paramb.e());
      this.e.c(paramb);
      this.c.remove(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public boolean f()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */