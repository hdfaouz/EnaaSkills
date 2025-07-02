package com.enaa.enaaskills.Mappers;

import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Model.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SousCompetenceMap {
    @Mapping(source = "competenceId", target = "competence.id")
    SousCompetence toEntity(SousCompetenceDto dto);
    @Mapping(target = "competenceId", source = "competence.id")
    SousCompetenceDto toDTO(SousCompetence sousCompetence);

    List<SousCompetenceDto> toDTOs(List<SousCompetence> sousCompetences);
}
