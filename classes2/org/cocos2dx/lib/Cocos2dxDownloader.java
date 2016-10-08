package org.cocos2dx.lib;

import android.app.Activity;
import com.b.a.a.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.net.ssl.SSLException;

public class Cocos2dxDownloader
{
  private int _countOfMaxProcessingTasks;
  private a _httpClient = new a();
  private int _id;
  private HashMap _taskMap = new HashMap();
  private Queue<Runnable> _taskQueue = new LinkedList();
  private String _tempFileNameSufix;
  
  public static void cancelAllRequests(Cocos2dxDownloader paramCocos2dxDownloader)
  {
    Cocos2dxHelper.getActivity().runOnUiThread(new Cocos2dxDownloader.4(paramCocos2dxDownloader));
  }
  
  public static Cocos2dxDownloader createDownloader(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Cocos2dxDownloader localCocos2dxDownloader = new Cocos2dxDownloader();
    localCocos2dxDownloader._id = paramInt1;
    localCocos2dxDownloader._httpClient.a(true);
    if (paramInt2 > 0) {
      localCocos2dxDownloader._httpClient.a(paramInt2 * 1000);
    }
    a locala = localCocos2dxDownloader._httpClient;
    a.a(SSLException.class);
    localCocos2dxDownloader._tempFileNameSufix = paramString;
    localCocos2dxDownloader._countOfMaxProcessingTasks = paramInt3;
    return localCocos2dxDownloader;
  }
  
  public static void createTask(Cocos2dxDownloader paramCocos2dxDownloader, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new Cocos2dxDownloader.3(paramString2, paramCocos2dxDownloader, paramInt, paramString1);
    if (paramCocos2dxDownloader._taskQueue.size() < paramCocos2dxDownloader._countOfMaxProcessingTasks)
    {
      Cocos2dxHelper.getActivity().runOnUiThread(paramString1);
      paramCocos2dxDownloader._taskQueue.add(null);
      return;
    }
    paramCocos2dxDownloader._taskQueue.add(paramString1);
  }
  
  public Runnable dequeue()
  {
    if ((!this._taskQueue.isEmpty()) && (this._taskQueue.element() == null)) {
      this._taskQueue.remove();
    }
    if (!this._taskQueue.isEmpty()) {
      return (Runnable)this._taskQueue.remove();
    }
    return null;
  }
  
  native void nativeOnFinish(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte);
  
  native void nativeOnProgress(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
  
  public void onFinish(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    if ((DownloadTask)this._taskMap.get(Integer.valueOf(paramInt1)) == null) {
      return;
    }
    this._taskMap.remove(Integer.valueOf(paramInt1));
    Cocos2dxHelper.runOnGLThread(new Cocos2dxDownloader.2(this, paramInt1, paramInt2, paramString, paramArrayOfByte));
  }
  
  void onProgress(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    DownloadTask localDownloadTask = (DownloadTask)this._taskMap.get(Integer.valueOf(paramInt));
    if (localDownloadTask != null)
    {
      localDownloadTask.bytesReceived = paramLong1;
      localDownloadTask.totalBytesReceived = paramLong2;
      localDownloadTask.totalBytesExpected = paramLong3;
    }
    Cocos2dxHelper.runOnGLThread(new Cocos2dxDownloader.1(this, paramInt, paramLong1, paramLong2, paramLong3));
  }
  
  public void onStart(int paramInt)
  {
    DownloadTask localDownloadTask = (DownloadTask)this._taskMap.get(Integer.valueOf(paramInt));
    if (localDownloadTask != null) {
      localDownloadTask.resetStatus();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */