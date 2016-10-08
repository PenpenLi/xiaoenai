package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.io.UnsupportedEncodingException;

public class b
{
  private static b jdField_a_of_type_ComAlibabaMtlLogB = new b();
  private String H = null;
  private String I = null;
  private String J = null;
  private String K = null;
  private String L = null;
  private Application jdField_a_of_type_AndroidAppApplication = null;
  private IUTRequestAuthentication jdField_a_of_type_ComUtMiniCoreSignIUTRequestAuthentication = null;
  private Context mContext = null;
  private boolean s = false;
  private boolean t = false;
  
  public static b a()
  {
    return jdField_a_of_type_ComAlibabaMtlLogB;
  }
  
  private void d(String paramString)
  {
    this.H = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      this.I = paramString;
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {}
    try
    {
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("UTCommon", 0).edit();
      localEditor.putString("_lun", new String(c.encode(paramString.getBytes("UTF-8"), 2)));
      localEditor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e(String paramString)
  {
    this.J = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      this.K = paramString;
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {}
    try
    {
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("UTCommon", 0).edit();
      localEditor.putString("_luid", new String(c.encode(paramString.getBytes("UTF-8"), 2)));
      localEditor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void o()
  {
    if ((!this.s) && (Build.VERSION.SDK_INT >= 14)) {
      try
      {
        if (a().a() != null)
        {
          UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(a().a());
          this.s = true;
          return;
        }
        UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application)a().getContext().getApplicationContext());
        this.s = true;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Log.e("UTEngine", "You need set a application instance for UT.");
      }
    }
  }
  
  public Application a()
  {
    return this.jdField_a_of_type_AndroidAppApplication;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void setAppApplicationInstance(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    o();
  }
  
  public void setAppVersion(String paramString)
  {
    this.L = paramString;
  }
  
  public void setContext(Context paramContext)
  {
    String str;
    if (paramContext != null)
    {
      this.mContext = paramContext;
      paramContext = this.mContext.getSharedPreferences("UTCommon", 0);
      str = paramContext.getString("_lun", "");
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      this.I = new String(c.decode(str.getBytes(), 2), "UTF-8");
      paramContext = paramContext.getString("_luid", "");
      if (TextUtils.isEmpty(paramContext)) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        this.K = new String(c.decode(paramContext.getBytes(), 2), "UTF-8");
        o();
        return;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
      }
      catch (UnsupportedEncodingException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  public void turnOnDebug()
  {
    i.d(true);
  }
  
  public void updateUserAccount(String paramString1, String paramString2)
  {
    d(paramString1);
    e(paramString2);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = new UTOriginalCustomHitBuilder("UT", 1007, paramString1, paramString2, null, null);
      UTAnalytics.getInstance().getDefaultTracker().send(paramString1.build());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */