package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.xiaoenai.app.classes.street.a.o;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.utils.ab;
import java.util.List;

public class e
  extends RecyclerView.ItemDecoration
{
  private int a;
  private Drawable b;
  private int c;
  private o d;
  
  public e(Drawable paramDrawable, int paramInt1, int paramInt2, o paramo)
  {
    this.a = paramInt1;
    this.b = paramDrawable;
    this.c = paramInt2;
    this.d = paramo;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.a = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (this.b == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramRecyclerView.getChildLayoutPosition(paramView);
        if (1 != this.c) {
          break;
        }
      } while (this.d.getItemViewType(i) != 11);
      paramRect.top = ab.a(6.0F);
      return;
      if (this.d.getItemViewType(i) == 10) {
        paramRect.top = ab.a(6.0F);
      }
    } while (this.d.getItemViewType(i) != 12);
    if ((this.d.b() != null) && ((this.d.b().get(0) instanceof Banner[]))) {
      if (i % 2 > 0)
      {
        paramRect.left = this.a;
        paramRect.right = (this.a / 2);
      }
    }
    for (;;)
    {
      paramRect.top = this.a;
      return;
      paramRect.left = (this.a / 2);
      paramRect.right = this.a;
      continue;
      if (i % 2 == 0)
      {
        paramRect.left = this.a;
        paramRect.right = (this.a / 2);
      }
      else
      {
        paramRect.left = (this.a / 2);
        paramRect.right = this.a;
      }
    }
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int m;
    int i;
    label34:
    int i2;
    int i3;
    int n;
    int i1;
    if (1 == this.c)
    {
      if ((LinearLayoutManager)paramRecyclerView.getLayoutManager() == null) {
        return;
      }
      int k = paramRecyclerView.getChildCount();
      m = paramRecyclerView.getWidth();
      i = 0;
      if (i < k)
      {
        paramState = paramRecyclerView.getChildAt(i);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
        j = paramRecyclerView.getChildAdapterPosition(paramState);
        i2 = paramRecyclerView.getPaddingLeft();
        i3 = paramState.getPaddingLeft();
        n = paramState.getBottom() + localLayoutParams.bottomMargin;
        i1 = this.a;
        if ((j + 1 >= this.d.getItemCount()) || (this.d.getItemViewType(j) != 12) || (this.d.getItemViewType(j + 1) == 12)) {
          break label187;
        }
      }
    }
    label187:
    for (int j = paramRecyclerView.getPaddingLeft();; j = i2 + i3)
    {
      this.b.setBounds(j, n, m, n + i1);
      this.b.draw(paramCanvas);
      i += 1;
      break label34;
      break;
      super.onDrawOver(paramCanvas, paramRecyclerView, paramState);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */