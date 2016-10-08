package com.xiaoenai.app.database.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.support.annotation.NonNull;
import com.xiaoenai.app.database.a.e;
import com.xiaoenai.app.database.bean.DaoMaster;
import com.xiaoenai.app.database.bean.DaoMaster.DevOpenHelper;
import com.xiaoenai.app.database.bean.DaoSession;
import java.util.Collection;

public class a<T>
  implements com.xiaoenai.app.database.a.a<T>
{
  private DaoMaster a;
  
  public a(@NonNull com.xiaoenai.app.database.a.c paramc)
  {
    a(paramc);
  }
  
  private void a(com.xiaoenai.app.database.a.c paramc)
  {
    this.a = new DaoMaster(new a(new e(paramc.c, paramc.a), paramc.b, null, this.a).getWritableDatabase());
  }
  
  public com.xiaoenai.app.database.a.b<T> a(Class<T> paramClass)
  {
    return new b(this.a.newSession());
  }
  
  private class a
    extends DaoMaster.DevOpenHelper
  {
    private DaoMaster b;
    
    public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, DaoMaster paramDaoMaster)
    {
      super(paramString, paramCursorFactory);
      this.b = paramDaoMaster;
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Collection localCollection = this.b.newSession().getAllDaos();
      paramInt2 = localCollection.size();
      Class[] arrayOfClass = new Class[paramInt2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        arrayOfClass[paramInt1] = localCollection.toArray()[paramInt1].getClass();
        paramInt1 += 1;
      }
      c.a(paramSQLiteDatabase, arrayOfClass);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */