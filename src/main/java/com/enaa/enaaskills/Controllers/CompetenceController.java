package com.enaa.enaaskills.Controllers;

import com.enaa.enaaskills.Dto.CompetenceDto;
import com.enaa.enaaskills.Services.CompetenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competence")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }
@PostMapping
    public CompetenceDto ajouterCompetence(CompetenceDto competenceDto){
        return competenceService.ajouterCompetence(competenceDto);
    }
}
