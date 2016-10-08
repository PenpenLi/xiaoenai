package com.xiaoenai.app.classes.common.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class b
  extends h
{
  public b(Context paramContext)
  {
    super(paramContext);
    this.d = ((RelativeLayout)getLayoutInflater().inflate(2130903134, null));
    this.c = ((TextView)this.d.findViewById(2131558918));
    this.b = ((ImageView)this.d.findViewById(2131558917));
    this.a = ((ProgressView)this.d.findViewById(2131558916));
    this.e = ((LinearLayout)this.d.findViewById(2131558915));
    this.d.setOnClickListener(new c(this));
    this.e.setOnClickListener(new d(this));
  }
  
  public static b a(Context paramContext, long paramLong)
  {
    paramContext = new b(paramContext);
    paramContext.a(paramLong);
    return paramContext;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */