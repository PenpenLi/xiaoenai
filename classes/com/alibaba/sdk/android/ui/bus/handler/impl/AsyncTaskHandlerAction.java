package com.alibaba.sdk.android.ui.bus.handler.impl;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.handler.HandlerAction;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import com.alibaba.sdk.android.util.ReflectionUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class AsyncTaskHandlerAction
  implements HandlerAction
{
  public static final String ASYNCTASK_CLASS_NAME_PARAMETER_KEY = "asyncClassName";
  private Class<? extends AsyncTask> asyncTaskClazz;
  private HandlerInfo handlerInfo;
  private Type parameterType;
  
  public AsyncTaskHandlerAction(HandlerInfo paramHandlerInfo)
  {
    this.handlerInfo = paramHandlerInfo;
    String str = (String)paramHandlerInfo.actionParameters.get("asyncClassName");
    if (TextUtils.isEmpty(str)) {
      throw new IllegalStateException("asyncClassName is not set in the handler " + paramHandlerInfo.name);
    }
    try
    {
      paramHandlerInfo = Class.forName(str);
      if (!AsyncTask.class.isAssignableFrom(paramHandlerInfo)) {
        throw new IllegalStateException("The class " + paramHandlerInfo.getName() + " is not of AsyncTask type");
      }
    }
    catch (Exception paramHandlerInfo)
    {
      throw new IllegalStateException(paramHandlerInfo);
    }
    this.asyncTaskClazz = paramHandlerInfo.asSubclass(AsyncTask.class);
    paramHandlerInfo = this.asyncTaskClazz.getGenericSuperclass();
    if ((paramHandlerInfo instanceof ParameterizedType))
    {
      paramHandlerInfo = ((ParameterizedType)paramHandlerInfo).getActualTypeArguments();
      if ((paramHandlerInfo != null) && (paramHandlerInfo.length > 0)) {
        this.parameterType = paramHandlerInfo[0];
      }
    }
  }
  
  public boolean execute(HandlerContext paramHandlerContext)
  {
    try
    {
      Object localObject = this.asyncTaskClazz;
      WebView localWebView = paramHandlerContext.webView;
      localObject = (AsyncTask)ReflectionUtils.newInstance((Class)localObject, new Class[] { WebView.class }, new Object[] { localWebView });
      if (this.parameterType == Void.class) {
        ((AsyncTask)localObject).execute(new Object[0]);
      } else if (this.parameterType == String.class) {
        ((AsyncTask)localObject).execute(new Object[] { paramHandlerContext.getUri() });
      }
    }
    catch (Exception paramHandlerContext)
    {
      AliSDKLogger.e("ui", "Fail to execute the async task", paramHandlerContext);
      return false;
    }
    AliSDKLogger.e("ui", "fail to execute the task " + this.asyncTaskClazz.getName() + " type = " + this.parameterType);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\impl\AsyncTaskHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */