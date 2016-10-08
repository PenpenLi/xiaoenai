package com.xiaoenai.app.classes.forum.b;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.g;
import java.util.List;

class b
  implements Runnable
{
  b(a parama, List paramList) {}
  
  public void run()
  {
    try
    {
      int i = this.b.a();
      this.b.a(i);
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      i = 0;
      while (i < this.a.size())
      {
        localSQLiteDatabase.insert("forum_notify", null, this.b.a((g)this.a.get(i)));
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
    ((SQLiteDatabase)localObject).close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */