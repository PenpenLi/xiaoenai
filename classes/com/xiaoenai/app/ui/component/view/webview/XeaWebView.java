package com.xiaoenai.app.ui.component.view.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ProgressBar;

public class XeaWebView
  extends WebView
{
  private ProgressBar a;
  
  public XeaWebView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public XeaWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public XeaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public XeaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  @TargetApi(11)
  public XeaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new ProgressBar(paramContext, null, 16842872);
    this.a.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 3, 0, 0));
    this.a.setVisibility(8);
    addView(this.a);
  }
  
  public void a(int paramInt)
  {
    int i;
    if (this.a != null)
    {
      if (100 != paramInt) {
        break label58;
      }
      i = this.a.getProgress();
      while (i <= paramInt)
      {
        this.a.setProgress(i);
        i += 1;
      }
      this.a.post(new b(this));
    }
    for (;;)
    {
      return;
      label58:
      if (this.a.getVisibility() == 8) {
        this.a.setVisibility(0);
      }
      i = this.a.getProgress();
      while (i <= paramInt)
      {
        this.a.setProgress(i);
        i += 1;
      }
    }
  }
  
  public void setProgressbarColor(int paramInt)
  {
    ClipDrawable localClipDrawable = new ClipDrawable(new ColorDrawable(paramInt), 3, 1);
    Drawable localDrawable = getResources().getDrawable(17170445);
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { localDrawable, localClipDrawable });
    localLayerDrawable.setDrawableByLayerId(16908288, localDrawable);
    localLayerDrawable.setDrawableByLayerId(16908301, localClipDrawable);
    this.a.setProgressDrawable(localLayerDrawable);
  }
  
  public void setProgressbarSize(int paramInt)
  {
    this.a.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, paramInt, 0, 0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\component\view\webview\XeaWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */