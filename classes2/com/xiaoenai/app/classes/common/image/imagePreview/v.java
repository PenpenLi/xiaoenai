package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.utils.e.a.b.a;
import com.xiaoenai.app.utils.e.d.g;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.k;

class v
  extends g
{
  v(t paramt, PhotoMessage paramPhotoMessage) {}
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    a.a("failReason = {}", new Object[] { paramb.a() });
    if (b.a.a == paramb.a()) {
      com.xiaoenai.app.utils.e.b.a((ImageView)paramView, this.a.t(), 2130839089);
    }
    do
    {
      do
      {
        return;
      } while (b.a.b != paramb.a());
      paramb = k.a(paramString);
    } while ((paramView == null) || (!(paramView instanceof ImageView)));
    if (paramb != null)
    {
      ((ImageView)paramView).setImageBitmap(paramb);
      return;
    }
    com.xiaoenai.app.utils.e.b.d(paramString);
    com.xiaoenai.app.utils.e.b.e(paramString);
    com.xiaoenai.app.utils.e.b.a((ImageView)paramView, this.a.t(), 2130839089);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */