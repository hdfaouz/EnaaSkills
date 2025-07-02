package com.enaa.enaaskills.Controllers;

import com.enaa.enaaskills.Dto.SousCompetenceDto;
import com.enaa.enaaskills.Services.SousCompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/souscompetence")
public class SousCompetenceController {

    private final SousCompetenceService sousCompetenceService;

    public SousCompetenceController(SousCompetenceService sousCompetenceService) {
        this.sousCompetenceService = sousCompetenceService;
    }

    @PostMapping
    public SousCompetenceDto ajouterSousCompetence( @RequestBody SousCompetenceDto sousCompetenceDto){
        return sousCompetenceService.Ajouter(sousCompetenceDto);
    }

    @GetMapping
    public List<SousCompetenceDto> getAll(){
        return sousCompetenceService.getAll();
    }

    @PutMapping("/{id}")
    public SousCompetenceDto update(@PathVariable Long id, @RequestBody SousCompetenceDto sousCompetenceDto){
        return sousCompetenceService.update(id,sousCompetenceDto);
    }

}
