package com.xiaoenai.app.classes.common.image.croper;

import android.widget.Toast;
import java.util.ArrayList;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    CropImage localCropImage = this.a.e;
    if (this.a.d > 1) {}
    for (boolean bool = true;; bool = false)
    {
      localCropImage.a = bool;
      if (this.a.d <= 0) {
        break;
      }
      int i = 0;
      while (i < this.a.d)
      {
        j.a(this.a, this.a.c[i]);
        i += 1;
      }
    }
    if (CropImage.j(this.a.e)) {
      j.a(this.a);
    }
    CropImage.c(this.a.e).invalidate();
    if (CropImage.c(this.a.e).a.size() == 1)
    {
      this.a.e.c = ((l)CropImage.c(this.a.e).a.get(0));
      this.a.e.c.a(true);
    }
    if (this.a.d > 1) {
      Toast.makeText(this.a.e, "Multi face crop help", 0).show();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */