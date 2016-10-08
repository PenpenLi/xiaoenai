package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.InputFilter.LengthFilter;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.e;
import org.json.JSONObject;

public final class ao
  extends z
  implements Handler.Callback
{
  private a n = null;
  private TextView o = null;
  private Handler p = null;
  private int q = 0;
  
  public ao(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt, paramJSONObject);
    i();
    this.n = null;
  }
  
  public ao(Context paramContext, int paramInt, JSONObject paramJSONObject, byte paramByte)
  {
    super(paramContext, paramInt, paramJSONObject);
    i();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.o.setText(paramString);
    this.o.setEnabled(paramBoolean);
  }
  
  private void i()
  {
    int i = this.a;
    i = a.b;
    this.b.a(new InputFilter.LengthFilter(6));
    this.b.a(2);
    Object localObject = new RelativeLayout.LayoutParams(-1, b.n);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(this.c);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setBackgroundColor(-3419943);
    new LinearLayout.LayoutParams(1, -1);
    this.o = new TextView(getContext());
    this.o.setGravity(17);
    this.o.setText(c.by.w);
    this.o.setTextColor(e.a(-10705958, -5846275, -5846275, -6710887));
    this.o.setTextSize(b.k);
    this.o.setOnClickListener(new ap(this));
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.b.a(this.o, (LinearLayout.LayoutParams)localObject);
  }
  
  public final void a(int paramInt)
  {
    this.p = new Handler(this);
    aq localaq = new aq(this, paramInt);
    a(false, String.format(c.by.x, new Object[] { Integer.valueOf(paramInt) }));
    localaq.start();
  }
  
  public final void a(a parama)
  {
    this.n = parama;
  }
  
  public final boolean b()
  {
    if (this.h) {}
    while (6 == a().length()) {
      return true;
    }
    return false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      if (c.by != null) {
        a(true, c.by.y);
      }
      this.p = null;
      return true;
      this.q = paramMessage.arg1;
    } while (c.by == null);
    a(false, String.format(c.by.x, new Object[] { Integer.valueOf(paramMessage.arg1) }));
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(y paramy);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */