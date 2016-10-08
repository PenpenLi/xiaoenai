package com.xiaoenai.app.classes.extentions.anniversary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import com.xiaoenai.app.classes.common.BaseActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class AnniversaryDatePickerDialog
  extends BaseActivity
{
  int a;
  int b;
  int c;
  int f;
  
  private void a()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.f = getIntent().getIntExtra("index", -1);
    if (this.f != -1)
    {
      ah localah = (ah)ai.a().b().get(this.f);
      if (localah.b() != 0L) {
        localCalendar.setTimeInMillis(localah.b() * 1000L);
      }
    }
    this.a = localCalendar.get(1);
    this.b = localCalendar.get(2);
    this.c = localCalendar.get(5);
  }
  
  @SuppressLint({"NewApi"})
  private void b()
  {
    DatePicker localDatePicker = (DatePicker)findViewById(2131559042);
    if ((this.f != -1) && (((ah)ai.a().b().get(this.f)).a().equals(ah.b)) && (Build.VERSION.SDK_INT >= 11)) {
      localDatePicker.setMaxDate(Calendar.getInstance().getTimeInMillis());
    }
    localDatePicker.init(this.a, this.b, this.c, new ae(this));
    ((Button)findViewById(2131559043)).setOnClickListener(new af(this));
    ((Button)findViewById(2131559044)).setOnClickListener(new ag(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903166);
    a();
    b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\AnniversaryDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */