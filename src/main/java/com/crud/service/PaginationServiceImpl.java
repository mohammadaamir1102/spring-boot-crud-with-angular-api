package com.crud.service;

import com.crud.common.dto.ErrorConstant;
import com.crud.common.dto.PaginationDTO;
import com.crud.common.dto.ServiceError;
import com.crud.common.dto.ServiceException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class PaginationServiceImpl implements PaginationService{
    @Override
    public Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException {
        if (Objects.isNull(paginationDTO.getOffset()) && (Objects.isNull(paginationDTO.getPageNumber()))){
            ServiceError serviceError = new ServiceError(ErrorConstant.OFFSET_AND_PAGE_NUMBER_REQUIRED,
                    ErrorConstant.SOMETHING_WENT_WRONG);
            throw new ServiceException(serviceError, HttpStatus.BAD_REQUEST);
        }
        return PageRequest.of(paginationDTO.getPageNumber(),paginationDTO.getOffset());
    }
}
