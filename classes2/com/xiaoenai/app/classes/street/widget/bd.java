package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;

class bd
  implements a
{
  bd(StreetSceneView paramStreetSceneView) {}
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramView = (ProductItemInfo)paramView.getTag();
      if (paramView != null) {
        StreetSceneView.a(this.a, paramView);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */