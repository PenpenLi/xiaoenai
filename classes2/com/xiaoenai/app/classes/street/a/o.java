package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.marshalchen.ultimaterecyclerview.e;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;
import com.xiaoenai.app.classes.street.model.SceneTextType;
import com.xiaoenai.app.classes.street.widget.StreetImageViewPager;
import com.xiaoenai.app.classes.street.widget.StreetImageViewPager.d;
import com.xiaoenai.app.classes.street.widget.a;
import com.xiaoenai.app.classes.street.widget.viewHolder.StreetGridProductItemViewHolder;
import com.xiaoenai.app.classes.street.widget.viewHolder.StreetProductItemViewHolder;
import com.xiaoenai.app.classes.street.widget.viewHolder.StreetSceneHeaderViewHolder;
import com.xiaoenai.app.classes.street.widget.viewHolder.b;
import java.util.List;

public class o
  extends e<Object>
{
  private int f = 0;
  private int g = 0;
  private StreetImageViewPager.d h = null;
  private a i;
  
  public o(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.f = paramInt;
  }
  
  public f a(ViewGroup paramViewGroup, int paramInt)
  {
    if (10 == paramInt) {
      return new b(new StreetImageViewPager(paramViewGroup.getContext()), this.h);
    }
    if (11 == paramInt) {
      return new StreetSceneHeaderViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903364, null));
    }
    if (12 == paramInt)
    {
      if (1 == this.f) {
        return new StreetProductItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903357, null), this.i);
      }
      return new StreetGridProductItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903342, null), this.i);
    }
    if (13 == paramInt) {
      return new StreetSceneHeaderViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903346, null));
    }
    if (14 == paramInt) {
      return new StreetSceneHeaderViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903366, null));
    }
    return (f)super.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(f paramf, int paramInt)
  {
    if (10 == getItemViewType(paramInt))
    {
      localObject = (Banner[])this.a.get(paramInt);
      ((b)paramf).a((Banner[])localObject);
    }
    do
    {
      return;
      if (11 == getItemViewType(paramInt))
      {
        localObject = (SceneTextType)this.a.get(paramInt);
        ((StreetSceneHeaderViewHolder)paramf).a(((SceneTextType)localObject).getText());
        return;
      }
      if (12 == getItemViewType(paramInt))
      {
        localObject = (ProductItemInfo)this.a.get(paramInt);
        if (1 == this.f)
        {
          ((StreetProductItemViewHolder)paramf).a((ProductItemInfo)localObject);
          return;
        }
        ((StreetGridProductItemViewHolder)paramf).a((ProductItemInfo)localObject);
        return;
      }
      if (13 == getItemViewType(paramInt))
      {
        localObject = (SceneTextType)this.a.get(paramInt);
        ((StreetSceneHeaderViewHolder)paramf).a(((SceneTextType)localObject).getText());
        return;
      }
    } while (14 != getItemViewType(paramInt));
    Object localObject = (SceneTextType)this.a.get(paramInt);
    ((StreetSceneHeaderViewHolder)paramf).a(((SceneTextType)localObject).getText());
  }
  
  public void a(StreetImageViewPager.d paramd)
  {
    this.h = paramd;
  }
  
  public void a(a parama)
  {
    this.i = parama;
  }
  
  public f b(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.g += paramInt;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = super.getItemViewType(paramInt);
    int k = j;
    if (j == 0)
    {
      k = j;
      if (this.a != null)
      {
        if (!(this.a.get(paramInt) instanceof Banner[])) {
          break label46;
        }
        k = 10;
      }
    }
    return k;
    label46:
    SceneTextType localSceneTextType;
    if ((this.a.get(paramInt) instanceof SceneTextType))
    {
      localSceneTextType = (SceneTextType)this.a.get(paramInt);
      if (1 == localSceneTextType.getType()) {
        paramInt = 11;
      }
    }
    for (;;)
    {
      return paramInt;
      if (localSceneTextType.getType() == 0)
      {
        paramInt = 13;
      }
      else
      {
        if (2 == localSceneTextType.getType())
        {
          paramInt = 14;
          continue;
          k = j;
          if (!(this.a.get(paramInt) instanceof ProductItemInfo)) {
            break;
          }
          return 12;
        }
        paramInt = j;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */