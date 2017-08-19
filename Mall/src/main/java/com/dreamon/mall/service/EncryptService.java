package com.dreamon.mall.service;

import com.dreamon.mall.base.Status;
import com.dreamon.mall.exception.EncryptException;
import com.dreamon.mall.service.utils.DESUtils;
import com.dreamon.mall.service.utils.MD5Utils;
import com.dreamon.mall.service.utils.RSAUtils;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * 加密解密服务
 * Created by qiumengsong on 2017/8/17.
 */
@Component
public class EncryptService implements Status{

    private final String loginKey;

    private final String requestKey;

    private final int numberLength;

    //生成秘钥相关常量
    public static final String PUBLIC_KEY_INDEX = "PUBLIC";
    public static final String PRIVATE_KEY_INDEX = "PRIVATE";
    public static final String MODULUS_INDEX = "MODULUS";
    //解密相关常量
    public static final String USER_NUMBER_INDEX = "USER_NUMBER";
    public static final String REQUEST_TOKEN_INDEX = "REQUEST_TOKEN";
    public static final String REQUEST_TIMESTAMP_INDEX = "REQUEST_TIMESTAMP";


    public EncryptService(String loginKey, String requestKey,int numberLength) {
        this.loginKey = loginKey;
        this.requestKey = requestKey;
        this.numberLength = numberLength;
    }

    /**
     * 登陆解密
     * @return md5加密形式的用户密码
     */
    public String loginDecrypt(String source) throws EncryptException{
        try {
            String result = DESUtils.decrypt(source,loginKey);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new EncryptException(SAFE_DES_EXCP,SAFE_DES_EXCP_STR);
        }
    }

    /**
     * 登陆时获取公钥、私钥、modulus
     * @return
     */
    public HashMap<String,String> getLoginKeys() throws EncryptException{

        HashMap<String, Object> map = null;
        try {
            map = RSAUtils.getKeys();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            throw new EncryptException(SAFE_NO_SUCH_ALGORITHM,SAFE_NO_SUCH_ALGORITHM_STR);
        }

        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get(RSAUtils.PUBLIC);
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get(RSAUtils.PRIVATE);

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();

        HashMap<String,String> result = new HashMap<String, String>();
        result.put(PUBLIC_KEY_INDEX,public_exponent);
        result.put(PRIVATE_KEY_INDEX,private_exponent);
        result.put(MODULUS_INDEX,modulus);

        return result;
    }

    /**
     * 请求的token解密函数
     * @param token 请求的token
     * @param modulus
     * @param privateExponent
     * @param requestTokenLength requestToken的长度
     * @return
     * @throws EncryptException
     */
    public HashMap<String,String> requestDecrypt(String token,String modulus,String privateExponent,int requestTokenLength) throws EncryptException{
        RSAPrivateKey privateKey = RSAUtils.getPrivateKey(modulus,privateExponent);
        try {
            String mingwen = RSAUtils.decryptByPrivateKey(token,privateKey);
            HashMap<String,String> result = new HashMap<String, String>();
            result.put(USER_NUMBER_INDEX,mingwen.substring(0,numberLength));
            result.put(REQUEST_TOKEN_INDEX,mingwen.substring(numberLength,requestTokenLength+numberLength));
            result.put(REQUEST_TIMESTAMP_INDEX,mingwen.substring(numberLength + requestTokenLength));
            return result;
        } catch (Exception e){
            e.printStackTrace();
            throw new EncryptException(SAFE_RSA_DECRYPT_FAIL,SAFE_RSA_DECRYPT_FAIL_STR);
        }
    }

    /**
     * 登陆加密 测试使用
     * @param password
     */
    @Deprecated
    public void loginEncrypt(String password) throws Exception{
        String md5Str = MD5Utils.md5(password);
        String desStr = DESUtils.encrypt(md5Str,loginKey);
        System.out.println("测试结果:");
        System.out.println("MD5加密后:"+md5Str);
        System.out.println("DES加密后:"+desStr);
    }

    /**
     * 请求加密 测试使用
     * @param number 用户编号
     * @param innerToken
     */
    @Deprecated
    public void requestEncrypt(String number,String innerToken) throws Exception{
        String modulus = "109508492818073068673713283879879637452459089067378487386036564796115729466678486205655437454374620076337245092257019144673363392550719896234139904688462721495528024948084963183154923535080274081582789068191854163893031474603625570559711998951860425903268936620861264437886426977844707814206865409273175438377";
        String publicKey = "65537";
        RSAPublicKey publicKey1 = RSAUtils.getPublicKey(modulus,publicKey);

        String mingwen = number + innerToken + System.currentTimeMillis();
        String miwen = RSAUtils.encryptByPublicKey(mingwen,publicKey1);
        System.out.println("公钥为:"+publicKey);
        System.out.println("modulus为:"+modulus);
        System.out.println("原文为:"+mingwen);
        System.out.println("密文为:"+miwen);
    }

}

