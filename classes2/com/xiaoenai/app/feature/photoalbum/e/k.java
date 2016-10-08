package com.xiaoenai.app.feature.photoalbum.e;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.album.CompressPhoto;
import com.xiaoenai.app.data.entity.album.UploadData;
import com.xiaoenai.app.utils.a.d;
import com.xiaoenai.app.utils.d.m;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class k
  extends AsyncTask<Void, Void, List<String>>
{
  private o a;
  private WeakReference<c> b;
  private String c;
  private int d;
  private List<String> e;
  private String[] f;
  private int g;
  private UploadData h;
  
  public k(o paramo, WeakReference<c> paramWeakReference)
  {
    this.a = paramo;
    this.b = paramWeakReference;
  }
  
  private CompressPhoto a(String paramString, boolean paramBoolean)
  {
    CompressPhoto localCompressPhoto = new CompressPhoto();
    File localFile1 = new File(paramString);
    Object localObject;
    label119:
    long l;
    if (paramBoolean)
    {
      File localFile2 = new File(d.a(), m.a(localFile1.getName()));
      paramBoolean = com.xiaoenai.app.utils.d.j.a(localFile1.getAbsolutePath(), localFile2.getAbsolutePath());
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      if (paramBoolean)
      {
        localObject = localFile2.getAbsolutePath();
        BitmapFactory.decodeFile((String)localObject, localOptions);
        localCompressPhoto.setHeight(localOptions.outHeight);
        localCompressPhoto.setWidth(localOptions.outWidth);
        if (!paramBoolean) {
          break label223;
        }
        localObject = localFile2.getAbsolutePath();
        localCompressPhoto.setPath((String)localObject);
        if (!paramBoolean) {
          break label228;
        }
        l = localFile2.length();
        label136:
        localCompressPhoto.setSize(l);
        localCompressPhoto.setOrigin(true);
        a.c("resizePhoto OriginPath:" + localCompressPhoto.getOriginPath(), new Object[0]);
        a.c("resizePhoto fileSize:" + localCompressPhoto.getSize(), new Object[0]);
      }
    }
    for (;;)
    {
      localCompressPhoto.setOriginPath(paramString);
      return localCompressPhoto;
      localObject = paramString;
      break;
      label223:
      localObject = paramString;
      break label119;
      label228:
      l = localFile1.length();
      break label136;
      localObject = new File(d.a(), m.a(localFile1.getName()));
      localCompressPhoto.transform(com.xiaoenai.app.utils.d.j.b(paramString, ((File)localObject).getAbsolutePath()));
      localCompressPhoto.setPath(((File)localObject).getAbsolutePath());
      localCompressPhoto.setSize(((File)localObject).length());
      localCompressPhoto.setOrigin(false);
    }
  }
  
  private List<String> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2;
    int i;
    Object localObject2;
    Object localObject1;
    if ((this.e != null) && (this.e.size() > 0))
    {
      localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.f.length)
      {
        localArrayList2.add(Boolean.valueOf(this.f[i]));
        i += 1;
      }
      localObject2 = new ArrayList();
      this.d = this.e.size();
      i = this.g;
      if (i < this.d)
      {
        localObject1 = (String)this.e.get(i);
        if (!((String)localObject1).contains("file://")) {
          break label310;
        }
        localObject1 = ((String)localObject1).substring("file://".length());
      }
    }
    label310:
    for (;;)
    {
      c localc = (c)this.b.get();
      if ((localc == null) || (localc.j()))
      {
        a.c("startUpLoadAction Activity is finish task cancel i = {} size = {} cur = {}", new Object[] { Integer.valueOf(i), Integer.valueOf(this.g), localObject1 });
        return new ArrayList();
      }
      localObject1 = a((String)localObject1, ((Boolean)localArrayList2.get(i)).booleanValue());
      ((List)localObject2).add(localObject1);
      localArrayList1.add(((CompressPhoto)localObject1).getPath());
      i += 1;
      break;
      if (this.g == 0)
      {
        localObject1 = new com.google.gson.j();
        localObject2 = ((com.google.gson.j)localObject1).a(localObject2);
        this.h.setUploadJson((String)localObject2);
        localObject1 = ((com.google.gson.j)localObject1).a(this.h);
        this.a.a("uploaddata", (String)localObject1);
      }
      return localArrayList1;
    }
  }
  
  protected List<String> a(Void... paramVarArgs)
  {
    return a();
  }
  
  protected void a(List<String> paramList)
  {
    super.onPostExecute(paramList);
    c localc = (c)this.b.get();
    if ((localc != null) && (!localc.j()))
    {
      ((c)this.b.get()).a(this.c, paramList, this.d);
      a.c("onPostExecute {}", new Object[] { Integer.valueOf(paramList.size()) });
      return;
    }
    a.c("onPostExecute activity is finish ", new Object[0]);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    Object localObject1 = this.a.b("uploaddata", "");
    a.c("onPreExecute data = {}", new Object[] { localObject1 });
    a.a((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.h = ((UploadData)new com.google.gson.j().a((String)localObject1, UploadData.class));
      this.c = this.h.getFeeling();
      Object localObject2 = this.h.getUploadImages();
      localObject1 = this.h.getOrigin();
      this.g = Integer.valueOf(this.h.getUploadedCount()).intValue();
      localObject2 = ((String)localObject2).split(";");
      this.f = ((String)localObject1).split(";");
      this.e = Arrays.asList((Object[])localObject2);
      localObject1 = (c)this.b.get();
      if ((localObject1 != null) && (!((c)localObject1).j())) {
        ((c)this.b.get()).c(this.e);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */