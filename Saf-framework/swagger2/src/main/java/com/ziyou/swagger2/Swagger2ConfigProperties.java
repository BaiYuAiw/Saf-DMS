package com.ziyou.swagger2;

import com.ziyou.core.constants.SafConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author libo
 * @date 2023/10/27
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2ConfigProperties {
    private boolean show = true;
    private String groupName = "Saf-Netdisk";
    private String basePackage = SafConstant.BASE_COMPONENT_SCAN_PATH;
    private String title = "Saf-Netdisk";
    private String desc = "Saf-Netdisk";
    private String serviceUrl = "http://127.0.0.1:${server.port}";
    private String contactName = "libo";
    private String contactUrl = "";
    private String contactEmail = "2565477149@qq.com";
    private String version = "1.0";
}
