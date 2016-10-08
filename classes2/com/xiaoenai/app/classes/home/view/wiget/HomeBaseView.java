package com.xiaoenai.app.classes.home.view.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.classes.home.model.HomeBaseModel;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class HomeBaseView
  extends RelativeLayout
{
  protected HomeBaseModel a;
  @BindView(2131558577)
  protected ImageView mIcon;
  @BindView(2131559378)
  protected TextView mNameTxt;
  @BindView(2131559379)
  protected RemindButton mRemindButton;
  
  public HomeBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HomeBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a()
  {
    this.mRemindButton.b();
  }
  
  protected void a(Context paramContext)
  {
    View.inflate(paramContext, 2130903235, this);
    ButterKnife.bind(this);
  }
  
  public void a(String paramString)
  {
    this.mRemindButton.a(paramString);
  }
  
  public HomeBaseModel getHomeModel()
  {
    return this.a;
  }
  
  public void setModel(HomeBaseModel paramHomeBaseModel)
  {
    if (paramHomeBaseModel != null)
    {
      this.a = paramHomeBaseModel;
      this.mIcon.setImageResource(paramHomeBaseModel.getResId());
      this.mNameTxt.setText(paramHomeBaseModel.getStringId());
      if ((paramHomeBaseModel.isShow()) && (paramHomeBaseModel.getRedString() != null)) {
        a(paramHomeBaseModel.getRedString());
      }
    }
    else
    {
      return;
    }
    a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\wiget\HomeBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */