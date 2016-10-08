package com.sina.weibo.sdk.register.mobile;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class SelectCountryActivity$2
  implements AdapterView.OnItemClickListener
{
  SelectCountryActivity$2(SelectCountryActivity paramSelectCountryActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Country)SelectCountryActivity.access$2(this.this$0).getItem(paramInt);
    if (paramAdapterView == null) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("code", paramAdapterView.getCode());
    paramView.putExtra("name", paramAdapterView.getName());
    this.this$0.setResult(-1, paramView);
    this.this$0.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\SelectCountryActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */