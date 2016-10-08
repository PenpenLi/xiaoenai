package com.xiaoenai.app.widget.swipe.app;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.xiaoenai.app.widget.swipe.SwipeBackLayout;

public class a
{
  private Activity a;
  private SwipeBackLayout b;
  
  public a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public View a(int paramInt)
  {
    if (this.b != null) {
      return this.b.findViewById(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    this.a.getWindow().getDecorView().setBackgroundDrawable(null);
    this.b = ((SwipeBackLayout)LayoutInflater.from(this.a).inflate(2130903373, null));
    this.b.a(new b(this));
  }
  
  public void b()
  {
    this.b.a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipe\app\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */