package com.xiaoenai.app.classes.home.view.wiget;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class a<T extends HomeBaseView>
  implements Unbinder
{
  protected T a;
  
  public a(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mIcon = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558577, "field 'mIcon'", ImageView.class));
    paramT.mNameTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559378, "field 'mNameTxt'", TextView.class));
    paramT.mRemindButton = ((RemindButton)paramFinder.findRequiredViewAsType(paramObject, 2131559379, "field 'mRemindButton'", RemindButton.class));
  }
  
  public void unbind()
  {
    HomeBaseView localHomeBaseView = this.a;
    if (localHomeBaseView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localHomeBaseView.mIcon = null;
    localHomeBaseView.mNameTxt = null;
    localHomeBaseView.mRemindButton = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\wiget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */