package com.xiaoenai.app.feature.photopreview.view.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.e.b;
import java.io.File;

public class PreviewItemView
  extends RelativeLayout
  implements com.xiaoenai.app.feature.photopreview.view.a
{
  public PhotoView a;
  public ImageButton b;
  public Button c;
  public ProgressView d;
  
  public PreviewItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected a a(int paramInt1, int paramInt2)
  {
    a locala = new a();
    int i = 0;
    int j;
    if ((paramInt1 > 1280) || (paramInt2 > 1280))
    {
      i = 70;
      j = 1280;
    }
    for (;;)
    {
      locala.c(i);
      locala.a(j);
      locala.b(paramInt2);
      return locala;
      if ((paramInt1 > 720) || (paramInt2 > 720))
      {
        i = 75;
        j = paramInt1;
      }
      else if (paramInt1 <= 300)
      {
        j = paramInt1;
        if (paramInt2 <= 300) {}
      }
      else
      {
        i = 85;
        j = paramInt1;
      }
    }
  }
  
  public void a(com.xiaoenai.app.feature.photopreview.b.a parama)
  {
    String str = parama.j();
    Object localObject = str;
    if (str.startsWith("http"))
    {
      localObject = b.b(str);
      if ((localObject == null) || (0L >= ((File)localObject).length())) {
        break label76;
      }
    }
    for (localObject = "file://" + ((File)localObject).getAbsolutePath();; localObject = parama.j() + "?imageView/2/w/" + ((a)localObject).a() + "/h/" + ((a)localObject).b() + "/q/" + ((a)localObject).c())
    {
      b.a(this.a, (String)localObject, new a(this));
      return;
      label76:
      localObject = a(parama.b(), parama.e());
    }
  }
  
  class a
  {
    private int b;
    private int c;
    private int d;
    private boolean e = false;
    
    a() {}
    
    public int a()
    {
      return this.b;
    }
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public void b(int paramInt)
    {
      this.c = paramInt;
    }
    
    public int c()
    {
      return this.d;
    }
    
    public void c(int paramInt)
    {
      this.d = paramInt;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\impl\PreviewItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */