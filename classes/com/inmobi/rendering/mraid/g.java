package com.inmobi.rendering.mraid;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class g
  extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final String k = g.class.getSimpleName();
  int a;
  boolean b;
  d c;
  b d;
  f e;
  String f;
  String g;
  boolean h;
  int i;
  int j;
  private MediaPlayer l;
  private a m;
  private RenderView n;
  private Bitmap o;
  private ViewGroup p;
  private c q;
  private b r;
  private e s;
  private String t;
  private boolean u;
  private boolean v;
  
  public g(Context paramContext, RenderView paramRenderView)
  {
    super(paramContext);
    this.n = paramRenderView;
    setZOrderOnTop(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    setDrawingCacheEnabled(true);
    this.a = 100;
    this.i = -1;
    this.j = 0;
    this.c = d.a;
    this.u = false;
    this.b = false;
    this.v = false;
  }
  
  private String a(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  private String b(String paramString)
  {
    paramString = paramString.getBytes();
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = paramString.length;
    int i2 = 0;
    if (i2 < i3)
    {
      int i1 = paramString[i2];
      if ((i1 & 0x80) > 0) {
        localStringBuilder.append("%").append(a(i1));
      }
      for (;;)
      {
        i2 += 1;
        break;
        localStringBuilder.append((char)i1);
      }
    }
    try
    {
      paramString = new String(localStringBuilder.toString().getBytes(), "ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private Bitmap c(String paramString)
  {
    try
    {
      paramString = (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[] { String.class, Integer.TYPE }).invoke(null, new Object[] { paramString, Integer.valueOf(1) });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void j()
  {
    if (this.p != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.p.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.p);
      }
      localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this);
      }
      setBackgroundColor(0);
      this.p = null;
    }
  }
  
  private boolean k()
  {
    return (d.c == this.c) || (d.d == this.c);
  }
  
  public void a()
  {
    setVideoPath(this.g);
    setOnCompletionListener(this);
    setOnPreparedListener(this);
    setOnErrorListener(this);
    if ((this.m == null) && (this.e.e) && (Build.VERSION.SDK_INT >= 19))
    {
      this.m = new a(getContext());
      this.m.setAnchorView(this);
      setMediaController(this.m);
    }
    if (this.s == null)
    {
      this.s = new e();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      a.b().registerReceiver(this.s, localIntentFilter);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < getDuration())
    {
      this.j = paramInt;
      seekTo(paramInt);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.n != null)
    {
      String str = "fireMediaTimeUpdateEvent('" + this.e.a + "'," + paramInt1 + "," + paramInt2 + ");";
      this.n.a(this.t, str);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.p = paramViewGroup;
  }
  
  public void a(c paramc)
  {
    this.q = paramc;
  }
  
  void a(String paramString)
  {
    if (this.n != null)
    {
      paramString = "fireMediaTrackingEvent('" + paramString + "','" + this.e.a + "');";
      this.n.a(this.t, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, f paramf, b paramb)
  {
    this.t = paramString1;
    this.r = new b(this);
    this.g = b(paramString2.trim());
    this.e = paramf;
    this.f = paramf.a;
    this.d = paramb;
    if (this.o == null)
    {
      this.o = Bitmap.createBitmap(24, 24, Bitmap.Config.ARGB_8888);
      this.o = c(this.g);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Media render view state: " + this.c);
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Release the media render view");
    if (this.s != null)
    {
      a.b().unregisterReceiver(this.s);
      this.s = null;
    }
    this.c = d.g;
    if (this.i != -1) {}
    for (int i1 = this.i;; i1 = Math.round(getCurrentPosition() / 1000))
    {
      a(paramBoolean, i1);
      stopPlayback();
      this.r.removeMessages(1);
      j();
      super.setMediaController(null);
      this.m = null;
      if (this.q != null) {
        this.q.a(this);
      }
      return;
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (this.n != null)
    {
      String str = "fireMediaCloseEvent('" + this.e.a + "'," + paramBoolean + "," + paramInt + ");";
      this.n.a(this.t, str);
    }
  }
  
  public void b()
  {
    if (d.e != this.c)
    {
      this.p.setVisibility(0);
      setVisibility(0);
      requestFocus();
      this.c = d.e;
      a("showing");
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = false;
    if ((this.l != null) && ((this.b) || (paramInt != this.a)))
    {
      if ((this.b) && (paramInt == 0)) {
        this.a = 0;
      }
    }
    else {
      return;
    }
    if (paramInt == 0) {
      bool = true;
    }
    this.b = bool;
    this.a = paramInt;
    float f1 = 1.0F - (float)(Math.log(101 - paramInt) / Math.log(101.0D));
    this.l.setVolume(f1, f1);
    h();
  }
  
  public void c()
  {
    if (d.d != this.c)
    {
      setVisibility(4);
      this.p.setVisibility(4);
      this.c = d.d;
      a("hidden");
    }
  }
  
  void c(int paramInt)
  {
    if (this.n != null)
    {
      String str = "fireMediaErrorEvent('" + this.e.a + "'," + paramInt + ");";
      this.n.a(this.t, str);
    }
  }
  
  public void d()
  {
    if ((this.l != null) && (!this.b))
    {
      this.b = true;
      this.l.setVolume(0.0F, 0.0F);
      h();
    }
  }
  
  public void e()
  {
    if ((this.l != null) && (this.b)) {
      b(this.a);
    }
  }
  
  public ViewGroup f()
  {
    return this.p;
  }
  
  void g()
  {
    d locald;
    if (d.e == this.c) {
      if (this.u) {
        locald = d.f;
      }
    }
    for (;;)
    {
      this.c = locald;
      if (this.h)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          break label63;
        }
        super.start();
      }
      try
      {
        Thread.sleep(1000L);
        super.pause();
        label63:
        do
        {
          do
          {
            return;
            locald = d.c;
            break;
            super.start();
            super.pause();
            return;
          } while (d.a != this.c);
          if (this.e.g) {
            d();
          }
          if (this.e.d)
          {
            start();
            return;
          }
        } while (!this.h);
        if (Build.VERSION.SDK_INT < 21) {
          super.start();
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        try
        {
          Thread.sleep(1000L);
          super.pause();
          return;
          super.start();
          super.pause();
          return;
          localInterruptedException1 = localInterruptedException1;
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;) {}
        }
      }
    }
  }
  
  void h()
  {
    if (this.b) {}
    for (int i1 = 0;; i1 = this.a)
    {
      if (this.n != null)
      {
        String str = "fireMediaVolumeChangeEvent('" + this.e.a + "'," + i1 + "," + this.b + ");";
        this.n.a(this.t, str);
      }
      return;
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, ">>> onCompletion");
    this.c = d.f;
    this.u = true;
    a("ended");
    this.r.removeMessages(1);
    if (this.e.f) {
      try
      {
        if (!k())
        {
          this.j = 0;
          start();
        }
        return;
      }
      finally {}
    }
    if (this.e.b()) {
      a(false);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, ">>> onError (" + paramInt1 + ", " + paramInt2 + ")");
    a(false);
    paramInt2 = -1;
    if (100 == paramInt1) {
      paramInt2 = 2;
    }
    c(paramInt2);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getHolder().setSizeFromLayout();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, ">>> onPrepared");
    paramMediaPlayer.setOnVideoSizeChangedListener(new g.1(this));
    this.l = paramMediaPlayer;
    a(this.j * 1000);
    this.h = true;
    this.q.b(this);
    g();
  }
  
  @TargetApi(16)
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, ">>> onVisibilityChanged (" + paramInt + ")");
    if (paramInt == 0)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        setBackground(new BitmapDrawable(a.b().getResources(), this.o));
      }
    }
    else {
      return;
    }
    setBackgroundDrawable(new BitmapDrawable(this.o));
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, ">>> onWindowVisibilityChanged (" + paramInt + ")");
  }
  
  public void pause()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Media render view state: " + this.c);
    if (d.c == this.c) {
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Pause media playback");
    this.r.removeMessages(1);
    super.pause();
    this.c = d.c;
    a("pause");
  }
  
  public void start()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Media render view state: " + this.c);
    if (d.b == this.c) {
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, k, "Start media playback");
    a(this.j * 1000);
    this.c = d.b;
    super.start();
    if (this.h) {
      a("play");
    }
    this.r.sendEmptyMessage(1);
  }
  
  static class a
    extends MediaController
  {
    Context a;
    
    public a(Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public void show(int paramInt)
    {
      super.show(paramInt);
      if (Build.VERSION.SDK_INT < 19) {}
      try
      {
        Object localObject1 = MediaController.class.getDeclaredField("mAnchor");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (View)((Field)localObject1).get(this);
        Object localObject2 = MediaController.class.getDeclaredField("mDecor");
        ((Field)localObject2).setAccessible(true);
        localObject2 = (View)((Field)localObject2).get(this);
        Object localObject3 = MediaController.class.getDeclaredField("mDecorLayoutParams");
        ((Field)localObject3).setAccessible(true);
        localObject3 = (WindowManager.LayoutParams)((Field)localObject3).get(this);
        Object localObject4 = MediaController.class.getDeclaredField("mWindowManager");
        ((Field)localObject4).setAccessible(true);
        localObject4 = (WindowManager)((Field)localObject4).get(this);
        int[] arrayOfInt = new int[2];
        ((View)localObject1).getLocationOnScreen(arrayOfInt);
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject1).getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(((View)localObject1).getHeight(), Integer.MIN_VALUE));
        ((View)localObject2).setPadding(0, 0, 0, 0);
        ((WindowManager.LayoutParams)localObject3).verticalMargin = 0.0F;
        ((WindowManager.LayoutParams)localObject3).horizontalMargin = 0.0F;
        ((WindowManager.LayoutParams)localObject3).width = ((View)localObject1).getWidth();
        ((WindowManager.LayoutParams)localObject3).gravity = 8388659;
        ((WindowManager.LayoutParams)localObject3).x = arrayOfInt[0];
        paramInt = arrayOfInt[1];
        ((WindowManager.LayoutParams)localObject3).y = (((View)localObject1).getHeight() + paramInt - ((View)localObject2).getMeasuredHeight());
        ((WindowManager)localObject4).updateViewLayout((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  static final class b
    extends Handler
  {
    private final WeakReference<g> a;
    
    public b(g paramg)
    {
      this.a = new WeakReference(paramg);
    }
    
    public void handleMessage(Message paramMessage)
    {
      g localg = (g)this.a.get();
      if (localg != null) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        do
        {
          return;
        } while (g.d.b != localg.c);
        int i = Math.round(localg.getCurrentPosition() / 1000.0F);
        int j = Math.round(localg.getDuration() / 1000.0F);
        if (localg.i != i)
        {
          localg.a(i, j);
          localg.i = i;
          localg.j = i;
        }
        sendEmptyMessageDelayed(1, 1000L);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void a(g paramg);
    
    public abstract void b(g paramg);
  }
  
  static enum d
  {
    private d() {}
  }
  
  final class e
    extends BroadcastReceiver
  {
    private final String b = e.class.getSimpleName();
    
    e() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null)
      {
        if (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
          break label58;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, this.b, "Screen OFF");
        if (g.d.b == g.this.c)
        {
          g.a(g.this, true);
          g.this.pause();
        }
      }
      label58:
      do
      {
        do
        {
          return;
        } while (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction()));
        Logger.a(Logger.InternalLogLevel.INTERNAL, this.b, "Screen ON");
      } while ((!g.a(g.this)) || (g.d.c != g.this.c));
      g.a(g.this, false);
      g.this.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */