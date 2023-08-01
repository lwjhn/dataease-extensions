package io.dataease.plugins.datasource.kingbase.provider;

import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 连接配置信息
 */
@Getter
@Setter
public class KingbaseConfig extends JdbcConfiguration {

    private String driver = "com.kingbase8.Driver";//驱动类名
    private String extraParams;

    public String getJdbc() {
        return "jdbc:kingbase8://HOSTNAME:PORT/DATABASE"
                .replace("HOSTNAME", getHost().trim())
                .replace("PORT", getPort().toString().trim())
                .replace("DATABASE", getDataBase().trim()) + (
                StringUtils.isBlank(extraParams)
                        ? (StringUtils.isNotBlank(this.getSchema()) ? "?currentSchema=" + this.getSchema() : "")
                        : ((getExtraParams().trim().startsWith("?") ? "" : "?")
                        + getExtraParams().trim()));
    }
}
