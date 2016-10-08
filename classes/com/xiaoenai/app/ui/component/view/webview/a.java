package com.xiaoenai.app.ui.component.view.webview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;

public class a
  extends WebChromeClient
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private View a;
  private ViewGroup b;
  private View c;
  private WebView d;
  private boolean e;
  private FrameLayout f;
  private WebChromeClient.CustomViewCallback g;
  private a h;
  
  public a(View paramView1, ViewGroup paramViewGroup, View paramView2, XeaWebView paramXeaWebView)
  {
    this.a = paramView1;
    this.b = paramViewGroup;
    this.c = paramView2;
    this.d = paramXeaWebView;
    this.e = false;
  }
  
  public void a(a parama)
  {
    this.h = parama;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.c != null)
    {
      this.c.setVisibility(0);
      return this.c;
    }
    return super.getVideoLoadingProgressView();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    onHideCustomView();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onHideCustomView()
  {
    if (this.e)
    {
      this.b.setVisibility(4);
      this.b.removeView(this.f);
      this.a.setVisibility(0);
      if ((this.g != null) && (!this.g.getClass().getName().contains(".chromium."))) {
        this.g.onCustomViewHidden();
      }
      this.e = false;
      this.f = null;
      this.g = null;
      if (this.h != null) {
        this.h.a(false);
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    View localView;
    if ((paramView instanceof FrameLayout))
    {
      paramView = (FrameLayout)paramView;
      localView = paramView.getFocusedChild();
      this.e = true;
      this.f = paramView;
      this.g = paramCustomViewCallback;
      this.a.setVisibility(4);
      this.b.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      this.b.setVisibility(0);
      if (!(localView instanceof VideoView)) {
        break label113;
      }
      paramView = (VideoView)localView;
      paramView.setOnPreparedListener(this);
      paramView.setOnCompletionListener(this);
      paramView.setOnErrorListener(this);
    }
    for (;;)
    {
      if (this.h != null) {
        this.h.a(true);
      }
      return;
      label113:
      if ((this.d != null) && (this.d.getSettings().getJavaScriptEnabled()) && ((localView instanceof SurfaceView)))
      {
        paramView = "javascript:" + "var _ytrp_html5_video_last;";
        paramView = paramView + "var _ytrp_html5_video = document.getElementsByTagName('video')[0];";
        paramView = paramView + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {";
        paramView = paramView + "_ytrp_html5_video_last = _ytrp_html5_video;";
        paramView = paramView + "function _ytrp_html5_video_ended() {";
        paramView = paramView + "_VideoEnabledWebView.notifyVideoEnd();";
        paramView = paramView + "}";
        paramView = paramView + "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);";
        paramView = paramView + "}";
        this.d.loadUrl(paramView);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\component\view\webview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */