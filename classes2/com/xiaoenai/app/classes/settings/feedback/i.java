package com.xiaoenai.app.classes.settings.feedback;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.input.faces.d;
import com.xiaoenai.app.classes.settings.feedback.a.a;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.ab;

public class i
  extends a
{
  protected TextView c;
  private RelativeLayout e = (RelativeLayout)findViewById(2131558831);
  private TextView f = (TextView)findViewById(2131558838);
  private TextView g;
  
  public i(Context paramContext)
  {
    super(paramContext);
    this.g = new TextView(paramContext);
    this.g.setBackgroundResource(2130837700);
    this.g.setTextColor(-1);
    this.g.setTextSize(2, 11.0F);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(3, this.mMessageBody.getId());
    paramContext.addRule(5, this.mMessageBody.getId());
    paramContext.leftMargin = ab.a(13.0F);
    paramContext.topMargin = ab.a(7.0F);
    this.g.setGravity(16);
    this.e.addView(this.g, paramContext);
  }
  
  public void a()
  {
    if (this.d == 2)
    {
      getAvatar().setRoundedImage(g.b());
      this.f.setText(g.a());
      setNickNameVisibility(0);
      return;
    }
    String str = User.getInstance().getAvatar();
    getAvatar().setRoundedImage(str);
  }
  
  public View getMsgContentView()
  {
    View localView = inflate(getContext(), 2130903116, null);
    this.c = ((TextView)localView.findViewById(2131558856));
    this.c.setMaxWidth((int)(ab.b() * 0.53D));
    this.c.setAutoLinkMask(15);
    return localView;
  }
  
  public void setContentText(String paramString)
  {
    this.c.setText(paramString);
    this.c.requestLayout();
    d.a().c(this.c);
    this.mRlStatus.setVisibility(8);
  }
  
  public void setCreatedAt(String paramString)
  {
    this.mMessageTime.setVisibility(8);
    if (paramString != null)
    {
      this.g.setText(paramString);
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  public void setImageResource(int paramInt) {}
  
  public void setStatus(int paramInt)
  {
    this.mRlStatus.setVisibility(8);
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    this.d = paramInt;
    if (paramInt == 2)
    {
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */