package com.xiaoenai.app.feature.feedback.view.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.xiaoenai.app.feature.feedback.a.c;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.feature.feedback.b.e;
import com.xiaoenai.app.utils.d.t;
import io.github.rockerhieu.emojicon.EmojiconTextView;

public class l
  extends BaseItemView
{
  private EmojiconTextView c;
  
  public l(Context paramContext, BaseItemView.a parama)
  {
    super(paramContext, parama);
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    a(paramc.d(), paramBoolean);
    a(paramc);
    if (paramc.d() == 1) {}
    for (int i = a.c.bg_chat_item_left;; i = a.c.bg_chat_item_right)
    {
      this.rlContent.setBackgroundResource(i);
      paramc = (e)paramc;
      this.c.setText(paramc.i());
      return;
    }
  }
  
  public View getMsgContentView()
  {
    this.c = ((EmojiconTextView)inflate(getContext(), a.e.view_item_text, null).findViewById(a.d.etv_content));
    this.c.setMaxWidth((int)(t.b(getContext()) * 0.53D));
    this.c.setUseSystemDefault(true);
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */