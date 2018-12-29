package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.MachineDAO;
import top.dustone.kaixin.entity.Machine;
import top.dustone.kaixin.util.Page4Navigator;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineService {
    @Autowired
    MachineDAO machineDAO;

    public Page4Navigator<Machine> listByExample(Machine machine, int start, int size, int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("machineType.model", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("nameplate", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("payway", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Machine> example = Example.of(machine, exampleMatcher);
        Page pageJPA = machineDAO.findAll(example, pageable);
        return new Page4Navigator<Machine>(pageJPA, page);
    }
    public Page4Navigator<Machine> update(Machine machine){
        machineDAO.save(machine);
        Page4Navigator<Machine> result=new Page4Navigator<Machine>();
        List<Machine> content=new ArrayList<Machine>(1);
        content.add(machine);
        result.setContent(content);
        return result;
    }
}
