package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

class WBAgentHandler
{
  private static int MAX_CACHE_SIZE = 5;
  private static List<PageLog> mActivePages;
  private static WBAgentHandler mInstance;
  private static Map<String, PageLog> mPages;
  private static Timer mTimer;
  
  private WBAgentHandler()
  {
    mActivePages = new ArrayList();
    mPages = new HashMap();
    LogUtil.i("WBAgent", "init handler");
  }
  
  private void checkAppStatus(Context paramContext)
  {
    if (isBackground(paramContext))
    {
      saveActivePages(mActivePages);
      mActivePages.clear();
    }
  }
  
  private void checkNewSession(Context arg1, long paramLong)
  {
    if (PageLog.isNewSession(???, paramLong))
    {
      PageLog localPageLog1 = new PageLog(???);
      localPageLog1.setType(LogType.SESSION_END);
      PageLog localPageLog2 = new PageLog(???, paramLong);
      localPageLog2.setType(LogType.SESSION_START);
      synchronized (mActivePages)
      {
        if (localPageLog1.getEndTime() > 0L)
        {
          mActivePages.add(localPageLog1);
          mActivePages.add(localPageLog2);
          LogUtil.d("WBAgent", "last session--- starttime:" + localPageLog1.getStartTime() + " ,endtime:" + localPageLog1.getEndTime());
          LogUtil.d("WBAgent", "is a new session--- starttime:" + localPageLog2.getStartTime());
          return;
        }
        LogUtil.d("WBAgent", "is a new install");
      }
    }
    LogUtil.i("WBAgent", "is not a new session");
  }
  
  private void closeTimer()
  {
    if (mTimer != null) {
      mTimer.cancel();
    }
  }
  
