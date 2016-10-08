package com.xiaoenai.app.classes.street.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.street.model.ProductSubscribe;
import java.util.HashMap;

public class a
  extends com.xiaoenai.app.d.a.b
{
  public a()
  {
    super("street.db", b, 1);
  }
  
  public ProductSubscribe a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    ProductSubscribe localProductSubscribe = new ProductSubscribe();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("subscribes", null, "product_id=? AND rush_id=?", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, "product_id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      localProductSubscribe.setId(localCursor.getInt(localCursor.getColumnIndex("id")));
      localProductSubscribe.setProductId(localCursor.getInt(localCursor.getColumnIndex("product_id")));
      localProductSubscribe.setRushId(localCursor.getInt(localCursor.getColumnIndex("rush_id")));
      localProductSubscribe.setSellingTime(localCursor.getLong(localCursor.getColumnIndex("selling_time")));
      localProductSubscribe.setCloseTime(localCursor.getLong(localCursor.getColumnIndex("close_time")));
      localProductSubscribe.setOrderNotiTs(localCursor.getLong(localCursor.getColumnIndex("order_noti_ts")));
      localProductSubscribe.setOrderNotiDesc(localCursor.getString(localCursor.getColumnIndex("order_noti_desc")));
      if (localCursor.getInt(localCursor.getColumnIndex("subscribe_status")) != 1) {
        break label282;
      }
      bool1 = true;
      localProductSubscribe.setSubscribeStatus(bool1);
      if (localCursor.getInt(localCursor.getColumnIndex("is_remind")) != 1) {
        break label288;
      }
    }
    label282:
    label288:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localProductSubscribe.setIsRemind(bool1);
      localCursor.close();
      localSQLiteDatabase.close();
      return localProductSubscribe;
      bool1 = false;
      break;
    }
  }
  
  public HashMap<String, ProductSubscribe> a()
  {
    HashMap localHashMap = new HashMap();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("subscribes", null, "subscribe_status=1", null, null, null, "id DESC");
    ProductSubscribe localProductSubscribe;
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      localProductSubscribe = new ProductSubscribe();
      localProductSubscribe.setId(localCursor.getInt(localCursor.getColumnIndex("id")));
      localProductSubscribe.setProductId(localCursor.getInt(localCursor.getColumnIndex("product_id")));
      localProductSubscribe.setRushId(localCursor.getInt(localCursor.getColumnIndex("rush_id")));
      localProductSubscribe.setSellingTime(localCursor.getLong(localCursor.getColumnIndex("selling_time")));
      localProductSubscribe.setCloseTime(localCursor.getLong(localCursor.getColumnIndex("close_time")));
      localProductSubscribe.setOrderNotiTs(localCursor.getLong(localCursor.getColumnIndex("order_noti_ts")));
      localProductSubscribe.setOrderNotiDesc(localCursor.getString(localCursor.getColumnIndex("order_noti_desc")));
      if (localCursor.getInt(localCursor.getColumnIndex("subscribe_status")) != 1) {
        break label284;
      }
      bool = true;
      label207:
      localProductSubscribe.setSubscribeStatus(bool);
      if (localCursor.getInt(localCursor.getColumnIndex("is_remind")) != 1) {
        break label290;
      }
    }
    label284:
    label290:
    for (boolean bool = true;; bool = false)
    {
      localProductSubscribe.setIsRemind(bool);
      localHashMap.put(String.valueOf(localProductSubscribe.getProductId() + localProductSubscribe.getRushId()), localProductSubscribe);
      if (localCursor.moveToNext()) {
        break;
      }
      localCursor.close();
      localSQLiteDatabase.close();
      return localHashMap;
      bool = false;
      break label207;
    }
  }
  
  public void a(long paramLong)
  {
    a(new e(this, paramLong));
  }
  
  public void a(ProductSubscribe paramProductSubscribe)
  {
    a(new b(this, paramProductSubscribe));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(new c(this, paramInt1, paramInt2));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(new d(this, paramInt1, paramInt2));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS subscribes (id INTEGER PRIMARY KEY autoincrement,product_id INTEGER NOT NULL DEFAULT 0,rush_id INTEGER NOT NULL DEFAULT 0,selling_time BIGINT NOT NULL DEFAULT 0,close_time BIGINT NOT NULL DEFAULT 0,order_noti_ts BIGINT NOT NULL DEFAULT 0,order_noti_desc VARCHAR,subscribe_status INTEGER NOT NULL DEFAULT 0,is_remind INTEGER NOT NULL DEFAULT 0);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */