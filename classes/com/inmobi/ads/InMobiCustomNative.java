package com.inmobi.ads;

import android.view.View;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.net.URL;
import java.util.Map;
import java.util.WeakHashMap;

public final class InMobiCustomNative
  extends InMobiNative
{
  private static final String TAG = InMobiCustomNative.class.getSimpleName();
  
  public InMobiCustomNative(long paramLong, InMobiNative.NativeAdListener paramNativeAdListener)
  {
    super(paramLong, paramNativeAdListener);
  }
  
  public static void bind(View paramView, InMobiNative paramInMobiNative, String paramString)
  {
    if ((paramView == null) || (paramInMobiNative == null)) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
    }
    do
    {
      return;
      if ((p)sMappedAdUnits.get(paramView) != null) {
        unbind(paramView);
      }
      paramInMobiNative = paramInMobiNative.mNativeAdUnit;
    } while (paramInMobiNative == null);
    sMappedAdUnits.remove(paramView);
    sMappedAdUnits.put(paramView, paramInMobiNative);
    paramInMobiNative.a(paramView, null, paramString);
  }
  
  public static void bind(View paramView, InMobiNative paramInMobiNative, URL paramURL)
  {
    if ((paramView == null) || (paramInMobiNative == null)) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
    }
    do
    {
      return;
      if ((p)sMappedAdUnits.get(paramView) != null) {
        unbind(paramView);
      }
      paramInMobiNative = paramInMobiNative.mNativeAdUnit;
    } while (paramInMobiNative == null);
    sMappedAdUnits.remove(paramView);
    sMappedAdUnits.put(paramView, paramInMobiNative);
    paramInMobiNative.a(paramView, paramURL, null);
  }
  
  public final void reportAdClick(String paramString, Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.a(paramMap, null, paramString);
    }
  }
  
  public final void reportAdClick(URL paramURL, Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.a(paramMap, paramURL, null);
    }
  }
  
  public final void reportAdClickAndOpenLandingPage(String paramString, Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null)
    {
      this.mNativeAdUnit.a(paramMap, null, paramString);
      this.mNativeAdUnit.B();
    }
  }
  
  public final void reportAdClickAndOpenLandingPage(URL paramURL, Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null)
    {
      this.mNativeAdUnit.a(paramMap, paramURL, null);
      this.mNativeAdUnit.B();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiCustomNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */