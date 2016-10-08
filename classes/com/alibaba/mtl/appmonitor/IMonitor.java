package com.alibaba.mtl.appmonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

public abstract interface IMonitor
  extends IInterface
{
  public abstract boolean alarm_checkSampled(String paramString1, String paramString2);
  
  public abstract void alarm_commitFail1(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void alarm_commitFail2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void alarm_commitSuccess1(String paramString1, String paramString2);
  
  public abstract void alarm_commitSuccess2(String paramString1, String paramString2, String paramString3);
  
  public abstract void alarm_setSampling(int paramInt);
  
  public abstract void alarm_setStatisticsInterval(int paramInt);
  
  public abstract boolean counter_checkSampled(String paramString1, String paramString2);
  
  public abstract void counter_commit1(String paramString1, String paramString2, double paramDouble);
  
  public abstract void counter_commit2(String paramString1, String paramString2, String paramString3, double paramDouble);
  
  public abstract void counter_setSampling(int paramInt);
  
  public abstract void counter_setStatisticsInterval(int paramInt);
  
  public abstract void destroy();
  
  public abstract void enableLog(boolean paramBoolean);
  
  public abstract void init();
  
  public abstract boolean offlinecounter_checkSampled(String paramString1, String paramString2);
  
  public abstract void offlinecounter_commit(String paramString1, String paramString2, double paramDouble);
  
  public abstract void offlinecounter_setSampling(int paramInt);
  
  public abstract void offlinecounter_setStatisticsInterval(int paramInt);
  
  public abstract void register1(String paramString1, String paramString2, MeasureSet paramMeasureSet);
  
  public abstract void register2(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean);
  
  public abstract void register3(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet);
  
  public abstract void register4(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean);
  
  public abstract void setChannel(String paramString);
  
  public abstract void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3);
  
  public abstract void setSampling(int paramInt);
  
  public abstract void setStatisticsInterval1(int paramInt);
  
  public abstract void setStatisticsInterval2(int paramInt1, int paramInt2);
  
  public abstract void stat_begin(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean stat_checkSampled(String paramString1, String paramString2);
  
  public abstract void stat_commit1(String paramString1, String paramString2, double paramDouble);
  
  public abstract void stat_commit2(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble);
  
  public abstract void stat_commit3(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet);
  
  public abstract void stat_end(String paramString1, String paramString2, String paramString3);
  
  public abstract void stat_setSampling(int paramInt);
  
  public abstract void stat_setStatisticsInterval(int paramInt);
  
  public abstract void transaction_begin(Transaction paramTransaction, String paramString);
  
  public abstract void transaction_end(Transaction paramTransaction, String paramString);
  
  public abstract void triggerUpload();
  
  public abstract void turnOffRealTimeDebug();
  
  public abstract void turnOnRealTimeDebug(Map paramMap);
  
  public abstract void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static abstract class Stub
    extends Binder
    implements IMonitor
  {
    public Stub()
    {
      attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
    }
    
    public static IMonitor asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
      if ((localIInterface != null) && ((localIInterface instanceof IMonitor))) {
        return (IMonitor)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      boolean bool2 = false;
      boolean bool3 = false;
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      boolean bool1 = false;
      Object localObject2 = null;
      String str1;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.alibaba.mtl.appmonitor.IMonitor");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        init();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        if (paramParcel1.readInt() != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          enableLog(bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        setRequestAuthInfo(bool1, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        setChannel(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        triggerUpload();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        setSampling(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        setStatisticsInterval1(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        setStatisticsInterval2(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        localObject1 = paramParcel1.readString();
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (MeasureSet)MeasureSet.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          register1((String)localObject1, (String)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 10: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        localObject2 = paramParcel1.readString();
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (MeasureSet)MeasureSet.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          bool1 = bool2;
          if (paramParcel1.readInt() != 0) {
            bool1 = true;
          }
          register2((String)localObject2, str1, (MeasureSet)localObject1, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 11: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        localObject2 = paramParcel1.readString();
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (MeasureSet)MeasureSet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label797;
          }
        }
        for (paramParcel1 = (DimensionSet)DimensionSet.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          register3((String)localObject2, str1, (MeasureSet)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 12: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (MeasureSet)MeasureSet.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject2 = (DimensionSet)DimensionSet.CREATOR.createFromParcel(paramParcel1);
          }
          bool1 = bool3;
          if (paramParcel1.readInt() != 0) {
            bool1 = true;
          }
          register4(str1, str2, (MeasureSet)localObject1, (DimensionSet)localObject2, bool1);
          paramParcel2.writeNoException();
          return true;
        }
      case 13: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        turnOnRealTimeDebug(paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        turnOffRealTimeDebug();
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        destroy();
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        counter_setStatisticsInterval(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        counter_setSampling(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        bool1 = counter_checkSampled(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        counter_commit1(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readDouble());
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        counter_commit2(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readDouble());
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        offlinecounter_setStatisticsInterval(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        offlinecounter_setSampling(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        bool1 = offlinecounter_checkSampled(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        offlinecounter_commit(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readDouble());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_setStatisticsInterval(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_setSampling(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        bool1 = alarm_checkSampled(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_commitSuccess1(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_commitSuccess2(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_commitFail1(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        alarm_commitFail2(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        stat_begin(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        stat_end(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        stat_setStatisticsInterval(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        stat_setSampling(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        bool1 = stat_checkSampled(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        stat_commit1(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readDouble());
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        localObject2 = paramParcel1.readString();
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (DimensionValueSet)DimensionValueSet.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          stat_commit2((String)localObject2, str1, (DimensionValueSet)localObject1, paramParcel1.readDouble());
          paramParcel2.writeNoException();
          return true;
        }
      case 39: 
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        localObject2 = paramParcel1.readString();
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (DimensionValueSet)DimensionValueSet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1724;
          }
        }
        for (paramParcel1 = (MeasureValueSet)MeasureValueSet.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          stat_commit3((String)localObject2, str1, (DimensionValueSet)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 40: 
        label797:
        label1724:
        paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Transaction)Transaction.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          transaction_begin((Transaction)localObject1, paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
      if (paramParcel1.readInt() != 0) {}
      for (Object localObject1 = (Transaction)Transaction.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        transaction_end((Transaction)localObject1, paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class a
      implements IMonitor
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public boolean alarm_checkSampled(String paramString1, String paramString2)
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_commitFail1(String paramString1, String paramString2, String paramString3, String paramString4)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          this.a.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_commitFail2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          localParcel1.writeString(paramString5);
          this.a.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_commitSuccess1(String paramString1, String paramString2)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_commitSuccess2(String paramString1, String paramString2, String paramString3)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(29, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_setSampling(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void alarm_setStatisticsInterval(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public boolean counter_checkSampled(String paramString1, String paramString2)
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void counter_commit1(String paramString1, String paramString2, double paramDouble)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeDouble(paramDouble);
          this.a.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void counter_commit2(String paramString1, String paramString2, String paramString3, double paramDouble)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeDouble(paramDouble);
          this.a.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void counter_setSampling(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void counter_setStatisticsInterval(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void destroy()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void enableLog(boolean paramBoolean)
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void init()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean offlinecounter_checkSampled(String paramString1, String paramString2)
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void offlinecounter_commit(String paramString1, String paramString2, double paramDouble)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeDouble(paramDouble);
          this.a.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void offlinecounter_setSampling(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void offlinecounter_setStatisticsInterval(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void register1(String paramString1, String paramString2, MeasureSet paramMeasureSet)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 4
        //   25: aload_2
        //   26: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload_3
        //   30: ifnull +49 -> 79
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 95	com/alibaba/mtl/appmonitor/model/MeasureSet:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/alibaba/mtl/appmonitor/IMonitor$Stub$a:a	Landroid/os/IBinder;
        //   50: bipush 9
        //   52: aload 4
        //   54: aload 5
        //   56: iconst_0
        //   57: invokeinterface 42 5 0
        //   62: pop
        //   63: aload 5
        //   65: invokevirtual 45	android/os/Parcel:readException	()V
        //   68: aload 5
        //   70: invokevirtual 52	android/os/Parcel:recycle	()V
        //   73: aload 4
        //   75: invokevirtual 52	android/os/Parcel:recycle	()V
        //   78: return
        //   79: aload 4
        //   81: iconst_0
        //   82: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   85: goto -39 -> 46
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 52	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: invokevirtual 52	android/os/Parcel:recycle	()V
        //   99: aload_1
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramString1	String
        //   0	101	2	paramString2	String
        //   0	101	3	paramMeasureSet	MeasureSet
        //   3	92	4	localParcel1	Parcel
        //   8	82	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	88	finally
        //   33	46	88	finally
        //   46	68	88	finally
        //   79	85	88	finally
      }
      
      public void register2(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean)
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramMeasureSet != null)
            {
              localParcel1.writeInt(1);
              paramMeasureSet.writeToParcel(localParcel1, 0);
              break label120;
              localParcel1.writeInt(i);
              this.a.transact(10, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
            else
            {
              localParcel1.writeInt(0);
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label120:
          do
          {
            i = 0;
            break;
          } while (!paramBoolean);
        }
      }
      
      public void register3(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramMeasureSet != null)
            {
              localParcel1.writeInt(1);
              paramMeasureSet.writeToParcel(localParcel1, 0);
              if (paramDimensionSet != null)
              {
                localParcel1.writeInt(1);
                paramDimensionSet.writeToParcel(localParcel1, 0);
                this.a.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void register4(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramMeasureSet != null)
            {
              localParcel1.writeInt(1);
              paramMeasureSet.writeToParcel(localParcel1, 0);
              if (paramDimensionSet != null)
              {
                localParcel1.writeInt(1);
                paramDimensionSet.writeToParcel(localParcel1, 0);
                break label148;
                localParcel1.writeInt(i);
                this.a.transact(12, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          label148:
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
      
      public void setChannel(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setSampling(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setStatisticsInterval1(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setStatisticsInterval2(int paramInt1, int paramInt2)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stat_begin(String paramString1, String paramString2, String paramString3)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(32, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean stat_checkSampled(String paramString1, String paramString2)
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.a.transact(36, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stat_commit1(String paramString1, String paramString2, double paramDouble)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeDouble(paramDouble);
          this.a.transact(37, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void stat_commit2(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: aload_1
        //   20: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 6
        //   25: aload_2
        //   26: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   29: aload_3
        //   30: ifnull +56 -> 86
        //   33: aload 6
        //   35: iconst_1
        //   36: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 6
        //   42: iconst_0
        //   43: invokevirtual 119	com/alibaba/mtl/appmonitor/model/DimensionValueSet:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload 6
        //   48: dload 4
        //   50: invokevirtual 75	android/os/Parcel:writeDouble	(D)V
        //   53: aload_0
        //   54: getfield 18	com/alibaba/mtl/appmonitor/IMonitor$Stub$a:a	Landroid/os/IBinder;
        //   57: bipush 38
        //   59: aload 6
        //   61: aload 7
        //   63: iconst_0
        //   64: invokeinterface 42 5 0
        //   69: pop
        //   70: aload 7
        //   72: invokevirtual 45	android/os/Parcel:readException	()V
        //   75: aload 7
        //   77: invokevirtual 52	android/os/Parcel:recycle	()V
        //   80: aload 6
        //   82: invokevirtual 52	android/os/Parcel:recycle	()V
        //   85: return
        //   86: aload 6
        //   88: iconst_0
        //   89: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   92: goto -46 -> 46
        //   95: astore_1
        //   96: aload 7
        //   98: invokevirtual 52	android/os/Parcel:recycle	()V
        //   101: aload 6
        //   103: invokevirtual 52	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	a
        //   0	108	1	paramString1	String
        //   0	108	2	paramString2	String
        //   0	108	3	paramDimensionValueSet	DimensionValueSet
        //   0	108	4	paramDouble	double
        //   3	99	6	localParcel1	Parcel
        //   8	89	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	95	finally
        //   33	46	95	finally
        //   46	75	95	finally
        //   86	92	95	finally
      }
      
      public void stat_commit3(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramDimensionValueSet != null)
            {
              localParcel1.writeInt(1);
              paramDimensionValueSet.writeToParcel(localParcel1, 0);
              if (paramMeasureValueSet != null)
              {
                localParcel1.writeInt(1);
                paramMeasureValueSet.writeToParcel(localParcel1, 0);
                this.a.transact(39, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void stat_end(String paramString1, String paramString2, String paramString3)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.a.transact(33, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stat_setSampling(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(35, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stat_setStatisticsInterval(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeInt(paramInt);
          this.a.transact(34, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void transaction_begin(Transaction paramTransaction, String paramString)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 132	com/alibaba/mtl/appmonitor/Transaction:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/alibaba/mtl/appmonitor/IMonitor$Stub$a:a	Landroid/os/IBinder;
        //   39: bipush 40
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 42 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 45	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 52	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 52	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   71: goto -41 -> 30
        //   74: astore_1
        //   75: aload 4
        //   77: invokevirtual 52	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 52	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramTransaction	Transaction
        //   0	86	2	paramString	String
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	30	74	finally
        //   30	56	74	finally
        //   66	71	74	finally
      }
      
      /* Error */
      public void transaction_end(Transaction paramTransaction, String paramString)
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 29
        //   12: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 132	com/alibaba/mtl/appmonitor/Transaction:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: aload_2
        //   32: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	com/alibaba/mtl/appmonitor/IMonitor$Stub$a:a	Landroid/os/IBinder;
        //   39: bipush 41
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 42 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 45	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 52	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 52	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   71: goto -41 -> 30
        //   74: astore_1
        //   75: aload 4
        //   77: invokevirtual 52	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 52	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramTransaction	Transaction
        //   0	86	2	paramString	String
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	30	74	finally
        //   30	56	74	finally
        //   66	71	74	finally
      }
      
      public void triggerUpload()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void turnOffRealTimeDebug()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void turnOnRealTimeDebug(Map paramMap)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          localParcel1.writeMap(paramMap);
          this.a.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeDouble(paramDouble1);
          localParcel1.writeDouble(paramDouble2);
          localParcel1.writeDouble(paramDouble3);
          this.a.transact(42, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\IMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */