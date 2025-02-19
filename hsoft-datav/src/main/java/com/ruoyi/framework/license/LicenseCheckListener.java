package com.ruoyi.framework.license;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @ProjectName: hsoft-datav
 * @ClassName: LicenseCheckListener
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 风清扬 [刘佳男]
 * @Date: 2021/6/10 15:52
 */

@Component
public class LicenseCheckListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LogManager.getLogger(LicenseCheckListener.class);

    /**
     * 证书subject
     */
    @Value("${license.subject}")
    private String subject;

    /**
     * 公钥别称
     */
    @Value("${license.publicAlias}")
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    @Value("${license.storePass}")
    private String storePass;

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    @Value("${license.publicKeysStorePath}")
    private String publicKeysStorePath;

    /**
     * 是否需要license认证
     */
    @Value("${license.isLicense}")
    private boolean isLicense;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (isLicense) {
            //root application context 没有parent
            ApplicationContext context = event.getApplicationContext().getParent();
            if(context == null){
                if(StringUtils.isNotBlank(licensePath)){
                    logger.info("++++++++ 开始安装证书 ++++++++");

                    LicenseVerifyParam param = new LicenseVerifyParam();
                    param.setSubject(subject);
                    param.setPublicAlias(publicAlias);
                    param.setStorePass(storePass);
                    param.setLicensePath(licensePath);
                    param.setPublicKeysStorePath(publicKeysStorePath);

                    LicenseVerify licenseVerify = new LicenseVerify();
                    //安装证书
                    licenseVerify.install(param);

                    logger.info("++++++++ 证书安装结束 ++++++++");
                }
            }
        }

    }

}
