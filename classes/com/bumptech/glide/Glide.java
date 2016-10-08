package com.bumptech.glide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.d.b.b.i;
import com.bumptech.glide.d.c.b.b.a;
import com.bumptech.glide.d.c.b.f.a;
import com.bumptech.glide.d.c.b.g.a;
import com.bumptech.glide.d.c.b.h.a;
import com.bumptech.glide.d.d.a.q;
import com.bumptech.glide.d.d.a.s;
import com.bumptech.glide.d.d.e.g;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Glide
{
  private static final String TAG = "Glide";
  private static volatile Glide glide;
  private final com.bumptech.glide.d.d.a.e bitmapCenterCrop;
  private final com.bumptech.glide.d.d.a.l bitmapFitCenter;
  private final com.bumptech.glide.d.b.a.c bitmapPool;
  private final com.bumptech.glide.d.b.d.b bitmapPreFiller;
  private final com.bumptech.glide.f.c dataLoadProviderRegistry;
  private final com.bumptech.glide.d.a decodeFormat;
  private final com.bumptech.glide.d.d.e.f drawableCenterCrop;
  private final com.bumptech.glide.d.d.e.f drawableFitCenter;
  private final com.bumptech.glide.d.b.c engine;
  private final com.bumptech.glide.g.b.f imageViewTargetFactory = new com.bumptech.glide.g.b.f();
  private final com.bumptech.glide.d.c.c loaderFactory;
  private final Handler mainHandler;
  private final i memoryCache;
  private final com.bumptech.glide.d.d.f.d transcoderRegistry = new com.bumptech.glide.d.d.f.d();
  
  Glide(com.bumptech.glide.d.b.c paramc, i parami, com.bumptech.glide.d.b.a.c paramc1, Context paramContext, com.bumptech.glide.d.a parama)
  {
    this.engine = paramc;
    this.bitmapPool = paramc1;
    this.memoryCache = parami;
    this.decodeFormat = parama;
    this.loaderFactory = new com.bumptech.glide.d.c.c(paramContext);
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.bitmapPreFiller = new com.bumptech.glide.d.b.d.b(parami, paramc1, parama);
    this.dataLoadProviderRegistry = new com.bumptech.glide.f.c();
    paramc = new s(paramc1, parama);
    this.dataLoadProviderRegistry.a(InputStream.class, Bitmap.class, paramc);
    parami = new com.bumptech.glide.d.d.a.j(paramc1, parama);
    this.dataLoadProviderRegistry.a(ParcelFileDescriptor.class, Bitmap.class, parami);
    paramc = new q(paramc, parami);
    this.dataLoadProviderRegistry.a(com.bumptech.glide.d.c.h.class, Bitmap.class, paramc);
    parami = new com.bumptech.glide.d.d.d.c(paramContext, paramc1);
    this.dataLoadProviderRegistry.a(InputStream.class, com.bumptech.glide.d.d.d.b.class, parami);
    this.dataLoadProviderRegistry.a(com.bumptech.glide.d.c.h.class, com.bumptech.glide.d.d.e.a.class, new g(paramc, parami, paramc1));
    this.dataLoadProviderRegistry.a(InputStream.class, File.class, new com.bumptech.glide.d.d.c.d());
    register(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.d.c.a.a.a());
    register(File.class, InputStream.class, new com.bumptech.glide.d.c.b.c.a());
    register(Integer.TYPE, ParcelFileDescriptor.class, new com.bumptech.glide.d.c.a.c.a());
    register(Integer.TYPE, InputStream.class, new com.bumptech.glide.d.c.b.e.a());
    register(Integer.class, ParcelFileDescriptor.class, new com.bumptech.glide.d.c.a.c.a());
    register(Integer.class, InputStream.class, new com.bumptech.glide.d.c.b.e.a());
    register(String.class, ParcelFileDescriptor.class, new com.bumptech.glide.d.c.a.d.a());
    register(String.class, InputStream.class, new f.a());
    register(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.d.c.a.e.a());
    register(Uri.class, InputStream.class, new g.a());
    register(URL.class, InputStream.class, new h.a());
    register(com.bumptech.glide.d.c.e.class, InputStream.class, new com.bumptech.glide.d.c.b.a.a());
    register(byte[].class, InputStream.class, new b.a());
    this.transcoderRegistry.a(Bitmap.class, com.bumptech.glide.d.d.a.m.class, new com.bumptech.glide.d.d.f.b(paramContext.getResources(), paramc1));
    this.transcoderRegistry.a(com.bumptech.glide.d.d.e.a.class, com.bumptech.glide.d.d.b.b.class, new com.bumptech.glide.d.d.f.a(new com.bumptech.glide.d.d.f.b(paramContext.getResources(), paramc1)));
    this.bitmapCenterCrop = new com.bumptech.glide.d.d.a.e(paramc1);
    this.drawableCenterCrop = new com.bumptech.glide.d.d.e.f(paramc1, this.bitmapCenterCrop);
    this.bitmapFitCenter = new com.bumptech.glide.d.d.a.l(paramc1);
    this.drawableFitCenter = new com.bumptech.glide.d.d.e.f(paramc1, this.bitmapFitCenter);
  }
  
  public static <T> com.bumptech.glide.d.c.l<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(Class<T> paramClass, Context paramContext)
  {
    return buildModelLoader(paramClass, ParcelFileDescriptor.class, paramContext);
  }
  
  public static <T> com.bumptech.glide.d.c.l<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(T paramT, Context paramContext)
  {
    return buildModelLoader(paramT, ParcelFileDescriptor.class, paramContext);
  }
  
  public static <T, Y> com.bumptech.glide.d.c.l<T, Y> buildModelLoader(Class<T> paramClass, Class<Y> paramClass1, Context paramContext)
  {
    if (paramClass == null)
    {
      if (Log.isLoggable("Glide", 3)) {
        Log.d("Glide", "Unable to load null model, setting placeholder only");
      }
      return null;
    }
    return get(paramContext).getLoaderFactory().b(paramClass, paramClass1);
  }
  
  public static <T, Y> com.bumptech.glide.d.c.l<T, Y> buildModelLoader(T paramT, Class<Y> paramClass, Context paramContext)
  {
    if (paramT != null) {}
    for (paramT = paramT.getClass();; paramT = null) {
      return buildModelLoader(paramT, paramClass, paramContext);
    }
  }
  
  public static <T> com.bumptech.glide.d.c.l<T, InputStream> buildStreamModelLoader(Class<T> paramClass, Context paramContext)
  {
    return buildModelLoader(paramClass, InputStream.class, paramContext);
  }
  
  public static <T> com.bumptech.glide.d.c.l<T, InputStream> buildStreamModelLoader(T paramT, Context paramContext)
  {
    return buildModelLoader(paramT, InputStream.class, paramContext);
  }
  
  public static void clear(View paramView)
  {
    clear(new a(paramView));
  }
  
  public static void clear(com.bumptech.glide.g.a<?> parama)
  {
    parama.a();
  }
  
  public static void clear(com.bumptech.glide.g.b.j<?> paramj)
  {
    com.bumptech.glide.i.h.a();
    com.bumptech.glide.g.c localc = paramj.b();
    if (localc != null)
    {
      localc.d();
      paramj.a(null);
    }
  }
  
  public static Glide get(Context paramContext)
  {
    if (glide == null)
    {
      try
      {
        if (glide != null) {
          break label126;
        }
        paramContext = paramContext.getApplicationContext();
        localObject = new com.bumptech.glide.e.b(paramContext).a();
        c localc = new c(paramContext);
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext()) {
          ((com.bumptech.glide.e.a)localIterator.next()).a(paramContext, localc);
        }
        glide = localc.a();
      }
      finally {}
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.bumptech.glide.e.a)((Iterator)localObject).next()).a(paramContext, glide);
      }
    }
    label126:
    return glide;
  }
  
  private com.bumptech.glide.d.c.c getLoaderFactory()
  {
    return this.loaderFactory;
  }
  
  public static File getPhotoCacheDir(Context paramContext)
  {
    return getPhotoCacheDir(paramContext, "image_manager_disk_cache");
  }
  
  public static File getPhotoCacheDir(Context paramContext, String paramString)
  {
    paramContext = paramContext.getCacheDir();
    if (paramContext != null)
    {
      paramContext = new File(paramContext, paramString);
      if ((paramContext.mkdirs()) || ((paramContext.exists()) && (paramContext.isDirectory()))) {}
    }
    while (!Log.isLoggable("Glide", 6))
    {
      return null;
      return paramContext;
    }
    Log.e("Glide", "default disk cache dir is null");
    return null;
  }
  
  @Deprecated
  public static boolean isSetup()
  {
    return glide != null;
  }
  
  @Deprecated
  public static void setup(c paramc)
  {
    if (isSetup()) {
      throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
    }
    glide = paramc.a();
  }
  
  static void tearDown()
  {
    glide = null;
  }
  
  public static f with(Activity paramActivity)
  {
    return com.bumptech.glide.manager.k.a().a(paramActivity);
  }
  
  @TargetApi(11)
  public static f with(android.app.Fragment paramFragment)
  {
    return com.bumptech.glide.manager.k.a().a(paramFragment);
  }
  
  public static f with(Context paramContext)
  {
    return com.bumptech.glide.manager.k.a().a(paramContext);
  }
  
  public static f with(android.support.v4.app.Fragment paramFragment)
  {
    return com.bumptech.glide.manager.k.a().a(paramFragment);
  }
  
  public static f with(FragmentActivity paramFragmentActivity)
  {
    return com.bumptech.glide.manager.k.a().a(paramFragmentActivity);
  }
  
  <T, Z> com.bumptech.glide.f.b<T, Z> buildDataProvider(Class<T> paramClass, Class<Z> paramClass1)
  {
    return this.dataLoadProviderRegistry.a(paramClass, paramClass1);
  }
  
  <R> com.bumptech.glide.g.b.j<R> buildImageViewTarget(ImageView paramImageView, Class<R> paramClass)
  {
    return this.imageViewTargetFactory.a(paramImageView, paramClass);
  }
  
  <Z, R> com.bumptech.glide.d.d.f.c<Z, R> buildTranscoder(Class<Z> paramClass, Class<R> paramClass1)
  {
    return this.transcoderRegistry.a(paramClass, paramClass1);
  }
  
  public void clearDiskCache()
  {
    com.bumptech.glide.i.h.b();
    getEngine().a();
  }
  
  public void clearMemory()
  {
    this.bitmapPool.b();
    this.memoryCache.c();
  }
  
  com.bumptech.glide.d.d.a.e getBitmapCenterCrop()
  {
    return this.bitmapCenterCrop;
  }
  
  com.bumptech.glide.d.d.a.l getBitmapFitCenter()
  {
    return this.bitmapFitCenter;
  }
  
  public com.bumptech.glide.d.b.a.c getBitmapPool()
  {
    return this.bitmapPool;
  }
  
  com.bumptech.glide.d.a getDecodeFormat()
  {
    return this.decodeFormat;
  }
  
  com.bumptech.glide.d.d.e.f getDrawableCenterCrop()
  {
    return this.drawableCenterCrop;
  }
  
  com.bumptech.glide.d.d.e.f getDrawableFitCenter()
  {
    return this.drawableFitCenter;
  }
  
  com.bumptech.glide.d.b.c getEngine()
  {
    return this.engine;
  }
  
  Handler getMainHandler()
  {
    return this.mainHandler;
  }
  
  public void preFillBitmapPool(com.bumptech.glide.d.b.d.d.a... paramVarArgs)
  {
    this.bitmapPreFiller.a(paramVarArgs);
  }
  
  public <T, Y> void register(Class<T> paramClass, Class<Y> paramClass1, com.bumptech.glide.d.c.m<T, Y> paramm)
  {
    paramClass = this.loaderFactory.a(paramClass, paramClass1, paramm);
    if (paramClass != null) {
      paramClass.a();
    }
  }
  
  public void setMemoryCategory(d paramd)
  {
    this.memoryCache.a(paramd.a());
    this.bitmapPool.a(paramd.a());
  }
  
  public void trimMemory(int paramInt)
  {
    this.bitmapPool.a(paramInt);
    this.memoryCache.a(paramInt);
  }
  
  @Deprecated
  public <T, Y> void unregister(Class<T> paramClass, Class<Y> paramClass1)
  {
    paramClass = this.loaderFactory.a(paramClass, paramClass1);
    if (paramClass != null) {
      paramClass.a();
    }
  }
  
  private static class a
    extends com.bumptech.glide.g.b.k<View, Object>
  {
    public a(View paramView)
    {
      super();
    }
    
    public void a(Drawable paramDrawable) {}
    
    public void a(Exception paramException, Drawable paramDrawable) {}
    
    public void a(Object paramObject, com.bumptech.glide.g.a.a<? super Object> parama) {}
    
    public void b(Drawable paramDrawable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\Glide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */