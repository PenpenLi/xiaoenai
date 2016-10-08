package com.xiaoenai.app.classes.forum.viewholder;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.classes.chat.input.faces.d;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;

public class ForumNotifyViewHolder
  extends com.marshalchen.ultimaterecyclerview.f<g>
{
  @BindView(2131559222)
  View mBottomDivider;
  @BindView(2131559260)
  TextView mCreatedTxt;
  @BindView(2131559255)
  ImageView mIconImg;
  @BindView(2131559256)
  TextView mNickNameTxt;
  @BindView(2131559258)
  TextView mPostContent;
  @BindView(2131559259)
  TextView mReplyPostContent;
  @BindView(2131559257)
  TextView mTitle;
  @BindView(2131559196)
  View mTopDivider;
  
  public ForumNotifyViewHolder(View paramView)
  {
    super(paramView);
    ButterKnife.bind(this, paramView);
  }
  
  public void a(g paramg, int paramInt, boolean paramBoolean)
  {
    Object localObject = (RelativeLayout.LayoutParams)this.mBottomDivider.getLayoutParams();
    int i;
    label38:
    label165:
    String str;
    if (paramBoolean)
    {
      i = 0;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      localObject = this.mTopDivider;
      if (paramInt != 0) {
        break label501;
      }
      paramInt = 0;
      ((View)localObject).setVisibility(paramInt);
      if (paramg != null)
      {
        if (paramg.j.g != null)
        {
          this.mIconImg.setImageResource(2130837619);
          com.xiaoenai.app.utils.e.b.a(this.mIconImg, paramg.j.g.c + "?imageView/2/w/" + ab.a(45.0F));
          if (paramg.j.e == 0) {
            break label507;
          }
          localObject = String.valueOf(paramg.j.e) + this.itemView.getResources().getString(2131101280) + "  ";
          str = (String)localObject + paramg.j.g.b;
          if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
            break label515;
          }
          SpannableString localSpannableString = new SpannableString(str);
          localSpannableString.setSpan(new ForegroundColorSpan(this.mIconImg.getResources().getColor(2131492942)), ((String)localObject).length(), str.length(), 17);
          this.mNickNameTxt.setText(localSpannableString);
          label266:
          this.mNickNameTxt.setCompoundDrawablePadding(ab.a(10.0F));
          if (User.getInstance().getLoverId() != paramg.k) {
            break label527;
          }
          paramInt = 2130838450;
          this.mTitle.setTextColor(this.itemView.getResources().getColor(2131492959));
          label315:
          this.mNickNameTxt.setCompoundDrawablesWithIntrinsicBounds(null, null, this.itemView.getResources().getDrawable(paramInt), null);
        }
        this.mCreatedTxt.setText(ak.a(paramg.j.f));
        this.mTitle.setText(paramg.j.j);
        this.mPostContent.setVisibility(0);
        this.mReplyPostContent.setVisibility(8);
        if ((paramg.j.m != 1) && (paramg.j.m != 0)) {
          break label780;
        }
        if ((paramg.j.n != 0) && (paramg.j.d != null)) {
          break label574;
        }
        this.mPostContent.setVisibility(8);
        if ((paramg.l != null) && (paramg.l.length() != 0))
        {
          this.mReplyPostContent.setVisibility(0);
          this.mReplyPostContent.setText(paramg.l);
          d.a().c(this.mReplyPostContent);
        }
      }
    }
    for (;;)
    {
      d.a().c(this.mTitle);
      return;
      i = ab.a(10.0F);
      break;
      label501:
      paramInt = 8;
      break label38;
      label507:
      localObject = "";
      break label165;
      label515:
      this.mNickNameTxt.setText(str);
      break label266;
      label527:
      this.mTitle.setTextColor(this.itemView.getResources().getColor(2131492966));
      if (paramg.j.g.e == 0)
      {
        paramInt = 2130838451;
        break label315;
      }
      paramInt = 2130838454;
      break label315;
      label574:
      if ((0L != paramg.m) && (paramg.j.l != null) && (paramg.j.l.length() > 0)) {
        localObject = String.format(this.itemView.getResources().getString(2131100482), new Object[] { paramg.j.l }) + paramg.j.d;
      }
      for (;;)
      {
        this.mPostContent.setText((CharSequence)localObject);
        d.a().c(this.mPostContent);
        break;
        if (paramg.n == com.xiaoenai.app.model.Forum.f.d().a) {
          localObject = this.itemView.getResources().getString(2131100483) + paramg.j.d;
        } else {
          localObject = this.itemView.getResources().getString(2131100480) + paramg.j.d;
        }
      }
      label780:
      this.mPostContent.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\viewholder\ForumNotifyViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */