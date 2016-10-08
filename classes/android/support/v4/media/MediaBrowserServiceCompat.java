package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  private static final boolean DBG = false;
  public static final String KEY_MEDIA_ITEM = "media_item";
  private static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  private static final String TAG = "MediaBrowserServiceCompat";
  private final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  private final ServiceHandler mHandler = new ServiceHandler(null);
  private MediaBrowserServiceImpl mImpl;
  MediaSessionCompat.Token mSession;
  
  private void addSubscription(String paramString, ConnectionRecord paramConnectionRecord, Bundle paramBundle)
  {
    Object localObject = (List)paramConnectionRecord.subscriptions.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)localIterator.next())) {
          return;
        }
      }
      ((List)localObject).add(paramBundle);
      paramConnectionRecord.subscriptions.put(paramString, localObject);
      performLoadChildren(paramString, paramConnectionRecord, paramBundle);
      return;
    }
  }
  
  private List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
    int m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    if ((i == -1) && (m == -1)) {
      return paramList;
    }
    int k = m * (i - 1);
    int j = k + m;
    if ((i < 1) || (m < 1) || (k >= paramList.size())) {
      return Collections.emptyList();
    }
    i = j;
    if (j > paramList.size()) {
      i = paramList.size();
    }
    return paramList.subList(k, i);
  }
  
  private boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (arrayOfString[paramInt].equals(paramString)) {
          return true;
        }
        paramInt += 1;
      }
    }
  }
  
  private void notifyChildrenChangedInternal(String paramString, Bundle paramBundle)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }
    this.mHandler.post(new MediaBrowserServiceCompat.2(this, paramString, paramBundle));
  }
  
  private void performLoadChildren(String paramString, ConnectionRecord paramConnectionRecord, Bundle paramBundle)
  {
    MediaBrowserServiceCompat.3 local3 = new MediaBrowserServiceCompat.3(this, paramString, paramConnectionRecord, paramString, paramBundle);
    if (paramBundle == null) {
      onLoadChildren(paramString, local3);
    }
    while (!local3.isDone())
    {
      throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramConnectionRecord.pkg + " id=" + paramString);
      onLoadChildren(paramString, local3, paramBundle);
    }
  }
  
  private void performLoadItem(String paramString, ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new MediaBrowserServiceCompat.4(this, paramString, paramResultReceiver);
    onLoadItem(paramString, paramResultReceiver);
    if (!paramResultReceiver.isDone()) {
      throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + paramString);
    }
  }
  
  private boolean removeSubscription(String paramString, ConnectionRecord paramConnectionRecord, Bundle paramBundle)
  {
    List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Bundle localBundle = (Bundle)localIterator.next();
        if (MediaBrowserCompatUtils.areSameOptions(paramBundle, localBundle)) {
          localList.remove(localBundle);
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (localList.size() == 0) {
          paramConnectionRecord.subscriptions.remove(paramString);
        }
        return bool;
      }
    }
    return false;
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @Nullable
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mSession;
  }
  
  public void notifyChildrenChanged(@NonNull String paramString)
  {
    notifyChildrenChangedInternal(paramString, null);
  }
  
  public void notifyChildrenChanged(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramBundle == null) {
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
    notifyChildrenChangedInternal(paramString, paramBundle);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mImpl.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 23) {
      this.mImpl = new MediaBrowserServiceImplApi23();
    }
    for (;;)
    {
      this.mImpl.onCreate();
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mImpl = new MediaBrowserServiceImplApi21();
      } else {
        this.mImpl = new MediaBrowserServiceImplBase();
      }
    }
  }
  
  @Nullable
  public abstract BrowserRoot onGetRoot(@NonNull String paramString, int paramInt, @Nullable Bundle paramBundle);
  
  public abstract void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult);
  
  public void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult, @NonNull Bundle paramBundle)
  {
    paramResult.setFlags(1);
    onLoadChildren(paramString, paramResult);
  }
  
  public void onLoadItem(String paramString, Result<MediaBrowserCompat.MediaItem> paramResult)
  {
    paramResult.sendResult(null);
  }
  
  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("Session token may not be null.");
    }
    if (this.mSession != null) {
      throw new IllegalStateException("The session token has already been set.");
    }
    this.mSession = paramToken;
    this.mHandler.post(new MediaBrowserServiceCompat.1(this, paramToken));
  }
  
  public static final class BrowserRoot
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    private final Bundle mExtras;
    private final String mRootId;
    
    public BrowserRoot(@NonNull String paramString, @Nullable Bundle paramBundle)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
      }
      this.mRootId = paramString;
      this.mExtras = paramBundle;
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public String getRootId()
    {
      return this.mRootId;
    }
  }
  
  private class ConnectionRecord
  {
    MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    String pkg;
    MediaBrowserServiceCompat.BrowserRoot root;
    Bundle rootHints;
    HashMap<String, List<Bundle>> subscriptions = new HashMap();
    
    private ConnectionRecord() {}
  }
  
  static abstract interface MediaBrowserServiceImpl
  {
    public abstract IBinder onBind(Intent paramIntent);
    
    public abstract void onCreate();
  }
  
  class MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Object mServiceObj;
    
    MediaBrowserServiceImplApi21() {}
    
    public IBinder onBind(Intent paramIntent)
    {
      return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, paramIntent);
    }
    
    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi21.createService();
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj, new MediaBrowserServiceCompat.ServiceImplApi21(MediaBrowserServiceCompat.this));
    }
  }
  
  class MediaBrowserServiceImplApi23
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Object mServiceObj;
    
    MediaBrowserServiceImplApi23() {}
    
    public IBinder onBind(Intent paramIntent)
    {
      return MediaBrowserServiceCompatApi23.onBind(this.mServiceObj, paramIntent);
    }
    
    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi23.createService();
      MediaBrowserServiceCompatApi23.onCreate(this.mServiceObj, new MediaBrowserServiceCompat.ServiceImplApi23(MediaBrowserServiceCompat.this, null));
    }
  }
  
  class MediaBrowserServiceImplBase
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Messenger mMessenger;
    
    MediaBrowserServiceImplBase() {}
    
    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction())) {
        return this.mMessenger.getBinder();
      }
      return null;
    }
    
    public void onCreate()
    {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
    }
  }
  
  public static class Result<T>
  {
    private Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendResultCalled;
    
    Result(Object paramObject)
    {
      this.mDebug = paramObject;
    }
    
    public void detach()
    {
      if (this.mDetachCalled) {
        throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
      }
      if (this.mSendResultCalled) {
        throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
      }
      this.mDetachCalled = true;
    }
    
    boolean isDone()
    {
      return (this.mDetachCalled) || (this.mSendResultCalled);
    }
    
    void onResultSent(T paramT, int paramInt) {}
    
    public void sendResult(T paramT)
    {
      if (this.mSendResultCalled) {
        throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
      }
      this.mSendResultCalled = true;
      onResultSent(paramT, this.mFlags);
    }
    
    void setFlags(int paramInt)
    {
      this.mFlags = paramInt;
    }
  }
  
  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();
    
    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
    
    public abstract void onConnectFailed();
    
    public abstract void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle);
  }
  
  private class ServiceCallbacksApi21
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final MediaBrowserServiceCompatApi21.ServiceCallbacks mCallbacks;
    Messenger mMessenger;
    
    ServiceCallbacksApi21(MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks)
    {
      this.mCallbacks = paramServiceCallbacks;
    }
    
    public IBinder asBinder()
    {
      return this.mCallbacks.asBinder();
    }
    
    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
      BundleCompat.putBinder(localBundle, "extra_messenger", this.mMessenger.getBinder());
      localBundle.putInt("extra_service_version", 1);
      this.mCallbacks.onConnect(paramString, paramToken.getToken(), localBundle);
    }
    
    public void onConnectFailed()
    {
      this.mCallbacks.onConnectFailed();
    }
    
    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
    {
      paramBundle = null;
      if (paramList != null)
      {
        paramBundle = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)paramList.next();
          Parcel localParcel = Parcel.obtain();
          localMediaItem.writeToParcel(localParcel, 0);
          paramBundle.add(localParcel);
        }
      }
      this.mCallbacks.onLoadChildren(paramString, paramBundle);
    }
  }
  
  private class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;
    
    ServiceCallbacksCompat(Messenger paramMessenger)
    {
      this.mCallbacks = paramMessenger;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      this.mCallbacks.send(localMessage);
    }
    
    public IBinder asBinder()
    {
      return this.mCallbacks.getBinder();
    }
    
    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 1);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }
    
    public void onConnectFailed()
    {
      sendRequest(2, null);
    }
    
    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle);
      if (paramList != null) {
        if (!(paramList instanceof ArrayList)) {
          break label57;
        }
      }
      label57:
      for (paramString = (ArrayList)paramList;; paramString = new ArrayList(paramList))
      {
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
        sendRequest(3, localBundle);
        return;
      }
    }
  }
  
  private final class ServiceHandler
    extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceImpl mServiceImpl = new MediaBrowserServiceCompat.ServiceImpl(MediaBrowserServiceCompat.this, null);
    
    private ServiceHandler() {}
    
    public MediaBrowserServiceCompat.ServiceImpl getServiceImpl()
    {
      return this.mServiceImpl;
    }
    
    public void handleMessage(Message paramMessage)
    {
      Bundle localBundle = paramMessage.getData();
      switch (paramMessage.what)
      {
      default: 
        Log.w("MediaBrowserServiceCompat", "Unhandled message: " + paramMessage + "\n  Service version: " + 1 + "\n  Client version: " + paramMessage.arg1);
        return;
      case 1: 
        this.mServiceImpl.connect(localBundle.getString("data_package_name"), localBundle.getInt("data_calling_uid"), localBundle.getBundle("data_root_hints"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 2: 
        this.mServiceImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 3: 
        this.mServiceImpl.addSubscription(localBundle.getString("data_media_item_id"), localBundle.getBundle("data_options"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 4: 
        this.mServiceImpl.removeSubscription(localBundle.getString("data_media_item_id"), localBundle.getBundle("data_options"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      case 5: 
        this.mServiceImpl.getMediaItem(localBundle.getString("data_media_item_id"), (ResultReceiver)localBundle.getParcelable("data_result_receiver"));
        return;
      case 6: 
        this.mServiceImpl.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
        return;
      }
      this.mServiceImpl.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(MediaBrowserServiceCompat.this, paramMessage.replyTo));
    }
    
    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }
    
    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
  
  private class ServiceImpl
  {
    private ServiceImpl() {}
    
    public void addSubscription(String paramString, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.3(this, paramServiceCallbacks, paramString, paramBundle));
    }
    
    public void connect(String paramString, int paramInt, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!MediaBrowserServiceCompat.this.isValidPackage(paramString, paramInt)) {
        throw new IllegalArgumentException("Package/uid mismatch: uid=" + paramInt + " package=" + paramString);
      }
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.1(this, paramServiceCallbacks, paramString, paramBundle, paramInt));
    }
    
    public void disconnect(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.2(this, paramServiceCallbacks));
    }
    
    public void getMediaItem(String paramString, ResultReceiver paramResultReceiver)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramResultReceiver == null)) {
        return;
      }
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.5(this, paramString, paramResultReceiver));
    }
    
    public void registerCallbacks(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.6(this, paramServiceCallbacks));
    }
    
    public void removeSubscription(String paramString, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.4(this, paramServiceCallbacks, paramString, paramBundle));
    }
    
    public void unregisterCallbacks(MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new MediaBrowserServiceCompat.ServiceImpl.7(this, paramServiceCallbacks));
    }
  }
  
  private class ServiceImplApi21
    implements MediaBrowserServiceCompatApi21.ServiceImplApi21
  {
    final MediaBrowserServiceCompat.ServiceImpl mServiceImpl = MediaBrowserServiceCompat.this.mHandler.getServiceImpl();
    
    ServiceImplApi21() {}
    
    public void addSubscription(String paramString, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks)
    {
      this.mServiceImpl.addSubscription(paramString, null, new MediaBrowserServiceCompat.ServiceCallbacksApi21(MediaBrowserServiceCompat.this, paramServiceCallbacks));
    }
    
    public void connect(String paramString, Bundle paramBundle, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks)
    {
      this.mServiceImpl.connect(paramString, Binder.getCallingUid(), paramBundle, new MediaBrowserServiceCompat.ServiceCallbacksApi21(MediaBrowserServiceCompat.this, paramServiceCallbacks));
    }
    
    public void disconnect(MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks)
    {
      this.mServiceImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksApi21(MediaBrowserServiceCompat.this, paramServiceCallbacks));
    }
    
    public void removeSubscription(String paramString, MediaBrowserServiceCompatApi21.ServiceCallbacks paramServiceCallbacks)
    {
      this.mServiceImpl.removeSubscription(paramString, null, new MediaBrowserServiceCompat.ServiceCallbacksApi21(MediaBrowserServiceCompat.this, paramServiceCallbacks));
    }
  }
  
  private class ServiceImplApi23
    extends MediaBrowserServiceCompat.ServiceImplApi21
    implements MediaBrowserServiceCompatApi23.ServiceImplApi23
  {
    private ServiceImplApi23()
    {
      super();
    }
    
    public void getMediaItem(String paramString, MediaBrowserServiceCompatApi23.ItemCallback paramItemCallback)
    {
      paramItemCallback = new MediaBrowserServiceCompat.ServiceImplApi23.1(this, MediaBrowserServiceCompat.this.mHandler, paramItemCallback);
      this.mServiceImpl.getMediaItem(paramString, paramItemCallback);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */