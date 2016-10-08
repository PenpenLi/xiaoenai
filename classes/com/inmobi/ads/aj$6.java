package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

class aj$6
  extends aj.b
{
  aj$6(aj paramaj)
  {
    super(paramaj);
  }
  
  protected View a(@NonNull Context paramContext)
  {
    return new Button(paramContext.getApplicationContext());
  }
  
  protected void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    aj.a((Button)paramView, paramNativeStrandAsset);
  }
  
  public boolean a(@NonNull View paramView)
  {
    if (!(paramView instanceof Button)) {
      return false;
    }
    aj.a((Button)paramView);
    return super.a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */