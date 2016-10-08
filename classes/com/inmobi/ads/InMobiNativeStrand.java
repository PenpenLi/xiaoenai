package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class InMobiNativeStrand
{
  private static final String TAG = InMobiNativeStrand.class.getSimpleName();
  private a mClientCallbackHandler;
  private Context mContext;
  private q.a mInteractionCallback = new InMobiNativeStrand.1(this);
  @Nullable
  private q mNativeStrandAd;
  private NativeStrandAdListener mNativeStrandAdListener;
  private s mNativeStrandAdUnit;
  
  public InMobiNativeStrand(Context paramContext, long paramLong, NativeStrandAdListener paramNativeStrandAdListener)
  {
    if (!com.inmobi.commons.a.a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please initialize the InMobiSdk before trying to instantiate InMobiNativeStrand.");
      return;
    }
    if (paramContext == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Context is null, Native Strand cannot be created.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Context is not Activity, Native Strand cannot be created.");
      return;
    }
    if (paramNativeStrandAdListener == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Listener supplied is null, the Native Strand cannot be created.");
      return;
    }
    InMobiNativeStrand.2 local2 = new InMobiNativeStrand.2(this);
    this.mContext = paramContext;
    this.mNativeStrandAdUnit = new s(paramContext, paramLong, new Integer[0], local2);
    this.mNativeStrandAdListener = paramNativeStrandAdListener;
    this.mClientCallbackHandler = new a(this);
  }
  
  private void deInit()
  {
    if (this.mNativeStrandAd != null)
    {
      this.mNativeStrandAd.c();
      this.mNativeStrandAd = null;
    }
  }
  
  public void destroy()
  {
    if (!com.inmobi.commons.a.a.a()) {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized. Ignoring InMobiNativeStrand.destroy()");
    }
    if (this.mClientCallbackHandler != null) {
      this.mClientCallbackHandler.removeMessages(0);
    }
    this.mNativeStrandAdListener = null;
    if (this.mNativeStrandAdUnit != null)
    {
      this.mNativeStrandAdUnit.y();
      this.mNativeStrandAdUnit = null;
    }
    deInit();
  }
  
  public View getStrandView(View paramView, ViewGroup paramViewGroup)
  {
    if (!com.inmobi.commons.a.a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized.Ignoring InMobiNativeStrand.getStrandView()");
      return null;
    }
    if (this.mNativeStrandAdUnit == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized.Ignoring InMobiNativeStrand.getStrandView()");
      return null;
    }
    if (this.mNativeStrandAd == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "No ad is available. Call load to request for ad or wait for wait for callback if ad load is already requested");
      return null;
    }
    paramView = this.mNativeStrandAd.a(paramView, paramViewGroup, this.mNativeStrandAdUnit.l().l());
    if (paramView == null)
    {
      com.inmobi.commons.core.c.a.a().a("ads", "StrandInflationFailed", new HashMap());
      Logger.a(Logger.InternalLogLevel.INTERNAL, TAG, "Error inflating view even with a valid data model!");
      return null;
    }
    return paramView;
  }
  
  public void load()
  {
    if (!com.inmobi.commons.a.a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized. Ignoring InMobiNativeStrand.load()");
      return;
    }
    if (this.mNativeStrandAdUnit == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized, ignoring InMobiNativeStrand.load()");
      return;
    }
    deInit();
    Logger.a(Logger.InternalLogLevel.INTERNAL, TAG, "Ad not loaded already requesting it now");
    this.mNativeStrandAdUnit.o();
  }
  
  public void setExtras(Map<String, String> paramMap)
  {
    if (!com.inmobi.commons.a.a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized.Ignoring InMobiNativeStrand.setExtras()");
      return;
    }
    if (this.mNativeStrandAdUnit == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized, ignoring setExtras.");
      return;
    }
    this.mNativeStrandAdUnit.a(paramMap);
  }
  
  public void setKeywords(String paramString)
  {
    if (!com.inmobi.commons.a.a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized.Ignoring InMobiNativeStrand.setKeywords()");
      return;
    }
    if (this.mNativeStrandAdUnit == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "InMobiNativeStrand is not initialized, ignoring setKeywords().");
      return;
    }
    this.mNativeStrandAdUnit.a(paramString);
  }
  
  public static abstract interface NativeStrandAdListener
  {
    public abstract void onAdClicked(@NonNull InMobiNativeStrand paramInMobiNativeStrand);
    
    public abstract void onAdImpressed(@NonNull InMobiNativeStrand paramInMobiNativeStrand);
    
    public abstract void onAdLoadFailed(@NonNull InMobiNativeStrand paramInMobiNativeStrand, @NonNull InMobiAdRequestStatus paramInMobiAdRequestStatus);
    
    public abstract void onAdLoadSucceeded(@NonNull InMobiNativeStrand paramInMobiNativeStrand);
  }
  
  private static final class a
    extends Handler
  {
    private WeakReference<InMobiNativeStrand> a;
    
    public a(InMobiNativeStrand paramInMobiNativeStrand)
    {
      super();
      this.a = new WeakReference(paramInMobiNativeStrand);
    }
    
    public void handleMessage(Message paramMessage)
    {
      InMobiNativeStrand localInMobiNativeStrand = (InMobiNativeStrand)this.a.get();
      if (localInMobiNativeStrand == null)
      {
        Logger.a(Logger.InternalLogLevel.ERROR, InMobiNativeStrand.TAG, "Lost reference to InMobiNativeStrand! callback cannot be given");
        return;
      }
      InMobiNativeStrand.NativeStrandAdListener localNativeStrandAdListener = localInMobiNativeStrand.mNativeStrandAdListener;
      if (localNativeStrandAdListener == null)
      {
        Logger.a(Logger.InternalLogLevel.ERROR, InMobiNativeStrand.TAG, "InMobiNative Strand is already destroyed ! callback cannot be given");
        return;
      }
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        Logger.a(Logger.InternalLogLevel.INTERNAL, InMobiNativeStrand.TAG, "Unhandled ad lifecycle event! Ignoring ...");
        return;
      case 1: 
        localInMobiNativeStrand.mNativeStrandAdListener.onAdLoadSucceeded(localInMobiNativeStrand);
        return;
      case 2: 
        paramMessage = (InMobiAdRequestStatus)paramMessage.obj;
        localInMobiNativeStrand.mNativeStrandAdListener.onAdLoadFailed(localInMobiNativeStrand, paramMessage);
        return;
      case 7: 
        localNativeStrandAdListener.onAdImpressed(localInMobiNativeStrand);
        return;
      }
      localNativeStrandAdListener.onAdClicked(localInMobiNativeStrand);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiNativeStrand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */