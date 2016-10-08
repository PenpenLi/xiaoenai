package com.xiaoenai.app.database.b.a;

import a.a.a.g;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c
{
  private static final Map<Class, String> a = new ArrayMap(10);
  
  static
  {
    a.put(Boolean.class, "INTEGER");
    a.put(Byte.class, "INTEGER");
    a.put(Short.class, "INTEGER");
    a.put(Integer.class, "INTEGER");
    a.put(Long.class, "INTEGER");
    a.put(Float.class, "REAL");
    a.put(Double.class, "REAL");
    a.put(String.class, "TEXT");
    a.put(Byte[].class, "BLOB");
    a.put(Date.class, "INTEGER");
  }
  
  private static String a(Class<?> paramClass)
  {
    return (String)a.get(paramClass);
  }
  
  /* Error */
  private static List<String> a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: new 64	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   13: ldc 68
    //   15: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 74
    //   24: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: aconst_null
    //   31: invokevirtual 84	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_0
    //   35: aload 4
    //   37: astore_2
    //   38: aload_0
    //   39: ifnull +29 -> 68
    //   42: aload 4
    //   44: astore_2
    //   45: aload_0
    //   46: astore_1
    //   47: aload_0
    //   48: invokeinterface 90 1 0
    //   53: ifle +15 -> 68
    //   56: aload_0
    //   57: astore_1
    //   58: aload_0
    //   59: invokeinterface 94 1 0
    //   64: invokestatic 100	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   67: astore_2
    //   68: aload_0
    //   69: ifnull +9 -> 78
    //   72: aload_0
    //   73: invokeinterface 103 1 0
    //   78: aload_2
    //   79: astore_0
    //   80: aload_2
    //   81: ifnonnull +11 -> 92
    //   84: new 105	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 106	java/util/ArrayList:<init>	()V
    //   91: astore_0
    //   92: aload_0
    //   93: areturn
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: astore_1
    //   99: aload_2
    //   100: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   103: aload_0
    //   104: ifnull +9 -> 113
    //   107: aload_0
    //   108: invokeinterface 103 1 0
    //   113: aload_3
    //   114: astore_0
    //   115: iconst_0
    //   116: ifne -24 -> 92
    //   119: new 105	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 106	java/util/ArrayList:<init>	()V
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +9 -> 140
    //   134: aload_1
    //   135: invokeinterface 103 1 0
    //   140: iconst_0
    //   141: ifne +11 -> 152
    //   144: new 105	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 106	java/util/ArrayList:<init>	()V
    //   151: pop
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: goto -25 -> 130
    //   158: astore_2
    //   159: goto -62 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	162	1	paramString	String
    //   37	44	2	localObject1	Object
    //   94	6	2	localException1	Exception
    //   158	1	2	localException2	Exception
    //   1	113	3	localObject2	Object
    //   3	40	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	35	94	java/lang/Exception
    //   5	35	127	finally
    //   47	56	154	finally
    //   58	68	154	finally
    //   99	103	154	finally
    //   47	56	158	java/lang/Exception
    //   58	68	158	java/lang/Exception
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean, @NonNull Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs.length < 1) {}
    for (;;)
    {
      return;
      try
      {
        int j = paramVarArgs.length;
        while (i < j)
        {
          paramVarArgs[i].getDeclaredMethod(paramString, new Class[] { SQLiteDatabase.class, Boolean.TYPE }).invoke(null, new Object[] { paramSQLiteDatabase, Boolean.valueOf(paramBoolean) });
          i += 1;
        }
        return;
      }
      catch (NoSuchMethodException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return;
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, @NonNull Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    a(paramSQLiteDatabase, "dropTable", paramBoolean, paramVarArgs);
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    b(paramSQLiteDatabase, paramVarArgs);
    a(paramSQLiteDatabase, true, paramVarArgs);
    b(paramSQLiteDatabase, false, paramVarArgs);
    c(paramSQLiteDatabase, paramVarArgs);
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, @NonNull Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    a(paramSQLiteDatabase, "createTable", paramBoolean, paramVarArgs);
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    int j = 0;
    if (j < paramVarArgs.length)
    {
      Object localObject = new a.a.a.c.a(paramSQLiteDatabase, paramVarArgs[j]);
      String str1 = ((a.a.a.c.a)localObject).b;
      String str2 = ((a.a.a.c.a)localObject).b.concat("_TEMP");
      List localList = a(paramSQLiteDatabase, str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CREATE TEMPORARY TABLE ").append(str2).append(" (");
      ArrayList localArrayList = new ArrayList();
      int i = 1;
      int k = 0;
      if (k < ((a.a.a.c.a)localObject).c.length)
      {
        g localg = localObject.c[k];
        int m = i;
        if (localList.contains(localg.e))
        {
          localArrayList.add(localg.e);
          if (i == 0) {
            break label215;
          }
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append(localg.e).append(" ");
          localStringBuilder.append(a(localg.b));
          m = i;
          if (localg.d)
          {
            localStringBuilder.append(" PRIMARY KEY");
            m = i;
          }
          k += 1;
          i = m;
          break;
          label215:
          localStringBuilder.append(",");
        }
      }
      if (localArrayList.isEmpty()) {}
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(");");
        paramSQLiteDatabase.execSQL(localStringBuilder.toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" INSERT INTO ").append(str2);
        ((StringBuilder)localObject).append(" SELECT * FROM ").append(str1).append(";");
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static void c(SQLiteDatabase paramSQLiteDatabase, Class<? extends a.a.a.a<?, ?>>... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Object localObject2 = new a.a.a.c.a(paramSQLiteDatabase, paramVarArgs[i]);
      Object localObject1 = ((a.a.a.c.a)localObject2).b;
      String str1 = ((a.a.a.c.a)localObject2).b.concat("_TEMP");
      Object localObject3 = a(paramSQLiteDatabase, str1);
      ArrayList localArrayList = new ArrayList(((List)localObject3).size());
      int j = 0;
      while (j < ((a.a.a.c.a)localObject2).c.length)
      {
        String str2 = localObject2.c[j].e;
        if (((List)localObject3).contains(str2)) {
          localArrayList.add(str2);
        }
        j += 1;
      }
      if (localArrayList.size() > 0)
      {
        localObject2 = TextUtils.join(",", localArrayList);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("INSERT INTO ").append((String)localObject1).append(" (");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(") SELECT ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" FROM ").append(str1).append(";");
        paramSQLiteDatabase.execSQL(((StringBuilder)localObject3).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DROP TABLE ").append(str1);
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject1).toString());
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */