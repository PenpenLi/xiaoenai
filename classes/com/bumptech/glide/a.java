package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.f.f;
import com.bumptech.glide.g.b.j;
import com.bumptech.glide.manager.m;

public class a<ModelType, DataType, ResourceType, TranscodeType>
  implements Cloneable
{
  private boolean A;
  private Drawable B;
  private int C;
  protected final Class<ModelType> a;
  protected final Context b;
  protected final Glide c;
  protected final Class<TranscodeType> d;
  protected final m e;
  protected final com.bumptech.glide.manager.h f;
  private com.bumptech.glide.f.a<ModelType, DataType, ResourceType, TranscodeType> g;
  private ModelType h;
  private com.bumptech.glide.d.c i = com.bumptech.glide.h.a.a();
  private boolean j;
  private int k;
  private int l;
  private com.bumptech.glide.g.e<? super ModelType, TranscodeType> m;
  private Float n;
  private a<?, ?, ?, TranscodeType> o;
  private Float p = Float.valueOf(1.0F);
  private Drawable q;
  private Drawable r;
  private e s = null;
  private boolean t = true;
  private com.bumptech.glide.g.a.b<TranscodeType> u = com.bumptech.glide.g.a.c.a();
  private int v = -1;
  private int w = -1;
  private com.bumptech.glide.d.b.b x = com.bumptech.glide.d.b.b.d;
  private com.bumptech.glide.d.g<ResourceType> y = com.bumptech.glide.d.d.d.b();
  private boolean z;
  
  a(Context paramContext, Class<ModelType> paramClass, f<ModelType, DataType, ResourceType, TranscodeType> paramf, Class<TranscodeType> paramClass1, Glide paramGlide, m paramm, com.bumptech.glide.manager.h paramh)
  {
    this.b = paramContext;
    this.a = paramClass;
    this.d = paramClass1;
    this.c = paramGlide;
    this.e = paramm;
    this.f = paramh;
    paramClass1 = (Class<TranscodeType>)localObject;
    if (paramf != null) {
      paramClass1 = new com.bumptech.glide.f.a(paramf);
    }
    this.g = paramClass1;
    if (paramContext == null) {
      throw new NullPointerException("Context can't be null");
    }
    if ((paramClass != null) && (paramf == null)) {
      throw new NullPointerException("LoadProvider must not be null");
    }
  }
  
  private com.bumptech.glide.g.c a(j<TranscodeType> paramj, float paramFloat, e parame, com.bumptech.glide.g.d paramd)
  {
    return com.bumptech.glide.g.b.a(this.g, this.h, this.i, this.b, parame, paramj, paramFloat, this.q, this.k, this.r, this.l, this.B, this.C, this.m, paramd, this.c.getEngine(), this.y, this.d, this.t, this.u, this.w, this.v, this.x);
  }
  
  private com.bumptech.glide.g.c a(j<TranscodeType> paramj, com.bumptech.glide.g.g paramg)
  {
    if (this.o != null)
    {
      if (this.A) {
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
      }
      if (this.o.u.equals(com.bumptech.glide.g.a.c.a())) {
        this.o.u = this.u;
      }
      if (this.o.s == null) {
        this.o.s = b();
      }
      if ((com.bumptech.glide.i.h.a(this.w, this.v)) && (!com.bumptech.glide.i.h.a(this.o.w, this.o.v))) {
        this.o.a(this.w, this.v);
      }
      paramg = new com.bumptech.glide.g.g(paramg);
      com.bumptech.glide.g.c localc = a(paramj, this.p.floatValue(), this.s, paramg);
      this.A = true;
      paramj = this.o.a(paramj, paramg);
      this.A = false;
      paramg.a(localc, paramj);
      return paramg;
    }
    if (this.n != null)
    {
      paramg = new com.bumptech.glide.g.g(paramg);
      paramg.a(a(paramj, this.p.floatValue(), this.s, paramg), a(paramj, this.n.floatValue(), b(), paramg));
      return paramg;
    }
    return a(paramj, this.p.floatValue(), this.s, paramg);
  }
  
  private e b()
  {
    if (this.s == e.d) {
      return e.c;
    }
    if (this.s == e.c) {
      return e.b;
    }
    return e.a;
  }
  
  private com.bumptech.glide.g.c b(j<TranscodeType> paramj)
  {
    if (this.s == null) {
      this.s = e.c;
    }
    return a(paramj, null);
  }
  
  /* Error */
  public a<ModelType, DataType, ResourceType, TranscodeType> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 233	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/bumptech/glide/a
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 129	com/bumptech/glide/a:g	Lcom/bumptech/glide/f/a;
    //   12: ifnull +18 -> 30
    //   15: aload_0
    //   16: getfield 129	com/bumptech/glide/a:g	Lcom/bumptech/glide/f/a;
    //   19: invokevirtual 236	com/bumptech/glide/f/a:g	()Lcom/bumptech/glide/f/a;
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: putfield 129	com/bumptech/glide/a:g	Lcom/bumptech/glide/f/a;
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_1
    //   32: goto -9 -> 23
    //   35: astore_1
    //   36: new 238	java/lang/RuntimeException
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 241	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	a
    //   22	10	1	locala	com.bumptech.glide.f.a
    //   35	6	1	localCloneNotSupportedException	CloneNotSupportedException
    //   7	22	2	locala1	a
    // Exception table:
    //   from	to	target	type
    //   0	23	35	java/lang/CloneNotSupportedException
    //   23	28	35	java/lang/CloneNotSupportedException
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(int paramInt1, int paramInt2)
  {
    if (!com.bumptech.glide.i.h.a(paramInt1, paramInt2)) {
      throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }
    this.w = paramInt1;
    this.v = paramInt2;
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.d.b.b paramb)
  {
    this.x = paramb;
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.d.b<DataType> paramb)
  {
    if (this.g != null) {
      this.g.a(paramb);
    }
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.d.c paramc)
  {
    if (paramc == null) {
      throw new NullPointerException("Signature must not be null");
    }
    this.i = paramc;
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.d.e<DataType, ResourceType> parame)
  {
    if (this.g != null) {
      this.g.a(parame);
    }
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(ModelType paramModelType)
  {
    this.h = paramModelType;
    this.j = true;
    return this;
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.t = paramBoolean;
      return this;
    }
  }
  
  public a<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.d.g<ResourceType>... paramVarArgs)
  {
    this.z = true;
    if (paramVarArgs.length == 1)
    {
      this.y = paramVarArgs[0];
      return this;
    }
    this.y = new com.bumptech.glide.d.d(paramVarArgs);
    return this;
  }
  
  public <Y extends j<TranscodeType>> Y a(Y paramY)
  {
    
    if (paramY == null) {
      throw new IllegalArgumentException("You must pass in a non null Target");
    }
    if (!this.j) {
      throw new IllegalArgumentException("You must first set a model (try #load())");
    }
    com.bumptech.glide.g.c localc = paramY.b();
    if (localc != null)
    {
      localc.d();
      this.e.b(localc);
      localc.a();
    }
    localc = b(paramY);
    paramY.a(localc);
    this.f.a(paramY);
    this.e.a(localc);
    return paramY;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */