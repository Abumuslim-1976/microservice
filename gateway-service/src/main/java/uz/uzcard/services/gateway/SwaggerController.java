//package uz.uzcard.services.gateway;
//
//
//import io.fabric8.kubernetes.client.Config;
//import io.fabric8.kubernetes.client.ConfigBuilder;
//import io.fabric8.kubernetes.client.DefaultKubernetesClient;
//import io.fabric8.kubernetes.client.KubernetesClient;
//import io.fabric8.kubernetes.client.dsl.LogWatch;
//import org.springdoc.core.AbstractSwaggerUiConfigProperties;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.*;
//
//@RestController
//public class SwaggerController {
//
//    private final DiscoveryClient discoveryClient;
//
//    String master = "http://localhost:8060/";
//    Config config = new ConfigBuilder().withMasterUrl(master).build();
//
//    KubernetesClient client = new DefaultKubernetesClient(config);
//    LogWatch watch = client.pods().inNamespace("default").withName("args[0]").tailingLines(10).watchLog(System.out);
//
//    // Services to exclude. You can modify this list as per your environment
//    private static final List<String> KUBE_SERVICES = Arrays.asList("kubernetes", "kube-dns", "prometheus-kube-prometheus-kubelet");
////    new DefaultKubernetesClient("http://localhost:8060");
//
//    public SwaggerController(final DiscoveryClient discoveryClient) {
//        this.discoveryClient = discoveryClient;
//    }
//
//    @GetMapping("/v3/api-docs/swagger-config")
//    public Map<String, Object> swaggerConfig(ServerHttpRequest serverHttpRequest) throws URISyntaxException {
//        URI uri = serverHttpRequest.getURI();
//        String url = new URI(uri.getScheme(), uri.getAuthority(), null, null, null).toString();
//        Map<String, Object> swaggerConfig = new LinkedHashMap<>();
//        List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerUrls = new LinkedList<>();
//
//        discoveryClient.getServices().stream().filter(s -> !KUBE_SERVICES.contains(s)).forEach(serviceName ->
//                swaggerUrls.add(new AbstractSwaggerUiConfigProperties.SwaggerUrl(serviceName,
//                        url + "/" + serviceName + "/v3/api-docs")));
//        swaggerConfig.put("urls", swaggerUrls);
//        return swaggerConfig;
//    }
//
//}
