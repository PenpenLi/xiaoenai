package d.a;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class bb
{
  private static final Comparator a = new a(null);
  
  public static int a(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 < paramByte2) {
      return -1;
    }
    if (paramByte2 < paramByte1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt2 < paramInt1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static int a(List paramList1, List paramList2)
  {
    int k = 0;
    int j = a(paramList1.size(), paramList2.size());
    if (j != 0) {
      return j;
    }
    int i = 0;
    for (;;)
    {
      j = k;
      if (i >= paramList1.size()) {
        break;
      }
      j = a.compare(paramList1.get(i), paramList2.get(i));
      if (j != 0) {
        return j;
      }
      i += 1;
    }
  }
  
  public static int a(Map paramMap1, Map paramMap2)
  {
    int i = a(paramMap1.size(), paramMap2.size());
    if (i != 0) {
      return i;
    }
    Object localObject = new TreeMap(a);
    ((SortedMap)localObject).putAll(paramMap1);
    paramMap1 = ((SortedMap)localObject).entrySet().iterator();
    localObject = new TreeMap(a);
    ((SortedMap)localObject).putAll(paramMap2);
    paramMap2 = ((SortedMap)localObject).entrySet().iterator();
    while ((paramMap1.hasNext()) && (paramMap2.hasNext()))
    {
      localObject = (Map.Entry)paramMap1.next();
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      i = a.compare(((Map.Entry)localObject).getKey(), localEntry.getKey());
      if (i != 0) {
        return i;
      }
      i = a.compare(((Map.Entry)localObject).getValue(), localEntry.getValue());
      if (i != 0) {
        return i;
      }
    }
    return 0;
  }
  
  public static int a(Set paramSet1, Set paramSet2)
  {
    int i = a(paramSet1.size(), paramSet2.size());
    if (i != 0) {
      return i;
    }
    TreeSet localTreeSet = new TreeSet(a);
    localTreeSet.addAll(paramSet1);
    paramSet1 = new TreeSet(a);
    paramSet1.addAll(paramSet2);
    paramSet2 = localTreeSet.iterator();
    paramSet1 = paramSet1.iterator();
    while ((paramSet2.hasNext()) && (paramSet1.hasNext()))
    {
      i = a.compare(paramSet2.next(), paramSet1.next());
      if (i != 0) {
        return i;
      }
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    int j = a(paramArrayOfByte1.length, paramArrayOfByte2.length);
    if (j != 0) {
      return j;
    }
    int i = 0;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfByte1.length) {
        break;
      }
      j = a(paramArrayOfByte1[i], paramArrayOfByte2[i]);
      if (j != 0) {
        return j;
      }
      i += 1;
    }
  }
  
  public static String a(byte paramByte)
  {
    return Integer.toHexString((paramByte | 0x100) & 0x1FF).toUpperCase().substring(1);
  }
  
  public static void a(ByteBuffer paramByteBuffer, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset();
    int k = i + paramByteBuffer.position();
    int m = paramByteBuffer.limit() + i;
    if (m - k > 128) {}
    for (i = k + 128;; i = m)
    {
      int j = k;
      while (j < i)
      {
        if (j > k) {
          paramStringBuilder.append(" ");
        }
        paramStringBuilder.append(a(arrayOfByte[j]));
        j += 1;
      }
    }
    if (m != i) {
      paramStringBuilder.append("...");
    }
  }
  
  private static class a
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      if ((paramObject1 == null) && (paramObject2 == null)) {
        return 0;
      }
      if (paramObject1 == null) {
        return -1;
      }
      if (paramObject2 == null) {
        return 1;
      }
      if ((paramObject1 instanceof List)) {
        return bb.a((List)paramObject1, (List)paramObject2);
      }
      if ((paramObject1 instanceof Set)) {
        return bb.a((Set)paramObject1, (Set)paramObject2);
      }
      if ((paramObject1 instanceof Map)) {
        return bb.a((Map)paramObject1, (Map)paramObject2);
      }
      if ((paramObject1 instanceof byte[])) {
        return bb.a((byte[])paramObject1, (byte[])paramObject2);
      }
      return bb.a((Comparable)paramObject1, (Comparable)paramObject2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */