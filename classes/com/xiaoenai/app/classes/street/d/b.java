package com.xiaoenai.app.classes.street.d;

import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.widget.StreetAddressItemView.a;
import com.xiaoenai.app.classes.street.widget.StreetBaseItemView;

public class b
  extends a
{
  private Contact a = null;
  private StreetAddressItemView.a b = null;
  private boolean c = false;
  
  public b(StreetAddressItemView.a parama)
  {
    this.b = parama;
  }
  
  public void a(int paramInt)
  {
    this.b.a.setisTopShortLine(true);
    this.b.a.setisBottomShortLine(true);
    if (paramInt == 0)
    {
      this.b.a.setBackgroundWithPosition(2);
      return;
    }
    if (paramInt == 1)
    {
      this.b.a.setBackgroundWithPosition(1);
      return;
    }
    if (paramInt == 2)
    {
      this.b.a.setisTopShortLine(false);
      this.b.a.setisBottomShortLine(false);
      this.b.a.setBackgroundWithPosition(0);
      return;
    }
    this.b.a.setBackgroundWithPosition(2);
  }
  
  public void a(Contact paramContact)
  {
    this.a = paramContact;
  }
  
  public void a(StreetAddressItemView.a parama)
  {
    parama.c.setText(this.a.getReceiver());
    parama.d.setText(this.a.getPhone());
    String str = this.a.getProvinceCityZone().replace(",", "") + this.a.getAddress();
    parama.e.setText(str);
    if (this.c)
    {
      parama.b.setVisibility(8);
      return;
    }
    if (this.a.isDefault())
    {
      parama.b.setVisibility(0);
      return;
    }
    parama.b.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */