package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class InMobiNative
{
  private static final String TAG = InMobiNative.class.getSimpleName();
  protected static WeakHashMap<View, p> sMappedAdUnits = new WeakHashMap();
  private a mClientCallbackHandler;
  private final AdUnit.a mListener = new InMobiNative.1(this);
  private NativeAdListener mNativeAdListener;
  protected p mNativeAdUnit;
  
  public InMobiNative(long paramLong, NativeAdListener paramNativeAdListener)
  {
    if (!a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
      return;
    }
    if (paramNativeAdListener == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
      return;
    }
    this.mNativeAdListener = paramNativeAdListener;
    this.mNativeAdUnit = new p(paramLong, this.mListener);
    this.mClientCallbackHandler = new a(this, paramNativeAdListener);
  }
  
  public static void bind(View paramView, InMobiNative paramInMobiNative)
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
    paramInMobiNative.a(paramView, null, null);
  }
  
  public static void unbind(View paramView)
  {
    if (paramView == null) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please pass a non-null view object to bind.");
    }
    p localp;
    do
    {
      return;
      localp = (p)sMappedAdUnits.remove(paramView);
    } while (localp == null);
    localp.a(paramView);
  }
  
  public final Object getAdContent()
  {
    if (this.mNativeAdUnit == null) {
      return null;
    }
    return this.mNativeAdUnit.z();
  }
  
  public final void load()
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.o();
    }
  }
  
  public final void pause()
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.y();
    }
  }
  
  public final void reportAdClick(Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.a(paramMap, null, null);
    }
  }
  
  public final void reportAdClickAndOpenLandingPage(Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null)
    {
      this.mNativeAdUnit.a(paramMap, null, null);
      this.mNativeAdUnit.B();
    }
  }
  
  public final void resume()
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.x();
    }
  }
  
  public final void setExtras(Map<String, String> paramMap)
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.a(paramMap);
    }
  }
  
  public final void setKeywords(String paramString)
  {
    if (this.mNativeAdUnit != null) {
      this.mNativeAdUnit.a(paramString);
    }
  }
  
  public static abstract interface NativeAdListener
  {
    public abstract void onAdDismissed(InMobiNative paramInMobiNative);
    
    public abstract void onAdDisplayed(InMobiNative paramInMobiNative);
    
    public abstract void onAdLoadFailed(InMobiNative paramInMobiNative, InMobiAdRequestStatus paramInMobiAdRequestStatus);
    
    public abstract void onAdLoadSucceeded(InMobiNative paramInMobiNative);
    
    public abstract void onUserLeftApplication(InMobiNative paramInMobiNative);
  }
  
  private static final class a
    extends Handler
  {
    private WeakReference<InMobiNative.NativeAdListener> a;
    private WeakReference<InMobiNative> b;
    
    public a(InMobiNative paramInMobiNative, InMobiNative.NativeAdListener paramNativeAdListener)
    {
      super();
      this.b = new WeakReference(paramInMobiNative);
      this.a = new WeakReference(paramNativeAdListener);
    }
    
    public void handleMessage(Message paramMessage)
    {
      InMobiNative localInMobiNative = (InMobiNative)this.b.get();
      InMobiNative.NativeAdListener localNativeAdListener = (InMobiNative.NativeAdListener)this.a.get();
      if ((localInMobiNative != null) && (localNativeAdListener != null)) {}
      switch (paramMessage.what)
      {
      default: 
        Logger.a(Logger.InternalLogLevel.INTERNAL, InMobiNative.TAG, "Unhandled ad lifecycle event! Ignoring ...");
        return;
      case 1: 
        localNativeAdListener.onAdLoadSucceeded(localInMobiNative);
        return;
      case 2: 
        localNativeAdListener.onAdLoadFailed(localInMobiNative, (InMobiAdRequestStatus)paramMessage.obj);
        return;
      case 3: 
        localNativeAdListener.onAdDisplayed(localInMobiNative);
        return;
      case 4: 
        localNativeAdListener.onAdDismissed(localInMobiNative);
        return;
      }
      localNativeAdListener.onUserLeftApplication(localInMobiNative);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */