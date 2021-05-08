package org.example.TGbot.Service.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Users2Repository extends JpaRepository<Users2, Long>, JpaSpecificationExecutor<Users2> {


    public Users2 findByChatid(Long chatid);
}