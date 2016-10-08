package com.xiaoenai.app.classes.street.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.street.model.ProductSubscribe;

class d
  implements Runnable
{
  d(a parama, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        ProductSubscribe localProductSubscribe = this.c.a(this.a, this.b);
        SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("product_id", Integer.valueOf(localProductSubscribe.getProductId()));
        localContentValues.put("rush_id", Integer.valueOf(localProductSubscribe.getRushId()));
        localContentValues.put("selling_time", Long.valueOf(localProductSubscribe.getSellingTime()));
        localContentValues.put("close_time", Long.valueOf(localProductSubscribe.getCloseTime()));
        localContentValues.put("order_noti_ts", Long.valueOf(localProductSubscribe.getOrderNotiTs()));
        localContentValues.put("order_noti_desc", localProductSubscribe.getOrderNotiDesc());
        if (!localProductSubscribe.isSubscribeStatus()) {
          continue;
        }
        localContentValues.put("subscribe_status", Integer.valueOf(i));
        localContentValues.put("is_remind", Integer.valueOf(1));
        if (localProductSubscribe.getId() == -1) {
          continue;
        }
        com.xiaoenai.app.utils.f.a.c("更新: productId = {}", new Object[] { Integer.valueOf(localProductSubscribe.getId()) });
        localSQLiteDatabase.update("subscribes", localContentValues, "id=? AND rush_id=?", new String[] { String.valueOf(this.a), String.valueOf(this.b) });
        localSQLiteDatabase.close();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      finally {}
      return;
      i = 0;
      continue;
      com.xiaoenai.app.utils.f.a.c("没有: productId = {}", new Object[] { Integer.valueOf(this.a) });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */