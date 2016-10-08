package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b;
import com.xiaoenai.app.stat.StatEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ak
  extends b
{
  public ak()
  {
    super("stat.db", b);
  }
  
  private void b(List<StatEntry> paramList)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localSQLiteDatabase.delete("stat", "id = ?", new String[] { String.valueOf(((StatEntry)paramList.next()).getId()) });
      }
      localSQLiteDatabase.close();
    }
    finally {}
  }
  
  private void c(StatEntry paramStatEntry)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.insert("stat", null, b(paramStatEntry));
      localSQLiteDatabase.close();
      return;
    }
    finally
    {
      paramStatEntry = finally;
      throw paramStatEntry;
    }
  }
  
  public List<StatEntry> a(int paramInt)
  {
    Object localObject = "id DESC LIMIT " + paramInt;
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    localObject = localSQLiteDatabase.query("stat", null, null, null, null, null, (String)localObject);
    if (localObject != null)
    {
      if (((Cursor)localObject).getCount() > 0)
      {
        ((Cursor)localObject).moveToFirst();
        do
        {
          StatEntry localStatEntry = new StatEntry();
          a(localStatEntry, (Cursor)localObject);
          localArrayList.add(localStatEntry);
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
    }
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public void a(StatEntry paramStatEntry)
  {
    a(new al(this, paramStatEntry));
  }
  
  public void a(StatEntry paramStatEntry, Cursor paramCursor)
  {
    paramStatEntry.setId(paramCursor.getInt(paramCursor.getColumnIndex("id")));
    paramStatEntry.setLogId(paramCursor.getInt(paramCursor.getColumnIndex("log_id")));
    paramStatEntry.setDeviceId(paramCursor.getString(paramCursor.getColumnIndex("device_id")));
    paramStatEntry.setUid(paramCursor.getInt(paramCursor.getColumnIndex("uid")));
    paramStatEntry.setNet(paramCursor.getString(paramCursor.getColumnIndex("net")));
    paramStatEntry.setInitate(paramCursor.getLong(paramCursor.getColumnIndex("initate")));
    paramStatEntry.setTimestamp(paramCursor.getLong(paramCursor.getColumnIndex("timestamp")));
    paramStatEntry.setStatus(paramCursor.getInt(paramCursor.getColumnIndex("status")));
    paramStatEntry.setRefer(paramCursor.getString(paramCursor.getColumnIndex("refer")));
    paramStatEntry.setPage(paramCursor.getString(paramCursor.getColumnIndex("page")));
    paramStatEntry.setFollow(paramCursor.getString(paramCursor.getColumnIndex("follow")));
    paramStatEntry.setExpId(paramCursor.getInt(paramCursor.getColumnIndex("exp_id")));
    paramStatEntry.setEvent(paramCursor.getString(paramCursor.getColumnIndex("event")));
    paramStatEntry.setExpand(paramCursor.getString(paramCursor.getColumnIndex("expand")));
  }
  
  public void a(List<StatEntry> paramList)
  {
    if (paramList != null) {
      a(new am(this, paramList));
    }
  }
  
  public ContentValues b(StatEntry paramStatEntry)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("log_id", Integer.valueOf(paramStatEntry.getLogId()));
    localContentValues.put("device_id", paramStatEntry.getDeviceId());
    localContentValues.put("uid", Integer.valueOf(paramStatEntry.getUid()));
    localContentValues.put("net", paramStatEntry.getNet());
    localContentValues.put("initate", Long.valueOf(paramStatEntry.getInitate()));
    localContentValues.put("timestamp", Long.valueOf(paramStatEntry.getTimestamp()));
    localContentValues.put("status", Integer.valueOf(paramStatEntry.getStatus()));
    localContentValues.put("refer", paramStatEntry.getRefer());
    localContentValues.put("page", paramStatEntry.getPage());
    localContentValues.put("follow", paramStatEntry.getPage());
    localContentValues.put("exp_id", Integer.valueOf(paramStatEntry.getExpId()));
    localContentValues.put("event", paramStatEntry.getEvent());
    localContentValues.put("expand", paramStatEntry.getExpand());
    return localContentValues;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stat ( id INTEGER PRIMARY KEY, log_id INT, device_id TEXT, uid INT, net TEXT, initate BIGINT, timestamp BIGINT, status INT, refer TEXT, page TEXT, follow TEXT, exp_id INT, event TEXT, expand TEXT );");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */