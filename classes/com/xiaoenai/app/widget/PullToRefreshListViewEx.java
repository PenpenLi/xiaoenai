package com.xiaoenai.app.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.a;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class PullToRefreshListViewEx
  extends PullToRefreshListView
{
  private ListView b;
  private View c = null;
  private ProgressBar d = null;
  private TextView e = null;
  
  @TargetApi(9)
  public PullToRefreshListViewEx(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.b.setOverScrollMode(2);
    }
  }
  
  @TargetApi(9)
  public PullToRefreshListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.b.setOverScrollMode(2);
    }
  }
  
  @TargetApi(9)
  public PullToRefreshListViewEx(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.b.setOverScrollMode(2);
    }
  }
  
  @TargetApi(9)
  public PullToRefreshListViewEx(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      this.b.setOverScrollMode(2);
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = ((ListView)getRefreshableView());
    this.c = LayoutInflater.from(paramContext).inflate(2130903399, null);
    this.b.addFooterView(this.c);
    this.d = ((ProgressBar)this.c.findViewById(2131560159));
    this.d.setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838790));
    this.e = ((TextView)this.c.findViewById(2131560160));
    this.c.setVisibility(8);
  }
  
  public void o()
  {
    this.d.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  public void p()
  {
    this.c.setVisibility(8);
  }
  
  public void setNoMoreText(String paramString)
  {
    this.c.setVisibility(0);
    this.e.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setText(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\PullToRefreshListViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */