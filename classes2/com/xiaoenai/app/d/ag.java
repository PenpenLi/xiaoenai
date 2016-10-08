package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b;
import com.xiaoenai.app.d.a.b.a;
import com.xiaoenai.app.d.a.b.b;
import com.xiaoenai.app.net.socket.f;

public class ag
  extends b
{
  public static String a = "CREATE TABLE queue (_id INTEGER PRIMARY KEY AUTOINCREMENT,priority INTEGER,body TEXT,retry INTERGER );";
  
  public ag()
  {
    super("socketQueue.db", b);
  }
  
  public void a(long paramLong, b.a parama)
  {
    a(new aj(this, paramLong, parama));
  }
  
  public void a(b.b<f> paramb)
  {
    a(new ai(this, paramb));
  }
  
  public void a(f paramf, b.a parama)
  {
    a(new ah(this, paramf, parama));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(a);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */