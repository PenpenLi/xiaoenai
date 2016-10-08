package com.adhoc;

final class fe
{
  static fd a;
  static long b;
  
  static fd a()
  {
    try
    {
      if (a != null)
      {
        fd localfd = a;
        a = localfd.f;
        localfd.f = null;
        b -= 2048L;
        return localfd;
      }
      return new fd();
    }
    finally {}
  }
  
  static void a(fd paramfd)
  {
    if ((paramfd.f != null) || (paramfd.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramfd.d) {
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
    paramfd.f = a;
    paramfd.c = 0;
    paramfd.b = 0;
    a = paramfd;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */