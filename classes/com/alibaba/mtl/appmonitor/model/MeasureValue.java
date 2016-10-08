package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;

public class MeasureValue
  implements Parcelable, b
{
  public static final Parcelable.Creator<MeasureValue> CREATOR = new MeasureValue.1();
  private Double d;
  private double e;
  private boolean n;
  
  @Deprecated
  public MeasureValue() {}
  
  @Deprecated
  public MeasureValue(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  @Deprecated
  public MeasureValue(double paramDouble1, double paramDouble2)
  {
    this.d = Double.valueOf(paramDouble2);
    this.e = paramDouble1;
    this.n = false;
  }
  
  /* Error */
  static MeasureValue a(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 55	android/os/Parcel:readInt	()I
    //   4: ifne +41 -> 45
    //   7: iconst_0
    //   8: istore 6
    //   10: aload_0
    //   11: invokevirtual 59	android/os/Parcel:readDouble	()D
    //   14: dstore_1
    //   15: aload_0
    //   16: invokevirtual 59	android/os/Parcel:readDouble	()D
    //   19: dstore_3
    //   20: invokestatic 63	com/alibaba/mtl/appmonitor/model/MeasureValue:create	()Lcom/alibaba/mtl/appmonitor/model/MeasureValue;
    //   23: astore_0
    //   24: aload_0
    //   25: iload 6
    //   27: putfield 45	com/alibaba/mtl/appmonitor/model/MeasureValue:n	Z
    //   30: aload_0
    //   31: dload_1
    //   32: invokestatic 41	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   35: putfield 43	com/alibaba/mtl/appmonitor/model/MeasureValue:d	Ljava/lang/Double;
    //   38: aload_0
    //   39: dload_3
    //   40: putfield 34	com/alibaba/mtl/appmonitor/model/MeasureValue:e	D
    //   43: aload_0
    //   44: areturn
    //   45: iconst_1
    //   46: istore 6
    //   48: goto -38 -> 10
    //   51: astore 5
    //   53: aconst_null
    //   54: astore_0
    //   55: aload 5
    //   57: invokevirtual 66	java/lang/Throwable:printStackTrace	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore 5
    //   64: goto -9 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramParcel	Parcel
    //   14	18	1	d1	double
    //   19	21	3	d2	double
    //   51	5	5	localThrowable1	Throwable
    //   62	1	5	localThrowable2	Throwable
    //   8	39	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	7	51	java/lang/Throwable
    //   10	24	51	java/lang/Throwable
    //   24	43	62	java/lang/Throwable
  }
  
  public static MeasureValue create()
  {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[0]);
  }
  
  public static MeasureValue create(double paramDouble)
  {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble) });
  }
  
  public static MeasureValue create(double paramDouble1, double paramDouble2)
  {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
  }
  
  public void clean()
  {
    try
    {
      this.e = 0.0D;
      this.d = null;
      this.n = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void fill(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramVarArgs.length > 0) {
          this.e = ((Double)paramVarArgs[0]).doubleValue();
        }
        if (paramVarArgs.length <= 1) {
          continue;
        }
        this.d = ((Double)paramVarArgs[1]);
        this.n = false;
      }
      finally {}
    }
  }
  
  public Double getOffset()
  {
    return this.d;
  }
  
  public double getValue()
  {
    return this.e;
  }
  
  public boolean isFinish()
  {
    return this.n;
  }
  
  public void merge(MeasureValue paramMeasureValue)
  {
    if (paramMeasureValue == null) {}
    for (;;)
    {
      return;
      try
      {
        this.e += paramMeasureValue.getValue();
        if (paramMeasureValue.getOffset() == null) {
          continue;
        }
        if (this.d == null) {
          this.d = Double.valueOf(0.0D);
        }
        this.d = Double.valueOf(this.d.doubleValue() + paramMeasureValue.getOffset().doubleValue());
      }
      catch (Throwable paramMeasureValue) {}finally {}
    }
  }
  
  public void setFinish(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOffset(double paramDouble)
  {
    this.d = Double.valueOf(paramDouble);
  }
  
  public void setValue(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.n)
        {
          paramInt = 1;
          paramParcel.writeInt(paramInt);
          if (this.d == null)
          {
            d1 = 0.0D;
            paramParcel.writeDouble(d1);
            paramParcel.writeDouble(this.e);
            return;
          }
          double d1 = this.d.doubleValue();
          continue;
        }
        paramInt = 0;
      }
      catch (Throwable paramParcel)
      {
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */