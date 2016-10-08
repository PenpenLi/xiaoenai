package com.inmobi.rendering.mraid;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.CalendarContract.Events;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.plus.PlusShare.Builder;
import com.inmobi.ads.b.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private static final String a = n.class.getSimpleName();
  private RenderView b;
  private a c;
  
  public n(RenderView paramRenderView)
  {
    this.b = paramRenderView;
    HandlerThread localHandlerThread = new HandlerThread("SystemTasksHandlerThread");
    localHandlerThread.start();
    this.c = new a(localHandlerThread.getLooper(), paramRenderView);
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.length() != 0) {
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.optString("frequency");
        if ((str1 != null) && (!"".equals(str1)))
        {
          if (("daily".equals(str1)) || ("weekly".equals(str1)) || ("monthly".equals(str1)) || ("yearly".equals(str1)))
          {
            localStringBuilder.append("freq=").append(str1).append(";");
            String str2 = paramString.optString("interval");
            if ((str2 != null) && (!"".equals(str2))) {
              localStringBuilder.append("interval=").append(Integer.parseInt(str2)).append(";");
            }
            str2 = a.a(paramString.optString("expires"));
            if (str2 != null) {
              localStringBuilder.append("until=").append(str2.replace("+", "Z+").replace("-", "Z-")).append(";");
            }
            if (str1.equals("weekly"))
            {
              str2 = a.a(paramString.optJSONArray("daysInWeek"));
              if (str2 != null) {
                localStringBuilder.append("byday=").append(str2).append(";");
              }
            }
            if (str1.equals("monthly"))
            {
              str2 = a.a(paramString.optJSONArray("daysInMonth"), -31, 31);
              if (str2 != null) {
                localStringBuilder.append("bymonthday=").append(str2).append(";");
              }
            }
            if (str1.equals("yearly"))
            {
              str2 = a.a(paramString.optJSONArray("daysInYear"), 65170, 366);
              if (str2 != null) {
                localStringBuilder.append("byyearday=").append(str2).append(";");
              }
            }
            if (str1.equals("monthly"))
            {
              str2 = a.a(paramString.optJSONArray("weeksInMonth"), -4, 4);
              if (str2 != null) {
                localStringBuilder.append("byweekno=").append(str2).append(";");
              }
            }
            if (str1.equals("yearly"))
            {
              paramString = a.a(paramString.optJSONArray("monthsInYear"), 1, 12);
              if (paramString != null) {
                localStringBuilder.append("bymonth=").append(paramString).append(";");
              }
            }
            return localStringBuilder.toString();
          }
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error Parsing recurrence string. Invalid Frequency supplied");
          return "";
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error Parsing recurrence string. Frequency supplied is null");
        return "";
      }
      catch (JSONException paramString)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error Parsing recurrence string" + paramString.toString());
        return "";
      }
    }
    return "";
  }
  
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + " " + paramString2 + " " + paramString3;
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramString1 = (String)localObject;
    }
    while (paramString1 != null)
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setData(Uri.parse(paramString1));
      try
      {
        com.inmobi.commons.a.a.a(paramContext, paramString2);
        return;
      }
      catch (ActivityNotFoundException paramContext)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, paramContext.getMessage());
        return;
      }
      try
      {
        paramString1 = "https://www.facebook.com/dialog/feed?app_id=181821551957328&link=" + URLEncoder.encode(paramString2, "UTF-8") + "&picture=" + URLEncoder.encode(paramString3, "UTF-8") + "&name=&description=" + URLEncoder.encode(paramString1, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(paramString2, "UTF-8");
      }
      catch (UnsupportedEncodingException paramContext) {}
      paramString1 = "https://m.google.com/app/plus/x/?v=compose&content=" + URLEncoder.encode(str, "UTF-8");
      continue;
      paramString1 = "http://twitter.com/home?status=" + URLEncoder.encode(str, "UTF-8");
    }
    paramString1 = new Intent();
    paramString1.setType("text/plain");
    paramString1.putExtra("android.intent.extra.TEXT", str);
    try
    {
      com.inmobi.commons.a.a.a(paramContext, paramString1);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, paramContext.getMessage());
      return;
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    try
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Google Play Services is not installed!");
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "RuntimeException");
      localHashMap.put("message", localRuntimeException.getMessage());
      com.inmobi.commons.core.c.a.a().a("ads", "ExceptionCaught", localHashMap);
    }
    return false;
  }
  
  public void a(Context paramContext)
  {
    if ((this.c != null) && (this.c.hasMessages(1)))
    {
      this.c.removeMessages(1);
      ((Vibrator)paramContext.getSystemService("vibrator")).cancel();
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Canceling any pending/ongoing vibrate requests");
    }
  }
  
  public void a(String paramString, Context paramContext)
  {
    ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(2000L);
    paramContext = Message.obtain();
    paramContext.what = 1;
    paramContext.obj = paramString;
    this.c.sendMessageDelayed(paramContext, 2000L);
  }
  
  public void a(String paramString1, Context paramContext, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString3 == null) || (paramString3.length() == 0) || (!paramString3.startsWith("http")) || (paramString4 == null) || (paramString4.length() == 0) || (!paramString4.startsWith("http")) || (!paramString4.endsWith(".jpg")))
    {
      this.b.a(paramString1, "Attempting to share with null/empty/invalid parameters", "postToSocial");
      return;
    }
    String str = null;
    switch (paramInt)
    {
    default: 
      this.b.a(paramString1, "Unsupported type of social network", "postToSocial");
      return;
    case 1: 
      paramString1 = str;
    }
    while (paramString1 != null)
    {
      try
      {
        com.inmobi.commons.a.a.a(paramContext, paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        a(paramContext, paramInt, paramString2, paramString3, paramString4);
        return;
      }
      paramString1 = str;
      if (b())
      {
        paramString1 = paramString2 + " " + paramString3 + " " + paramString4;
        paramString1 = new PlusShare.Builder(paramContext).setType("text/plain").setText(paramString1).setContentUrl(Uri.parse(paramString4)).getIntent();
        continue;
        str = paramString2 + " " + paramString3 + " " + paramString4;
        paramString1 = new Intent();
        paramString1.setType("text/plain");
        paramString1.setPackage("com.twitter.android");
        paramString1.putExtra("android.intent.extra.TEXT", str);
      }
    }
    a(paramContext, paramInt, paramString2, paramString3, paramString4);
  }
  
  public void a(String paramString1, Context paramContext, String paramString2, int paramInt)
  {
    Vibrator localVibrator = (Vibrator)paramContext.getSystemService("vibrator");
    paramString2 = paramString2.replaceAll("\\[", "").replaceAll("\\]", "");
    if ((paramString2 == null) || ("".equals(paramString2.trim())))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Vibration canceled");
      a(paramContext);
    }
    long[] arrayOfLong;
    int k;
    do
    {
      return;
      paramString2 = paramString2.split(",");
      int j = paramString2.length;
      b.e locale = this.b.getRenderingConfig();
      int i = j;
      if (j > locale.f())
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "vibration pattern exceeds max length. Will be truncated to max " + locale.f());
        i = locale.f();
      }
      arrayOfLong = new long[i];
      k = 0;
      j = 0;
      while (j < i) {
        try
        {
          arrayOfLong[j] = Long.parseLong(paramString2[j]);
          if (arrayOfLong[j] > locale.e() * 1000)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, a, "vibration duration exceeds max. Will only vibrate for max " + locale.e() + "ms");
            arrayOfLong[j] = locale.e();
          }
          if (arrayOfLong[j] < 0L) {
            this.b.a(paramString1, "Negative duration not allowed in vibration .", "vibrate");
          }
          k = (int)(k + arrayOfLong[j]);
          j += 1;
        }
        catch (NumberFormatException paramContext)
        {
          this.b.a(paramString1, "Invalid values of pattern in vibration .", "vibrate");
          return;
        }
      }
    } while (arrayOfLong.length == 0);
    a(paramContext);
    localVibrator.vibrate(arrayOfLong, paramInt);
    paramContext = Message.obtain();
    paramContext.what = 1;
    paramContext.obj = paramString1;
    this.c.sendMessageDelayed(paramContext, k);
  }
  
  @TargetApi(14)
  public void a(String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    int i = a.a(paramContext);
    GregorianCalendar localGregorianCalendar1 = a.b(paramString3);
    if (localGregorianCalendar1 == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid event start date provided. date string: " + paramString3);
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Event start: " + localGregorianCalendar1.get(1) + "-" + localGregorianCalendar1.get(2) + "-" + localGregorianCalendar1.get(5));
    GregorianCalendar localGregorianCalendar2 = a.b(paramString4);
    if (localGregorianCalendar2 == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid event end date provided. date string: " + paramString4);
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Event end: " + localGregorianCalendar2.get(1) + "-" + localGregorianCalendar2.get(2) + "-" + localGregorianCalendar2.get(5));
    paramString2 = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("calendar_id", paramString2).putExtra("beginTime", localGregorianCalendar1.getTimeInMillis()).putExtra("endTime", localGregorianCalendar2.getTimeInMillis()).putExtra("allDay", false).putExtra("title", paramString6).putExtra("eventLocation", paramString5).putExtra("description", paramString7);
    if (paramString9.equals("transparent")) {
      paramString2.putExtra("availability", 1);
    }
    for (;;)
    {
      paramString4 = a(paramString10);
      if (paramString4.length() != 0) {
        paramString2.putExtra("rrule", paramString4);
      }
      i = InMobiAdActivity.a(paramString2, new n.1(this, paramContext, i, paramString8, paramString11, paramString3, paramString1));
      paramString1 = new Intent(paramContext, InMobiAdActivity.class);
      paramString1.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
      paramString1.putExtra("id", i);
      com.inmobi.commons.a.a.a(paramContext, paramString1);
      return;
      if (paramString9.equals("opaque")) {
        paramString2.putExtra("availability", 0);
      }
    }
  }
  
  static final class a
    extends Handler
  {
    private static final String a = a.class.getSimpleName();
    private WeakReference<RenderView> b;
    
    public a(Looper paramLooper, RenderView paramRenderView)
    {
      super();
      this.b = new WeakReference(paramRenderView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unknown message type. Ignoring ...");
      }
      RenderView localRenderView;
      do
      {
        return;
        paramMessage = (String)paramMessage.obj;
        localRenderView = (RenderView)this.b.get();
      } while (localRenderView == null);
      localRenderView.a(paramMessage, "broadcastEvent('vibrateComplete');");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */