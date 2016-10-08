package com.ta.utdid2.device;

import com.ta.utdid2.b.a.a;
import com.ta.utdid2.b.a.b;
import com.ta.utdid2.b.a.i;

public class e
{
  private String p = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
  
  public String b(String paramString)
  {
    return a.e(this.p, paramString);
  }
  
  public String c(String paramString)
  {
    paramString = a.e(this.p, paramString);
    if (!i.a(paramString)) {
      try
      {
        paramString = new String(b.decode(paramString, 0));
        return paramString;
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\device\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */