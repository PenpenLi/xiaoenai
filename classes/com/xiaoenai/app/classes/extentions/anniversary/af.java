package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

class af
  implements View.OnClickListener
{
  af(AnniversaryDatePickerDialog paramAnniversaryDatePickerDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = Calendar.getInstance(TimeZone.getDefault());
    paramView.set(1, this.a.a);
    paramView.set(2, this.a.b);
    paramView.set(5, this.a.c);
    paramView.set(11, 0);
    paramView.set(12, 0);
    paramView.set(13, 0);
    if ((this.a.f != -1) && (paramView.getTimeInMillis() > Calendar.getInstance().getTimeInMillis()) && (((ah)ai.a().b().get(this.a.f)).a().equals(ah.b)))
    {
      Toast.makeText(this.a, "日期有误，请重新选择", 0).show();
      return;
    }
    String str = new SimpleDateFormat("yyyy-MM-dd").format(paramView.getTime());
    Intent localIntent = new Intent(this.a, AnniversaryAddActivity.class);
    localIntent.putExtra("date", str);
    localIntent.putExtra("ts", paramView.getTimeInMillis() / 1000L);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */