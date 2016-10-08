package com.xiaoenai.app.classes.extentions.menses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.a;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.widget.TitleBarView;

public class MensesEditSexActivity
  extends TitleBarActivity
  implements View.OnClickListener
{
  private int a = -1;
  private String b = null;
  @BindView(2131559108)
  Button mButton = null;
  @BindView(2131559106)
  ImageView mFemalemSelector;
  @BindView(2131559107)
  ImageView mFemalemSelectorIcon;
  @BindView(2131559103)
  ImageView mMalemSelector;
  @BindView(2131559104)
  ImageView mMalemSelectorIcon;
  
  private void a(int paramInt)
  {
    new l(new v(this, this)).l(String.valueOf(paramInt), String.valueOf(1));
  }
  
  private void c()
  {
    int j = 8;
    this.a = ac.l();
    ButterKnife.bind(this);
    ImageView localImageView;
    if (this.a != -1)
    {
      localImageView = this.mMalemSelector;
      if (this.a != 1) {
        break label158;
      }
      i = 2130838733;
      localImageView.setImageResource(i);
      localImageView = this.mFemalemSelector;
      if (this.a != 0) {
        break label164;
      }
      i = 2130838731;
      label59:
      localImageView.setImageResource(i);
      localImageView = this.mFemalemSelectorIcon;
      if (this.a != 0) {
        break label170;
      }
    }
    label158:
    label164:
    label170:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView = this.mMalemSelectorIcon;
      i = j;
      if (this.a == 1) {
        i = 0;
      }
      localImageView.setVisibility(i);
      findViewById(2131559102).setOnClickListener(this);
      findViewById(2131559105).setOnClickListener(this);
      this.mButton.setOnClickListener(this);
      if (ac.l() != -1) {
        break label176;
      }
      this.mButton.setBackgroundResource(2130837625);
      this.mButton.setEnabled(false);
      return;
      i = 2130838732;
      break;
      i = 2130838730;
      break label59;
    }
    label176:
    this.mButton.setBackgroundResource(2130837628);
    this.mButton.setEnabled(true);
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", MensesEditSexActivity.class.getName());
    if (ac.p())
    {
      localIntent.setClass(this, MensesActivity.class);
      startActivity(localIntent);
      finish();
      if ((this.b == null) || (!this.b.equals(MensesSettingActivity.class.getName()))) {
        break label119;
      }
      overridePendingTransition(2130968606, 2130968607);
      a.a().a(MensesSettingActivity.class);
    }
    for (;;)
    {
      a.a().a(MensesActivity.class);
      return;
      if (1 == ac.l())
      {
        localIntent.setClass(this, MensesActivity.class);
        break;
      }
      localIntent.setClass(this, MensesSettingActivity.class);
      break;
      label119:
      overridePendingTransition(2130968606, 2130968607);
    }
  }
  
  private void d()
  {
    this.mButton.setBackgroundResource(2130837628);
    this.mButton.setEnabled(true);
  }
  
  public int a()
  {
    return 2130903175;
  }
  
  protected void b()
  {
    super.b();
    if ((this.b != null) && (this.b.equals(MensesSettingActivity.class.getName()))) {
      this.g.a(2130839000, 2131099966);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131559102: 
      this.mFemalemSelector.setImageResource(2130838730);
      this.mMalemSelector.setImageResource(2130838733);
      this.mMalemSelectorIcon.setVisibility(0);
      this.mFemalemSelectorIcon.setVisibility(8);
      this.a = 1;
      d();
      return;
    case 2131559105: 
      this.mFemalemSelector.setImageResource(2130838731);
      this.mMalemSelector.setImageResource(2130838732);
      this.mMalemSelectorIcon.setVisibility(8);
      this.mFemalemSelectorIcon.setVisibility(0);
      this.a = 0;
      d();
      return;
    }
    if (this.a != ac.l())
    {
      a(this.a);
      return;
    }
    r();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.b = getIntent().getStringExtra("from");
    super.onCreate(paramBundle);
    c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\MensesEditSexActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */