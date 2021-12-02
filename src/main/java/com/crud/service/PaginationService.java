package com.crud.service;

import com.crud.common.dto.PaginationDTO;
import com.crud.common.dto.ServiceException;
import org.springframework.data.domain.Pageable;

public interface PaginationService {
    Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException;
}
