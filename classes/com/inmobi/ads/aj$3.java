package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

class aj$3
  extends aj.b
{
  aj$3(aj paramaj)
  {
    super(paramaj);
  }
  
  protected View a(@NonNull Context paramContext)
  {
    return new ao(paramContext.getApplicationContext());
  }
  
  protected void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    aj.a(paramView, paramNativeStrandAsset.b());
  }
  
  public boolean a(@NonNull View paramView)
  {
    ((ao)paramView).a();
    return super.a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */