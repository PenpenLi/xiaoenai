package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.classes.home.view.wiget.RoundRectangleLayout;
import com.xiaoenai.app.ui.component.view.AvatarView;

public class am<T extends LoverSearchView>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public am(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.backgrandView = paramFinder.findRequiredView(paramObject, 2131559482, "field 'backgrandView'");
    View localView = paramFinder.findRequiredView(paramObject, 2131559487, "field 'cleanView' and method 'cleanEditView'");
    paramT.cleanView = ((ImageView)paramFinder.castView(localView, 2131559487, "field 'cleanView'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new an(this, paramT));
    paramT.searchLayout = paramFinder.findRequiredView(paramObject, 2131559483, "field 'searchLayout'");
    paramT.searchEdit = ((EditText)paramFinder.findRequiredViewAsType(paramObject, 2131558813, "field 'searchEdit'", EditText.class));
    paramT.searchBtn = ((RoundRectangleLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559486, "field 'searchBtn'", RoundRectangleLayout.class));
    paramT.copyBtn = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559489, "field 'copyBtn'", ImageView.class));
    paramT.MyUserIdText = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559488, "field 'MyUserIdText'", TextView.class));
    paramT.waitingLayout = paramFinder.findRequiredView(paramObject, 2131559490, "field 'waitingLayout'");
    paramT.cancelRequestBtn = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559492, "field 'cancelRequestBtn'", ImageView.class));
    paramT.imgAvatar = ((AvatarView)paramFinder.findRequiredViewAsType(paramObject, 2131559491, "field 'imgAvatar'", AvatarView.class));
  }
  
  public void unbind()
  {
    LoverSearchView localLoverSearchView = this.a;
    if (localLoverSearchView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLoverSearchView.backgrandView = null;
    localLoverSearchView.cleanView = null;
    localLoverSearchView.searchLayout = null;
    localLoverSearchView.searchEdit = null;
    localLoverSearchView.searchBtn = null;
    localLoverSearchView.copyBtn = null;
    localLoverSearchView.MyUserIdText = null;
    localLoverSearchView.waitingLayout = null;
    localLoverSearchView.cancelRequestBtn = null;
    localLoverSearchView.imgAvatar = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */