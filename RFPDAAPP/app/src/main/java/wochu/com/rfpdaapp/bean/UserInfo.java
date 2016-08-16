package wochu.com.rfpdaapp.bean;

public class UserInfo {
    public String MESSAGE;//返回来的信息
    public String RESULT;//返回结果
    public int EntityState;
    public Boolean Selected;
    public User DATA;

    public class User {
        public String USERNAME;
        public String USERCODE;
        public String PASSWORD;
        public int USERID;//工人的ID
    }
}
