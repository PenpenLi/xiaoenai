package com.meiqia.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.meiqia.core.b.g;

class aa
  extends SQLiteOpenHelper
{
  public aa(Context paramContext)
  {
    super(paramContext, "meiqia.db", null, 7);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS mq_message(id_ INTEGER PRIMARY KEY AUTOINCREMENT,id INTEGER,agent_id INTEGER,content TEXT,content_type TEXT,conversation_id INTEGER,created_on INTEGER,enterprise_id INTEGER,from_type TEXT,track_id TEXT,avatar TEXT,status TEXT,agent_nickname TEXT,media_url TEXT,isRead INTEGER,type TEXT,extra TEXT,is_already_feedback INTEGER)");
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS mq_conversation(id INTEGER PRIMARY KEY,agent_id INTEGER,created_on TEXT,ended_by TEXT,ended_on TEXT,enterprise_id INTEGER,last_msg_content TEXT,last_updated TEXT,track_id TEXT,visit_id TEXT,last_msg_created_on TEXT)");
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("alter table mq_message rename to mq_message_temp");
    a(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("INSERT INTO mq_message(id,agent_id,content,content_type,conversation_id,created_on,enterprise_id,from_type,track_id,avatar,status,agent_nickname,media_url,isRead,type,extra,is_already_feedback) SELECT id,agent_id,content,content_type,conversation_id,created_on,enterprise_id,from_type,track_id,avatar,status,agent_nickname,media_url,isRead,type,extra,is_already_feedback FROM mq_message_temp");
    paramSQLiteDatabase.execSQL("drop table if exists mq_message_temp");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    g.b("onUpgrade 升级数据库   " + paramInt1 + " => " + paramInt2);
    paramSQLiteDatabase.beginTransaction();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      try
      {
        g.b("升级数据库成功");
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      catch (Exception localException)
      {
        g.b("升级数据库出错" + localException.getMessage());
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      g.b("升级数据库   4 => 5");
      paramSQLiteDatabase.execSQL("ALTER TABLE mq_message ADD COLUMN extra");
      g.b("升级数据库   5 => 6");
      paramSQLiteDatabase.execSQL("ALTER TABLE mq_message ADD COLUMN is_already_feedback INTEGER");
      g.b("升级数据库   6 => 7");
      c(paramSQLiteDatabase);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */