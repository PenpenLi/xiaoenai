package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.CustomGridLayoutManager;
import com.xiaoenai.app.classes.home.a.k;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.view.a.a;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder.a;
import com.xiaoenai.app.classes.home.view.viewHolder.b;
import java.util.List;

public class LifeServiceLayout
  extends LinearLayout
{
  private a a;
  private b b;
  private LifeServiceItemViewHolder.a c;
  @BindView(2131559570)
  RecyclerView mStreetGuideRecyclerView;
  @BindView(2131559569)
  TextView mTitleView;
  
  public LifeServiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LifeServiceLayout(Context paramContext, LifeServiceItemViewHolder.a parama)
  {
    super(paramContext);
    this.c = parama;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    ButterKnife.bind(this, LinearLayout.inflate(paramContext, 2130903265, this));
    this.a = new a(this.c);
    this.b = new b(getContext(), 1, this.a);
    this.mStreetGuideRecyclerView.addItemDecoration(this.b);
    this.mStreetGuideRecyclerView.setAdapter(this.a);
    this.mTitleView.setText(k.a().f());
  }
  
  public void a(List<HomeDiscoverItem> paramList)
  {
    this.a.a(paramList);
    int j = this.a.a() / 4;
    if (this.a.a() % 4 == 0) {}
    for (int i = 0;; i = 1)
    {
      paramList = new CustomGridLayoutManager(getContext(), 4, i + j + 1);
      paramList.setSpanSizeLookup(new y(this));
      this.mStreetGuideRecyclerView.setLayoutManager(paramList);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\LifeServiceLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */