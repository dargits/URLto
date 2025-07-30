package app.urlto.webcontants;

public class Webcontants {
    // shortcode
    public static final String URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static final int SHORTCODE_LENGTH = 6;

    // web info
    public static final String WEB_NAME = "URLto";
    public static final String AUTHOR = "ShyDev";
    public static final String GIT_HUB = "https://github.com/dargits";

    public static final String BACK_END_DOMAIN = "http://localhost:8080";

    // api path
    public static final String API_V1_PATH = "/api/v1";

    public static final String WEB_PATH = "/web";

    public static final String WEB_ROUTER = "/";

    // api path auth
    public static final String AUTH_V1_PATH = API_V1_PATH + "/auth";

    // link controller path

    public static final String LINK_API_V1_PATH = API_V1_PATH + "/link";

    // controller path
    public static final String GET_WEB_INFOR = "/infor";

    public static final String GET_BACKEND_DOMAIN = "/domain";

    public static final String ROUTER_PAYOUT_RATE = "payout-rates";

    // api message
    public static final String SUCCESS = "Success.";
    public static final String FAIL = "Fail.";

    // error message
    public static final String ERROR = "Error.";

    public static final String ACCOUNT_NOT_FOUND = "Tài khoản không tồn tại: ";

    public static final String ACCOUNT_ALREADY_EXISTS = "Tài khoản này đã tồn tại.";

    public static final String INVALID_PASSWORD = "Mật khẩu không chính xác.";

    public static final String CONFIRM_PASSWORD_NOT_MATCH = "Mật khẩu xác nhận không khớp.";

    public static final String ERROR_MESSAGE_SHORTCODE_EXISTS = "Mã link tùy chỉnh này đã được xử dụng: ";

    public static final String ERROR_MESSAGE_SHORTCODE_LENGTH = "Mã link tùy chỉnh phải có ít nhất " + SHORTCODE_LENGTH
            + " kí tự";

    public static final String ERROR_MESSAGE_SHORTCODE_NOT_VALID = "Mã tùy chỉnh chỉ chấp nhận chữ cái và số.";

    public static final String ERROR_MESSAGE_ORIGINALLINK_START_WITH_BACKEND_URL = "Không được rút gọn link nội bộ hệ thống.";

    // role
    public static final String ROLE_USER = "USER";

    public static final String ROLE_ADMIN = "ADMIN";

    // error code
    public static final int ERROR_CODE_CONFIRM_PASSWORD_NOT_MATCH = 1000;

    public static final int ERROR_CODE_USER_NOT_FOUND = 1001;

    public static final int ERROR_CODE_INVALID_PASSWORD = 1002;

    public static final int ERROR_CODE_ACCOUNT_EXISTS = 1003;

    public static final int ERROR_CODE_VALID_INPUT = 1004;

    public static final int ERROR_CODE_SHORTCODE_EXISTS = 1005;

    public static final int ERROR_CODE_SHORTCODE_LENGTH = 1006;

    public static final int ERROR_CODE_SHORTCODE_NOT_VALID = 1007;

    public static final int ERROR_CODE_ORIGINALLINK_START_WITH_BACKEND_URL = 1008;
}
