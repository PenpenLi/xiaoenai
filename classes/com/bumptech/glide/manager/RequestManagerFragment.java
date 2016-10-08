package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.bumptech.glide.f;
import java.util.HashSet;

@TargetApi(11)
public class RequestManagerFragment
  extends Fragment
{
  private final a a;
  private final l b = new a(null);
  private f c;
  private final HashSet<RequestManagerFragment> d = new HashSet();
  private RequestManagerFragment e;
  
  public RequestManagerFragment()
  {
    this(new a());
  }
  
  @SuppressLint({"ValidFragment"})
  RequestManagerFragment(a parama)
  {
    this.a = parama;
  }
  
  private void a(RequestManagerFragment paramRequestManagerFragment)
  {
    this.d.add(paramRequestManagerFragment);
  }
  
  private void b(RequestManagerFragment paramRequestManagerFragment)
  {
    this.d.remove(paramRequestManagerFragment);
  }
  
  a a()
  {
    return this.a;
  }
  
  public void a(f paramf)
  {
    this.c = paramf;
  }
  
  public f b()
  {
    return this.c;
  }
  
  public l c()
  {
    return this.b;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = k.a().a(getActivity().getFragmentManager());
    if (this.e != this) {
      this.e.a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.c();
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
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.b();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.c != null) {
      this.c.a(paramInt);
    }
  }
  
  private class a
    implements l
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\RequestManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */