package com.jlkj.msj.test;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.jlkj.msj.uitl.EncryptionUtil;
import com.jlkj.msj.uitl.SendMail;
import org.junit.Test;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.jlkj.msj.uitl.SendMessage.querySendDetails;
import static com.jlkj.msj.uitl.SendMessage.sendSms;

public class TestEncryption {
    @Test
    public void test(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2017,11,1);
//        System.out.println(calendar.get(Calendar.YEAR));
        Date date = new Date(2017,11,1);
        System.out.println(date.getMonth());
//        Date date = new Date(1509674906646L);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(date));
//        try {
//            SendSmsResponse response = sendSms("13151567657", "1111");
//            System.out.println("短信接口返回的数据----------------");
//            System.out.println("Code=" + response.getCode());
//            System.out.println("Message=" + response.getMessage());
//            System.out.println("RequestId=" + response.getRequestId());
//            System.out.println("BizId=" + response.getBizId());
//
//            //查明细
//            if(response.getCode() != null && response.getCode().equals("OK")) {
//                QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId());
//                System.out.println("短信明细查询接口返回数据----------------");
//                System.out.println("Code=" + querySendDetailsResponse.getCode());
//                System.out.println("Message=" + querySendDetailsResponse.getMessage());
//                int i = 0;
//                for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
//                {
//                    System.out.println("SmsSendDetailDTO["+i+"]:");
//                    System.out.println("Content=" + smsSendDetailDTO.getContent());
//                    System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
//                    System.out.println("OutId=" + smsSendDetailDTO.getOutId());
//                    System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
//                    System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
//                    System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
//                    System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
//                    System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
//                }
//                System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
//                System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
//            }
//        }catch (ClientException e){
//            System.out.println("exception");
//            e.printStackTrace();
//        }
////        String result = EncryptionUtil.encoder("1212","12");
////        System.out.println(result.equals(EncryptionUtil.encoder("1212","12")));
////        SendMail mail = new SendMail();
////        try{
////            mail.send("m13814545863@163.com");
////            System.out.println(mail.getContent());
////        }catch (Exception e){
////            System.out.println("exception");
////        }
    }
//    @Test
//    public void testMail(){
//        SendMail mail = new SendMail();
//        try{
//            mail.send("m13814545863@163.com");
//            System.out.println(mail.getContent());
//        }catch (Exception e){
//            System.out.println("exception");
//        }
//
//    }
}
