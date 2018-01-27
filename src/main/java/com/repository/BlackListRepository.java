package com.repository;

import com.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26.
 */
@Repository
public interface BlackListRepository extends JpaRepository<Blacklist,Integer> {

    List<Blacklist> findByTenantIdAndSchoolId(String tenantId, String schoolId);

    void deleteByTenantIdAndSchoolId(String tenantId,String schoolId);

}
