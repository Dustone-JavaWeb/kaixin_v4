package top.dustone.kaixin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.MachineStatus;

public interface MachineStatusDAO extends JpaRepository<MachineStatus,Integer> {
    public MachineStatus findFirstByMachineIdEquals(Integer id);
    public Page<MachineStatus> findByWorkIdIsNotNull(Pageable pageable);
    public Page<MachineStatus> findByMaintainIdIsNotNull(Pageable pageable);
    public Page<MachineStatus> findByTransportIdIsNotNull(Pageable pageable);
}
