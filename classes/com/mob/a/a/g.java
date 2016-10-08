package com.mob.a.a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.util.ArrayList;
import java.util.HashMap;

public class g
{
  /* Error */
  public static long a(Context paramContext, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_3
    //   4: invokestatic 12	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore 7
    //   9: iload 7
    //   11: ifeq +12 -> 23
    //   14: ldc2_w 13
    //   17: lstore_1
    //   18: ldc 2
    //   20: monitorexit
    //   21: lload_1
    //   22: lreturn
    //   23: aload_0
    //   24: invokestatic 19	com/mob/a/a/c:a	(Landroid/content/Context;)Lcom/mob/a/a/c;
    //   27: astore_0
    //   28: new 21	android/content/ContentValues
    //   31: dup
    //   32: invokespecial 25	android/content/ContentValues:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc 27
    //   41: lload_1
    //   42: invokestatic 33	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 37	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   48: aload 6
    //   50: ldc 39
    //   52: aload_3
    //   53: invokevirtual 45	java/lang/String:toString	()Ljava/lang/String;
    //   56: invokevirtual 48	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 6
    //   61: ldc 50
    //   63: iload 4
    //   65: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 58	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   71: aload 6
    //   73: ldc 60
    //   75: aload 5
    //   77: invokevirtual 48	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: ldc 62
    //   83: aload 6
    //   85: invokevirtual 65	com/mob/a/a/c:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   88: lstore_1
    //   89: goto -71 -> 18
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramLong	long
    //   0	98	3	paramString1	String
    //   0	98	4	paramInt	int
    //   0	98	5	paramString2	String
    //   35	49	6	localContentValues	android.content.ContentValues
    //   7	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	92	finally
    //   23	89	92	finally
  }
  
  public static long a(Context paramContext, ArrayList<String> paramArrayList)
  {
    long l;
    if (paramArrayList == null) {
      l = 0L;
    }
    for (;;)
    {
      return l;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramArrayList.size())
        {
          localStringBuilder.append("'");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.append("'");
          localStringBuilder.append(",");
          i += 1;
        }
        paramArrayList = localStringBuilder.toString().substring(0, localStringBuilder.length() - 1);
        i = c.a(paramContext).a("table_exception", "exception_md5 in ( " + paramArrayList + " )", null);
        e.a().i("delete COUNT == %s", new Object[] { Integer.valueOf(i) });
        l = i;
      }
      finally {}
    }
  }
  
  private static ArrayList<f> a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      f localf = new f();
      c localc = c.a(paramContext);
      String str = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = str;
        if (paramArrayOfString != null)
        {
          paramContext = str;
          if (paramArrayOfString.length > 0) {
            paramContext = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + paramString + " group by exception_md5 having max(_id)";
          }
        }
      }
      paramString = localc.a(paramContext, paramArrayOfString);
      do
      {
        paramContext = localf;
        if (paramString == null) {
          break;
        }
        paramContext = localf;
        if (!paramString.moveToNext()) {
          break;
        }
        localf.b.add(paramString.getString(0));
        paramContext = new HashMap();
        paramContext.put("type", Integer.valueOf(paramString.getInt(1)));
        paramContext.put("errat", Long.valueOf(paramString.getLong(2)));
        paramContext.put("msg", Base64.encodeToString(paramString.getString(3).getBytes(), 2));
        paramContext.put("times", Integer.valueOf(paramString.getInt(4)));
        localf.a.add(paramContext);
      } while (localf.b.size() != 50);
      localArrayList.add(localf);
      paramContext = new f();
      paramString.close();
      if (paramContext.b.size() != 0) {
        localArrayList.add(paramContext);
      }
      return localArrayList;
    }
    finally {}
  }
  
  public static ArrayList<f> a(Context paramContext, String[] paramArrayOfString)
  {
    String str = "exception_level = ?";
    if (paramArrayOfString != null) {}
    for (String[] arrayOfString = paramArrayOfString;; arrayOfString = null) {
      try
      {
        if (paramArrayOfString.length > 0)
        {
          if (c.a(paramContext).a("table_exception") > 0) {}
          for (paramContext = a(paramContext, str, arrayOfString);; paramContext = new ArrayList()) {
            return paramContext;
          }
        }
        str = null;
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */