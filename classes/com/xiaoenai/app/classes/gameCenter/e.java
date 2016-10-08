package com.xiaoenai.app.classes.gameCenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;
import com.xiaoenai.app.classes.street.model.ImageInfo;

class e
  implements AdapterView.OnItemClickListener
{
  e(GameItemActivity paramGameItemActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ImageInfo[])paramView.getTag(2131558427);
    if (paramAdapterView != null)
    {
      Intent localIntent = new Intent(paramView.getContext(), ImageViewPager.class);
      String[] arrayOfString = new String[paramAdapterView.length];
      paramInt = 0;
      while (paramInt < paramAdapterView.length)
      {
        arrayOfString[paramInt] = paramAdapterView[paramInt].getUrl();
        paramInt += 1;
      }
      localIntent.putExtra("imageUrls", arrayOfString);
      localIntent.putExtra("from", 10);
      localIntent.putExtra("position", Integer.parseInt(paramView.getTag(2131558426).toString()));
      paramView.getContext().startActivity(localIntent);
      this.a.overridePendingTransition(2130968588, 2130968589);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */