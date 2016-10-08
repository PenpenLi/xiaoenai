package com.xiaoenai.app.feature.feedback.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.xiaoenai.app.feature.feedback.view.b.b;
import com.xiaoenai.app.feature.feedback.view.b.d;
import com.xiaoenai.app.feature.feedback.view.widget.BaseItemView.a;
import com.xiaoenai.app.feature.feedback.view.widget.TipTextItemView;
import com.xiaoenai.app.feature.feedback.view.widget.i;
import com.xiaoenai.app.feature.feedback.view.widget.l;
import java.util.List;

public class a
  extends RecyclerView.Adapter<com.xiaoenai.app.feature.feedback.view.b.a>
{
  public List<com.xiaoenai.app.feature.feedback.b.c> a = null;
  private Context b;
  private BaseItemView.a c;
  
  public a(Context paramContext, List<com.xiaoenai.app.feature.feedback.b.c> paramList, BaseItemView.a parama)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = parama;
  }
  
  public com.xiaoenai.app.feature.feedback.view.b.a a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = null;
    if (paramInt == 11) {
      paramViewGroup = new com.xiaoenai.app.feature.feedback.view.b.c(new l(this.b, this.c));
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 12) {
        return new b(new i(this.b, this.c));
      }
    } while (paramInt != 13);
    return new d(new TipTextItemView(this.b));
  }
  
  public void a(com.xiaoenai.app.feature.feedback.view.b.a parama, int paramInt)
  {
    com.xiaoenai.app.feature.feedback.b.c localc;
    if ((parama != null) && (getItemCount() > 0))
    {
      localc = (com.xiaoenai.app.feature.feedback.b.c)this.a.get(paramInt);
      if (paramInt != this.a.size() - 1) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      parama.a(localc, bool);
      return;
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItemCount() > 0) && (paramInt >= 0) && (paramInt < getItemCount()))
    {
      com.xiaoenai.app.feature.feedback.b.c localc = (com.xiaoenai.app.feature.feedback.b.c)this.a.get(paramInt);
      if (localc != null)
      {
        if (localc.b().equals("text")) {
          return 11;
        }
        if (localc.b().equals("photo")) {
          return 12;
        }
        if (localc.b().equals("tip")) {
          return 13;
        }
      }
    }
    return 10;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */