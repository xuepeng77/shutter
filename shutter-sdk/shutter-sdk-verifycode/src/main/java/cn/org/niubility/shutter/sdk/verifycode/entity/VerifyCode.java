package cn.org.niubility.shutter.sdk.verifycode.entity;

import lombok.*;

/**
 * 验证码的实体类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VerifyCode {

    /**
     * 唯一标识。
     */
    private String uuid;

    /**
     * 验证图片。
     */
    private String img;

    /**
     * 验证码。
     */
    private String code;

}
