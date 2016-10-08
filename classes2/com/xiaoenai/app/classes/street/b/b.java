package com.xiaoenai.app.classes.street.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.street.model.ProductSubscribe;

class b
  implements Runnable
{
  b(a parama, ProductSubscribe paramProductSubscribe) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        ProductSubscribe localProductSubscribe = this.b.a(this.a.getProductId(), this.a.getRushId());
        SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("product_id", Integer.valueOf(this.a.getProductId()));
        localContentValues.put("rush_id", Integer.valueOf(this.a.getRushId()));
        localContentValues.put("selling_time", Long.valueOf(this.a.getSellingTime()));
        localContentValues.put("close_time", Long.valueOf(this.a.getCloseTime()));
        localContentValues.put("order_noti_ts", Long.valueOf(this.a.getOrderNotiTs()));
        localContentValues.put("order_noti_desc", this.a.getOrderNotiDesc());
        if (this.a.isSubscribeStatus())
        {
          i = 1;
          localContentValues.put("subscribe_status", Integer.valueOf(i));
          if (!this.a.isRemind()) {
            break label310;
          }
          i = j;
          localContentValues.put("is_remind", Integer.valueOf(i));
          if (localProductSubscribe.getId() != -1)
          {
            com.xiaoenai.app.utils.f.a.c("更新: productId = {}", new Object[] { Integer.valueOf(this.a.getId()) });
            localSQLiteDatabase.update("subscribes", localContentValues, "id=? AND rush_id=?", new String[] { String.valueOf(this.a.getId()), String.valueOf(this.a.getRushId()) });
            localSQLiteDatabase.close();
            return;
          }
          com.xiaoenai.app.utils.f.a.c("插入: productId = {}", new Object[] { Integer.valueOf(this.a.getId()) });
          localSQLiteDatabase.insert("subscribes", null, localContentValues);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label310:
      int i = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */