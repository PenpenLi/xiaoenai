package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.utils.e;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

public final class u
  extends LinearLayout
{
  private String a = null;
  private v b = null;
  
  private u(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    super(paramContext);
    setOrientation(0);
    this.a = paramString2;
    this.b = v.a(paramContext, paramDrawable);
    this.b.a(Html.fromHtml(String.format("<u>%s</u>", new Object[] { paramString1 })));
    paramContext = e.a(-13601621, -15909519);
    this.b.a(paramContext);
    addView(this.b);
  }
  
  public static final u a(Context paramContext, JSONObject paramJSONObject, Drawable paramDrawable)
  {
    u localu = null;
    if (paramJSONObject != null) {
      localu = new u(paramContext, g.a(paramJSONObject, "label"), g.a(paramJSONObject, "href"), paramDrawable);
    }
    return localu;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    if (this.b != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */