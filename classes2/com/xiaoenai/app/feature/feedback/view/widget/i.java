package com.xiaoenai.app.feature.feedback.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.feature.feedback.a.b;
import com.xiaoenai.app.feature.feedback.a.c;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.feature.feedback.b.d;
import com.xiaoenai.app.ui.component.view.ChatImageView;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.e.c.d.a;

public class i
  extends BaseItemView
{
  private ChatImageView c;
  private ProgressView d;
  private ImageView e;
  
  public i(Context paramContext, BaseItemView.a parama)
  {
    super(paramContext, parama);
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    a(paramc.d(), paramBoolean);
    a(paramc);
    int i;
    String str;
    if (paramc.d() == 1)
    {
      i = a.c.bg_chat_item_left;
      this.c.setMaskResource(i);
      paramc = (d)paramc;
      str = paramc.j();
      if (!TextUtils.isEmpty(str)) {
        break label111;
      }
    }
    label111:
    for (paramc = paramc.i().a();; paramc = "file://" + str)
    {
      this.c.setImageDrawable(null);
      com.xiaoenai.app.utils.e.b.b(this.c, paramc, new d.a().b(a.b.color_bg_grey).a(), new k(this), null);
      return;
      i = a.c.bg_chat_item_right;
      break;
    }
  }
  
  public View getMsgContentView()
  {
    View localView = inflate(getContext(), a.e.view_item_photo, null);
    this.c = ((ChatImageView)localView.findViewById(a.d.photoMessageImage));
    this.d = ((ProgressView)localView.findViewById(a.d.progressView));
    this.e = ((ImageView)localView.findViewById(a.d.iv_failed));
    this.c.setOnClickListener(j.a(this));
    return localView;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */