package com.xiaoenai.app.widget.swipe.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class SwipeBackActivity
  extends FragmentActivity
{
  private a a;
  
  public View findViewById(int paramInt)
  {
    View localView2 = super.findViewById(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (this.a != null) {
        localView1 = this.a.a(paramInt);
      }
    }
    return localView1;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new a(this);
    this.a.a();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipe\app\SwipeBackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */