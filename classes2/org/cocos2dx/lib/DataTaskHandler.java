package org.cocos2dx.lib;

import android.util.Log;
import com.b.a.a.g;
import org.apache.http.Header;

class DataTaskHandler
  extends g
{
  private Cocos2dxDownloader _downloader;
  int _id;
  private long _lastBytesWritten;
  
  public DataTaskHandler(Cocos2dxDownloader paramCocos2dxDownloader, int paramInt)
  {
    super(new String[] { ".*" });
    this._downloader = paramCocos2dxDownloader;
    this._id = paramInt;
    this._lastBytesWritten = 0L;
  }
  
  void LogD(String paramString)
  {
    Log.d("Cocos2dxDownloader", paramString);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    LogD("onFailure(i:" + paramInt + " headers:" + paramArrayOfHeader + " throwable:" + paramThrowable);
    paramArrayOfHeader = "";
    if (paramThrowable != null) {
      paramArrayOfHeader = paramThrowable.toString();
    }
    this._downloader.onFinish(this._id, paramInt, paramArrayOfHeader, null);
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    long l = this._lastBytesWritten;
    this._downloader.onProgress(this._id, paramLong1 - l, paramLong1, paramLong2);
    this._lastBytesWritten = paramLong1;
  }
  
  public void onStart()
  {
    this._downloader.onStart(this._id);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    LogD("onSuccess(i:" + paramInt + " headers:" + paramArrayOfHeader);
    this._downloader.onFinish(this._id, 0, null, paramArrayOfByte);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\DataTaskHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */