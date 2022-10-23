package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Row;
import co.com.user.taskusers.persistence.repository.RowRepository;
import co.com.user.taskusers.service.DTO.RowInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RowServiceImpl implements RowService {

    private final RowRepository repository;

    @Override
    public Row createRow(Row row){
        return repository.save(row);
    }

    @Override
    @Transactional
    public Row updateRow(RowInDTO row){

        Optional<Row> resultSearch = repository.findById(row.getId());

        if(resultSearch.isEmpty()){
            return null;
        }

        repository.updateRow(row.getDuration(), row.getId());
        return resultSearch.orElse(null);
    }

    @Override
    public Row deleteRow(Long id){

        Optional<Row> row = repository.findById(id);

        if(row.isEmpty()){
            return null;
        }

        repository.deleteById(id);
        return row.orElse(null);
    }

    @Override
    public List<Row> findAllRows(){
        return repository.findAll();
    }

}
