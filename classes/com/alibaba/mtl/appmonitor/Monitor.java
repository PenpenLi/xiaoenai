package com.alibaba.mtl.appmonitor;

import android.app.Application;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.e.i;
import java.util.Map;

public class Monitor
  extends IMonitor.Stub
{
  private Application b;
  
  Monitor(Application paramApplication)
  {
    this.b = paramApplication;
  }
  
  private f a(int paramInt)
  {
    return f.a(paramInt);
  }
  
  public boolean alarm_checkSampled(String paramString1, String paramString2)
  {
    return AppMonitorDelegate.Alarm.checkSampled(paramString1, paramString2);
  }
  
  public void alarm_commitFail1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMonitorDelegate.Alarm.commitFail(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void alarm_commitFail2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMonitorDelegate.Alarm.commitFail(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void alarm_commitSuccess1(String paramString1, String paramString2)
  {
    AppMonitorDelegate.Alarm.commitSuccess(paramString1, paramString2);
  }
  
  public void alarm_commitSuccess2(String paramString1, String paramString2, String paramString3)
  {
    AppMonitorDelegate.Alarm.commitSuccess(paramString1, paramString2, paramString3);
  }
  
  public void alarm_setSampling(int paramInt)
  {
    AppMonitorDelegate.Alarm.setSampling(paramInt);
  }
  
  public void alarm_setStatisticsInterval(int paramInt)
  {
    AppMonitorDelegate.Alarm.setStatisticsInterval(paramInt);
  }
  
  public boolean counter_checkSampled(String paramString1, String paramString2)
  {
    return AppMonitorDelegate.Counter.checkSampled(paramString1, paramString2);
  }
  
  public void counter_commit1(String paramString1, String paramString2, double paramDouble)
  {
    AppMonitorDelegate.Counter.commit(paramString1, paramString2, paramDouble);
  }
  
  public void counter_commit2(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    AppMonitorDelegate.Counter.commit(paramString1, paramString2, paramString3, paramDouble);
  }
  
  public void counter_setSampling(int paramInt)
  {
    AppMonitorDelegate.Counter.setSampling(paramInt);
  }
  
  public void counter_setStatisticsInterval(int paramInt)
  {
    AppMonitorDelegate.Counter.setStatisticsInterval(paramInt);
  }
  
  public void destroy() {}
  
  public void enableLog(boolean paramBoolean)
  {
    AppMonitorDelegate.enableLog(paramBoolean);
  }
  
  public void init()
  {
    AppMonitorDelegate.init(this.b);
  }
  
  public boolean offlinecounter_checkSampled(String paramString1, String paramString2)
  {
    return AppMonitorDelegate.OffLineCounter.checkSampled(paramString1, paramString2);
  }
  
  public void offlinecounter_commit(String paramString1, String paramString2, double paramDouble)
  {
    AppMonitorDelegate.OffLineCounter.commit(paramString1, paramString2, paramDouble);
  }
  
  public void offlinecounter_setSampling(int paramInt)
  {
    AppMonitorDelegate.OffLineCounter.setSampling(paramInt);
  }
  
  public void offlinecounter_setStatisticsInterval(int paramInt)
  {
    AppMonitorDelegate.OffLineCounter.setStatisticsInterval(paramInt);
  }
  
  public void register1(String paramString1, String paramString2, MeasureSet paramMeasureSet)
  {
    AppMonitorDelegate.register(paramString1, paramString2, paramMeasureSet);
  }
  
  public void register2(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean)
  {
    AppMonitorDelegate.register(paramString1, paramString2, paramMeasureSet, paramBoolean);
  }
  
  public void register3(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet)
  {
    AppMonitorDelegate.register(paramString1, paramString2, paramMeasureSet, paramDimensionSet);
  }
  
  public void register4(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    AppMonitorDelegate.register(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean);
  }
  
  public void setChannel(String paramString)
  {
    AppMonitorDelegate.setChannel(paramString);
  }
  
  public void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    AppMonitorDelegate.setRequestAuthInfo(paramBoolean, paramString1, paramString2, paramString3);
  }
  
  public void setSampling(int paramInt)
  {
    AppMonitorDelegate.setSampling(paramInt);
  }
  
  public void setStatisticsInterval1(int paramInt)
  {
    AppMonitorDelegate.setStatisticsInterval(paramInt);
  }
  
  public void setStatisticsInterval2(int paramInt1, int paramInt2)
  {
    AppMonitorDelegate.setStatisticsInterval(a(paramInt1), paramInt2);
  }
  
  public void stat_begin(String paramString1, String paramString2, String paramString3)
  {
    AppMonitorDelegate.Stat.begin(paramString1, paramString2, paramString3);
  }
  
  public boolean stat_checkSampled(String paramString1, String paramString2)
  {
    return AppMonitorDelegate.Stat.checkSampled(paramString1, paramString2);
  }
  
  public void stat_commit1(String paramString1, String paramString2, double paramDouble)
  {
    AppMonitorDelegate.Stat.commit(paramString1, paramString2, paramDouble);
  }
  
  public void stat_commit2(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble)
  {
    AppMonitorDelegate.Stat.commit(paramString1, paramString2, paramDimensionValueSet, paramDouble);
  }
  
  public void stat_commit3(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
  {
    i.a("Monitor", new Object[] { "[stat_commit3]" });
    AppMonitorDelegate.Stat.commit(paramString1, paramString2, paramDimensionValueSet, paramMeasureValueSet);
  }
  
  public void stat_end(String paramString1, String paramString2, String paramString3)
  {
    AppMonitorDelegate.Stat.end(paramString1, paramString2, paramString3);
  }
  
  public void stat_setSampling(int paramInt)
  {
    AppMonitorDelegate.Stat.setSampling(paramInt);
  }
  
  public void stat_setStatisticsInterval(int paramInt)
  {
    AppMonitorDelegate.Stat.setStatisticsInterval(paramInt);
  }
  
  public void transaction_begin(Transaction paramTransaction, String paramString)
  {
    TransactionDelegate.begin(paramTransaction, paramString);
  }
  
  public void transaction_end(Transaction paramTransaction, String paramString)
  {
    TransactionDelegate.end(paramTransaction, paramString);
  }
  
  public void triggerUpload() {}
  
  public void turnOffRealTimeDebug() {}
  
  public void turnOnRealTimeDebug(Map paramMap)
  {
    AppMonitorDelegate.turnOnRealTimeDebug(paramMap);
  }
  
  public void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMonitorDelegate.updateMeasure(paramString1, paramString2, paramString3, paramDouble1, paramDouble2, paramDouble3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\Monitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */