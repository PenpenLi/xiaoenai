package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class t
  extends m
{
  private ArrayList<PhotoMessage> a;
  private ViewPager b;
  private Context c;
  private int d;
  
  public t(ArrayList<PhotoMessage> paramArrayList, Activity paramActivity, ViewPager paramViewPager, int paramInt)
  {
    super(paramActivity, paramViewPager);
    this.c = paramActivity;
    this.b = paramViewPager;
    this.a = paramArrayList;
    this.d = paramInt;
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      return this.a.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    a.c("position = {}", new Object[] { Integer.valueOf(paramInt) });
    View localView = a().getLayoutInflater().inflate(2130903149, null);
    ((ViewPager)paramView).addView(localView);
    PhotoView localPhotoView = (PhotoView)localView.findViewById(2131558985);
    ImageButton localImageButton = (ImageButton)localView.findViewById(2131558986);
    Button localButton = (Button)localView.findViewById(2131558982);
    ProgressView localProgressView = (ProgressView)localView.findViewById(2131558987);
    PhotoMessage localPhotoMessage = (PhotoMessage)this.a.get(paramInt);
    String str = localPhotoMessage.t();
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    a.c("url = {}", new Object[] { paramView });
    File localFile = b.b(paramView);
    if ((this.a != null) && (this.a.size() > 0) && (localPhotoMessage.s()))
    {
      paramView = new StringBuilder();
      paramView.append(a().getString(2131100080));
      paramView.append("(");
      paramView.append(a(localPhotoMessage.r()));
      paramView.append(")");
      localButton.setText(paramView.toString());
      localButton.setOnClickListener(new u(this, localFile, localPhotoMessage, localPhotoView, localButton));
      str = null;
      if (localPhotoMessage.w() == null) {
        break label384;
      }
      paramView = "file://" + localPhotoMessage.w();
      localButton.setVisibility(8);
      label281:
      if (paramView == null) {
        break label417;
      }
      b.a(localPhotoView, paramView, new v(this, localPhotoMessage));
    }
    for (;;)
    {
      localImageButton.setOnClickListener(new w(this, paramInt));
      if (this.d == 2) {
        localImageButton.setVisibility(8);
      }
      localPhotoView.setOnLongClickListener(new x(this, paramInt));
      localPhotoView.setOnClickListener(new y(this));
      b().put(Integer.valueOf(paramInt), localPhotoView);
      return localView;
      localButton.setVisibility(8);
      break;
      label384:
      paramView = str;
      if (localFile == null) {
        break label281;
      }
      paramView = str;
      if (!localFile.exists()) {
        break label281;
      }
      paramView = localPhotoMessage.t();
      localButton.setVisibility(8);
      break label281;
      label417:
      a(localPhotoMessage.u(), localPhotoMessage.v(), localPhotoMessage.s(), localPhotoMessage.t(), localPhotoView, localProgressView, a());
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */