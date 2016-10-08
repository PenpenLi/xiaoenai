package com.inmobi.rendering.a;

import android.os.SystemClock;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@VisibleForTesting
public final class a
{
  int a;
  @VisibleForTesting
  public String b;
  @VisibleForTesting
  public Map<String, String> c;
  long d;
  long e;
  int f;
  AtomicBoolean g;
  boolean h;
  boolean i;
  
  public a(int paramInt1, String paramString, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, long paramLong1, long paramLong2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramMap;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt2;
    this.g = new AtomicBoolean(false);
    this.i = paramBoolean1;
    this.h = paramBoolean2;
  }
  
  public a(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, long paramLong1, long paramLong2)
  {
    this(paramInt1, paramString, new HashMap(), paramBoolean1, paramBoolean2, paramInt2, paramLong1, paramLong2);
  }
  
  public a(String paramString, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(new Random().nextInt() & 0x7FFFFFFF, paramString, paramMap, paramBoolean1, paramBoolean2, paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
  }
  
  public a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(new Random().nextInt() & 0x7FFFFFFF, paramString, new HashMap(), paramBoolean1, paramBoolean2, paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
  }
  
  public boolean a(long paramLong)
  {
    return SystemClock.elapsedRealtime() - this.e > 1000L * paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */