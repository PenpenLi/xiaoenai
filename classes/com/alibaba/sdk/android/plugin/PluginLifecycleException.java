package com.alibaba.sdk.android.plugin;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.message.Message;

public class PluginLifecycleException
  extends Exception
{
  private static final long serialVersionUID = -1346625393468196870L;
  private String pluginName;
  private ResultCode resultCode;
  
  public PluginLifecycleException(Message paramMessage)
  {
    super(paramMessage.message);
    this.resultCode = ResultCode.create(paramMessage);
  }
  
  public PluginLifecycleException(Message paramMessage, Throwable paramThrowable)
  {
    super(paramMessage.message, paramThrowable);
    this.resultCode = ResultCode.create(paramMessage);
  }
  
  public PluginLifecycleException(String paramString)
  {
    super(paramString);
  }
  
  public PluginLifecycleException(String paramString1, String paramString2)
  {
    super(paramString2);
    this.pluginName = paramString1;
  }
  
  public PluginLifecycleException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString2, paramThrowable);
    this.pluginName = paramString1;
  }
  
  public PluginLifecycleException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.pluginName).append("]");
    if (this.resultCode != null) {
      localStringBuilder.append(this.resultCode);
    }
    localStringBuilder.append(", the android stack error message is ").append(super.getMessage());
    if (getCause() != null) {
      localStringBuilder.append(", which is caused by ").append(getCause().getMessage());
    }
    return localStringBuilder.toString();
  }
  
  public String getPluginName()
  {
    return this.pluginName;
  }
  
  public ResultCode getResultCode()
  {
    return this.resultCode;
  }
  
  public void setPluginName(String paramString)
  {
    this.pluginName = paramString;
  }
  
  public void setResultCode(ResultCode paramResultCode)
  {
    this.resultCode = paramResultCode;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginLifecycleException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */