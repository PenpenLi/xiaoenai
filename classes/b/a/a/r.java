package b.a.a;

import c.i;

public final class r
{
  public static final i a = i.a(":status");
  public static final i b = i.a(":method");
  public static final i c = i.a(":path");
  public static final i d = i.a(":scheme");
  public static final i e = i.a(":authority");
  public static final i f = i.a(":host");
  public static final i g = i.a(":version");
  public final i h;
  public final i i;
  final int j;
  
  public r(i parami1, i parami2)
  {
    this.h = parami1;
    this.i = parami2;
    this.j = (parami1.f() + 32 + parami2.f());
  }
  
  public r(i parami, String paramString)
  {
    this(parami, i.a(paramString));
  }
  
  public r(String paramString1, String paramString2)
  {
    this(i.a(paramString1), i.a(paramString2));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof r))
    {
      paramObject = (r)paramObject;
      bool1 = bool2;
      if (this.h.equals(((r)paramObject).h))
      {
        bool1 = bool2;
        if (this.i.equals(((r)paramObject).i)) {
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */