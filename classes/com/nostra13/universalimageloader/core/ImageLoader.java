package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.a.f;

public class ImageLoader
{
  private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
  private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
  private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  static final String LOG_DESTROY = "Destroy ImageLoader";
  static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
  static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
  public static final String TAG = ImageLoader.class.getSimpleName();
  private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  private static volatile ImageLoader instance;
  private d configuration;
  private com.nostra13.universalimageloader.core.f.a defaultListener = new com.nostra13.universalimageloader.core.f.c();
  private e engine;
  
  private void checkConfiguration()
  {
    if (this.configuration == null) {
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
    }
  }
  
  private static Handler defineHandler(c paramc)
  {
    Handler localHandler = paramc.r();
    if (paramc.s()) {
      paramc = null;
    }
    do
    {
      do
      {
        return paramc;
        paramc = localHandler;
      } while (localHandler != null);
      paramc = localHandler;
    } while (Looper.myLooper() != Looper.getMainLooper());
    return new Handler();
  }
  
  public static ImageLoader getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ImageLoader();
      }
      return instance;
    }
    finally {}
  }
  
  public void cancelDisplayTask(ImageView paramImageView)
  {
    this.engine.b(new com.nostra13.universalimageloader.core.e.b(paramImageView));
  }
  
  public void cancelDisplayTask(com.nostra13.universalimageloader.core.e.a parama)
  {
    this.engine.b(parama);
  }
  
  @Deprecated
  public void clearDiscCache()
  {
    clearDiskCache();
  }
  
  public void clearDiskCache()
  {
    checkConfiguration();
    this.configuration.o.b();
  }
  
  public void clearMemoryCache()
  {
    checkConfiguration();
    this.configuration.n.b();
  }
  
  public void denyNetworkDownloads(boolean paramBoolean)
  {
    this.engine.a(paramBoolean);
  }
  
  public void destroy()
  {
    if (this.configuration != null) {
      com.nostra13.universalimageloader.b.c.a("Destroy ImageLoader", new Object[0]);
    }
    stop();
    this.configuration.o.a();
    this.engine = null;
    this.configuration = null;
  }
  
  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), null, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, com.nostra13.universalimageloader.core.a.e parame)
  {
    displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), null, parame, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, c paramc)
  {
    displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), paramc, null, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, c paramc, com.nostra13.universalimageloader.core.f.a parama)
  {
    displayImage(paramString, paramImageView, paramc, parama, null);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, c paramc, com.nostra13.universalimageloader.core.f.a parama, com.nostra13.universalimageloader.core.f.b paramb)
  {
    displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), paramc, parama, paramb);
  }
  
  public void displayImage(String paramString, ImageView paramImageView, com.nostra13.universalimageloader.core.f.a parama)
  {
    displayImage(paramString, new com.nostra13.universalimageloader.core.e.b(paramImageView), null, parama, null);
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama)
  {
    displayImage(paramString, parama, null, null, null);
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama, c paramc)
  {
    displayImage(paramString, parama, paramc, null, null);
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama, c paramc, com.nostra13.universalimageloader.core.a.e parame, com.nostra13.universalimageloader.core.f.a parama1, com.nostra13.universalimageloader.core.f.b paramb)
  {
    checkConfiguration();
    if (parama == null) {
      throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    }
    if (parama1 == null) {
      parama1 = this.defaultListener;
    }
    for (;;)
    {
      if (paramc == null) {
        paramc = this.configuration.r;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString))
        {
          this.engine.b(parama);
          parama1.a(paramString, parama.d());
          if (paramc.b()) {
            parama.a(paramc.b(this.configuration.a));
          }
          for (;;)
          {
            parama1.a(paramString, parama.d(), null);
            return;
            parama.a(null);
          }
        }
        if (parame == null) {
          parame = com.nostra13.universalimageloader.b.a.a(parama, this.configuration.a());
        }
        for (;;)
        {
          String str = com.nostra13.universalimageloader.b.d.a(paramString, parame);
          this.engine.a(parama, str);
          parama1.a(paramString, parama.d());
          Bitmap localBitmap = this.configuration.n.a(str);
          if ((localBitmap != null) && (!localBitmap.isRecycled()))
          {
            com.nostra13.universalimageloader.b.c.a("Load image from memory cache [%s]", new Object[] { str });
            if (paramc.e())
            {
              paramString = new g(paramString, parama, parame, str, paramc, parama1, paramb, this.engine.a(paramString));
              paramString = new l(this.engine, localBitmap, paramString, defineHandler(paramc));
              if (paramc.s())
              {
                paramString.run();
                return;
              }
              this.engine.a(paramString);
              return;
            }
            paramc.q().a(localBitmap, parama, f.c);
            parama1.a(paramString, parama.d(), localBitmap);
            return;
          }
          if (paramc.a()) {
            parama.a(paramc.a(this.configuration.a));
          }
          for (;;)
          {
            paramString = new g(paramString, parama, parame, str, paramc, parama1, paramb, this.engine.a(paramString));
            paramString = new h(this.engine, paramString, defineHandler(paramc));
            if (!paramc.s()) {
              break;
            }
            paramString.run();
            return;
            if (paramc.g()) {
              parama.a(null);
            }
          }
          this.engine.a(paramString);
          return;
        }
      }
    }
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama, c paramc, com.nostra13.universalimageloader.core.f.a parama1)
  {
    displayImage(paramString, parama, paramc, parama1, null);
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama, c paramc, com.nostra13.universalimageloader.core.f.a parama1, com.nostra13.universalimageloader.core.f.b paramb)
  {
    displayImage(paramString, parama, paramc, null, parama1, paramb);
  }
  
  public void displayImage(String paramString, com.nostra13.universalimageloader.core.e.a parama, com.nostra13.universalimageloader.core.f.a parama1)
  {
    displayImage(paramString, parama, null, parama1, null);
  }
  
  @Deprecated
  public com.nostra13.universalimageloader.a.a.a getDiscCache()
  {
    return getDiskCache();
  }
  
  public com.nostra13.universalimageloader.a.a.a getDiskCache()
  {
    checkConfiguration();
    return this.configuration.o;
  }
  
  public String getLoadingUriForView(ImageView paramImageView)
  {
    return this.engine.a(new com.nostra13.universalimageloader.core.e.b(paramImageView));
  }
  
  public String getLoadingUriForView(com.nostra13.universalimageloader.core.e.a parama)
  {
    return this.engine.a(parama);
  }
  
  public com.nostra13.universalimageloader.a.b.a getMemoryCache()
  {
    checkConfiguration();
    return this.configuration.n;
  }
  
  public void handleSlowNetwork(boolean paramBoolean)
  {
    this.engine.b(paramBoolean);
  }
  
  public void init(d paramd)
  {
    if (paramd == null) {
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally {}
    }
    if (this.configuration == null)
    {
      com.nostra13.universalimageloader.b.c.a("Initialize ImageLoader with configuration", new Object[0]);
      this.engine = new e(paramd);
      this.configuration = paramd;
    }
    for (;;)
    {
      return;
      com.nostra13.universalimageloader.b.c.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
    }
  }
  
  public boolean isInited()
  {
    return this.configuration != null;
  }
  
  public void loadImage(String paramString, com.nostra13.universalimageloader.core.a.e parame, c paramc, com.nostra13.universalimageloader.core.f.a parama)
  {
    loadImage(paramString, parame, paramc, parama, null);
  }
  
  public void loadImage(String paramString, com.nostra13.universalimageloader.core.a.e parame, c paramc, com.nostra13.universalimageloader.core.f.a parama, com.nostra13.universalimageloader.core.f.b paramb)
  {
    checkConfiguration();
    com.nostra13.universalimageloader.core.a.e locale = parame;
    if (parame == null) {
      locale = this.configuration.a();
    }
    if (paramc == null) {}
    for (parame = this.configuration.r;; parame = paramc)
    {
      displayImage(paramString, new com.nostra13.universalimageloader.core.e.c(paramString, locale, com.nostra13.universalimageloader.core.a.h.b), parame, parama, paramb);
      return;
    }
  }
  
  public void loadImage(String paramString, com.nostra13.universalimageloader.core.a.e parame, com.nostra13.universalimageloader.core.f.a parama)
  {
    loadImage(paramString, parame, null, parama, null);
  }
  
  public void loadImage(String paramString, c paramc, com.nostra13.universalimageloader.core.f.a parama)
  {
    loadImage(paramString, null, paramc, parama, null);
  }
  
  public void loadImage(String paramString, com.nostra13.universalimageloader.core.f.a parama)
  {
    loadImage(paramString, null, null, parama, null);
  }
  
  public Bitmap loadImageSync(String paramString)
  {
    return loadImageSync(paramString, null, null);
  }
  
  public Bitmap loadImageSync(String paramString, com.nostra13.universalimageloader.core.a.e parame)
  {
    return loadImageSync(paramString, parame, null);
  }
  
  public Bitmap loadImageSync(String paramString, com.nostra13.universalimageloader.core.a.e parame, c paramc)
  {
    Object localObject = paramc;
    if (paramc == null) {
      localObject = this.configuration.r;
    }
    paramc = new c.a().a((c)localObject).d(true).a();
    localObject = new a(null);
    loadImage(paramString, parame, paramc, (com.nostra13.universalimageloader.core.f.a)localObject);
    return ((a)localObject).a();
  }
  
  public Bitmap loadImageSync(String paramString, c paramc)
  {
    return loadImageSync(paramString, null, paramc);
  }
  
  public void pause()
  {
    this.engine.a();
  }
  
  public void resume()
  {
    this.engine.b();
  }
  
  public void setDefaultLoadingListener(com.nostra13.universalimageloader.core.f.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = new com.nostra13.universalimageloader.core.f.c();
    }
    this.defaultListener = ((com.nostra13.universalimageloader.core.f.a)localObject);
  }
  
  public void stop()
  {
    this.engine.c();
  }
  
  private static class a
    extends com.nostra13.universalimageloader.core.f.c
  {
    private Bitmap a;
    
    public Bitmap a()
    {
      return this.a;
    }
    
    public void a(String paramString, View paramView, Bitmap paramBitmap)
    {
      this.a = paramBitmap;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */