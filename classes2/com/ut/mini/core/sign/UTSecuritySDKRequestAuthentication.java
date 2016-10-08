package com.ut.mini.core.sign;

import com.alibaba.mtl.log.e.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UTSecuritySDKRequestAuthentication
  implements IUTRequestAuthentication
{
  private boolean D = false;
  private Class jdField_a_of_type_JavaLangClass = null;
  private Field jdField_a_of_type_JavaLangReflectField = null;
  private Method jdField_a_of_type_JavaLangReflectMethod = null;
  private String aa;
  private Object jdField_b_of_type_JavaLangObject = null;
  private String jdField_b_of_type_JavaLangString = null;
  private Field jdField_b_of_type_JavaLangReflectField = null;
  private Object jdField_c_of_type_JavaLangObject = null;
  private Field jdField_c_of_type_JavaLangReflectField = null;
  private int z = 1;
  
  public UTSecuritySDKRequestAuthentication(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.aa = paramString2;
  }
  
  /* Error */
  private void D()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:D	Z
    //   8: istore 5
    //   10: iload 5
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: ldc 51
    //   20: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: ldc 59
    //   28: iconst_1
    //   29: anewarray 53	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: ldc 61
    //   36: aastore
    //   37: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   40: aconst_null
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: invokestatic 70	com/alibaba/mtl/log/b:a	()Lcom/alibaba/mtl/log/b;
    //   50: invokevirtual 74	com/alibaba/mtl/log/b:getContext	()Landroid/content/Context;
    //   53: aastore
    //   54: invokevirtual 80	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: putfield 28	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   60: aload_0
    //   61: aload_1
    //   62: ldc 82
    //   64: iconst_0
    //   65: anewarray 53	java/lang/Class
    //   68: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: aload_0
    //   72: getfield 28	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokevirtual 80	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   82: putfield 30	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   85: aload_1
    //   86: ifnull +125 -> 211
    //   89: aload_0
    //   90: ldc 84
    //   92: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   95: putfield 32	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 32	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   103: ldc 86
    //   105: invokevirtual 90	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   108: putfield 34	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 32	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   116: ldc 92
    //   118: invokevirtual 90	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   121: putfield 36	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 32	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   129: ldc 94
    //   131: invokevirtual 90	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   134: putfield 38	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_c_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   137: aload_1
    //   138: ldc 96
    //   140: iconst_0
    //   141: anewarray 53	java/lang/Class
    //   144: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +105 -> 254
    //   152: aload_1
    //   153: aload_0
    //   154: getfield 28	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokevirtual 80	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 98	java/lang/Boolean
    //   167: invokevirtual 102	java/lang/Boolean:booleanValue	()Z
    //   170: istore 5
    //   172: goto +140 -> 312
    //   175: aload_0
    //   176: iload 4
    //   178: putfield 42	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:z	I
    //   181: aload_0
    //   182: ldc 104
    //   184: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   187: ldc 106
    //   189: iconst_2
    //   190: anewarray 53	java/lang/Class
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: getfield 32	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: ldc 108
    //   204: aastore
    //   205: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   208: putfield 40	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   211: aload_0
    //   212: iconst_1
    //   213: putfield 44	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:D	Z
    //   216: goto -201 -> 15
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    //   224: astore_2
    //   225: aconst_null
    //   226: astore_1
    //   227: ldc 110
    //   229: aload_2
    //   230: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   233: invokestatic 119	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   236: goto -151 -> 85
    //   239: astore_1
    //   240: ldc 110
    //   242: aload_1
    //   243: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   246: invokestatic 119	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -103 -> 148
    //   254: ldc 121
    //   256: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   259: astore_1
    //   260: aload_1
    //   261: ifnonnull +48 -> 309
    //   264: iconst_1
    //   265: istore 5
    //   267: goto +45 -> 312
    //   270: astore_1
    //   271: ldc 110
    //   273: aload_1
    //   274: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   277: invokestatic 119	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   280: aload_3
    //   281: astore_1
    //   282: goto -22 -> 260
    //   285: astore_1
    //   286: ldc 110
    //   288: aload_1
    //   289: invokevirtual 114	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   292: invokestatic 119	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   295: goto -84 -> 211
    //   298: bipush 12
    //   300: istore 4
    //   302: goto -127 -> 175
    //   305: astore_2
    //   306: goto -79 -> 227
    //   309: iconst_0
    //   310: istore 5
    //   312: iload 5
    //   314: ifeq -16 -> 298
    //   317: iconst_1
    //   318: istore 4
    //   320: goto -145 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	UTSecuritySDKRequestAuthentication
    //   23	130	1	localObject1	Object
    //   219	4	1	localObject2	Object
    //   226	1	1	localObject3	Object
    //   239	4	1	localThrowable1	Throwable
    //   250	11	1	localClass	Class
    //   270	4	1	localThrowable2	Throwable
    //   281	1	1	localObject4	Object
    //   285	4	1	localThrowable3	Throwable
    //   224	6	2	localThrowable4	Throwable
    //   305	1	2	localThrowable5	Throwable
    //   1	280	3	localObject5	Object
    //   176	143	4	i	int
    //   8	305	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	219	finally
    //   18	24	219	finally
    //   24	85	219	finally
    //   89	137	219	finally
    //   137	148	219	finally
    //   152	172	219	finally
    //   175	211	219	finally
    //   211	216	219	finally
    //   227	236	219	finally
    //   240	249	219	finally
    //   254	260	219	finally
    //   271	280	219	finally
    //   286	295	219	finally
    //   18	24	224	java/lang/Throwable
    //   137	148	239	java/lang/Throwable
    //   254	260	270	java/lang/Throwable
    //   89	137	285	java/lang/Throwable
    //   152	172	285	java/lang/Throwable
    //   175	211	285	java/lang/Throwable
    //   240	249	285	java/lang/Throwable
    //   271	280	285	java/lang/Throwable
    //   24	85	305	java/lang/Throwable
  }
  
  public String getAppkey()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String getAuthCode()
  {
    return this.aa;
  }
  
  public String getSign(String paramString)
  {
    if (!this.D) {
      D();
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
    }
    while (paramString == null) {
      return null;
    }
    if ((this.jdField_b_of_type_JavaLangObject != null) && (this.jdField_a_of_type_JavaLangClass != null) && (this.jdField_a_of_type_JavaLangReflectField != null) && (this.jdField_b_of_type_JavaLangReflectField != null) && (this.jdField_c_of_type_JavaLangReflectField != null) && (this.jdField_a_of_type_JavaLangReflectMethod != null) && (this.jdField_c_of_type_JavaLangObject != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_JavaLangClass.newInstance();
        this.jdField_a_of_type_JavaLangReflectField.set(localObject, this.jdField_b_of_type_JavaLangString);
        ((Map)this.jdField_b_of_type_JavaLangReflectField.get(localObject)).put("INPUT", paramString);
        this.jdField_c_of_type_JavaLangReflectField.set(localObject, Integer.valueOf(this.z));
        paramString = (String)this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_c_of_type_JavaLangObject, new Object[] { localObject, this.aa });
        return paramString;
      }
      catch (InstantiationException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
        continue;
      }
      catch (InvocationTargetException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\sign\UTSecuritySDKRequestAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */