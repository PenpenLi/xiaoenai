package com.xiaoenai.app.classes.extentions.menses;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.utils.ak;
import java.util.Timer;

public class MensesMaleFragment
  extends Fragment
{
  private View a = null;
  private View b = null;
  private View c = null;
  private TextView d = null;
  private TextView e = null;
  private View f = null;
  private ac.a g = ac.a.a;
  private Handler h = new Handler();
  private Timer i = null;
  private long j = 0L;
  @BindView(2131559112)
  LinearLayout mCloseIcon;
  @BindView(2131559113)
  LinearLayout mColseTip;
  @BindView(2131559115)
  Button mConcernView;
  
  private void a()
  {
    Intent localIntent = new Intent(getActivity(), ChatActivity.class);
    getActivity().startActivity(localIntent);
    getActivity().overridePendingTransition(2130968608, 2130968609);
  }
  
  private void a(ac.a parama)
  {
    if (this.c == null) {}
    do
    {
      do
      {
        return;
        this.e.setVisibility(0);
        switch (z.a[parama.ordinal()])
        {
        default: 
          return;
        case 1: 
          this.c.setVisibility(8);
          this.mConcernView.setVisibility(8);
          this.a.setVisibility(0);
          this.b.setVisibility(8);
          this.e.setText(2131100850);
          if (this.i == null) {}
          for (this.i = new Timer(true);; this.i = new Timer(true))
          {
            this.j = (ac.k() - ak.b());
            this.i.schedule(new x(this), 0L, 1000L);
            return;
            this.i.cancel();
            this.i = null;
          }
        case 2: 
          this.c.setVisibility(8);
          this.mConcernView.setVisibility(8);
          this.a.setVisibility(8);
          this.b.setVisibility(0);
          this.e.setText(2131100848);
        }
      } while (this.i == null);
      this.i.cancel();
      this.i = null;
      return;
      this.c.setVisibility(0);
      this.mConcernView.setVisibility(0);
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      this.e.setText(2131100849);
    } while (this.i == null);
    this.i.cancel();
    this.i = null;
  }
  
  private void b()
  {
    if (ac.c())
    {
      this.mConcernView.setVisibility(8);
      return;
    }
    this.mCloseIcon.setVisibility(8);
    this.mColseTip.setVisibility(8);
    if (ac.p())
    {
      this.f.findViewById(2131559109).setVisibility(8);
      this.f.findViewById(2131558464).setVisibility(0);
      this.a = this.f.findViewById(2131559085);
      this.b = this.f.findViewById(2131559089);
      this.c = this.f.findViewById(2131559092);
      this.d = ((TextView)this.f.findViewById(2131559088));
      this.e = ((TextView)this.f.findViewById(2131559114));
      return;
    }
    this.f.findViewById(2131558464).setVisibility(8);
    this.f.findViewById(2131559109).setVisibility(0);
  }
  
  @OnClick({2131559115})
  void concern()
  {
    a();
    k.y().j();
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.f = paramLayoutInflater.inflate(2130903176, paramViewGroup, false);
    ButterKnife.bind(this, this.f);
    b();
    return this.f;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (ac.c()) {}
    do
    {
      return;
      this.g = ac.n();
      if (ac.p())
      {
        a(this.g);
        return;
      }
    } while (this.f == null);
    this.f.findViewById(2131558464).setVisibility(8);
    this.f.findViewById(2131559109).setVisibility(0);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\MensesMaleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */