package top.dustone.kaixin.dao.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.dustone.kaixin.entity.view.MachineStatusView;

public interface MachineStatusViewDAO extends JpaRepository<MachineStatusView,Integer> {
    public MachineStatusView findFirstByMachineIdEquals(Integer id);
    public Page<MachineStatusView> findByWorkIdIsNotNull(Pageable pageable);
    public Page<MachineStatusView> findByMaintainIdIsNotNull(Pageable pageable);
    public Page<MachineStatusView> findByTransportIdIsNotNull(Pageable pageable);
}
