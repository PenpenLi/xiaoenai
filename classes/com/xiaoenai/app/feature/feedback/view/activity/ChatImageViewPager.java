package com.xiaoenai.app.feature.feedback.view.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.feedback.a.a;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.feature.photopreview.view.ImageViewPagerWidget;
import com.xiaoenai.app.feature.photopreview.view.PreviewActivity;
import com.xiaoenai.app.ui.a.b;
import com.xiaoenai.app.utils.d.i;
import com.xiaoenai.app.utils.d.j;
import java.io.File;

public class ChatImageViewPager
  extends PreviewActivity
{
  private void a(String paramString1, String paramString2)
  {
    paramString2 = com.xiaoenai.app.feature.photopreview.a.a.a + paramString2;
    if (i.a(paramString1, paramString2) == 0)
    {
      j.a(this, new File(paramString2));
      com.xiaoenai.app.utils.d.a.a(this, a.f.pv_save_local_success);
      return;
    }
    com.xiaoenai.app.utils.d.a.a(this, a.f.pv_save_local_failed);
  }
  
  private void g()
  {
    this.o = ((ImageViewPagerWidget)findViewById(a.d.image_pager));
    c();
    a();
  }
  
  public void a()
  {
    this.b.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void b()
  {
    finish();
    overridePendingTransition(a.a.activity_close_enter, a.a.activity_close_exit);
  }
  
  protected void b(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("showCommonDialog", new Object[0]);
    b localb = new b(this);
    localb.a(a.f.chat_save_2_sdcard, 1, new a(this, localb, paramString));
    localb.show();
  }
  
  protected int d()
  {
    return a.e.activity_preview_page;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\ChatImageViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */