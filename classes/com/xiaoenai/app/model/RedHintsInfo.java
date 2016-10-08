package com.xiaoenai.app.model;

import java.util.ArrayList;
import java.util.List;

public class RedHintsInfo
{
  private int childNumSum = 0;
  private int childShowCount = 0;
  private List<RedHintsInfo> children = new ArrayList();
  private int id = 0;
  private boolean isShow = true;
  private String module = "";
  private RedHintsInfo parentNode;
  private int style = 1;
  private String value = "";
  
  public RedHintsInfo() {}
  
  public RedHintsInfo(String paramString)
  {
    this.module = paramString;
  }
  
  public void addChildNodeCount(RedHintsInfo paramRedHintsInfo)
  {
    if ((1 == paramRedHintsInfo.getStyle()) && (paramRedHintsInfo.getValue() != null) && (paramRedHintsInfo.getValue().length() > 0)) {
      this.childNumSum += Integer.valueOf(paramRedHintsInfo.getValue()).intValue();
    }
    if (paramRedHintsInfo.isShow()) {
      this.childShowCount += 1;
    }
    if (getParentNode() != null) {
      getParentNode().addChildNodeCount(paramRedHintsInfo);
    }
  }
  
  public int getChildNumSum()
  {
    return this.childNumSum;
  }
  
  public int getChildShowCount()
  {
    return this.childShowCount;
  }
  
  public List<RedHintsInfo> getChildren()
  {
    return this.children;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getModule()
  {
    return this.module;
  }
  
  public RedHintsInfo getParentNode()
  {
    return this.parentNode;
  }
  
  public int getStyle()
  {
    if ((this.children.size() > 0) && (1 == this.style))
    {
      if (this.childNumSum > 0) {
        return 1;
      }
      return 0;
    }
    return this.style;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public boolean isShow()
  {
    if (this.children.size() > 0) {
      if (getChildShowCount() <= 0) {
        break label29;
      }
    }
    label29:
    for (this.isShow = true;; this.isShow = false) {
      return this.isShow;
    }
  }
  
  public void minusChildNodeCount(RedHintsInfo paramRedHintsInfo)
  {
    if (getChildren().size() > 0)
    {
      if ((1 == paramRedHintsInfo.getStyle()) && (paramRedHintsInfo.getValue() != null) && (paramRedHintsInfo.getValue().length() > 0))
      {
        int i = Integer.valueOf(paramRedHintsInfo.getValue()).intValue();
        this.childNumSum -= i;
        if (this.childNumSum < 0) {
          this.childNumSum = 0;
        }
      }
      this.childShowCount -= 1;
    }
    for (;;)
    {
      if (getParentNode() != null) {
        getParentNode().minusChildNodeCount(paramRedHintsInfo);
      }
      return;
      setIsShow(false);
    }
  }
  
  public void setChildNumSum(int paramInt)
  {
    this.childNumSum -= paramInt;
  }
  
  public void setChildShowCount(int paramInt)
  {
    this.childShowCount = paramInt;
  }
  
  public void setChildren(List<RedHintsInfo> paramList)
  {
    this.children = paramList;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public void setModule(String paramString)
  {
    this.module = paramString;
  }
  
  public void setParentNode(RedHintsInfo paramRedHintsInfo)
  {
    this.parentNode = paramRedHintsInfo;
  }
  
  public void setStyle(int paramInt)
  {
    this.style = paramInt;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\RedHintsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */