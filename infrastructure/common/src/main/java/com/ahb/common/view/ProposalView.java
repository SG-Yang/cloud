package com.ahb.common.view;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 13/4/2018.
 */
public class ProposalView extends ViewImpl {
   private List<View> views = Lists.newArrayList();
   private String hit;
   private String desc;
   private String displayCommand;

   public String getHit() {
      return hit;
   }

   public void setHit(String hit) {
      this.hit = hit;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public String getDisplayCommand() {
      return displayCommand;
   }

   public void setDisplayCommand(String displayCommand) {
      this.displayCommand = displayCommand;
   }
}
