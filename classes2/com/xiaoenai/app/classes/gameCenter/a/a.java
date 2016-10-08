package com.xiaoenai.app.classes.gameCenter.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.gameCenter.GameItemActivity;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.remindButton.RemindButton;
import java.util.List;
import java.util.Vector;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<GameEntry> b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new Vector();
  }
  
  private void a(int paramInt, String paramString)
  {
    new k(this.a).a(String.format(this.a.getString(2131100524), new Object[] { paramString }), 2131099973, new d(this), 2131101308, new e(this, paramInt));
  }
  
  private void a(String paramString)
  {
    paramString = this.a.getPackageManager().getLaunchIntentForPackage(paramString);
    this.a.startActivity(paramString);
  }
  
  private void b(GameEntry paramGameEntry)
  {
    com.xiaoenai.app.widget.remindButton.a.a().b(paramGameEntry.getRedHintsInfo());
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, GameItemActivity.class);
    localIntent.putExtra("game_id", paramGameEntry.getId());
    localIntent.putExtra("from", this.a.getString(2131100525));
    this.a.startActivity(localIntent);
    ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
  }
  
  public void a(GameEntry paramGameEntry)
  {
    this.b.add(paramGameEntry);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return this.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      if (this.a == null) {
        break label331;
      }
      a locala = new a();
      View localView = ((Activity)this.a).getLayoutInflater().inflate(2130903226, null);
      locala.a = ((ImageView)localView.findViewById(2131559338));
      locala.b = ((TextView)localView.findViewById(2131559341));
      locala.c = ((TextView)localView.findViewById(2131559343));
      locala.d = ((Button)localView.findViewById(2131559340));
      locala.e = localView.findViewById(2131559344);
      locala.f = ((RemindButton)localView.findViewById(2131559339));
      locala.g = ((RemindButton)localView.findViewById(2131559342));
      locala.d.setOnClickListener(new b(this, paramInt));
      paramViewGroup = locala;
      paramView = localView;
      if (this.b.get(paramInt) != null)
      {
        paramViewGroup = locala;
        paramView = localView;
        if (((GameEntry)this.b.get(paramInt)).getStartType() == 0)
        {
          localView.setOnClickListener(new c(this, paramInt));
          paramView = localView;
          paramViewGroup = locala;
        }
      }
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("posotion: {} count:{}", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      if (paramInt == getCount() - 1) {}
      for (((LinearLayout.LayoutParams)paramViewGroup.e.getLayoutParams()).leftMargin = 0;; ((LinearLayout.LayoutParams)paramViewGroup.e.getLayoutParams()).leftMargin = ab.a(12.0F))
      {
        com.xiaoenai.app.classes.gameCenter.b.a.a((GameEntry)this.b.get(paramInt), paramViewGroup);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
      label331:
      paramViewGroup = null;
    }
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public Button d;
    public View e;
    public RemindButton f;
    public RemindButton g;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */