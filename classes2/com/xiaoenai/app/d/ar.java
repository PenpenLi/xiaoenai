package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.d.a.b;
import java.util.Vector;

public class ar
  extends b
{
  public ar()
  {
    super("sticker.db", b, 3);
  }
  
  public BaseSticker a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("sticker", null, "id=?", new String[] { String.valueOf(paramInt) }, null, null, "id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      switch (localCursor.getInt(localCursor.getInt(localCursor.getColumnIndex("type"))))
      {
      }
    }
    for (localObject1 = localObject2;; localObject1 = new FaceSticker())
    {
      a((BaseSticker)localObject1, localCursor);
      localCursor.close();
      localSQLiteDatabase.close();
      return (BaseSticker)localObject1;
    }
  }
  
  public void a()
  {
    a(new au(this));
  }
  
  public void a(BaseSticker paramBaseSticker)
  {
    a(new as(this, paramBaseSticker));
  }
  
  public void a(BaseSticker paramBaseSticker, Cursor paramCursor)
  {
    boolean bool2 = true;
    paramBaseSticker.setId(paramCursor.getInt(paramCursor.getColumnIndex("id")));
    paramBaseSticker.setName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    paramBaseSticker.setType(paramCursor.getInt(paramCursor.getColumnIndex("type")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isDownload")) == 1)
    {
      bool1 = true;
      paramBaseSticker.setDownload(bool1);
      if (paramCursor.getInt(paramCursor.getColumnIndex("isNew")) != 1) {
        break label301;
      }
      bool1 = true;
      label102:
      paramBaseSticker.setNew(bool1);
      paramBaseSticker.setThumb_url(paramCursor.getString(paramCursor.getColumnIndex("thumb_url")));
      paramBaseSticker.setCover_url(paramCursor.getString(paramCursor.getColumnIndex("cover_url")));
      paramBaseSticker.setCover_bg_url(paramCursor.getString(paramCursor.getColumnIndex("cover_bg_url")));
      paramBaseSticker.setFree(paramCursor.getInt(paramCursor.getColumnIndex("free")));
      paramBaseSticker.setSort(paramCursor.getInt(paramCursor.getColumnIndex("sort")));
      paramBaseSticker.setIntro(paramCursor.getString(paramCursor.getColumnIndex("intro")));
      paramBaseSticker.setPrice(paramCursor.getInt(paramCursor.getColumnIndex("price")));
      paramBaseSticker.setVip_price(paramCursor.getInt(paramCursor.getColumnIndex("vip_price")));
      if (paramCursor.getInt(paramCursor.getColumnIndex("purchased")) != 1) {
        break label306;
      }
    }
    label301:
    label306:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBaseSticker.setPurchased(bool1);
      paramBaseSticker.setZipUrl(paramCursor.getString(paramCursor.getColumnIndex("zipUrl")));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
    }
  }
  
  public Vector<BaseSticker> b(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject1 = "sort DESC LIMIT " + paramInt;
        Vector localVector = new Vector();
        SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
        Cursor localCursor = localSQLiteDatabase.query("sticker", null, null, null, null, null, (String)localObject1);
        if (localCursor.getCount() > 0)
        {
          localCursor.moveToFirst();
          localObject1 = null;
        }
        switch (localCursor.getInt(localCursor.getInt(localCursor.getColumnIndex("type"))))
        {
        case 1: 
          a((BaseSticker)localObject1, localCursor);
          localVector.add(localObject1);
          if (localCursor.moveToNext()) {
            continue;
          }
          localCursor.close();
          localSQLiteDatabase.close();
          return localVector;
        }
      }
      finally {}
      Object localObject1 = new FaceSticker();
    }
  }
  
  public void b(BaseSticker paramBaseSticker)
  {
    a(new at(this, paramBaseSticker));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE sticker (id INTEGER PRIMARY KEY,type INT ,name TEXT,isDownload INT,isNew INT,thumb_url TEXT,cover_url TEXT,cover_bg_url TEXT,free INT,sort INT,intro TEXT,price INT,vip_price Int,purchased Int,zipUrl TEXT);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists sticker");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */