package com.xiaoenai.app.classes.common.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EditDialog
  extends a
{
  private a a;
  private View b;
  @BindView(2131558930)
  Button mLeftButton;
  @BindView(2131558931)
  Button mRightButton;
  @BindView(2131558923)
  TextView mTv_title;
  @BindView(2131558928)
  EditText messageText;
  
  public EditDialog(Context paramContext)
  {
    super(paramContext, 2131296450);
    this.b = LayoutInflater.from(paramContext).inflate(2130903137, null);
    a(this.b);
  }
  
  private void a(View paramView)
  {
    ButterKnife.bind(this, paramView);
    this.mRightButton.setOnClickListener(new o(this));
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    String str = getContext().getResources().getString(paramInt);
    this.mLeftButton.setText(str);
    this.mLeftButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(int paramInt, a parama)
  {
    String str = getContext().getResources().getString(paramInt);
    this.mRightButton.setText(str);
    this.a = parama;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.b);
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, EditText paramEditText);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\EditDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */