package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.PriorityDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Priority;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PriorityMapper {
    PriorityDTO priorityToPriorityDTO(Priority priority);
    Priority priorityDTOToPriority(PriorityDTO priorityDTO);
}
