package com.bumptech.glide.d.b;

import com.bumptech.glide.d.c;
import java.security.MessageDigest;

class j
  implements c
{
  private final String a;
  private final c b;
  
  public j(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
  }
  
  public void a(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (j)paramObject;
      if (!this.a.equals(((j)paramObject).a)) {
        return false;
      }
    } while (this.b.equals(((j)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */