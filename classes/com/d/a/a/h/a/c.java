package com.d.a.a.h.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.d.a.a.e.b;

public class c
{
  String a;
  final SQLiteDatabase b;
  final String c;
  final String d;
  final int e;
  final long f;
  private SQLiteStatement g;
  private SQLiteStatement h;
  private SQLiteStatement i;
  private SQLiteStatement j;
  private SQLiteStatement k;
  private SQLiteStatement l;
  private SQLiteStatement m;
  
  public c(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    this.b = paramSQLiteDatabase;
    this.c = paramString1;
    this.e = paramInt;
    this.d = paramString2;
    this.f = paramLong;
    this.a = ("SELECT * FROM " + paramString1 + " WHERE " + a.a.a + " = ?");
  }
  
  public static String a(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }
  
  public static String a(String paramString, b paramb, b... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE ");
    localStringBuilder.append(paramString).append(" (");
    localStringBuilder.append(paramb.a).append(" ");
    localStringBuilder.append(paramb.b);
    localStringBuilder.append("  primary key autoincrement ");
    int i1 = paramVarArgs.length;
    int n = 0;
    while (n < i1)
    {
      paramString = paramVarArgs[n];
      localStringBuilder.append(", `").append(paramString.a).append("` ").append(paramString.b);
      n += 1;
    }
    localStringBuilder.append(" );");
    b.a(localStringBuilder.toString(), new Object[0]);
    return localStringBuilder.toString();
  }
  
  public SQLiteStatement a()
  {
    if (this.g == null)
    {
      StringBuilder localStringBuilder = new StringBuilder("INSERT INTO ").append(this.c);
      localStringBuilder.append(" VALUES (");
      int n = 0;
      while (n < this.e)
      {
        if (n != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("?");
        n += 1;
      }
      localStringBuilder.append(")");
      this.g = this.b.compileStatement(localStringBuilder.toString());
    }
    return this.g;
  }
  
  public String a(String paramString, Integer paramInteger, a... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT * FROM ");
    localStringBuilder.append(this.c);
    if (paramString != null) {
      localStringBuilder.append(" WHERE ").append(paramString);
    }
    int i2 = paramVarArgs.length;
    int i1 = 1;
    int n = 0;
    if (n < i2)
    {
      paramString = paramVarArgs[n];
      if (i1 != 0) {
        localStringBuilder.append(" ORDER BY ");
      }
      for (;;)
      {
        localStringBuilder.append(paramString.a.a).append(" ").append(paramString.b);
        n += 1;
        i1 = 0;
        break;
        localStringBuilder.append(",");
      }
    }
    if (paramInteger != null) {
      localStringBuilder.append(" LIMIT ").append(paramInteger);
    }
    return localStringBuilder.toString();
  }
  
  public void a(long paramLong)
  {
    this.b.execSQL("UPDATE job_holder SET " + a.g.a + "=?", new Object[] { Long.valueOf(paramLong) });
  }
  
  public SQLiteStatement b()
  {
    if (this.k == null) {
      this.k = this.b.compileStatement("SELECT COUNT(*) FROM " + this.c + " WHERE " + a.h.a + " != ?");
    }
    return this.k;
  }
  
  public SQLiteStatement c()
  {
    if (this.h == null)
    {
      StringBuilder localStringBuilder = new StringBuilder("INSERT OR REPLACE INTO ").append(this.c);
      localStringBuilder.append(" VALUES (");
      int n = 0;
      while (n < this.e)
      {
        if (n != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("?");
        n += 1;
      }
      localStringBuilder.append(")");
      this.h = this.b.compileStatement(localStringBuilder.toString());
    }
    return this.h;
  }
  
  public SQLiteStatement d()
  {
    if (this.i == null) {
      this.i = this.b.compileStatement("DELETE FROM " + this.c + " WHERE " + this.d + " = ?");
    }
    return this.i;
  }
  
  public SQLiteStatement e()
  {
    if (this.j == null)
    {
      String str = "UPDATE " + this.c + " SET " + a.d.a + " = ? , " + a.h.a + " = ? " + " WHERE " + this.d + " = ? ";
      this.j = this.b.compileStatement(str);
    }
    return this.j;
  }
  
  public SQLiteStatement f()
  {
    if (this.l == null)
    {
      String str = "SELECT " + a.g.a + " FROM " + this.c + " WHERE " + a.h.a + " != " + this.f + " ORDER BY " + a.g.a + " ASC" + " LIMIT 1";
      this.l = this.b.compileStatement(str);
    }
    return this.l;
  }
  
  public SQLiteStatement g()
  {
    if (this.m == null)
    {
      String str = "SELECT " + a.g.a + " FROM " + this.c + " WHERE " + a.h.a + " != " + this.f + " AND " + a.i.a + " != 1" + " ORDER BY " + a.g.a + " ASC" + " LIMIT 1";
      this.m = this.b.compileStatement(str);
    }
    return this.m;
  }
  
  public static class a
  {
    final c.b a;
    final a b;
    
    public a(c.b paramb, a parama)
    {
      this.a = paramb;
      this.b = parama;
    }
    
    public static enum a
    {
      private a() {}
    }
  }
  
  public static class b
  {
    final String a;
    final String b;
    public final int c;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramInt;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\h\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */