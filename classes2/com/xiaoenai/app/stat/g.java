package com.xiaoenai.app.stat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.ak;

public class g
{
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 12	com/xiaoenai/app/Xiaoenai:j	()Lcom/xiaoenai/app/Xiaoenai;
    //   6: new 14	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   13: ldc 20
    //   15: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 30	com/xiaoenai/app/model/AppModel:getInstance	()Lcom/xiaoenai/app/model/AppModel;
    //   21: invokevirtual 34	com/xiaoenai/app/model/AppModel:getUserId	()I
    //   24: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: iconst_0
    //   31: invokevirtual 44	com/xiaoenai/app/Xiaoenai:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   34: invokeinterface 50 1 0
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +16 -> 57
    //   44: aload_0
    //   45: invokeinterface 56 1 0
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +10 -> 64
    //   57: aconst_null
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: new 14	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   71: astore_1
    //   72: aload_0
    //   73: invokeinterface 60 1 0
    //   78: invokeinterface 66 1 0
    //   83: astore_2
    //   84: iconst_0
    //   85: istore 4
    //   87: aload_2
    //   88: invokeinterface 71 1 0
    //   93: ifeq +49 -> 142
    //   96: aload_2
    //   97: invokeinterface 75 1 0
    //   102: checkcast 77	java/lang/String
    //   105: astore_3
    //   106: iload 4
    //   108: ifle +10 -> 118
    //   111: aload_1
    //   112: ldc 79
    //   114: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: aload_0
    //   120: aload_3
    //   121: invokeinterface 83 2 0
    //   126: checkcast 77	java/lang/String
    //   129: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -52 -> 87
    //   142: aload_1
    //   143: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_0
    //   147: goto -88 -> 59
    //   150: astore_0
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_0
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	108	0	localObject1	Object
    //   150	5	0	localObject2	Object
    //   71	72	1	localStringBuilder	StringBuilder
    //   83	14	2	localIterator	java.util.Iterator
    //   105	16	3	str	String
    //   85	53	4	i	int
    //   50	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	40	150	finally
    //   44	52	150	finally
    //   64	84	150	finally
    //   87	106	150	finally
    //   111	118	150	finally
    //   118	133	150	finally
    //   142	147	150	finally
  }
  
  public static void a(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("stat_1_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.putString(String.valueOf(System.currentTimeMillis()), paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 12	com/xiaoenai/app/Xiaoenai:j	()Lcom/xiaoenai/app/Xiaoenai;
    //   6: new 14	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   13: ldc 111
    //   15: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 30	com/xiaoenai/app/model/AppModel:getInstance	()Lcom/xiaoenai/app/model/AppModel;
    //   21: invokevirtual 34	com/xiaoenai/app/model/AppModel:getUserId	()I
    //   24: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: iconst_0
    //   31: invokevirtual 44	com/xiaoenai/app/Xiaoenai:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   34: invokeinterface 50 1 0
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +16 -> 57
    //   44: aload_0
    //   45: invokeinterface 56 1 0
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +10 -> 64
    //   57: aconst_null
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: new 14	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   71: astore_1
    //   72: aload_0
    //   73: invokeinterface 60 1 0
    //   78: invokeinterface 66 1 0
    //   83: astore_2
    //   84: iconst_0
    //   85: istore 4
    //   87: aload_2
    //   88: invokeinterface 71 1 0
    //   93: ifeq +49 -> 142
    //   96: aload_2
    //   97: invokeinterface 75 1 0
    //   102: checkcast 77	java/lang/String
    //   105: astore_3
    //   106: iload 4
    //   108: ifle +10 -> 118
    //   111: aload_1
    //   112: ldc 79
    //   114: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: aload_0
    //   120: aload_3
    //   121: invokeinterface 83 2 0
    //   126: checkcast 77	java/lang/String
    //   129: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -52 -> 87
    //   142: aload_1
    //   143: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_0
    //   147: goto -88 -> 59
    //   150: astore_0
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_0
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	108	0	localObject1	Object
    //   150	5	0	localObject2	Object
    //   71	72	1	localStringBuilder	StringBuilder
    //   83	14	2	localIterator	java.util.Iterator
    //   105	16	3	str	String
    //   85	53	4	i	int
    //   50	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	40	150	finally
    //   44	52	150	finally
    //   64	84	150	finally
    //   87	106	150	finally
    //   111	118	150	finally
    //   118	133	150	finally
    //   142	147	150	finally
  }
  
  public static void b(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("stat_2_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.putString(String.valueOf(ak.b()), paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("stat_1_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void d()
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("stat_2_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\stat\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */