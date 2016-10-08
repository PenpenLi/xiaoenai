package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import java.util.UUID;

final class am
  extends af<UUID>
{
  public UUID a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return UUID.fromString(parama.h());
  }
  
  public void a(d paramd, UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (paramUUID = null;; paramUUID = paramUUID.toString())
    {
      paramd.b(paramUUID);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */