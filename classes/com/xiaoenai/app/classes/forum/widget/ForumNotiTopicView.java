package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.f.a;

public class ForumNotiTopicView
  extends RelativeLayout
{
  private View a;
  private TextView b;
  
  public ForumNotiTopicView(Context paramContext)
  {
    super(paramContext);
    a();
    b();
  }
  
  public ForumNotiTopicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    b();
  }
  
  private int a(int paramInt)
  {
    int i;
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue())
    {
      i = 2131296398;
      if (i != 2131296398) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      a.c("==================== {}", new Object[] { Boolean.valueOf(bool) });
      return getContext().obtainStyledAttributes(i, new int[] { paramInt }).getColor(0, -16777216);
      i = 2131296397;
      break;
    }
  }
  
  private void a()
  {
    setBackgroundResource(2130839016);
    this.b = new TextView(getContext());
    this.b.setGravity(17);
    this.b.getPaint().setFlags(8);
    this.b.getPaint().setAntiAlias(true);
    this.b.setText(2131100391);
    this.b.setTextColor(getResources().getColor(2131492956));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    this.b.setLayoutParams(localLayoutParams);
    this.a = new View(getContext());
    this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, 1));
    this.a.setBackgroundColor(a(2130772024));
  }
  
  private void b()
  {
    addView(this.b);
    addView(this.a);
  }
  
  public TextView getGetDetailBtn()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumNotiTopicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */