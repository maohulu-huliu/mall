//package com.mhl.mall.config;
//
//import com.mhl.mall.config.properties.EsProperties;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//
///**
// * @author huliou
// * @date 2021/11/12 13:43
// */
//@Configuration
//public class RestHighLevelClientConfiguration extends AbstractElasticsearchConfiguration {
//
//    @Autowired
//    private EsProperties esProperties;
//
//    @Bean
//    @ConditionalOnBean(value = EsProperties.class)
//    @ConditionalOnMissingBean
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        return new RestHighLevelClient(RestClient.builder(
//                new HttpHost(esProperties.getAddress(), esProperties.getPort())
//        ));
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public ElasticsearchRestTemplate template() {
//        return new ElasticsearchRestTemplate(elasticsearchClient());
//    }
//}
