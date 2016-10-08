package org.cocos2dx.lib;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;
import com.chukong.cocosplay.client.CocosPlayClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Cocos2dxSound
{
  private static final int INVALID_SOUND_ID = -1;
  private static final int INVALID_STREAM_ID = -1;
  private static int LOAD_TIME_OUT = 500;
  private static final int MAX_SIMULTANEOUS_STREAMS_DEFAULT = 5;
  private static final int MAX_SIMULTANEOUS_STREAMS_I9100 = 3;
  private static final int SOUND_PRIORITY = 1;
  private static final int SOUND_QUALITY = 5;
  private static final float SOUND_RATE = 1.0F;
  private static final String TAG = "Cocos2dxSound";
  private final Context mContext;
  private float mLeftVolume;
  private final HashMap<String, Integer> mPathSoundIDMap = new HashMap();
  private final HashMap<String, ArrayList<Integer>> mPathStreamIDsMap = new HashMap();
  private ConcurrentHashMap<Integer, SoundInfoForLoadedCompleted> mPlayWhenLoadedEffects = new ConcurrentHashMap();
  private float mRightVolume;
  private SoundPool mSoundPool;
  
  public Cocos2dxSound(Context paramContext)
  {
    this.mContext = paramContext;
    initData();
  }
  
  private float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  private int doPlayEffect(String paramString, int paramInt, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.mLeftVolume;
    float f3 = clamp(paramFloat2, 0.0F, 1.0F);
    float f1 = this.mRightVolume;
    paramFloat2 = clamp(-paramFloat2, 0.0F, 1.0F);
    paramFloat1 = clamp(1.0F * paramFloat1, 0.5F, 2.0F);
    Object localObject = this.mSoundPool;
    f2 = clamp((1.0F - f3) * (f2 * paramFloat3), 0.0F, 1.0F);
    paramFloat2 = clamp(f1 * paramFloat3 * (1.0F - paramFloat2), 0.0F, 1.0F);
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      paramInt = ((SoundPool)localObject).play(paramInt, f2, paramFloat2, 1, i, paramFloat1);
      ArrayList localArrayList = (ArrayList)this.mPathStreamIDsMap.get(paramString);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        this.mPathStreamIDsMap.put(paramString, localObject);
      }
      ((ArrayList)localObject).add(Integer.valueOf(paramInt));
      return paramInt;
    }
  }
  
  private void initData()
  {
    if (Cocos2dxHelper.getDeviceModel().contains("GT-I9100")) {}
    for (this.mSoundPool = new SoundPool(3, 3, 5);; this.mSoundPool = new SoundPool(5, 3, 5))
    {
      this.mSoundPool.setOnLoadCompleteListener(new OnLoadCompletedListener());
      this.mLeftVolume = 0.5F;
      this.mRightVolume = 0.5F;
      return;
    }
  }
  
  public int createSoundIDFromAsset(String paramString)
  {
    int i;
    try
    {
      if (paramString.startsWith("/")) {
        i = this.mSoundPool.load(paramString, 0);
      } else {
        i = this.mSoundPool.load(this.mContext.getAssets().openFd(paramString), 0);
      }
    }
    catch (Exception paramString)
    {
      Log.e("Cocos2dxSound", "error: " + paramString.getMessage(), paramString);
      i = -1;
    }
    int j = i;
    if (i == 0) {
      j = -1;
    }
    return j;
  }
  
  public void end()
  {
    this.mSoundPool.release();
    this.mPathStreamIDsMap.clear();
    this.mPathSoundIDMap.clear();
    this.mPlayWhenLoadedEffects.clear();
    this.mLeftVolume = 0.5F;
    this.mRightVolume = 0.5F;
    initData();
  }
  
  public float getEffectsVolume()
  {
    return (this.mLeftVolume + this.mRightVolume) / 2.0F;
  }
  
  public void onEnterBackground()
  {
    this.mSoundPool.autoPause();
  }
  
  public void onEnterForeground()
  {
    this.mSoundPool.autoResume();
  }
  
  public void pauseAllEffects()
  {
    if (!this.mPathStreamIDsMap.isEmpty())
    {
      Iterator localIterator1 = this.mPathStreamIDsMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.mSoundPool.pause(i);
        }
      }
    }
  }
  
  public void pauseEffect(int paramInt)
  {
    this.mSoundPool.pause(paramInt);
  }
  
  public int playEffect(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Integer localInteger = (Integer)this.mPathSoundIDMap.get(paramString);
    if (localInteger != null) {
      return doPlayEffect(paramString, localInteger.intValue(), paramBoolean, paramFloat1, paramFloat2, paramFloat3);
    }
    localInteger = Integer.valueOf(preloadEffect(paramString));
    if (localInteger.intValue() == -1) {
      return -1;
    }
    paramString = new SoundInfoForLoadedCompleted(paramString, paramBoolean, paramFloat1, paramFloat2, paramFloat3);
    this.mPlayWhenLoadedEffects.putIfAbsent(localInteger, paramString);
    try
    {
      paramString.wait(LOAD_TIME_OUT);
      int i = paramString.effectID;
      this.mPlayWhenLoadedEffects.remove(localInteger);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public int preloadEffect(String paramString)
  {
    if ((CocosPlayClient.isEnabled()) && (!CocosPlayClient.isDemo())) {
      CocosPlayClient.updateAssets(paramString);
    }
    CocosPlayClient.notifyFileLoaded(paramString);
    Integer localInteger2 = (Integer)this.mPathSoundIDMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger2 = Integer.valueOf(createSoundIDFromAsset(paramString));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != -1)
      {
        this.mPathSoundIDMap.put(paramString, localInteger2);
        localInteger1 = localInteger2;
      }
    }
    return localInteger1.intValue();
  }
  
  public void resumeAllEffects()
  {
    if (!this.mPathStreamIDsMap.isEmpty())
    {
      Iterator localIterator1 = this.mPathStreamIDsMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.mSoundPool.resume(i);
        }
      }
    }
  }
  
  public void resumeEffect(int paramInt)
  {
    this.mSoundPool.resume(paramInt);
  }
  
  public void setEffectsVolume(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.mRightVolume = paramFloat;
        this.mLeftVolume = paramFloat;
        if (!this.mPathStreamIDsMap.isEmpty())
        {
          Iterator localIterator1 = this.mPathStreamIDsMap.entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
            while (localIterator2.hasNext())
            {
              int i = ((Integer)localIterator2.next()).intValue();
              this.mSoundPool.setVolume(i, this.mLeftVolume, this.mRightVolume);
            }
          }
        }
        return;
      }
    }
  }
  
  public void stopAllEffects()
  {
    if (!this.mPathStreamIDsMap.isEmpty())
    {
      Iterator localIterator1 = this.mPathStreamIDsMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          int i = ((Integer)localIterator2.next()).intValue();
          this.mSoundPool.stop(i);
        }
      }
    }
    this.mPathStreamIDsMap.clear();
  }
  
  public void stopEffect(int paramInt)
  {
    this.mSoundPool.stop(paramInt);
    Iterator localIterator = this.mPathStreamIDsMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((ArrayList)this.mPathStreamIDsMap.get(str)).contains(Integer.valueOf(paramInt))) {
        ((ArrayList)this.mPathStreamIDsMap.get(str)).remove(((ArrayList)this.mPathStreamIDsMap.get(str)).indexOf(Integer.valueOf(paramInt)));
      }
    }
  }
  
  public void unloadEffect(String paramString)
  {
    Object localObject = (ArrayList)this.mPathStreamIDsMap.get(paramString);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        this.mSoundPool.stop(localInteger.intValue());
      }
    }
    this.mPathStreamIDsMap.remove(paramString);
    localObject = (Integer)this.mPathSoundIDMap.get(paramString);
    if (localObject != null)
    {
      this.mSoundPool.unload(((Integer)localObject).intValue());
      this.mPathSoundIDMap.remove(paramString);
    }
  }
  
  public class OnLoadCompletedListener
    implements SoundPool.OnLoadCompleteListener
  {
    public OnLoadCompletedListener() {}
    
    public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0)
      {
        paramSoundPool = (Cocos2dxSound.SoundInfoForLoadedCompleted)Cocos2dxSound.this.mPlayWhenLoadedEffects.get(Integer.valueOf(paramInt1));
        if (paramSoundPool != null)
        {
          paramSoundPool.effectID = Cocos2dxSound.this.doPlayEffect(paramSoundPool.path, paramInt1, paramSoundPool.isLoop, paramSoundPool.pitch, paramSoundPool.pan, paramSoundPool.gain);
          try
          {
            paramSoundPool.notifyAll();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public class SoundInfoForLoadedCompleted
  {
    public int effectID;
    public float gain;
    public boolean isLoop;
    public float pan;
    public String path;
    public float pitch;
    
    public SoundInfoForLoadedCompleted(String paramString, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.path = paramString;
      this.isLoop = paramBoolean;
      this.pitch = paramFloat1;
      this.pan = paramFloat2;
      this.gain = paramFloat3;
      this.effectID = -1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxSound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */