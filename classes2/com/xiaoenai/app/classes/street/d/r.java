package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.street.StreetOrderDetailActivity.a;
import com.xiaoenai.app.classes.street.StreetOrderReviewsActivity;

class r
  implements View.OnClickListener
{
  r(i parami) {}
  
  public void onClick(View paramView)
  {
    paramView = i.a(this.a).p.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_key", i.c(this.a));
    localIntent.setClass(paramView, StreetOrderReviewsActivity.class);
    ((Activity)paramView).startActivityForResult(localIntent, 834);
    ((Activity)paramView).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */