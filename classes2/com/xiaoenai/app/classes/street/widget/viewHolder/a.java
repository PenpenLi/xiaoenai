package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class a<T extends StreetGridProductItemViewHolder>
  implements Unbinder
{
  protected T a;
  
  public a(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mProductImageView = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559872, "field 'mProductImageView'", ImageView.class));
    paramT.mProductTitleTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559874, "field 'mProductTitleTxt'", TextView.class));
    paramT.mProductPriceTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559875, "field 'mProductPriceTxt'", TextView.class));
    paramT.mProductOriginPriceTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559876, "field 'mProductOriginPriceTxt'", TextView.class));
    paramT.mProductGuaranteesTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559877, "field 'mProductGuaranteesTxt'", TextView.class));
    paramT.mNewImageView = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559873, "field 'mNewImageView'", ImageView.class));
  }
  
  public void unbind()
  {
    StreetGridProductItemViewHolder localStreetGridProductItemViewHolder = this.a;
    if (localStreetGridProductItemViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetGridProductItemViewHolder.mProductImageView = null;
    localStreetGridProductItemViewHolder.mProductTitleTxt = null;
    localStreetGridProductItemViewHolder.mProductPriceTxt = null;
    localStreetGridProductItemViewHolder.mProductOriginPriceTxt = null;
    localStreetGridProductItemViewHolder.mProductGuaranteesTxt = null;
    localStreetGridProductItemViewHolder.mNewImageView = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */