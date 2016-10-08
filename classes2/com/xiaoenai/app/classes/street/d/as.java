package com.xiaoenai.app.classes.street.d;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetCommentsAvtivity;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.widget.ad;

class as
  implements View.OnClickListener
{
  as(aq paramaq, ProductInfo paramProductInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("product_id", this.a.getId());
    paramView.setClass(aq.b(this.b).getActivity(), StreetCommentsAvtivity.class);
    aq.b(this.b).startActivityForResult(paramView, 1);
    aq.b(this.b).getActivity().overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */