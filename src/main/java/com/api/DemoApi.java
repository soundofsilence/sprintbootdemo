package com.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2018/1/24.
 */
@FeignClient(url="http://localhost:")
public interface DemoApi {

}
