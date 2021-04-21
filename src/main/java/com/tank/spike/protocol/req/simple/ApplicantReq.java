package com.tank.spike.protocol.req.simple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tank198435163.com
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantReq implements Serializable {

  private String name;

  private String capacity;
}
