package com.xiaoenai.app.classes.street.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.xiaoenai.app.classes.street.StreetAddOrEditAddressActivity;
import com.xiaoenai.app.classes.street.StreetAddressManagerActivity;
import com.xiaoenai.app.classes.street.d.b;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.widget.StreetAddressItemView;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private List<Contact> a = new ArrayList();
  private Context b = null;
  private boolean c = true;
  private boolean d = false;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(Contact paramContact)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.b, StreetAddOrEditAddressActivity.class);
    localIntent.putExtra("street_contact_info_key", paramContact);
    localIntent.putExtra("street_address_add_or_edit_key", true);
    ((Activity)this.b).startActivityForResult(localIntent, 1);
    ((Activity)this.b).overridePendingTransition(2130968604, 2130968605);
  }
  
  public void a(ArrayList<Contact> paramArrayList)
  {
    this.a = paramArrayList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a != null) {
      i = this.a.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a != null) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (getCount() > 1) {
      if (paramInt == getCount() - 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = new StreetAddressItemView(this.b);
        paramView.setTag(paramView);
      }
      for (paramViewGroup = paramView;; paramViewGroup = (StreetAddressItemView)paramView)
      {
        Contact localContact = (Contact)getItem(paramInt);
        if (localContact != null)
        {
          b localb = (b)paramViewGroup.getPresenter();
          localb.a(this.d);
          localb.a(localContact);
          paramViewGroup.a();
          localb.a(i);
        }
        return paramView;
        if (paramInt == 0)
        {
          i = 0;
          break;
        }
        i = 3;
        break;
      }
      i = 2;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Contact)getItem(paramInt - 1);
    com.xiaoenai.app.utils.f.a.c("******Selected Contact ********id={} name = {}", new Object[] { Integer.valueOf(paramAdapterView.getId()), paramAdapterView.getReceiver() });
    if (this.d)
    {
      paramView = new Intent();
      paramView.putExtra("street_contact_info_key", paramAdapterView);
      ((StreetAddressManagerActivity)this.b).setResult(-1, paramView);
      ((StreetAddressManagerActivity)this.b).r();
      return;
    }
    a(paramAdapterView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */