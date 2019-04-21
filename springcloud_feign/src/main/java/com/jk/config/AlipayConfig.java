package com.jk.config;

public class AlipayConfig {

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "2016091700529409";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCOKQb3A2b4XGiHQodIaAm84BNyfnnOyrvqRZR93ppQnclfrLcA8T+vfcXIyoBHmDqQ+7ix0hm7MTFv3zsF8OxzExMHegppT3k/grl406j7/3+4tOU9Vpkzi0idDJkSHPwKEGq3cYS8WttmFwBKYQC42GTKpMyENKIaSpd3y8ubxC408P8M+YosRIIfP79dtdr9KbF7ouEjhm1O7pKGYNki5PHcwvT/qrEmilos3pYJo34vtLqMLYwo826nmSfYYGq36QG6Ty6SHAud3Lo1XvXYwMz9OoxMwEfjpnbBKkh7b4qLu80/XpxP9nekcHK0+XZRF/J+k1QCd0hmCsww/jqjAgMBAAECggEBAIfxhd6LG1nfjHnkTdgY3U8H/LDdb4An8OFL3n8rcugqq1pZoLs++IbKQGwN8fQFB+SDQxCQ+NhAZ6UylI/O313/3I+mzfP88tagHNsFlTA+GRY5rookmOZoiGzekjZ3DzJUlqiL3sH8JJiQ4E9ASd9515DNXWIDrwxzTjtZ4IA39wgJkbNrhTekQ4Omv0n/qEftCaa2np+jyf3Jjd02ImF+bumjcl3FOtCu3zWLSIxG6vHTIby53kRHEPp5eTw2mawhBCZ4US3TAOP5cgqJPe06jjJthcJZH39IgpWNHJz+oG5EangRv6ym9IEvhruxiAwKhN7Y8V1ICPjfDWTrmSECgYEA9TgEqOO7jPezLtB6odAdoII9pVnv71YARVCVW3LkcAc0o2R7L9vdqiWi0TQ1zYaqz72GYAsUy4BQqUx1lUmcBJhnepwGzwrtm0eFoVXwEW6VGdOuqbVai/vPJOQBrHwOJM9a4KVImr4QL/kFWJfheAgBoPgD6DH/mqEF9hMgcNMCgYEAlGkRAt0I5m1959De3MGvPb7iUa5NNvdMQFMR0WO0KXOn+MlKAzt8gUIykdJJ3i7y4lhCKq4D2LKEAc8nfr9glBtm6PKljr5z0Q7NI+0oMsnPkJ3z6qndiMtuXWc9OpgyYzQlcjkBUUqyz39iQ0V8yp5JP5d9Dxqv5rmFH4/ZbPECgYBzEWtWWS7sElvZruisv7z3UcZdrhtiAsgzvoGnnP1G+Iqh1YfcyF529hw18TsCC5xhyTyiGvESIU84cnGGsTjuCxobtdWYGDexMtmpAGubsnly2htO9ZPctjfYxslmR/xXF5o8ajLssh1kdYUlsneR3KfvAhLLRZL822yxsP37EwKBgQCOesgQHbBbuKZ1lbs/6NqaxtV0YYhTyttzrcyfX78pRJXwbR8XN1byqWDvShoMqroXv2/WlbWvpsLBEeXy8zx/NEd6QOncvs9l13XuldJP4Bvb1SjFE0tR9yv/lAveYxuMzhVdMYkoSDSerMbjmqSRyaC84mz3wUE6msVJZcrxoQKBgQCRaD3q5LvqUQu4FQ2XhLSGu8tzo61ouGjW19Zgu4Wo2EfSC93lQFtxORMPvhaUV0iiL846OynzIMkWCxFor0dlUWzhjASDVMWwmFATYJ8sL1ublX3JbpRVqzNZZy8vETTz9K0zz6aFmS6sCkH448BeOtqSYEIfgdGQpx5SWXZLtQ==";
    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://127.0.0.1:8082/page/tologin";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjikG9wNm+Fxoh0KHSGgJvOATcn55zsq76kWUfd6aUJ3JX6y3APE/r33FyMqAR5g6kPu4sdIZuzExb987BfDscxMTB3oKaU95P4K5eNOo+/9/uLTlPVaZM4tInQyZEhz8ChBqt3GEvFrbZhcASmEAuNhkyqTMhDSiGkqXd8vLm8QuNPD/DPmKLESCHz+/XbXa/Smxe6LhI4ZtTu6ShmDZIuTx3ML0/6qxJopaLN6WCaN+L7S6jC2MKPNup5kn2GBqt+kBuk8ukhwLndy6NV712MDM/TqMTMBH46Z2wSpIe2+Ki7vNP16cT/Z3pHBytPl2URfyfpNUAndIZgrMMP46owIDAQAB";

    public static String signtype = "RSA";


}
