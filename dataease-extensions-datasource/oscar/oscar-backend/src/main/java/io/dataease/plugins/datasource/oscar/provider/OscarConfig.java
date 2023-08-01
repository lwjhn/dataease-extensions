package io.dataease.plugins.datasource.oscar.provider;

import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class OscarConfig extends JdbcConfiguration {

    private String driver = "com.oscar.Driver";
    private String extraParams;


    public String getJdbc() {
        return "jdbc:oscar://HOST:PORT/DATABASE"
                .replace("HOST", getHost().trim())
                .replace("PORT", getPort().toString())
                .replace("DATABASE", getDataBase().trim()) + (
                StringUtils.isBlank(extraParams)
                        ? (StringUtils.isNotBlank(this.getSchema()) ? "?currentSchema=" + this.getSchema() : "")
                        : ((getExtraParams().trim().startsWith("?") ? "" : "?")
                        + getExtraParams().trim()));
    }
}
