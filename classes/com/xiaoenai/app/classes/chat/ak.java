package com.xiaoenai.app.classes.chat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ImageView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.e.b;
import java.io.File;

public class ak
{
  public static Integer a(String paramString, Integer paramInteger)
  {
    try
    {
      int i = Xiaoenai.j().getSharedPreferences("user_chat_bg_" + AppModel.getInstance().getUserId(), 0).getInt(paramString, paramInteger.intValue());
      return Integer.valueOf(i);
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(ImageView paramImageView)
  {
    String str = b("chat_bg_photo_path", null);
    int i = a("chat_bg_type", Integer.valueOf(-2)).intValue();
    if ((str != null) && (i > -2))
    {
      if (i == -1) {
        if (new File(str).exists()) {
          b.a(paramImageView, "file://" + str);
        }
      }
      do
      {
        return;
        paramImageView.setImageResource(2130837652);
        a("chat_bg_photo_path");
        a("chat_bg_type");
        return;
        if (i == 0)
        {
          paramImageView.setImageResource(2130837652);
          return;
        }
        if (i == 1)
        {
          paramImageView.setImageResource(2130837654);
          return;
        }
        if (i == 2)
        {
          paramImageView.setImageResource(2130837656);
          return;
        }
        if (str.startsWith("/"))
        {
          if (new File(str).exists())
          {
            b.a(paramImageView, "file://" + str);
            return;
          }
          str = b("chat_bg_origin_url", null);
          if ((str != null) && (str.length() > 0))
          {
            b.a(paramImageView, str, new al());
            return;
          }
          a("chat_bg_photo_path");
          a("chat_bg_type");
          return;
        }
      } while (!str.startsWith("http:"));
      b.a(paramImageView, str, new am());
      return;
    }
    paramImageView.setImageResource(2130837652);
  }
  
  public static void a(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_chat_bg_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_chat_bg_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.putInt(paramString, paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_chat_bg_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Xiaoenai.j().getSharedPreferences("user_chat_bg_" + AppModel.getInstance().getUserId(), 0).getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */