package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.n.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends b
  implements n.a
{
  private Activity A;
  private boolean B;
  private boolean C = false;
  public List<com.unionpay.mobile.android.model.c> p = null;
  public List<com.unionpay.mobile.android.model.c> q = null;
  private ProgressBar r = null;
  private String s = null;
  private int t = 0;
  private volatile int u = 0;
  private boolean v = false;
  private boolean w = false;
  private JSONArray x;
  private d y;
  private long z;
  
  public l(Context paramContext)
  {
    super(paramContext);
    this.f = 1;
    d();
    this.A = ((Activity)paramContext);
    this.B = com.unionpay.mobile.android.nocard.utils.a.a(this.A.getIntent(), this.a);
    if (this.a.aC)
    {
      setVisibility(8);
      this.b.a(com.unionpay.mobile.android.languages.c.by.c);
    }
    r();
  }
  
  private final void A()
  {
    int k = 1;
    int j;
    label122:
    label321:
    Object localObject2;
    Object localObject4;
    label531:
    for (;;)
    {
      int i;
      try
      {
        h.c("uppay", "showContentView() +++" + this.u);
        if (this.u != 2)
        {
          if (!this.w)
          {
            i = 1;
            if ((this.w) && (!"1".equalsIgnoreCase(this.a.ai)))
            {
              j = this.a.aj;
              bool = f(j);
              if ((!bool) || ((j & 0x11101) != 0)) {
                break label828;
              }
              j = 1;
              if (j == 0)
              {
                j = k;
                if ((i == 0) && (j == 0)) {
                  continue;
                }
              }
            }
          }
          else
          {
            i = 0;
            continue;
          }
          j = 0;
          continue;
        }
        if (this.v) {
          continue;
        }
        this.v = true;
        if (this.a.aC) {
          this.b.c();
        }
        i = this.a.aj;
        if (!"1".equalsIgnoreCase(this.a.ai)) {
          break label321;
        }
        if (this.a.au)
        {
          this.a.l = null;
          if ((!"0".equalsIgnoreCase(this.a.ai)) || ((this.a.l != null) && (this.a.l.size() > 0)) || (f(i))) {
            break;
          }
          String str1 = this.a.ak;
          if ("fail".length() > 0) {
            this.a.D.f = "fail";
          }
          this.r.setVisibility(4);
          a(str1, true);
          continue;
        }
        this.a.l = this.p;
      }
      finally {}
      continue;
      if ("0".equalsIgnoreCase(this.a.ai)) {
        this.a.l = this.q;
      }
      for (;;)
      {
        if ((this.a.l == null) || (this.a.l.size() <= 0)) {
          break label531;
        }
        localObject2 = this.a.l.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (com.unionpay.mobile.android.model.c)((Iterator)localObject2).next();
          if ((((com.unionpay.mobile.android.model.c)localObject4).c() != 0) && ((((com.unionpay.mobile.android.model.c)localObject4).c() & i) == 0)) {
            ((Iterator)localObject2).remove();
          }
        }
        break;
        if (this.a.au)
        {
          this.a.l = this.q;
        }
        else
        {
          if ((this.q != null) && (this.q.size() > 0)) {
            this.a.l.addAll(this.q);
          }
          if ((this.p != null) && (this.p.size() > 0)) {
            this.a.l.addAll(this.p);
          }
        }
      }
    }
    boolean bool = "1".equalsIgnoreCase(this.a.ai);
    if (!bool) {}
    for (;;)
    {
      try
      {
        if (this.x == null) {
          break label764;
        }
        localObject4 = this.x.getString(0);
        if (this.x == null) {
          break label774;
        }
        str2 = this.x.getString(1);
        if (this.x == null) {
          break label784;
        }
        str3 = this.x.getString(2);
        if (!z()) {
          break label795;
        }
        str4 = this.x.getString(3);
        com.unionpay.mobile.android.model.c localc;
        if (this.a.l != null)
        {
          Iterator localIterator = this.a.l.iterator();
          if (localIterator.hasNext())
          {
            localc = (com.unionpay.mobile.android.model.c)localIterator.next();
            if (localc.c() == 0) {
              continue;
            }
            localObject2 = "";
          }
        }
        switch (localc.c())
        {
        case 16: 
          localc.a((String)localObject2);
          continue;
          a(2, this.y);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      h.c("uppay", "showContentView() ---");
      break label122;
      label764:
      localObject4 = com.unionpay.mobile.android.languages.c.by.ak;
      continue;
      label774:
      String str2 = com.unionpay.mobile.android.languages.c.by.aj;
      continue;
      label784:
      String str3 = com.unionpay.mobile.android.languages.c.by.ai;
      continue;
      label795:
      String str4 = com.unionpay.mobile.android.languages.c.by.al;
      continue;
      Object localObject3 = str3;
      continue;
      localObject3 = localObject4;
      continue;
      localObject3 = str2;
      continue;
      localObject3 = str4;
      continue;
      label828:
      j = 0;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new m(this, paramString3);
    n localn = new n(this);
    if (paramString1.equalsIgnoreCase("01")) {}
    for (int i = 0; i != 0; i = 1)
    {
      this.b.a(paramString3, localn);
      this.b.a(com.unionpay.mobile.android.languages.c.by.ae, paramString2, com.unionpay.mobile.android.languages.c.by.af, com.unionpay.mobile.android.languages.c.by.ag);
      return;
    }
    this.b.a(paramString3, localn);
    this.b.a(com.unionpay.mobile.android.languages.c.by.Y, paramString2, com.unionpay.mobile.android.languages.c.by.af, com.unionpay.mobile.android.languages.c.by.ag);
  }
  
  private void b(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.a.D.f = paramString;
    }
    this.r.setVisibility(4);
    a(c(paramInt), true);
  }
  
  private boolean f(int paramInt)
  {
    if ((paramInt & 0x2) != 0)
    {
      this.a.ar = true;
      return true;
    }
    return false;
  }
  
  private final boolean z()
  {
    boolean bool2 = false;
    try
    {
      if (this.x != null) {}
      for (String str = this.x.getString(3);; str = null)
      {
        boolean bool1 = bool2;
        if (str != null)
        {
          bool1 = bool2;
          if (str.length() > 0)
          {
            boolean bool3 = "null".equalsIgnoreCase(str);
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte)
  {
    j();
    if (paramInt != 0) {
      b(paramInt, null);
    }
    h.a("uppay", "status = " + paramInt);
    if (paramArrayOfByte != null)
    {
      paramInt = 0;
      if ("mounted".equals(Environment.getExternalStorageState())) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        b(9, null);
      }
    }
    else
    {
      return;
    }
    if (com.unionpay.mobile.android.utils.m.a(paramArrayOfByte) == true)
    {
      paramArrayOfByte = new Intent();
      paramArrayOfByte.setAction("android.intent.action.VIEW");
      String str = Environment.getExternalStorageDirectory() + File.separator + "UPPay" + File.separator + "UPPayPluginEx.apk";
      h.a("uppay", "apk path:" + str);
      paramArrayOfByte.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
      ((BaseActivity)this.d).startActivityForResult(paramArrayOfByte, 100);
      return;
    }
    b(21, null);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    h.a("uppay", "init.parserParamJsonObj() +++");
    if (paramJSONObject == null)
    {
      b(2);
      return;
    }
    switch (this.t)
    {
    }
    for (;;)
    {
      h.a("uppay", "init.parserParamJsonObj() ---");
      return;
      String str = g.a(paramJSONObject, "secret");
      g.a(paramJSONObject, "sec_sign");
      this.e.d(str);
      Object localObject1 = g.b(paramJSONObject, "upgrade_info");
      this.s = g.a((JSONObject)localObject1, "type");
      str = g.a((JSONObject)localObject1, "desc");
      localObject1 = g.a((JSONObject)localObject1, "url");
      if (this.s.equalsIgnoreCase("02"))
      {
        a(this.s, str, (String)localObject1);
      }
      else
      {
        this.a.j = g.a(paramJSONObject, "title");
        this.a.g = g.b(paramJSONObject, "init_button");
        this.a.e = g.c(paramJSONObject, "order");
        this.a.f = g.b(paramJSONObject, "risk_info");
        Object localObject2 = g.d(paramJSONObject, "cards");
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          this.p = new ArrayList(((List)localObject2).size());
        }
        int i = 0;
        while ((localObject2 != null) && (i < ((List)localObject2).size()))
        {
          com.unionpay.mobile.android.model.a locala = new com.unionpay.mobile.android.model.a(g.a((JSONArray)((List)localObject2).get(i), 0), g.a((JSONArray)((List)localObject2).get(i), 1), g.a((JSONArray)((List)localObject2).get(i), 2), (byte)0);
          this.p.add(locala);
          i += 1;
        }
        this.a.n = g.a(paramJSONObject, "bank_url");
        this.a.o = g.c(paramJSONObject, "input_info");
        this.a.q = g.b(paramJSONObject, "account_info");
        this.a.r = g.b(paramJSONObject, "other_card_info");
        this.a.p = g.a(paramJSONObject, "user_id");
        this.e.b(g.a(paramJSONObject, "sid"));
        this.e.c(g.a(paramJSONObject, "secret"));
        localObject2 = g.a(paramJSONObject, "secret");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.a.i = ((String)localObject2);
        }
        localObject2 = g.a(paramJSONObject, "uid");
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          PreferenceUtils.a(this.d, (String)localObject2);
        }
        if (t())
        {
          this.x = g.c(paramJSONObject, "cards_desc");
          this.a.ai = g.a(paramJSONObject, "trade_privilege");
          this.a.ak = g.a(paramJSONObject, "upcard_msg");
          this.a.aj = 0;
          localObject2 = g.a(paramJSONObject, "upcard_support_type");
          if ((!"1".equalsIgnoreCase(this.a.ai)) && (localObject2 != null) && (((String)localObject2).length() > 0)) {
            this.a.aj = Integer.parseInt((String)localObject2, 2);
          }
          f(this.a.aj);
        }
        this.a.am = g.a(paramJSONObject, "ad");
        this.a.ao = g.a(paramJSONObject, "pay_tip");
        localObject2 = g.a(paramJSONObject, "sup_pay_method");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.a.au = "01".equals(localObject2);
        }
        this.a.ap = g.b(paramJSONObject, "find_pwd_url");
        this.a.T = g.b(paramJSONObject, "reg_url");
        localObject2 = this.a;
        if (!"0".equals(g.a(paramJSONObject, "sup_nfc"))) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.unionpay.mobile.android.model.b)localObject2).at = bool;
          if (this.s.equalsIgnoreCase("00")) {
            break label758;
          }
          a(this.s, str, (String)localObject1);
          break;
        }
        label758:
        if (b(this.a.p))
        {
          this.t = 2;
          paramJSONObject = String.format("\"user_id\":\"%s\"", new Object[] { this.a.p });
          this.e.k(paramJSONObject);
        }
        else
        {
          u();
          continue;
          f.c(this.a, paramJSONObject);
          i = f.b(this.a, paramJSONObject);
          if (i != 0)
          {
            b(i);
          }
          else
          {
            this.y = f.a(paramJSONObject);
            u();
          }
        }
      }
    }
  }
  
  public final void b(int paramInt)
  {
    h.a("uppay", toString() + "doErrHappended() +++");
    b(paramInt, "fail");
    h.a("uppay", toString() + "doErrHappended() ---");
  }
  
  public final void c(String paramString)
  {
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    new com.unionpay.mobile.android.utils.n(paramString, this).a();
  }
  
  protected final void d()
  {
    super.d();
    this.l.setBackgroundColor(-1);
    setBackgroundDrawable(this.c.a(3008));
    int i = com.unionpay.mobile.android.global.a.I / 2;
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageDrawable(this.c.a(1027, i, -1));
    ((ImageView)localObject).setId(localObject.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.leftMargin = com.unionpay.mobile.android.global.a.j;
    localLayoutParams.topMargin = ((int)(0.3F * com.unionpay.mobile.android.global.a.t));
    addView((View)localObject, localLayoutParams);
    this.r = new ProgressBar(getContext(), null, 16843399);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(3, ((ImageView)localObject).getId());
    localLayoutParams.topMargin = (com.unionpay.mobile.android.global.a.d * 3);
    addView(this.r, localLayoutParams);
    localObject = new LinearLayout(this.d);
    ((LinearLayout)localObject).setOrientation(1);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.bottomMargin = com.unionpay.mobile.android.global.a.b;
    addView((View)localObject, localLayoutParams);
    TextView localTextView = new TextView(this.d);
    localTextView.setText(com.unionpay.mobile.android.languages.c.by.a);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(14.0F);
    localTextView.setGravity(1);
    new LinearLayout.LayoutParams(-2, -2).gravity = 14;
    ((LinearLayout)localObject).addView(localTextView, localLayoutParams);
    localTextView = new TextView(getContext());
    localTextView.setText(com.unionpay.mobile.android.languages.c.by.b);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(16.0F);
    localTextView.setGravity(1);
    new LinearLayout.LayoutParams(-2, -2).gravity = 14;
    ((LinearLayout)localObject).addView(localTextView, localLayoutParams);
  }
  
  public final void d(String paramString)
  {
    this.t = 1;
    this.e.a(this.z);
    this.e.a(this.a.b, paramString);
    this.e.a(this);
  }
  
  public final void l() {}
  
  protected void r()
  {
    s();
  }
  
  public final void s()
  {
    int i = 1;
    boolean bool;
    if (!this.C)
    {
      this.C = true;
      v();
      this.w = false;
      Object localObject = this.A;
      bool = this.B;
      this.e.a();
      UPPayEngine localUPPayEngine = this.e;
      if (!this.a.c) {
        break label141;
      }
      this.z = localUPPayEngine.initJNIEnv((Activity)localObject, i, Integer.decode(this.a.D.c).intValue(), this.a.D.d, this.a.a, this.a.aE);
      if ((!bool) || (this.z == 0L) || (this.z == -1L)) {
        break label146;
      }
      localObject = this.d;
      y();
    }
    label141:
    label146:
    do
    {
      return;
      i = 0;
      break;
      if (this.z == -1L)
      {
        b(7, null);
        return;
      }
    } while (bool);
    b(5, null);
  }
  
  public boolean t()
  {
    return false;
  }
  
  public final void u()
  {
    if (this.s.equalsIgnoreCase("02"))
    {
      k();
      return;
    }
    this.u += 1;
    this.w = true;
    A();
  }
  
  public void v()
  {
    w();
  }
  
  protected final void w()
  {
    this.u += 1;
    A();
  }
  
  public final void x()
  {
    removeAllViews();
    this.r = null;
  }
  
  public void y()
  {
    d("000");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */