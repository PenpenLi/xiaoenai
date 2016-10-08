package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import java.util.ArrayList;

class x
  implements View.OnLongClickListener
{
  x(t paramt, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (((PhotoMessage)t.a(this.b).get(this.a)).t() == null)
    {
      com.xiaoenai.app.utils.f.a.a("ChatImagePreviewController photoMessages = {}", new Object[] { ((PhotoMessage)t.a(this.b).get(this.a)).x() });
      paramView = (PhotoMessage)com.xiaoenai.app.classes.chat.messagelist.a.a().b().get(this.a);
      if (paramView.t() == null)
      {
        com.xiaoenai.app.utils.f.a.a("ChatImagePreviewController message = {}", new Object[] { paramView.x() });
        return false;
      }
      localObject = this.b;
      str1 = paramView.x();
      String str2 = paramView.t();
      i = paramView.u();
      j = paramView.v();
      if (1 == t.c(this.b)) {}
      for (;;)
      {
        ((t)localObject).a(str1, str2, i, j, bool1);
        return false;
        bool1 = false;
      }
    }
    paramView = this.b;
    Object localObject = ((PhotoMessage)t.a(this.b).get(this.a)).x();
    String str1 = ((PhotoMessage)t.a(this.b).get(this.a)).t();
    int i = ((PhotoMessage)t.a(this.b).get(this.a)).u();
    int j = ((PhotoMessage)t.a(this.b).get(this.a)).v();
    if (1 == t.c(this.b)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.a((String)localObject, str1, i, j, bool1);
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */