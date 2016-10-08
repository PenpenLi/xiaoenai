package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboException;

public class AsyncWeiboRunner
{
  private Context mContext;
  
  public AsyncWeiboRunner(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public String request(String paramString1, WeiboParameters paramWeiboParameters, String paramString2)
  {
    WbAppActivator.getInstance(this.mContext, paramWeiboParameters.getAppKey()).activateApp();
    return HttpManager.openUrl(this.mContext, paramString1, paramString2, paramWeiboParameters);
  }
  
  public void requestAsync(String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener)
  {
    WbAppActivator.getInstance(this.mContext, paramWeiboParameters.getAppKey()).activateApp();
    new RequestRunner(this.mContext, paramString1, paramWeiboParameters, paramString2, paramRequestListener).execute(new Void[1]);
  }
  
  @Deprecated
  public void requestByThread(String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener)
  {
    new AsyncWeiboRunner.1(this, paramString1, paramString2, paramWeiboParameters, paramRequestListener).start();
  }
  
  private static class AsyncTaskResult<T>
  {
    private WeiboException error;
    private T result;
    
    public AsyncTaskResult(WeiboException paramWeiboException)
    {
      this.error = paramWeiboException;
    }
    
    public AsyncTaskResult(T paramT)
    {
      this.result = paramT;
    }
    
    public WeiboException getError()
    {
      return this.error;
    }
    
    public T getResult()
    {
      return (T)this.result;
    }
  }
  
  static class RequestRunner
    extends AsyncTask<Void, Void, AsyncWeiboRunner.AsyncTaskResult<String>>
  {
    private final Context mContext;
    private final String mHttpMethod;
    private final RequestListener mListener;
    private final WeiboParameters mParams;
    private final String mUrl;
    
    public RequestRunner(Context paramContext, String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener)
    {
      this.mContext = paramContext;
      this.mUrl = paramString1;
      this.mParams = paramWeiboParameters;
      this.mHttpMethod = paramString2;
      this.mListener = paramRequestListener;
    }
    
    protected AsyncWeiboRunner.AsyncTaskResult<String> doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new AsyncWeiboRunner.AsyncTaskResult(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
        return paramVarArgs;
      }
      catch (WeiboException paramVarArgs) {}
      return new AsyncWeiboRunner.AsyncTaskResult(paramVarArgs);
    }
    
    protected void onPostExecute(AsyncWeiboRunner.AsyncTaskResult<String> paramAsyncTaskResult)
    {
      WeiboException localWeiboException = paramAsyncTaskResult.getError();
      if (localWeiboException != null)
      {
        this.mListener.onWeiboException(localWeiboException);
        return;
      }
      this.mListener.onComplete((String)paramAsyncTaskResult.getResult());
    }
    
    protected void onPreExecute() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\net\AsyncWeiboRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */