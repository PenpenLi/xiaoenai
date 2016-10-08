package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;
import com.xiaoenai.app.classes.street.widget.a;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.e.b;

public class StreetGridProductItemViewHolder
  extends f
  implements View.OnClickListener
{
  private a e;
  private int f;
  @BindView(2131559873)
  ImageView mNewImageView;
  @BindView(2131559877)
  TextView mProductGuaranteesTxt;
  @BindView(2131559872)
  ImageView mProductImageView;
  @BindView(2131559876)
  TextView mProductOriginPriceTxt;
  @BindView(2131559875)
  TextView mProductPriceTxt;
  @BindView(2131559874)
  TextView mProductTitleTxt;
  
  public StreetGridProductItemViewHolder(View paramView, a parama)
  {
    super(paramView);
    this.e = parama;
    ButterKnife.bind(this, paramView);
    paramView.setOnClickListener(this);
    this.f = ((ab.b() - ab.a(6.0F) * 3) / 2);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 2130838619;
    case 1: 
      return 2130838610;
    }
    return 2130838614;
  }
  
  public void a(ProductItemInfo paramProductItemInfo)
  {
    if (paramProductItemInfo != null)
    {
      Object localObject = this.mProductImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.f;
      ((ViewGroup.LayoutParams)localObject).height = this.f;
      this.mProductImageView.setImageResource(2130838959);
      b.a(this.mProductImageView, paramProductItemInfo.getImage().getUrl());
      localObject = new ImageSpan(this.mProductTitleTxt.getContext(), a(paramProductItemInfo.getFrom()));
      SpannableString localSpannableString = new SpannableString("   " + paramProductItemInfo.getTitle());
      localSpannableString.setSpan(localObject, 0, 2, 17);
      this.mProductTitleTxt.setText(localSpannableString);
      localObject = this.mProductPriceTxt.getResources().getString(2131101450);
      this.mProductPriceTxt.setText((String)localObject + ea.a(paramProductItemInfo.getPrice()));
      this.mProductOriginPriceTxt.setText((String)localObject + ea.a(paramProductItemInfo.getOrigin_price()));
      this.mProductOriginPriceTxt.setPaintFlags(this.mProductOriginPriceTxt.getPaintFlags() | 0x10);
      if (ae.a(paramProductItemInfo.getGuarantees())) {
        break label266;
      }
      this.mProductGuaranteesTxt.setVisibility(0);
      this.mProductGuaranteesTxt.setText(paramProductItemInfo.getGuarantees());
      if (!paramProductItemInfo.isNew()) {
        break label278;
      }
      this.mNewImageView.setVisibility(0);
    }
    for (;;)
    {
      this.itemView.setTag(paramProductItemInfo);
      return;
      label266:
      this.mProductGuaranteesTxt.setVisibility(8);
      break;
      label278:
      this.mNewImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.e != null) {
      this.e.a(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\StreetGridProductItemViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */