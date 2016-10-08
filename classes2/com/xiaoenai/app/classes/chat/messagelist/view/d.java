package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.gif.GifView;

public class d
  extends BaseItemView
{
  private GifView b;
  private String c = "";
  private ProgressGifView d;
  private LinearLayout e;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    getMessageBody().setOnClickListener(new e(this, paramString));
    if ((this.c != null) && (this.c.equals(paramString)))
    {
      this.b.e();
      return;
    }
    this.c = paramString;
    if (paramInt2 != 1)
    {
      this.d.a();
      this.e.setVisibility(0);
      this.b.setVisibility(8);
    }
    this.b.setImageBitmap(null);
    if ((UserConfig.getInt("lstTimestamp", Integer.valueOf(0)).intValue() >= paramInt1) || (paramInt1 < 0))
    {
      this.b.g();
      this.b.i();
      b.a(this.b, paramString, new f(this));
      return;
    }
    b.a(this.b, paramString, new g(this));
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b.i();
    }
  }
  
  public void c()
  {
    if (this.b != null)
    {
      this.b.e();
      this.b.f();
    }
  }
  
  protected void finalize()
  {
    b();
    super.finalize();
  }
  
  public View getMsgContentView()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2130903095, null);
    this.d = ((ProgressGifView)localRelativeLayout.findViewById(2131558770));
    this.b = ((GifView)localRelativeLayout.findViewById(2131558771));
    this.e = ((LinearLayout)localRelativeLayout.findViewById(2131558769));
    return localRelativeLayout;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.b != null) {
      this.b.h();
    }
  }
  
  public void setImageResource(int paramInt) {}
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    this.mMessageBody.setBackgroundDrawable(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */