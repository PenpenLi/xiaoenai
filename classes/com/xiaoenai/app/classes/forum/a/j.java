package com.xiaoenai.app.classes.forum.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.xiaoenai.app.classes.common.ads.AdsView;
import com.xiaoenai.app.classes.common.ads.a;
import com.xiaoenai.app.classes.common.ads.b;
import com.xiaoenai.app.classes.forum.ForumTopicActivity;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.widget.ForumPostLayoutView;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;

public class j
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context a;
  private ArrayList<a> b;
  private boolean c = true;
  private boolean d = false;
  private Object e = new Object();
  
  public j(Context paramContext, ArrayList<a> paramArrayList)
  {
    this.a = paramContext;
    this.b = paramArrayList;
  }
  
  public a a(int paramInt)
  {
    if (this.b != null) {
      return (a)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<a> paramArrayList)
  {
    this.b = paramArrayList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(ArrayList<a> paramArrayList)
  {
    this.b.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.b != null) {
      i = this.b.size();
    }
    int j = i;
    if (i >= 20)
    {
      j = i;
      if (this.c) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramInt == getCount() - 1) && (getCount() >= 20) && (this.c))
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
    paramViewGroup = a(paramInt);
    if (paramViewGroup.a() == 4)
    {
      paramView = new AdsView(this.a);
      localObject = new b();
      ((b)localObject).a(paramViewGroup);
      ((b)localObject).a((AdsView)paramView);
      ((b)localObject).a();
      ((b)localObject).b();
      return paramView;
    }
    Post localPost = (Post)paramViewGroup;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new ForumPostLayoutView(this.a);
      paramView.setTag(paramView);
    }
    for (paramViewGroup = paramView;; paramViewGroup = (ViewGroup)localObject)
    {
      localObject = new ForumTopicViewPresenter(0, this.a, paramView.getViewHolder());
      ((ForumTopicViewPresenter)localObject).a(localPost);
      ((ForumTopicViewPresenter)localObject).a(2);
      paramView.setCardType(0);
      ((ForumTopicViewPresenter)localObject).b();
      return paramViewGroup;
      paramViewGroup = (ForumPostLayoutView)paramView.getTag();
      localObject = (View)paramView.getTag();
      paramView = paramViewGroup;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.c) && (paramInt - 1 == this.b.size()) && (paramView.getTag() == null)) {
      return;
    }
    paramAdapterView = new Intent();
    paramAdapterView.setClass(this.a, ForumTopicActivity.class);
    paramAdapterView.putExtra("forum_topic_key", (Post)a(paramInt - 1));
    ((Activity)this.a).startActivityForResult(paramAdapterView, 2);
    ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */