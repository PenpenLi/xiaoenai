package org.cocos2dx.lib;

import android.app.Activity;
import android.util.Log;
import com.b.a.a.h;
import java.io.File;
import org.apache.http.Header;

class FileTaskHandler
  extends h
{
  private Cocos2dxDownloader _downloader;
  File _finalFile;
  int _id;
  private long _initFileLen;
  private long _lastBytesWritten;
  
  public FileTaskHandler(Cocos2dxDownloader paramCocos2dxDownloader, int paramInt, File paramFile1, File paramFile2)
  {
    super(paramFile1, true);
    this._finalFile = paramFile2;
    this._downloader = paramCocos2dxDownloader;
    this._id = paramInt;
    this._initFileLen = getTargetFile().length();
    this._lastBytesWritten = 0L;
  }
  
  void LogD(String paramString)
  {
    Log.d("Cocos2dxDownloader", paramString);
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile)
  {
    LogD("onFailure(i:" + paramInt + " headers:" + paramArrayOfHeader + " throwable:" + paramThrowable + " file:" + paramFile);
    paramArrayOfHeader = "";
    if (paramThrowable != null) {
      paramArrayOfHeader = paramThrowable.toString();
    }
    this._downloader.onFinish(this._id, paramInt, paramArrayOfHeader, null);
  }
  
  public void onFinish()
  {
    Runnable localRunnable = this._downloader.dequeue();
    if (localRunnable != null) {
      Cocos2dxHelper.getActivity().runOnUiThread(localRunnable);
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    long l1 = this._lastBytesWritten;
    long l2 = this._initFileLen;
    long l3 = this._initFileLen;
    this._downloader.onProgress(this._id, paramLong1 - l1, paramLong1 + l2, paramLong2 + l3);
    this._lastBytesWritten = paramLong1;
  }
  
  public void onStart()
  {
    this._downloader.onStart(this._id);
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile)
  {
    LogD("onSuccess(i:" + paramInt + " headers:" + paramArrayOfHeader + " file:" + paramFile);
    if (this._finalFile.exists()) {
      if (this._finalFile.isDirectory()) {
        paramArrayOfHeader = "Dest file is directory:" + this._finalFile.getAbsolutePath();
      }
    }
    for (;;)
    {
      this._downloader.onFinish(this._id, 0, paramArrayOfHeader, null);
      return;
      if (!this._finalFile.delete())
      {
        paramArrayOfHeader = "Can't remove old file:" + this._finalFile.getAbsolutePath();
      }
      else
      {
        getTargetFile().renameTo(this._finalFile);
        paramArrayOfHeader = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\FileTaskHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */