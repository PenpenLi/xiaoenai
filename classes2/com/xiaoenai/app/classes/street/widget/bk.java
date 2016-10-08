package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class bk<T extends StreetSceneView>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public bk(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mProductRecyclerView = ((RefreshCustomUltimateRecyclerview)paramFinder.findRequiredViewAsType(paramObject, 2131560053, "field 'mProductRecyclerView'", RefreshCustomUltimateRecyclerview.class));
    paramT.progressView = ((ProgressView)paramFinder.findRequiredViewAsType(paramObject, 2131558669, "field 'progressView'", ProgressView.class));
    paramObject = paramFinder.findRequiredView(paramObject, 2131560056, "field 'mProductNewCountTextView' and method 'productNewCountTextClick'");
    paramT.mProductNewCountTextView = ((TextView)paramFinder.castView((View)paramObject, 2131560056, "field 'mProductNewCountTextView'", TextView.class));
    this.b = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new bl(this, paramT));
  }
  
  public void unbind()
  {
    StreetSceneView localStreetSceneView = this.a;
    if (localStreetSceneView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetSceneView.mProductRecyclerView = null;
    localStreetSceneView.progressView = null;
    localStreetSceneView.mProductNewCountTextView = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */