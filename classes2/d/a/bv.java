package d.a;

public class bv
{
  private static int a = Integer.MAX_VALUE;
  
  public static void a(bs parambs, byte paramByte)
  {
    a(parambs, paramByte, a);
  }
  
  public static void a(bs parambs, byte paramByte, int paramInt)
  {
    byte b2 = 0;
    byte b3 = 0;
    byte b1 = 0;
    if (paramInt <= 0) {
      throw new be("Maximum skip depth exceeded");
    }
    switch (paramByte)
    {
    case 5: 
    case 7: 
    case 9: 
    default: 
      return;
    case 2: 
      parambs.p();
      return;
    case 3: 
      parambs.q();
      return;
    case 6: 
      parambs.r();
      return;
    case 8: 
      parambs.s();
      return;
    case 10: 
      parambs.t();
      return;
    case 4: 
      parambs.u();
      return;
    case 11: 
      parambs.w();
      return;
    case 12: 
      parambs.f();
      for (;;)
      {
        localObject = parambs.h();
        if (((bp)localObject).b == 0)
        {
          parambs.g();
          return;
        }
        a(parambs, ((bp)localObject).b, paramInt - 1);
        parambs.i();
      }
    case 13: 
      localObject = parambs.j();
      paramByte = b1;
      while (paramByte < ((br)localObject).c)
      {
        a(parambs, ((br)localObject).a, paramInt - 1);
        a(parambs, ((br)localObject).b, paramInt - 1);
        paramByte += 1;
      }
      parambs.k();
      return;
    case 14: 
      localObject = parambs.n();
      paramByte = b2;
      while (paramByte < ((bw)localObject).b)
      {
        a(parambs, ((bw)localObject).a, paramInt - 1);
        paramByte += 1;
      }
      parambs.o();
      return;
    }
    Object localObject = parambs.l();
    paramByte = b3;
    while (paramByte < ((bq)localObject).b)
    {
      a(parambs, ((bq)localObject).a, paramInt - 1);
      paramByte += 1;
    }
    parambs.m();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */