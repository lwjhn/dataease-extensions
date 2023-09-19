package io.dataease.plugins.datasource.trino.provider;

import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class DmConfig extends JdbcConfiguration {

    private String driver = "dm.jdbc.driver.DmDriver";
    private String extraParams;


    public String getJdbc() {
        return "jdbc:dm://HOST:PORT/DATABASE"
                .replace("HOST", getHost().trim())
                .replace("PORT", getPort().toString())
                .replace("DATABASE", getDataBase().trim()) + (
                StringUtils.isBlank(extraParams)
                        ? (StringUtils.isNotBlank(this.getSchema()) ? "?schema=" + this.getSchema() : "")
                        : ((getExtraParams().trim().startsWith("?") ? "" : "?")
                        + getExtraParams().trim()));
    }
}
