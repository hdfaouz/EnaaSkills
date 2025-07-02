package com.enaa.enaaskills.Services;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Mappers.SousCompetenceMap;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Model.SousCompetence;
import com.enaa.enaaskills.Repositories.CompetenceRepository;
import com.enaa.enaaskills.Repositories.SousCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final SousCompetenceMap sousCompetenceMap;
    private final CompetenceRepository competenceRepository;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository, SousCompetenceMap sousCompetenceMap, CompetenceRepository competenceRepository) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.sousCompetenceMap = sousCompetenceMap;
        this.competenceRepository = competenceRepository;
    }

    public SousCompetenceDto Ajouter(SousCompetenceDto dto){
        SousCompetence sousCompetence = sousCompetenceMap.toEntity(dto);
        if (dto.getCompetenceId() != null){
            Competence competence = competenceRepository.findById(dto.getCompetenceId())
                    .orElseThrow(()-> new RuntimeException("Competence introuvable"));
            sousCompetence.setCompetence(competence);
        }
        return sousCompetenceMap.toDTO(sousCompetenceRepository.save(sousCompetence));
    }

    public List<SousCompetenceDto> getAll(){
        List<SousCompetence> sousCompetences= sousCompetenceRepository.findAll();
        return sousCompetenceMap.toDTOs(sousCompetences);
    }
}
