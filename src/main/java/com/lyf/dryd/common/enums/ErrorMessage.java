package com.lyf.dryd.common.enums;

import com.lyf.dryd.common.i18n.I18nUtils;

/**
 * 错误信息提示
 */
public enum ErrorMessage {

    SYSTEM_ERROR("SYSTEM_ERROR", MsgType.SIMPLE, "系统异常,请重试"),

    PARAM_FAIL("PARAM_FAIL", MsgType.FORMAT, "参数{0}不正确"),

    PARAM_NOT_EMPTY("PARAM_NOT_EMPTY", MsgType.FORMAT, "参数[{0}]不能为空"),

    USER_CAN_NOT_EMPTY("USER_CAN_NOT_EMPTY", MsgType.SIMPLE, "用户不能为空"),

    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", MsgType.FORMAT, "用户{0}已存在"),

    USER_NOT_EXISTS("USER_NOT_EXISTS", MsgType.SIMPLE, "用户不存在"),

    PWD_ERROR("PWD_ERROR", MsgType.SIMPLE, "密码错误"),

    MEMBER_FULL("MEMBER_FULL", MsgType.FORMAT, "课程{0}已满员")

    ;
    private enum MsgType{
        SIMPLE,FORMAT
    }
    private String code;

    private String msg;

    private MsgType type;

    ErrorMessage(String code, MsgType type, String msg) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getMsg(String...params) {
        //国际化
        String value = I18nUtils.getOrDefault("error.msg." + code, msg);
        if(this.type == MsgType.SIMPLE){
            return value;
        } else {
            return I18nUtils.formatMsg(value, params);
        }
    }
}
