package com.ahb.common.view;

import com.ahb.common.domain.Domain;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by aheroboy on 13/4/2018.
 */
public class ProposalView implements View{
   private List<View> views = Lists.newArrayList();
   private String hit;
   private String desc;
   private String displayCommand;

   @Override
   public void setStyle(Style style) {

   }

   @Override
   public Style getStyle() {
      return null;
   }

   @Override
   public void setViewId(ViewId id) {

   }

   @Override
   public JsonObject toViewObj() {
      return null;
   }

   @Override
   public ViewId getViewId() {
      return null;
   }

   @Override
   public View copy() {
      return null;
   }

   @Override
   public View decorate(Domain domain) {
      return null;
   }

   @Override
   public ProposalView getProposal() {
      return null;
   }

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
