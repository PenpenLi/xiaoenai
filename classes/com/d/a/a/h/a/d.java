package com.d.a.a.h.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import com.d.a.a.e;
import com.d.a.a.j;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;

public class d
  implements j
{
  a a;
  SQLiteDatabase b;
  c c;
  c d;
  b e;
  b f;
  private final long g;
  
  public d(Context paramContext, long paramLong, String paramString, c paramc)
  {
    this.g = paramLong;
    this.a = new a(paramContext, "db_" + paramString);
    this.b = this.a.getWritableDatabase();
    this.c = new c(this.b, "job_holder", a.a.a, 9, paramLong);
    this.d = paramc;
    this.e = new b();
    this.f = new b();
    this.c.a(Long.MIN_VALUE);
  }
  
  private com.d.a.a.b a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.d.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.d.a.a.e.b.a(paramArrayOfByte, "error while deserializing job", new Object[0]);
    }
    return null;
  }
  
  private e a(Cursor paramCursor)
  {
    com.d.a.a.b localb = a(paramCursor.getBlob(a.e.c));
    if (localb == null) {
      throw new a(null);
    }
    return new e(Long.valueOf(paramCursor.getLong(a.a.c)), paramCursor.getInt(a.b.c), paramCursor.getString(a.c.c), paramCursor.getInt(a.d.c), localb, paramCursor.getLong(a.f.c), paramCursor.getLong(a.g.c), paramCursor.getLong(a.h.c));
  }
  
  private static String a(String paramString, Collection<String> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  private String a(boolean paramBoolean1, Collection<String> paramCollection, boolean paramBoolean2)
  {
    Object localObject2 = a.h.a + " != ? " + " AND " + a.g.a + " <= ? ";
    Object localObject1 = localObject2;
    if (!paramBoolean1) {
      localObject1 = (String)localObject2 + " AND " + a.i.a + " != 1 ";
    }
    Object localObject3 = null;
    localObject2 = localObject3;
    if (paramCollection != null)
    {
      localObject2 = localObject3;
      if (paramCollection.size() > 0) {
        localObject2 = a.c.a + " IS NULL OR " + a.c.a + " NOT IN('" + a("','", paramCollection) + "')";
      }
    }
    if (paramBoolean2)
    {
      localObject1 = (String)localObject1 + " GROUP BY " + a.c.a;
      paramCollection = (Collection<String>)localObject1;
      if (localObject2 != null) {
        paramCollection = (String)localObject1 + " HAVING " + (String)localObject2;
      }
    }
    do
    {
      return paramCollection;
      paramCollection = (Collection<String>)localObject1;
    } while (localObject2 == null);
    return (String)localObject1 + " AND ( " + (String)localObject2 + " )";
  }
  
  private void a(SQLiteStatement paramSQLiteStatement, e parame)
  {
    if (parame.a() != null) {
      paramSQLiteStatement.bindLong(a.a.c + 1, parame.a().longValue());
    }
    paramSQLiteStatement.bindLong(a.b.c + 1, parame.c());
    if (parame.i() != null) {
      paramSQLiteStatement.bindString(a.c.c + 1, parame.i());
    }
    paramSQLiteStatement.bindLong(a.d.c + 1, parame.d());
    byte[] arrayOfByte = e(parame);
    if (arrayOfByte != null) {
      paramSQLiteStatement.bindBlob(a.e.c + 1, arrayOfByte);
    }
    paramSQLiteStatement.bindLong(a.f.c + 1, parame.e());
    paramSQLiteStatement.bindLong(a.g.c + 1, parame.g());
    paramSQLiteStatement.bindLong(a.h.c + 1, parame.f());
    int i = a.i.c;
    if (parame.b()) {}
    for (long l = 1L;; l = 0L)
    {
      paramSQLiteStatement.bindLong(i + 1, l);
      return;
    }
  }
  
  private void a(Long paramLong)
  {
    synchronized (this.c.d())
    {
      ???.clearBindings();
      ???.bindLong(1, paramLong.longValue());
      ???.execute();
      return;
    }
  }
  
  private byte[] a(Object paramObject)
  {
    try
    {
      byte[] arrayOfByte = this.d.a(paramObject);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      com.d.a.a.e.b.a(localThrowable, "error while serializing object %s", new Object[] { paramObject.getClass().getSimpleName() });
    }
    return null;
  }
  
  private void d(e parame)
  {
    SQLiteStatement localSQLiteStatement = this.c.e();
    parame.b(parame.d() + 1);
    parame.a(this.g);
    try
    {
      localSQLiteStatement.clearBindings();
      localSQLiteStatement.bindLong(1, parame.d());
      localSQLiteStatement.bindLong(2, this.g);
      localSQLiteStatement.bindLong(3, parame.a().longValue());
      localSQLiteStatement.execute();
      return;
    }
    finally {}
  }
  
  private byte[] e(e parame)
  {
    return a(parame.h());
  }
  
  public int a()
  {
    synchronized (this.c.b())
    {
      ???.clearBindings();
      ???.bindLong(1, this.g);
      int i = (int)???.simpleQueryForLong();
      return i;
    }
  }
  
  public int a(boolean paramBoolean, Collection<String> paramCollection)
  {
    String str2 = this.e.a(paramBoolean, paramCollection);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramBoolean, paramCollection, true);
      str1 = "SELECT count(*) group_cnt, " + a.c.a + " FROM " + "job_holder" + " WHERE " + str1;
      str1 = "SELECT SUM(case WHEN " + a.c.a + " is null then group_cnt else 1 end) from (" + str1 + ")";
      this.e.a(str1, paramBoolean, paramCollection);
    }
    paramCollection = this.b.rawQuery(str1, new String[] { Long.toString(this.g), Long.toString(System.nanoTime()) });
    try
    {
      paramBoolean = paramCollection.moveToNext();
      if (!paramBoolean) {
        return 0;
      }
      int i = paramCollection.getInt(0);
      return i;
    }
    finally
    {
      paramCollection.close();
    }
  }
  
  public long a(e parame)
  {
    synchronized (this.c.a())
    {
      ???.clearBindings();
      a(???, parame);
      long l = ???.executeInsert();
      parame.a(Long.valueOf(l));
      return l;
    }
  }
  
  public Long a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    synchronized (this.c.f())
    {
      try
      {
        ???.clearBindings();
        long l = ???.simpleQueryForLong();
        return Long.valueOf(l);
      }
      catch (SQLiteDoneException localSQLiteDoneException)
      {
        return null;
      }
      ??? = this.c.g();
    }
  }
  
  public long b(e parame)
  {
    if (parame.a() == null) {
      return a(parame);
    }
    parame.a(Long.MIN_VALUE);
    synchronized (this.c.c())
    {
      ???.clearBindings();
      a(???, parame);
      long l = ???.executeInsert();
      parame.a(Long.valueOf(l));
      return l;
    }
  }
  
  public e b(boolean paramBoolean, Collection<String> paramCollection)
  {
    String str = this.f.a(paramBoolean, paramCollection);
    Object localObject1 = str;
    if (str == null)
    {
      localObject1 = a(paramBoolean, paramCollection, false);
      localObject1 = this.c.a((String)localObject1, Integer.valueOf(1), new c.a[] { new c.a(a.b, c.a.a.b), new c.a(a.f, c.a.a.a), new c.a(a.a, c.a.a.a) });
      this.f.a((String)localObject1, paramBoolean, paramCollection);
    }
    paramCollection = this.b.rawQuery((String)localObject1, new String[] { Long.toString(this.g), Long.toString(System.nanoTime()) });
    try
    {
      paramBoolean = paramCollection.moveToNext();
      if (!paramBoolean) {
        return null;
      }
      localObject1 = a(paramCollection);
      d((e)localObject1);
      return (e)localObject1;
    }
    catch (a locala)
    {
      a(Long.valueOf(paramCollection.getLong(0)));
      e locale = b(true, null);
      return locale;
    }
    finally
    {
      paramCollection.close();
    }
  }
  
  public void c(e parame)
  {
    if (parame.a() == null)
    {
      com.d.a.a.e.b.b("called remove with null job id.", new Object[0]);
      return;
    }
    a(parame.a());
  }
  
  private static class a
    extends Exception
  {}
  
  public static class b
    implements d.c
  {
    public <T extends com.d.a.a.b> T a(byte[] paramArrayOfByte)
    {
      localObjectInputStream = null;
      localObject = localObjectInputStream;
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length == 0) {
          localObject = localObjectInputStream;
        }
      }
      else {
        label15:
        return (T)localObject;
      }
      try
      {
        localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte));
      }
      finally
      {
        try
        {
          paramArrayOfByte = (com.d.a.a.b)localObjectInputStream.readObject();
          localObject = paramArrayOfByte;
          if (localObjectInputStream == null) {
            break label15;
          }
          localObjectInputStream.close();
          return paramArrayOfByte;
        }
        finally
        {
          localObject = localObjectInputStream;
        }
        paramArrayOfByte = finally;
        localObject = null;
      }
      if (localObject != null) {
        ((ObjectInputStream)localObject).close();
      }
      throw paramArrayOfByte;
    }
    
    /* Error */
    public byte[] a(Object paramObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_1
      //   3: ifnonnull +7 -> 10
      //   6: aload_2
      //   7: astore_1
      //   8: aload_1
      //   9: areturn
      //   10: new 40	java/io/ByteArrayOutputStream
      //   13: dup
      //   14: invokespecial 41	java/io/ByteArrayOutputStream:<init>	()V
      //   17: astore_3
      //   18: new 43	java/io/ObjectOutputStream
      //   21: dup
      //   22: aload_3
      //   23: invokespecial 46	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   26: aload_1
      //   27: invokeinterface 52 2 0
      //   32: aload_3
      //   33: invokevirtual 56	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   36: astore_2
      //   37: aload_2
      //   38: astore_1
      //   39: aload_3
      //   40: ifnull -32 -> 8
      //   43: aload_3
      //   44: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
      //   47: aload_2
      //   48: areturn
      //   49: astore_1
      //   50: aconst_null
      //   51: astore_2
      //   52: aload_2
      //   53: ifnull +7 -> 60
      //   56: aload_2
      //   57: invokevirtual 57	java/io/ByteArrayOutputStream:close	()V
      //   60: aload_1
      //   61: athrow
      //   62: astore_1
      //   63: aload_3
      //   64: astore_2
      //   65: goto -13 -> 52
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	b
      //   0	68	1	paramObject	Object
      //   1	64	2	localObject	Object
      //   17	47	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      // Exception table:
      //   from	to	target	type
      //   10	18	49	finally
      //   18	37	62	finally
    }
  }
  
  public static abstract interface c
  {
    public abstract <T extends com.d.a.a.b> T a(byte[] paramArrayOfByte);
    
    public abstract byte[] a(Object paramObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\h\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */