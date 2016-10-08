package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.bumptech.glide.f;
import java.util.HashSet;

public class n
  extends Fragment
{
  private f a;
  private final a b;
  private final l c = new a(null);
  private final HashSet<n> d = new HashSet();
  private n e;
  
  public n()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  public n(a parama)
  {
    this.b = parama;
  }
  
  private void a(n paramn)
  {
    this.d.add(paramn);
  }
  
  private void b(n paramn)
  {
    this.d.remove(paramn);
  }
  
  a a()
  {
    return this.b;
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public f b()
  {
    return this.a;
  }
  
  public l c()
  {
    return this.c;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = k.a().a(getActivity().getSupportFragmentManager());
    if (this.e != this) {
      this.e.a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.c();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.e != null)
    {
      this.e.b(this);
      this.e = null;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.b.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.b.b();
  }
  
  private class a
    implements l
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */