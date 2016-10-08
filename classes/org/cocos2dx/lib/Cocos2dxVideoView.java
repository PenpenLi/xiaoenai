package org.cocos2dx.lib;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController.MediaPlayerControl;
import com.chukong.cocosplay.client.CocosPlayClient;
import java.io.IOException;
import java.util.Map;

public class Cocos2dxVideoView
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  private static final String AssetResourceRoot = "assets/";
  private static final int EVENT_COMPLETED = 3;
  private static final int EVENT_PAUSED = 1;
  private static final int EVENT_PLAYING = 0;
  private static final int EVENT_STOPPED = 2;
  private static final int STATE_ERROR = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PAUSED = 4;
  private static final int STATE_PLAYBACK_COMPLETED = 5;
  private static final int STATE_PLAYING = 3;
  private static final int STATE_PREPARED = 2;
  private static final int STATE_PREPARING = 1;
  private String TAG = "Cocos2dxVideoView";
  private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new Cocos2dxVideoView.5(this);
  protected Cocos2dxActivity mCocos2dxActivity = null;
  private MediaPlayer.OnCompletionListener mCompletionListener = new Cocos2dxVideoView.3(this);
  private int mCurrentBufferPercentage;
  private int mCurrentState = 0;
  private int mDuration;
  private MediaPlayer.OnErrorListener mErrorListener = new Cocos2dxVideoView.4(this);
  protected boolean mFullScreenEnabled = false;
  protected int mFullScreenHeight = 0;
  protected int mFullScreenWidth = 0;
  private boolean mIsAssetRouse = false;
  private boolean mKeepRatio = false;
  private MediaPlayer mMediaPlayer = null;
  private boolean mNeedResume = false;
  private MediaPlayer.OnErrorListener mOnErrorListener;
  private MediaPlayer.OnPreparedListener mOnPreparedListener;
  private OnVideoEventListener mOnVideoEventListener;
  MediaPlayer.OnPreparedListener mPreparedListener = new Cocos2dxVideoView.2(this);
  SurfaceHolder.Callback mSHCallback = new Cocos2dxVideoView.6(this);
  private int mSeekWhenPrepared;
  protected MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new Cocos2dxVideoView.1(this);
  private SurfaceHolder mSurfaceHolder = null;
  private int mTargetState = 0;
  private String mVideoFilePath = null;
  private int mVideoHeight = 0;
  private Uri mVideoUri;
  private int mVideoWidth = 0;
  protected int mViewHeight = 0;
  protected int mViewLeft = 0;
  private int mViewTag = 0;
  protected int mViewTop = 0;
  protected int mViewWidth = 0;
  protected int mVisibleHeight = 0;
  protected int mVisibleLeft = 0;
  protected int mVisibleTop = 0;
  protected int mVisibleWidth = 0;
  
  public Cocos2dxVideoView(Cocos2dxActivity paramCocos2dxActivity, int paramInt)
  {
    super(paramCocos2dxActivity);
    this.mViewTag = paramInt;
    this.mCocos2dxActivity = paramCocos2dxActivity;
    initVideoView();
  }
  
  private void initVideoView()
  {
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.mSHCallback);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.mCurrentState = 0;
    this.mTargetState = 0;
  }
  
  private void openVideo()
  {
    if (this.mSurfaceHolder == null) {}
    do
    {
      return;
      if (!this.mIsAssetRouse) {
        break;
      }
    } while (this.mVideoFilePath == null);
    for (;;)
    {
      Object localObject = new Intent("com.android.music.musicservicecommand");
      ((Intent)localObject).putExtra("command", "pause");
      this.mCocos2dxActivity.sendBroadcast((Intent)localObject);
      release(false);
      try
      {
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
        this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
        this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
        this.mMediaPlayer.setAudioStreamType(3);
        this.mMediaPlayer.setScreenOnWhilePlaying(true);
        this.mDuration = -1;
        this.mCurrentBufferPercentage = 0;
        if (this.mIsAssetRouse)
        {
          localObject = this.mCocos2dxActivity.getAssets().openFd(this.mVideoFilePath);
          this.mMediaPlayer.setDataSource(((AssetFileDescriptor)localObject).getFileDescriptor(), ((AssetFileDescriptor)localObject).getStartOffset(), ((AssetFileDescriptor)localObject).getLength());
          this.mMediaPlayer.prepareAsync();
          this.mCurrentState = 1;
          return;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.w(this.TAG, "Unable to open content: " + this.mVideoUri, localIOException);
          this.mCurrentState = -1;
          this.mTargetState = -1;
          this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
          return;
          if (this.mVideoUri != null) {
            break;
          }
          return;
          this.mMediaPlayer.setDataSource(this.mCocos2dxActivity, this.mVideoUri);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.w(this.TAG, "Unable to open content: " + this.mVideoUri, localIllegalArgumentException);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
      }
    }
  }
  
  private void release(boolean paramBoolean)
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      if (paramBoolean) {
        this.mTargetState = 0;
      }
    }
  }
  
  private void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    this.mVideoUri = paramUri;
    this.mSeekWhenPrepared = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public boolean canPause()
  {
    return true;
  }
  
  public boolean canSeekBackward()
  {
    return true;
  }
  
  public boolean canSeekForward()
  {
    return true;
  }
  
  public void fixSize()
  {
    if (this.mFullScreenEnabled)
    {
      fixSize(0, 0, this.mFullScreenWidth, this.mFullScreenHeight);
      return;
    }
    fixSize(this.mViewLeft, this.mViewTop, this.mViewWidth, this.mViewHeight);
  }
  
  public void fixSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      this.mVisibleLeft = paramInt1;
      this.mVisibleTop = paramInt2;
      this.mVisibleWidth = paramInt3;
      this.mVisibleHeight = paramInt4;
    }
    for (;;)
    {
      getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.mVisibleLeft;
      localLayoutParams.topMargin = this.mVisibleTop;
      localLayoutParams.gravity = 51;
      setLayoutParams(localLayoutParams);
      return;
      if ((paramInt3 != 0) && (paramInt4 != 0))
      {
        if (this.mKeepRatio)
        {
          if (this.mVideoWidth * paramInt4 > this.mVideoHeight * paramInt3)
          {
            this.mVisibleWidth = paramInt3;
            this.mVisibleHeight = (this.mVideoHeight * paramInt3 / this.mVideoWidth);
          }
          for (;;)
          {
            this.mVisibleLeft = ((paramInt3 - this.mVisibleWidth) / 2 + paramInt1);
            this.mVisibleTop = ((paramInt4 - this.mVisibleHeight) / 2 + paramInt2);
            break;
            if (this.mVideoWidth * paramInt4 < this.mVideoHeight * paramInt3)
            {
              this.mVisibleWidth = (this.mVideoWidth * paramInt4 / this.mVideoHeight);
              this.mVisibleHeight = paramInt4;
            }
          }
        }
        this.mVisibleLeft = paramInt1;
        this.mVisibleTop = paramInt2;
        this.mVisibleWidth = paramInt3;
        this.mVisibleHeight = paramInt4;
      }
      else
      {
        this.mVisibleLeft = paramInt1;
        this.mVisibleTop = paramInt2;
        this.mVisibleWidth = this.mVideoWidth;
        this.mVisibleHeight = this.mVideoHeight;
      }
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mMediaPlayer.getAudioSessionId();
  }
  
  public int getBufferPercentage()
  {
    if (this.mMediaPlayer != null) {
      return this.mCurrentBufferPercentage;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (isInPlaybackState()) {
      return this.mMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (isInPlaybackState())
    {
      if (this.mDuration > 0) {
        return this.mDuration;
      }
      this.mDuration = this.mMediaPlayer.getDuration();
      return this.mDuration;
    }
    this.mDuration = -1;
    return this.mDuration;
  }
  
  public boolean isInPlaybackState()
  {
    return (this.mMediaPlayer != null) && (this.mCurrentState != -1) && (this.mCurrentState != 0) && (this.mCurrentState != 1);
  }
  
  public boolean isPlaying()
  {
    return (isInPlaybackState()) && (this.mMediaPlayer.isPlaying());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(this.mViewWidth, this.mViewHeight);
      Log.i(this.TAG, "" + this.mViewWidth + ":" + this.mViewHeight);
      return;
    }
    setMeasuredDimension(this.mVisibleWidth, this.mVisibleHeight);
    Log.i(this.TAG, "" + this.mVisibleWidth + ":" + this.mVisibleHeight);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      if (!isPlaying()) {
        break label25;
      }
      pause();
    }
    label25:
    while (this.mCurrentState != 4) {
      return true;
    }
    resume();
    return true;
  }
  
  public void pause()
  {
    if ((isInPlaybackState()) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      this.mCurrentState = 4;
      if (this.mOnVideoEventListener != null) {
        this.mOnVideoEventListener.onVideoEvent(this.mViewTag, 1);
      }
    }
    this.mTargetState = 4;
  }
  
  public int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void restart()
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.seekTo(0);
      this.mMediaPlayer.start();
      this.mCurrentState = 3;
      this.mTargetState = 3;
    }
  }
  
  public void resume()
  {
    if ((isInPlaybackState()) && (this.mCurrentState == 4))
    {
      this.mMediaPlayer.start();
      this.mCurrentState = 3;
      if (this.mOnVideoEventListener != null) {
        this.mOnVideoEventListener.onVideoEvent(this.mViewTag, 0);
      }
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.seekTo(paramInt);
      this.mSeekWhenPrepared = 0;
      return;
    }
    this.mSeekWhenPrepared = paramInt;
  }
  
  public void setFullScreenEnabled(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.mFullScreenEnabled != paramBoolean)
    {
      this.mFullScreenEnabled = paramBoolean;
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        this.mFullScreenWidth = paramInt1;
        this.mFullScreenHeight = paramInt2;
      }
      fixSize();
    }
  }
  
  public void setKeepRatio(boolean paramBoolean)
  {
    this.mKeepRatio = paramBoolean;
    fixSize();
  }
  
  public void setOnCompletionListener(OnVideoEventListener paramOnVideoEventListener)
  {
    this.mOnVideoEventListener = paramOnVideoEventListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoFileName(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("assets/")) {
      str = paramString.substring("assets/".length());
    }
    if ((CocosPlayClient.isEnabled()) && (!CocosPlayClient.isDemo())) {
      CocosPlayClient.updateAssets(str);
    }
    CocosPlayClient.notifyFileLoaded(str);
    if (str.startsWith("/"))
    {
      this.mIsAssetRouse = false;
      setVideoURI(Uri.parse(str), null);
      return;
    }
    this.mVideoFilePath = str;
    this.mIsAssetRouse = true;
    setVideoURI(Uri.parse(str), null);
  }
  
  public void setVideoRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mViewLeft = paramInt1;
    this.mViewTop = paramInt2;
    this.mViewWidth = paramInt3;
    this.mViewHeight = paramInt4;
    fixSize(this.mViewLeft, this.mViewTop, this.mViewWidth, this.mViewHeight);
  }
  
  public void setVideoURL(String paramString)
  {
    this.mIsAssetRouse = false;
    setVideoURI(Uri.parse(paramString), null);
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 4)
    {
      this.mNeedResume = isPlaying();
      if (this.mNeedResume) {
        this.mSeekWhenPrepared = getCurrentPosition();
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      if (this.mNeedResume)
      {
        start();
        this.mNeedResume = false;
      }
    }
  }
  
  public void start()
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.start();
      this.mCurrentState = 3;
      if (this.mOnVideoEventListener != null) {
        this.mOnVideoEventListener.onVideoEvent(this.mViewTag, 0);
      }
    }
    this.mTargetState = 3;
  }
  
  public void stop()
  {
    if ((isInPlaybackState()) && (this.mMediaPlayer.isPlaying()))
    {
      stopPlayback();
      if (this.mOnVideoEventListener != null) {
        this.mOnVideoEventListener.onVideoEvent(this.mViewTag, 2);
      }
    }
  }
  
  public void stopPlayback()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      this.mTargetState = 0;
    }
  }
  
  public void suspend()
  {
    release(false);
  }
  
  public static abstract interface OnVideoEventListener
  {
    public abstract void onVideoEvent(int paramInt1, int paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */