package com.xiaoenai.app.utils.h;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import java.io.IOException;

public class c
{
  private static c d = null;
  private volatile MediaPlayer a = null;
  private AudioManager b;
  private o c;
  private a e;
  
  public c()
  {
    this.a.setAudioStreamType(3);
    this.b = ((AudioManager)Xiaoenai.j().getSystemService("audio"));
  }
  
  private void a(int paramInt)
  {
    this.a.setOnCompletionListener(new d(this));
    this.a.setOnErrorListener(new e(this));
    this.a.setOnPreparedListener(new f(this, paramInt));
  }
  
  private void h()
  {
    a();
  }
  
  public void a()
  {
    if (this.a.isPlaying()) {
      this.a.stop();
    }
    if (this.e != null) {
      this.e.c(this.c);
    }
    for (;;)
    {
      this.c = null;
      return;
      com.xiaoenai.app.utils.f.a.c("voice player listener null pointer.", new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      this.a = new MediaPlayer();
    }
    this.a.reset();
    this.a.setAudioStreamType(paramInt2);
    try
    {
      if (this.c == null) {
        throw new NullPointerException("Voice Message is null.");
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    com.xiaoenai.app.utils.f.a.c("================= getVoicePath: {}", new Object[] { this.c.u() });
    this.a.setDataSource(this.c.u());
    this.a.prepareAsync();
    if (this.e != null) {
      this.e.b(this.c);
    }
    a(paramInt1);
  }
  
  public void a(o paramo, a parama, boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.h() == paramo.h()))
    {
      a();
      com.xiaoenai.app.utils.f.a.c("voice stop", new Object[0]);
      return;
    }
    h();
    com.xiaoenai.app.utils.f.a.c("voice play", new Object[0]);
    this.c = paramo;
    this.e = parama;
    if (paramBoolean)
    {
      com.xiaoenai.app.utils.f.a.c("================== playByStreamMusic {}", new Object[] { Boolean.valueOf(Xiaoenai.j().o()) });
      this.b.setSpeakerphoneOn(true);
      b(0, 3);
      return;
    }
    this.b.setSpeakerphoneOn(false);
    com.xiaoenai.app.utils.f.a.c("================== playByHeadSet {}", new Object[] { Boolean.valueOf(Xiaoenai.j().o()) });
    if (!Xiaoenai.j().o())
    {
      b(2, 0);
      return;
    }
    b(0, 3);
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.stop();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.setMode(0);
      this.b.setSpeakerphoneOn(true);
    }
    b(0, 3);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    if (this.a != null)
    {
      this.a.stop();
      this.a = null;
    }
    this.b.setSpeakerphoneOn(false);
    b(2, 0);
  }
  
  public void d()
  {
    this.b.setMode(0);
    a.a().c(4);
  }
  
  public void e()
  {
    if (this.a != null)
    {
      if (this.a.isPlaying()) {
        this.a.stop();
      }
      this.a.release();
      this.a = null;
      this.c = null;
    }
  }
  
  public com.xiaoenai.app.classes.chat.messagelist.message.a.a f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.isPlaying();
  }
  
  public static abstract interface a
  {
    public abstract void a(o paramo, int paramInt);
    
    public abstract void a(o paramo, int paramInt1, int paramInt2);
    
    public abstract void b(o paramo);
    
    public abstract void c(o paramo);
    
    public abstract void d(o paramo);
    
    public abstract void e(o paramo);
    
    public abstract void f(o paramo);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */