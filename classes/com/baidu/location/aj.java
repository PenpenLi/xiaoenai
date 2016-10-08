package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;

public class aj
  implements ax, n
{
  public static final float hA = 4.0F;
  public static final float hj = 0.01F;
  private static final int hs = 6;
  private static final int hu = 20;
  private static final float hz = 0.8F;
  private int hB = 0;
  private SensorManager hC;
  private boolean hD;
  private int he;
  private int hf = 440;
  private int hg = 1;
  private final long hh = 30L;
  private float[] hi = new float[3];
  private int hk = 0;
  private double hl = 1.6D;
  private double[] hm = new double[6];
  public SensorEventListener hn = new aj.1(this);
  private int ho = 0;
  private long hp = 0L;
  Timer hq;
  private int hr;
  private Sensor ht;
  private float[] hv = { 0.0F, 0.0F, 0.0F };
  private volatile int hw = 0;
  private int hx = 31;
  private double[] hy = new double[this.hx];
  
  public aj(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  private aj(Context paramContext, int paramInt)
  {
    try
    {
      this.hC = ((SensorManager)paramContext.getSystemService("sensor"));
      this.hr = paramInt;
      this.ht = this.hC.getDefaultSensor(1);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void bG()
  {
    if (this.he < 20) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      float[] arrayOfFloat = new float[3];
      System.arraycopy(this.hv, 0, arrayOfFloat, 0, 3);
      float f1 = arrayOfFloat[0];
      float f2 = arrayOfFloat[0];
      float f3 = arrayOfFloat[1];
      float f4 = arrayOfFloat[1];
      float f5 = arrayOfFloat[2];
      double d = Math.sqrt(arrayOfFloat[2] * f5 + (f1 * f2 + f3 * f4));
      this.hy[this.hB] = d;
      jdMethod_do(d);
      this.hB += 1;
      if (this.hB == this.hx)
      {
        this.hB = 0;
        d = jdMethod_if(this.hy);
        if ((this.hw != 0) || (d >= 0.3D)) {
          break label203;
        }
        jdMethod_case(0);
      }
      for (this.hw = 0; (l - this.hp > this.hf) && (jdMethod_if(this.hl)); this.hw = 1)
      {
        this.hk += 1;
        this.hp = l;
        return;
        label203:
        jdMethod_case(1);
      }
    }
  }
  
  private void jdMethod_case(int paramInt)
  {
    try
    {
      this.hg |= paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void jdMethod_do(double paramDouble)
  {
    this.hm[(this.ho % 6)] = paramDouble;
    this.ho += 1;
    this.ho %= 6;
  }
  
  private double jdMethod_if(double[] paramArrayOfDouble)
  {
    int j = 0;
    double d2 = 0.0D;
    int k = paramArrayOfDouble.length;
    int i = 0;
    double d1 = 0.0D;
    while (i < k)
    {
      d1 += paramArrayOfDouble[i];
      i += 1;
    }
    double d3 = d1 / k;
    d1 = d2;
    i = j;
    while (i < k)
    {
      d1 += (paramArrayOfDouble[i] - d3) * (paramArrayOfDouble[i] - d3);
      i += 1;
    }
    return d1 / (k - 1);
  }
  
  private boolean jdMethod_if(double paramDouble)
  {
    int i = 1;
    while (i <= 5)
    {
      if (this.hm[((this.ho - 1 - i + 6 + 6) % 6)] - this.hm[((this.ho - 1 + 6) % 6)] > paramDouble) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private float[] jdMethod_if(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.hi[0] = (this.hi[0] * 0.8F + 0.19999999F * paramFloat1);
    this.hi[1] = (this.hi[1] * 0.8F + 0.19999999F * paramFloat2);
    this.hi[2] = (this.hi[2] * 0.8F + 0.19999999F * paramFloat3);
    return new float[] { paramFloat1 - this.hi[0], paramFloat2 - this.hi[1], paramFloat3 - this.hi[2] };
  }
  
  /* Error */
  public int bD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/baidu/location/aj:he	I
    //   6: istore_2
    //   7: iload_2
    //   8: bipush 20
    //   10: if_icmpge +9 -> 19
    //   13: iconst_m1
    //   14: istore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 87	com/baidu/location/aj:hk	I
    //   23: istore_2
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	aj
    //   27	4	1	localObject	Object
    //   6	18	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   19	24	27	finally
  }
  
  public void bE()
  {
    try
    {
      this.hg = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int bF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 123	com/baidu/location/aj:he	I
    //   6: istore_2
    //   7: iload_2
    //   8: bipush 20
    //   10: if_icmpge +9 -> 19
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 69	com/baidu/location/aj:hg	I
    //   23: istore_2
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	aj
    //   27	4	1	localObject	Object
    //   6	18	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   19	24	27	finally
  }
  
  public void bH()
  {
    if ((!this.hD) && (this.ht != null)) {}
    try
    {
      this.hC.registerListener(this.hn, this.ht, this.hr);
      this.hq = new Timer("UpdateData", false);
      aj.2 local2 = new aj.2(this);
      this.hq.schedule(local2, 500L, 30L);
      this.hD = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void bI()
  {
    if (this.hD == true) {}
    try
    {
      this.hC.unregisterListener(this.hn);
      this.hq.cancel();
      this.hq.purge();
      this.hq = null;
      this.hD = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */