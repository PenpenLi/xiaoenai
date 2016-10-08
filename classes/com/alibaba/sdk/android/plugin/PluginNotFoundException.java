package com.alibaba.sdk.android.plugin;

public class PluginNotFoundException
  extends Exception
{
  private static final long serialVersionUID = -4638859050373683050L;
  private String pluginName;
  
  public PluginNotFoundException(String paramString1, String paramString2)
  {
    super(paramString2);
    this.pluginName = paramString1;
  }
  
  public PluginNotFoundException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString2, paramThrowable);
    this.pluginName = paramString1;
  }
  
  public String getPluginName()
  {
    return this.pluginName;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */