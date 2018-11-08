package com.tongsr.kotlindemo.ui;

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class LoginSession {

    static LoginSession sLoginSession = null;
    private UserBean loginedUser;

    private LoginSession() {

    }

    public static LoginSession getLoginSession() {
        synchronized (LoginSession.class) {
            if (sLoginSession == null) {
                sLoginSession = new LoginSession();
            }
            return sLoginSession;
        }
    }

    public UserBean getLoginedUser() {
        return loginedUser;
    }

    void setLoginedUser(UserBean loginedUser) {
        this.loginedUser = loginedUser;
    }
}
