package com.marshalchen.ultimaterecyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class c
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.b = paramInt3;
    this.d = paramInt4;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramRect.bottom = this.d;
    paramRect.top = this.c;
    paramRect.left = this.a;
    paramRect.right = this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */