package com.xiaoenai.app.classes.forum.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.g;
import java.util.ArrayList;
import java.util.List;

public class a
  extends com.xiaoenai.app.d.a.b
{
  public static String a = "forum_notify.db";
  
  public a()
  {
    super(a, b, 2);
  }
  
  public int a()
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select _id from forum_notify desc limit 0,1", null);
    int i = -1;
    int j = i;
    if (localCursor != null)
    {
      if (localCursor.moveToNext()) {
        i = localCursor.getInt(localCursor.getColumnIndex("_id"));
      }
      localCursor.close();
      j = i;
    }
    localSQLiteDatabase.close();
    return j;
  }
  
  public ContentValues a(g paramg)
  {
    Object localObject = null;
    if (paramg != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("notify_id", Integer.valueOf(paramg.j.b));
      localContentValues.put("created_at", Long.valueOf(paramg.j.f));
      localContentValues.put("product_id", Integer.valueOf(paramg.j.h));
      localContentValues.put("topic_id", Integer.valueOf(paramg.j.i));
      localContentValues.put("title", paramg.j.j);
      localContentValues.put("topic_type", Integer.valueOf(paramg.j.m));
      localContentValues.put("favored", Boolean.valueOf(paramg.j.k));
      localContentValues.put("excerpt", paramg.j.d);
      localContentValues.put("post_number", Integer.valueOf(paramg.j.e));
      localContentValues.put("reply_to", paramg.j.l);
      localContentValues.put("event_url", paramg.i);
      localContentValues.put("event_status", Integer.valueOf(paramg.h));
      localContentValues.put("post_id", Integer.valueOf(paramg.j.n));
      localContentValues.put("post_author_id", Long.valueOf(paramg.k));
      localContentValues.put("post_reply_to_id", Long.valueOf(paramg.m));
      localContentValues.put("post_reply_to_content", paramg.l);
      localContentValues.put("topic_author_id", Long.valueOf(paramg.n));
      localObject = localContentValues;
      if (paramg.j.g != null)
      {
        localContentValues.put("author_id", Integer.valueOf(paramg.j.g.a));
        localContentValues.put("author_nickname", paramg.j.g.b);
        localContentValues.put("author_avatar_url", paramg.j.g.c);
        localContentValues.put("author_gender", Integer.valueOf(paramg.j.g.e));
        localContentValues.put("author_is_admin", Boolean.valueOf(paramg.j.g.d));
        localObject = localContentValues;
      }
    }
    return (ContentValues)localObject;
  }
  
  public List<g> a(int paramInt1, int paramInt2)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from forum_notify order by created_at desc limit ?,? ", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    ArrayList localArrayList = null;
    if (localCursor != null)
    {
      localArrayList = new ArrayList();
      for (;;)
      {
        try
        {
          if (!localCursor.moveToNext()) {
            break;
          }
          g localg = new g();
          localg.j.b = localCursor.getInt(localCursor.getColumnIndex("notify_id"));
          localg.j.f = localCursor.getInt(localCursor.getColumnIndex("created_at"));
          localg.j.h = localCursor.getInt(localCursor.getColumnIndex("product_id"));
          localg.j.i = localCursor.getInt(localCursor.getColumnIndex("topic_id"));
          localg.j.n = localCursor.getInt(localCursor.getColumnIndex("post_id"));
          localg.j.m = localCursor.getInt(localCursor.getColumnIndex("topic_type"));
          Object localObject = localg.j;
          if (localCursor.getInt(localCursor.getColumnIndex("favored")) != 0)
          {
            bool = true;
            ((com.xiaoenai.app.model.Forum.b)localObject).k = bool;
            localg.j.d = localCursor.getString(localCursor.getColumnIndex("excerpt"));
            localg.j.e = localCursor.getInt(localCursor.getColumnIndex("post_number"));
            localg.j.l = localCursor.getString(localCursor.getColumnIndex("reply_to"));
            localg.j.j = localCursor.getString(localCursor.getColumnIndex("title"));
            localg.i = localCursor.getString(localCursor.getColumnIndex("event_url"));
            localg.h = localCursor.getInt(localCursor.getColumnIndex("event_status"));
            localg.k = localCursor.getLong(localCursor.getColumnIndex("post_author_id"));
            localg.m = localCursor.getLong(localCursor.getColumnIndex("post_reply_to_id"));
            localg.l = localCursor.getString(localCursor.getColumnIndex("post_reply_to_content"));
            localg.n = localCursor.getLong(localCursor.getColumnIndex("topic_author_id"));
            localObject = new f();
            ((f)localObject).a = localCursor.getInt(localCursor.getColumnIndex("author_id"));
            ((f)localObject).b = localCursor.getString(localCursor.getColumnIndex("author_nickname"));
            ((f)localObject).c = localCursor.getString(localCursor.getColumnIndex("author_avatar_url"));
            ((f)localObject).e = localCursor.getInt(localCursor.getColumnIndex("author_gender"));
            if (localCursor.getInt(localCursor.getColumnIndex("author_is_admin")) == 0) {
              break label629;
            }
            bool = true;
            ((f)localObject).d = bool;
            localg.j.g = ((f)localObject);
            localArrayList.add(localg);
            continue;
          }
          bool = false;
        }
        finally {}
        continue;
        label629:
        boolean bool = false;
      }
      localCursor.close();
      localSQLiteDatabase.close();
    }
    return localList;
  }
  
  public void a(int paramInt)
  {
    paramInt -= 10000;
    if (paramInt > 0)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("forum_notify", "_id < ?", new String[] { String.valueOf(paramInt) });
      localSQLiteDatabase.close();
    }
  }
  
  public void a(List<g> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    a(new b(this, paramList));
  }
  
  public void b()
  {
    a(new c(this));
  }
  
  public int c()
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select count(_id) as count from forum_notify", null);
    if (localCursor != null) {
      i = j;
    }
    try
    {
      if (localCursor.moveToNext()) {
        i = localCursor.getInt(0);
      }
      localCursor.close();
      localSQLiteDatabase.close();
      return i;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS forum_notify(_id INTEGER PRIMARY KEY autoincrement, notify_id INTEGER, created_at INTEGER, product_id INTEGER, topic_id INTEGER, post_id INTEGER, favored INTEGER, title TEXT, excerpt TEXT, post_number INTEGER, topic_type INTEGER, reply_to TEXT, author_id INTEGER, author_nickname TEXT, author_avatar_url TEXT, author_gender INTEGER, author_is_admin INTEGER, event_url TEXT, event_status INTEGER, post_author_id INTEGER NOT NULL DEFAULT 0, post_reply_to_id INTEGER NOT NULL DEFAULT 0, topic_author_id INTEGER NOT NULL DEFAULT 0, post_reply_to_content TEXT)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < paramInt2) && (2 == paramInt2)) {}
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE 'forum_notify' ADD COLUMN post_author_id INTEGER NOT NULL DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE 'forum_notify' ADD COLUMN post_reply_to_id INTEGER NOT NULL DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE 'forum_notify' ADD COLUMN post_reply_to_content TEXT");
      paramSQLiteDatabase.execSQL("ALTER TABLE 'forum_notify' ADD COLUMN topic_author_id INTEGER NOT NULL DEFAULT 0");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */