//package uz.uzcard.services.faculty.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name = "department-service")
//public interface StudentClient {
//
//	@GetMapping("/organization/{organizationId}")
//	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId);
//
//	@GetMapping("/organization/{organizationId}/with-employees")
//	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
//
//}
