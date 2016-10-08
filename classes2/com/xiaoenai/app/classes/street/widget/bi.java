package com.xiaoenai.app.classes.street.widget;

import com.xiaoenai.app.classes.street.d.bo;
import com.xiaoenai.app.ui.component.view.ProgressView;

class bi
  implements Runnable
{
  bi(StreetSceneView paramStreetSceneView) {}
  
  public void run()
  {
    this.a.progressView.a();
    StreetSceneView.e(this.a).a(0, StreetSceneView.c(this.a), StreetSceneView.d(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */