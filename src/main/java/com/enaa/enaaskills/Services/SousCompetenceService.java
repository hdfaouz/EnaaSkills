package com.enaa.enaaskills.Services;

import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Mappers.SousCompetenceMap;
import com.enaa.enaaskills.Model.SousCompetence;
import com.enaa.enaaskills.Repositories.SousCompetenceRepository;
import org.springframework.stereotype.Service;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final SousCompetenceMap sousCompetenceMap;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository, SousCompetenceMap sousCompetenceMap) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.sousCompetenceMap = sousCompetenceMap;
    }

    public SousCompetenceDto ajouterSousCompetence(SousCompetenceDto sousCompetenceDto){
        SousCompetence sousCompetence = sousCompetenceMap.toEntity(sousCompetenceDto);
        SousCompetence savedSousCompetence= sousCompetenceRepository.save(sousCompetence);
        return sousCompetenceMap.toDTO(savedSousCompetence);
    }
}
