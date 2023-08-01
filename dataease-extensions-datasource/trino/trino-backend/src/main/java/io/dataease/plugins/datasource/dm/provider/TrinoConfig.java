package io.dataease.plugins.datasource.dm.provider;

import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class TrinoConfig extends JdbcConfiguration {

    private String driver = "io.trino.jdbc.TrinoDriver";
    private String extraParams;


    public String getJdbc() {
        return "jdbc:trino://HOST:PORT/DATABASE/SCHEMA"
                .replace("HOST", getHost().trim())
                .replace("PORT", getPort().toString())
                .replace("DATABASE", getDataBase().trim())
                .replace("SCHEMA", getSchema().trim()) + (
                StringUtils.isBlank(extraParams) ? ""
                        : ((getExtraParams().trim().startsWith("?") ? "" : "?")
                        + getExtraParams().trim()));
    }
}
