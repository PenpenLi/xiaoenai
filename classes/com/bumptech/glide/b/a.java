package com.bumptech.glide.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private int[] c;
  private ByteBuffer d;
  private final byte[] e = new byte['Ā'];
  private short[] f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  private int[] j;
  private int k;
  private byte[] l;
  private c m;
  private a n;
  private Bitmap o;
  private boolean p;
  private int q;
  
  public a(a parama)
  {
    this.n = parama;
    this.m = new c();
  }
  
  private Bitmap a(b paramb1, b paramb2)
  {
    int i8 = this.m.f;
    int i9 = this.m.g;
    int[] arrayOfInt = this.j;
    int i1;
    int i4;
    int i3;
    label85:
    int i2;
    int i7;
    if ((paramb2 != null) && (paramb2.g > 0))
    {
      if (paramb2.g == 2)
      {
        i1 = 0;
        if (!paramb1.f) {
          i1 = this.m.l;
        }
        Arrays.fill(arrayOfInt, i1);
      }
    }
    else
    {
      a(paramb1);
      int i5 = 1;
      i4 = 8;
      int i6 = 0;
      i3 = 0;
      if (i3 >= paramb1.d) {
        break label397;
      }
      if (!paramb1.e) {
        break label472;
      }
      i1 = i6;
      i2 = i4;
      i7 = i5;
      if (i6 >= paramb1.d) {
        i7 = i5 + 1;
      }
      switch (i7)
      {
      default: 
        i2 = i4;
        i1 = i6;
        label164:
        i6 = i1 + i2;
        i5 = i7;
      }
    }
    for (;;)
    {
      i1 += paramb1.b;
      if (i1 < this.m.g)
      {
        int i10 = this.m.f * i1;
        i7 = i10 + paramb1.a;
        i4 = paramb1.c + i7;
        i1 = i4;
        if (this.m.f + i10 < i4) {
          i1 = this.m.f + i10;
        }
        i4 = paramb1.c * i3;
        for (;;)
        {
          if (i7 < i1)
          {
            i10 = this.i[i4];
            i10 = this.c[(i10 & 0xFF)];
            if (i10 != 0) {
              arrayOfInt[i7] = i10;
            }
            i7 += 1;
            i4 += 1;
            continue;
            if ((paramb2.g != 3) || (this.o == null)) {
              break;
            }
            this.o.getPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
            break;
            i1 = 4;
            i2 = i4;
            break label164;
            i1 = 2;
            i2 = 4;
            break label164;
            i1 = 1;
            i2 = 2;
            break label164;
          }
        }
      }
      i3 += 1;
      i4 = i2;
      break label85;
      label397:
      if ((this.p) && ((paramb1.g == 0) || (paramb1.g == 1)))
      {
        if (this.o == null) {
          this.o = j();
        }
        this.o.setPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
      }
      paramb1 = j();
      paramb1.setPixels(arrayOfInt, 0, i8, 0, 0, i8, i9);
      return paramb1;
      label472:
      i1 = i3;
      i2 = i4;
    }
  }
  
  @TargetApi(12)
  private static void a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {
      paramBitmap.setHasAlpha(true);
    }
  }
  
  private void a(b paramb)
  {
    if (paramb != null) {
      this.d.position(paramb.j);
    }
    if (paramb == null) {}
    int i18;
    int i19;
    int i15;
    for (int i14 = this.m.f * this.m.g;; i14 = paramb.c * paramb.d)
    {
      if ((this.i == null) || (this.i.length < i14)) {
        this.i = new byte[i14];
      }
      if (this.f == null) {
        this.f = new short['က'];
      }
      if (this.g == null) {
        this.g = new byte['က'];
      }
      if (this.h == null) {
        this.h = new byte['ခ'];
      }
      i18 = h();
      i19 = 1 << i18;
      i15 = -1;
      i2 = i18 + 1;
      i1 = 0;
      while (i1 < i19)
      {
        this.f[i1] = 0;
        this.g[i1] = ((byte)i1);
        i1 += 1;
      }
    }
    int i10 = 0;
    int i13 = 0;
    int i8 = 0;
    int i5 = 0;
    int i9 = 0;
    int i4 = i2;
    int i7 = (1 << i2) - 1;
    int i6 = i19 + 2;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      if (i13 < i14)
      {
        i11 = i2;
        i2 = i3;
        if (i3 != 0) {
          break label267;
        }
        i2 = i();
        if (i2 <= 0) {
          this.q = 3;
        }
      }
      else
      {
        while (i1 < i14)
        {
          this.i[i1] = 0;
          i1 += 1;
        }
      }
      int i11 = 0;
      label267:
      int i17 = this.e[i11];
      int i12 = i11 + 1;
      i11 = i2 - 1;
      i3 = i4;
      int i16 = i7;
      i4 = i5;
      i7 = i10 + ((i17 & 0xFF) << i9);
      i2 = i6;
      i10 = i9 + 8;
      i5 = i15;
      i6 = i1;
      i1 = i16;
      for (;;)
      {
        if (i10 < i3) {
          break label803;
        }
        i9 = i7 & i1;
        i7 >>= i3;
        i10 -= i3;
        if (i9 == i19)
        {
          i3 = i18 + 1;
          i1 = (1 << i3) - 1;
          i2 = i19 + 2;
          i5 = -1;
        }
        else
        {
          if (i9 > i2)
          {
            this.q = 3;
            i16 = i4;
            i9 = i10;
            i4 = i3;
            i17 = i2;
            i2 = i12;
            i10 = i7;
            i7 = i1;
            i3 = i11;
            i1 = i6;
            i15 = i5;
            i5 = i16;
            i6 = i17;
            break;
          }
          if (i9 == i19 + 1)
          {
            i16 = i4;
            i9 = i10;
            i4 = i3;
            i17 = i2;
            i2 = i12;
            i10 = i7;
            i7 = i1;
            i3 = i11;
            i1 = i6;
            i15 = i5;
            i5 = i16;
            i6 = i17;
            break;
          }
          if (i5 != -1) {
            break label542;
          }
          this.h[i8] = this.g[i9];
          i8 += 1;
          i4 = i9;
          i5 = i9;
        }
      }
      label542:
      if (i9 >= i2)
      {
        this.h[i8] = ((byte)i4);
        i8 += 1;
        i4 = i5;
      }
      for (;;)
      {
        if (i4 >= i19)
        {
          this.h[i8] = this.g[i4];
          i4 = this.f[i4];
          i8 += 1;
        }
        else
        {
          i16 = this.g[i4] & 0xFF;
          paramb = this.h;
          i17 = i8 + 1;
          paramb[i8] = ((byte)i16);
          i15 = i3;
          i8 = i1;
          i4 = i2;
          if (i2 < 4096)
          {
            this.f[i2] = ((short)i5);
            this.g[i2] = ((byte)i16);
            i2 += 1;
            i15 = i3;
            i8 = i1;
            i4 = i2;
            if ((i2 & i1) == 0)
            {
              i15 = i3;
              i8 = i1;
              i4 = i2;
              if (i2 < 4096)
              {
                i15 = i3 + 1;
                i8 = i1 + i2;
                i4 = i2;
              }
            }
          }
          i2 = i13;
          i1 = i17;
          while (i1 > 0)
          {
            i1 -= 1;
            this.i[i6] = this.h[i1];
            i2 += 1;
            i6 += 1;
            continue;
            return;
          }
          i13 = i2;
          i5 = i9;
          i9 = i1;
          i3 = i15;
          i1 = i8;
          i2 = i4;
          i8 = i9;
          i4 = i16;
          break;
          i4 = i9;
        }
      }
      label803:
      i16 = i4;
      i17 = i1;
      i1 = i11;
      i4 = i3;
      i11 = i2;
      i9 = i10;
      i2 = i12;
      i3 = i1;
      i1 = i6;
      i10 = i7;
      i15 = i5;
      i5 = i16;
      i7 = i17;
      i6 = i11;
    }
  }
  
  private int h()
  {
    try
    {
      int i1 = this.d.get();
      return i1 & 0xFF;
    }
    catch (Exception localException)
    {
      this.q = 1;
    }
    return 0;
  }
  
  private int i()
  {
    int i3 = h();
    int i2 = 0;
    int i1 = 0;
    if (i3 > 0) {
      for (;;)
      {
        i2 = i1;
        if (i1 < i3)
        {
          i2 = i3 - i1;
          try
          {
            this.d.get(this.e, i1, i2);
            i1 += i2;
          }
          catch (Exception localException)
          {
            Log.w(a, "Error Reading Block", localException);
            this.q = 1;
            i2 = i1;
          }
        }
      }
    }
    return i2;
  }
  
  private Bitmap j()
  {
    Bitmap localBitmap2 = this.n.a(this.m.f, this.m.g, b);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = Bitmap.createBitmap(this.m.f, this.m.g, b);
    }
    a(localBitmap1);
    return localBitmap1;
  }
  
  public int a(int paramInt)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramInt >= 0)
    {
      i1 = i2;
      if (paramInt < this.m.c) {
        i1 = ((b)this.m.e.get(paramInt)).i;
      }
    }
    return i1;
  }
  
  public void a()
  {
    this.k = ((this.k + 1) % this.m.c);
  }
  
  public void a(c paramc, byte[] paramArrayOfByte)
  {
    this.m = paramc;
    this.l = paramArrayOfByte;
    this.q = 0;
    this.k = -1;
    this.d = ByteBuffer.wrap(paramArrayOfByte);
    this.d.rewind();
    this.d.order(ByteOrder.LITTLE_ENDIAN);
    this.p = false;
    paramArrayOfByte = paramc.e.iterator();
    while (paramArrayOfByte.hasNext()) {
      if (((b)paramArrayOfByte.next()).g == 3) {
        this.p = true;
      }
    }
    this.i = new byte[paramc.f * paramc.g];
    this.j = new int[paramc.f * paramc.g];
  }
  
  public int b()
  {
    if ((this.m.c <= 0) || (this.k < 0)) {
      return -1;
    }
    return a(this.k);
  }
  
  public int c()
  {
    return this.m.c;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public int e()
  {
    return this.m.m;
  }
  
  public Bitmap f()
  {
    int i1 = 0;
    for (;;)
    {
      b localb2;
      try
      {
        if ((this.m.c <= 0) || (this.k < 0))
        {
          if (Log.isLoggable(a, 3)) {
            Log.d(a, "unable to decode frame, frameCount=" + this.m.c + " framePointer=" + this.k);
          }
          this.q = 1;
        }
        if ((this.q == 1) || (this.q == 2))
        {
          if (Log.isLoggable(a, 3)) {
            Log.d(a, "Unable to decode frame, status=" + this.q);
          }
          localObject = null;
          return (Bitmap)localObject;
        }
        this.q = 0;
        localb2 = (b)this.m.e.get(this.k);
        int i2 = this.k - 1;
        if (i2 < 0) {
          break label345;
        }
        Object localObject = (b)this.m.e.get(i2);
        if (localb2.k == null)
        {
          this.c = this.m.a;
          if (localb2.f)
          {
            i1 = this.c[localb2.h];
            this.c[localb2.h] = 0;
          }
          if (this.c == null)
          {
            if (Log.isLoggable(a, 3)) {
              Log.d(a, "No Valid Color Table");
            }
            this.q = 1;
            localObject = null;
          }
        }
        else
        {
          this.c = localb2.k;
          if (this.m.j != localb2.h) {
            continue;
          }
          this.m.l = 0;
          continue;
        }
        localBitmap = a(localb2, localb1);
      }
      finally {}
      if (localb2.f) {
        this.c[localb2.h] = i1;
      }
      continue;
      label345:
      Bitmap localBitmap = null;
    }
  }
  
  public void g()
  {
    this.m = null;
    this.l = null;
    this.i = null;
    this.j = null;
    if (this.o != null) {
      this.n.a(this.o);
    }
    this.o = null;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
    
    public abstract void a(Bitmap paramBitmap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */