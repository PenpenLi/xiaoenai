package com.xiaoenai.app.classes.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.EditDialog;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingReleaseActivity
  extends TitleBarActivity
{
  View a;
  View b;
  JSONObject c;
  private TextView i;
  private boolean j = true;
  
  private void a(JSONObject paramJSONObject)
  {
    this.j = paramJSONObject.getBoolean("password_exist");
  }
  
  private void a(boolean paramBoolean)
  {
    new l(new ak(this, this, paramBoolean)).d();
  }
  
  private void d()
  {
    this.a = findViewById(2131559718);
    this.i = ((TextView)findViewById(2131559772));
    this.b = findViewById(2131559773);
    this.b.setOnClickListener(new ag(this));
    this.b.setEnabled(false);
    this.a.setVisibility(8);
    if (this.c != null) {}
    try
    {
      this.i.setText(this.c.getString("note"));
      this.b.setEnabled(true);
      this.a.setVisibility(0);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void f()
  {
    new l(new aj(this, this)).q();
  }
  
  private void g()
  {
    new k(this).a(2131101220, 2131099973, new al(this), 2131101150, new am(this));
  }
  
  public int a()
  {
    return 2130903321;
  }
  
  protected void c()
  {
    EditDialog localEditDialog = new EditDialog(this);
    localEditDialog.setTitle(2131101219);
    localEditDialog.a(2131099973, new ah(this, localEditDialog));
    localEditDialog.a(2131100898, new ai(this, localEditDialog));
    localEditDialog.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = f.a(f.a(Xiaoenai.j(), "release_note"));
    f();
    d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingReleaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */