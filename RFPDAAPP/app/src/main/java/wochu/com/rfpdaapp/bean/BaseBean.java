package wochu.com.rfpdaapp.bean;

/**
 * Created by hasee on 2016/7/19.
 */
public class BaseBean <T>{

    /**
     * RESULT : 1
     * MESSAGE : 请求成功
     * DATA : true
     */

    private String RESULT;
    private String MESSAGE;
    private T DATA;

    public T getDATA() {
        return DATA;
    }

    public void setDATA(T DATA) {
        this.DATA = DATA;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }


}
