package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

final class ac
  implements ao.a
{
  private static final String a = ac.class.getSimpleName();
  private static Handler i = new Handler(Looper.getMainLooper());
  @NonNull
  private final Context b;
  @NonNull
  private final x c;
  @NonNull
  private final y d;
  @Nullable
  private b e;
  @Nullable
  private a f;
  private int g = 0;
  @NonNull
  private aj h;
  private boolean j = false;
  
  ac(@NonNull Context paramContext, @NonNull x paramx, @Nullable b paramb, @Nullable a parama)
  {
    this.b = paramContext;
    this.c = paramx;
    this.h = aj.a(paramContext);
    this.e = paramb;
    this.f = parama;
    this.d = new y(paramx, this);
  }
  
  private ViewGroup b(@NonNull ViewGroup paramViewGroup1, @NonNull ViewGroup paramViewGroup2, @NonNull v paramv)
  {
    paramViewGroup2 = paramv.iterator();
    while (paramViewGroup2.hasNext())
    {
      paramv = (NativeStrandAsset)paramViewGroup2.next();
      Object localObject;
      if (NativeStrandAsset.AssetType.ASSET_TYPE_CONTAINER == paramv.a())
      {
        if (paramv.c().equalsIgnoreCase("card_scrollable"))
        {
          localObject = (ao)this.h.a(this.b, paramv);
          ((ao)localObject).a((v)paramv, this.d, this.g, c(), this);
          paramViewGroup1.addView((View)localObject, aj.a(paramv, paramViewGroup1));
        }
        else
        {
          paramViewGroup1.addView(b((ViewGroup)aj.a(this.b).a(this.b, paramv), paramViewGroup1, (v)paramv), aj.a(paramv, paramViewGroup1));
        }
      }
      else
      {
        localObject = aj.a(this.b).a(this.b, paramv);
        if (localObject != null)
        {
          paramViewGroup1.addView((View)localObject, aj.a(paramv, paramViewGroup1));
          if (paramv.g()) {
            ((View)localObject).setOnClickListener(new ac.2(this, paramv));
          }
        }
      }
    }
    return paramViewGroup1;
  }
  
  private int c()
  {
    if (this.g == 0) {
      return 8388611;
    }
    if (this.c.d() - 1 == this.g) {
      return 8388613;
    }
    return 1;
  }
  
  int a()
  {
    return this.g;
  }
  
  public int a(int paramInt)
  {
    this.g = paramInt;
    if (this.e != null) {
      this.e.a(paramInt, this.c.a(paramInt));
    }
    return c();
  }
  
  public ViewGroup a(@NonNull ViewGroup paramViewGroup1, @NonNull ViewGroup paramViewGroup2, @NonNull v paramv)
  {
    return b(paramViewGroup1, paramViewGroup2, paramv);
  }
  
  public ViewGroup a(@NonNull ViewGroup paramViewGroup, @NonNull v paramv)
  {
    ViewGroup localViewGroup = (ViewGroup)this.h.a(this.b, paramv);
    localViewGroup.setLayoutParams(aj.a(paramv, paramViewGroup));
    return localViewGroup;
  }
  
  public ag a(@Nullable ag paramag, @NonNull ViewGroup paramViewGroup)
  {
    if (paramag == null) {
      paramag = (ag)this.h.a(this.b, this.c.a());
    }
    for (;;)
    {
      if (paramag.getChildCount() > 0)
      {
        aj.a(this.b).a(paramag);
        aj.a(paramag, this.c.a().b());
      }
      paramag.setLayoutParams(aj.a(this.c.a(), paramViewGroup));
      i.post(new ac.1(this, paramag, paramViewGroup));
      return paramag;
    }
  }
  
  void a(@NonNull View paramView)
  {
    this.h.a(paramView);
  }
  
  void b()
  {
    this.j = true;
    this.d.a();
  }
  
  static abstract interface a
  {
    public abstract void a(NativeStrandAsset paramNativeStrandAsset);
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, NativeStrandAsset paramNativeStrandAsset);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */