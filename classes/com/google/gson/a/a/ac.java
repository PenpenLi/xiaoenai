package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class ac
  extends af<Character>
{
  public Character a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    parama = parama.h();
    if (parama.length() != 1) {
      throw new ab("Expecting character, got: " + parama);
    }
    return Character.valueOf(parama.charAt(0));
  }
  
  public void a(d paramd, Character paramCharacter)
  {
    if (paramCharacter == null) {}
    for (paramCharacter = null;; paramCharacter = String.valueOf(paramCharacter))
    {
      paramd.b(paramCharacter);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */