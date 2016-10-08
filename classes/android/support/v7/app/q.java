package android.support.v7.app;

class q
  implements Runnable
{
  q(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public void run()
  {
    if ((AppCompatDelegateImplV7.a(this.a) & 0x1) != 0) {
      AppCompatDelegateImplV7.a(this.a, 0);
    }
    if ((AppCompatDelegateImplV7.a(this.a) & 0x1000) != 0) {
      AppCompatDelegateImplV7.a(this.a, 108);
    }
    AppCompatDelegateImplV7.a(this.a, false);
    AppCompatDelegateImplV7.b(this.a, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */