package com.enaa.enaaskills.Mappers;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Model.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CompetenceMap {
    Competence toEntity(CompetenceDto dto);

    @Mapping(target = "statutAcquise", expression = "java(competence.SimpleIsAcquired())")
    CompetenceDto toDTO(Competence competence);

    List<CompetenceDto> toDTOs(List<Competence> competences);
}
