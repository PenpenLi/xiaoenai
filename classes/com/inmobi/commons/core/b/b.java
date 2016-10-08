package com.inmobi.commons.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final String a = b.class.getSimpleName();
  private static volatile b b;
  private static final Object c = new Object();
  private static final Object d = new Object();
  private static int e = 0;
  private SQLiteDatabase f;
  
  private b()
  {
    a locala = new a(com.inmobi.commons.a.a.b());
    try
    {
      this.f = locala.getWritableDatabase();
      b = this;
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Problem while getting writable database connection.", localSQLiteException);
    }
  }
  
  /* Error */
  public static b a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	com/inmobi/commons/core/b/b:d	Ljava/lang/Object;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 34	com/inmobi/commons/core/b/b:e	I
    //   12: iconst_1
    //   13: iadd
    //   14: putstatic 34	com/inmobi/commons/core/b/b:e	I
    //   17: aload_0
    //   18: monitorexit
    //   19: getstatic 55	com/inmobi/commons/core/b/b:b	Lcom/inmobi/commons/core/b/b;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnonnull +35 -> 61
    //   29: getstatic 30	com/inmobi/commons/core/b/b:c	Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_2
    //   34: monitorenter
    //   35: getstatic 55	com/inmobi/commons/core/b/b:b	Lcom/inmobi/commons/core/b/b;
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: ifnonnull +17 -> 59
    //   45: new 2	com/inmobi/commons/core/b/b
    //   48: dup
    //   49: invokespecial 70	com/inmobi/commons/core/b/b:<init>	()V
    //   52: putstatic 55	com/inmobi/commons/core/b/b:b	Lcom/inmobi/commons/core/b/b;
    //   55: getstatic 55	com/inmobi/commons/core/b/b:b	Lcom/inmobi/commons/core/b/b;
    //   58: astore_0
    //   59: aload_2
    //   60: monitorexit
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: astore_0
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	5	0	localObject2	Object
    //   77	4	0	localObject3	Object
    //   22	20	1	localb	b
    //   66	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	19	66	finally
    //   67	69	66	finally
    //   3	9	71	finally
    //   19	23	71	finally
    //   29	35	71	finally
    //   69	71	71	finally
    //   80	82	71	finally
    //   35	39	77	finally
    //   45	59	77	finally
    //   59	61	77	finally
    //   78	80	77	finally
  }
  
  public int a(String paramString)
  {
    try
    {
      paramString = "SELECT COUNT(*) FROM " + paramString + " ; ";
      paramString = this.f.rawQuery(paramString, null);
      paramString.moveToFirst();
      int i = paramString.getInt(0);
      paramString.close();
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int i = this.f.delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public List<ContentValues> a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      paramString1 = this.f.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      paramArrayOfString1 = new ArrayList();
      if (paramString1.moveToFirst()) {
        do
        {
          paramString2 = new ContentValues();
          DatabaseUtils.cursorRowToContentValues(paramString1, paramString2);
          paramArrayOfString1.add(paramString2);
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return paramArrayOfString1;
    }
    finally {}
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      if (!a(paramString1, paramContentValues)) {
        b(paramString1, paramContentValues, paramString2, paramArrayOfString);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = "CREATE TABLE IF NOT EXISTS " + paramString1 + paramString2 + ";";
      this.f.execSQL(paramString1);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public boolean a(String paramString, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 53	com/inmobi/commons/core/b/b:f	Landroid/database/sqlite/SQLiteDatabase;
    //   6: aload_1
    //   7: aconst_null
    //   8: aload_2
    //   9: iconst_4
    //   10: invokevirtual 156	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   13: lstore_3
    //   14: lload_3
    //   15: ldc2_w 157
    //   18: lcmp
    //   19: ifeq +11 -> 30
    //   22: iconst_1
    //   23: istore 5
    //   25: aload_0
    //   26: monitorexit
    //   27: iload 5
    //   29: ireturn
    //   30: iconst_0
    //   31: istore 5
    //   33: goto -8 -> 25
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	b
    //   0	41	1	paramString	String
    //   0	41	2	paramContentValues	ContentValues
    //   13	2	3	l	long
    //   23	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
  }
  
  public int b(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      int i = this.f.updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 4);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      paramString1 = "SELECT COUNT(*) FROM " + paramString1 + " WHERE " + paramString2 + " ; ";
      paramString1 = this.f.rawQuery(paramString1, paramArrayOfString);
      paramString1.moveToFirst();
      int i = paramString1.getInt(0);
      paramString1.close();
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 32	com/inmobi/commons/core/b/b:d	Ljava/lang/Object;
    //   5: astore_1
    //   6: aload_1
    //   7: monitorenter
    //   8: getstatic 34	com/inmobi/commons/core/b/b:e	I
    //   11: iconst_1
    //   12: isub
    //   13: putstatic 34	com/inmobi/commons/core/b/b:e	I
    //   16: getstatic 34	com/inmobi/commons/core/b/b:e	I
    //   19: ifne +14 -> 33
    //   22: aload_0
    //   23: getfield 53	com/inmobi/commons/core/b/b:f	Landroid/database/sqlite/SQLiteDatabase;
    //   26: invokevirtual 165	android/database/sqlite/SQLiteDatabase:close	()V
    //   29: aconst_null
    //   30: putstatic 55	com/inmobi/commons/core/b/b:b	Lcom/inmobi/commons/core/b/b;
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_2
    //   39: aload_1
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	b
    //   43	4	1	localObject2	Object
    //   38	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	33	38	finally
    //   33	35	38	finally
    //   39	41	38	finally
    //   2	8	43	finally
    //   41	43	43	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */