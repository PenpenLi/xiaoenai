package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

class aj$2
  extends aj.b
{
  aj$2(aj paramaj)
  {
    super(paramaj);
  }
  
  protected View a(@NonNull Context paramContext)
  {
    return new NativeStrandContainerLayout(paramContext.getApplicationContext());
  }
  
  protected void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    aj.a(paramView, paramNativeStrandAsset.b());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */