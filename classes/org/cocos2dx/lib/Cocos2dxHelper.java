package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.Vibrator;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.a.a.a;
import com.chukong.cocosplay.client.CocosPlayClient;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Cocos2dxHelper
{
  private static final int BOOST_TIME = 7;
  private static final String PREFS_NAME = "Cocos2dxPrefsFile";
  private static final int RUNNABLES_PER_FRAME = 5;
  private static ServiceConnection connection = new Cocos2dxHelper.1();
  private static a mGameServiceBinder;
  private static Set<PreferenceManager.OnActivityResultListener> onActivityResultListeners;
  private static boolean sAccelerometerEnabled;
  private static Activity sActivity = null;
  private static boolean sActivityVisible;
  private static AssetManager sAssetManager;
  private static Cocos2dxMusic sCocos2dMusic;
  private static Cocos2dxSound sCocos2dSound;
  private static Cocos2dxAccelerometer sCocos2dxAccelerometer;
  private static Cocos2dxHelperListener sCocos2dxHelperListener;
  private static String sFileDirectory;
  private static boolean sInited;
  private static String sPackageName;
  private static Vibrator sVibrateService;
  
  static
  {
    onActivityResultListeners = new LinkedHashSet();
    sVibrateService = null;
    mGameServiceBinder = null;
    sInited = false;
  }
  
  public static void addOnActivityResultListener(PreferenceManager.OnActivityResultListener paramOnActivityResultListener)
  {
    onActivityResultListeners.add(paramOnActivityResultListener);
  }
  
  public static byte[] conversionEncoding(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString1).getBytes(paramString2);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static void deleteValueForKey(String paramString)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }
  
  public static void disableAccelerometer()
  {
    sAccelerometerEnabled = false;
    sCocos2dxAccelerometer.disable();
  }
  
  public static void enableAccelerometer()
  {
    sAccelerometerEnabled = true;
    sCocos2dxAccelerometer.enable();
  }
  
  public static void end()
  {
    sCocos2dMusic.end();
    sCocos2dSound.end();
  }
  
  public static int fastLoading(int paramInt)
  {
    int i = -1;
    try
    {
      if (mGameServiceBinder != null) {
        i = mGameServiceBinder.c(paramInt);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static Activity getActivity()
  {
    return sActivity;
  }
  
  public static AssetManager getAssetManager()
  {
    return sAssetManager;
  }
  
  public static float getBackgroundMusicVolume()
  {
    return sCocos2dMusic.getBackgroundVolume();
  }
  
  public static boolean getBoolForKey(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0);
    try
    {
      paramBoolean = localSharedPreferences.getBoolean(paramString, paramBoolean);
      return paramBoolean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramString = localSharedPreferences.getAll().get(paramString);
      if ((paramString instanceof String)) {
        return Boolean.parseBoolean(paramString.toString());
      }
      if ((paramString instanceof Integer)) {
        return ((Integer)paramString).intValue() != 0;
      }
      if ((paramString instanceof Float))
      {
        if (((Float)paramString).floatValue() != 0.0F) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    }
    return false;
  }
  
  public static String getCocos2dxPackageName()
  {
    return sPackageName;
  }
  
  public static String getCocos2dxWritablePath()
  {
    return sFileDirectory;
  }
  
  public static String getCurrentLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static int getDPI()
  {
    if (sActivity != null)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      Object localObject = sActivity.getWindowManager();
      if (localObject != null)
      {
        localObject = ((WindowManager)localObject).getDefaultDisplay();
        if (localObject != null)
        {
          ((Display)localObject).getMetrics(localDisplayMetrics);
          return (int)(localDisplayMetrics.density * 160.0F);
        }
      }
    }
    return -1;
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static double getDoubleForKey(String paramString, double paramDouble)
  {
    return getFloatForKey(paramString, (float)paramDouble);
  }
  
  public static float getEffectsVolume()
  {
    return sCocos2dSound.getEffectsVolume();
  }
  
  public static float getFloatForKey(String paramString, float paramFloat)
  {
    SharedPreferences localSharedPreferences = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0);
    try
    {
      paramFloat = localSharedPreferences.getFloat(paramString, paramFloat);
      return paramFloat;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramString = localSharedPreferences.getAll().get(paramString);
      if ((paramString instanceof String)) {
        return Float.parseFloat(paramString.toString());
      }
      if ((paramString instanceof Integer)) {
        return ((Integer)paramString).floatValue();
      }
      if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
        return 1.0F;
      }
    }
    return 0.0F;
  }
  
  public static int getIntegerForKey(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0);
    try
    {
      paramInt = localSharedPreferences.getInt(paramString, paramInt);
      return paramInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramString = localSharedPreferences.getAll().get(paramString);
      if ((paramString instanceof String)) {
        return Integer.parseInt(paramString.toString());
      }
      if ((paramString instanceof Float)) {
        return ((Float)paramString).intValue();
      }
      if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue())) {
        return 1;
      }
    }
    return 0;
  }
  
  public static Set<PreferenceManager.OnActivityResultListener> getOnActivityResultListeners()
  {
    return onActivityResultListeners;
  }
  
  public static String getStringForKey(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0);
    try
    {
      paramString2 = localSharedPreferences.getString(paramString1, paramString2);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return localSharedPreferences.getAll().get(paramString1).toString();
  }
  
  public static int getTemperature()
  {
    int i = -1;
    try
    {
      if (mGameServiceBinder != null) {
        i = mGameServiceBinder.a();
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static String getVersion()
  {
    try
    {
      String str = Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(Cocos2dxActivity.getContext().getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static void init(Activity paramActivity)
  {
    sActivity = paramActivity;
    sCocos2dxHelperListener = (Cocos2dxHelperListener)paramActivity;
    Object localObject;
    if (!sInited)
    {
      localObject = paramActivity.getApplicationInfo();
      sPackageName = ((ApplicationInfo)localObject).packageName;
      if ((!CocosPlayClient.isEnabled()) || (CocosPlayClient.isDemo())) {
        break label157;
      }
    }
    label157:
    for (sFileDirectory = CocosPlayClient.getGameRoot();; sFileDirectory = paramActivity.getFilesDir().getAbsolutePath())
    {
      nativeSetApkPath(((ApplicationInfo)localObject).sourceDir);
      sCocos2dxAccelerometer = new Cocos2dxAccelerometer(paramActivity);
      sCocos2dMusic = new Cocos2dxMusic(paramActivity);
      sCocos2dSound = new Cocos2dxSound(paramActivity);
      sAssetManager = paramActivity.getAssets();
      nativeSetContext(paramActivity, sAssetManager);
      Cocos2dxBitmap.setContext(paramActivity);
      sVibrateService = (Vibrator)paramActivity.getSystemService("vibrator");
      sInited = true;
      localObject = new Intent(a.class.getName());
      ((Intent)localObject).setPackage("com.enhance.gameservice");
      paramActivity.getApplicationContext().bindService((Intent)localObject, connection, 1);
      return;
    }
  }
  
  public static boolean isActivityVisible()
  {
    return sActivityVisible;
  }
  
  public static boolean isBackgroundMusicPlaying()
  {
    return sCocos2dMusic.isBackgroundMusicPlaying();
  }
  
  private static native void nativeSetApkPath(String paramString);
  
  private static native void nativeSetContext(Context paramContext, AssetManager paramAssetManager);
  
  private static native void nativeSetEditTextDialogResult(byte[] paramArrayOfByte);
  
  public static void onEnterBackground()
  {
    sCocos2dSound.onEnterBackground();
    sCocos2dMusic.onEnterBackground();
  }
  
  public static void onEnterForeground()
  {
    sCocos2dSound.onEnterForeground();
    sCocos2dMusic.onEnterForeground();
  }
  
  public static void onPause()
  {
    sActivityVisible = false;
    if (sAccelerometerEnabled) {
      sCocos2dxAccelerometer.disable();
    }
  }
  
  public static void onResume()
  {
    sActivityVisible = true;
    if (sAccelerometerEnabled) {
      sCocos2dxAccelerometer.enable();
    }
  }
  
  public static boolean openURL(String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      sActivity.startActivity(localIntent);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void pauseAllEffects()
  {
    sCocos2dSound.pauseAllEffects();
  }
  
  public static void pauseBackgroundMusic()
  {
    sCocos2dMusic.pauseBackgroundMusic();
  }
  
  public static void pauseEffect(int paramInt)
  {
    sCocos2dSound.pauseEffect(paramInt);
  }
  
  public static void playBackgroundMusic(String paramString, boolean paramBoolean)
  {
    sCocos2dMusic.playBackgroundMusic(paramString, paramBoolean);
  }
  
  public static int playEffect(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return sCocos2dSound.playEffect(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void preloadBackgroundMusic(String paramString)
  {
    sCocos2dMusic.preloadBackgroundMusic(paramString);
  }
  
  public static void preloadEffect(String paramString)
  {
    sCocos2dSound.preloadEffect(paramString);
  }
  
  public static void resumeAllEffects()
  {
    sCocos2dSound.resumeAllEffects();
  }
  
  public static void resumeBackgroundMusic()
  {
    sCocos2dMusic.resumeBackgroundMusic();
  }
  
  public static void resumeEffect(int paramInt)
  {
    sCocos2dSound.resumeEffect(paramInt);
  }
  
  public static void rewindBackgroundMusic()
  {
    sCocos2dMusic.rewindBackgroundMusic();
  }
  
  public static void runOnGLThread(Runnable paramRunnable)
  {
    ((Cocos2dxActivity)sActivity).runOnGLThread(paramRunnable);
  }
  
  public static void setAccelerometerInterval(float paramFloat)
  {
    sCocos2dxAccelerometer.setInterval(paramFloat);
  }
  
  public static void setBackgroundMusicVolume(float paramFloat)
  {
    sCocos2dMusic.setBackgroundVolume(paramFloat);
  }
  
  public static void setBoolForKey(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static void setDoubleForKey(String paramString, double paramDouble)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.putFloat(paramString, (float)paramDouble);
    localEditor.commit();
  }
  
  public static void setEditTextDialogResult(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF8");
      sCocos2dxHelperListener.runOnGLThread(new Cocos2dxHelper.2(paramString));
      return;
    }
    catch (UnsupportedEncodingException paramString) {}
  }
  
  public static void setEffectsVolume(float paramFloat)
  {
    sCocos2dSound.setEffectsVolume(paramFloat);
  }
  
  public static int setFPS(int paramInt)
  {
    int i = -1;
    try
    {
      if (mGameServiceBinder != null) {
        i = mGameServiceBinder.b(paramInt);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static void setFloatForKey(String paramString, float paramFloat)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.commit();
  }
  
  public static void setIntegerForKey(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static void setKeepScreenOn(boolean paramBoolean)
  {
    ((Cocos2dxActivity)sActivity).setKeepScreenOn(paramBoolean);
  }
  
  public static int setLowPowerMode(boolean paramBoolean)
  {
    int i = -1;
    try
    {
      if (mGameServiceBinder != null) {
        i = mGameServiceBinder.a(paramBoolean);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static int setResolutionPercent(int paramInt)
  {
    int i = -1;
    try
    {
      if (mGameServiceBinder != null) {
        i = mGameServiceBinder.a(paramInt);
      }
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static void setStringForKey(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = sActivity.getSharedPreferences("Cocos2dxPrefsFile", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private static void showDialog(String paramString1, String paramString2)
  {
    sCocos2dxHelperListener.showDialog(paramString1, paramString2);
  }
  
  public static void stopAllEffects()
  {
    sCocos2dSound.stopAllEffects();
  }
  
  public static void stopBackgroundMusic()
  {
    sCocos2dMusic.stopBackgroundMusic();
  }
  
  public static void stopEffect(int paramInt)
  {
    sCocos2dSound.stopEffect(paramInt);
  }
  
  public static void terminateProcess()
  {
    Process.killProcess(Process.myPid());
  }
  
  public static void unloadEffect(String paramString)
  {
    sCocos2dSound.unloadEffect(paramString);
  }
  
  public static void vibrate(float paramFloat)
  {
    sVibrateService.vibrate((1000.0F * paramFloat));
  }
  
  public static abstract interface Cocos2dxHelperListener
  {
    public abstract void runOnGLThread(Runnable paramRunnable);
    
    public abstract void showDialog(String paramString1, String paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */