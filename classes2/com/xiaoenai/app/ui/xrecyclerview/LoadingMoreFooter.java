package com.xiaoenai.app.ui.xrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingMoreFooter
  extends LinearLayout
{
  private SimpleViewSwitcher a;
  private TextView b;
  
  public LoadingMoreFooter(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LoadingMoreFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public void a()
  {
    setGravity(17);
    setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    this.a = new SimpleViewSwitcher(getContext());
    this.a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView(this.a);
    this.b = new TextView(getContext());
  }
  
  public void setProgressStyle(int paramInt)
  {
    if (paramInt == -1) {
      this.a.setView(new ProgressBar(getContext(), null, 16842871));
    }
  }
  
  public void setProgressStyle(ProgressBar paramProgressBar)
  {
    if (paramProgressBar != null) {
      this.a.setView(paramProgressBar);
    }
  }
  
  public void setState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.setVisibility(0);
      this.b.setText(getContext().getText(d.d.xrv_listview_loading));
      setVisibility(0);
      return;
    case 1: 
      this.b.setText(getContext().getText(d.d.xrv_listview_loading));
      setVisibility(8);
      return;
    }
    this.b.setText(getContext().getText(d.d.xrv_nomore_loading));
    this.a.setVisibility(8);
    setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\xrecyclerview\LoadingMoreFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */