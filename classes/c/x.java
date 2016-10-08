package c;

final class x
{
  static w a;
  static long b;
  
  static w a()
  {
    try
    {
      if (a != null)
      {
        w localw = a;
        a = localw.f;
        localw.f = null;
        b -= 2048L;
        return localw;
      }
      return new w();
    }
    finally {}
  }
  
  static void a(w paramw)
  {
    if ((paramw.f != null) || (paramw.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramw.d) {
      return;
    }
    try
    {
      if (b + 2048L > 65536L) {
        return;
      }
    }
    finally {}
    b += 2048L;
    paramw.f = a;
    paramw.c = 0;
    paramw.b = 0;
    a = paramw;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */