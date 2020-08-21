package com.mastertech.access.access.repository;;

import com.mastertech.access.access.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Integer> {
    void removeAllByCustomerIdAndDoorId(Integer customerId, Integer doorId);

    void findAllByCustomerIdAndDoorId(Integer customerId, Integer doorId);
}
