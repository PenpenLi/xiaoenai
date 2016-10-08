package com.alimama.mobile.sdk.hack;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AssertionArrayException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private List<Hack.HackDeclaration.HackAssertionException> mAssertionErr = new ArrayList();
  
  public AssertionArrayException(String paramString)
  {
    super(paramString);
  }
  
  public static AssertionArrayException mergeException(AssertionArrayException paramAssertionArrayException1, AssertionArrayException paramAssertionArrayException2)
  {
    if (paramAssertionArrayException1 == null) {
      return paramAssertionArrayException2;
    }
    if (paramAssertionArrayException2 == null) {
      return paramAssertionArrayException1;
    }
    AssertionArrayException localAssertionArrayException = new AssertionArrayException(paramAssertionArrayException1.getMessage() + ";" + paramAssertionArrayException2.getMessage());
    localAssertionArrayException.addException(paramAssertionArrayException1.getExceptions());
    localAssertionArrayException.addException(paramAssertionArrayException2.getExceptions());
    return localAssertionArrayException;
  }
  
  public void addException(Hack.HackDeclaration.HackAssertionException paramHackAssertionException)
  {
    this.mAssertionErr.add(paramHackAssertionException);
  }
  
  public void addException(List<Hack.HackDeclaration.HackAssertionException> paramList)
  {
    this.mAssertionErr.addAll(paramList);
  }
  
  public List<Hack.HackDeclaration.HackAssertionException> getExceptions()
  {
    return this.mAssertionErr;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mAssertionErr.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Hack.HackDeclaration.HackAssertionException localHackAssertionException = (Hack.HackDeclaration.HackAssertionException)localIterator.next();
        localStringBuilder.append(localHackAssertionException.toString()).append(";");
        try
        {
          Object localObject;
          int i;
          if ((localHackAssertionException.getCause() instanceof NoSuchFieldException))
          {
            localObject = localHackAssertionException.getHackedClass().getDeclaredFields();
            localStringBuilder.append(localHackAssertionException.getHackedClass().getName()).append(".").append(localHackAssertionException.getHackedFieldName()).append(";");
            i = 0;
            while (i < localObject.length)
            {
              localStringBuilder.append(localObject[i].getName()).append("/");
              i += 1;
            }
          }
          if ((localHackAssertionException.getCause() instanceof NoSuchMethodException))
          {
            localObject = localHackAssertionException.getHackedClass().getDeclaredMethods();
            localStringBuilder.append(localHackAssertionException.getHackedClass().getName()).append("->").append(localHackAssertionException.getHackedMethodName()).append(";");
            i = 0;
            while (i < localObject.length)
            {
              if (localHackAssertionException.getHackedMethodName().equals(localObject[i].getName())) {
                localStringBuilder.append(localObject[i].toGenericString()).append("/");
              }
              i += 1;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localStringBuilder.append("@@@@");
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\hack\AssertionArrayException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */