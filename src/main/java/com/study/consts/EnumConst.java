package com.study.consts;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 14-1-26.
 * 系统编码
 *
 * @author zhaonc
 * @since 14-1-26
 */
public class EnumConst {
    /***
     * 服务端返回码
     * 5 系统级别
     * 4 通讯级别
     * 3 服务级(参数 代码 自定义)
     * 2 成功
     */
    private static String index;//官网域名
    private static String index_child;//毙考题域名
    @Bean
	@ConfigurationProperties(prefix = "sso.INDEX")
    public String getIndex(){
    	return index;
    }
    @Bean
  	@ConfigurationProperties(prefix = "sso.INDEX_CHILD")
    public String getIndexChild(){
    	return index_child;
    }

    public enum RetCode {
        /**
         * 系统级错误
         */
        SYSTEM_ERROR(50001, "系统异常"),

        /**
         * 通讯级错误
         */
        ILLEGAL_REQUEST(40001, "Illegal request非法请求 http"),
        ACCESS_TOKEN_ERROR(40002, "ACCESS_TOKEN失效或错误"),

        /**
         * 服务级(参数 代码 自定义)
         */
        PARAMETER_IS_NULL(30001, "参数为空"),
        PARAMETER_IS_INVALID(30002, "参数非法"),
        USERNAME_OR_PASSWORD_ERROR(30003, "用户名密码错误"),
        USER_NOTEXISTS(30004, "用户不存在"),
        AUTH_FAILD(30005, "认证失败"),
        SMSCODE_FAILD(30006, "短信验证码获取失败"),
        NOT_SIGNIN(30007, "没有登录"),
        NO_PERMISSION(30008, "没有权限"),
        OPERATION_FAILD(30009, "操作失败"),
        ACCOUNT_EXCEPTION(30010, "账户异常"),
        USER_ISEXISTS(30011, "用户存在"),
        ATTENTION_ERROR(30012, "关注失败"),
        WEIXIN_SENDCUSTOM_ERROR(30013, "微信回复消息失败"),
        PASSWORD_ERROR(30014, "密码错误"),
        PAY_ERROR(30015, "支付错误"),
        NOT_PAY(30016, "未支付"),

        //找回密码       
        PASSWORD_AGAIN_ERROR(30017, "两次密码不一致"),
        VALIDATE_CODE_ERROR(30018, "图片验证码错误"),

        PARAMETER_TOO_LONG(30019, "参数过长"),
        TOKEN_FAILD(30020, "令牌过期"),
        KEY_NOT_IN_SYS(30021, "不是APP的请求或者不是1.5.4版本以上"),

        INVITE_CODE_ERROR(30022, "邀请码错误"),
        WEIXIN_CODE_OR_TOKEN_ERROR(30023, "微信登录code或token错误错误"),

        /*是否有数据*/
        HAVEDATA(20001, "有数据"),
        NODATA(20002, "无数据"),
        SAMEDATA(20003, "重复数据"),

        /*数据已删除或失效*/
        INVALID_DATA(20004, "数据已删除或失效"),
        /*操作成功,失败*/
        SUCCESS(1, "成功"),
        ERROR(0, "失败");


        private Integer code;
        private String value;

        public Integer getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        private RetCode(Integer code, String value) {
            this.code = code;
            this.value = value;
        }
    }


}
