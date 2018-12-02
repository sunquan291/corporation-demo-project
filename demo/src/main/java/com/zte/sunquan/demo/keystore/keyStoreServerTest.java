package com.zte.sunquan.demo.keystore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.KeyStore;

/**
 * Created by 10184538 on 2016/11/25.
 */
public class keyStoreServerTest {
    public static void main(String[] args) throws Exception {
//        String key = "c:/.keystore";
        String key="C:\\Users\\Administrator\\.keystore";
//        String key="C:\\Users\\Administrator\\client";
        KeyStore keystore = KeyStore.getInstance("JKS");//keystore的类型，默认是jks
        //创建jkd密钥访问库123456是keystore密码
        keystore.load(new FileInputStream(key), "123456".toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        //asdfgh是key密码
        //创建管理jks密钥库的x509密钥管理器，用来管理密钥，需要key的密码
        kmf.init(keystore, "123456".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(keystore);

        // 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。
        SSLContext sslc = SSLContext.getInstance("SSLv3");
        //第二个参数TrustManager[] 是认证管理器，在需要双向认证时使用，
        sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        //构造ssl环境
        SSLServerSocketFactory sslfactory = sslc.getServerSocketFactory();
        SSLServerSocket serversocket = (SSLServerSocket) sslfactory.createServerSocket(9999);
        //创建serversocket，监听，并传输数据来验证授权
        for (int i = 0; i < 15; i++) {
            final Socket socket = serversocket.accept();
            new Thread() {
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();

                        byte[] buf = new byte[1024];
                        int len = is.read(buf);
                        System.out.println("From client"+new String(buf));
                        os.write("ssl test".getBytes());
                        os.close();
                        is.close();
                    } catch (Exception e) {// }
                    }
                }
            }.start();
        }
        serversocket.close();
    }

}