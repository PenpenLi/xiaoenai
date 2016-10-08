package com.xiaoenai.app.classes.forum.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.marshalchen.ultimaterecyclerview.e;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.forum.viewholder.ForumNotifyViewHolder;
import com.xiaoenai.app.model.g;
import java.util.List;

public class k
  extends e<g>
  implements View.OnClickListener
{
  public final int f = 4;
  private a g;
  private boolean h;
  
  public k(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.h = paramBoolean;
  }
  
  public int a()
  {
    if (this.h) {
      return super.a() + 1;
    }
    return super.a();
  }
  
  public f a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
    {
      paramViewGroup = View.inflate(paramViewGroup.getContext(), 2130903207, null);
      paramViewGroup.setOnClickListener(this);
      return new ForumNotifyViewHolder(paramViewGroup);
    }
    if (4 == paramInt)
    {
      paramViewGroup = View.inflate(paramViewGroup.getContext(), 2130903208, null);
      paramViewGroup.setOnClickListener(this);
      return new f(paramViewGroup);
    }
    return (f)super.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void a(f paramf, int paramInt)
  {
    g localg;
    if ((this.a != null) && (paramInt < this.a.size()))
    {
      localg = (g)this.a.get(paramInt);
      if (paramInt != this.a.size() - 1) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      paramf.a(localg, paramInt, bool);
      paramf.itemView.setTag(2131558460, localg);
      return;
    }
  }
  
  public void a(a parama)
  {
    this.g = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    notifyDataSetChanged();
  }
  
  public f b(ViewGroup paramViewGroup)
  {
    return new f(new TextView(paramViewGroup.getContext()));
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = super.getItemViewType(paramInt);
    int i = j;
    if (j == 0) {
      if (this.a != null)
      {
        i = j;
        if (paramInt < this.a.size()) {}
      }
      else
      {
        i = 4;
      }
    }
    return i;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131558460);
    if (this.g != null)
    {
      if (localObject != null) {
        this.g.a(paramView, (g)localObject);
      }
    }
    else {
      return;
    }
    this.g.onNewMoreClick(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, g paramg);
    
    public abstract void onNewMoreClick(View paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */