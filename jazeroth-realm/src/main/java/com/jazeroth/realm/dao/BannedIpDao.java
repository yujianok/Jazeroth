package com.jazeroth.realm.dao;

import com.jazeroth.realm.entity.BannedIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BannedIpDao extends JpaRepository<BannedIp, Long> {

    @Query("SELECT COUNT(bi) FROM BannedIp bi WHERE bi.unbanDate > NOW() AND bi.ip = :ip")
    long countBannedIp(@Param("ip") String ip);

}
