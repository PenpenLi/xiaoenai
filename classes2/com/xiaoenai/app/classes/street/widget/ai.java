package com.xiaoenai.app.classes.street.widget;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.k;

class ai
  implements View.OnClickListener
{
  ai(ad paramad) {}
  
  public void onClick(View paramView)
  {
    paramView = ad.h(this.a).findViewById(2131559998);
    if (paramView.getVisibility() == 0)
    {
      paramView.setVisibility(8);
      k.a(((BitmapDrawable)this.a.getResources().getDrawable(2130838709)).getBitmap(), (ImageView)ad.h(this.a).findViewById(2131559997), 90.0F);
      ad.h(this.a).findViewById(2131559997).getLayoutParams().height = -1;
      ad.h(this.a).findViewById(2131559997).getLayoutParams().width = ab.a(12.0F);
      return;
    }
    paramView.setVisibility(0);
    k.a(((BitmapDrawable)this.a.getResources().getDrawable(2130838709)).getBitmap(), (ImageView)ad.h(this.a).findViewById(2131559997), 270.0F);
    ad.h(this.a).findViewById(2131559997).getLayoutParams().height = -2;
    ad.h(this.a).findViewById(2131559997).getLayoutParams().width = ab.a(12.0F);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */