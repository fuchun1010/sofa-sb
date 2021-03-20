package com.tank.spike.protocol.req.erp;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import io.vavr.control.Try;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import strman.Strman;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class ColumnMetaData {

  public ColumnMetaData(@NonNull final RawTicketReq.ElementsBean.ColumnsBean columnsBean) {
    this.columnsBean = columnsBean;
    this.fieldsMeta = this.init(this.columnsBean);
  }

  public String index(@NonNull final int index) {
    return Try.of(() -> index).map(this.fieldsMeta::get).getOrElse(DEFAULT_ERROR_INDEX);
  }

  @SneakyThrows
  private Map<Integer, String> init(RawTicketReq.ElementsBean.ColumnsBean columnsBean) {
    val fields = columnsBean.getClass().getDeclaredFields();
    val meta = Maps.<Integer, String>newTreeMap();

    for (Field field : fields) {
      val methodName = StrUtil.format("get{}", Strman.capitalize(field.getName()));
      val method = columnsBean.getClass().getMethod(methodName);
      val result = method.invoke(columnsBean);
      if (Objects.nonNull(result)) {
        meta.putIfAbsent((Integer) result, field.getName());
      }
    }
    return meta;
  }


  private final RawTicketReq.ElementsBean.ColumnsBean columnsBean;

  private Map<Integer, String> fieldsMeta = null;

  private static final String DEFAULT_ERROR_INDEX = "-";

}
