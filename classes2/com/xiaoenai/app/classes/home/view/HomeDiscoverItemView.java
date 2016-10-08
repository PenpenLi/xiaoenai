package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.ListItemViewEx;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class HomeDiscoverItemView
  extends ListItemViewEx
{
  private ListItemViewEx a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private RemindButton e;
  private HomeDiscoverItem f;
  
  public HomeDiscoverItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public HomeDiscoverItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = ((ListItemViewEx)RelativeLayout.inflate(paramContext, 2130903243, this));
    this.b = ((ImageView)findViewById(2131559459));
    this.c = ((TextView)findViewById(2131559460));
    this.d = ((TextView)findViewById(2131559462));
    this.e = ((RemindButton)findViewById(2131559461));
  }
  
  public void a()
  {
    if (this.f != null)
    {
      this.f.getIcon().setViewScale(ab.a(37.0F), ab.a(37.0F));
      b.a(this.b, this.f.getIcon().getCommonUrl());
      this.c.setText(this.f.getTitle());
      if (ae.a(this.f.getSubTitle())) {
        break label121;
      }
      this.d.setText(this.f.getSubTitle());
      this.d.setVisibility(0);
    }
    while (this.f.getRedHintsInfo() != null)
    {
      com.xiaoenai.app.widget.remindButton.a.a().a(this.e, this.f.getRedHintsInfo());
      return;
      label121:
      this.d.setVisibility(8);
    }
    this.e.b();
  }
  
  public void setDiscoverItem(HomeDiscoverItem paramHomeDiscoverItem)
  {
    this.f = paramHomeDiscoverItem;
  }
  
  public void setItemLine(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("===setItemLine positon======={}", new Object[] { Integer.valueOf(paramInt) });
    this.a.setisTopShortLine(true);
    this.a.setisBottomShortLine(true);
    this.a.setTopLineShortDirection(1);
    this.a.setBottomLineShortDirection(1);
    if (paramInt == 0)
    {
      this.a.setisTopShortLine(false);
      this.a.setBackgroundWithPosition(1);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.a.setisBottomShortLine(false);
        this.a.setBackgroundWithPosition(2);
        return;
      }
      if (paramInt == 2)
      {
        this.a.setisTopShortLine(false);
        this.a.setisBottomShortLine(false);
        this.a.setBackgroundWithPosition(0);
        return;
      }
    } while (paramInt != 3);
    this.a.setBackgroundWithPosition(2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\HomeDiscoverItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */