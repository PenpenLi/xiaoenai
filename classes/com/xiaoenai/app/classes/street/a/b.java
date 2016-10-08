package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.xiaoenai.app.classes.street.d.c.a;
import com.xiaoenai.app.classes.street.model.Comment;
import com.xiaoenai.app.classes.street.widget.StreetCommentLayout;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;

public class b
  extends BaseAdapter
{
  c.a a = new d(this);
  private Context b;
  private com.xiaoenai.app.classes.street.d.c c;
  private ArrayList<Comment> d = new ArrayList();
  private StreetCommentLayout e = null;
  private boolean f = true;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int a()
  {
    int i = 0;
    if (this.d != null) {
      i = this.d.size();
    }
    return i;
  }
  
  public Comment a(int paramInt)
  {
    if (this.d != null) {
      return (Comment)this.d.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<Comment> paramArrayList)
  {
    this.d = paramArrayList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(ArrayList<Comment> paramArrayList)
  {
    this.d.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.d != null) {
      i = this.d.size();
    }
    int j = i;
    if (i >= 20)
    {
      j = i;
      if (this.f) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt == getCount() - 1) && (paramInt >= 20) && (this.f))
    {
      paramView = new LinearLayout(this.b);
      paramViewGroup = new ProgressBar(this.b);
      paramViewGroup.setIndeterminateDrawable(this.b.getResources().getDrawable(2130838790));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ab.a(25.0F), ab.a(25.0F));
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = ab.a(5.0F);
      localLayoutParams.bottomMargin = ab.a(5.0F);
      localLayoutParams.leftMargin = ab.a(5.0F);
      localLayoutParams.rightMargin = ab.a(5.0F);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramView.setPadding(5, 5, 5, 5);
      ((LinearLayout)paramView).setGravity(17);
      ((LinearLayout)paramView).addView(paramViewGroup);
      return paramView;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new StreetCommentLayout(this.b);
      this.c = new com.xiaoenai.app.classes.street.d.c(this.b, this.a, paramInt, paramView, new c(this, paramView));
      paramView.setTag(this.c);
    }
    for (;;)
    {
      this.c.a(a(paramInt));
      this.c.a();
      return paramView;
      this.c = ((com.xiaoenai.app.classes.street.d.c)paramView.getTag());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */