package in.srain.cube.views.ptr;

import in.srain.cube.views.ptr.a.a;

class e
  implements d
{
  private d a;
  private e b;
  
  public static void a(e parame, d paramd)
  {
    if (paramd == null) {
      break label4;
    }
    label4:
    while (parame == null) {
      return;
    }
    e locale = parame;
    if (parame.a == null)
    {
      parame.a = paramd;
      return;
    }
    do
    {
      locale = locale.b;
      if (locale.a(paramd)) {
        break;
      }
    } while (locale.b != null);
    parame = new e();
    parame.a = paramd;
    locale.b = parame;
  }
  
  private boolean a(d paramd)
  {
    return (this.a != null) && (this.a == paramd);
  }
  
  public static e b()
  {
    return new e();
  }
  
  private d c()
  {
    return this.a;
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((e)localObject1).c();
      if (localObject2 != null) {
        ((d)localObject2).a(paramPtrFrameLayout);
      }
      localObject2 = ((e)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((e)localObject1).c();
      if (localObject2 != null) {
        ((d)localObject2).a(paramPtrFrameLayout, paramBoolean, paramByte, parama);
      }
      localObject2 = ((e)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public void b(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    if (!a()) {
      return;
    }
    Object localObject2;
    do
    {
      localObject2 = ((e)localObject1).c();
      if (localObject2 != null) {
        ((d)localObject2).b(paramPtrFrameLayout);
      }
      localObject2 = ((e)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void c(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((e)localObject1).c();
      if (localObject2 != null) {
        ((d)localObject2).c(paramPtrFrameLayout);
      }
      localObject2 = ((e)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void d(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((e)localObject1).c();
      if (localObject2 != null) {
        ((d)localObject2).d(paramPtrFrameLayout);
      }
      localObject2 = ((e)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */