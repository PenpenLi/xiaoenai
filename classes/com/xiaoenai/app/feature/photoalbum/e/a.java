package com.xiaoenai.app.feature.photoalbum.e;

import android.app.Activity;
import android.content.Intent;
import com.google.gson.j;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.album.UploadData;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import com.xiaoenai.app.utils.d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

@PerActivity
public class a
{
  private int a = 0;
  private ArrayList<String> b = new ArrayList();
  private List<Boolean> c = new ArrayList();
  private UploadData d;
  private boolean e = true;
  private o f;
  
  @Inject
  public a(o paramo)
  {
    this.f = paramo;
  }
  
  private String a(String paramString)
  {
    return Pattern.compile("\t|\r|\n").matcher(paramString).replaceAll(" ");
  }
  
  public List<Boolean> a()
  {
    return this.c;
  }
  
  public List<Boolean> a(int paramInt, int[] paramArrayOfInt)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[0];
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(Boolean.valueOf(false));
      i += 1;
    }
    com.xiaoenai.app.utils.f.a.c("getOriginData {} {}", new Object[] { Integer.valueOf(paramInt), arrayOfInt });
    i = j;
    while (i < arrayOfInt.length)
    {
      if ((-1 != arrayOfInt[i]) && (arrayOfInt[i] < paramInt)) {
        localArrayList.set(arrayOfInt[i], Boolean.valueOf(true));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.b.remove(paramInt);
    this.c.remove(paramInt);
    this.a -= 1;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    l.b(paramActivity);
    ArrayList localArrayList = b();
    List localList = a();
    paramString = a(paramString.trim());
    com.xiaoenai.app.utils.f.a.c("AlbumPostPresenter {} ", new Object[] { paramString });
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      localStringBuilder1.append((String)localArrayList.get(i));
      localStringBuilder2.append(localList.get(i));
      if (i != localArrayList.size() - 1)
      {
        localStringBuilder1.append(";");
        localStringBuilder2.append(";");
      }
      i += 1;
    }
    this.d = new UploadData();
    this.d.setFeeling(paramString);
    this.d.setUploadImages(localStringBuilder1.toString());
    this.d.setOrigin(localStringBuilder2.toString());
    this.d.setUploadedCount(String.valueOf(0));
    this.d.setUploadtotalCount(String.valueOf(localArrayList.size()));
    this.d.setUploadJson("");
    paramString = new j().a(this.d);
    this.f.a("uploaddata", paramString);
    paramActivity.setResult(-1, new Intent());
  }
  
  public void a(ArrayList<String> paramArrayList, List<Boolean> paramList)
  {
    this.b.clear();
    this.c.clear();
    this.a = 0;
    b(paramArrayList, paramList);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      a(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public ArrayList<String> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<String> paramArrayList, List<Boolean> paramList)
  {
    this.b.addAll(paramArrayList);
    this.c.addAll(paramList);
    this.a += paramArrayList.size();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */