package com.xiaoenai.app.classes.forum.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.ads.AdsView;
import com.xiaoenai.app.classes.forum.presenter.o;
import com.xiaoenai.app.classes.forum.widget.ForumNotiTopicView;
import com.xiaoenai.app.classes.forum.widget.ForumReplyLayout;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;

public class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  private Context a;
  private com.xiaoenai.app.classes.forum.presenter.b b;
  private ArrayList<com.xiaoenai.app.classes.common.ads.a> c = new ArrayList();
  private ForumReplyLayout d = null;
  private boolean e = true;
  private int f;
  private boolean g = true;
  private View.OnClickListener h = null;
  
  public b(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.f = paramInt;
  }
  
  public int a()
  {
    int i = 0;
    if (this.c != null) {
      i = this.c.size();
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
  
  public void a(com.xiaoenai.app.classes.common.ads.a parama)
  {
    this.c.add(0, parama);
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<com.xiaoenai.app.classes.common.ads.a> paramArrayList)
  {
    this.c = paramArrayList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public com.xiaoenai.app.classes.common.ads.a b(int paramInt)
  {
    if ((this.c != null) && (this.c.size() > 0)) {
      return (com.xiaoenai.app.classes.common.ads.a)this.c.get(paramInt);
    }
    return null;
  }
  
  public void b()
  {
    this.c.clear();
  }
  
  public void b(ArrayList<com.xiaoenai.app.classes.common.ads.a> paramArrayList)
  {
    this.c.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.c != null) {
      i = this.c.size();
    }
    int j;
    if ((i < 20) || (!this.g))
    {
      j = i;
      if (!this.e) {}
    }
    else
    {
      j = i + 1;
    }
    return j;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (((paramInt == getCount() - 1) && (paramInt >= 20) && (this.g)) || ((paramInt == getCount() - 1) && (this.e)))
    {
      paramView = new LinearLayout(this.a);
      paramViewGroup = new ProgressBar(this.a);
      paramViewGroup.setIndeterminateDrawable(this.a.getResources().getDrawable(2130838790));
      localObject = new LinearLayout.LayoutParams(ab.a(25.0F), ab.a(25.0F));
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      ((LinearLayout.LayoutParams)localObject).topMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = ab.a(5.0F);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setPadding(5, 5, 5, 5);
      ((LinearLayout)paramView).setGravity(17);
      ((LinearLayout)paramView).addView(paramViewGroup);
      return paramView;
    }
    paramViewGroup = b(paramInt);
    if (paramViewGroup.a() == 4)
    {
      if (paramViewGroup.h() != 3)
      {
        paramViewGroup.b(2);
        paramView = new AdsView(this.a);
        localObject = new com.xiaoenai.app.classes.common.ads.b();
        com.xiaoenai.app.utils.f.a.c("======================= FORUM_REPLY_ADS:", new Object[0]);
        ((com.xiaoenai.app.classes.common.ads.b)localObject).a(paramViewGroup);
        ((com.xiaoenai.app.classes.common.ads.b)localObject).a((AdsView)paramView);
        ((com.xiaoenai.app.classes.common.ads.b)localObject).a();
        ((com.xiaoenai.app.classes.common.ads.b)localObject).b();
        return paramView;
      }
      paramView = new ForumNotiTopicView(this.a);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, ab.a(60.0F)));
      paramView.getGetDetailBtn().setEnabled(false);
      paramView.setOnClickListener(new c(this));
      paramView.setTag(paramView);
      return paramView;
    }
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView instanceof ForumReplyLayout)))
    {
      paramView = new ForumReplyLayout(this.a);
      this.b = new o(this.a, this.f, new d(this), paramInt, paramView, new f(this, paramView));
      paramView.setTag(this.b);
    }
    for (;;)
    {
      ((o)this.b).a((com.xiaoenai.app.model.Forum.d)b(paramInt));
      this.b.a();
      return paramView;
      this.b = ((com.xiaoenai.app.classes.forum.presenter.b)paramView.getTag());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */