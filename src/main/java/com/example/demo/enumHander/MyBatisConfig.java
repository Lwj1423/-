package com.example.demo.enumHander;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.activation.DataSource;


@Configuration
@ConfigurationProperties(prefix = "mybatis")
public class MyBatisConfig {


        private String configLocation;

        private String mapperLocations;


//        @Bean
//        public SqlSessionFactory sqlSessionFactory(
//                DataSource dataSource,
//                JSONArrayHandler jsonArrayHandler,
//                JSONObjectHandler jsonObjectHandler) throws Exception {
//            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//            factory.setDataSource(dataSource);
//
//
//            // 设置配置文件及mapper文件地址
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//            factory.setConfigLocation(resolver.getResource(configLocation));
//            factory.setMapperLocations(resolver.getResources(mapperLocations));
//
//
//            SqlSessionFactory sqlSessionFactory = factory.getObject();
//
//
//            // 取得类型转换注册器
//            TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
//            // 注册默认枚举转换器
//            typeHandlerRegistry.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
//
//            return sqlSessionFactory;
//        }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }
}
