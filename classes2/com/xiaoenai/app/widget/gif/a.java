package com.xiaoenai.app.widget.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

public class a
{
  protected Bitmap A;
  protected byte[] B = new byte['Ā'];
  protected int C = 0;
  protected int D = 0;
  protected int E = 0;
  protected boolean F = false;
  protected int G = 0;
  protected int H;
  protected short[] I;
  protected byte[] J;
  protected byte[] K;
  protected byte[] L;
  protected Vector<a> M;
  protected int N;
  private final Object O = new Object();
  protected InputStream a;
  protected int b;
  protected int c;
  protected int d;
  protected boolean e;
  protected int f;
  protected int g = 1;
  protected int[] h;
  protected int[] i;
  protected int[] j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected boolean o;
  protected boolean p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  protected Bitmap z;
  
  public int a()
  {
    return this.N;
  }
  
  public int a(int paramInt)
  {
    this.G = -1;
    if ((paramInt >= 0) && (paramInt < this.N) && (paramInt < this.M.size())) {
      this.G = ((a)this.M.elementAt(paramInt)).b;
    }
    return this.G;
  }
  
  public int a(InputStream paramInputStream)
  {
    e();
    if (paramInputStream != null)
    {
      this.a = paramInputStream;
      j();
      if (!d())
      {
        h();
        if (this.N < 0) {
          this.b = 1;
        }
      }
    }
    try
    {
      for (;;)
      {
        paramInputStream.close();
        return this.b;
        this.b = 2;
      }
    }
    catch (Exception paramInputStream)
    {
      for (;;) {}
    }
  }
  
  public Bitmap b(int paramInt)
  {
    if (this.N <= 0) {}
    while (paramInt >= this.M.size()) {
      return null;
    }
    int i1 = this.N;
    return ((a)this.M.elementAt(paramInt % i1)).a;
  }
  
  protected void b()
  {
    int i1;
    int i5;
    for (;;)
    {
      synchronized (this.O)
      {
        int[] arrayOfInt1 = new int[this.c * this.d];
        if (this.E <= 0) {
          break;
        }
        if (this.E == 3)
        {
          i1 = this.N - 2;
          if (i1 > 0) {
            this.A = b(i1 - 1);
          }
        }
        else
        {
          if (this.A == null) {
            break;
          }
          if (!this.A.isRecycled()) {
            this.A.getPixels(arrayOfInt1, 0, this.c, 0, 0, this.c, this.d);
          }
          if (this.E != 2) {
            break;
          }
          if (this.F) {
            break label417;
          }
          i2 = this.m;
          break label420;
          if (i3 >= this.y) {
            break;
          }
          i4 = (this.w + i3) * this.c + this.v;
          i5 = this.x;
          i1 = i4;
          break label426;
        }
        this.A = null;
      }
      i3 += 1;
    }
    int i2 = 8;
    int i6 = 0;
    int i4 = 0;
    int i3 = 1;
    for (;;)
    {
      int i7;
      if (i6 < this.u)
      {
        if (!this.p) {
          break label407;
        }
        i1 = i4;
        i5 = i2;
        i7 = i3;
        if (i4 < this.u) {
          break label454;
        }
        i7 = i3 + 1;
      }
      label339:
      int i8;
      switch (i7)
      {
      default: 
        for (;;)
        {
          i4 += this.s;
          if (i4 >= this.d) {
            break label517;
          }
          i5 = i4 * this.c;
          i7 = i5 + this.r;
          i4 = this.t + i7;
          if (this.c + i5 < i4) {
            i4 = this.c + i5;
          }
          for (;;)
          {
            i5 = this.t * i6;
            if (i7 >= i4) {
              break label517;
            }
            i8 = this.L[i5];
            i8 = this.j[(i8 & 0xFF)];
            if (i8 == 0) {
              break;
            }
            arrayOfInt2[i7] = i8;
            break;
            this.z = Bitmap.createBitmap(arrayOfInt2, this.c, this.d, Bitmap.Config.ARGB_4444);
            return;
          }
          label407:
          i1 = i4;
          i4 = i6;
        }
        label417:
        i2 = 0;
        label420:
        i3 = 0;
        break;
        label426:
        while (i1 < i5 + i4)
        {
          arrayOfInt2[i1] = i2;
          i1 += 1;
        }
        i5 = i2;
        i1 = i4;
      }
      for (;;)
      {
        label454:
        i8 = i1 + i5;
        i2 = i5;
        i3 = i7;
        i4 = i1;
        i1 = i8;
        break;
        i7 += 1;
        i5 += 1;
        break label339;
        i1 = 4;
        i5 = i2;
        continue;
        i1 = 2;
        i5 = 4;
        continue;
        i1 = 1;
        i5 = 2;
      }
      label517:
      i6 += 1;
      i4 = i1;
    }
  }
  
  protected void c()
  {
    int i16 = this.t * this.u;
    if ((this.L == null) || (this.L.length < i16)) {
      this.L = new byte[i16];
    }
    if (this.I == null) {
      this.I = new short['က'];
    }
    if (this.J == null) {
      this.J = new byte['က'];
    }
    if (this.K == null) {
      this.K = new byte['ခ'];
    }
    int i17 = f();
    int i18 = 1 << i17;
    int i7 = i18 + 2;
    int i2 = i17 + 1;
    int i3 = (1 << i2) - 1;
    int i1 = 0;
    while (i1 < i18)
    {
      this.I[i1] = 0;
      this.J[i1] = ((byte)i1);
      i1 += 1;
    }
    int i10 = 0;
    int i4 = 0;
    int i8 = 0;
    int i5 = 0;
    int i13 = 0;
    int i11 = 0;
    int i6 = 0;
    i1 = -1;
    int i12 = 0;
    int i9;
    if (i13 < i16)
    {
      if (i4 != 0) {
        break label666;
      }
      if (i6 >= i2) {
        break label276;
      }
      i9 = i11;
      if (i11 != 0) {
        break label235;
      }
      i9 = g();
      if (i9 > 0) {
        break label232;
      }
    }
    label232:
    label235:
    label276:
    int i14;
    int i15;
    for (;;)
    {
      if (i10 < i16)
      {
        this.L[i10] = 0;
        i10 += 1;
        continue;
        i12 = 0;
        i5 += ((this.B[i12] & 0xFF) << i6);
        i6 += 8;
        i12 += 1;
        i11 = i9 - 1;
        break;
        i9 = i5 & i3;
        i14 = i5 >> i2;
        i6 -= i2;
        if ((i9 <= i7) && (i9 != i18 + 1))
        {
          if (i9 == i18)
          {
            i2 = i17 + 1;
            i3 = (1 << i2) - 1;
            i7 = i18 + 2;
            i1 = -1;
            i5 = i14;
            break;
          }
          if (i1 == -1)
          {
            this.K[i4] = this.J[i9];
            i4 += 1;
            i1 = i9;
            i8 = i9;
            i5 = i14;
            break;
          }
          if (i9 != i7) {
            break label659;
          }
          byte[] arrayOfByte = this.K;
          i15 = i4 + 1;
          arrayOfByte[i4] = ((byte)i8);
          i5 = i1;
          i4 = i15;
          label416:
          while (i5 > i18)
          {
            this.K[i4] = this.J[i5];
            i5 = this.I[i5];
            i4 += 1;
          }
          i15 = this.J[i5] & 0xFF;
          if (i7 < 4096)
          {
            this.K[i4] = ((byte)i15);
            this.I[i7] = ((short)i1);
            this.J[i7] = ((byte)i15);
            i8 = i7 + 1;
            i1 = i2;
            i5 = i3;
            if ((i8 & i3) == 0)
            {
              i1 = i2;
              i5 = i3;
              if (i8 < 4096)
              {
                i1 = i2 + 1;
                i5 = i3 + i8;
              }
            }
            i3 = i14;
            i7 = i5;
            i5 = i15;
            i14 = i4 + 1;
            i2 = i8;
            i4 = i7;
            i7 = i1;
            i1 = i9;
            i8 = i14;
          }
        }
      }
    }
    for (;;)
    {
      i15 = i8 - 1;
      this.L[i10] = this.K[i15];
      i13 += 1;
      i14 = i10 + 1;
      i8 = i7;
      i9 = i3;
      i10 = i15;
      i7 = i2;
      i2 = i8;
      i3 = i4;
      i4 = i10;
      i8 = i5;
      i5 = i9;
      i10 = i14;
      break;
      return;
      label659:
      i5 = i9;
      break label416;
      label666:
      i9 = i3;
      i3 = i8;
      i8 = i4;
      i4 = i5;
      i14 = i7;
      i5 = i3;
      i3 = i4;
      i7 = i2;
      i4 = i9;
      i2 = i14;
    }
  }
  
  protected int[] c(int paramInt)
  {
    int i2 = 0;
    int i3 = paramInt * 3;
    Object localObject = null;
    byte[] arrayOfByte = new byte[i3];
    int i1;
    int[] arrayOfInt;
    try
    {
      i1 = this.a.read(arrayOfByte);
      if (i1 < i3)
      {
        this.b = 1;
        return (int[])localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i1 = 0;
      }
      arrayOfInt = new int['Ā'];
      i3 = 0;
      i1 = i2;
      i2 = i3;
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (i1 >= paramInt) {
        break;
      }
      int i5 = i2 + 1;
      i3 = arrayOfByte[i2];
      int i4 = i5 + 1;
      i5 = arrayOfByte[i5];
      i2 = i4 + 1;
      arrayOfInt[i1] = ((i3 & 0xFF) << 16 | 0xFF000000 | (i5 & 0xFF) << 8 | arrayOfByte[i4] & 0xFF);
      i1 += 1;
    }
  }
  
  protected boolean d()
  {
    return this.b != 0;
  }
  
  protected void e()
  {
    this.b = 0;
    this.N = 0;
    if (this.M == null) {
      this.M = new Vector();
    }
    this.h = null;
    this.i = null;
  }
  
  protected int f()
  {
    try
    {
      int i1 = this.a.read();
      return i1;
    }
    catch (Exception localException)
    {
      this.b = 1;
    }
    return 0;
  }
  
  protected int g()
  {
    this.C = f();
    int i2 = 0;
    int i1 = 0;
    if (this.C > 0) {}
    for (;;)
    {
      try
      {
        if (i1 < this.C)
        {
          i2 = this.a.read(this.B, i1, this.C - i1);
          if (i2 != -1) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      i2 = i1;
      if (i1 < this.C)
      {
        this.b = 1;
        i2 = i1;
      }
      return i2;
      i1 += i2;
    }
  }
  
  protected void h()
  {
    int i1 = 0;
    while ((i1 == 0) && (!d())) {
      switch (f())
      {
      default: 
        this.b = 1;
        break;
      case 44: 
        k();
        break;
      case 33: 
        switch (f())
        {
        default: 
          p();
          break;
        case 249: 
          i();
          break;
        case 255: 
          g();
          String str = "";
          int i2 = 0;
          while (i2 < 11)
          {
            str = str + (char)this.B[i2];
            i2 += 1;
          }
          if (str.equals("NETSCAPE2.0")) {
            m();
          } else {
            p();
          }
          break;
        case 254: 
          p();
          break;
        case 1: 
          p();
        }
        break;
      case 59: 
        i1 = 1;
      }
    }
  }
  
  protected void i()
  {
    boolean bool = true;
    f();
    int i1 = f();
    this.D = ((i1 & 0x1C) >> 2);
    if (this.D == 0) {
      this.D = 1;
    }
    if ((i1 & 0x1) != 0) {}
    for (;;)
    {
      this.F = bool;
      this.G = (n() * 10);
      this.H = f();
      f();
      return;
      bool = false;
    }
  }
  
  protected void j()
  {
    String str = "";
    int i1 = 0;
    while (i1 < 6)
    {
      str = str + (char)f();
      i1 += 1;
    }
    if (!str.startsWith("GIF")) {
      this.b = 1;
    }
    do
    {
      return;
      l();
    } while ((!this.e) || (d()));
    this.h = c(this.f);
    this.l = this.h[this.k];
  }
  
  protected void k()
  {
    int i1 = 0;
    this.r = n();
    this.s = n();
    this.t = n();
    this.u = n();
    int i2 = f();
    boolean bool;
    if ((i2 & 0x80) != 0)
    {
      bool = true;
      this.o = bool;
      this.q = ((int)Math.pow(2.0D, (i2 & 0x7) + 1));
      if ((i2 & 0x40) == 0) {
        break label165;
      }
      bool = true;
      label81:
      this.p = bool;
      if (!this.o) {
        break label170;
      }
      this.i = c(this.q);
      this.j = this.i;
      label113:
      if (this.F)
      {
        i1 = this.j[this.H];
        this.j[this.H] = 0;
      }
      if (this.j == null) {
        this.b = 1;
      }
      if (!d()) {
        break label197;
      }
    }
    label165:
    label170:
    label197:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label81;
      this.j = this.h;
      if (this.k != this.H) {
        break label113;
      }
      this.l = 0;
      break label113;
      c();
      p();
    } while (d());
    this.N += 1;
    this.z = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_4444);
    b();
    this.M.addElement(new a(this.z, this.G));
    if (this.F) {
      this.j[this.H] = i1;
    }
    o();
  }
  
  protected void l()
  {
    this.c = n();
    this.d = n();
    int i1 = f();
    if ((i1 & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      this.f = (2 << (i1 & 0x7));
      this.k = f();
      this.n = f();
      return;
    }
  }
  
  protected void m()
  {
    do
    {
      g();
      if (this.B[0] == 1) {
        this.g = (this.B[1] & 0xFF | (this.B[2] & 0xFF) << 8);
      }
    } while ((this.C > 0) && (!d()));
  }
  
  protected int n()
  {
    return f() | f() << 8;
  }
  
  protected void o()
  {
    this.E = this.D;
    this.v = this.r;
    this.w = this.s;
    this.x = this.t;
    this.y = this.u;
    this.A = this.z;
    this.m = this.l;
    this.D = 0;
    this.F = false;
    this.G = 0;
    this.i = null;
  }
  
  protected void p()
  {
    do
    {
      g();
    } while ((this.C > 0) && (!d()));
  }
  
  public void q()
  {
    synchronized (this.O)
    {
      if ((this.M != null) && (!this.M.isEmpty()))
      {
        Iterator localIterator = this.M.iterator();
        if (localIterator.hasNext())
        {
          ((a)localIterator.next()).a.recycle();
          this.M.remove(null);
        }
      }
    }
  }
  
  private static class a
  {
    public Bitmap a;
    public int b;
    
    public a(Bitmap paramBitmap, int paramInt)
    {
      this.a = paramBitmap;
      this.b = (paramInt + 80);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\gif\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */