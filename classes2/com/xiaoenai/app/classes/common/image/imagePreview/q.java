package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.widget.Button;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.e.d.d;

class q
  implements d
{
  q(m paramm, Button paramButton) {}
  
  public void a(String paramString, View paramView, int paramInt1, int paramInt2)
  {
    int i = (int)((paramInt1 + 0.0F) / (paramInt2 + 0.0F) * 100.0F);
    this.a.setText(String.valueOf(i) + "%");
    if (paramInt1 == paramInt2)
    {
      Xiaoenai.j().a(new r(this), 200L);
      this.b.b(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */