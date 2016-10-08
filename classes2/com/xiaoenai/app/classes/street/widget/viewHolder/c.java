package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class c<T extends StreetProductItemViewHolder>
  implements Unbinder
{
  protected T a;
  
  public c(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mProductImageView = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559872, "field 'mProductImageView'", ImageView.class));
    paramT.mProductTitleTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559874, "field 'mProductTitleTxt'", TextView.class));
    paramT.mProductPriceTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559875, "field 'mProductPriceTxt'", TextView.class));
    paramT.mProductOriginPriceTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559876, "field 'mProductOriginPriceTxt'", TextView.class));
    paramT.mProductGuaranteesTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559877, "field 'mProductGuaranteesTxt'", TextView.class));
    paramT.mProductSellingTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131560007, "field 'mProductSellingTxt'", TextView.class));
    paramT.mTodayImageView = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131560004, "field 'mTodayImageView'", ImageView.class));
  }
  
  public void unbind()
  {
    StreetProductItemViewHolder localStreetProductItemViewHolder = this.a;
    if (localStreetProductItemViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetProductItemViewHolder.mProductImageView = null;
    localStreetProductItemViewHolder.mProductTitleTxt = null;
    localStreetProductItemViewHolder.mProductPriceTxt = null;
    localStreetProductItemViewHolder.mProductOriginPriceTxt = null;
    localStreetProductItemViewHolder.mProductGuaranteesTxt = null;
    localStreetProductItemViewHolder.mProductSellingTxt = null;
    localStreetProductItemViewHolder.mTodayImageView = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */