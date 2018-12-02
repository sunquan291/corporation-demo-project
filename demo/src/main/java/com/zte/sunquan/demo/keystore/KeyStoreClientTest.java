package com.zte.sunquan.demo.keystore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * Created by 10184538 on 2016/11/25.
 */
public class KeyStoreClientTest {
    public static final String key = "C:\\Users\\Administrator\\client";//使用不同keystore未进行证明导入
    public static final String password = "123456";
    private static KeyStore keyStore;
    private static TrustManagerFactory tmf;
    private static KeyManagerFactory kmf;
    /**
     * 创建jkd密钥访问库
     *
     * @throws KeyStoreException
     */
    public static void loadKeyStore() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        keyStore = KeyStore.getInstance("JKS");  //创建一个keystore来管理密钥库
        keyStore.load(new FileInputStream(key), password.toCharArray());
    }

    /**
     * 创建TrustManagerFactory,管理授权证书
     */
    public static void createTrustManagerFactor() throws NoSuchAlgorithmException, KeyStoreException {
        tmf = TrustManagerFactory.getInstance("SunX509");
        //验证数据，可以不传入key密码
        tmf.init(keyStore);
    }
    /**
     * 创建授权的密钥管理器,用来授权验证
     */
    public static void createKeytManagerFactor() throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
         kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keyStore, password.toCharArray());
    }

    public static void main(String[] args) throws Exception {

        loadKeyStore();
        createKeytManagerFactor();
        createTrustManagerFactor();
        // 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。
        SSLContext sslc = SSLContext.getInstance("SSLv3");
        //KeyManager[] 第一个参数是授权的密钥管理器，用来授权验证。第二个是被授权的证书管理器，
        //用来验证服务器端的证书。只验证服务器数据，第一个管理器可以为null
        sslc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        //构造ssl环境

        SSLSocketFactory sslfactory = sslc.getSocketFactory();
        SSLSocket socket = (SSLSocket) sslfactory.createSocket("127.0.0.1", 9999);
        //创建serversocket通过传输数据来验证授权

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write("client".getBytes());
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        System.out.println("From server:" + new String(buf));
        os.close();
        is.close();
    }
}
