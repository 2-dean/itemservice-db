package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Slf4j
//@Import(MemoryConfig.class)// MemofyConfig를 설정파일로 사용한다
//@Import(JdbcTemplateV1Config.class)
//@Import(MyBatisConfig.class)
@Import(JdbcTemplateV3Config.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")// 해당 패키지 하위만 컴포넌트를 스캔함
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local") // 특정 프로필의 경우만 해당 스프링 빈을 등록한다, -->application.properties
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

/*	@Bean
	@Profile("test") //프로필이 "test" 인 경우에만 데이터소스를 스프링 빈으로 등록
	public DataSource dataSource() {
		log.info("메모리 데이터베이스 초기화");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");// [jdbc:h2:mem:db] 데이터소스를 만들때 이렇게만 적으면 임베디드 모드(메모리 모드)로 동작하는 H2 데이터베이스를 사용할 수 있다.
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}*/

}
//@Import(JdbcTemplateV2Config.class)
