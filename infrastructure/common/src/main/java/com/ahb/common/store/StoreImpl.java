package com.ahb.common.store;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.domain.*;
import com.ahb.common.region.Criteria;
import com.ahb.common.region.DefaultRegion;
import com.ahb.common.region.Region;
import com.ahb.common.region.RegionId;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xerial.snappy.Snappy;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aheroboy on 17/3/2018.
 */
public class StoreImpl implements Store {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreImpl.class);
    private Conf conf;
    private BasicDataSource bds;

    public enum StoreHolder {
        INSTANCE;
        public Store store;

        StoreHolder() {
            Conf storeConf = new ConfImpl();
            store = new StoreImpl(storeConf);
        }
    }

    public enum RegionRoot {
        INSTANCE;
        private Map<RegionId, Region<Domain>> regions = Maps.newConcurrentMap();

        public Region<Domain> getRegion(RegionId regionId) {
            return regions.get(regionId);
        }

        public void add(Region<Domain> region) {
            regions.put(region.getId(), region);
        }
    }

    @Override
    public Collection<Region<Domain>> getAll() {
        return RegionRoot.INSTANCE.regions.values();
    }

    private StoreImpl(Conf conf) {
        this.conf = conf;
    }

    public StoreImpl() {
    }

    @Override
    public Collection<DomainValues> execute(Criteria criteria) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void save(DomainValues domain) {
        try {
            Gson gson = new Gson();
            String strs = gson.toJson(domain);
            byte[] str = strs.getBytes();
            byte[] compressed = Snappy.compress(gson.toJson(domain));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DomainValues get(String domainId) {
        return null;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public void init() {
        initDb();
        URL url = conf.getFileSystemUrl();
        if (url != null && conf.loadDefaultData()) {
            LOGGER.info("File system location:" + url.getPath());

            File regionFolders = new File(url.getFile(), "region");
            if (regionFolders.exists()) {
                Set<Region<Domain>> pubRegions = Sets.newHashSet();
                //Load default regions.
                /**
                 Properties properties = new Properties();
                 loadProperties(new File(ClassLoader.getSystemResource(Region.REGION_FILE_NAME).getFile()), properties);
                 Region<Domain> adminRegion = createRegionFromProperties(properties);
                 domains.add(adminRegion);
                 **/
                //Load all regions, may override existing.
                File[] regions = regionFolders.listFiles((File pathFile) -> {
                    return pathFile.isDirectory() && new File(pathFile, Region.REGION_FILE_NAME).exists();
                });
                pubRegions.addAll(Stream.of(regions).map((File regionFolder) -> {
                    try {
                        Properties localProperties = new Properties();
                        File regionDescFile = new File(regionFolder, Region.REGION_FILE_NAME);
                        loadProperties(regionDescFile, localProperties);
                        return createRegionFromProperties(localProperties);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toSet()));

                createRegionRoot(pubRegions);
            }
        } else {
            loadRegionFromDb();
        }
    }
    void loadDomainForRegion(Region<Domain> region){

    }

    void loadRegionFromDb() {
        try {
            Connection conn = bds.getConnection();
            conn.setAutoCommit(Boolean.TRUE);
            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM REGION");
            DomainDesc domainDesc = new DomainDesc();
            List<Region<Domain>> regions = Lists.newArrayList();
            while (resultset.next()) {
                int id = resultset.getInt("ID");
                String businessId = resultset.getString("BUSINESS_ID");
                String description = resultset.getString("DESCRIPTION");
                regions.add(new DefaultRegion(new DefaultDomain(businessId, businessId, domainDesc)));
            }
            for (Region<Domain> region : regions) {
                ResultSet rs = statement.executeQuery("select * from REGION_DETAILS WHERE BUSINESS_ID = '" + region.getRegionName() + "'");
                while (rs.next()) {
                    //String bsId = rs.getString("BUSINESS_ID");
                    String colName = rs.getString("COL_NAME");
                    String type = rs.getString("TYPE");
                    int seq = rs.getInt("SEQ");
                    //long id = rs.getLong("ID");
                    ColumnDesc columnDesc = new ColumnDesc(Integer.valueOf(seq), ColumnType.valueOf(type), colName);
                    region.getRegionDomain().getDomainDesc().add(columnDesc);
                }
            }
            for (Region<Domain> region : regions) {
                RegionRoot.INSTANCE.add(region);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void initDb() {
        bds = new BasicDataSource();
        bds.setDefaultTransactionIsolation(2);
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/ahb?useSSL=true&useUnicode=true&characterEncoding=UTF-8");
        bds.setUsername("root");
        bds.setPassword("123456");
        bds.setInitialSize(20);
        bds.setMaxTotal(100);
        bds.setMaxIdle(20);

        try {
            Connection conn = bds.getConnection();
            conn.setAutoCommit(Boolean.TRUE);
            DatabaseMetaData metaData = conn.getMetaData();
            LOGGER.info(metaData.getURL()
                    + ",UserName=" + metaData.getUserName()
                    + "," + metaData.getDriverName());
            conn.close();
        } catch (Exception e) {
            LOGGER.error("Error:", e);
        }
    }

    private void createRegionRoot(Collection<Region<Domain>> regions) {

        Connection conn;
        try {
            conn = bds.getConnection();
            conn.setAutoCommit(Boolean.TRUE);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE REGION_DETAILS(ID BIGINT NOT NULL AUTO_INCREMENT," +
                    "BUSINESS_ID VARBINARY(64) NOT NULL ," +
                    "COL_NAME VARCHAR(64) NOT NULL," +
                    "TYPE VARCHAR(64) DEFAULT NULL," +
                    "SEQ INT NOT NULL," +
                    "PRIMARY KEY (ID)," +
                    "UNIQUE KEY BUSINESS_ID_COL_NAME(BUSINESS_ID,COL_NAME))");
            statement.execute("CREATE TABLE REGION(ID BIGINT NOT NULL AUTO_INCREMENT,BUSINESS_ID VARBINARY(64) UNIQUE NOT NULL ,DESCRIPTION VARBINARY(64) NULL ,PRIMARY KEY(ID))");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        regions.stream().forEach((Region<Domain> region) -> {
            try {
                Statement statement = conn.createStatement();
                Collection<String> sqls = MysqlSupport.toSql(region);
                for (String sql : sqls) {
                    LOGGER.info("executing:" + region.getRegionName() + " with sql : " + sql);
                    statement.addBatch(sql);
                }
                statement.executeBatch();
                RegionRoot.INSTANCE.add(region);
            } catch (Exception e) {
                LOGGER.error("Error occurred while creating region " + region.getRegionName());
                throw new RuntimeException(e);
            }
        });
    }

    private void loadProperties(File propertyFile, Properties properties) {
        try {
            LOGGER.info("Loading property file from " + propertyFile);
            properties.load(new FileInputStream(propertyFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Region<Domain> createRegionFromProperties(Properties properties) {

        String regionName = properties.getProperty(Region.NAME);
        String regionNameSeq = properties.getProperty(Region.NAME_SEQ);
        String regionNameType = properties.getProperty(Region.NAME_TYPE);
        DomainDesc domainDesc = new DomainDesc();
        ColumnDesc columnDesc = new ColumnDesc(Integer.valueOf(regionNameSeq), ColumnType.valueOf(regionNameType), regionName);
        domainDesc.add(columnDesc);

        String regionPath = properties.getProperty(Region.PATH);
        String regionPathType = properties.getProperty(Region.PATH_TYPE);
        String regionPathSeq = properties.getProperty(Region.PATH_SEQ);
        columnDesc = new ColumnDesc(Integer.valueOf(regionPathSeq), ColumnType.valueOf(regionPathType), regionPath);
        domainDesc.add(columnDesc);

        Domain regionDomain = new DefaultDomain(regionName, regionName, domainDesc);
        Region<Domain> domainRegion = new DefaultRegion(regionDomain);
        createDomainForRegion(domainRegion);
        return domainRegion;
    }

    private void createDomainForRegion(Region<Domain> region) {
        String domainName = "user";
        String domainId = domainName;
        DomainDesc domainDesc = new DomainDesc();
        ColumnDesc username = new ColumnDesc(1,ColumnType.STRING,"username");
        domainDesc.add(username);
        ColumnDesc password = new ColumnDesc(2,ColumnType.STRING,"password");
        domainDesc.add(password);
        ColumnDesc businessId = new ColumnDesc(3,ColumnType.STRING,"businessId");
        domainDesc.add(businessId);
        Domain userDomain = new DefaultDomain(domainName,domainId,domainDesc);
        region.install(userDomain);
    }
}
