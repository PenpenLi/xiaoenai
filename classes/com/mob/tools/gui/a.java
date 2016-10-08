package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.mob.tools.a.l;
import com.mob.tools.b.g;
import com.mob.tools.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Timer;
import java.util.Vector;

public class a
{
  private static a a;
  private int b;
  private int c;
  private int d;
  private d<String, Bitmap> e;
  private boolean f;
  private Vector<b> g;
  private File h;
  private e[] i;
  private Vector<b> j;
  private c k;
  
  private a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.b = paramInt2;
      if (paramInt3 <= 0) {
        break label133;
      }
      paramInt2 = paramInt3;
      label21:
      this.c = paramInt2;
      if (paramFloat <= 1.0F) {
        break label139;
      }
      paramInt2 = (int)(paramInt3 * paramFloat);
      label41:
      this.d = paramInt2;
      this.g = new Vector();
      this.j = new Vector();
      if (paramInt1 <= 0) {
        break label145;
      }
      label72:
      this.i = new e[paramInt1];
      if (paramInt4 <= 0) {
        break label150;
      }
    }
    for (;;)
    {
      this.e = new d(paramInt4);
      this.h = new File(g.c(paramContext));
      this.k = new c(this);
      return;
      paramInt2 = 200;
      break;
      label133:
      paramInt2 = 100;
      break label21;
      label139:
      paramInt2 = 120;
      break label41;
      label145:
      paramInt1 = 3;
      break label72;
      label150:
      paramInt4 = 50;
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      a(paramContext, 0, 0, 0, 0.0F, 0);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext.getApplicationContext(), paramInt1, paramInt2, paramInt3, paramFloat, paramInt4);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Bitmap paramBitmap);
  }
  
  public static class b
  {
    private String a;
    private a.a b;
    private a.e c;
    private long d = System.currentTimeMillis();
    private Bitmap e;
    
    private void a(Bitmap paramBitmap)
    {
      this.e = paramBitmap;
      if (this.b != null) {
        this.b.a(this.a, this.e);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url=").append(this.a);
      localStringBuilder.append("time=").append(this.d);
      localStringBuilder.append("worker=").append(this.c.getName()).append(" (").append(this.c.getId()).append("");
      return localStringBuilder.toString();
    }
  }
  
  private static class c
    extends Timer
  {
    private a a;
    
    public c(a parama)
    {
      this.a = parama;
      schedule(new b(this), 0L, a.b(this.a));
    }
    
    private void a()
    {
      if (a.c(this.a) != null) {
        a.c(this.a).a(System.currentTimeMillis() - 60000L);
      }
      if (a.c(this.a) == null)
      {
        i = 0;
        e.a().d(">>>> BitmapProcessor.cachePool: " + i, new Object[0]);
        if (a.d(this.a) != null) {
          break label136;
        }
      }
      label136:
      for (int i = 0;; i = a.d(this.a).size())
      {
        e.a().d(">>>> BitmapProcessor.reqList: " + i, new Object[0]);
        if (a.a(this.a)) {
          break label150;
        }
        return;
        i = a.c(this.a).a();
        break;
      }
      label150:
      long l = System.currentTimeMillis();
      i = 0;
      label156:
      boolean bool;
      if (i < a.e(this.a).length)
      {
        if (a.e(this.a)[i] != null) {
          break label280;
        }
        a.e(this.a)[i] = new a.e(this.a);
        a.e(this.a)[i].setName("worker " + i);
        a.e locale = a.e(this.a)[i];
        if (i != 0) {
          break label274;
        }
        bool = true;
        label248:
        a.e.a(locale, bool);
        a.e(this.a)[i].start();
      }
      for (;;)
      {
        i += 1;
        break label156;
        break;
        label274:
        bool = false;
        break label248;
        label280:
        if (l - a.e.a(a.e(this.a)[i]) > a.b(this.a) * 100)
        {
          a.e(this.a)[i].interrupt();
          bool = a.e.b(a.e(this.a)[i]);
          a.e(this.a)[i] = new a.e(this.a);
          a.e(this.a)[i].setName("worker " + i);
          a.e.a(a.e(this.a)[i], bool);
          a.e(this.a)[i].start();
        }
      }
    }
  }
  
  private static class d
    extends FilterInputStream
  {
    InputStream a;
    
    protected d(InputStream paramInputStream)
    {
      super();
      this.a = paramInputStream;
    }
    
    public long skip(long paramLong)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2) {
        if (l1 < paramLong)
        {
          l2 = this.a.skip(paramLong - l1);
          if (l2 != 0L) {}
        }
        else
        {
          return l1;
        }
      }
    }
  }
  
  private static class e
    extends Thread
  {
    private a a;
    private long b;
    private boolean c;
    private a.b d;
    
    public e(a parama)
    {
      this.a = parama;
      this.b = System.currentTimeMillis();
    }
    
    private void a()
    {
      if (a.d(this.a).size() > 0) {}
      Object localObject;
      for (a.b localb = (a.b)a.d(this.a).remove(0);; localObject = null)
      {
        if (localb != null)
        {
          Bitmap localBitmap = (Bitmap)a.c(this.a).a(a.b.a(localb));
          if (localBitmap != null)
          {
            this.d = localb;
            a.b.a(this.d, this);
            a.b.a(localb, localBitmap);
          }
          for (;;)
          {
            this.b = System.currentTimeMillis();
            return;
            if (new File(a.f(this.a), com.mob.tools.b.b.b(a.b.a(localb))).exists())
            {
              a(localb);
              this.b = System.currentTimeMillis();
              return;
            }
            if (a.g(this.a).size() > a.h(this.a))
            {
              while (a.d(this.a).size() > 0) {
                a.d(this.a).remove(0);
              }
              a.g(this.a).remove(0);
            }
            a.g(this.a).add(localb);
          }
        }
        this.b = System.currentTimeMillis();
        try
        {
          Thread.sleep(30L);
          return;
        }
        catch (Throwable localThrowable)
        {
          return;
        }
      }
    }
    
    private void a(Bitmap paramBitmap, File paramFile, boolean paramBoolean)
    {
      try
      {
        if (paramFile.exists()) {
          paramFile.delete();
        }
        if (!paramFile.getParentFile().exists()) {
          paramFile.getParentFile().mkdirs();
        }
        paramFile.createNewFile();
        if (paramBoolean) {}
        for (Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;; localCompressFormat = Bitmap.CompressFormat.JPEG)
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
          paramBitmap.compress(localCompressFormat, 100, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return;
        }
        return;
      }
      catch (Throwable paramBitmap)
      {
        if (paramFile.exists()) {
          paramFile.delete();
        }
      }
    }
    
    private void a(a.b paramb)
    {
      this.d = paramb;
      a.b.a(this.d, this);
      boolean bool;
      Object localObject;
      if ((a.b.a(paramb).toLowerCase().endsWith("png")) || (a.b.a(paramb).toLowerCase().endsWith("gif")))
      {
        bool = true;
        localObject = new File(a.f(this.a), com.mob.tools.b.b.b(a.b.a(paramb)));
        if (!((File)localObject).exists()) {
          break label149;
        }
        localObject = com.mob.tools.b.a.a(((File)localObject).getAbsolutePath());
        if (localObject != null)
        {
          a.c(this.a).a(a.b.a(paramb), localObject);
          a.b.a(paramb, (Bitmap)localObject);
        }
        this.d = null;
      }
      for (;;)
      {
        if (localObject != null)
        {
          a.c(this.a).a(a.b.a(paramb), localObject);
          a.b.a(paramb, (Bitmap)localObject);
        }
        this.d = null;
        return;
        bool = false;
        break;
        label149:
        new l().rawGet(a.b.a(paramb), new c(this, (File)localObject, bool, paramb), null);
        localObject = null;
      }
    }
    
    private void b()
    {
      a.b localb = null;
      if (a.g(this.a).size() > 0) {
        localb = (a.b)a.g(this.a).remove(0);
      }
      if ((localb == null) && (a.d(this.a).size() > 0)) {
        localb = (a.b)a.d(this.a).remove(0);
      }
      for (;;)
      {
        if (localb != null)
        {
          Bitmap localBitmap = (Bitmap)a.c(this.a).a(a.b.a(localb));
          if (localBitmap != null)
          {
            this.d = localb;
            a.b.a(this.d, this);
            a.b.a(localb, localBitmap);
          }
          for (;;)
          {
            this.b = System.currentTimeMillis();
            return;
            a(localb);
          }
        }
        this.b = System.currentTimeMillis();
        try
        {
          Thread.sleep(30L);
          return;
        }
        catch (Throwable localThrowable)
        {
          return;
        }
      }
    }
    
    public void interrupt()
    {
      try
      {
        super.interrupt();
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    public void run()
    {
      while (a.a(this.a))
      {
        try
        {
          if (!this.c) {
            break label36;
          }
          a();
        }
        catch (Throwable localThrowable)
        {
          e.a().w(localThrowable);
        }
        continue;
        label36:
        b();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */