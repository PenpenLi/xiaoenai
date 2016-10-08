package com.xiaoenai.app.classes.chat.messagelist;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class i<T extends a>
  extends Vector<a>
{
  private Set<Long> a = new HashSet();
  private int b = 0;
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt, a parama)
  {
    this.b += 1;
    if (parama.h() == -1L) {
      super.add(paramInt, parama);
    }
    while (this.a.contains(Long.valueOf(parama.h()))) {
      return;
    }
    this.a.add(Long.valueOf(parama.h()));
    super.add(paramInt, parama);
  }
  
  /* Error */
  public boolean a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 21	com/xiaoenai/app/classes/chat/messagelist/i:b	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 21	com/xiaoenai/app/classes/chat/messagelist/i:b	I
    //   12: aload_1
    //   13: invokevirtual 30	com/xiaoenai/app/classes/chat/messagelist/message/a/a:h	()J
    //   16: ldc2_w 31
    //   19: lcmp
    //   20: ifne +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 52	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 19	com/xiaoenai/app/classes/chat/messagelist/i:a	Ljava/util/Set;
    //   37: aload_1
    //   38: invokevirtual 30	com/xiaoenai/app/classes/chat/messagelist/message/a/a:h	()J
    //   41: invokestatic 42	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   44: invokeinterface 48 2 0
    //   49: ifne +29 -> 78
    //   52: aload_0
    //   53: getfield 19	com/xiaoenai/app/classes/chat/messagelist/i:a	Ljava/util/Set;
    //   56: aload_1
    //   57: invokevirtual 30	com/xiaoenai/app/classes/chat/messagelist/message/a/a:h	()J
    //   60: invokestatic 42	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   63: invokeinterface 50 2 0
    //   68: pop
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 52	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   74: istore_2
    //   75: goto -46 -> 29
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -51 -> 29
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	i
    //   0	88	1	parama	a
    //   28	52	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	29	83	finally
    //   33	75	83	finally
  }
  
  public void clear()
  {
    this.b = 0;
    this.a.clear();
    super.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    paramObject = (a)paramObject;
    boolean bool = false;
    if (this.a.contains(Long.valueOf(((a)paramObject).h()))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean remove(Object paramObject)
  {
    this.b -= 1;
    a locala = (a)paramObject;
    if (this.a.contains(Long.valueOf(locala.h()))) {
      this.a.remove(Long.valueOf(locala.h()));
    }
    return super.remove(paramObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */