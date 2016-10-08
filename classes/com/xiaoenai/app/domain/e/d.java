package com.xiaoenai.app.domain.e;

import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.domain.c;
import java.lang.ref.WeakReference;
import java.util.List;
import rx.a;
import rx.k;

public abstract interface d
{
  public abstract a<List<PhotoAlbum>> a(int paramInt1, int paramInt2);
  
  public abstract a<Integer> a(String paramString1, String paramString2);
  
  public abstract void a(List<String> paramList, WeakReference<k<c>> paramWeakReference);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract a<List<PhotoAlbum>> b(String paramString1, String paramString2);
  
  public abstract int c();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\domain\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */