package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

class bn
  implements View.OnClickListener
{
  bn(SearchView paramSearchView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == SearchView.access$400(this.a)) {
      SearchView.access$500(this.a);
    }
    do
    {
      return;
      if (paramView == SearchView.access$600(this.a))
      {
        SearchView.access$700(this.a);
        return;
      }
      if (paramView == SearchView.access$800(this.a))
      {
        SearchView.access$900(this.a);
        return;
      }
      if (paramView == SearchView.access$1000(this.a))
      {
        SearchView.access$1100(this.a);
        return;
      }
    } while (paramView != SearchView.access$1200(this.a));
    SearchView.access$1300(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */