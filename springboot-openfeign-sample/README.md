###
# Spring Cloud OpenFeign

서버간의 통신을 인터페이스 형식으로 지원하는 라이브러리.

명시된 규칙에 따라서 인터페이스를 설계하고 유지보수 및 작업하기 편리


``build.gradle``
```
ext{
	set('springCloudVersion', "2020.0.5")

	dependencyManagement{
		imports{
			mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
		}
  }
}

dependencies{
	....
	implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
   ....
}
```




``application.yml``
```aidl
#feign fallback 을 위한 설정
feign:
  hystrix:
    enabled: true
```





``Application 설정``
```aidl
@SpringBootApplication
@EnableFeignClients
public class ServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiApplication.class, args);
	}

}
```
- EnableFeignClients 라고 선언을 해주면, FeignClient 를 선언해준 인터페이스를 찾아 구현체를 만든다.



``Interface 설정``
```aidl
@FeignClient(name = "test-api",
        url = "${test.api.url}",
        fallbackFactory = ApiClientFallback.class)
public interface ApiClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/check",
            produces = "application/json")
    String checkPay(@RequestHeader("Route-check") String route,
                    @RequestParam(name = "checkPoint") String checkPoint);
}

```
- FeignClient
    - name : 해당 인터페이스 이름
    - url : 호출할 메인 url
    - fallbackFactory : fallback 발생시 처리할 클래스
- 인터페이스
    - RequestMapping 을 통해서 method, api 나머지 주소 등 정보 등록
    - 헤더 및 파라미터 정보들을 추가

``활용``
```aidl
public class ApiService {

    private final ApiClient apiClient;

    public PayService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String checkPayPoint(String point){

				......

        String result = apiClient.checkPay("api", point);

				.......
        
        return  result;
    }
}
```

- 사용할 서비스에서 의존성주입을 통해 편하게 사용 가능


``fallback``
```aidl
@Component
public ApiClientFallback implements FallbackFactory<ApiClient> {

    @Override
    public ApiClient create(Throwable cause) {

        return new ApiClient() {
            @Override
            public String checkPay(String route, String checkPoint) {
                log.error(cause.toString());
                return "Response Error";
            }
        };
    }
}
```
- 인터페이스에서 fallbackFactory에 선언을 해 줬기에 fallback 이벤트 발생시 동작