package com.enaa.enaaskills.Services;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Mappers.CompetenceMap;
import com.enaa.enaaskills.Model.Competence;
import com.enaa.enaaskills.Repositories.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public List<CompetenceDto> getAllCompetences(){
//        List<Competence> competences = competenceRepository.findAll();
//        return competenceMap.toDTOs(competences);
//    }
    public List<Competence> ListCompetence() {
       return competenceRepository.findAll();
}



    public CompetenceDto update(Long id, CompetenceDto competenceDto){
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("competence not found"));

        competence.setNom(competenceDto.getNom());
        competence.setStatutAcquise(competenceDto.isStatutAcquise());

        Competence savedCompetence = competenceRepository.save(competence);

        return competenceMap.toDTO(savedCompetence);
    }

    public void supprimerCompetence(Long id){
        competenceRepository.deleteById(id);
    }
}
