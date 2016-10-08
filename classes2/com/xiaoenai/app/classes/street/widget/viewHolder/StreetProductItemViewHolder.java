package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;
import com.xiaoenai.app.classes.street.widget.a;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.e.b;

public class StreetProductItemViewHolder
  extends f
  implements View.OnClickListener
{
  private a e;
  @BindView(2131559877)
  TextView mProductGuaranteesTxt;
  @BindView(2131559872)
  ImageView mProductImageView;
  @BindView(2131559876)
  TextView mProductOriginPriceTxt;
  @BindView(2131559875)
  TextView mProductPriceTxt;
  @BindView(2131560007)
  TextView mProductSellingTxt;
  @BindView(2131559874)
  TextView mProductTitleTxt;
  @BindView(2131560004)
  ImageView mTodayImageView;
  
  public StreetProductItemViewHolder(View paramView, a parama)
  {
    super(paramView);
    this.e = parama;
    ButterKnife.bind(this, paramView);
    paramView.setOnClickListener(this);
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
      this.mProductImageView.setImageResource(2130838959);
      b.a(this.mProductImageView, paramProductItemInfo.getImage().getUrl());
      Object localObject = new ImageSpan(this.mProductTitleTxt.getContext(), a(paramProductItemInfo.getFrom()));
      SpannableString localSpannableString = new SpannableString("   " + paramProductItemInfo.getTitle());
      localSpannableString.setSpan(localObject, 0, 2, 17);
      this.mProductTitleTxt.setText(localSpannableString);
      localObject = this.mProductPriceTxt.getResources().getString(2131101450);
      this.mProductPriceTxt.setText((String)localObject + ea.a(paramProductItemInfo.getPrice()));
      this.mProductOriginPriceTxt.setText((String)localObject + ea.a(paramProductItemInfo.getOrigin_price()));
      this.mProductOriginPriceTxt.setPaintFlags(this.mProductOriginPriceTxt.getPaintFlags() | 0x10);
      if (ae.a(paramProductItemInfo.getGuarantees())) {
        break label271;
      }
      this.mProductGuaranteesTxt.setVisibility(0);
      this.mProductGuaranteesTxt.setText(paramProductItemInfo.getGuarantees());
      if (ae.a(paramProductItemInfo.getSelling_text())) {
        break label283;
      }
      this.mProductSellingTxt.setVisibility(0);
      this.mProductSellingTxt.setText(paramProductItemInfo.getSelling_text());
      label247:
      if (!paramProductItemInfo.isToday()) {
        break label295;
      }
      this.mTodayImageView.setVisibility(0);
    }
    for (;;)
    {
      this.itemView.setTag(paramProductItemInfo);
      return;
      label271:
      this.mProductGuaranteesTxt.setVisibility(8);
      break;
      label283:
      this.mProductSellingTxt.setVisibility(8);
      break label247;
      label295:
      this.mTodayImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.e != null) {
      this.e.a(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\StreetProductItemViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */