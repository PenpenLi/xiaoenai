package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.StreetWebPageActivity;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.widget.ad;

class at
  implements View.OnClickListener
{
  at(aq paramaq) {}
  
  public void onClick(View paramView)
  {
    if (aq.c(this.a) != null)
    {
      paramView = new Intent();
      paramView.putExtra("html", aq.c(this.a).getDetailPage());
      paramView.putExtra("title", aq.a(this.a).getString(2131101449));
      paramView.setClass(aq.b(this.a).getActivity(), StreetWebPageActivity.class);
      aq.b(this.a).startActivity(paramView);
      aq.b(this.a).getActivity().overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */