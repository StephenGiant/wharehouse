package wochu.com.rfpdaapp.utils;

import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import cn.pda.serialport.SerialPort;

/**
 * 扫描工具
 * Created by qianpeng on 2016/7/20.
 */
public class ScanUtil {

    private SerialPort mSerialPort;

    public ScanUtil(){
        try {
            mSerialPort = new SerialPort(0, 9600, 0);
            mSerialPort.scaner_poweron();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isScanning;

    //扫描并通过回调拿到条码
    public void scan(){
Observable.create(new Observable.OnSubscribe<String>() {
    @Override
    public void call(Subscriber<? super String> subscriber) {
        if(!subscriber.isUnsubscribed()&&!TextUtils.isEmpty(doScan())){
            subscriber.onNext(doScan());
        }
        subscriber.onCompleted();
    }
})
        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        if(mOnScanListenner!=null){
                            if(!TextUtils.isEmpty(s)) {
                                mOnScanListenner.onScan(s);
                            }
                        }
                    }
                });


    }
    private onScanListenner mOnScanListenner;
    public void setmOnScanListenner(onScanListenner listenner){
        mOnScanListenner = listenner;
    }
    public interface onScanListenner{
        public void onScan(String code);
    }

    //扫描操作,必须在子线程中
    private String doScan(){
        final InputStream inputStream = mSerialPort.getInputStream();
        OutputStream outputStream = mSerialPort.getOutputStream();
        if(mSerialPort.scaner_trig_stat() == true){
            mSerialPort.scaner_trigoff();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        mSerialPort.scaner_trigon();

        int size = 0;
        byte[] buffer = new byte[2048];
        int available = 0;
        isScanning = true;
        mSerialPort.scaner_trigon();
        String code=null;
        while (isScanning){

            try {

                if(inputStream.available()>0){
                    size = inputStream.read(buffer);
                    if(size>0){
                        code = new String(buffer,0,size);
                        isScanning = false;
                        return code;

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "";
    }
  
}
