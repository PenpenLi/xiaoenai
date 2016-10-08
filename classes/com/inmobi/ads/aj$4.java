package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

class aj$4
  extends aj.b
{
  aj$4(aj paramaj)
  {
    super(paramaj);
  }
  
  protected View a(@NonNull Context paramContext)
  {
    return new ImageView(paramContext.getApplicationContext());
  }
  
  protected void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    aj.a(this.a, (ImageView)paramView, paramNativeStrandAsset);
  }
  
  public boolean a(@NonNull View paramView)
  {
    if (!(paramView instanceof ImageView)) {
      return false;
    }
    ((ImageView)paramView).setImageDrawable(null);
    return super.a(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */