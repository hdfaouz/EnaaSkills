package com.enaa.enaaskills.Mappers;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Model.SousCompetence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SousCompetenceMap {

    SousCompetence toEntity(SousCompetenceDto dto);

    SousCompetenceDto toDTO(SousCompetence sousCompetence);

    List<SousCompetenceDto> toDTOs(List<SousCompetence> sousCompetences);
}
