package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.k;
import java.io.File;

class o
  implements View.OnClickListener
{
  o(m paramm, com.xiaoenai.app.classes.common.dialog.e parame, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (!as.c())
    {
      h.c(m.a(this.c), 2131101068, 1500L);
      return;
    }
    if (this.b.startsWith("file://"))
    {
      paramView = this.b.substring(7);
      if (paramView.startsWith(com.xiaoenai.app.utils.e.b))
      {
        as.b(2131100981);
        return;
      }
      Object localObject = new File(paramView);
      localObject = com.xiaoenai.app.utils.e.b + ((File)localObject).getName();
      if (com.xiaoenai.app.utils.e.a(paramView, (String)localObject) == 0)
      {
        k.a(new File((String)localObject));
        as.b(2131100138);
        return;
      }
      as.b(2131100139);
      return;
    }
    as.c(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */