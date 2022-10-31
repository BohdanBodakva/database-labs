package ua.lviv.iot.databases.lab5.dto.assemblers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import ua.lviv.iot.databases.lab5.dto.WorkPositionDto;
import ua.lviv.iot.databases.lab5.entities.WorkPositionEntity;

@Component
public class WorkPositionAssembler implements RepresentationModelAssembler<WorkPositionEntity, WorkPositionDto> {

    @Override
    public WorkPositionDto toModel(WorkPositionEntity entity) {
        WorkPositionDto workPositionDto = WorkPositionDto.builder()
                .name(entity.getName())
                .build();

//        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WorkPositionController.class)
//                .ge)

        return null;
    }
}
