package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class InMobiInterstitial
{
  private static final String TAG = InMobiInterstitial.class.getSimpleName();
  private a mClientCallbackHandler;
  private Context mContext;
  private Map<String, String> mExtras;
  private final AdUnit.a mInterstitialAdListener = new InMobiInterstitial.1(this);
  private o mInterstitialAdUnit;
  private boolean mIsHardwareAccelerationDisabled;
  private boolean mIsInitialized = false;
  private String mKeywords;
  private InterstitialAdListener mListener;
  private long mPlacementId;
  
  public InMobiInterstitial(Context paramContext, long paramLong, InterstitialAdListener paramInterstitialAdListener)
  {
    if (!a.a())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
      return;
    }
    if (paramInterstitialAdListener == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
      return;
    }
    if (paramContext == null)
    {
      Logger.a(Logger.InternalLogLevel.ERROR, TAG, "Unable to create ad unit with NULL context object.");
      return;
    }
    this.mIsInitialized = true;
    this.mContext = paramContext;
    this.mPlacementId = paramLong;
    this.mListener = paramInterstitialAdListener;
    this.mClientCallbackHandler = new a(this, this.mListener);
  }
  
  private ak getPlacementObj()
  {
    ak localak = new ak(this.mPlacementId, i.a(this.mExtras));
    localak.a(this.mKeywords);
    localak.a(this.mExtras);
    return localak;
  }
  
  private void setupAdUnit()
  {
    this.mInterstitialAdUnit.a(this.mExtras);
    this.mInterstitialAdUnit.a(this.mKeywords);
    if (this.mIsHardwareAccelerationDisabled) {
      this.mInterstitialAdUnit.A();
    }
  }
  
  public void disableHardwareAcceleration()
  {
    if (this.mIsInitialized) {
      this.mIsHardwareAccelerationDisabled = true;
    }
  }
  
  public boolean isReady()
  {
    if ((!this.mIsInitialized) || (this.mInterstitialAdUnit == null)) {
      return false;
    }
    return this.mInterstitialAdUnit.z();
  }
  
  public void load()
  {
    if (this.mIsInitialized)
    {
      AdUnit localAdUnit = i.a().a(getPlacementObj());
      this.mClientCallbackHandler.a();
      if (localAdUnit == null) {
        break label75;
      }
      this.mInterstitialAdUnit = ((o)localAdUnit);
      this.mInterstitialAdUnit.a(this.mInterstitialAdListener);
      setupAdUnit();
      if (this.mInterstitialAdUnit.g() == AdUnit.AdState.STATE_READY) {
        this.mInterstitialAdListener.a();
      }
    }
    return;
    label75:
    this.mInterstitialAdUnit = new o(this.mContext, this.mPlacementId, this.mInterstitialAdListener);
    setupAdUnit();
    this.mInterstitialAdUnit.o();
  }
  
  public void setExtras(Map<String, String> paramMap)
  {
    if (this.mIsInitialized) {
      this.mExtras = paramMap;
    }
  }
  
  public void setKeywords(String paramString)
  {
    if (this.mIsInitialized) {
      this.mKeywords = paramString;
    }
  }
  
  public void show()
  {
    if ((this.mIsInitialized) && (this.mInterstitialAdUnit != null)) {
      this.mInterstitialAdUnit.x();
    }
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    if ((this.mIsInitialized) && (this.mInterstitialAdUnit != null)) {
      this.mInterstitialAdUnit.a(paramInt1, paramInt2);
    }
  }
  
  public static abstract interface InterstitialAdListener
  {
    public abstract void onAdDismissed(InMobiInterstitial paramInMobiInterstitial);
    
    public abstract void onAdDisplayed(InMobiInterstitial paramInMobiInterstitial);
    
    public abstract void onAdInteraction(InMobiInterstitial paramInMobiInterstitial, Map<Object, Object> paramMap);
    
    public abstract void onAdLoadFailed(InMobiInterstitial paramInMobiInterstitial, InMobiAdRequestStatus paramInMobiAdRequestStatus);
    
    public abstract void onAdLoadSucceeded(InMobiInterstitial paramInMobiInterstitial);
    
    public abstract void onAdRewardActionCompleted(InMobiInterstitial paramInMobiInterstitial, Map<Object, Object> paramMap);
    
    public abstract void onUserLeftApplication(InMobiInterstitial paramInMobiInterstitial);
  }
  
  private static final class a
    extends Handler
  {
    private WeakReference<InMobiInterstitial.InterstitialAdListener> a;
    private WeakReference<InMobiInterstitial> b;
    private boolean c = false;
    
    public a(InMobiInterstitial paramInMobiInterstitial, InMobiInterstitial.InterstitialAdListener paramInterstitialAdListener)
    {
      super();
      this.b = new WeakReference(paramInMobiInterstitial);
      this.a = new WeakReference(paramInterstitialAdListener);
    }
    
    public void a()
    {
      this.c = false;
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      InMobiInterstitial localInMobiInterstitial = (InMobiInterstitial)this.b.get();
      InMobiInterstitial.InterstitialAdListener localInterstitialAdListener = (InMobiInterstitial.InterstitialAdListener)this.a.get();
      if ((localInMobiInterstitial != null) && (localInterstitialAdListener != null)) {}
      switch (paramMessage.what)
      {
      default: 
        Logger.a(Logger.InternalLogLevel.INTERNAL, InMobiInterstitial.TAG, "Unhandled ad lifecycle event! Ignoring ...");
      case 1: 
        do
        {
          return;
        } while (this.c);
        this.c = true;
        localInterstitialAdListener.onAdLoadSucceeded(localInMobiInterstitial);
        return;
      case 2: 
        localInterstitialAdListener.onAdLoadFailed(localInMobiInterstitial, (InMobiAdRequestStatus)paramMessage.obj);
        return;
      case 3: 
        localInterstitialAdListener.onAdDisplayed(localInMobiInterstitial);
        return;
      case 4: 
        localInterstitialAdListener.onAdDismissed(localInMobiInterstitial);
        return;
      case 5: 
        if (paramMessage.obj != null) {
          localObject1 = (Map)paramMessage.obj;
        }
        localInterstitialAdListener.onAdInteraction(localInMobiInterstitial, (Map)localObject1);
        return;
      case 6: 
        localInterstitialAdListener.onUserLeftApplication(localInMobiInterstitial);
        return;
      }
      localObject1 = localObject2;
      if (paramMessage.obj != null) {
        localObject1 = (Map)paramMessage.obj;
      }
      localInterstitialAdListener.onAdRewardActionCompleted(localInMobiInterstitial, (Map)localObject1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */