package com.xiaoenai.app.classes.street.d;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.xiaoenai.app.classes.common.a.a;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout.a;

class az
  implements View.OnClickListener
{
  az(ay paramay) {}
  
  public void onClick(View paramView)
  {
    paramView = ay.a(this.a);
    boolean bool;
    b localb;
    Bundle localBundle;
    if (!ay.a(this.a).isChecked())
    {
      bool = true;
      paramView.setIsChecked(bool);
      ay.b(this.a).i.setSelected(ay.a(this.a).isChecked());
      localb = new b();
      localBundle = new Bundle();
      if (!ay.a(this.a).isChecked()) {
        break label126;
      }
    }
    label126:
    for (paramView = "street_order_select_action";; paramView = "street_order_unselect_action")
    {
      localBundle.putString("street_order_op_key", paramView);
      localBundle.putParcelable(paramView, ay.a(this.a));
      localb.a(localBundle);
      a.a().a(833L, localb);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */