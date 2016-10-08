package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.b.a;
import com.google.gson.j;
import java.sql.Timestamp;
import java.util.Date;

final class ao
  implements ah
{
  public <T> af<T> a(j paramj, a<T> parama)
  {
    if (parama.getRawType() != Timestamp.class) {
      return null;
    }
    return new ap(this, paramj.a(Date.class));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */