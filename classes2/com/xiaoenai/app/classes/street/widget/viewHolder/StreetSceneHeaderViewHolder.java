package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.utils.ae;

public class StreetSceneHeaderViewHolder
  extends f
{
  @BindView(2131559367)
  TextView mHeaderText;
  
  public StreetSceneHeaderViewHolder(View paramView)
  {
    super(paramView);
    ButterKnife.bind(this, paramView);
  }
  
  public void a(String paramString)
  {
    if (!ae.a(paramString)) {
      this.mHeaderText.setText(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\StreetSceneHeaderViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */