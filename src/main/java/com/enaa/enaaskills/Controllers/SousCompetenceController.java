package com.enaa.enaaskills.Controllers;

import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Services.SousCompetenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/souscompetence")
public class SousCompetenceController {

    private final SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping
    public SousCompetenceDto ajouterSousCompetence( @RequestBody SousCompetenceDto sousCompetenceDto){
        return sousCompetenceService.ajouterSousCompetence(sousCompetenceDto);
    }
}
