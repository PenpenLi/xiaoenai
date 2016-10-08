package com.xiaoenai.app.utils.h;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.SparseIntArray;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.as;
import java.io.File;

public class a
{
  private static volatile a b = null;
  private Vibrator a;
  private SoundPool[] c = new SoundPool[2];
  private SparseIntArray[] d = new SparseIntArray[2];
  private SparseIntArray e = new SparseIntArray();
  private MediaPlayer f = null;
  
  private a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.c[0] = a(5);
      this.d[0] = new SparseIntArray();
      this.d[0].put(2, this.c[0].load(Xiaoenai.j(), 2131034117, 1));
      this.d[0].put(3, this.c[0].load(Xiaoenai.j(), 2131034118, 1));
      this.d[0].put(4, this.c[0].load(Xiaoenai.j(), 2131034120, 1));
      if (Build.VERSION.SDK_INT < 21) {
        break label299;
      }
      this.c[1] = a(3);
    }
    for (;;)
    {
      this.d[1] = new SparseIntArray();
      this.d[1].put(2, this.c[1].load(Xiaoenai.j(), 2131034117, 1));
      this.d[1].put(3, this.c[1].load(Xiaoenai.j(), 2131034118, 1));
      this.d[1].put(4, this.c[1].load(Xiaoenai.j(), 2131034120, 1));
      this.a = ((Vibrator)Xiaoenai.j().getSystemService("vibrator"));
      try
      {
        this.f = new MediaPlayer();
        this.f.setAudioStreamType(5);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.c[0] = b(5);
      break;
      label299:
      this.c[1] = b(3);
    }
  }
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  @TargetApi(21)
  protected SoundPool a(int paramInt)
  {
    AudioAttributes localAudioAttributes = new AudioAttributes.Builder().setUsage(10).setContentType(2).setLegacyStreamType(paramInt).build();
    return new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(localAudioAttributes).build();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.f.reset();
        if (!Xiaoenai.j().o())
        {
          this.f.setAudioStreamType(5);
          if (paramString.equals("alarm_default"))
          {
            paramString = Xiaoenai.j().getResources().openRawResourceFd(2131034113);
            this.f.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
            paramString.close();
            this.f.prepare();
            this.f.setLooping(paramBoolean);
            this.f.setOnPreparedListener(new b(this));
          }
        }
        else
        {
          this.f.setAudioStreamType(3);
          continue;
        }
        if (!new File(paramString).exists()) {
          break label141;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.f.setDataSource(paramString);
      continue;
      label141:
      paramString = Xiaoenai.j().getResources().openRawResourceFd(2131034113);
      this.f.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
    }
  }
  
  protected SoundPool b(int paramInt)
  {
    return new SoundPool(1, paramInt, 0);
  }
  
  public boolean b()
  {
    return (this.f != null) && (this.f.isPlaying());
  }
  
  public void c(int paramInt)
  {
    float f1 = 1.0F;
    AudioManager localAudioManager = (AudioManager)Xiaoenai.j().getSystemService("audio");
    float f2 = localAudioManager.getStreamVolume(5);
    float f3 = localAudioManager.getStreamMaxVolume(5);
    if (f3 > 0.0F) {
      f1 = f2 / f3;
    }
    com.xiaoenai.app.utils.f.a.c("streamVolume = {}", new Object[] { Float.valueOf(f1) });
    int i;
    try
    {
      if (this.e.get(paramInt) != 0)
      {
        this.c[0].stop(this.e.get(paramInt));
        this.c[1].stop(this.e.get(paramInt));
      }
      if (paramInt == 4)
      {
        if (!Xiaoenai.j().o()) {}
        for (i = this.c[0].play(this.d[0].get(4), f1, f1, 1, 0, 1.0F);; i = this.c[1].play(this.d[1].get(4), f1, f1, 1, 0, 1.0F))
        {
          this.e.put(paramInt, i);
          return;
        }
      }
      if (UserConfig.getBoolean("setting_vibrate", Boolean.valueOf(true)).booleanValue()) {
        this.a.vibrate(new long[] { 200L, 150L, 100L, 80L }, -1);
      }
      if (paramInt == 1)
      {
        a(UserConfig.getString("clock_alarm_path", "alarm_default"), true);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (UserConfig.getBoolean("setting_sound", Boolean.valueOf(true)).booleanValue())
    {
      if ((as.d()) || (!as.g()))
      {
        if (!Xiaoenai.j().o()) {}
        for (i = this.c[0].play(this.d[0].get(3), f1, f1, 1, 0, 1.0F);; i = this.c[1].play(this.d[1].get(3), f1, f1, 1, 0, 1.0F))
        {
          this.e.put(paramInt, i);
          return;
        }
      }
      if (!Xiaoenai.j().o()) {}
      for (i = this.c[0].play(this.d[0].get(paramInt), f1, f1, 1, 0, 1.0F);; i = this.c[1].play(this.d[1].get(paramInt), f1, f1, 1, 0, 1.0F))
      {
        this.e.put(paramInt, i);
        return;
      }
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      if (this.e.get(paramInt) != 0)
      {
        this.c[0].stop(this.e.get(paramInt));
        this.c[1].stop(this.e.get(paramInt));
      }
      if (this.f != null)
      {
        if (this.f.isPlaying()) {
          this.f.stop();
        }
        this.f.reset();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */