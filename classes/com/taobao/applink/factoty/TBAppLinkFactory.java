package com.taobao.applink.factoty;

import com.taobao.applink.param.TBAuthParam;
import com.taobao.applink.param.TBBaseParam;
import com.taobao.applink.param.TBDetailParam;
import com.taobao.applink.param.TBNavParam;
import com.taobao.applink.param.TBShopParam;
import com.taobao.applink.param.TBURIParam;
import java.util.HashMap;
import java.util.Map;

public class TBAppLinkFactory
{
  private static final String JUMP_AUTH = "doAuth";
  private static final String JUMP_DETAIL = "jumpDetail";
  private static final String JUMP_H5 = "jumpH5";
  private static final String JUMP_NAV = "jumpNav";
  private static final String JUMP_SHOP = "jumpShop";
  private static Map<String, Class<? extends TBBaseParam>> registerMap = new HashMap();
  
  static
  {
    registerMap.put("jumpShop", TBShopParam.class);
    registerMap.put("jumpDetail", TBDetailParam.class);
    registerMap.put("jumpH5", TBURIParam.class);
    registerMap.put("doAuth", TBAuthParam.class);
    registerMap.put("jumpNav", TBNavParam.class);
  }
  
  /* Error */
  public static TBBaseParam createTBBaseParam(String paramString)
  {
    // Byte code:
    //   0: new 58	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: ldc 63
    //   12: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_1
    //   16: getstatic 32	com/taobao/applink/factoty/TBAppLinkFactory:registerMap	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 71 2 0
    //   25: checkcast 73	java/lang/Class
    //   28: astore_1
    //   29: aload_1
    //   30: iconst_0
    //   31: anewarray 73	java/lang/Class
    //   34: invokevirtual 77	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   37: astore_1
    //   38: aload_1
    //   39: iconst_1
    //   40: invokevirtual 83	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   43: aload_1
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokevirtual 87	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 89	com/taobao/applink/param/TBBaseParam
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 93	com/taobao/applink/param/TBBaseParam:checkParams	(Lorg/json/JSONObject;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifne +18 -> 80
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: ldc 95
    //   70: aload_0
    //   71: invokevirtual 99	org/json/JSONException:toString	()Ljava/lang/String;
    //   74: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aconst_null
    //   79: areturn
    //   80: aload_1
    //   81: aload_0
    //   82: invokevirtual 109	com/taobao/applink/param/TBBaseParam:setParams	(Lorg/json/JSONObject;)V
    //   85: aload_1
    //   86: areturn
    //   87: astore_0
    //   88: ldc 95
    //   90: aload_0
    //   91: invokevirtual 110	java/lang/Throwable:toString	()Ljava/lang/String;
    //   94: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aconst_null
    //   99: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramString	String
    //   15	71	1	localObject	Object
    //   60	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	16	67	org/json/JSONException
    //   29	61	87	java/lang/Throwable
    //   80	85	87	java/lang/Throwable
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\factoty\TBAppLinkFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */