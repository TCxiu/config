import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {
	 @Bean
	 public DataSource dataSource() {
		 DruidDataSource datasource = new DruidDataSource(); 
		 datasource.setUrl("jdbc:mysql://192.168.0.189:3306/dyd_shop_admin_v1.0?useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
	        datasource.setUsername("root");
	        datasource.setPassword("Dyd_2018");
	        datasource.setDriverClassName("com.mysql.jdbc.Driver");
//	        <!-- 初始化连接大小 -->
	        datasource.setInitialSize(10);
//	        <!-- 连接池最大并发使用连接数量 -->
	        datasource.setMaxActive(500);
//	        <!-- 连接池最小空闲 -->
	        datasource.setMinIdle(1);
//	        <!-- 获取连接最大等待时间 -->
	        datasource.setMaxWait(60000);
//	        <!-- 打开pscache功能  在mysql5.5以上版本支持 -->
	        datasource.setPoolPreparedStatements(true);
//	        <!-- 指定每个连接上的pscache的大小 -->
	        datasource.setMaxPoolPreparedStatementPerConnectionSize(66);
	        datasource.setValidationQuery("select 1");
//	        <!-- 归还连接时执行validationQuery  ，检测是否有效，设置为true这样会降低性能 -->
	        datasource.setTestOnBorrow(false);
	        datasource.setTestOnReturn(false);
//	        <!-- 申请链接的时间是否检测 -->
	        datasource.setTestWhileIdle(true);
//	        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
	        datasource.setTimeBetweenEvictionRunsMillis(60000);
//	        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
	        datasource.setMinEvictableIdleTimeMillis(2520000);
//	        <!-- 打开超过时间限制是否回收功能 -->
	        datasource.removeAbandoned();
//	        <!-- 超过多长时间 1800秒，也就是30分钟 -->
	        datasource.setRemoveAbandonedTimeout(1800);
		 return datasource; 
	 } 
	 
}