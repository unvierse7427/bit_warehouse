package com.universe.warehouse.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author universe7427
 * @since 2024-12-06
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@ApiModel(value="BwDocumentMessage对象", description="")
public class BwDocumentMessage implements Serializable {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "id")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "文件名称")
      private String name;

      @ApiModelProperty(value = "文件地址")
      private String url;

      @ApiModelProperty(value = "创建时间")
      private LocalDateTime createTime;

      @ApiModelProperty(value = "更新时间")
      private LocalDateTime updateTime;

      @ApiModelProperty(value = "是否删除")
      private Integer isDelete;


}
