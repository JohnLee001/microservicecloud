package atguigu.springcloud;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient
public interface FeiClientService {

    @PostMapping
    public boolean addDept(Dept dept);

    @GetMapping("/{deptno}")
    public Dept findDept(@PathVariable String deptno);

    @GetMapping("list")
    public List<Dept> deptList();
}
