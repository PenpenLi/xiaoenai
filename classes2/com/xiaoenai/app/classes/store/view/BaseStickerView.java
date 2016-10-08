package com.xiaoenai.app.classes.store.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public abstract class BaseStickerView
  extends RelativeLayout
{
  private ImageView a;
  private ImageButton b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private RemindButton f;
  
  public BaseStickerView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2130903183, this);
    a();
  }
  
  public BaseStickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a = ((ImageView)findViewById(2131559158));
    this.b = ((ImageButton)findViewById(2131559159));
    this.c = ((TextView)findViewById(2131559161));
    this.d = ((TextView)findViewById(2131559163));
    this.e = ((ImageView)findViewById(2131559166));
    this.f = ((RemindButton)findViewById(2131559164));
    this.b.setOnClickListener(new a(this));
  }
  
  public ImageView getStorestickerImage()
  {
    return this.a;
  }
  
  public void setImageByPath(String paramString)
  {
    b.a(getStorestickerImage(), paramString);
  }
  
  public void setPlayBtnvisibility(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
  
  public void setRemindButton(RedHintsInfo paramRedHintsInfo)
  {
    if ((paramRedHintsInfo != null) && (this.f != null))
    {
      com.xiaoenai.app.widget.remindButton.a.a().a(this.f, paramRedHintsInfo);
      return;
    }
    this.f.b();
  }
  
  public void setStickerImage(Bitmap paramBitmap)
  {
    if (this.a != null)
    {
      this.a.setImageBitmap(paramBitmap);
      this.a.invalidate();
    }
  }
  
  public void setStickerImage(Drawable paramDrawable)
  {
    if (this.a != null) {
      this.a.setImageDrawable(paramDrawable);
    }
  }
  
  public void setStickerName(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void setStickerNewStateVisiablity(int paramInt)
  {
    if (this.e != null) {
      this.e.setVisibility(paramInt);
    }
  }
  
  public void setStickerState(String paramString)
  {
    if (this.d != null)
    {
      this.d.setText(paramString);
      this.d.setBackgroundDrawable(null);
    }
  }
  
  public void setStickerStateImage(int paramInt)
  {
    if (this.d != null)
    {
      this.d.setText("");
      this.d.setBackgroundResource(paramInt);
    }
  }
  
  public void setStickerStateVisiablity(int paramInt)
  {
    if (this.d != null) {
      this.d.setVisibility(paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\view\BaseStickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */