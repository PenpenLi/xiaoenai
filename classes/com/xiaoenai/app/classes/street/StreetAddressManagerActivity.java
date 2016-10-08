package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.street.a.a;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.widget.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.d.f;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetAddressManagerActivity
  extends StreetBaseActivity
{
  PullToRefreshListView a = null;
  a b = null;
  b c = null;
  boolean i = false;
  
  private void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramJSONObject.optJSONObject("data"));
      f.a(localJSONObject, f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "street_address_list_file_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    this.a = ((PullToRefreshListView)findViewById(2131559805));
    this.c = new b(this);
    this.a.setAdapter(this.b);
    ((ListView)this.a.getRefreshableView()).addFooterView(this.c);
  }
  
  private void d()
  {
    this.a.setOnRefreshListener(new t(this));
    this.a.setOnLastItemVisibleListener(new u(this));
    this.a.setOnItemClickListener(this.b);
    this.c.setOnClickListener(new v(this));
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, StreetAddOrEditAddressActivity.class);
    localIntent.putExtra("street_address_add_or_edit_key", false);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void g()
  {
    new ae(new w(this, this)).b();
  }
  
  private void h()
  {
    Object localObject = f.a(f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "street_address_list_file_name"));
    if ((localObject != null) && (((JSONObject)localObject).optJSONArray("data") != null))
    {
      localObject = Contact.getContactList(((JSONObject)localObject).optJSONArray("data"));
      this.b.a((ArrayList)localObject);
    }
  }
  
  public int a()
  {
    return 2130903331;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      g();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = getIntent().getBooleanExtra("street_address_is_selector_mode_key", false);
    this.b = new a(this);
    this.b.a(this.i);
    c();
    d();
    g();
    h();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetAddressManagerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */