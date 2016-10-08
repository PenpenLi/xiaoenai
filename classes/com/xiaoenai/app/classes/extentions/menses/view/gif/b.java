package com.xiaoenai.app.classes.extentions.menses.view.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class b
  extends Thread
{
  private Bitmap A;
  private c B = null;
  private int C = 0;
  private boolean D = false;
  private byte[] E = new byte['Ā'];
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private boolean I = false;
  private int J = 0;
  private int K;
  private short[] L;
  private byte[] M;
  private byte[] N;
  private byte[] O;
  private c P;
  private int Q;
  private a R = null;
  private byte[] S = null;
  public int a;
  public int b;
  private InputStream c;
  private int d;
  private boolean e;
  private int f;
  private int g = 1;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private Bitmap z;
  
  public b(InputStream paramInputStream, a parama)
  {
    this.c = paramInputStream;
    this.R = parama;
  }
  
  public b(byte[] paramArrayOfByte, a parama)
  {
    this.S = paramArrayOfByte;
    this.R = parama;
  }
  
  private int[] c(int paramInt)
  {
    int i2 = 0;
    int i3 = paramInt * 3;
    Object localObject = null;
    byte[] arrayOfByte = new byte[i3];
    int i1;
    int[] arrayOfInt;
    try
    {
      i1 = this.c.read(arrayOfByte);
      if (i1 < i3)
      {
        this.d = 1;
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
  
  private void e()
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    for (;;)
    {
      try
      {
        int[] arrayOfInt = new int[this.a * this.b];
        if (this.H <= 0) {
          continue;
        }
        if (this.H == 3)
        {
          i1 = this.Q - 2;
          if (i1 <= 0) {
            continue;
          }
          this.A = a(i1 - 1);
        }
        if (this.A == null) {
          continue;
        }
        this.A.getPixels(arrayOfInt, 0, this.a, 0, 0, this.a, this.b);
        if (this.H != 2) {
          continue;
        }
        if (this.I) {
          break label414;
        }
        i2 = this.m;
      }
      catch (Exception localException)
      {
        com.xiaoenai.app.utils.f.a.e("exception", new Object[0]);
        return;
        i3 += 1;
        continue;
        i2 = 8;
        i6 = 0;
        i4 = 0;
        i3 = 1;
        if (i6 >= this.u) {
          continue;
        }
        if (!this.p) {
          break label404;
        }
        i1 = i4;
        i5 = i2;
        i7 = i3;
        if (i4 < this.u) {
          break label448;
        }
        i7 = i3 + 1;
        switch (i7)
        {
        default: 
          i4 += this.s;
          if (i4 >= this.b) {
            break label509;
          }
          i5 = i4 * this.a;
          i7 = i5 + this.r;
          i4 = this.t + i7;
          if (this.a + i5 >= i4) {
            break label401;
          }
          i4 = this.a + i5;
          i5 = this.t * i6;
          if (i7 >= i4) {
            break label509;
          }
          i8 = this.O[i5];
          i8 = this.j[(i8 & 0xFF)];
          if (i8 == 0) {
            break label470;
          }
          localException[i7] = i8;
          break label470;
          this.z = Bitmap.createBitmap(localException, this.a, this.b, Bitmap.Config.ARGB_4444);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.xiaoenai.app.utils.f.a.e("memory error", new Object[0]);
        return;
      }
      if (i3 >= this.y) {
        continue;
      }
      i4 = (this.w + i3) * this.a + this.v;
      i5 = this.x;
      i1 = i4;
      break label422;
      this.A = null;
    }
    for (;;)
    {
      int i6;
      int i7;
      label327:
      int i8;
      label401:
      continue;
      label404:
      i1 = i4;
      i4 = i6;
      continue;
      label414:
      i2 = 0;
      i3 = 0;
      break;
      label422:
      while (i1 < i5 + i4)
      {
        localOutOfMemoryError[i1] = i2;
        i1 += 1;
      }
      continue;
      i5 = i2;
      i1 = i4;
      for (;;)
      {
        label448:
        i8 = i1 + i5;
        i2 = i5;
        i3 = i7;
        i4 = i1;
        i1 = i8;
        break;
        label470:
        i7 += 1;
        i5 += 1;
        break label327;
        i1 = 4;
        i5 = i2;
        continue;
        i1 = 2;
        i5 = 4;
        continue;
        i1 = 1;
        i5 = 2;
      }
      label509:
      i6 += 1;
      i4 = i1;
    }
  }
  
  private int f()
  {
    this.c = new ByteArrayInputStream(this.S);
    this.S = null;
    return g();
  }
  
  private int g()
  {
    j();
    if (this.c != null)
    {
      o();
      if (!i())
      {
        m();
        if (this.Q >= 0) {
          break label61;
        }
        this.d = 1;
        this.R.a(false, -1);
      }
    }
    for (;;)
    {
      try
      {
        this.c.close();
        return this.d;
        label61:
        com.xiaoenai.app.utils.f.a.e("readStreamOK={}", new Object[] { c() });
        com.xiaoenai.app.utils.f.a.e("readStreamOK={}", new Object[] { Integer.valueOf(this.a) });
        com.xiaoenai.app.utils.f.a.e("readStreamOK={}", new Object[] { Integer.valueOf(this.b) });
        this.d = -1;
        this.R.a(true, -1);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.d = 2;
      this.R.a(false, -1);
    }
  }
  
  private void h()
  {
    int i15 = this.t * this.u;
    if ((this.O == null) || (this.O.length < i15)) {
      this.O = new byte[i15];
    }
    if (this.L == null) {
      this.L = new short['က'];
    }
    if (this.M == null) {
      this.M = new byte['က'];
    }
    if (this.N == null) {
      this.N = new byte['ခ'];
    }
    int i16 = k();
    int i17 = 1 << i16;
    int i3 = i16 + 1;
    int i2 = (1 << i3) - 1;
    int i1 = 0;
    while (i1 < i17)
    {
      this.L[i1] = 0;
      this.M[i1] = ((byte)i1);
      i1 += 1;
    }
    int i8 = 0;
    int i12 = 0;
    int i11 = 0;
    int i5 = 0;
    int i10 = 0;
    i1 = 0;
    int i6 = 0;
    int i4 = -1;
    int i9 = i17 + 2;
    int i7 = 0;
    int i13;
    for (;;)
    {
      i13 = i5;
      if (i12 < i15)
      {
        if (i1 != 0) {
          break label610;
        }
        if (i13 >= i3) {
          break label285;
        }
        i5 = i7;
        if (i7 != 0) {
          break label240;
        }
        i5 = l();
        if (i5 > 0) {
          break label237;
        }
      }
      label213:
      label237:
      label240:
      label285:
      do
      {
        while (i6 < i15)
        {
          this.O[i6] = 0;
          i6 += 1;
        }
        i8 = 0;
        i14 = this.E[i8];
        i8 += 1;
        i7 = i5 - 1;
        i5 = i13 + 8;
        i11 = ((i14 & 0xFF) << i13) + i11;
        break;
        this.C = (i11 & i2);
        i11 >>= i3;
        i13 -= i3;
      } while ((this.C > i9) || (this.C == i17 + 1));
      if (this.C == i17)
      {
        i3 = i16 + 1;
        i2 = (1 << i3) - 1;
        i4 = -1;
        i9 = i17 + 2;
        i5 = i13;
      }
      else
      {
        if (i4 != -1) {
          break;
        }
        this.N[i1] = this.M[this.C];
        i4 = this.C;
        i10 = this.C;
        i1 += 1;
        i5 = i13;
      }
    }
    int i14 = this.C;
    if (this.C == i9)
    {
      byte[] arrayOfByte = this.N;
      i5 = i1 + 1;
      arrayOfByte[i1] = ((byte)i10);
      this.C = i4;
      i1 = i5;
    }
    for (;;)
    {
      if (this.C > i17)
      {
        this.N[i1] = this.M[this.C];
        this.C = this.L[this.C];
        i1 += 1;
      }
      else
      {
        i10 = this.M[this.C] & 0xFF;
        if (i9 >= 4096) {
          break label213;
        }
        this.N[i1] = ((byte)i10);
        this.L[i9] = ((short)i4);
        this.M[i9] = ((byte)i10);
        i9 += 1;
        if (((i9 & i2) == 0) && (i9 < 4096))
        {
          i3 += 1;
          i4 = i2 + i9;
          i2 = i3;
          i3 = i4;
        }
        for (;;)
        {
          i5 = i2;
          i4 = i14;
          i1 += 1;
          i2 = i3;
          i3 = i5;
          i5 = i13;
          break;
          label610:
          i1 -= 1;
          this.O[i6] = this.N[i1];
          i12 += 1;
          i6 += 1;
          i5 = i13;
          break;
          return;
          i4 = i3;
          i3 = i2;
          i2 = i4;
        }
      }
    }
  }
  
  private boolean i()
  {
    return this.d != 0;
  }
  
  private void j()
  {
    this.d = 0;
    this.Q = 0;
    this.P = null;
    this.h = null;
    this.i = null;
  }
  
  private int k()
  {
    try
    {
      int i1 = this.c.read();
      return i1;
    }
    catch (Exception localException)
    {
      this.d = 1;
      return 0;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.d = 1;
    }
    return 0;
  }
  
  private int l()
  {
    this.F = k();
    int i2 = 0;
    int i1 = 0;
    if (this.F > 0) {}
    for (;;)
    {
      try
      {
        if (i1 < this.F)
        {
          i2 = this.c.read(this.E, i1, this.F - i1);
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
      if (i1 < this.F)
      {
        this.d = 1;
        i2 = i1;
      }
      return i2;
      i1 += i2;
    }
  }
  
  private void m()
  {
    int i1 = 0;
    while ((i1 == 0) && (!i())) {
      switch (k())
      {
      case 0: 
      default: 
        this.d = 1;
        break;
      case 44: 
        p();
        break;
      case 33: 
        switch (k())
        {
        default: 
          u();
          break;
        case 249: 
          n();
          break;
        case 255: 
          l();
          String str = "";
          int i2 = 0;
          while (i2 < 11)
          {
            str = str + (char)this.E[i2];
            i2 += 1;
          }
          if (str.equals("NETSCAPE2.0")) {
            r();
          } else {
            u();
          }
          break;
        }
        break;
      case 59: 
        i1 = 1;
      }
    }
  }
  
  private void n()
  {
    boolean bool = true;
    k();
    int i1 = k();
    this.G = ((i1 & 0x1C) >> 2);
    if (this.G == 0) {
      this.G = 1;
    }
    if ((i1 & 0x1) != 0) {}
    for (;;)
    {
      this.I = bool;
      this.J = (s() * 10);
      this.K = k();
      k();
      return;
      bool = false;
    }
  }
  
  private void o()
  {
    String str = "";
    int i1 = 0;
    while (i1 < 6)
    {
      str = str + (char)k();
      i1 += 1;
    }
    if (!str.startsWith("GIF")) {
      this.d = 1;
    }
    do
    {
      return;
      q();
    } while ((!this.e) || (i()));
    this.h = c(this.f);
    this.l = this.h[this.k];
  }
  
  private void p()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        this.r = s();
        this.s = s();
        this.t = s();
        this.u = s();
        i1 = k();
        if ((i1 & 0x80) == 0) {
          break label368;
        }
        bool1 = true;
        this.o = bool1;
        if ((i1 & 0x40) == 0) {
          break label373;
        }
        bool1 = bool2;
        this.p = bool1;
        this.q = (2 << (i1 & 0x7));
        if (this.o)
        {
          this.i = c(this.q);
          this.j = this.i;
          if (!this.I) {
            break label362;
          }
          i1 = this.j[this.K];
          this.j[this.K] = 0;
          if (this.j == null) {
            this.d = 1;
          }
          if (!i()) {}
        }
        else
        {
          this.j = this.h;
          if (this.k != this.K) {
            continue;
          }
          this.l = 0;
          continue;
        }
        localc = this.P;
      }
      catch (Exception localException)
      {
        com.xiaoenai.app.utils.f.a.e("exception", new Object[0]);
        return;
        h();
        u();
        if (i()) {
          break label367;
        }
        this.Q += 1;
        this.z = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_4444);
        e();
        if (this.P == null)
        {
          this.P = new c(this.z, this.J);
          this.B = this.P;
          if (this.I) {
            this.j[this.K] = i1;
          }
          t();
          this.R.a(true, this.Q);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.xiaoenai.app.utils.f.a.e("memory error", new Object[0]);
        return;
      }
      c localc;
      while (localc.c != null) {
        localc = localc.c;
      }
      localc.c = new c(this.z, this.J);
      continue;
      label362:
      int i1 = 0;
      continue;
      label367:
      return;
      label368:
      boolean bool1 = false;
      continue;
      label373:
      bool1 = false;
    }
  }
  
  private void q()
  {
    this.a = s();
    this.b = s();
    int i1 = k();
    if ((i1 & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      this.f = (2 << (i1 & 0x7));
      this.k = k();
      this.n = k();
      return;
    }
  }
  
  private void r()
  {
    do
    {
      l();
      if (this.E[0] == 1) {
        this.g = (this.E[1] & 0xFF | (this.E[2] & 0xFF) << 8);
      }
    } while ((this.F > 0) && (!i()));
  }
  
  private int s()
  {
    return k() | k() << 8;
  }
  
  private void t()
  {
    this.H = this.G;
    this.v = this.r;
    this.w = this.s;
    this.x = this.t;
    this.y = this.u;
    this.A = this.z;
    this.m = this.l;
    this.G = 0;
    this.I = false;
    this.J = 0;
    this.i = null;
  }
  
  private void u()
  {
    do
    {
      l();
    } while ((this.F > 0) && (!i()));
  }
  
  public Bitmap a(int paramInt)
  {
    c localc = b(paramInt);
    if (localc == null) {
      return null;
    }
    return localc.a;
  }
  
  public void a()
  {
    for (c localc = this.P; localc != null; localc = this.P)
    {
      localc.a = null;
      this.P = this.P.c;
    }
    if (this.c != null) {}
    try
    {
      this.c.close();
      this.c = null;
      this.S = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int b()
  {
    return this.Q;
  }
  
  public c b(int paramInt)
  {
    c localc = this.P;
    int i1 = 0;
    while (localc != null)
    {
      if (i1 == paramInt) {
        return localc;
      }
      localc = localc.c;
      i1 += 1;
    }
    return null;
  }
  
  public Bitmap c()
  {
    return a(0);
  }
  
  public c d()
  {
    if (!this.D)
    {
      this.D = true;
      return this.P;
    }
    if (this.d == 0) {
      if (this.B.c != null) {
        this.B = this.B.c;
      }
    }
    for (;;)
    {
      return this.B;
      this.B = this.B.c;
      if (this.B == null) {
        this.B = this.P;
      }
    }
  }
  
  public void run()
  {
    if (this.c != null) {
      g();
    }
    while (this.S == null) {
      return;
    }
    f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\view\gif\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */