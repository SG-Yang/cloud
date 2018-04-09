package com.ahb.common.store;

import com.ahb.common.domain.ColumnDesc;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainDesc;
import com.ahb.common.region.Region;
import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * Created by aheroboy on 8/4/2018.
 */
public class MysqlSupport {
    public static Collection<String> toSql(Region<Domain> region) {
        Domain domain = region.getRegionDomain();
        String domainName = domain.getDomainName();
        DomainDesc domainDesc = domain.getDomainDesc();
        Collection<String> sqls = Lists.newArrayList();
        sqls.add("insert into REGION(BUSINESS_ID) VALUES('" + domainName + "')");
        for (ColumnDesc columnDesc : domainDesc.getPropertyNameToColumnDesc().values()) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("insert into REGION_DETAILS(BUSINESS_ID,COL_NAME,TYPE,SEQ) values(")
                    .append("'")
                    .append(domainName)
                    .append("'")

                    .append(",")
                    .append("'")
                    .append(columnDesc.getColumnName())
                    .append("'")

                    .append(",")
                    .append("'")
                    .append(columnDesc.getColumnType())
                    .append("'")

                    .append(",")
                    .append(columnDesc.getSeq());

            sqlBuilder.append(");");
            sqls.add(sqlBuilder.toString());
        }
        return sqls;
    }
}
