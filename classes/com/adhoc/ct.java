package com.adhoc;

public final class ct
{
  public static final er a = er.a(":status");
  public static final er b = er.a(":method");
  public static final er c = er.a(":path");
  public static final er d = er.a(":scheme");
  public static final er e = er.a(":authority");
  public static final er f = er.a(":host");
  public static final er g = er.a(":version");
  public final er h;
  public final er i;
  final int j;
  
  public ct(er paramer1, er paramer2)
  {
    this.h = paramer1;
    this.i = paramer2;
    this.j = (paramer1.f() + 32 + paramer2.f());
  }
  
  public ct(er paramer, String paramString)
  {
    this(paramer, er.a(paramString));
  }
  
  public ct(String paramString1, String paramString2)
  {
    this(er.a(paramString1), er.a(paramString2));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof ct))
    {
      paramObject = (ct)paramObject;
      bool1 = bool2;
      if (this.h.equals(((ct)paramObject).h))
      {
        bool1 = bool2;
        if (this.i.equals(((ct)paramObject).i)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.h.hashCode() + 527) * 31 + this.i.hashCode();
  }
  
  public String toString()
  {
    return String.format("%s: %s", new Object[] { this.h.a(), this.i.a() });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */