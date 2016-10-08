package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.classes.home.view.wiget.RoundRectangleLayout;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.e.b;

public class LoverSearchView
  extends LinearLayout
{
  @BindView(2131559488)
  TextView MyUserIdText;
  private int a;
  private int b = 0;
  @BindView(2131559482)
  View backgrandView;
  private int[] c = { -1470284, -15431708, -15655384, -4760093, -15938635, -1556684, -13474670, 34222, -2175834 };
  @BindView(2131559492)
  ImageView cancelRequestBtn;
  @BindView(2131559487)
  ImageView cleanView;
  @BindView(2131559489)
  ImageView copyBtn;
  private int[] d = { -735271, -7748623, -7827821, -2380047, -8002086, -811111, -6770232, 49878, -1120814 };
  private h e;
  private String f;
  @BindView(2131559491)
  AvatarView imgAvatar;
  @BindView(2131559486)
  RoundRectangleLayout searchBtn;
  @BindView(2131558813)
  EditText searchEdit;
  @BindView(2131559483)
  View searchLayout;
  @BindView(2131559490)
  View waitingLayout;
  
  public LoverSearchView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public LoverSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      this.cleanView.setVisibility(0);
      this.searchBtn.setBackgroundColour(this.c[this.b]);
      this.searchBtn.setEnabled(true);
      this.searchBtn.setClickable(true);
      return;
    }
    this.cleanView.setVisibility(8);
    this.searchBtn.setBackgroundColour(this.d[this.b]);
    this.searchBtn.setEnabled(false);
    this.searchBtn.setClickable(false);
  }
  
  private void a(View paramView)
  {
    d();
    e();
    f();
    if (User.getInstance().getLoverId() <= 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    g localg = new g(getContext());
    localg.a(paramString);
    localg.a(2131100898, new ak(this));
    localg.show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    new k(getContext()).a(paramString2, paramString1, 2131100594, 2131099973, new ab(this), 2131100898, new ac(this));
  }
  
  private void b(String paramString)
  {
    this.f = paramString;
    new l(new al(this, getContext())).b(paramString);
  }
  
  private void c()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903248, this);
    ButterKnife.bind(localView);
    a(localView);
    localView.setOnTouchListener(new aa(this));
  }
  
  private void c(String paramString)
  {
    new l(new ad(this, getContext())).c(paramString);
  }
  
  private void d()
  {
    this.MyUserIdText.setText(User.getInstance().getUserName());
    ae localae = new ae(this);
    this.searchEdit.setOnEditorActionListener(localae);
    this.searchEdit.setFocusable(true);
    this.searchEdit.setFocusableInTouchMode(true);
    this.searchEdit.setOnClickListener(new af(this));
    this.searchBtn.setBackgroundColour(this.d[this.b]);
    this.searchBtn.setEnabled(false);
    this.searchBtn.setClickable(false);
    this.searchBtn.setOnClickListener(new ag(this));
    b();
    this.copyBtn.setOnClickListener(new ah(this));
    this.searchEdit.addTextChangedListener(new ai(this));
  }
  
  private void d(String paramString)
  {
    this.e = h.a(getContext());
    if (!this.e.isShowing()) {
      this.e.show();
    }
    if ((paramString != null) && (paramString.length() > 1)) {
      this.e.a(paramString);
    }
  }
  
  private void e()
  {
    this.cancelRequestBtn.setOnClickListener(new aj(this));
  }
  
  private void f()
  {
    String str1 = UserConfig.getString("home_search_lover_avatar", null);
    String str2 = UserConfig.getString("home_search_lover_email", null);
    if ((str1 != null) && (str2 != null))
    {
      this.waitingLayout.setVisibility(0);
      this.searchLayout.setVisibility(8);
      b.b(this.imgAvatar, str1, com.xiaoenai.app.utils.ab.a(60.0F));
      return;
    }
    this.waitingLayout.setVisibility(8);
    this.searchLayout.setVisibility(0);
  }
  
  private void g()
  {
    String str = this.searchEdit.getText().toString().trim();
    if (str.length() == 0)
    {
      a(getContext().getString(2131100593));
      return;
    }
    b(str);
  }
  
  private void h()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    this.e = null;
  }
  
  public void a()
  {
    this.MyUserIdText.setText(User.getInstance().getUserName());
  }
  
  public void b()
  {
    this.b = UserConfig.getInt("chat_title_color_index", Integer.valueOf(0)).intValue();
    this.a = UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue();
    this.backgrandView.setBackgroundColor(this.a);
    a(this.searchEdit.getText());
  }
  
  @OnClick({2131559487})
  void cleanEditView()
  {
    this.searchEdit.setText("");
    this.cleanView.setVisibility(8);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (User.getInstance().getLoverId() < 0)) {
      f();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\view\LoverSearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */