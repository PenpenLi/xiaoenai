package com.xiaoenai.app.classes.home.view.viewHolder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xiaoenai.app.classes.home.view.a.a;

public class b
  extends RecyclerView.ItemDecoration
{
  private int a;
  private Drawable b;
  private a c;
  
  public b(Context paramContext, int paramInt, a parama)
  {
    this.a = paramInt;
    this.b = paramContext.getResources().getDrawable(2130837829);
    this.c = parama;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    int j = this.c.getItemCount() % 4;
    if (i == this.c.getItemCount() - 1) {
      paramRect.bottom = this.a;
    }
    if ((j == 0) && (i == this.c.getItemCount() - 4)) {
      paramRect.bottom = this.a;
    }
    if (((j == 2) || (j == 0)) && (i == this.c.getItemCount() - 2)) {
      paramRect.bottom = this.a;
    }
    if (((j == 3) || (j == 0)) && ((i == this.c.getItemCount() - 2) || (i == this.c.getItemCount() - 3))) {
      paramRect.bottom = this.a;
    }
    paramRect.right = this.a;
    paramRect.top = this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\viewHolder\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */