package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.inmobi.commons.a.b;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.inmobi.rendering.mraid.d;
import com.inmobi.rendering.mraid.l;
import com.inmobi.rendering.mraid.m;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  static final String[] a = { "tel", "sms", "calendar", "storePicture", "inlineVideo" };
  private static final String b = a.class.getSimpleName();
  private RenderView c;
  private RenderingProperties d;
  private l e;
  private Context f;
  private DownloadManager g;
  private BroadcastReceiver h;
  
  public a(RenderView paramRenderView, RenderingProperties paramRenderingProperties)
  {
    this.f = paramRenderView.getRenderViewContext();
    this.c = paramRenderView;
    this.d = paramRenderingProperties;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.g == null) {
      this.g = ((DownloadManager)com.inmobi.commons.a.a.b().getSystemService("download"));
    }
    try
    {
      paramString2 = Uri.parse(paramString2);
      DownloadManager.Request localRequest = new DownloadManager.Request(paramString2);
      localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, paramString2.getLastPathSegment());
      registerBroadcastListener(paramString1);
      long l = this.g.enqueue(localRequest);
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Download enqueued with ID: " + l);
      return;
    }
    catch (ParseException paramString2)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Invalid URL provided to storePicture " + paramString2.getMessage());
      this.c.a(paramString1, "Invalid URL", "storePicture");
    }
  }
  
  private void b(String paramString)
  {
    int i = InMobiAdActivity.a(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new a.6(this, paramString));
    paramString = new Intent(this.f, InMobiAdActivity.class);
    paramString.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
    paramString.putExtra("id", i);
    com.inmobi.commons.a.a.a(this.f, paramString);
    this.c.getListener().g(this.c);
  }
  
  private static int c(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -99999;
  }
  
  @JavascriptInterface
  public void asyncPing(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "asyncPing called: " + paramString2);
    if (!URLUtil.isValidUrl(paramString2))
    {
      this.c.a(paramString1, "Invalid url", "asyncPing");
      return;
    }
    paramString1 = new NetworkRequest(NetworkRequest.RequestType.GET, paramString2, false, null);
    paramString1.a(false);
    new com.inmobi.commons.core.network.a(paramString1, new a.7(this)).a();
  }
  
  @JavascriptInterface
  public void cancelSaveContent(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "cancelSaveContent called. mediaId:" + paramString2);
    this.c.e(paramString2);
  }
  
  @JavascriptInterface
  public void close(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "close called");
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.33(this));
  }
  
  @JavascriptInterface
  public void closeVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: closeVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.11(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  @TargetApi(23)
  public void createCalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if (!this.c.f("calendar"))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "createCalendarEvent called even when it is not supported");
      return;
    }
    if ((paramString3 == null) || (paramString3.trim().length() == 0) || (paramString4 == null) || (paramString4.trim().length() == 0))
    {
      this.c.a(paramString1, "Mandatory parameter(s) start and/or end date not supplied", "createCalendarEvent");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "createCalendarEvent called with parameters: \nevent ID: " + paramString2 + "; startDate: " + paramString3 + "; endDate: " + paramString4 + "; location: " + paramString5 + "; description: " + paramString6 + "; summary: " + paramString7 + "; status: " + paramString8 + "; transparency: " + paramString9 + "; recurrence: " + paramString10 + "; reminder: " + paramString11);
    if ((Build.VERSION.SDK_INT >= 23) && ((com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.WRITE_CALENDAR") != 0) || (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.READ_CALENDAR") != 0)))
    {
      paramString1 = new a.4(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
      InMobiAdActivity.a(new String[] { "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR" }, paramString1);
      return;
    }
    this.c.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
  }
  
  @JavascriptInterface
  public void disableBackButton(String paramString, boolean paramBoolean)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.setDisableBackButton(paramBoolean);
  }
  
  @JavascriptInterface
  public void disableCloseRegion(String paramString, boolean paramBoolean)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.25(this, paramBoolean));
  }
  
  @JavascriptInterface
  public void expand(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "expand called. Url:" + paramString2);
    if (this.d.a() != RenderingProperties.PlacementType.FULL_SCREEN)
    {
      if (this.c == null) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      }
    }
    else {
      return;
    }
    if (this.c.a())
    {
      if ((paramString2 != null) && (paramString2.length() != 0) && (!paramString2.startsWith("http")))
      {
        this.c.a(paramString1, "Invalid URL", "expand");
        return;
      }
      new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.29(this, paramString1, paramString2));
      return;
    }
    this.c.a(paramString1, "Creative is not visible. Ignoring request.", "expand");
  }
  
  @JavascriptInterface
  public void fireAdFailed(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "fireAdFailed called.");
    this.c.getListener().b(this.c);
  }
  
  @JavascriptInterface
  public void fireAdReady(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "fireAdReady called.");
    this.c.getListener().a(this.c);
  }
  
  @JavascriptInterface
  public int getAudioVolume(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: getAudioVolume (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return 0;
    }
    return this.c.e(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public String getCurrentPosition(String arg1)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return "";
    }
    synchronized (this.c.getCurrentPositionMonitor())
    {
      this.c.setCurrentPositionLock();
      new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.28(this));
      for (;;)
      {
        boolean bool = this.c.c();
        if (bool) {
          try
          {
            this.c.getCurrentPositionMonitor().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return this.c.getCurrentPosition();
  }
  
  @JavascriptInterface
  public String getDefaultPosition(String arg1)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return new JSONObject().toString();
    }
    synchronized (this.c.getDefaultPositionMonitor())
    {
      this.c.setDefaultPositionLock();
      new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.23(this));
      for (;;)
      {
        boolean bool = this.c.b();
        if (bool) {
          try
          {
            this.c.getDefaultPositionMonitor().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return this.c.getDefaultPosition();
  }
  
  @JavascriptInterface
  public String getExpandProperties(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return "";
    }
    return this.c.getExpandProperties().c();
  }
  
  @JavascriptInterface
  @TargetApi(23)
  public void getGalleryImage(String paramString)
  {
    if (!this.c.f("getGalleryImage"))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getGalleryImage called even when it is not supported");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getGalleryImage called ");
    if ((Build.VERSION.SDK_INT >= 23) && (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0))
    {
      paramString = new a.5(this, paramString);
      InMobiAdActivity.a(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, paramString);
      return;
    }
    b(paramString);
  }
  
  /* Error */
  @JavascriptInterface
  public String getMaxSize(String paramString)
  {
    // Byte code:
    //   0: getstatic 129	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   3: getstatic 32	com/inmobi/rendering/a:b	Ljava/lang/String;
    //   6: ldc_w 476
    //   9: invokestatic 149	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 61	com/inmobi/rendering/a:c	Lcom/inmobi/rendering/RenderView;
    //   16: invokevirtual 480	com/inmobi/rendering/RenderView:getFullScreenActivity	()Landroid/app/Activity;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: ifnonnull +33 -> 56
    //   26: aload_0
    //   27: getfield 61	com/inmobi/rendering/a:c	Lcom/inmobi/rendering/RenderView;
    //   30: invokevirtual 57	com/inmobi/rendering/RenderView:getRenderViewContext	()Landroid/content/Context;
    //   33: instanceof 482
    //   36: ifne +9 -> 45
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 485	com/inmobi/rendering/a:getScreenSize	(Ljava/lang/String;)Ljava/lang/String;
    //   44: areturn
    //   45: aload_0
    //   46: getfield 61	com/inmobi/rendering/a:c	Lcom/inmobi/rendering/RenderView;
    //   49: invokevirtual 57	com/inmobi/rendering/RenderView:getRenderViewContext	()Landroid/content/Context;
    //   52: checkcast 482	android/app/Activity
    //   55: astore_2
    //   56: aload_2
    //   57: ldc_w 486
    //   60: invokevirtual 490	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   63: checkcast 492	android/widget/FrameLayout
    //   66: checkcast 492	android/widget/FrameLayout
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 495	android/widget/FrameLayout:getWidth	()I
    //   74: invokestatic 500	com/inmobi/commons/core/utilities/info/DisplayInfo:b	(I)I
    //   77: istore 5
    //   79: aload_2
    //   80: invokevirtual 503	android/widget/FrameLayout:getHeight	()I
    //   83: invokestatic 500	com/inmobi/commons/core/utilities/info/DisplayInfo:b	(I)I
    //   86: istore 4
    //   88: aload_0
    //   89: getfield 61	com/inmobi/rendering/a:c	Lcom/inmobi/rendering/RenderView;
    //   92: invokevirtual 480	com/inmobi/rendering/RenderView:getFullScreenActivity	()Landroid/app/Activity;
    //   95: ifnull +153 -> 248
    //   98: iload 5
    //   100: ifeq +8 -> 108
    //   103: iload 4
    //   105: ifne +143 -> 248
    //   108: new 6	com/inmobi/rendering/a$a
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 506	com/inmobi/rendering/a$a:<init>	(Landroid/view/View;)V
    //   116: astore_1
    //   117: aload_2
    //   118: invokevirtual 510	android/widget/FrameLayout:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   121: aload_1
    //   122: invokevirtual 516	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   125: aload_1
    //   126: invokestatic 519	com/inmobi/rendering/a$a:a	(Lcom/inmobi/rendering/a$a;)Ljava/lang/Boolean;
    //   129: astore_2
    //   130: aload_2
    //   131: monitorenter
    //   132: aload_1
    //   133: invokestatic 519	com/inmobi/rendering/a$a:a	(Lcom/inmobi/rendering/a$a;)Ljava/lang/Boolean;
    //   136: invokevirtual 431	java/lang/Object:wait	()V
    //   139: aload_1
    //   140: invokestatic 522	com/inmobi/rendering/a$a:b	(Lcom/inmobi/rendering/a$a;)I
    //   143: istore 5
    //   145: aload_1
    //   146: invokestatic 524	com/inmobi/rendering/a$a:c	(Lcom/inmobi/rendering/a$a;)I
    //   149: istore 4
    //   151: aload_2
    //   152: monitorexit
    //   153: new 437	org/json/JSONObject
    //   156: dup
    //   157: invokespecial 438	org/json/JSONObject:<init>	()V
    //   160: astore_1
    //   161: aload_1
    //   162: ldc_w 526
    //   165: iload 5
    //   167: invokevirtual 530	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload_1
    //   172: ldc_w 532
    //   175: iload 4
    //   177: invokevirtual 530	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   180: pop
    //   181: getstatic 129	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   184: getstatic 32	com/inmobi/rendering/a:b	Ljava/lang/String;
    //   187: new 131	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 534
    //   197: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 439	org/json/JSONObject:toString	()Ljava/lang/String;
    //   204: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 149	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 439	org/json/JSONObject:toString	()Ljava/lang/String;
    //   217: areturn
    //   218: astore_3
    //   219: aload_3
    //   220: invokevirtual 432	java/lang/InterruptedException:printStackTrace	()V
    //   223: goto -84 -> 139
    //   226: astore_1
    //   227: aload_2
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: astore_2
    //   232: getstatic 129	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   235: getstatic 32	com/inmobi/rendering/a:b	Ljava/lang/String;
    //   238: ldc_w 536
    //   241: aload_2
    //   242: invokestatic 539	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -64 -> 181
    //   248: goto -95 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	a
    //   0	251	1	paramString	String
    //   21	207	2	localObject	Object
    //   231	11	2	localJSONException	JSONException
    //   19	4	3	localActivity	android.app.Activity
    //   218	2	3	localInterruptedException	InterruptedException
    //   86	90	4	i	int
    //   77	89	5	j	int
    // Exception table:
    //   from	to	target	type
    //   132	139	218	java/lang/InterruptedException
    //   132	139	226	finally
    //   139	153	226	finally
    //   219	223	226	finally
    //   227	229	226	finally
    //   161	181	231	org/json/JSONException
  }
  
  @JavascriptInterface
  public double getMicIntensity(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getMicIntensity called even when it is not supported");
    return -2.147483648E9D;
  }
  
  @JavascriptInterface
  public String getOrientation(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getOrientation called");
    int i = DisplayInfo.b();
    if (i == DisplayInfo.ORIENTATION_VALUES.PORTRAIT.getValue()) {
      return "0";
    }
    if (i == DisplayInfo.ORIENTATION_VALUES.LANDSCAPE.getValue()) {
      return "90";
    }
    if (i == DisplayInfo.ORIENTATION_VALUES.REVERSE_PORTRAIT.getValue()) {
      return "180";
    }
    if (i == DisplayInfo.ORIENTATION_VALUES.REVERSE_LANDSCAPE.getValue()) {
      return "270";
    }
    return "-1";
  }
  
  @JavascriptInterface
  public String getOrientationProperties(String paramString)
  {
    paramString = this.e.a();
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getOrientationProperties called: " + paramString);
    return paramString;
  }
  
  @JavascriptInterface
  public String getPlacementType(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getPlacementType called");
    if (this.d.a() == RenderingProperties.PlacementType.FULL_SCREEN) {
      return "interstitial";
    }
    return "inline";
  }
  
  @JavascriptInterface
  public String getPlatform(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getPlatform. Platform:" + b.e());
    return b.e();
  }
  
  @JavascriptInterface
  public String getPlatformVersion(String paramString)
  {
    paramString = Integer.toString(Build.VERSION.SDK_INT);
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getPlatformVersion. Version:" + paramString);
    return paramString;
  }
  
  @JavascriptInterface
  public String getResizeProperties(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return "";
    }
    paramString = this.c.getResizeProperties();
    if (paramString == null) {
      return "";
    }
    return paramString.a();
  }
  
  @JavascriptInterface
  public String getScreenSize(String paramString)
  {
    paramString = new JSONObject();
    try
    {
      paramString.put("width", DisplayInfo.a().b());
      paramString.put("height", DisplayInfo.a().a());
      paramString = paramString.toString();
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getScreenSize called:" + paramString);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  @JavascriptInterface
  public String getSdkVersion(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getSdkVersion called. Version:" + b.c());
    return b.c();
  }
  
  @JavascriptInterface
  public String getState(String paramString)
  {
    paramString = this.c.getState().toString().toLowerCase(Locale.ENGLISH);
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getState called:" + paramString);
    return paramString;
  }
  
  @JavascriptInterface
  public String getVersion(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "getVersion called. Version:" + b.d());
    return b.d();
  }
  
  @JavascriptInterface
  public int getVideoVolume(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: getVideoVolume (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return 0;
    }
    return this.c.e(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public void hideVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: hideVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.13(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void incentCompleted(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "incentCompleted called. IncentData:" + paramString2);
    if (paramString2 == null)
    {
      this.c.getListener().a(this.c, null);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString2);
      paramString2 = new HashMap();
      Iterator localIterator = paramString1.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString2.put(str, paramString1.get(str));
      }
      this.c.getListener().a(this.c, paramString2);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      this.c.getListener().a(this.c, null);
      return;
    }
  }
  
  @JavascriptInterface
  public boolean isAudioMuted(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isAudioMuted (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return false;
    }
    return this.c.f(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public boolean isBackButtonDisabled(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return false;
    }
    return this.c.g();
  }
  
  @JavascriptInterface
  public String isDeviceMuted(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return "false";
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isDeviceMuted()");
    return String.valueOf(this.c.getMediaProcessor().d());
  }
  
  @JavascriptInterface
  public String isHeadphonePlugged(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return "false";
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isHeadphonePlugged()");
    return String.valueOf(this.c.getMediaProcessor().g());
  }
  
  @JavascriptInterface
  public boolean isVideoMuted(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isVideoMuted (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return false;
    }
    return this.c.f(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public boolean isViewable(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return false;
    }
    return this.c.a();
  }
  
  @JavascriptInterface
  public void log(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Log called. Message:" + paramString2);
  }
  
  @JavascriptInterface
  public void makeCall(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "makeCall called even when it is not supported");
  }
  
  @JavascriptInterface
  public void muteAudio(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: muteAudio (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.21(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void muteVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: muteVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.15(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void onOrientationChange(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, ">>> onOrientationChange() >>> This API is deprecated!");
  }
  
  @JavascriptInterface
  public void onUserInteraction(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "onUserInteraction called. Params:" + paramString2);
    if (paramString2 == null)
    {
      this.c.getListener().b(this.c, null);
      return;
    }
    try
    {
      paramString1 = new JSONObject(paramString2);
      paramString2 = new HashMap();
      Iterator localIterator = paramString1.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString2.put(str, paramString1.get(str));
      }
      this.c.getListener().b(this.c, paramString2);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      this.c.getListener().b(this.c, null);
      return;
    }
  }
  
  @JavascriptInterface
  public void open(String paramString1, String paramString2)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.1(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void openEmbedded(String paramString1, String paramString2)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.12(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void openExternal(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "openExternal called with url: " + paramString2);
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if ((paramString2.startsWith("http")) && (!URLUtil.isValidUrl(paramString2)))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "openExternal called with invalid url (" + paramString2 + ")");
      this.c.a(paramString1, "Invalid URL", "openExternal");
      return;
    }
    this.c.b("openExternal", paramString1, paramString2);
  }
  
  @JavascriptInterface
  public void pauseAudio(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: pauseAudio (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.20(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void pauseVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: pauseVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.10(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void ping(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if ((paramString2 == null) || (paramString2.trim().length() == 0) || (!URLUtil.isValidUrl(paramString2)))
    {
      this.c.a(paramString1, "Invalid URL:" + paramString2, "ping");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called ping() URL: >>> " + paramString2 + " <<<");
    com.inmobi.rendering.a.c.a().a(paramString2, paramBoolean);
  }
  
  @JavascriptInterface
  public void pingInWebView(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if ((paramString2 == null) || (paramString2.trim().length() == 0) || (!URLUtil.isValidUrl(paramString2)))
    {
      this.c.a(paramString1, "Invalid URL:" + paramString2, "pingInWebView");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called pingInWebView() URL: >>> " + paramString2 + " <<<");
    com.inmobi.rendering.a.c.a().b(paramString2, paramBoolean);
  }
  
  @JavascriptInterface
  public void playAudio(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, String paramString5)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: playAudio (" + paramString2 + ", " + paramString5 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.18(this, paramString5, paramString2, paramString1, paramBoolean1, paramBoolean3, paramString3, paramString4, paramBoolean2));
  }
  
  @JavascriptInterface
  public void playVideo(String paramString1, String paramString2)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if ((paramString2 == null) || (paramString2.trim().length() == 0) || (!paramString2.startsWith("http")))
    {
      this.c.a(paramString1, "Null or empty or invalid media playback URL supplied", "playVideo");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: playVideo (" + paramString2 + ")");
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.32(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void playVideo(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.8(this, paramString2, paramString9, paramString1, paramString5, paramString6, paramBoolean2, paramBoolean4, paramString7, paramString8, paramString4, paramString3, paramBoolean1, paramBoolean3));
  }
  
  @JavascriptInterface
  public void postToSocial(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "postToSocial called with parameters: socialType: " + paramInt + "; text: " + paramString2 + "; link: " + paramString3 + "; image URL: " + paramString4);
    this.c.a(paramString1, paramInt, paramString2, paramString3, paramString4);
  }
  
  @JavascriptInterface
  public void registerBackButtonPressedEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.c(paramString);
  }
  
  @SuppressLint({"NewApi"})
  public void registerBroadcastListener(String paramString)
  {
    if (this.h == null)
    {
      this.h = new a.3(this, paramString);
      com.inmobi.commons.a.a.b().registerReceiver(this.h, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }
  }
  
  @JavascriptInterface
  public void registerDeviceMuteEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.getMediaProcessor().a(paramString);
  }
  
  @JavascriptInterface
  public void registerDeviceVolumeChangeEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.getMediaProcessor().b(paramString);
  }
  
  @JavascriptInterface
  public void registerHeadphonePluggedEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.getMediaProcessor().c(paramString);
  }
  
  @JavascriptInterface
  @TargetApi(23)
  public void registerMicListener(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "registerMicListener called even when it is not supported");
  }
  
  @JavascriptInterface
  public void resize(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "resize called");
    if (this.d.a() != RenderingProperties.PlacementType.FULL_SCREEN)
    {
      if (this.c == null) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      }
    }
    else {
      return;
    }
    if (this.c.a())
    {
      new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.30(this));
      return;
    }
    this.c.a(paramString, "Creative is not visible. Ignoring request.", "resize");
  }
  
  @JavascriptInterface
  public void saveContent(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString3 == null) || (paramString3.length() == 0))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "saveContent called with invalid parameters");
      Object localObject = new JSONObject();
      String str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      try
      {
        ((JSONObject)localObject).put("url", str);
        ((JSONObject)localObject).put("reason", 1);
        str = ((JSONObject)localObject).toString().replace("\"", "\\\"");
        localObject = new StringBuilder().append("sendSaveContentResult(\"saveContent_");
        paramString3 = paramString2;
        if (paramString2 == null) {
          paramString3 = "";
        }
        paramString2 = paramString3 + "\", 'failed', \"" + str + "\");";
        this.c.a(paramString1, paramString2);
        return;
      }
      catch (JSONException paramString3)
      {
        for (;;)
        {
          paramString3.printStackTrace();
        }
      }
    }
    this.c.d(paramString1, paramString2, paramString3);
  }
  
  @JavascriptInterface
  public void seekAudio(String paramString1, String paramString2, int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: seekAudio (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.19(this, paramString1, paramString2, paramInt));
  }
  
  @JavascriptInterface
  public void seekVideo(String paramString1, String paramString2, int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: seekVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.9(this, paramString1, paramString2, paramInt));
  }
  
  @JavascriptInterface
  public void sendMail(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "sendMail called even when it is not supported");
  }
  
  @JavascriptInterface
  public void sendSMS(String paramString1, String paramString2, String paramString3)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "sendSMS called even when it is not supported");
  }
  
  @JavascriptInterface
  public void setAudioVolume(String paramString1, String paramString2, int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: setAudioVolume (" + paramString2 + ", " + paramInt + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.24(this, paramString1, paramString2, paramInt));
  }
  
  @JavascriptInterface
  public void setExpandProperties(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "setExpandProperties called. Params:" + paramString2);
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    if (this.c.getState() == RenderView.RenderViewState.EXPANDED)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "setExpandProperties can't be called on an already expanded ad.");
      return;
    }
    paramString1 = d.a(paramString2, this.c.getExpandProperties(), this.c.getOrientationProperties());
    this.c.setExpandProperties(paramString1);
  }
  
  @JavascriptInterface
  public void setOrientationProperties(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "setOrientationProperties called: " + paramString2);
    this.e = l.a(paramString2, this.c.getOrientationProperties());
    this.c.setOrientationProperties(this.e);
  }
  
  @JavascriptInterface
  public void setResizeProperties(String paramString1, String paramString2)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "setResizeProperties called. Properties:" + paramString2);
    paramString2 = m.a(paramString2, this.c.getResizeProperties());
    if (paramString2 == null) {
      this.c.a(paramString1, "setResizeProperties", "All mandatory fields are not present");
    }
    this.c.setResizeProperties(paramString2);
  }
  
  @JavascriptInterface
  public void setVideoVolume(String paramString1, String paramString2, int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: setVideoVolume (" + paramString2 + ", " + paramInt + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.17(this, paramString1, paramString2, paramInt));
  }
  
  @JavascriptInterface
  public void showAlert(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "showAlert: " + paramString2);
  }
  
  @JavascriptInterface
  public void showVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: showVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.14(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  @SuppressLint({"NewApi"})
  public void storePicture(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "storePicture called with URL: " + paramString2);
    if (!this.c.f("storePicture"))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "storePicture called despite the fact that it is not supported");
      return;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      this.c.a(paramString1, "Null or empty URL supplied", "storePicture");
      return;
    }
    if ((!paramString2.startsWith("http")) && (!paramString2.startsWith("HTTP")))
    {
      this.c.a(paramString1, "Invalid URL scheme - only HTTP(S) is supported", "storePicture");
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      paramString1 = new a.2(this, paramString1, paramString2);
      InMobiAdActivity.a(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, paramString1);
      return;
    }
    a(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public String supports(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Checking support for: " + paramString2);
    if ((!Arrays.asList(a).contains(paramString2)) && (!this.c.f(paramString2))) {
      return "false";
    }
    return String.valueOf(this.c.f(paramString2));
  }
  
  @JavascriptInterface
  @TargetApi(23)
  public void takeCameraPicture(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "takeCameraPicture called even when it is not supported");
  }
  
  @JavascriptInterface
  public void unMuteAudio(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: unMuteAudio (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.22(this, paramString1, paramString2));
  }
  
  @JavascriptInterface
  public void unMuteVideo(String paramString1, String paramString2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: unMuteVideo (" + paramString2 + ")");
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.16(this, paramString1, paramString2));
  }
  
  @SuppressLint({"NewApi"})
  public void unRegisterBroadcastListener()
  {
    if (this.h != null)
    {
      com.inmobi.commons.a.a.b().unregisterReceiver(this.h);
      this.h = null;
    }
  }
  
  @JavascriptInterface
  public void unregisterBackButtonPressedEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    this.c.h();
  }
  
  @JavascriptInterface
  public void unregisterDeviceMuteEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Unregister device mute event listener ...");
    this.c.getMediaProcessor().e();
  }
  
  @JavascriptInterface
  public void unregisterDeviceVolumeChangeEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Unregister device volume change listener ...");
    this.c.getMediaProcessor().f();
  }
  
  @JavascriptInterface
  public void unregisterHeadphonePluggedEventListener(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Unregister headphone plugged event listener ...");
    this.c.getMediaProcessor().h();
  }
  
  @JavascriptInterface
  @TargetApi(23)
  public void unregisterMicListener(String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "unRegisterMicListener called even when it is not supported");
  }
  
  @JavascriptInterface
  public void useCustomClose(String paramString, boolean paramBoolean)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "useCustomClose called:" + paramBoolean);
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.31(this, paramBoolean));
  }
  
  @JavascriptInterface
  public void vibrate(String paramString)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Vibrate called");
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.26(this, paramString));
  }
  
  @JavascriptInterface
  public void vibrate(String paramString1, String paramString2, int paramInt)
  {
    if (this.c == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Vibrate called with pattern " + paramString2);
    new Handler(this.c.getRenderViewContext().getMainLooper()).post(new a.27(this, paramString1, paramString2, paramInt));
  }
  
  @TargetApi(16)
  private static class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int a;
    private int b;
    private View c;
    private final Boolean d = Boolean.valueOf(false);
    
    a(View paramView)
    {
      this.c = paramView;
    }
    
    public void onGlobalLayout()
    {
      this.a = DisplayInfo.b(this.c.getWidth());
      this.b = DisplayInfo.b(this.c.getHeight());
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      synchronized (this.d)
      {
        this.d.notify();
        return;
        this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */