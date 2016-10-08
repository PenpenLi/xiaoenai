package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.widget.AddressPicker.ProvincePicker;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.widget.TitleBarView;

public class StreetAddOrEditAddressActivity
  extends StreetBaseActivity
{
  View.OnTouchListener a = new o(this);
  private EditText b;
  private EditText c;
  private TextView i;
  private EditText j;
  private LinearLayout k;
  private ImageView l;
  private Button m;
  private ProvincePicker n;
  private Contact o;
  private boolean s = false;
  
  private void a(Contact paramContact)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_contact_info_key", paramContact);
    setResult(-1, localIntent);
    a_(2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setImageResource(2130837822);
      return;
    }
    this.l.setImageResource(2130837821);
  }
  
  private boolean b(String paramString)
  {
    if ((am.e(paramString)) && (paramString.length() == 11)) {
      return true;
    }
    h.c(this, 2131101212, 1500L);
    return false;
  }
  
  private void c()
  {
    this.b = ((EditText)findViewById(2131559789));
    this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.c = ((EditText)findViewById(2131559791));
    this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });
    this.i = ((TextView)findViewById(2131559793));
    this.n = ((ProvincePicker)findViewById(2131559800));
    this.j = ((EditText)findViewById(2131559795));
    this.k = ((LinearLayout)findViewById(2131559796));
    this.l = ((ImageView)findViewById(2131559798));
    this.m = ((Button)findViewById(2131559799));
  }
  
  private boolean c(String paramString)
  {
    if ((paramString.length() < 2) || (paramString.length() > 15))
    {
      h.c(this, 2131100686, 1500L);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    this.g.setTitle(2131100675);
    this.m.setVisibility(8);
    ab.a(this, this.b);
  }
  
  private boolean d(String paramString)
  {
    if (paramString.length() == 0)
    {
      h.c(this, 2131100681, 1500L);
      return false;
    }
    if ((paramString.length() < 5) || (paramString.length() > 60))
    {
      h.c(this, 2131100682, 1500L);
      return false;
    }
    return true;
  }
  
  private void f()
  {
    this.m.setVisibility(0);
    this.b.setText(this.o.getReceiver());
    this.c.setText(this.o.getPhone());
    this.i.setTextColor(getResources().getColor(2131493002));
    this.i.setText(this.o.getProvinceCityZone().replace(",", " "));
    this.j.setText(this.o.getAddress());
    a(this.o.isDefault());
    if (this.o.getProvinceCityZone().length() != 3)
    {
      String[] arrayOfString = this.o.getProvinceCityZone().split(",");
      this.n.a(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
    }
  }
  
  private void g()
  {
    this.b.setOnTouchListener(this.a);
    this.c.setOnTouchListener(this.a);
    this.j.setOnTouchListener(this.a);
    this.n.setProvincePickerListener(new j(this));
    this.i.setOnClickListener(new k(this));
    this.k.setOnClickListener(new l(this));
    this.l.setOnClickListener(new m(this));
    if (this.s) {
      this.m.setOnClickListener(new n(this));
    }
  }
  
  private boolean h()
  {
    if (this.i.getText().length() == 3)
    {
      h.c(this, 2131100690, 1500L);
      return false;
    }
    return true;
  }
  
  private void i()
  {
    this.n.setVisibility(8);
  }
  
  private void j()
  {
    this.n.postDelayed(new p(this), 100L);
  }
  
  private void k()
  {
    int i1 = 1;
    boolean bool;
    Contact localContact;
    if (!this.o.isDefault())
    {
      bool = true;
      a(bool);
      localContact = this.o;
      if (!bool) {
        break label39;
      }
    }
    for (;;)
    {
      localContact.setDefault(i1);
      return;
      bool = false;
      break;
      label39:
      i1 = 0;
    }
  }
  
  private void o()
  {
    new ae(new q(this, this)).a(this.o.getId());
  }
  
  private void p()
  {
    String str1 = this.b.getText().toString().trim();
    String str2 = this.c.getText().toString();
    String str3 = this.i.getText().toString().replace(" ", ",");
    String str4 = this.j.getText().toString().trim();
    if (!c(str1)) {}
    while ((!b(str2)) || (!h()) || (!d(str4))) {
      return;
    }
    ae localae = new ae(new e(this, this, str1, str4, str2, str3));
    if (this.s)
    {
      localae.a(this.o.getId(), str1, str2, str3, str4, this.o.getDefault());
      return;
    }
    localae.a(str1, str2, str3, str4, this.o.getDefault());
  }
  
  private void q()
  {
    setResult(-1);
    a_(2);
  }
  
  public int a()
  {
    return 2130903329;
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new d(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.s = getIntent().getBooleanExtra("street_address_add_or_edit_key", false);
    c();
    if (this.s)
    {
      this.o = ((Contact)getIntent().getParcelableExtra("street_contact_info_key"));
      f();
    }
    for (;;)
    {
      g();
      return;
      this.o = new Contact();
      d();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetAddOrEditAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */