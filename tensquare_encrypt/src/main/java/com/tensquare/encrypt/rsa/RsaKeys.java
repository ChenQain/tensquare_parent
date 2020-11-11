package com.tensquare.encrypt.rsa;

/**
 * rsa加解密用的公钥和私钥
 *
 * @author Administrator
 */
public class RsaKeys {

    //生成秘钥对的方法可以参考这篇帖子
    //https://www.cnblogs.com/yucy/p/8962823.html

    /**
     * 服务器公钥
     */
    private static final String SERVER_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6AZDxj5qe7diIM4a8j1y" +
            "zQHFuuGkVog0eEAd+fsxKRqoAIn6i2AvWfDxMGoVyYVHnaHj6K9vMsKukYWIO0ga" +
            "DCLQ04w9VoKknD+nmbwSfXqYNjSn963DCSSKKej75vCMdK2y3owJpu6bZOG45tj/" +
            "Nin0UJXs2CUIudnqBuDkbNGV3wAemkymeuQqxGDOba2333iJlKT3o7m5BjKvp/+L" +
            "yb0904HAsEj/+8mGdO1oR7GY+rVEYuNSYhW217zhnVGDzibBc7BT/CRO77kZG5aU" +
            "+jaCvyed3I5WzKd3xCH+WGxFK0nSHdDL6z3VdrTfAeBqsdl8ptvN8i2+62qGZl+j" +
            "BQIDAQAB";

    /**
     * 服务器私钥(经过pkcs8格式处理)
     */
    private static final String SERVER_PRV_KEY_PKCS8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDoBkPGPmp7t2Ig" +
            "zhryPXLNAcW64aRWiDR4QB35+zEpGqgAifqLYC9Z8PEwahXJhUedoePor28ywq6R" +
            "hYg7SBoMItDTjD1WgqScP6eZvBJ9epg2NKf3rcMJJIop6Pvm8Ix0rbLejAmm7ptk" +
            "4bjm2P82KfRQlezYJQi52eoG4ORs0ZXfAB6aTKZ65CrEYM5trbffeImUpPejubkG" +
            "Mq+n/4vJvT3TgcCwSP/7yYZ07WhHsZj6tURi41JiFbbXvOGdUYPOJsFzsFP8JE7v" +
            "uRkblpT6NoK/J53cjlbMp3fEIf5YbEUrSdId0MvrPdV2tN8B4Gqx2Xym283yLb7r" +
            "aoZmX6MFAgMBAAECggEAZ/D+hZ3KeBfD9uw9+Az9E8fae4i/5R/pWYFnrGgSMtbF" +
            "MlCdk7iIHeOpOMYdcoSpe31dqwyEZRn/uCM4z03SlWM3Z72ocMvf0DtX6q/tHJdB" +
            "/u6B3JvUBpF+751205MpaM+zlKzpWgYESSIxggDt+6a50ywGySF2EkQD6gbvbatv" +
            "+P4vjYAfBILjOgQ+PcmL97co+AfxOnU8UaP3XRs5kj1mK9pNZYB8C495uJDSdbhW" +
            "WQBzh24bOP4JrEo6/P8kxZALoSVLC5ehcPkNbtACS+1GAJFYDvezl2kdchT3KYqV" +
            "ymiywq6QwubRiHQR6hZW6JrY0HSHzuhTwBVWGEHU1QKBgQD1g3/Kfxt3nM1JFSPR" +
            "IDAZJ6/31qNvReboWNrAFno0vt+zLvy/8C8oaQRC2Vbmv/jLdqP3V8VgQmCBxDYW" +
            "ltjwFREU/YJLfmr3MFRtu/U/3tZrXOj8YvSgz6hiVPbRHfn1J2l+PnzzvHAZ9He/" +
            "XE7kgGDyAYiKY1y11YeG6/ctBwKBgQDx70WNqtVpvK9s4IR/O9yG11svI4nNDm1W" +
            "f6H08qTSG4CzL9IHs5/J2SRrSl5Q/e1YxjvmhxHjuhQAYW/4qXLeIVjW48cWX7AJ" +
            "4noOH+uvE6dL68bMyp3h+lbowwWaAplzv4/1Cv4eJ2VGrAAnFU73mfXh/x38DZBo" +
            "khsiKx74kwKBgQCzq7VkotqeEYFmP3NDwvOQJSwxCsH2V8ihNw13T7vFR/57qiJL" +
            "8OECCMCWj2l6WvkfJUbfZztJs6nerZILu/8sy64Bl3i3+N8c4SCYYdocEN8IGSlk" +
            "MqLl4LJQq+8ooHBhiaM5QU++K6Q6Sl8sCsitjonj8V1UMV0SsR6KjbsJFwKBgQDo" +
            "e/ZJcW1NA21L4eBQ57Q9uzq7bJoh+4gkA9gdKwIpiRY+mmho0DpvXAN8OmWxzKFE" +
            "mpG7L/aH8CsCRp+zwxlHzaGyNgX9QQxII2MIqbHwdqFf+nz6FIZtPgQ//hAm8/KD" +
            "4QQ0BFE3psHSjLxE0lwk4MUAXAhzSpGHe0cpqWhEkwKBgAgfYKGjniHK+uU3vC8z" +
            "KV5lU90KgMdY3wCVk4l1YvY1lFoJyQVvMMtjoQ7DMsBcBRujMcHdF5PFLdIrz+JC" +
            "nTNks4X2JBaviA4jvIso5zG2Y7YAb4iP9GtIndshx6yXxDD3H9JZteTA/lSGZa7S" +
            "VvxPFxWGm9hOEvwoLN4MxW1c";

    public static String getServerPubKey() {
        return SERVER_PUB_KEY;
    }

    public static String getServerPrvKeyPkcs8() {
        return SERVER_PRV_KEY_PKCS8;
    }

}
