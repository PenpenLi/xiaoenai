package com.xiaoenai.app.utils.e.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.b.b.a;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.a.g;
import com.nostra13.universalimageloader.core.c.a;
import com.nostra13.universalimageloader.core.d.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class h
  extends a
{
  h(f paramf)
  {
    super(paramf);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    for (;;)
    {
      try
      {
        Matrix localMatrix = new Matrix();
        if (paramInt == 6)
        {
          localMatrix.postRotate(90.0F);
          return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        }
        if (paramInt == 3)
        {
          localMatrix.postRotate(180.0F);
          continue;
        }
        if (paramInt != 8) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramBitmap;
      }
      localException.postRotate(270.0F);
    }
  }
  
  private b.a a(com.xiaoenai.app.utils.e.d.a parama)
  {
    return new i(this, parama);
  }
  
  private com.nostra13.universalimageloader.core.a.d a(com.xiaoenai.app.utils.e.a.c paramc)
  {
    if (paramc != null)
    {
      if (com.xiaoenai.app.utils.e.a.c.a == paramc) {
        return com.nostra13.universalimageloader.core.a.d.a;
      }
      if (com.xiaoenai.app.utils.e.a.c.b == paramc) {
        return com.nostra13.universalimageloader.core.a.d.b;
      }
      if (com.xiaoenai.app.utils.e.a.c.c == paramc) {
        return com.nostra13.universalimageloader.core.a.d.c;
      }
      if (com.xiaoenai.app.utils.e.a.c.d == paramc) {
        return com.nostra13.universalimageloader.core.a.d.d;
      }
      if (com.xiaoenai.app.utils.e.a.c.e == paramc) {
        return com.nostra13.universalimageloader.core.a.d.e;
      }
      if (com.xiaoenai.app.utils.e.a.c.f == paramc) {
        return com.nostra13.universalimageloader.core.a.d.f;
      }
      return com.nostra13.universalimageloader.core.a.d.c;
    }
    return com.nostra13.universalimageloader.core.a.d.c;
  }
  
  private com.nostra13.universalimageloader.core.a.e a(com.xiaoenai.app.utils.e.a.d paramd)
  {
    com.nostra13.universalimageloader.core.a.e locale = null;
    if (paramd != null) {
      locale = new com.nostra13.universalimageloader.core.a.e(paramd.a(), paramd.b());
    }
    return locale;
  }
  
  private com.nostra13.universalimageloader.core.c a(d paramd)
  {
    return new c.a().a(paramd.a).b(paramd.b).c(paramd.c).a(paramd.d).a(com.nostra13.universalimageloader.core.a.d.c).a(paramd.e).a();
  }
  
  private com.nostra13.universalimageloader.core.c a(String paramString, d paramd)
  {
    d locald = paramd;
    if (paramd == null)
    {
      locald = paramd;
      if (this.a != null) {
        locald = this.a.g;
      }
    }
    com.nostra13.universalimageloader.core.c.a locala;
    boolean bool;
    if ((this.a != null) && (this.a.h != null)) {
      if ((locald == null) || (locald.e == null))
      {
        paramd = this.a.h.a(paramString);
        locala = b(locald);
        if ((!paramString.startsWith("http")) || ((locald != null) && (!locald.c))) {
          break label258;
        }
        bool = true;
        label95:
        if (!paramString.startsWith("file")) {
          break label332;
        }
        if (locald == null) {
          break label276;
        }
        paramd = new c.a().a(locald.a).b(locald.b).c(bool).a(locald.d).a(a(locald.l)).a(paramd).b(locald.j).a(locald.i).c(locald.j).b(locald.g).a(locald.f).c(locald.h).c(locald.k);
        if (locald.r != null) {
          break label264;
        }
      }
    }
    label258:
    label264:
    for (paramString = e(paramString);; paramString = a(locald.r))
    {
      return paramd.a(paramString).a(locala).a();
      paramd = locald.e;
      break;
      if (locald != null)
      {
        paramd = locald.e;
        break;
      }
      paramd = null;
      break;
      bool = false;
      break label95;
    }
    label276:
    paramd = new c.a().a(paramd).c(bool);
    if (locald.r == null) {}
    for (paramString = e(paramString);; paramString = a(locald.r)) {
      return paramd.a(paramString).a(locala).a();
    }
    label332:
    if (locald != null) {
      return new c.a().a(locald.a).b(locald.b).c(bool).a(locald.d).a(a(locald.l)).a(paramd).a(locala).b(locald.j).a(locald.i).c(locald.j).b(locald.g).a(locald.f).c(locald.h).c(locald.k).a(a(locald.r)).a();
    }
    return new c.a().a(paramd).a(locala).c(bool).a(a(locald.r)).a();
  }
  
  private com.nostra13.universalimageloader.core.f.a a(com.xiaoenai.app.utils.e.d.b paramb)
  {
    j localj = null;
    if (paramb != null) {
      localj = new j(this, paramb);
    }
    return localj;
  }
  
  private com.nostra13.universalimageloader.core.f.a a(com.xiaoenai.app.utils.e.d.c paramc)
  {
    k localk = null;
    if (paramc != null) {
      localk = new k(this, paramc);
    }
    return localk;
  }
  
  private com.nostra13.universalimageloader.core.f.b a(com.xiaoenai.app.utils.e.d.d paramd)
  {
    l locall = null;
    if (paramd != null) {
      locall = new l(this, paramd);
    }
    return locall;
  }
  
  private com.nostra13.universalimageloader.core.g.a a(com.xiaoenai.app.utils.e.a parama)
  {
    m localm = null;
    if (parama != null) {
      localm = new m(this, parama);
    }
    return localm;
  }
  
  private com.nostra13.universalimageloader.core.c.a b(d paramd)
  {
    if (paramd != null)
    {
      if ((paramd.p > 0.0F) || (paramd.o != null)) {
        return new com.nostra13.universalimageloader.core.c.b(paramd.o, paramd.p);
      }
      if (paramd.m > 0) {
        return new com.nostra13.universalimageloader.core.c.d(paramd.m, paramd.n);
      }
      if (paramd.q > 0) {
        return new com.nostra13.universalimageloader.core.c.c(paramd.q);
      }
      return new com.nostra13.universalimageloader.core.c.e();
    }
    return new com.nostra13.universalimageloader.core.c.e();
  }
  
  private com.nostra13.universalimageloader.core.g.a e(String paramString)
  {
    Object localObject = null;
    int i = f(paramString);
    paramString = (String)localObject;
    if (1 != i)
    {
      paramString = (String)localObject;
      if (i != 0) {
        paramString = new n(this, i);
      }
    }
    return paramString;
  }
  
  private int f(String paramString)
  {
    int j = 1;
    int k = 1;
    i = k;
    if (!TextUtils.isEmpty(paramString))
    {
      i = k;
      if (!paramString.startsWith("http")) {
        i = j;
      }
    }
    try
    {
      if (paramString.startsWith("file://")) {
        i = j;
      }
      for (String str = paramString.substring(6, paramString.length());; str = paramString)
      {
        i = j;
        ExifInterface localExifInterface = new ExifInterface(str);
        i = j;
        com.xiaoenai.app.utils.f.a.c("url: {} {}", new Object[] { str, paramString });
        i = j;
        j = localExifInterface.getAttributeInt("Orientation", 1);
        i = j;
        com.xiaoenai.app.utils.f.a.c("Exif orientation : {}", new Object[] { Integer.valueOf(j) });
        i = j;
        return i;
      }
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public File a(String paramString)
  {
    return ImageLoader.getInstance().getDiskCache().a(paramString);
  }
  
  public void a()
  {
    ImageLoader.getInstance().getMemoryCache().b();
  }
  
  public void a(ImageView paramImageView, String paramString, d paramd, com.xiaoenai.app.utils.e.a.d paramd1, com.xiaoenai.app.utils.e.d.b paramb, com.xiaoenai.app.utils.e.d.d paramd2)
  {
    ImageLoader.getInstance().displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), a(paramString, paramd), a(paramd1), a(paramb), a(paramd2));
  }
  
  protected void a(f paramf)
  {
    paramf = new d.a(paramf.a).a(paramf.b).b(paramf.c).d(paramf.e).e(paramf.d).a(new com.nostra13.universalimageloader.a.a.b.b()).c(paramf.f).a().a(g.b).a(new com.xiaoenai.app.utils.e.b.a(paramf.a)).a(a(paramf.g)).b();
    ImageLoader.getInstance().init(paramf);
    com.xiaoenai.app.utils.f.a.c("mImageLoaderOptions {}", new Object[] { this.a });
  }
  
  public void a(String paramString, d paramd, com.xiaoenai.app.utils.e.a.d paramd1, com.xiaoenai.app.utils.e.d.c paramc, com.xiaoenai.app.utils.e.d.d paramd2)
  {
    ImageLoader.getInstance().loadImage(paramString, a(paramd1), a(paramString, paramd), a(paramc), a(paramd2));
  }
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      boolean bool = ImageLoader.getInstance().getDiskCache().a(paramString, paramBitmap);
      return bool;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(String paramString, InputStream paramInputStream, com.xiaoenai.app.utils.e.d.a parama)
  {
    try
    {
      boolean bool = ImageLoader.getInstance().getDiskCache().a(paramString, paramInputStream, a(parama));
      return bool;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public Bitmap b(String paramString)
  {
    return ImageLoader.getInstance().getMemoryCache().a(paramString);
  }
  
  public void b()
  {
    ImageLoader.getInstance().getDiskCache().b();
  }
  
  public void c()
  {
    com.xiaoenai.app.utils.f.a.c("imageloader stop", new Object[0]);
    ImageLoader.getInstance().stop();
  }
  
  public void c(String paramString)
  {
    ImageLoader.getInstance().getMemoryCache().b(paramString);
  }
  
  public void d()
  {
    com.xiaoenai.app.utils.f.a.c("imageloader stop", new Object[0]);
    ImageLoader.getInstance().resume();
  }
  
  public void d(String paramString)
  {
    ImageLoader.getInstance().getDiskCache().b(paramString);
  }
  
  public void e()
  {
    com.xiaoenai.app.utils.f.a.c("imageloader pause", new Object[0]);
    ImageLoader.getInstance().pause();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */