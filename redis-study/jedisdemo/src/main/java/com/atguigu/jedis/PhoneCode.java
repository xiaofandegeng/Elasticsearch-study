package com.atguigu.jedis;

import com.sun.deploy.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author liaohongwei
 * @date 2021/4/23 10:29
 * @Description:
 */
public class PhoneCode {
    public static void main(String[] args) {
        //checkPhone("13412344321");
        checkPhoneAndCode("13412344321","716035");
    }

    /**
     * @Author lhw
     * @Description 验证手机的验证码
     * @Date 10:51 2021/4/23
     * @param
     * @return
     */
    public static void checkPhoneAndCode(String phone, String code) {
        // 创建jedis对象
        Jedis jedis = new Jedis("172.16.5.59", 6379);

        String checkCode = "check:" + phone +":code";
        String res = jedis.get(checkCode);
        if (res.equals(code)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }


    /**
     * @Author liaohongwei
     * @Description 验证手机
     * @Date 10:40 2021/4/23
     * @param
     * @return
     */
    public static void checkPhone(String phone) {
        // 创建jedis对象
        Jedis jedis = new Jedis("172.16.5.59", 6379);

        String checkCount = "check:" + phone +":count";
        String checkCode = "check:" + phone +":code";

        // 设置手机号今天只能接收三次短信
        String count = jedis.get(checkCount);
        if(count == null) {
            jedis.setex(checkCount, 24*60*60, "1");
        } else if(Integer.parseInt(count) <= 2) {
            jedis.incr(checkCount);
        } else {
            System.out.println("今日发送次数已达上限，请24小时后再发送！");
        }

        // 设置code的过期时间
        String vcode = setCode();
        jedis.setex(checkCode, 120, vcode);

        jedis.close();
    }

    /**
     * @Author lhw
     * @Description 生成验证码
     * @Date 10:39 2021/4/23
     * @param
     * @return
     */
    public static String setCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(10);
            code += num;
        }
        return code;
    }
}
