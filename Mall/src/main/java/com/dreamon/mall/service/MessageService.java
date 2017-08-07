package com.dreamon.mall.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.dreamon.mall.base.Status;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.MessageException;
import com.dreamon.mall.exception.OutException;

/**
 * 短息服务(已经在beans.xml中定义了该bean，ID为msgService
 * Created by wmt on 2017/7/28.
 */
public class MessageService implements Status {

    private final String product;
    private final String domain;
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String defaultConnectTimeoutIndex;
    private final String defaultConnectTimeoutValue;
    private final String defaultReadTimeoutIndex;
    private final String defaultReadTimeoutValue;
    private final String templeteCode ;
    private final String contentName ;
    private final String msgName ;

    public MessageService(String accessKeyId, String product, String domain,
                          String accessKeySecret, String defaultConnectTimeoutIndex,
                          String defaultConnectTimeoutValue, String defaultReadTimeoutIndex,
                          String defaultReadTimeoutValue, String templeteCode,
                          String contentName, String msgName) throws ClientException {
        this.accessKeyId = accessKeyId;
        this.product = product;
        this.domain = domain;
        this.accessKeySecret = accessKeySecret;
        this.defaultConnectTimeoutIndex = defaultConnectTimeoutIndex;
        this.defaultConnectTimeoutValue = defaultConnectTimeoutValue;
        this.defaultReadTimeoutIndex = defaultReadTimeoutIndex;
        this.defaultReadTimeoutValue = defaultReadTimeoutValue;
        this.templeteCode = templeteCode;
        this.contentName = contentName;
        this.msgName = msgName;

        initComponet();

    }

    /**
     * 初始化短信接口对象
     * @throws ClientException
     */
    private void initComponet() throws ClientException{
        //设置超时时间-可自行调整
        System.setProperty(defaultConnectTimeoutIndex, defaultConnectTimeoutValue);
        System.setProperty(defaultReadTimeoutIndex, defaultReadTimeoutValue);
        //初始化ascClient需要的几个参数{配置文件中}
        //替换成你的AK{配置文件中}
        //初始化ascClient,暂时不支持多region
        profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        acsClient = new DefaultAcsClient(profile);
    }

    private IClientProfile profile;
    private IAcsClient acsClient;
    private SendSmsRequest request;

    public static final int MSG_REGISTER_MODEL = 1;
    public static final int MSG_FIND_MODEL = 2;

    /**
     * 发送验证码短信接口
     * @param telephone 目标电话号码
     * @param code 验证码
     * @param messageModel 短信模板
     * @throws ClientException
     * @throws MessageException 验证码短信发送出错时抛出此异常
     * @throws OutException 电话号码不合法时抛出此异常
     */
    public void sendIdcodeMessage(String telephone,String code,int messageModel) throws ClientException,MessageException,OutException {

        //组装请求对象
        request = new SendSmsRequest();
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(telephone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("叶荣");
        System.out.println(msgName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templeteCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        String msgContent = "{ \"code\":\""+code+"\"}";
        request.setTemplateParam(msgContent);
        //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");
//请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println(sendSmsResponse.getCode()+"      "+sendSmsResponse.getMessage());
        //电话号码是否合法
        if (sendSmsResponse.getCode() .equals("isv.MOBILE_NUMBER_ILLEGAL"))
            throw new OutException(MSG_ILLAGEL_PHONE_NUMBER,MSG_ILLAGEL_PHONE_NUMBER_STR);
        //短信是否发送成功
        boolean result = sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK");
        if(!result)
            throw new MessageException(MSG_SEND_FAIL,MSG_SEND_FAIL_STR);

    }

}
