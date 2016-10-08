package in.srain.cube.views.ptr;

public abstract class f
  implements Runnable
{
  private Runnable a;
  private byte b = 0;
  
  public void a()
  {
    a(null);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.a = paramRunnable;
    }
    switch (this.b)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.b = 1;
      run();
      return;
    }
    c();
  }
  
  public void b()
  {
    this.b = 0;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.run();
    }
    this.b = 2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */