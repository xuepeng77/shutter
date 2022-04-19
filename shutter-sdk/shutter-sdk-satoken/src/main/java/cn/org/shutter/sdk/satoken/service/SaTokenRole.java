package cn.org.shutter.sdk.satoken.service;

import lombok.*;

/**
 * SaToken角色的实体类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SaTokenRole {

    /**
     * 主键。
     */
    private Long id;

    /**
     * 唯一标识。
     */
    private String code;

    /**
     * 名称。
     */
    private String name;

}