  public static WBAgentHandler getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new WBAgentHandler();
      }
      WBAgentHandler localWBAgentHandler = mInstance;
      return localWBAgentHandler;
    }
    finally {}
  }
  
  private String getLogsInMemory()
  {
    String str = "";
    try
    {
      if (mActivePages.size() > 0)
      {
        str = LogBuilder.getPageLogs(mActivePages);
        mActivePages.clear();
      }
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean isBackground(Context paramContext)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()));
    if (localRunningAppProcessInfo.importance == 400)
    {
      LogUtil.i("WBAgent", "后台:" + localRunningAppProcessInfo.processName);
      return true;
    }
    LogUtil.i("WBAgent", "前台:" + localRunningAppProcessInfo.processName);
    return false;
  }
  
  private void saveActivePages(List<PageLog> paramList)
  {
    try
    {
      WBAgentExecutor.execute(new WBAgentHandler.2(this, LogBuilder.getPageLogs(paramList)));
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private Timer timerTask(Context paramContext, long paramLong1, long paramLong2)
  {
    Timer localTimer = new Timer();
    paramContext = new WBAgentHandler.3(this, paramContext);
    if (paramLong2 == 0L)
    {
      localTimer.schedule(paramContext, paramLong1);
      return localTimer;
    }
    localTimer.schedule(paramContext, paramLong1, paramLong2);
    return localTimer;
  }
  
  public void onEvent(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    EventLog localEventLog = new EventLog(paramString1, paramString2, paramMap);
    localEventLog.setType(LogType.EVENT);
    for (;;)
    {
      synchronized (mActivePages)
      {
        mActivePages.add(localEventLog);
        if (paramMap == null)
        {
          LogUtil.d("WBAgent", "event--- page:" + paramString1 + " ,event name:" + paramString2);
          if (mActivePages.size() >= MAX_CACHE_SIZE)
          {
            saveActivePages(mActivePages);
            mActivePages.clear();
          }
          return;
        }
      }
      LogUtil.d("WBAgent", "event--- page:" + paramString1 + " ,event name:" + paramString2 + " ,extend:" + paramMap.toString());
    }
  }
  
  public void onKillProcess()
  {
    LogUtil.i("WBAgent", "save applogs and close timer and shutdown thread executor");
    saveActivePages(mActivePages);
    mInstance = null;
    closeTimer();
    WBAgentExecutor.shutDownExecutor();
  }
  
  public void onPageEnd(String paramString)
  {
    PageLog localPageLog;
    if (!StatisticConfig.ACTIVITY_DURATION_OPEN)
    {
      if (!mPages.containsKey(paramString)) {
        break label172;
      }
      localPageLog = (PageLog)mPages.get(paramString);
      localPageLog.setDuration(System.currentTimeMillis() - localPageLog.getStartTime());
      synchronized (mActivePages)
      {
        mActivePages.add(localPageLog);
      }
    }
    for (;;)
    {
      synchronized (mPages)
      {
        mPages.remove(paramString);
        LogUtil.d("WBAgent", paramString + ", " + localPageLog.getStartTime() / 1000L + ", " + localPageLog.getDuration() / 1000L);
        if (mActivePages.size() >= MAX_CACHE_SIZE)
        {
          saveActivePages(mActivePages);
          mActivePages.clear();
        }
        return;
        paramString = finally;
        throw paramString;
      }
      label172:
      LogUtil.e("WBAgent", "please call onPageStart before onPageEnd");
    }
  }
  
  public void onPageStart(String paramString)
  {
    PageLog localPageLog;
    if (!StatisticConfig.ACTIVITY_DURATION_OPEN)
    {
      localPageLog = new PageLog(paramString);
      localPageLog.setType(LogType.FRAGMENT);
    }
    synchronized (mPages)
    {
      mPages.put(paramString, localPageLog);
      LogUtil.d("WBAgent", paramString + ", " + localPageLog.getStartTime() / 1000L);
      return;
    }
  }
  
  public void onPause(Context paramContext)
  {
    long l = System.currentTimeMillis();
    String str = paramContext.getClass().getName();
    LogUtil.i("WBAgent", "update last page endtime:" + l / 1000L);
    PageLog.updateSession(paramContext, null, Long.valueOf(0L), Long.valueOf(l));
    PageLog localPageLog;
    if (StatisticConfig.ACTIVITY_DURATION_OPEN)
    {
      if (!mPages.containsKey(str)) {
        break label238;
      }
      localPageLog = (PageLog)mPages.get(str);
      localPageLog.setDuration(l - localPageLog.getStartTime());
      synchronized (mActivePages)
      {
        mActivePages.add(localPageLog);
      }
    }
    for (;;)
    {
      synchronized (mPages)
      {
        mPages.remove(str);
        LogUtil.d("WBAgent", str + ", " + localPageLog.getStartTime() / 1000L + ", " + localPageLog.getDuration() / 1000L);
        if (mActivePages.size() >= MAX_CACHE_SIZE)
        {
          saveActivePages(mActivePages);
          mActivePages.clear();
        }
        checkAppStatus(paramContext);
        return;
        paramContext = finally;
        throw paramContext;
      }
      label238:
      LogUtil.e("WBAgent", "please call onResume before onPause");
    }
  }
  
  public void onResume(Context arg1)
  {
    if (LogReport.getPackageName() == null) {
      LogReport.setPackageName(???.getPackageName());
    }
    if (mTimer == null) {
      mTimer = timerTask(???, 500L, StatisticConfig.getUploadInterval());
    }
    long l = System.currentTimeMillis();
    String str = ???.getClass().getName();
    checkNewSession(???, l);
    PageLog localPageLog;
    if (StatisticConfig.ACTIVITY_DURATION_OPEN)
    {
      localPageLog = new PageLog(str, l);
      localPageLog.setType(LogType.ACTIVITY);
    }
    synchronized (mPages)
    {
      mPages.put(str, localPageLog);
      LogUtil.d("WBAgent", str + ", " + l / 1000L);
      return;
    }
  }
  
  public void onStop(Context paramContext)
  {
    checkAppStatus(paramContext);
  }
  
  public void uploadAppLogs(Context paramContext)
  {
    long l = System.currentTimeMillis() - LogReport.getTime(paramContext);
    if ((LogReport.getTime(paramContext) > 0L) && (l < 30000L))
    {
      timerTask(paramContext, 30000L - l, 0L);
      return;
    }
    WBAgentExecutor.execute(new WBAgentHandler.1(this, paramContext));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */