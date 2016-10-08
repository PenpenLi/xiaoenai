package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

class cg
{
  @VisibleForTesting
  final ArrayMap<RecyclerView.ViewHolder, a> a = new ArrayMap();
  @VisibleForTesting
  final LongSparseArray<RecyclerView.ViewHolder> b = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    int i = this.a.indexOfKey(paramViewHolder);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    a locala;
    do
    {
      do
      {
        return (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1;
        locala = (a)this.a.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.a & paramInt) == 0);
    locala.a &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramViewHolder = locala.b;; paramViewHolder = locala.c)
    {
      localObject1 = paramViewHolder;
      if ((locala.a & 0xC) != 0) {
        break;
      }
      this.a.removeAt(i);
      a.a(locala);
      return paramViewHolder;
      if (paramInt != 8) {
        break label128;
      }
    }
    label128:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  RecyclerView.ViewHolder a(long paramLong)
  {
    return (RecyclerView.ViewHolder)this.b.get(paramLong);
  }
  
  void a()
  {
    this.a.clear();
    this.b.clear();
  }
  
  void a(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    this.b.put(paramLong, paramViewHolder);
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    a locala2 = (a)this.a.get(paramViewHolder);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramViewHolder, locala1);
    }
    locala1.b = paramItemHolderInfo;
    locala1.a |= 0x4;
  }
  
  void a(b paramb)
  {
    int i = this.a.size() - 1;
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.a.keyAt(i);
      a locala = (a)this.a.removeAt(i);
      if ((locala.a & 0x3) == 3) {
        paramb.a(localViewHolder);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.a & 0x1) != 0)
        {
          if (locala.b == null) {
            paramb.a(localViewHolder);
          } else {
            paramb.a(localViewHolder, locala.b, locala.c);
          }
        }
        else if ((locala.a & 0xE) == 14) {
          paramb.b(localViewHolder, locala.b, locala.c);
        } else if ((locala.a & 0xC) == 12) {
          paramb.c(localViewHolder, locala.b, locala.c);
        } else if ((locala.a & 0x4) != 0) {
          paramb.a(localViewHolder, locala.b, null);
        } else if ((locala.a & 0x8) != 0) {
          paramb.b(localViewHolder, locala.b, locala.c);
        } else if ((locala.a & 0x2) == 0) {}
      }
    }
  }
  
  boolean a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (a)this.a.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.a & 0x1) != 0);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder paramViewHolder)
  {
    return a(paramViewHolder, 4);
  }
  
  void b() {}
  
  void b(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    a locala2 = (a)this.a.get(paramViewHolder);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramViewHolder, locala1);
    }
    locala1.a |= 0x2;
    locala1.b = paramItemHolderInfo;
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo c(RecyclerView.ViewHolder paramViewHolder)
  {
    return a(paramViewHolder, 8);
  }
  
  void c(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    a locala2 = (a)this.a.get(paramViewHolder);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramViewHolder, locala1);
    }
    locala1.c = paramItemHolderInfo;
    locala1.a |= 0x8;
  }
  
  boolean d(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (a)this.a.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.a & 0x4) != 0);
  }
  
  void e(RecyclerView.ViewHolder paramViewHolder)
  {
    a locala2 = (a)this.a.get(paramViewHolder);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.a();
      this.a.put(paramViewHolder, locala1);
    }
    locala1.a |= 0x1;
  }
  
  void f(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (a)this.a.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.a &= 0xFFFFFFFE;
  }
  
  void g(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = this.b.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramViewHolder == this.b.valueAt(i)) {
          this.b.removeAt(i);
        }
      }
      else
      {
        paramViewHolder = (a)this.a.remove(paramViewHolder);
        if (paramViewHolder != null) {
          a.a(paramViewHolder);
        }
        return;
      }
      i -= 1;
    }
  }
  
  public void h(RecyclerView.ViewHolder paramViewHolder)
  {
    f(paramViewHolder);
  }
  
  static class a
  {
    static Pools.Pool<a> d = new Pools.SimplePool(20);
    int a;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo b;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo c;
    
    static a a()
    {
      a locala2 = (a)d.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void a(a parama)
    {
      parama.a = 0;
      parama.b = null;
      parama.c = null;
      d.release(parama);
    }
    
    static void b()
    {
      while (d.acquire() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void a(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void b(RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void c(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */