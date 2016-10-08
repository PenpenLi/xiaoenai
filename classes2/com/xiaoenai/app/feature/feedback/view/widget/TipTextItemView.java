package com.xiaoenai.app.feature.feedback.view.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.feature.feedback.b.f;
import com.xiaoenai.app.utils.d.t;

public class TipTextItemView
  extends RelativeLayout
{
  @BindView(2131230876)
  RelativeLayout rlTipRoot;
  @BindView(2131230877)
  TextView tvTip;
  
  public TipTextItemView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(a.e.view_item_tip, this);
    ButterKnife.bind(this);
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    paramc = (f)paramc;
    this.tvTip.setText(paramc.i());
    paramc = (RelativeLayout.LayoutParams)this.rlTipRoot.getLayoutParams();
    if (paramBoolean) {}
    for (paramc.bottomMargin = t.a(getContext(), 20.0F);; paramc.bottomMargin = t.a(getContext(), 0.0F))
    {
      this.rlTipRoot.setLayoutParams(paramc);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\TipTextItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */