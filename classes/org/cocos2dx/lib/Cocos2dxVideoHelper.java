package org.cocos2dx.lib;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.lang.ref.WeakReference;

public class Cocos2dxVideoHelper
{
  static final int KeyEventBack = 1000;
  private static final int VideoTaskCreate = 0;
  private static final int VideoTaskFullScreen = 12;
  private static final int VideoTaskKeepRatio = 11;
  private static final int VideoTaskPause = 5;
  private static final int VideoTaskRemove = 1;
  private static final int VideoTaskRestart = 10;
  private static final int VideoTaskResume = 6;
  private static final int VideoTaskSeek = 8;
  private static final int VideoTaskSetRect = 3;
  private static final int VideoTaskSetSource = 2;
  private static final int VideoTaskSetVisible = 9;
  private static final int VideoTaskStart = 4;
  private static final int VideoTaskStop = 7;
  static VideoHandler mVideoHandler = null;
  private static int videoTag = 0;
  private Cocos2dxActivity mActivity = null;
  private FrameLayout mLayout = null;
  private SparseArray<Cocos2dxVideoView> sVideoViews = null;
  Cocos2dxVideoView.OnVideoEventListener videoEventListener = new Cocos2dxVideoHelper.1(this);
  
  Cocos2dxVideoHelper(Cocos2dxActivity paramCocos2dxActivity, FrameLayout paramFrameLayout)
  {
    this.mActivity = paramCocos2dxActivity;
    this.mLayout = paramFrameLayout;
    mVideoHandler = new VideoHandler(this);
    this.sVideoViews = new SparseArray();
  }
  
  private void _createVideoView(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = new Cocos2dxVideoView(this.mActivity, paramInt);
    this.sVideoViews.put(paramInt, localCocos2dxVideoView);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.mLayout.addView(localCocos2dxVideoView, localLayoutParams);
    localCocos2dxVideoView.setZOrderOnTop(true);
    localCocos2dxVideoView.setOnCompletionListener(this.videoEventListener);
  }
  
  private void _pauseVideo(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.pause();
    }
  }
  
  private void _removeVideoView(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null)
    {
      localCocos2dxVideoView.stopPlayback();
      this.sVideoViews.remove(paramInt);
      this.mLayout.removeView(localCocos2dxVideoView);
    }
  }
  
  private void _restartVideo(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.restart();
    }
  }
  
  private void _resumeVideo(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.resume();
    }
  }
  
  private void _seekVideoTo(int paramInt1, int paramInt2)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt1);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.seekTo(paramInt2);
    }
  }
  
  private void _setFullScreenEnabled(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt1);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.setFullScreenEnabled(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  private void _setVideoKeepRatio(int paramInt, boolean paramBoolean)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.setKeepRatio(paramBoolean);
    }
  }
  
  private void _setVideoRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt1);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.setVideoRect(paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  private void _setVideoURL(int paramInt1, int paramInt2, String paramString)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt1);
    if (localCocos2dxVideoView != null) {}
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      localCocos2dxVideoView.setVideoFileName(paramString);
      return;
    }
    localCocos2dxVideoView.setVideoURL(paramString);
  }
  
  private void _setVideoVisible(int paramInt, boolean paramBoolean)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null)
    {
      if (paramBoolean)
      {
        localCocos2dxVideoView.fixSize();
        localCocos2dxVideoView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localCocos2dxVideoView.setVisibility(4);
  }
  
  private void _startVideo(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.start();
    }
  }
  
  private void _stopVideo(int paramInt)
  {
    Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(paramInt);
    if (localCocos2dxVideoView != null) {
      localCocos2dxVideoView.stop();
    }
  }
  
  public static int createVideoWidget()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.arg1 = videoTag;
    mVideoHandler.sendMessage(localMessage);
    int i = videoTag;
    videoTag = i + 1;
    return i;
  }
  
  public static native void nativeExecuteVideoCallback(int paramInt1, int paramInt2);
  
  private void onBackKeyEvent()
  {
    int j = this.sVideoViews.size();
    int i = 0;
    while (i < j)
    {
      int k = this.sVideoViews.keyAt(i);
      Cocos2dxVideoView localCocos2dxVideoView = (Cocos2dxVideoView)this.sVideoViews.get(k);
      if (localCocos2dxVideoView != null)
      {
        localCocos2dxVideoView.setFullScreenEnabled(false, 0, 0);
        this.mActivity.runOnGLThread(new VideoEventRunnable(k, 1000));
      }
      i += 1;
    }
  }
  
  public static void pauseVideo(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 5;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void removeVideoWidget(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void restartVideo(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 10;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void resumeVideo(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void seekVideoTo(int paramInt1, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.what = 8;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void setFullScreenEnabled(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Message localMessage = new Message();
    localMessage.what = 12;
    localMessage.arg1 = paramInt1;
    if (paramBoolean) {}
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      localMessage.obj = new Rect(0, 0, paramInt2, paramInt3);
      mVideoHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public static void setVideoKeepRatioEnabled(int paramInt, boolean paramBoolean)
  {
    Message localMessage = new Message();
    localMessage.what = 11;
    localMessage.arg1 = paramInt;
    if (paramBoolean) {}
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      mVideoHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public static void setVideoRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.arg1 = paramInt1;
    localMessage.obj = new Rect(paramInt2, paramInt3, paramInt4, paramInt5);
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void setVideoUrl(int paramInt1, int paramInt2, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramString;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void setVideoVisible(int paramInt, boolean paramBoolean)
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    localMessage.arg1 = paramInt;
    if (paramBoolean) {}
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      mVideoHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public static void startVideo(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  public static void stopVideo(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    localMessage.arg1 = paramInt;
    mVideoHandler.sendMessage(localMessage);
  }
  
  private class VideoEventRunnable
    implements Runnable
  {
    private int mVideoEvent;
    private int mVideoTag;
    
    public VideoEventRunnable(int paramInt1, int paramInt2)
    {
      this.mVideoTag = paramInt1;
      this.mVideoEvent = paramInt2;
    }
    
    public void run()
    {
      Cocos2dxVideoHelper.nativeExecuteVideoCallback(this.mVideoTag, this.mVideoEvent);
    }
  }
  
  static class VideoHandler
    extends Handler
  {
    WeakReference<Cocos2dxVideoHelper> mReference;
    
    VideoHandler(Cocos2dxVideoHelper paramCocos2dxVideoHelper)
    {
      this.mReference = new WeakReference(paramCocos2dxVideoHelper);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        ((Cocos2dxVideoHelper)this.mReference.get())._createVideoView(paramMessage.arg1);
        continue;
        ((Cocos2dxVideoHelper)this.mReference.get())._removeVideoView(paramMessage.arg1);
        continue;
        ((Cocos2dxVideoHelper)this.mReference.get())._setVideoURL(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
        continue;
        ((Cocos2dxVideoHelper)this.mReference.get())._startVideo(paramMessage.arg1);
        continue;
        Cocos2dxVideoHelper localCocos2dxVideoHelper = (Cocos2dxVideoHelper)this.mReference.get();
        Rect localRect = (Rect)paramMessage.obj;
        localCocos2dxVideoHelper._setVideoRect(paramMessage.arg1, localRect.left, localRect.top, localRect.right, localRect.bottom);
        continue;
        localCocos2dxVideoHelper = (Cocos2dxVideoHelper)this.mReference.get();
        localRect = (Rect)paramMessage.obj;
        if (paramMessage.arg2 == 1)
        {
          localCocos2dxVideoHelper._setFullScreenEnabled(paramMessage.arg1, true, localRect.right, localRect.bottom);
        }
        else
        {
          localCocos2dxVideoHelper._setFullScreenEnabled(paramMessage.arg1, false, localRect.right, localRect.bottom);
          continue;
          ((Cocos2dxVideoHelper)this.mReference.get())._pauseVideo(paramMessage.arg1);
          continue;
          ((Cocos2dxVideoHelper)this.mReference.get())._resumeVideo(paramMessage.arg1);
          continue;
          ((Cocos2dxVideoHelper)this.mReference.get())._stopVideo(paramMessage.arg1);
          continue;
          ((Cocos2dxVideoHelper)this.mReference.get())._seekVideoTo(paramMessage.arg1, paramMessage.arg2);
          continue;
          localCocos2dxVideoHelper = (Cocos2dxVideoHelper)this.mReference.get();
          if (paramMessage.arg2 == 1)
          {
            localCocos2dxVideoHelper._setVideoVisible(paramMessage.arg1, true);
          }
          else
          {
            localCocos2dxVideoHelper._setVideoVisible(paramMessage.arg1, false);
            continue;
            ((Cocos2dxVideoHelper)this.mReference.get())._restartVideo(paramMessage.arg1);
            continue;
            localCocos2dxVideoHelper = (Cocos2dxVideoHelper)this.mReference.get();
            if (paramMessage.arg2 == 1)
            {
              localCocos2dxVideoHelper._setVideoKeepRatio(paramMessage.arg1, true);
            }
            else
            {
              localCocos2dxVideoHelper._setVideoKeepRatio(paramMessage.arg1, false);
              continue;
              ((Cocos2dxVideoHelper)this.mReference.get()).onBackKeyEvent();
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */