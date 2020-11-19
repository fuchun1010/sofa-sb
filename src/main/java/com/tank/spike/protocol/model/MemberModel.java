package com.tank.spike.protocol.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class MemberModel {

  private String customerId;

  private Integer level;

  private String createDateTime;

  private ChannelModel channel;

  private OrgModel org;
}
