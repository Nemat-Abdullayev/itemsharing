package az.itemsharing.userservice.config;

import org.hibernate.dialect.Oracle12cDialect;

public class CustomOracleDialect extends Oracle12cDialect {
    public CustomOracleDialect() {
        super();
        registerKeyword("within");
    }
}
