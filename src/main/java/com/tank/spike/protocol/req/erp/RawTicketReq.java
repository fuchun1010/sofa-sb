package com.tank.spike.protocol.req.erp;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class RawTicketReq {


  /**
   * mqId : null
   * sign : f39664062c1e65a7039b8c206392afd6
   * time : 1616032141151
   * mqInfo : null
   * id : u_sales
   * enterpriseCode : bgy
   * customerCode : 0087
   * posMachineCode : 00878
   * elements : [{"columns":{"couponamt":43,"transtime":22,"usercode":18,"memberid":49,"itemweight":7,"produceno":45,"saleamt":16,"memdiscountamt":42,"transno":3,"itemcode":5,"discountamt":17,"userdesc":19,"enterprisecode":0,"age":35,"merchantdiscount":47,"entrydate":37,"gender":36,"weather":34,"prmlevelcode":32,"quantity":14,"monitor":23,"barcode":40,"lastcustomercode":25,"o2oorderid":39,"memprice":50,"saleunitname":9,"discount":15,"functioncode":20,"transitemno":4,"eorderno":38,"plusscore":33,"itemtypecode":26,"platformdiscount":48,"cardcode":27,"transdate":21,"customercode":1,"saleunitcode":8,"packageweight":53,"employeecode":29,"prmschemecode":31,"taxrate":10,"itemname":6,"itemcouponamt":44,"notaxprice":12,"employeename":30,"retailprice":41,"outprice":13,"machinecode":2,"saletype":51,"lotno":46,"goodsweight":52,"intaxprice":11,"storecostcode":28,"consumenum":24},"primaryKeys":[],"rows":[["bgy","0087","00878","21031800878094436809",1,"108752","B级-沙漠蜜瓜","1","kg","公斤","0","1","0","11.90","0.988","0","11.76","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","11031","","",null,"","","","0","","0","","2021/03/18","","",null,"11.9","0","0","0","","",0,"0","","11.5","0","1.000","0.012"],["bgy","0087","00878","21031800878094436809",2,"500223","小号无盖透明盒","12","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","108752","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",3,"100132","A级-阿克苏蜜心富士（中）","1","kg","公斤","0","0","0","16.99","0.988","0","16.79","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","10132","","",null,"","","","0","","0","","2021/03/18","","",null,"16.99","0","0","0","","",0,"0","","16.99","0","1.000","0.012"],["bgy","0087","00878","21031800878094436809",4,"500223","小号无盖透明盒","12","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","100132","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",5,"101301","A级-进口青啤梨","1","kg","公斤","0","0","0","28.00","0.990","0","27.72","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","10202","","",null,"","","","0","","0","","2021/03/18","","",null,"28","0","0","0","","",0,"0","","27.4","0","1.000","0.010"],["bgy","0087","00878","21031800878094436809",6,"546299","塑料托盘24*11","10","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","101301","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",7,"","合计","0","","","0","0","0","0","2.966","0","56.27","0","0340","中国石油张本荷加油站","51","2021/03/18","09:45:16","","0","","","","","","","","","0","20210312","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",8,"","人民币支付","0","","","0","0","0","0","0","0","56.27","0","0340","中国石油张本荷加油站","21","2021/03/18","09:45:16","","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",9,"","找零","0","","","0","0","0","0","0","0","0.00","0","0340","中国石油张本荷加油站","30","2021/03/18","09:45:16","","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"]],"name":"mag_customer_bill_sale_t_jms","rowCount":9,"columnCount":54}]
   * attributes : {}
   */

  private Object mqId;
  private String sign;
  private long time;
  private Object mqInfo;
  private String id;
  private String enterpriseCode;
  private String customerCode;
  private String posMachineCode;
  private AttributesBean attributes;
  private List<ElementsBean> elements = Lists.newArrayList();


  /**
   * @author tank198435163.com
   */
  public static class AttributesBean {
  }

  @Getter
  @Setter
  public static class ElementsBean {
    /**
     * columns : {"couponamt":43,"transtime":22,"usercode":18,"memberid":49,"itemweight":7,"produceno":45,"saleamt":16,"memdiscountamt":42,"transno":3,"itemcode":5,"discountamt":17,"userdesc":19,"enterprisecode":0,"age":35,"merchantdiscount":47,"entrydate":37,"gender":36,"weather":34,"prmlevelcode":32,"quantity":14,"monitor":23,"barcode":40,"lastcustomercode":25,"o2oorderid":39,"memprice":50,"saleunitname":9,"discount":15,"functioncode":20,"transitemno":4,"eorderno":38,"plusscore":33,"itemtypecode":26,"platformdiscount":48,"cardcode":27,"transdate":21,"customercode":1,"saleunitcode":8,"packageweight":53,"employeecode":29,"prmschemecode":31,"taxrate":10,"itemname":6,"itemcouponamt":44,"notaxprice":12,"employeename":30,"retailprice":41,"outprice":13,"machinecode":2,"saletype":51,"lotno":46,"goodsweight":52,"intaxprice":11,"storecostcode":28,"consumenum":24}
     * primaryKeys : []
     * rows : [["bgy","0087","00878","21031800878094436809",1,"108752","B级-沙漠蜜瓜","1","kg","公斤","0","1","0","11.90","0.988","0","11.76","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","11031","","",null,"","","","0","","0","","2021/03/18","","",null,"11.9","0","0","0","","",0,"0","","11.5","0","1.000","0.012"],["bgy","0087","00878","21031800878094436809",2,"500223","小号无盖透明盒","12","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","108752","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",3,"100132","A级-阿克苏蜜心富士（中）","1","kg","公斤","0","0","0","16.99","0.988","0","16.79","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","10132","","",null,"","","","0","","0","","2021/03/18","","",null,"16.99","0","0","0","","",0,"0","","16.99","0","1.000","0.012"],["bgy","0087","00878","21031800878094436809",4,"500223","小号无盖透明盒","12","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","100132","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",5,"101301","A级-进口青啤梨","1","kg","公斤","0","0","0","28.00","0.990","0","27.72","0","0340","中国石油张本荷加油站","1","2021/03/18","09:45:16","","0","","10202","","",null,"","","","0","","0","","2021/03/18","","",null,"28","0","0","0","","",0,"0","","27.4","0","1.000","0.010"],["bgy","0087","00878","21031800878094436809",6,"546299","塑料托盘24*11","10","g","克","0","0","0","0","1","0","0","0","0340","中国石油张本荷加油站","2","2021/03/18","09:45:16","101301","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",7,"","合计","0","","","0","0","0","0","2.966","0","56.27","0","0340","中国石油张本荷加油站","51","2021/03/18","09:45:16","","0","","","","","","","","","0","20210312","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",8,"","人民币支付","0","","","0","0","0","0","0","0","56.27","0","0340","中国石油张本荷加油站","21","2021/03/18","09:45:16","","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"],["bgy","0087","00878","21031800878094436809",9,"","找零","0","","","0","0","0","0","0","0","0.00","0","0340","中国石油张本荷加油站","30","2021/03/18","09:45:16","","0","","","","","","","","","0","","0","","2021/03/18","","",null,null,null,null,null,"","","0","0","","0","0","0","0"]]
     * name : mag_customer_bill_sale_t_jms
     * rowCount : 9
     * columnCount : 54
     */

    private ColumnsBean columns;
    private String name;
    private int rowCount;
    private int columnCount;
    private List<?> primaryKeys;
    private List<List<String>> rows;


    /**
     * @author tank198435163.com
     */
    @Getter
    @Setter
    public static class ColumnsBean {
      /**
       * couponamt : 43
       * transtime : 22
       * usercode : 18
       * memberid : 49
       * itemweight : 7
       * produceno : 45
       * saleamt : 16
       * memdiscountamt : 42
       * transno : 3
       * itemcode : 5
       * discountamt : 17
       * userdesc : 19
       * enterprisecode : 0
       * age : 35
       * merchantdiscount : 47
       * entrydate : 37
       * gender : 36
       * weather : 34
       * prmlevelcode : 32
       * quantity : 14
       * monitor : 23
       * barcode : 40
       * lastcustomercode : 25
       * o2oorderid : 39
       * memprice : 50
       * saleunitname : 9
       * discount : 15
       * functioncode : 20
       * transitemno : 4
       * eorderno : 38
       * plusscore : 33
       * itemtypecode : 26
       * platformdiscount : 48
       * cardcode : 27
       * transdate : 21
       * customercode : 1
       * saleunitcode : 8
       * packageweight : 53
       * employeecode : 29
       * prmschemecode : 31
       * taxrate : 10
       * itemname : 6
       * itemcouponamt : 44
       * notaxprice : 12
       * employeename : 30
       * retailprice : 41
       * outprice : 13
       * machinecode : 2
       * saletype : 51
       * lotno : 46
       * goodsweight : 52
       * intaxprice : 11
       * storecostcode : 28
       * consumenum : 24
       */

      private int couponamt;
      private int transtime;
      private int usercode;
      private int memberid;
      private int itemweight;
      private int produceno;
      private int saleamt;
      private int memdiscountamt;
      private int transno;
      private int itemcode;
      private int discountamt;
      private int userdesc;
      private int enterprisecode;
      private int age;
      private int merchantdiscount;
      private int entrydate;
      private int gender;
      private int weather;
      private int prmlevelcode;
      private int quantity;
      private int monitor;
      private int barcode;
      private int lastcustomercode;
      private int o2oorderid;
      private int memprice;
      private int saleunitname;
      private int discount;
      private int functioncode;
      private int transitemno;
      private int eorderno;
      private int plusscore;
      private int itemtypecode;
      private int platformdiscount;
      private int cardcode;
      private int transdate;
      private int customercode;
      private int saleunitcode;
      private int packageweight;
      private int employeecode;
      private int prmschemecode;
      private int taxrate;
      private int itemname;
      private int itemcouponamt;
      private int notaxprice;
      private int employeename;
      private int retailprice;
      private int outprice;
      private int machinecode;
      private int saletype;
      private int lotno;
      private int goodsweight;
      private int intaxprice;
      private int storecostcode;
      private int consumenum;

    }
  }
}
