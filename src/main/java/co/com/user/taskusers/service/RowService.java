package co.com.user.taskusers.service;

import co.com.user.taskusers.persistence.entity.Row;
import co.com.user.taskusers.service.DTO.RowInDTO;

import java.util.List;

public interface RowService {

    Row createRow(Row row);

    Row updateRow(RowInDTO row);

    Row deleteRow(Long id);

    List<Row> findAllRows();

}
