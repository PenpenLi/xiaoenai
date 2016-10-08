package com.alibaba.sdk.android.trace;

import com.alibaba.sdk.android.util.JSONUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ActionTraceLogger
{
  private final String action;
  private long beginTime;
  private Map<String, Object> infos;
  private final int level;
  private final String module;
  
  ActionTraceLogger(int paramInt, String paramString1, String paramString2)
  {
    this.level = paramInt;
    this.module = paramString1;
    this.action = paramString2;
  }
  
  private void done(String paramString)
  {
    long l;
    if (this.beginTime > 0L)
    {
      l = System.currentTimeMillis() - this.beginTime;
      if (l > 0L)
      {
        if (this.infos == null) {
          this.infos = new HashMap();
        }
        this.infos.put("caseTime", Long.valueOf(l));
      }
    }
    for (;;)
    {
      TraceLoggerManager.INSTANCE.log(this.level, 3, this.module, this.action + paramString, infoString());
      if ((this.level & 0x4) > 0) {
        TraceLoggerManager.INSTANCE.actionCountTrack(this.module, this.action, true, (int)l);
      }
      this.infos = null;
      return;
      l = 0L;
      continue;
      l = 0L;
    }
  }
  
  private void done(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      done(".Success");
      return;
    }
    done(".Failed");
  }
  
  private String infoString()
  {
    if ((this.infos != null) && (this.infos.size() > 0)) {
      return JSONUtils.toJson(this.infos);
    }
    return null;
  }
  
  public ActionTraceLogger begin()
  {
    this.beginTime = System.currentTimeMillis();
    AliSDKLogger.d(this.level, this.module, this.action, infoString());
    this.infos = null;
    return this;
  }
  
  public void done()
  {
    done(".Done");
  }
  
  public void failed()
  {
    done(false);
  }
  
  public void failed(String paramString, Object paramObject)
  {
    info(paramString, paramObject);
    failed();
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public long getCaseTime()
  {
    long l = 0L;
    if (this.beginTime > 0L) {
      l = System.currentTimeMillis() - this.beginTime;
    }
    return l;
  }
  
  public ActionTraceLogger info(String paramString, Object paramObject)
  {
    if (this.infos == null) {
      this.infos = new LinkedHashMap();
    }
    this.infos.put(paramString, paramObject);
    return this;
  }
  
  public ActionTraceLogger infos(Map<String, ?> paramMap)
  {
    if (paramMap != null)
    {
      if (this.infos == null) {
        this.infos = new LinkedHashMap(paramMap);
      }
    }
    else {
      return this;
    }
    this.infos.putAll(paramMap);
    return this;
  }
  
  public void success()
  {
    done(true);
  }
  
  public void success(String paramString, Object paramObject)
  {
    info(paramString, paramObject);
    success();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\ActionTraceLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */