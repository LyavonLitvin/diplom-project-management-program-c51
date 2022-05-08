package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.StatusDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Status;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDTO statusToStatusDTO(Status status);
    Status statusDTOToStatus(StatusDTO statusDTO);
}
