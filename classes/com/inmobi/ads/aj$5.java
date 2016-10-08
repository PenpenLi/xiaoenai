package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

class aj$5
  extends aj.b
{
  aj$5(aj paramaj)
  {
    super(paramaj);
  }
  
  protected View a(@NonNull Context paramContext)
  {
    return new aj.a(paramContext);
  }
  
  protected void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    aj.a(this.a, (TextView)paramView, paramNativeStrandAsset);
  }
  
  public boolean a(@NonNull View paramView)
  {
    if (!(paramView instanceof TextView)) {
      return false;
    }
    aj.a((TextView)paramView);
    return super.a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */