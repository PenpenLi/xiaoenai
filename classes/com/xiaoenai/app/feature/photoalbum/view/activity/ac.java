package com.xiaoenai.app.feature.photoalbum.view.activity;

import com.xiaoenai.app.b.a.a;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import java.io.File;
import java.util.ArrayList;

class ac
  implements a.a
{
  ac(PostPhotoActivity paramPostPhotoActivity) {}
  
  public void a(File paramFile)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(paramFile.getAbsolutePath());
    localArrayList2.add(Boolean.valueOf(true));
    this.a.e.b(localArrayList1, localArrayList2);
    PostPhotoActivity.k(this.a).a(this.a.e.b());
    PostPhotoActivity.l(this.a).setRightButtonClickenable(false);
    if (localArrayList1.size() > 0) {
      PostPhotoActivity.m(this.a).setRightButtonClickenable(true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */