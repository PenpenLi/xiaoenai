package com.inmobi.rendering.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"ClickableViewAccessibility"})
public final class MraidMediaProcessor
{
  private static final String a = MraidMediaProcessor.class.getSimpleName();
  private RenderView b;
  private g c;
  private RingerModeChangeReceiver d;
  private a e;
  private HeadphonesPluggedChangeReceiver f;
  private f g;
  private b h;
  private boolean i;
  private Hashtable<String, g> j = new Hashtable();
  
  public MraidMediaProcessor(RenderView paramRenderView)
  {
    this.b = paramRenderView;
    this.g = new f();
    this.h = new b();
    this.i = false;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.b != null) {
      this.b.a(paramString, "fireDeviceVolumeChangeEvent(" + paramInt + ");");
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramString, "fireDeviceMuteChangeEvent(" + paramBoolean + ");");
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, MediaContentType paramMediaContentType, Activity paramActivity)
  {
    if (((paramString2.length() != 0) && (!URLUtil.isValidUrl(paramString2))) || ((paramString2.length() == 0) && (!this.j.containsKey(paramString3))))
    {
      paramActivity = this.b;
      paramString3 = "Invalid ID (" + paramString3 + "); no playback URL for this ID";
      if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == paramMediaContentType) {}
      for (paramString2 = "playVideo";; paramString2 = "playAudio")
      {
        paramActivity.a(paramString1, paramString3, paramString2);
        return false;
      }
    }
    if (this.j.size() == 5)
    {
      paramString3 = this.b;
      if (MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == paramMediaContentType) {}
      for (paramString2 = "playVideo";; paramString2 = "playAudio")
      {
        paramString3.a(paramString1, "Cannot create media player - limit on number of media players reached", paramString2);
        return false;
      }
    }
    paramMediaContentType = (g)this.j.remove(paramString3);
    if (paramMediaContentType == null)
    {
      if ((this.c != null) && (this.g.a()))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Only a single instance of full-screen media playback is allowed. Releasing the current active player ...");
        this.j.remove(this.c.f);
        this.c.a(false);
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Creating a new media player instance!");
    }
    for (this.c = new g(paramActivity, this.b);; this.c = paramMediaContentType)
    {
      if ((paramString2.length() == 0) && (paramMediaContentType != null))
      {
        this.c.a(paramString1, paramMediaContentType.g, paramMediaContentType.e, paramMediaContentType.d);
        this.c.d = paramMediaContentType.d;
      }
      return true;
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Reusing media player (" + paramString3 + ") from the pool");
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramString, "fireHeadphonePluggedEvent(" + paramBoolean + ");");
    }
  }
  
  private boolean b(String paramString1, String paramString2, MediaContentType paramMediaContentType, Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.c == null) || (!this.c.f.equalsIgnoreCase(this.g.a))) {
      bool1 = a(paramString1, paramString2, this.g.a, paramMediaContentType, paramActivity);
    }
    do
    {
      do
      {
        return bool1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Reusing media player (" + this.c.f + ") from the pool");
        bool1 = bool2;
      } while (!this.c.f.equalsIgnoreCase(this.g.a));
      if ((paramString2.length() != 0) && (!this.c.g.equalsIgnoreCase(paramString2))) {
        break;
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Player state: " + this.c.c);
      switch (MraidMediaProcessor.4.a[this.c.c.ordinal()])
      {
      default: 
        return false;
      case 1: 
        this.c.start();
        j();
        return false;
      case 2: 
        if (this.c.h) {
          this.c.start();
        }
        for (;;)
        {
          j();
          return false;
          this.g.d = true;
          this.c.e = this.g;
        }
      case 3: 
        bool1 = bool2;
      }
    } while (!this.g.f);
    this.c.start();
    j();
    return false;
    j();
    return false;
    this.c.a(paramString1, paramString2, this.g, this.h);
    this.c.g();
    return false;
  }
  
  private g d(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Checking for media player with ID: " + paramString);
    if ((this.c != null) && ((paramString == null) || (paramString.length() == 0)))
    {
      if ("anonymous".equalsIgnoreCase(this.g.a))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Returning media render view with ID: " + this.g.a + " (state: " + this.c.c + ")");
        return this.c;
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot find ID to look up the media render view");
      return null;
    }
    g localg = (g)this.j.get(paramString);
    if (localg != null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Returning media render view with ID: " + paramString + " (state: " + localg.c + ")");
      return localg;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "No media render view found!");
    return localg;
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout;
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (!this.g.a())
    {
      localRelativeLayout = (RelativeLayout)this.c.f();
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        localRelativeLayout.setBackgroundColor(0);
        localLayoutParams1 = new FrameLayout.LayoutParams(this.h.c, this.h.d);
        localLayoutParams2 = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
        if ((-99999 != this.h.a) && (-99999 != this.h.b)) {
          break label113;
        }
        localLayoutParams1.leftMargin = localLayoutParams2.leftMargin;
      }
    }
    for (localLayoutParams1.topMargin = localLayoutParams2.topMargin;; localLayoutParams1.topMargin = this.h.b)
    {
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      return;
      label113:
      localLayoutParams1.leftMargin = this.h.a;
    }
  }
  
  public void a(b paramb)
  {
    this.h = paramb;
  }
  
  public void a(f paramf)
  {
    this.g = paramf;
    this.i = true;
  }
  
  public void a(String paramString)
  {
    if (this.d == null)
    {
      this.d = new RingerModeChangeReceiver(paramString);
      a.b().registerReceiver(this.d, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "pauseMedia");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((paramString2.c != g.d.b) && ((g.d.a == paramString2.c) || (g.d.d == paramString2.c)))
    {
      if (!paramString2.h)
      {
        this.g.d = false;
        paramString2.e = this.g;
        return;
      }
      this.b.a(paramString1, "Invalid player state", "pauseMedia");
      return;
    }
    paramString2.pause();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "seekMedia");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.a == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "seekMedia");
      return;
    }
    paramString2.a(paramInt * 1000);
  }
  
  public void a(String paramString1, String paramString2, MediaContentType paramMediaContentType, Activity paramActivity)
  {
    if (!b(paramString1, paramString2, paramMediaContentType, paramActivity)) {
      return;
    }
    f localf = this.g;
    b localb = this.h;
    this.b.setAdActiveFlag(true);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + this.c.c);
    if (paramString2.length() != 0) {
      this.c.a(paramString1, paramString2, localf, localb);
    }
    while ((MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO == paramMediaContentType) && (paramString2.startsWith("http")) && (!paramString2.endsWith("mp4")) && (!paramString2.endsWith("avi")) && (!paramString2.endsWith("m4v")))
    {
      this.c.c(3);
      return;
      this.c.a(paramString1, this.c.g, localf, localb);
    }
    if ((MediaContentType.MEDIA_CONTENT_TYPE_AUDIO == paramMediaContentType) && (paramString2.startsWith("http")) && (!paramString2.endsWith("mp3")))
    {
      this.c.c(3);
      return;
    }
    this.j.put(this.g.a, this.c);
    if (g.d.d == this.c.c)
    {
      this.c.b();
      return;
    }
    if (localf.a())
    {
      paramString1 = (ViewGroup)paramActivity.findViewById(16908290);
      paramString2 = new RelativeLayout.LayoutParams(-1, -1);
      paramString2.addRule(13);
      this.c.setLayoutParams(paramString2);
      paramString2 = new RelativeLayout(paramActivity);
      paramString2.setOnTouchListener(new MraidMediaProcessor.1(this));
      paramString2.setBackgroundColor(-16777216);
      paramString2.addView(this.c);
      paramString1.addView(paramString2, new ViewGroup.LayoutParams(-1, -1));
      this.c.a(paramString2);
      this.c.requestFocus();
      this.c.setOnKeyListener(new MraidMediaProcessor.2(this));
    }
    for (;;)
    {
      this.c.a(new MraidMediaProcessor.3(this));
      this.c.a();
      return;
      paramString1 = (ViewGroup)paramActivity.findViewById(16908290);
      paramString2 = new RelativeLayout(paramActivity);
      paramMediaContentType = new FrameLayout.LayoutParams(localb.c, localb.d);
      paramMediaContentType.leftMargin = localb.a;
      paramMediaContentType.topMargin = localb.b;
      paramMediaContentType.width = localb.c;
      paramMediaContentType.height = localb.d;
      paramActivity = new RelativeLayout.LayoutParams(-1, -1);
      paramActivity.addRule(10);
      paramActivity.addRule(12);
      paramActivity.addRule(9);
      paramActivity.addRule(11);
      this.c.setLayoutParams(paramActivity);
      this.c.a(paramString2);
      paramString2.addView(this.c);
      paramString1.addView(paramString2, paramMediaContentType);
      this.c.clearFocus();
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "closeMedia");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "closeMedia");
      return;
    }
    paramString2.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public void b()
  {
    if (this.c != null) {
      this.j.put(this.c.f, this.c);
    }
    Iterator localIterator = this.j.keySet().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)this.j.get(localIterator.next());
      localIterator.remove();
      localg.a(true);
    }
    this.j.clear();
    this.c = null;
  }
  
  public void b(String paramString)
  {
    if (this.e == null)
    {
      Context localContext = a.b();
      this.e = new a(paramString, localContext, new Handler());
      localContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.e);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "muteMedia");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.a == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "muteMedia");
      return;
    }
    paramString2.d();
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "setMediaVolume");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "setMediaVolume");
      return;
    }
    paramString2.b(paramInt);
  }
  
  public void c()
  {
    if ((this.c != null) && (g.d.g != this.c.c))
    {
      this.j.put(this.c.f, this.c);
      this.c.c();
    }
  }
  
  public void c(String paramString)
  {
    if (this.f == null)
    {
      this.f = new HeadphonesPluggedChangeReceiver(paramString);
      a.b().registerReceiver(this.f, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "unMuteMedia");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.a == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "unMuteMedia");
      return;
    }
    paramString2.e();
  }
  
  public boolean d()
  {
    return 2 != ((AudioManager)a.b().getSystemService("audio")).getRingerMode();
  }
  
  public boolean d(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "isMediaMuted");
      return false;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
    if ((g.d.g == paramString2.c) || (g.d.a == paramString2.c) || (g.d.d == paramString2.c))
    {
      this.b.a(paramString1, "Invalid player state", "isMediaMuted");
      return false;
    }
    return paramString2.b;
  }
  
  public int e(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null) {
      this.b.a(paramString1, "Invalid property ID", "getMediaVolume");
    }
    do
    {
      return 0;
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player state: " + paramString2.c);
      if (g.d.g == paramString2.c)
      {
        this.b.a(paramString1, "Invalid player state", "getMediaVolume");
        return 0;
      }
    } while (paramString2.b);
    return paramString2.a;
  }
  
  public void e()
  {
    if (this.d != null)
    {
      a.b().unregisterReceiver(this.d);
      this.d = null;
    }
  }
  
  public void f()
  {
    if (this.e != null)
    {
      a.b().getContentResolver().unregisterContentObserver(this.e);
      this.e = null;
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    paramString2 = d(paramString2);
    if (paramString2 == null)
    {
      this.b.a(paramString1, "Invalid property ID", "hideMedia");
      return;
    }
    if (g.d.g == paramString2.c)
    {
      this.b.a(paramString1, "Invalid player state", "hideMedia");
      return;
    }
    if (g.d.d == paramString2.c)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player is already hidden");
      return;
    }
    paramString2.c();
  }
  
  public void g(String paramString1, String paramString2)
  {
    g localg = d(paramString2);
    if (localg == null)
    {
      this.b.a(paramString1, "Invalid property ID", "showMedia");
      return;
    }
    if (g.d.g == localg.c)
    {
      this.b.a(paramString1, "Invalid player state", "showMedia");
      return;
    }
    if (!this.g.a.equalsIgnoreCase(paramString2))
    {
      this.b.a(paramString1, "Show failed. There is already a video playing", "showMedia");
      return;
    }
    if (g.d.e == localg.c)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Media player is already showing");
      return;
    }
    this.j.remove(paramString2);
    this.c = localg;
    localg.b();
  }
  
  public boolean g()
  {
    return ((AudioManager)a.b().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void h()
  {
    if (this.f != null)
    {
      a.b().unregisterReceiver(this.f);
      this.f = null;
    }
  }
  
  public final class HeadphonesPluggedChangeReceiver
    extends BroadcastReceiver
  {
    private String b;
    
    public HeadphonesPluggedChangeReceiver(String paramString)
    {
      this.b = paramString;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = true;
      if ((paramIntent != null) && ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction())))
      {
        int i = paramIntent.getIntExtra("state", 0);
        Logger.a(Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.i(), "Headphone plugged state changed: " + i);
        paramContext = MraidMediaProcessor.this;
        paramIntent = this.b;
        if (1 != i) {
          break label78;
        }
      }
      for (;;)
      {
        MraidMediaProcessor.b(paramContext, paramIntent, bool);
        return;
        label78:
        bool = false;
      }
    }
  }
  
  public static enum MediaContentType
  {
    MEDIA_CONTENT_TYPE_AUDIO,  MEDIA_CONTENT_TYPE_AUDIO_VIDEO;
    
    private MediaContentType() {}
  }
  
  public final class RingerModeChangeReceiver
    extends BroadcastReceiver
  {
    private String b;
    
    public RingerModeChangeReceiver(String paramString)
    {
      this.b = paramString;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && ("android.media.RINGER_MODE_CHANGED".equals(paramIntent.getAction())))
      {
        int i = paramIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
        Logger.a(Logger.InternalLogLevel.INTERNAL, MraidMediaProcessor.i(), "Ringer mode action changed: " + i);
        paramContext = MraidMediaProcessor.this;
        paramIntent = this.b;
        if (2 == i) {
          break label78;
        }
      }
      label78:
      for (boolean bool = true;; bool = false)
      {
        MraidMediaProcessor.a(paramContext, paramIntent, bool);
        return;
      }
    }
  }
  
  public final class a
    extends ContentObserver
  {
    private Context b;
    private int c;
    private String d;
    
    public a(String paramString, Context paramContext, Handler paramHandler)
    {
      super();
      this.d = paramString;
      this.b = paramContext;
      this.c = -1;
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      if (this.b != null)
      {
        int i = ((AudioManager)this.b.getSystemService("audio")).getStreamVolume(3);
        if (i != this.c)
        {
          this.c = i;
          MraidMediaProcessor.a(MraidMediaProcessor.this, this.d, i);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\MraidMediaProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */