package com.xiaoenai.app.data.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper;

public abstract class MQMessageReceiver
  extends BroadcastReceiver
{
  private String a;
  private final MessageEntityDataMapper b;
  
  public MQMessageReceiver(MessageEntityDataMapper paramMessageEntityDataMapper)
  {
    this.b = paramMessageEntityDataMapper;
  }
  
  public abstract void a();
  
  public abstract void a(com.xiaoenai.app.domain.c.a parama);
  
  public abstract void a(com.xiaoenai.app.domain.c.b paramb);
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramContext = com.meiqia.core.b.a(paramContext);
    if ("new_msg_received_action".equals(str))
    {
      paramContext = paramContext.a(paramIntent.getStringExtra("msgId"));
      if (paramContext != null)
      {
        paramContext = com.xiaoenai.app.h.c.b.a.a.a(paramContext);
        if (paramContext != null) {
          a(this.b.transform(paramContext));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ("agent_inputting_action".equals(str))
          {
            a();
            return;
          }
          if (!"agent_change_action".equals(str)) {
            break;
          }
          paramContext = paramContext.a();
          if (paramIntent.getBooleanExtra("client_is_redirected", false)) {
            a(paramContext.b());
          }
          paramContext = com.xiaoenai.app.h.c.b.a.a.a(paramContext);
          a(this.b.transformAgent(paramContext));
          paramContext = paramIntent.getStringExtra("conversation_id");
        } while (TextUtils.isEmpty(paramContext));
        this.a = paramContext;
        b(paramContext);
        return;
        if (!"invite_evaluation".equals(str)) {
          break;
        }
      } while (!paramIntent.getStringExtra("conversation_id").equals(this.a));
      b();
      return;
      if ("action_agent_status_update_event".equals(str))
      {
        c();
        return;
      }
      if ("action_black_add".equals(str))
      {
        d();
        return;
      }
      if ("action_black_del".equals(str))
      {
        e();
        return;
      }
      if (TextUtils.equals("action_queueing_remove", str))
      {
        f();
        return;
      }
    } while (!TextUtils.equals("action_queueing_init_conv", str));
    g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\receiver\MQMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */