package com.xiaoenai.app.classes.street.widget;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;

public class aj
  extends Fragment
{
  private int a = 0;
  private View b = null;
  private int c = 0;
  private ImageInfo[] d = null;
  private ImageView e = null;
  private ProgressView f = null;
  
  private void a()
  {
    this.e.setOnClickListener(new ak(this));
  }
  
  private void a(View paramView)
  {
    this.e = ((ImageView)paramView.findViewById(2131558738));
    this.f = ((ProgressView)paramView.findViewById(2131558669));
    paramView = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    paramView.height = ab.b();
    this.e.setLayoutParams(paramView);
    a(this.c);
  }
  
  public void a(int paramInt)
  {
    if ((this.d == null) || (this.d.length == 0)) {}
    while ((this.d.length <= 0) || (this.a >= this.d.length)) {
      return;
    }
    String str = this.d[this.a].getUrl() + "?imageView/1/w/" + this.d[this.a].getWidth() + "/h/" + this.d[this.a].getHeight();
    a.c("=========imageUrl========={}", new Object[] { str });
    switch (paramInt)
    {
    }
    for (;;)
    {
      b.a(this.e, str, new al(this));
      return;
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.e.setAlpha(1.0F);
      }
      else
      {
        this.e.setAlpha(255);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          this.e.setAlpha(0.5F);
        } else {
          this.e.setAlpha(128);
        }
      }
    }
  }
  
  public void a(ImageInfo[] paramArrayOfImageInfo, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.d = paramArrayOfImageInfo;
    this.c = paramInt2;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2130903280, paramViewGroup, false);
    return this.b;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */