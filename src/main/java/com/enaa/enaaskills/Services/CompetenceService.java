package com.enaa.enaaskills.Services;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Mappers.CompetenceMap;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Repositories.CompetenceRepository;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {
    private final CompetenceMap competenceMap;
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceMap competenceMap, CompetenceRepository competenceRepository) {
        this.competenceMap = competenceMap;
        this.competenceRepository = competenceRepository;
    }
    public CompetenceDto ajouterCompetence(CompetenceDto competenceDto){
        Competence competence = competenceMap.toEntity(competenceDto);
        Competence saveCompetence = competenceRepository.save(competence);
        return competenceMap.toDTO(saveCompetence);

    }
}
