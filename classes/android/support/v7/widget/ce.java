package android.support.v7.widget;

import android.support.v7.view.menu.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

class ce
  implements View.OnClickListener
{
  final a a = new a(ToolbarWidgetWrapper.access$000(this.b).getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.access$100(this.b));
  
  ce(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onClick(View paramView)
  {
    if ((ToolbarWidgetWrapper.access$200(this.b) != null) && (ToolbarWidgetWrapper.access$300(this.b))) {
      ToolbarWidgetWrapper.access$200(this.b).onMenuItemSelected(0, this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */