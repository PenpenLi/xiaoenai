package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ProgressGifView
  extends ProgressBar
{
  public ProgressGifView(Context paramContext)
  {
    super(paramContext);
    setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838789));
  }
  
  public ProgressGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838789));
  }
  
  public ProgressGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838789));
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void b()
  {
    setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\ProgressGifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */