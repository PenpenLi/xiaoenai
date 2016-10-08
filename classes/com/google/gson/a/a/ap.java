package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;
import java.sql.Timestamp;
import java.util.Date;

class ap
  extends af<Timestamp>
{
  ap(ao paramao, af paramaf) {}
  
  public Timestamp a(a parama)
  {
    parama = (Date)this.a.b(parama);
    if (parama != null) {
      return new Timestamp(parama.getTime());
    }
    return null;
  }
  
  public void a(d paramd, Timestamp paramTimestamp)
  {
    this.a.a(paramd, paramTimestamp);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */