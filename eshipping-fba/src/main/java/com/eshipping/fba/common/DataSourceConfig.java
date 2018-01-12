package com.eshipping.fba.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableTransactionManagement
@MapperScan("com.eshipping.fba.dao")
/**
 * 
* @ClassName: DataSourceConfig 
* @Description: TODO(数据连接) 
* @author Alan
* @date 2017年6月10日 下午1:52:53 
*
 */
public class DataSourceConfig {

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	@Value("${mysql.ipPort}")
	private String jdbcIpPort;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.hikari.connectionTimeout}")
	private int connectionTimeout;
	@Value("${spring.datasource.hikari.idleTimeout}")
	private int idleTimeout;
	@Value("${spring.datasource.hikari.maxLifetime}")
	private int maxLifetime;
	@Value("${spring.datasource.hikari.maximumPoolSize}")
	private int maximumPoolSize;
	@Value("${spring.datasource.hikari.dataName}")
	private String dateName;
	

	/**
	 * 
	 * @Title: dataSource
	 * @Description: TODO(hikari数据连接池)
	 * @user Alan
	 * @date 2017年6月10日 下午1:47:14
	 * @param @return设定文件
	 * @return DataSource 返回类型
	 */
	@Bean(name = "HikariDataSource")
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(String.format(jdbcUrl, jdbcIpPort, dateName));
		config.setUsername(userName);
		config.setPassword(password);
		config.setConnectionTimeout(connectionTimeout);
		config.setIdleTimeout(idleTimeout);
		config.setMaxLifetime(maxLifetime);
		config.setMaximumPoolSize(maximumPoolSize);
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	/**
	* @Title: clusterTransactionManager 
	* @Description: TODO(事物处理) 
	* @user  Alan
	* @date 2017年6月10日 下午1:52:11 
	* @param @return    设定文件 
	* @return DataSourceTransactionManager    返回类型
	 */

	@Bean(name = "dataSourceManager")
	public DataSourceTransactionManager clusterTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * @Title: sqlSessionFactoryBean
	 * @Description: TODO(mybatis配置)
	 * @user Alan
	 * @date 2017年6月10日 下午1:48:01
	 * @param @param ds
	 * @param @return
	 * @param @throws  Exception 设定文件
	 * @return SqlSessionFactory 返回类型
	 */
	@Bean(name = "dataSourceSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("HikariDataSource") DataSource ds) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(ds);
		// 设置查找器
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 自动扫描mybatis文件
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

}
