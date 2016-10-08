package b.a;

public abstract class f
  implements Runnable
{
  protected final String b;
  
  public f(String paramString, Object... paramVarArgs)
  {
    this.b = String.format(paramString, paramVarArgs);
  }
  
  protected abstract void b();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.b);
    try
    {
      b();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */